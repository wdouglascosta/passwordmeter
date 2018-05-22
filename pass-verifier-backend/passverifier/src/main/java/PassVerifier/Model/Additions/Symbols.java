package PassVerifier.Model.Additions;

import PassVerifier.Model.ModelInterface;

public class Symbols implements ModelInterface {
    @Override
    public int wordAnalyzer(String password) {
        return regexCounter("[\\x20-\\x2F\\|\\x3a-\\x40\\|\\x5b-\\x60\\|\\x7b-\\x7e]", password);
    }

    @Override
    public int bonusCalc(String password,int count) {
        return count * 6;
    }
}
