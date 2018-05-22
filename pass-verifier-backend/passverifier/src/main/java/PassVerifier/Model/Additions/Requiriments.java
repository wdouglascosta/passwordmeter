package PassVerifier.Model.Additions;

import PassVerifier.Model.ModelInterface;

public class Requiriments implements ModelInterface {

    public int requirimentAnalyzer(int numCharacters, int upperLetters, int lowerLetters, int numbers, int symbols){
        int value = 0;
        if (numCharacters >= 8){
            value++;
        }
        if (upperLetters > 0){
            value++;
        }
        if (lowerLetters > 0){
            value++;
        }
        if (numbers > 0){
            value++;
        }
        if (symbols > 0){
            value++;
        }
        return value;

    }

    @Override
    public int wordAnalyzer(String password) {
        return 0;
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count * 2;
    }
}
