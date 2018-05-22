package PassVerifier.Model.Additions;

import PassVerifier.Model.ModelInterface;

public class UppercaseLetters implements ModelInterface {

    @Override
    public int wordAnalyzer(String password) {
        return regexCounter("[A-Z]",password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        if (count > 0 && password.length() > count){
            return (password.length() - count) * 2;
        }else {
            return 0;
        }
    }


}
