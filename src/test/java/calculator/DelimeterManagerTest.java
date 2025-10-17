package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimeterManagerTest {
    @DisplayName("구분자가 여러 개인 경우 에러 반환")
    @Test
    void delimeterManager_multiple(){
        String input = "//;+\\n1,2";

        DelimeterManager delimeterManager = new DelimeterManager();

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> delimeterManager.getDelimeter(input));

        assertThat(exception.getMessage()).isEqualTo("구분자는 여러 개일 수 없습니다.");
    }

    @DisplayName("구분자가 숫자인 경우 에러 반환")
    @Test
    void delimeterManager_number(){
        String input = "//3\\n1,2";

        DelimeterManager delimeterManager = new DelimeterManager();

        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()
                -> delimeterManager.getDelimeter(input));

        assertThat(exception.getMessage()).isEqualTo("구분자는 숫자일 수 없습니다.");
    }

    @DisplayName("커스텀 구분자 입력이 없는 경우 기본 구분자 반환")
    @Test
    void delimeterManager_blank(){
        String input = "//\\n1,2";

        DelimeterManager delimeterManager = new DelimeterManager();
        String delimeter = delimeterManager.getDelimeter(input);

        assertThat(delimeter).isEqualTo(",|:");
    }

    @DisplayName("구분자가 인식이 안 될 수도 있는 특수 문자인 경우도 구분자로 등록")
    @Test
    void delimeterManager_specialCharacter(){
        String input = "//^\\n1^2";

        DelimeterManager delimeterManager = new DelimeterManager();
        String delimeter = delimeterManager.getDelimeter(input);

        assertThat(delimeter).isEqualTo(",|:|\\^");
    }

    @DisplayName("구분자 추출 확인")
    @Test
    void delimeterManager(){
        String input = "//;\\n1;2";
        String output;

        DelimeterManager delimeterManager = new DelimeterManager();
        output = delimeterManager.getDelimeter(input);

        assertThat(output).isEqualTo(",|:|;");
    }
}
