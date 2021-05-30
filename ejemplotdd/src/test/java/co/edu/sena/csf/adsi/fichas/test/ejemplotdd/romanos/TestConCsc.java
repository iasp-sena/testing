/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 *
 * @author Ismael
 */
@RunWith(JUnitPlatform.class)
public class TestConCsc {
    
    @ParameterizedTest
    //@ValueSource(ints = {1,3,4,5,6,7,8,9})
    //@ValueSource(strings = {"V","I"})
    //@NullSource
    //@NullAndEmptySource
    //@EnumSource(Mes.class)
    @CsvSource({"hola,mundo", "mamá,papá", "hermano,hermana"})
    void testValoresCsv0(String valor1, String valor2){
        System.out.println(valor1);
        System.out.println(valor2);
    }
    
    @ParameterizedTest
    @CsvSource({"hola,mundo", "mamá,papá", "hermano,hermana"})
    void testValoresCsv1(String valor1, String valor2){
        System.out.println(valor1);
        System.out.println(valor2);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"hola;mundo", "mamá;papá", "hermano;hermana"}, delimiter = ';')
    void testValoresCsv2(String valor1, String valor2){
        System.out.println(valor1);
        System.out.println(valor2);
    }
    
    
    @ParameterizedTest
    @CsvFileSource(resources = "/datosCsvTest.csv")
    void testValoresCsv3(String valor1, String valor2){
        System.out.println(valor1);
        System.out.println(valor2);
    }
    
}
