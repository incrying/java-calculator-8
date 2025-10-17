package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberMangerTest {
    @DisplayName("입력이 없는 경우 0 출력")
    @Test
    void numberManger_blankInput(){
        String input = "";
        String delimeter = ",|:";

        NumberManager numberManager = new NumberManager();
        List<Integer> output = numberManager.numberExtractor(input,delimeter);

        assertThat(output).isEqualTo(List.of(0));
    }

    @DisplayName("숫자 이외의 문자가 입력된 경우 에러 반환")
    @Test
    void numberManger_nonDigit(){
        String input = "2w:2";
        String delimeter = ",|:";

        NumberManager numberManager = new NumberManager();
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> numberManager.numberExtractor(input,delimeter));

        assertThat(exception.getMessage()).isEqualTo("숫자 이외의 문자가 입력되었습니다.");
    }

    @DisplayName("숫자가 음수인 경우 에러 반환")
    @Test
    void numberManger_negative(){
        String input = "-2:2";
        String delimeter = ",|:";

        NumberManager numberManager = new NumberManager();
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> numberManager.numberExtractor(input,delimeter));

        assertThat(exception.getMessage()).isEqualTo("숫자는 음수일 수 없습니다.");
    }

    @DisplayName("입력으로부터 숫자만 추출 확인")
    @Test
    void numberManger(){
        String input = "2:2";
        String delimeter = ",|:";

        NumberManager numberManager = new NumberManager();
        List<Integer> output = numberManager.numberExtractor(input,delimeter);

        assertThat(output).isEqualTo(List.of(2,2));
    }
}

