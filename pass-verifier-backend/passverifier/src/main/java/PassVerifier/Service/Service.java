package PassVerifier.Service;

import PassVerifier.Model.Additions.*;
import PassVerifier.Model.Deductions.*;
import org.springframework.stereotype.Component;

@Component
public class Service {

    private int numberOfCharacters;
    private int uppercaseLetters;
    private int lowercaseLetters;
    private int numbers;
    private int symbols;
    private int middleNumbersOrSymbols;
    private int requirements;

    private int lettersOnly;
    private int numbersOnly;
    private int repeatCharacters;
    private int consecutiveUppercase;
    private int consecutiveLowercase;
    private int consecutiveNumbers;
    private int sequentialLetters;
    private int sequentialNumbers;
    private int sequentialSymbols;

    NumberOfCharacter numberOfChar = new NumberOfCharacter();
    UppercaseLetters upperLetters = new UppercaseLetters();
    LowercaseLetters lowerLetters = new LowercaseLetters();
    Numbers nums = new Numbers();
    Symbols syms = new Symbols();
    LettersOnly onlyLetters = new LettersOnly();
    NumbersOnly onlyNumbers = new NumbersOnly();


    MiddleNumbersOrSymbols numbersOrSymbols = new MiddleNumbersOrSymbols();
    RepeatCharacters characters = new RepeatCharacters();
    ConsecutiveUppercaseLetters consecutiveUpper = new ConsecutiveUppercaseLetters();
    ConsecutiveLowercaseLetters consecutiveLower = new ConsecutiveLowercaseLetters();
    ConsecutiveNumbers consecNumbers = new ConsecutiveNumbers();
    SequentialLetters seqLetters = new SequentialLetters();
    SequentialNumbers seqNumbers = new SequentialNumbers();
    SequentialSymbols seqSymbols = new SequentialSymbols();

    Requiriments req = new Requiriments();


    private void passwordAnalyzer(String password){
        numbersOnly = onlyNumbers.wordAnalyzer(password);
        lettersOnly = onlyLetters.wordAnalyzer(password);
        symbols = syms.wordAnalyzer(password);
        numbers = nums.wordAnalyzer(password);
        numberOfCharacters = numberOfChar.wordAnalyzer(password);
        uppercaseLetters = upperLetters.wordAnalyzer(password);
        lowercaseLetters = lowerLetters.wordAnalyzer(password);
        middleNumbersOrSymbols = numbersOrSymbols.wordAnalyzer(password);
        repeatCharacters = characters.wordAnalyzer(password);
        consecutiveUppercase = consecutiveUpper.wordAnalyzer(password);
        consecutiveLowercase = consecutiveLower.wordAnalyzer(password);
        consecutiveNumbers = consecNumbers.wordAnalyzer(password);
        sequentialLetters = seqLetters.wordAnalyzer(password);
        sequentialNumbers = seqNumbers.wordAnalyzer(password);
        sequentialSymbols = seqSymbols.wordAnalyzer(password);
        requirements = req.requirimentAnalyzer(numberOfCharacters, uppercaseLetters, lowercaseLetters, numbers, symbols);
    }

    private int rateCalc(String password){
        int additions = numberOfChar.bonusCalc(password,numberOfCharacters) +
                upperLetters.bonusCalc(password, uppercaseLetters) +
                lowerLetters.bonusCalc(password, lowercaseLetters) +
                nums.bonusCalc(password, numbers) +
                syms.bonusCalc(password, symbols) +
                numbersOrSymbols.bonusCalc(password, middleNumbersOrSymbols) +
                req.bonusCalc(password, requirements);
        int deductions = onlyLetters.bonusCalc(password, lettersOnly) +
                onlyNumbers.bonusCalc(password, numbersOnly) +
                characters.bonusCalc(password, repeatCharacters) +
                consecutiveUpper.bonusCalc(password, consecutiveUppercase) +
                consecutiveLower.bonusCalc(password, consecutiveLowercase) +
                consecNumbers.bonusCalc(password, consecutiveNumbers) +
                seqLetters.bonusCalc(password, sequentialLetters) +
                seqNumbers.bonusCalc(password, sequentialNumbers) +
                seqSymbols.bonusCalc(password, sequentialSymbols);

        int result = additions - deductions;
        if (result > 0 && result < 100){
            return result;
        }else {
            if (result < 0){
                result = 0;
            }
            if (result > 100){
                result = 100;
            }
        }
        return result;
    }

    public Integer VerifyValidityPassword(String pass){
        passwordAnalyzer(pass);
        return rateCalc(pass);
    }
}
