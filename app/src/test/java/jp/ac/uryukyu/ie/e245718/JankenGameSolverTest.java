package jp.ac.uryukyu.ie.e245718;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JankenGameSolverのユニットテスト
 */
public class JankenGameSolverTest {

    @Test
    public void testPlayGame() {
        JankenGameSolver solver = new JankenGameSolver();

        // プレイヤーがグー(0)の場合
        String result = solver.playGame(0);
        assertTrue(result.equals("あなたの勝ちです！") || result.equals("コンピュータの勝ちです！") || result.equals("引き分けです！"));
    }

    @Test
    public void testStatistics() {
        JankenGameSolver solver = new JankenGameSolver();
        solver.playGame(0);
        solver.playGame(1);
        solver.playGame(2);
        String stats = solver.getStatistics();
        assertTrue(stats.contains("試合数:3"));
    }
}
