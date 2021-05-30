package co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
/**
 *
 * @author Ismael
 */
@RunWith(JUnitPlatform.class)
public class RomanoTest_Old2 {
    
    private Romano romano;
    
    @BeforeEach
    void initTest(){
        this.romano = new Romano();
    }  
    
    @ParameterizedTest
    @MethodSource("co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos.data.RomanoTestData#getDataTestRomano")
    void testConvertirARomano(int numero, String numeroRomanoEsperado){
        //Given
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals(numeroRomanoEsperado, numeroRomano);
    }
    
    /*
    @Test
    void testRomanoNumeroNoValido(){
        //Given
        int numero = 0;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("", numeroRomano);
    }
    
    @Test
    void testRomanoUno(){
        //Given
        int numero = 1;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("I", numeroRomano);
    }
    
    @Test
    void testRomanoDos(){
        //Given
        int numero = 2;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("II", numeroRomano);
    }
    
    @Test
    void testRomanoTres(){
        //Given
        int numero = 3;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("III", numeroRomano);
    }
    
    @Test
    void testRomanoCuatro(){
        //Given
        int numero = 4;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("IV", numeroRomano);
    }
    
    @Test
    void testRomanoCinco(){
        //Given
        int numero = 5;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("V", numeroRomano);
    }
    
    @Test
    void testRomanoSeis(){
        //Given
        int numero = 6;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("VI", numeroRomano);
    }
    
    @Test
    void testRomanoSeite(){
        //Given
        int numero = 7;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("VII", numeroRomano);
    }
    
    @Test
    void testRomanoOcho(){
        //Given
        int numero = 8;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("VIII", numeroRomano);
    }
    
    @Test
    void testRomanoNueve(){
        //Given
        int numero = 9;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("IX", numeroRomano);
    }
    
    @Test
    void testRomanoDiez(){
        //Given
        int numero = 10;
        //When
        String numeroRomano = romano.convertir(numero);
        //Then
        assertNotNull(numeroRomano);
        assertEquals("X", numeroRomano);
    }
*/
}
