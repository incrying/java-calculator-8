package calculator;

import java.util.regex.Pattern;

public class DelimeterManager {

    private String delimeter = ",|:";

    public String DelimeterFinder(String input){
        String subString;
        if(input.startsWith("//")&&input.contains("\\n")){
            subString = input.substring(2,input.indexOf("\\n"));
            if(subString.length() != 1)
                throw new IllegalArgumentException("구분자는 여러 개일 수 없습니다.");
            if(Character.isDigit(subString.charAt(0)))
                throw new IllegalArgumentException("구분자는 숫자일 수 없습니다.");
            if(isSpecialCharacter(subString))
                subString = "\\" + subString;
            delimeter += "|" + subString;
            return delimeter;
        }
        else
            return delimeter;
    }

    private boolean isSpecialCharacter (String input){
        String regex = "[|*&^]";
        if(Pattern.matches(regex,input))
            return true;
        else
            return false;
    }
}
