package PassVerifier.Model.Additions;

import PassVerifier.Model.ModelInterface;

public class Numbers implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return regexCounter("[0-9]", password);
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count * 4;
    }
}
