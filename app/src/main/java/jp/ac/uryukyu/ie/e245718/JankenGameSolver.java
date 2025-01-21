package jp.ac.uryukyu.ie.e245718;

import java.util.Random;

/**
 * ゲームのロジックを管理するクラス
 * ゲームの進行、結果の判定、統計の管理などを行う。
 */
public class JankenGameSolver {
    private int wonCounter = 0;
    private int lostCounter = 0;
    private int matchCounter = 0;

    private int computerChoice;

    /**
     * プレイヤーとコンピュータの選択を元に勝敗を決定し、結果を更新する。
     * @param playerChoice プレイヤーの選択 (0: グー, 1: チョキ, 2: パー)
     * @return 結果メッセージ
     */
    public String playGame(int playerChoice) {
        Random random = new Random();
        computerChoice = random.nextInt(3);

        String result = JankenResult.determineWinner(playerChoice, computerChoice);

        if (result.equals("あなたの勝ちです！")) {
            wonCounter++;
        } else if (result.equals("コンピュータの勝ちです！")) {
            lostCounter++;
        }
        matchCounter++;

        return result;
    }

    /**
     * 現在の統計情報を取得します。
     * @return 統計情報 (勝ち, 負け, 試合数, 勝率)
     */
    public String getStatistics() {
        float winPercentage = (matchCounter > 0) ? (float) wonCounter / matchCounter * 100 : 0;
        return String.format("勝ち:%d 負け:%d 試合数:%d 勝率:%.2f%%", wonCounter, lostCounter, matchCounter, winPercentage);
    }

    /**
     * コンピュータの選択を取得します。
     * @return コンピュータの選択 (0: グー, 1: チョキ, 2: パー)
     */
    public int getComputerChoice() {
        return computerChoice;
    }
}
