/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.ejemplotdd.romanos.data;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

/**
 *
 * @author Ismael
 */
public class ArgumentRomanoTest implements ArgumentsProvider{
    
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext ec) throws Exception {
        return Stream.of(
                Arguments.of(0,""),
                Arguments.of(1,"I"),
                Arguments.of(2,"II"),
                Arguments.of(3,"III"),
                Arguments.of(4,"IV"),
                Arguments.of(5,"V"),
                Arguments.of(6,"VI"),
                Arguments.of(7,"VII"),
                Arguments.of(8,"VIII"),
                Arguments.of(9,"IX"),
                Arguments.of(10,"X")
        );
    }
    
}
