import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageNuovoOrdine.NuovoOrdineControl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class NuovoOrdineControlTest {

    private final NuovoOrdineControl control = new NuovoOrdineControl(null, null);
    private final ArmadiettoGetDataInterface i = new ArmadiettoFacade();

    @ParameterizedTest
    @CsvSource({
            "-1 , false"
    })
    public void TC1_1_a_purezzaNegativa(double purezza , boolean expected) {

        assertEquals(expected, control.isValidPurezza(purezza));

    }

    @ParameterizedTest
    @CsvSource({
            "101 , false"
    })
    public void TC1_1_b_purezzaSuperioreAl100(double purezza , boolean expected) {

        assertEquals(expected, control.isValidPurezza(purezza));

    }

    @Test
    public void TC1_1_c_purezzaUgualeA0(){
        assertFalse(control.isValidPurezza(0));
    }

    @Test
    public void TC1_1_d_purezzaNulla() {

        assertFalse(control.isValidPurezza(null));

    }

    @Test
    public void TC1_1_e_purezzaNonNumerica() {
        assertFalse(control.isValidPurezza("abc"));
    }

    @Test
    public void TC1_2_a_prioritaNulla() {

        assertFalse(control.isValidPriorita(null));

    }

    @ParameterizedTest
    @CsvSource({
            "4 , false"
    })
    public void TC1_2_b_prioritaNonAccettabile(Integer priorita , boolean expected) {

        assertEquals(expected, control.isValidPriorita(priorita));

    }

    @Test
    public void TC1_2_c_prioritaNonNumerica() {
        assertFalse(control.isValidPriorita("a"));
    }

    @ParameterizedTest
    @CsvSource({
            "-1 , false"
    })
    public void TC1_3_a_quantitaNegativa(double quantita , boolean expected) {

        assertEquals(expected, control.isValidQuantita(quantita));

    }

    @ParameterizedTest
    @CsvSource({
            "100001 , false"
    })
    public void TC1_3_b_quantitaMassimaSuperata(double quantita , boolean expected) {

        assertEquals(expected, control.isValidPurezza(quantita));

    }

    @Test
    public void TC1_3_c_quantitaUgualeA0() {
        assertFalse(control.isValidQuantita(0));
    }
    @Test
    public void TC1_3_d_quantitaNulla() {


        assertFalse(control.isValidQuantita(null));

    }

    @Test
    public void TC1_3_e_quantitaNonNumerica() {

        assertFalse(control.isValidQuantita("quantita"));
    }

    @Test
    public void TC1_4_a_sostanzaNulla(){
        assertFalse(control.isValidSostanza(null , i));
    }

    @Test
    public void TC1_4_b_sostanzaNonEsistente(){
        assertFalse(control.isValidSostanza("sostanzainesistente" , i));
    }

    @ParameterizedTest
    @CsvSource({
            "'Etanolo' , 78 , 5000 , 2 , true"

    })
    public void TC1_5_InputCorretto(String sostanza, double purezza, double quantita, Integer priorita, boolean expected) {
        assertEquals(expected, control.isValidOrdineInfos(sostanza, purezza, quantita, priorita));
    }



}


