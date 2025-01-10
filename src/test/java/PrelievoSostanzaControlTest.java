
import PackagePrelievoSostanza.PrelievoSostanzaControl;
import PackagePrelievoSostanza.Ricercatore;
import PackagePrelievoSostanza.RicercatoreDAO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PrelievoSostanzaControlTest {

    private static PrelievoSostanzaControl control ;

    @BeforeAll
    static void init(){

        RicercatoreDAO ricercatoreDAO = new RicercatoreDAO();
        Ricercatore ricercatore = ricercatoreDAO.getRicercatore(1);
        control = new PrelievoSostanzaControl(null , ricercatore);

    }

    @Test
    public void TC2_1_teamNullo(){

        assertFalse(control.TeamProgettoIsValid(null , null));

    }

    @Test
    public void TC2_2_progettoNullo(){

        assertFalse(control.TeamProgettoIsValid("Team_A" , null));

    }

    @ParameterizedTest
    @CsvSource({
            "'team_A' , 'progetto_1' , true" ,
            "'team_B' , 'progetto_3' , true"
    })

    public void TC2_3_teamEProgettoValido(String team , String progetto , boolean expected){

        assertEquals(expected, control.TeamProgettoIsValid(team , progetto));

    }

}
