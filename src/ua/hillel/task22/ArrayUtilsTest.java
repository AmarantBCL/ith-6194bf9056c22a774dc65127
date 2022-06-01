package ua.hillel.task22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayUtilsTest {
    @ParameterizedTest
    @MethodSource("provideArraysWhenFourIsPresent")
    void shouldReturnArray_whenFourIsPresent(int[] given, int[] expected) {
        Assertions.assertArrayEquals(ArrayUtils.lastFourArray(given), expected);
    }

    private static Stream<Arguments> provideArraysWhenFourIsPresent() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                Arguments.of(new int[]{1, 2, 2, 3, 4, 1, 7}, new int[]{1, 7}),
                Arguments.of(new int[]{1, 2, 4, 2, 3, 1, 7}, new int[]{2, 3, 1, 7}),
                Arguments.of(new int[]{1, 4, 1, 7}, new int[]{1, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysWhenFourIsPresentFirst")
    void shouldReturnArray_whenFourIsPresentFirst(int[] given, int[] expected) {
        Assertions.assertArrayEquals(ArrayUtils.lastFourArray(given), expected);
    }

    private static Stream<Arguments> provideArraysWhenFourIsPresentFirst() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 1, 3}, new int[]{2, 1, 3}),
                Arguments.of(new int[]{4, 1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{4, 1}, new int[]{1}),
                Arguments.of(new int[]{4, 4}, new int[0])
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysWhenFourIsPresentLast")
    void shouldReturnEmptyArray_whenFourIsPresentLast(int[] given, int[] expected) {
        Assertions.assertArrayEquals(ArrayUtils.lastFourArray(given), expected);
    }

    private static Stream<Arguments> provideArraysWhenFourIsPresentLast() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4, 4}, new int[0]),
                Arguments.of(new int[]{1, 2, 4}, new int[0]),
                Arguments.of(new int[]{1, 4}, new int[0]),
                Arguments.of(new int[]{4}, new int[0])
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysWhenFourIsNotPresent")
    void shouldThrowRuntimeException_whenFourIsNotPresent(int[] given) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> ArrayUtils.lastFourArray(given));
    }

    private static Stream<Arguments> provideArraysWhenFourIsNotPresent() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 7}),
                Arguments.of(new int[]{1, 2, 1}),
                Arguments.of(new int[]{1, 2}),
                Arguments.of(new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("provideEmptyArray")
    void shouldThrowRuntimeException_whenArrayIsEmpty(int[] given) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> ArrayUtils.lastFourArray(given));
    }

    private static Stream<Arguments> provideEmptyArray() {
        return Stream.of(
                Arguments.of(new int[0])
        );
    }

    @Test
    void shouldReturnTrue_whenOneAndFourArePresent() {
        int[] given = new int[]{1, 1, 1, 4, 4, 1, 4, 4};
        Assertions.assertTrue(ArrayUtils.isOneAndFourArray(given));
    }

    @Test
    void shouldReturnFalse_whenFourIsAbsent() {
        int[] given = new int[]{1, 1, 1, 1, 1, 1};
        Assertions.assertFalse(ArrayUtils.isOneAndFourArray(given));
    }

    @Test
    void shouldReturnFalse_whenOneIsAbsent() {
        int[] given = new int[]{4, 4, 4, 4};
        Assertions.assertFalse(ArrayUtils.isOneAndFourArray(given));
    }

    @Test
    void shouldReturnFalse_whenOneAndFourWithRandomDigitsArePresent() {
        int[] given = new int[]{1, 4, 4, 1, 1, 4, 3};
        Assertions.assertFalse(ArrayUtils.isOneAndFourArray(given));
    }
}
