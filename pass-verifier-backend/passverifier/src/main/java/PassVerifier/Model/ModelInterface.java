package PassVerifier.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ModelInterface {
    int wordAnalyzer(String password);
    int bonusCalc(String password, int count);


    default int regexCounter(String regex, String password){
        int count = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        while (matcher.find()){
            count++;
        }
        return count;
    }

    default int consecutiveDetector(String regex, String password){
        int value = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            String character = Character.toString(password.charAt(i));
            if (regexCounter(regex, character) >=1){
                if (regexCounter(regex, Character.toString(password.charAt( i + 1 ))) >= 1){
                    value++;
                }
            }
        }
        return value;
    }

    default int sequenceDetector(String sequence, String password){
        String forward;
        String reverse;
        password = password.toLowerCase();
        int value = 0;
        for (int i = 0; i < sequence.length() -3 ; i++) {
            forward = sequence.substring(i, i+3);
            reverse = new StringBuilder(forward).reverse().toString();
            if (password.contains(forward) || password.contains(reverse)){
                value++;
            }
        }
        return value;
    }
}
