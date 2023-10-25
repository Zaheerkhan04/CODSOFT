/* Task 2
  Guessing number a number in range 1 to 100 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class NumberGuessingGameGUI {
    private JFrame frame;
    private JTextField inputField;
    private int targetNumber;
    private int attempts;
    private String playerName;

    public NumberGuessingGameGUI() {
        frame = new JFrame("Number Guessing Game");
        frame.getContentPane().setBackground(new Color(64, 128, 128));
        frame.getContentPane().setForeground(new Color(64, 128, 128));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(430, 323);
        frame.getContentPane().setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Guessing number game");
        welcomeLabel.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
        welcomeLabel.setForeground(new Color(255, 255, 255));
        welcomeLabel.setBounds(63, 73, 250, 20);
        frame.getContentPane().add(welcomeLabel);

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
        nameLabel.setBackground(new Color(255, 255, 255));
        nameLabel.setForeground(new Color(255, 255, 255));
        nameLabel.setBounds(10, 132, 120, 20);
        frame.getContentPane().add(nameLabel);

        inputField = new JTextField();
        inputField.setBounds(160, 133, 150, 20);
        frame.getContentPane().add(inputField);

        JButton startButton = new JButton("Start Game");
        startButton.setForeground(new Color(0, 128, 128));
        startButton.setFont(new Font("Arial Narrow", Font.BOLD | Font.ITALIC, 15));
        startButton.setBounds(161, 179, 136, 30);
        frame.getContentPane().add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName = inputField.getText();
                startGame();
            }
        });

        frame.setVisible(true);
    }

    private void startGame() {
        frame.getContentPane().removeAll();
        frame.repaint();

        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        attempts = 0;

        JLabel guessLabel = new JLabel("Enter your guess:");
        guessLabel.setBounds(20, 40, 120, 20);
        frame.getContentPane().add(guessLabel);

        JTextField guessField = new JTextField();
        guessField.setBounds(150, 40, 50, 20);
        frame.getContentPane().add(guessField);

        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(210, 40, 80, 20);
        frame.getContentPane().add(guessButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 80, 300, 20);
        frame.getContentPane().add(resultLabel);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(guessField.getText());
                    attempts++;
                    if (userGuess == targetNumber) {
                        resultLabel.setText(playerName + ", you guessed it right in " + attempts + " attempts!");
                        guessButton.setEnabled(false);
                    } else if (userGuess < targetNumber) {
                        resultLabel.setText("Try a higher number. Attempts: " + attempts);
                    } else {
                        resultLabel.setText("Try a lower number. Attempts: " + attempts);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter a number.");
                }
                guessField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGameGUI();
            }
        });
    }
}
