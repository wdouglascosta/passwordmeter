package PassVerifier.Model.Deductions;

import PassVerifier.Model.ModelInterface;

public class LettersOnly implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return regexCounter("^([a-zA-Z])*$", password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count;
    }
}
