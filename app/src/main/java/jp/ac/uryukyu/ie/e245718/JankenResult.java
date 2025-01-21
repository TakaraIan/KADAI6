package jp.ac.uryukyu.ie.e245718;

/**
 * じゃんけんの結果を判定するクラス
 */
public class JankenResult {
    
    /**
     * 勝者を決定します。
     * @param playerChoice プレイヤーの選択 (0: グー, 1: チョキ, 2: パー)
     * @param computerChoice コンピュータの選択 (0: グー, 1: チョキ, 2: パー)
     * @return 勝敗結果メッセージ
     */
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
