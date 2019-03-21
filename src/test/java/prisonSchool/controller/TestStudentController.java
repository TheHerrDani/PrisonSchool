package prisonSchool.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import prisonSchool.domains.StudentDomain;
import prisonSchool.interfaces.StudentServiceInterface;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestStudentController {

    @InjectMocks
    private StudentController studentController;   //tényleges példánya a StudentControllerosztálynak. itt ezt az osztályt teszteljük

    @Mock
    private StudentServiceInterface studentService;  //dummy osztály ->obj

    @Test
    public void getStudentById(){
        StudentDomain sd = new StudentDomain();
        sd.setName("Pista");
        //Given
        when(studentService.getStudentById(anyInt())).thenReturn(sd);
        //When
        StudentDomain result = studentController.getStudentById(-236);
        //Then
        assertEquals("Pista", result.getName());
    }


}
