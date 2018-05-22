package PassVerifier.Model.Deductions;

import PassVerifier.Model.ModelInterface;

public class NumbersOnly implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return regexCounter("^([0-9])*$", password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count;
    }
}
