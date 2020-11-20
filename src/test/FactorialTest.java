import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testNegative(){
        assertThrows(IllegalAccessException.class, () -> {
            Factorial.fact(-1);;
        });
    }

}