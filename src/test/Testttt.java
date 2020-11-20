import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testttt {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -100})
    void testAbs(int x) {
        assertEquals(-x, Math.abs(x));
    }

}
