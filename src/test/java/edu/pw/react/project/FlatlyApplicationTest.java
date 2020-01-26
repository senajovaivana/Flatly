package edu.pw.react.project;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles(profiles = {"dev", "it", "prod"})
@RunWith(SpringRunner.class)
@SpringBootTest
class FlatlyApplicationTest {

    @Test
    void main() {
    }
}