package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AdderTest {
    @DisplayName("덧셈 수행 확인")
    @Test
    void adder(){
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1,2,3,4)
        );

        int total = Adder.add(numbers);

        assertThat(total).isEqualTo(10);
    }
}
