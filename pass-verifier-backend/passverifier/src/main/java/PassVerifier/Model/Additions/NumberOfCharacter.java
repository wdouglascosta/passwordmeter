package PassVerifier.Model.Additions;

import PassVerifier.Model.ModelInterface;

public class NumberOfCharacter implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return password.length();
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count * 4;
    }
}
