package jp.ac.uryukyu.ie.e245718;

public class JankenResult {
    public static String determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return "引き分けです！";
        } else if ((playerChoice == 0 && computerChoice == 1) || 
                (playerChoice == 1 && computerChoice == 2) || 
                (playerChoice == 2 && computerChoice == 0)) {
            return "あなたの勝ちです！";
        } else {
            return "コンピュータの勝ちです！";
        }
    }
}
