package calculator;

public class StringParser {

    static public String splitString(String input){
        String subString;
        if(input.startsWith("//")&&input.contains("\\n")){
            subString = input.substring(5);
            return subString;
        }
        else
            return input;
    }
}
