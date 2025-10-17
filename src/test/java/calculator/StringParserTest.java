package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @DisplayName("커스텀 구분자가 있는 경우 구분자 정의 부분 분리")
    @Test
    void stringParser_hasCustomDelimeter() {
        String input1 = "//;\\n1;2";
        String output1;

        output1 = StringParser.splitString(input1);


        assertThat(output1).isEqualTo("1;2");
    }

    @DisplayName("커스텀 구분자가 없는 경우 입력 그대로 반환")
    @Test
    void stringParser_noCustomDelimeter(){
        String input1 = "1;2";
        String output1;

        output1 = StringParser.splitString(input1);


        assertThat(output1).isEqualTo("1;2");
    }
}
