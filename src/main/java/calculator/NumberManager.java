package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumberManager {

    private List<Integer> numbers = new ArrayList<>();
    public List<Integer> numberExtractor(String input, String delimeter){
        if(input.isBlank()){
            numbers.add(0);
            return numbers;
        }
        String[] stringNumbers = input.split(delimeter);

        for (int i=0;i<stringNumbers.length;i++){
            if(isDigit(stringNumbers[i]))
                throw new IllegalArgumentException("숫자 이외의 문자가 입력되었습니다.");
            if (parseInt(stringNumbers[i])<0)
                throw new IllegalArgumentException("숫자는 음수일 수 없습니다.");
            numbers.add(parseInt(stringNumbers[i]));
        }
        return numbers;
    }

    private int parseInt(String number){
        int result = Integer.parseInt(number);
        return result;
    }

    private boolean isDigit (String input){ //이름 좀 생각해보기
        String regex = "^[\\d]$";
        if(Pattern.matches(regex,input))
            return false;
        else
            return true;
    }
}
