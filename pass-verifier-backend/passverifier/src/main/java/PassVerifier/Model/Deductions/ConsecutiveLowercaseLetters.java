package PassVerifier.Model.Deductions;

import PassVerifier.Model.ModelInterface;

public class ConsecutiveLowercaseLetters implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return consecutiveDetector("[a-z]", password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count * 2;
    }
}
