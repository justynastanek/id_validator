package js.id_validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ID_Validator implements Validator{

    final static int[] WEIGHTS = {7,3,1,9,7,3,1,7,3};
    final static Pattern ID_PATTERN = Pattern.compile("[a-zA-Z]{3}[0-9]{6}");
    final static Map<Character, Integer> LETTERS_WEIGHTS = new HashMap<>();
    static{
        LETTERS_WEIGHTS.put('A',10);
        LETTERS_WEIGHTS.put('B',11);
        LETTERS_WEIGHTS.put('C',12);
        LETTERS_WEIGHTS.put('D',13);
        LETTERS_WEIGHTS.put('E',14);
        LETTERS_WEIGHTS.put('F',15);
        LETTERS_WEIGHTS.put('G',16);
        LETTERS_WEIGHTS.put('H',17);
        LETTERS_WEIGHTS.put('I',18);
        LETTERS_WEIGHTS.put('J',19);
        LETTERS_WEIGHTS.put('K',20);
        LETTERS_WEIGHTS.put('L',21);
        LETTERS_WEIGHTS.put('M',22);
        LETTERS_WEIGHTS.put('N',23);
        LETTERS_WEIGHTS.put('O',24);
        LETTERS_WEIGHTS.put('P',25);
        LETTERS_WEIGHTS.put('Q',26);
        LETTERS_WEIGHTS.put('R',27);
        LETTERS_WEIGHTS.put('S',28);
        LETTERS_WEIGHTS.put('T',29);
        LETTERS_WEIGHTS.put('U',30);
        LETTERS_WEIGHTS.put('V',31);
        LETTERS_WEIGHTS.put('W',32);
        LETTERS_WEIGHTS.put('X',33);
        LETTERS_WEIGHTS.put('Y',34);
        LETTERS_WEIGHTS.put('Z',35);
    }

    public boolean validate(String id_number){

        Matcher id_matcher = ID_PATTERN.matcher(id_number);

        if(!id_matcher.matches()){
            return false;
        }

        int sum = 0;
        int[] numbers = new int[9];

        for(int k = 0; k < 3; k++){
            numbers[k] = LETTERS_WEIGHTS.get(id_number.charAt(k));
        }

        for(int j = 3; j < id_number.length(); j++) {
            numbers[j] = id_number.charAt(j);
        }

        for(int i = 0 ; i < id_number.length(); i++ ){
            sum += WEIGHTS[i] * numbers[i];
        }

        return sum%10 == 0;
    }


}
