import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class UIGui extends JFrame{
    private ArrayList<String> history = new ArrayList<>();

    private JTextField calculateText;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a4Button;
    private JButton a1Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton exitButton;
    private JButton clearButton;
    private JButton addbutton;
    private JButton minusbutton;
    private JButton timesbutton;
    private JButton dividebutton;
    private JPanel UIPanel;
    private JButton equalsbutton;
    private JButton decimalpoint;
    private JButton deleteButton;
    private JButton exponenButton;
    private JTextArea historyArea;
    private JScrollPane historyScroll;
    private JButton clearHistButton;

    public UIGui(){
        history.add("");
        setTitle("EMDAS Calculator");
        setContentPane(UIPanel);
        setVisible(true);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        //numbers button
        a1Button.addActionListener(e -> {
            String one ="1";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a2Button.addActionListener(e -> {
            String one ="2";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a3Button.addActionListener(e -> {
            String one ="3";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a4Button.addActionListener(e -> {
            String one ="4";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a5Button.addActionListener(e -> {
            String one ="5";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a6Button.addActionListener(e -> {
            String one ="6";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a7Button.addActionListener(e -> {
            String one ="7";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a8Button.addActionListener(e -> {
            String one ="8";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a9Button.addActionListener(e -> {
            String one ="9";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        a0Button.addActionListener(e -> {
            String one ="0";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });


        //special button
        exponenButton.addActionListener(e -> {
            String one ="^";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        decimalpoint.addActionListener(e -> {
            String one =".";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        deleteButton.addActionListener(e -> {
            try{
                String one = calculateText.getText();
                calculateText.setText(one.substring(0,one.length()-1));
            }catch (Exception exception){
                calculateText.setText("Nothing to Delete");
            }
        });

        clearHistButton.addActionListener(e -> {
            history.removeAll(history);
            historyArea.setText("");
        });
        clearButton.addActionListener(e -> calculateText.setText(""));
        exitButton.addActionListener(e -> System.exit(0));



        //operations
        addbutton.addActionListener(e -> {
            String one ="+";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        minusbutton.addActionListener(e -> {
            String one ="-";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        timesbutton.addActionListener(e -> {
            String one ="*";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        dividebutton.addActionListener(e -> {
            String one ="/";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });







        equalsbutton.addActionListener(e ->{
            String his = calculateText.getText();
            try{
                String notation = calculateText.getText();
                UILogic logic = new UILogic();

                String resultString = String.format("%.2f", logic.myProcess(notation));
                double resultDouble = Double.parseDouble(resultString);
                int div = resultString.indexOf(".");//checks index of decimal point exist
                int numOne = Integer.parseInt(String.valueOf(resultString.charAt(div+1)));
                int numTwo = Integer.parseInt(String.valueOf(resultString.charAt(div+2)));

                //prints out double if list contains double else integer
                if(numOne>0||numTwo>0){
                    calculateText.setText(String.format("%.2f",resultDouble));
                    history.add(his+" = "+calculateText.getText()+"\n");
                }else {
                    calculateText.setText( String.valueOf((int) resultDouble));
                    history.add(his+" = "+calculateText.getText()+"\n");
                }
            }catch (Exception exception){
                System.out.println("Equation Error");
            }
            historyArea.setText(String.valueOf(history).replaceAll("^\\[|]$|,+",""));
        });

        calculateText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==10){
                    equalsbutton.doClick();
                }
            }
        });

    }

}
