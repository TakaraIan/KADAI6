package jp.ac.uryukyu.ie.e245718;

import java.util.Scanner;

public class JankenGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"グー", "チョキ", "パー"};
        
        System.out.println("じゃんけんをしましょう！");
        System.out.println("0: グー, 1: チョキ, 2: パー");
        System.out.print("あなたの手を入力してください (0, 1, 2): ");
        int playerChoice = scanner.nextInt();
        
        int computerChoice = (int)(Math.random() * 3);
        
        String result = JankenResult.determineWinner(playerChoice, computerChoice);

        System.out.println("あなたの手: " + choices[playerChoice]);
        System.out.println("コンピュータの手: " + choices[computerChoice]);
        System.out.println(result);
        
        scanner.close();
    }
}
