package PassVerifier.Model.Additions;

import PassVerifier.Model.ModelInterface;

public class MiddleNumbersOrSymbols implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        int value = 0;
        for (int i = 1; i < password.length()-1; i++) {
            String character = Character.toString(password.charAt(i));
            if (regexCounter("[\\x20-\\x40\\|\\x5b-\\x60\\|\\x7b-\\x7e]", character) >= 1){
                if ((i+1) > password.length()) {
                    break;
                }else{
                    value++;
                }
            }
        }
        return value;
    }

    @Override
    public int bonusCalc(String password,int count) {
        return count * 2;
    }

}
