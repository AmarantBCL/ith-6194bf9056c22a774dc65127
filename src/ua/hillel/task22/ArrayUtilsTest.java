package ua.hillel.task22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {

    @Test
    void shouldReturnArray_whenFourIsPresent() {
        int[] given = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expected = new int[]{1, 7};
        Assertions.assertArrayEquals(ArrayUtils.lastFourArray(given), expected);
    }

    @Test
    void shouldReturnEmptyArray_whenFourIsPresentButLast() {
        int[] given = new int[]{1, 2, 4, 4};
        int[] expected = new int[0];
        Assertions.assertArrayEquals(ArrayUtils.lastFourArray(given), expected);
    }

    @Test
    void shouldThrowRuntimeException_whenFourIsNotPresent() {
        int[] given = new int[]{1, 2, 1, 7};
        Assertions.assertThrowsExactly(RuntimeException.class, () -> ArrayUtils.lastFourArray(given));
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
