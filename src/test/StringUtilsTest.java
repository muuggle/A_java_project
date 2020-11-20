import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @ParameterizedTest
//    @MethodSource
    @CsvSource({ "abc, Abc", "APPLE, Apple", "gooD, Good" })
    void testCapitalize(String input,String result){
        assertEquals(result,StringUtils.capitalize(input));
    }
//    static List<Arguments> testCapitalize(){
//        return List.of( // arguments:
//                Arguments.arguments("abc", "Abc"), //
//                Arguments.arguments("APPLE", "Apple"), //
//                Arguments.arguments("gooD", "Good"));
//    }
}