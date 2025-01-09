import PackageArmadietto.ArmadiettoFacade;
import PackageArmadietto.ArmadiettoGetDataInterface;
import PackageResponsabile.NuovoOrdineControl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class ResponsabileControlTest {

    private final NuovoOrdineControl control = new NuovoOrdineControl(null, null);
    private final ArmadiettoGetDataInterface i = new ArmadiettoFacade();

    @ParameterizedTest
    @CsvSource({
            "-1 , false" ,
            "-100 , false" ,
            "-1000 , false" ,
            "-20 , false" ,
            "-200 , false"
    })
    public void TC1_1_a_purezzaNegativa(double purezza , boolean expected) {

        assertEquals(expected, control.isValidPurezza(purezza));

    }

    @ParameterizedTest
    @CsvSource({
            "101 , false" ,
            "102 , false" ,
            "1000 , false" ,
            "120000 , false" ,
            "200000 , false"
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
            "4 , false" ,
            "5 , false" ,
            "-1 , false" ,
            "-2 , false" ,
            "30 , false"
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
            "-1 , false" ,
            " -2 , false" ,
            " -100 , false" ,
            " -1000 , false" ,
            " -10000000000 , false"
    })
    public void TC1_3_a_quantitaNegativa(double quantita , boolean expected) {

        assertEquals(expected, control.isValidQuantita(quantita));

    }

    @ParameterizedTest
    @CsvSource({
            "100001 , false" ,
            " 2000002, false" ,
            " 2000001 , false" ,
            " 101010 , false"
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
            "'Etanolo' , 78 , 5000 , 2 , true" ,
            "'Etanolo', 100, 100000, 1, true",
            "'Acido cloridrico', 1, 1, 3, true",
            "'Acqua ossigenata', 50, 500, 2, true",
            "'Etanolo', 99.99, 99999, 1, true",
            "'Acido cloridrico', 25, 1000, 3, true"

    })
    public void TC1_5_InputCorretto(String sostanza, double purezza, double quantita, Integer priorita, boolean expected) {
        assertEquals(expected, control.isValidOrdineInfos(sostanza, purezza, quantita, priorita));
    }



}


