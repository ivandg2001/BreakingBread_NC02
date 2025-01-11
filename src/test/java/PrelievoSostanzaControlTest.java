
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

    @ParameterizedTest
    @CsvSource({
            "'-1' , false" ,
            "'-2' , false" ,
            "'-20' , false"
    })
    public void TC2_4a_quantitaNegativa(String quantita , boolean expected){

        assertEquals(expected, control.quantitaIsValid(quantita));

    }

    @ParameterizedTest
    @CsvSource({
            "'99999' , false" ,
            "'100000' , false" ,
            "'100000000' , false"
    })
    public void TC2_4b_quantitaTroppoAlta(String quantita , boolean expected){

        assertEquals(expected, control.quantitaIsValid(quantita));

    }

    @Test
    public void TC2_4c_quantitaugualeA0(){

        assertFalse(control.quantitaIsValid("0"));

    }

    @Test
    public void TC2_4d_quantitaNulla(){

        assertFalse(control.quantitaIsValid(null));

    }

    @ParameterizedTest
    @CsvSource({
            "'1' , true"
    })
    public void TC2_5_quantitaValida(String quantita , boolean expected){

        assertEquals(expected, control.quantitaIsValid(quantita));

    }

}
