package PassVerifier.Model.Deductions;

import PassVerifier.Model.ModelInterface;

public class SequentialSymbols implements ModelInterface {
    private String sequence = "!@#$%^&*()";
    @Override
    public int wordAnalyzer(String password) {
        return sequenceDetector(sequence, password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count * 3;
    }
}
