import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MainTest {

    @Test
    public void shouldMassiveException() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.array(new int[]{1, 2, 1, 3, 3, 3, 5, 1, 7});
        });
    }

    @ParameterizedTest
    @MethodSource("arrays")
    public void shouldArray(int[] a, int[] b) {
        Assertions.assertArrayEquals(b, Main.array(a));
    }

    static Stream<Arguments> arrays() {

        return Stream.of(
                arguments(new int[]{7, 2, 3, 4, 5, 10, 7, 8}, new int[]{5, 10, 7, 8}),
                arguments(new int[]{6, 4, 3, 4, 4, 3, 7, 8}, new int[]{3, 7, 8}),
                arguments(new int[]{5, 9, 3, 4, 5, 2, 4, 8}, new int[]{8}),
                arguments(new int[]{4, 8, 10, 3, 5, 23, 7, 4}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("arrays1")
    public void shouldCheckArray(int[] a, boolean z) {
        Assertions.assertEquals(z, Main.checkArray(a));
    }

    static Stream<Arguments> arrays1() {

        return Stream.of(
                arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true),
                arguments(new int[]{1, 1, 1, 1, 1, 1}, false),
                arguments(new int[]{4, 4, 4, 4}, false),
                arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, true)
        );
    }
}
