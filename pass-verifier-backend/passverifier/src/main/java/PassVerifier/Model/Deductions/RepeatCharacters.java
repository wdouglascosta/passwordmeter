package PassVerifier.Model.Deductions;

import PassVerifier.Model.ModelInterface;

import java.util.HashSet;
import java.util.Set;

public class RepeatCharacters implements ModelInterface {
    private Set<Integer> verifiedChars = new HashSet<>();

    @Override
    public int wordAnalyzer(String password) {
        int value = 0;
        verifiedChars.clear();
        boolean flag = false;
        for (int i = 0; i < password.length(); i++) {
            flag = false;
            int charCode = password.charAt(i);
            if (!verifiedChars.contains(charCode)){
                verifiedChars.add(charCode);
                for (int j = 0; j < password.length(); j++) {
                    if (!(i == j)){
                        int charCodeComparison = password.charAt(j);
                        if (charCode == charCodeComparison){
                            value++;
                            flag = true;
                        }
                    }
                }
                if (flag){
                    value++;
                }
            }
        }
        return value;
    }

    @Override
    public int bonusCalc(String password, int count) {
        return count;
    }
}
