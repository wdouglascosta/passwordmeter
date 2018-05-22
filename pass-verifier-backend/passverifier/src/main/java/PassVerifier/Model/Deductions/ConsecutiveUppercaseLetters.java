package PassVerifier.Model.Deductions;

import PassVerifier.Model.ModelInterface;

public class ConsecutiveUppercaseLetters implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return consecutiveDetector("[A-Z]", password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count * 2;
    }
}
