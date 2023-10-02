import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessing implements ActionListener
{

    private  int randomNumber = 0;
    private int gueesNumber;
    private int stepsCounter = 0;

    private JLabel gameInfo;

    private JLabel textInput;

    private JLabel textWin;

    private JTextField  textField;
    private  JFrame frame;
    private JPanel panel;

    private Random rand = new Random();

    public NumberGuessing()
    {

            randomNumber = rand.nextInt(99)+1;
            frame = new JFrame();

            JButton button = new JButton("Enter");
            button.addActionListener(this);

            gameInfo = new JLabel("Guess the Number between 1 and 100");

            textField = new JTextField(30);
            textInput = new JLabel("");
            textWin = new JLabel("");

            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
            panel.setLayout(new GridLayout(0,1));

            panel.add(gameInfo);
            panel.add(button);
            panel.add(textField);
            panel.add(textInput);
            panel.add(textWin);


            frame.add(panel,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("NumberGuessing");
            frame.pack();
            frame.setVisible(true);

    }



    public static void main(String[] args)
    {

    new NumberGuessing();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gueesNumber = Integer.parseInt(textField.getText());

            if( gueesNumber == randomNumber)
            {
                textInput.setText("You're right! You needed "+ stepsCounter+ " attempts" );
                textWin.setText("Now I'm thinking about new number! Can you guess it?");
                randomNumber = rand.nextInt(99)+1;
                stepsCounter = 0;

            }
            else
            {
                stepsCounter++;
                textWin.setText("");

                if(gueesNumber > randomNumber)
                {
                    textInput.setText("Try again! My number is smaller");
                }
                else if (gueesNumber < randomNumber)
                {
                    textInput.setText("Try again! My number is greater");
                }
            }
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Wrong Number Entered");
            textInput.setText("Wrong Number Entered");
        }



    }
}




