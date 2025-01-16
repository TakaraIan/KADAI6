package jp.ac.uryukyu.ie.e245718;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JankenGameGUI {
    private static final String[] IMAGE_PATHS = {"rock.png", "scissors.png", "paper.png"};
    private static final int IMAGE_WIDTH = 250;
    private static final int IMAGE_HEIGHT = 250;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("じゃんけんゲーム");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JLabel resultLabel = new JLabel("ゲームを開始してください", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton rockButton = new JButton("グー");
        JButton scissorsButton = new JButton("チョキ");
        JButton paperButton = new JButton("パー");
        
        buttonPanel.add(rockButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(paperButton);

        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 2));

        JLabel userChoiceImage = new JLabel();
        JLabel computerChoiceImage = new JLabel();
        imagePanel.add(userChoiceImage);
        imagePanel.add(computerChoiceImage);

        panel.add(resultLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(imagePanel, BorderLayout.SOUTH);
        frame.add(panel);
        
        rockButton.addActionListener(e -> playGame(0, userChoiceImage, computerChoiceImage, resultLabel));
        scissorsButton.addActionListener(e -> playGame(1, userChoiceImage, computerChoiceImage, resultLabel));
        paperButton.addActionListener(e -> playGame(2, userChoiceImage, computerChoiceImage, resultLabel));

        frame.setVisible(true);
    }

    private static void playGame(int playerChoice, JLabel userChoiceImage, JLabel computerChoiceImage, JLabel resultLabel) {
        ImageIcon userIcon = resizeImage(new ImageIcon(IMAGE_PATHS[playerChoice]));
        userChoiceImage.setIcon(userIcon);

        Random random = new Random();
        int computerChoice = random.nextInt(3);
        
        ImageIcon computerIcon = resizeImage(new ImageIcon(IMAGE_PATHS[computerChoice]));
        computerChoiceImage.setIcon(computerIcon);

        String result = JankenResult.determineWinner(playerChoice, computerChoice);
        resultLabel.setText(result);
    }

    private static ImageIcon resizeImage(ImageIcon originalIcon) {
        Image img = originalIcon.getImage();
        Image resizedImg = img.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
