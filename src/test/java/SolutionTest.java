import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SolutionTest {

    @Test
    public void noChangeTest(){
        String csv =
                "LastName,FirstName,Age,Job\n" +
                        "Mazzucchelli,Enrico,30,Developer\n" +
                        "Devil,Andrea,52,Bella domanda\n" ;
        Solution solution = new Solution();
        String res = solution.customPrint(csv, new String[]{"LastName","FirstName","Age","Job"});
        assertNotNull(res, "Result is null");
        assertEquals(csv, res );
    }

    @Test
    public void firstTest(){
        String test =
                "LastName,FirstName,Age,Job\n" +
                        "Mazzucchelli,Enrico,30,Developer\n" +
                        "Devil,Andrea,52,Bella domanda\n" ;
        Solution solution = new Solution();
        String res = solution.customPrint(test, new String[]{"FirstName","Age"});
        assertNotNull(res, "Result is null");
        assertEquals("FirstName,Age\n" +
                "Enrico,30\n" +
                "Andrea,52\n", res );
    }

    @Test
    public void singleColumnTest(){
        String test =
                "LastName,FirstName,Age,Job\n" +
                        "Mazzucchelli,Enrico,30,Developer\n" +
                        "Devil,Andrea,52,Bella domanda\n" ;
        Solution solution = new Solution();
        String res = solution.customPrint(test, new String[]{"FirstName"});
        assertNotNull(res, "Result is null");
        assertEquals("FirstName\n" +
                "Enrico\n" +
                "Andrea\n", res);
    }

    @Test
    public void illegalArguments(){
        String test =
                "LastName,FirstName,Age,Job\n" +
                        "Mazzucchelli,Enrico,30,Developer\n" +
                        "Devil,Andrea,52,Bella domanda\n" ;
        Solution solution = new Solution();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            solution.customPrint(test, new String[]{});
        });
    }

    @Test
    public void illegalArgumentsColumns(){
        String test =
                "LastName,FirstName,Age,Job\n" +
                        "Mazzucchelli,Enrico,30,Developer\n" +
                        "Devil,Andrea,52,Bella domanda\n" ;
        Solution solution = new Solution();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            try {
                solution.customPrint(test, new String[]{"invalid_name","Age"});
            }catch (IllegalArgumentException ex){
                assertEquals("Missing columns: 1", ex.getMessage());
                throw ex;
            }
        });
    }

}
