package PassVerifier.Model.Deductions;

import PassVerifier.Model.ModelInterface;

public class ConsecutiveNumbers implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return consecutiveDetector("[0-9]", password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count * 2;
    }
}
