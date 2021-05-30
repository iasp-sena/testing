/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos;

import co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos.data.ArgumentRomanoTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
/**
 *
 * @author Ismael
 */
@RunWith(JUnitPlatform.class)
public class RomanoTest {
    
    private Romano romano;
    
    @BeforeEach
    void initTest(){
        this.romano = new Romano();
    }  
    
    @ParameterizedTest
    @ArgumentsSource(ArgumentRomanoTest.class)
    void testConvertirARomano(int numero, String numeroRomanoEsperado){
        //Given
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals(numeroRomanoEsperado, numeroRomano);
    }
}
