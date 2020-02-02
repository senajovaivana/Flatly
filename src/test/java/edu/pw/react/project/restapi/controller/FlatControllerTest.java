package edu.pw.react.project.restapi.controller;

import edu.pw.react.project.FlatlyApplication;
import edu.pw.react.project.backend.dao.FlatRepository;
import edu.pw.react.project.backend.model.FlatEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.*;
import java.util.Optional;

import static edu.pw.react.project.utils.TestConstants.PATH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlatlyApplication.class)
@ActiveProfiles(profiles = {"dev"})//FIXME zmienic na IT
public class FlatControllerTest {

    private static final String FLAT_PATH = "flats/";

    private MockMvc mockMvc;

    @Autowired
    private FlatRepository repository;
    @Autowired
    private FlatController flatController;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.flatController).build();
    }

    @Test
    public void whenNoSecurityHeader_thenStatusCode403() throws Exception {
        MockHttpServletRequestBuilder getCompany = get("/flats/1");
        mockMvc.perform(getCompany).andExpect(status().isUnauthorized());
    }

    @Test
    public void whenSystemStartsUpAndLoadData_thenCanAccessTheseData() {
        assertThat(repository.findAll()).hasSize(3);
        assertThat(repository.findById(1L).orElseThrow(IllegalAccessError::new).getName_of_room()).isEqualTo("Bed and Breakfast");
    }

    public String loadJsonFromFileAsString(String path, String filename) {
        try {
            InputStream is = new FileInputStream(path + filename);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }

            String fileAsString = sb.toString();
            return fileAsString;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String loadJsonFromFileAsObject(String path, String filename) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(path + filename))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }

    @Test
    public void whenPostNewRoom_thenThatRoomIsInsertedIntoDatabase() throws Exception {
        String content = loadJsonFromFileAsString(PATH + FLAT_PATH, "FlatControllerTest_001.JSON");
        MockHttpServletRequestBuilder post = post("/flats")
                .contentType(MediaType.APPLICATION_JSON)
                //.header("security-header", "secureMe")
                .content(content);
        mockMvc.perform(post)
                .andExpect(status().isOk())
                .andExpect(content().string("4"));

        //String content = loadJsonFromFile("", "is_it_friday_yet.feature");

        //POST

        ResultActions asd = mockMvc.perform(post);
//                .andExpect(status().isOk())
//                .andExpect(content().string("4"));

        Optional<FlatEntity> actualCompany = repository.findById(4L);
        assertThat(actualCompany.isPresent()).isTrue();
        assertThat(actualCompany.get().getName_of_room()).isEqualTo("Room_for_test");

        content = "{  \n" +
                "   \"name\" : \"devCompChanged\",\n" +
                "   \"id\" : 4,\n" +
                "   \"startDateTime\" : \"2019-10-05T21:34:21\"\n" +
                "}";
        //PUT
        MockHttpServletRequestBuilder putCompany = put("/companies/4").contentType(MediaType.APPLICATION_JSON)
                .header("security-header", "secureMe")
                .content(content);
        mockMvc.perform(putCompany)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("devCompChanged")));


        actualCompany = repository.findById(4L);
        assertThat(actualCompany.isPresent()).isTrue();
        assertThat(actualCompany.get().getName_of_room()).isEqualTo("devCompChanged");

        //GET
        MockHttpServletRequestBuilder getCompany = get("/companies/4").header("security-header", "secureMe");
        mockMvc.perform(getCompany)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("devCompChanged")));

        //DELETE
        MockHttpServletRequestBuilder deleteCompany = delete("/companies/4").header("security-header", "secureMe");
        mockMvc.perform(deleteCompany)
                .andExpect(status().isOk())
                .andExpect(content().string("Company with id 4 deleted."));

        actualCompany = repository.findById(4L);
        assertThat(actualCompany.isPresent()).isFalse();
    }
}
