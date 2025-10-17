package calculator;

import java.util.regex.Pattern;

public class DelimeterManager {

    private String delimeter = ",|:";
    private String subString;

    public String getDelimeter(String input) {
        // 기본 구분자 반환
        if (!input.startsWith("//") || !input.contains("\\n"))
            return delimeter;

        subString = input.substring(2, input.indexOf("\\n"));
        if (subString.isBlank())
            return delimeter;

        validateSubString(subString);

        if (isSpecialCharacter(subString))
            subString = "\\" + subString;

        return delimeter + "|" + subString;
    }

    private void validateSubString(String subString) {
        if (subString.length() > 1) {
            throw new IllegalArgumentException("구분자는 여러 개일 수 없습니다.");
        }
        if (Character.isDigit(subString.charAt(0))) {
            throw new IllegalArgumentException("구분자는 숫자일 수 없습니다.");
        }
    }

    private boolean isSpecialCharacter(String input) {
        String regex = "[|*&^]";
        if (Pattern.matches(regex, input))
            return true;
        else
            return false;
    }
}
