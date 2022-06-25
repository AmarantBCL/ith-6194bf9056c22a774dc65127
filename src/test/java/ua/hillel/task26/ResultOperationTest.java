package ua.hillel.task26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ResultOperationTest {
    @Test
    void shouldReturnNothing_whenNothingSpecified() {
        Assertions.assertEquals("", ResultOperation.calculate(""));
    }

    @ParameterizedTest
    @MethodSource("provideOneOperandStringsExpressions")
    void shouldReturnOperand_whenOneOperandSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideOneOperandStringsExpressions() {
        return Stream.of(
                Arguments.of("0", "0"),
                Arguments.of("1", "1"),
                Arguments.of("233", "233"),
                Arguments.of("-3", "-3"),
                Arguments.of("-1000", "-1000"),
                Arguments.of("-2,42", "-2,42"),
                Arguments.of("3,03", "3,03"),
                Arguments.of("128,14", "128,14")
        );
    }

    @ParameterizedTest
    @MethodSource("provideOneOperandAndOperationStringsExpressions")
    void shouldReturnOperand_whenOneOperandAndOperationSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideOneOperandAndOperationStringsExpressions() {
        return Stream.of(
                Arguments.of("2 + ", "2"),
                Arguments.of("2 +", "2"),
                Arguments.of("31 - ", "31"),
                Arguments.of("31 -", "31"),
                Arguments.of("16 * ", "16"),
                Arguments.of("16 *", "16"),
                Arguments.of("48 / ", "48"),
                Arguments.of("48 /", "48")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTwoSumOperandsStringsExpressions")
    void shouldReturnSumResult_whenTwoOperandsSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideTwoSumOperandsStringsExpressions() {
        return Stream.of(
                Arguments.of("2 + 2", "4"),
                Arguments.of("11 + 64", "75"),
                Arguments.of("233 + 1000", "1233"),
                Arguments.of("4 + -3", "1"),
                Arguments.of("-8 + 13", "5"),
                Arguments.of("-24 + -4", "-28"),
                Arguments.of("-3,14 + 4,14", "1"),
                Arguments.of("23,15 + -8,12", "15,03"),
                Arguments.of("-564,028 + -100,45", "-664,478")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTwoSubtractionOperandsStringsExpressions")
    void shouldReturnSubtractionResult_whenTwoOperandsSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideTwoSubtractionOperandsStringsExpressions() {
        return Stream.of(
                Arguments.of("5 - 2", "3"),
                Arguments.of("41 - 18", "23"),
                Arguments.of("854 - 501", "353"),
                Arguments.of("3 - 5", "-2"),
                Arguments.of("15 - 46", "-31"),
                Arguments.of("401 - 985", "-584"),
                Arguments.of("25 - -3", "28"),
                Arguments.of("-18 - 13", "-31"),
                Arguments.of("-48 - -10", "-38"),
                Arguments.of("-1,1 - 2,25", "-3,35"),
                Arguments.of("14,954 - -6,68", "21,634"),
                Arguments.of("-428,758 - -258,447", "-170,311")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTwoMultiplicationOperandsStringsExpressions")
    void shouldReturnMultiplicationResult_whenTwoOperandsSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideTwoMultiplicationOperandsStringsExpressions() {
        return Stream.of(
                Arguments.of("2 * 2", "4"),
                Arguments.of("16 * 10", "160"),
                Arguments.of("233 * 455", "106015"),
                Arguments.of("5 * -4", "-20"),
                Arguments.of("-1 * 40", "-40"),
                Arguments.of("-39 * -8", "312"),
                Arguments.of("-5,42 * 7,128", "-38,63376"),
                Arguments.of("18,486 * -2,47", "-45,66042"),
                Arguments.of("-322,75 * -654,014", "211083,0185")
        );
    }

    @ParameterizedTest
    @MethodSource("provideTwoDivisionOperandsStringsExpressions")
    void shouldReturnDivisionResult_whenTwoOperandsSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideTwoDivisionOperandsStringsExpressions() {
        return Stream.of(
                Arguments.of("3 / 0", "∞"),
                Arguments.of("8 / 4", "2"),
                Arguments.of("16 / 3", "5,3333333333"),
                Arguments.of("500 / 100", "5"),
                Arguments.of("7 / -3", "-2,3333333333"),
                Arguments.of("-8 / 16", "-0,5"),
                Arguments.of("-84 / -3", "28"),
                Arguments.of("-2,15 / 9,011", "-0,23859727"),
                Arguments.of("68,145 / -5,4", "-12,6194444444"),
                Arguments.of("-129,16 / -345,225", "0,3741328119")
        );
    }

    @ParameterizedTest
    @MethodSource("provideThreeOperandsStringsExpressions")
    void shouldReturnResult_whenThreeOperandsSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideThreeOperandsStringsExpressions() {
        return Stream.of(
                Arguments.of("2 + 3 + 8", "13"),
                Arguments.of("12 + 48 + 23", "83"),
                Arguments.of("15,1 + -84 + 24", "-44,9"),
                Arguments.of("9 - 2 - 4", "3"),
                Arguments.of("18 - 32 - 10", "-24"),
                Arguments.of("85,432 - 2,21 - -16,3", "99,522"),
                Arguments.of("3 * 5 * 2", "30"),
                Arguments.of("43 * 32 * 12", "16512"),
                Arguments.of("-5,02 * 0,44 * -1", "2,2088"),
                Arguments.of("8 / 4 / 2", "1"),
                Arguments.of("53 / 16 / 19", "0,1743421053"),
                Arguments.of("-8 / -5,322 / 2,25", "0,6680863502")
        );
    }

    @ParameterizedTest
    @MethodSource("provideMoreThanThreeOperandsStringsExpressions")
    void shouldReturnResult_whenMoreThanThreeOperandsSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideMoreThanThreeOperandsStringsExpressions() {
        return Stream.of(
                Arguments.of("1 + 8 + 4 + 6", "19"),
                Arguments.of("13 + 2 - 10 * 2 / 5", "2"),
                Arguments.of("41 + -12 - 4,43 * 2,5 / 10", "6,1425"),
                Arguments.of("14 - 128 - 23 - 23 - 12 - 100", "-272"),
                Arguments.of("2 * 100 * 18 / 25 / 0,5 + 400 + 48 - -24,2 + 6", "766,2"),
                Arguments.of("10 / 8 / 3 + 14 * 28 - -400 * 25 - 36,6 / 5", "4011,0133333333")
        );
    }

    @ParameterizedTest
    @MethodSource("provideSpecificCasesExpressions")
    void shouldReturnOperand_whenSpecificCasesSpecified(String input, String expected) {
        Assertions.assertEquals(expected, ResultOperation.calculate(input));
    }

    private static Stream<Arguments> provideSpecificCasesExpressions() {
        return Stream.of(
                Arguments.of("2 + 2 + ", "4"),
                Arguments.of("-3 - 8 / ", "-11"),
                Arguments.of("4 * -16 + ", "-64"),
                Arguments.of("-12 / -14 - ", "0,8571428571"),
                Arguments.of("8 + 28,32 - ", "36,32"),
                Arguments.of("45,1 - 13 / ", "32,1"),
                Arguments.of("32,14 * 12,922 - ", "415,31308"),
                Arguments.of("-14 / 56,3331 * ", "-0,2485217394"),
                Arguments.of("2,5 + -6 / ", "-3,5"),
                Arguments.of("-23,14 - -12,6 + ", "-10,54"),
                Arguments.of("1 + 8 + 4 + 6 + ", "19"),
                Arguments.of("-21,1 * 8 + 45,3 - 6 / ", "-129,5"),
                Arguments.of("5 / 10,2 * 18 + 45 - 24 * 0 + 400 -", "400")
        );
    }
}
