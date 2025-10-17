package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        DelimeterManager delimeterManager = new DelimeterManager();
        NumberManager numberManager = new NumberManager();

        String delimeter = delimeterManager.getDelimeter(input);
        String subString = StringParser.splitString(input);
        List<Integer> numbers = numberManager.numberExtractor(subString,delimeter);
        int result = Adder.add(numbers);

        System.out.println("결과 : " + result);
    }
}
