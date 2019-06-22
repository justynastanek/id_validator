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

        int temp = 10;
        for(int i = Character.valueOf('A'); i <= Character.valueOf('Z'); i++) {
            LETTERS_WEIGHTS.put((char) i , temp);
            temp++;
        }
    }

    public boolean validate(String id_number){

        id_number = id_number.toUpperCase();
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
