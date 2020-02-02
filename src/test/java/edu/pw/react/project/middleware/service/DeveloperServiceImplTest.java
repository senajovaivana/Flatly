package edu.pw.react.project.middleware.service;

import edu.pw.react.project.backend.dao.DeveloperRepository;
import edu.pw.react.project.backend.model.DeveloperEntity;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
@Deprecated
public class DeveloperServiceImplTest {

    @Mock
    private DeveloperRepository repository;
    @Spy
    @InjectMocks
    private DeveloperServiceImpl developerService;


    @Test
    public void updateDeveloper() {
        DeveloperEntity updatedDeveloper = new DeveloperEntity();
        when(repository.existsById(anyLong())).thenReturn(true);
        when(repository.save(any(DeveloperEntity.class))).thenReturn(updatedDeveloper);

        DeveloperEntity actual = developerService.updateDeveloper(1L, updatedDeveloper);

        assertThat(actual).isEqualTo(updatedDeveloper);
        verify(repository, times(1)).existsById(eq(1L));
        verify(repository, times(1)).save(eq(updatedDeveloper));
    }



    @Test
    //@DisplayName("When trying to update non existing developer Return DeveloperEntityEMPTY")
    public void givenNotExistingId_whenUpdateDeveloper_thenReturnDeveloperEMPTY() {
        when(repository.existsById(anyLong())).thenReturn(false);
        DeveloperEntity actual = developerService.updateDeveloper(-999999L, new DeveloperEntity());
        DeveloperEntity expected = DeveloperEntity.EMPTY;

        assertThat(actual).isEqualTo(expected);
        verify(repository, times(1)).existsById(eq(-999999L));
        verify(repository, times(0)).save(any(DeveloperEntity.class));
    }

    //@DisplayName("When trying to update existing developer Return updated DeveloperEntity")
    @Test
    public void givenExistingId_whenUpdateDeveloper_thenReturnUpdatedDeveloper() {
        DeveloperEntity updatedDeveloper = new DeveloperEntity();
        when(repository.existsById(anyLong())).thenReturn(true);
        when(repository.save(any(DeveloperEntity.class))).thenReturn(updatedDeveloper);

        DeveloperEntity actual = developerService.updateDeveloper(1L, updatedDeveloper);

        assertThat(actual).isEqualTo(updatedDeveloper);
        verify(repository, times(1)).existsById(eq(1L));
        verify(repository, times(1)).save(eq(updatedDeveloper));
    }

}