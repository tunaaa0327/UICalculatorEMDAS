import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Locale;

public class UIGui extends JFrame {
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

    public UIGui() {
        history.add("");
        setTitle("EMDAS Calculator");
        setContentPane(UIPanel);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //numbers button
        a1Button.addActionListener(e -> {
            String one = "1";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a2Button.addActionListener(e -> {
            String one = "2";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a3Button.addActionListener(e -> {
            String one = "3";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a4Button.addActionListener(e -> {
            String one = "4";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a5Button.addActionListener(e -> {
            String one = "5";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a6Button.addActionListener(e -> {
            String one = "6";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a7Button.addActionListener(e -> {
            String one = "7";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a8Button.addActionListener(e -> {
            String one = "8";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a9Button.addActionListener(e -> {
            String one = "9";
            one = calculateText.getText() + one;
            calculateText.setText(one);
            addComma();

        });
        a0Button.addActionListener(e -> {
            String one = "0";
            one = calculateText.getText() + one;
            calculateText.setText(one);

        });


        //special button
        exponenButton.addActionListener(e -> {
            String one = "^";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        decimalpoint.addActionListener(e -> {
            String one = ".";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        deleteButton.addActionListener(e -> {
            try {
                String one = calculateText.getText();
                calculateText.setText(one.substring(0, one.length() - 1));
            } catch (Exception exception) {
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
            String one = "+";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        minusbutton.addActionListener(e -> {
            String one = "-";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        timesbutton.addActionListener(e -> {
            String one = "*";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });
        dividebutton.addActionListener(e -> {
            String one = "/";
            one = calculateText.getText() + one;
            calculateText.setText(one);
        });


        equalsbutton.addActionListener(e -> {
            String his = calculateText.getText();
            try {
                String notation = calculateText.getText();
                notation = notation.replaceAll(",", "");
                UILogic logic = new UILogic();

                String resultString = String.format("%.2f", logic.myProcess(notation));
                double resultDouble = Double.parseDouble(resultString);
                int div = resultString.indexOf(".");//checks index of decimal point exist
                int numOne = Integer.parseInt(String.valueOf(resultString.charAt(div + 1)));
                int numTwo = Integer.parseInt(String.valueOf(resultString.charAt(div + 2)));

                //prints out double if list contains double else integer
                if (numOne > 0 || numTwo > 0) {
                    calculateText.setText(String.format("%.2f", resultDouble));
                    history.add(his + " = " + calculateText.getText() + "\n");
                } else {
                    calculateText.setText(String.valueOf((int) resultDouble));
                    history.add(his + " = " + calculateText.getText() + "\n");
                }
            } catch (Exception exception) {
                System.out.println("Equation Error");
            }
            historyArea.setText(String.valueOf(history).replaceAll("^\\[|]$|,+", ""));
            addComma();
        });

        calculateText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == 10) {
                    equalsbutton.doClick();
                }
            }
        });

    }

    public void addComma() {
        String txtComma = "";
        String txt = calculateText.getText().replaceAll(",", "");
        int counter = 0;
        int dec = txt.indexOf(".");
        for (int i = txt.length(); i > 0; i--) {
            boolean digit = Character.isDigit(txt.charAt(i - 1));
            if (counter == 3 && digit) {
                txtComma = "," + txtComma;
                counter = 0;

            }
            if (digit) {
                txtComma = txt.charAt(i - 1) + txtComma;
                counter++;
            } else {
                counter = 0;
                txtComma = txt.charAt(i - 1) + txtComma;
            }

        }

        calculateText.setText(txtComma);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        UIPanel = new JPanel();
        UIPanel.setLayout(new GridBagLayout());
        a2Button = new JButton();
        a2Button.setText("2");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a2Button, gbc);
        a1Button = new JButton();
        a1Button.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a1Button, gbc);
        a3Button = new JButton();
        a3Button.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a3Button, gbc);
        addbutton = new JButton();
        addbutton.setText("+");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(addbutton, gbc);
        a6Button = new JButton();
        a6Button.setText("6");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a6Button, gbc);
        minusbutton = new JButton();
        minusbutton.setText("-");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(minusbutton, gbc);
        dividebutton = new JButton();
        dividebutton.setText("/");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(dividebutton, gbc);
        timesbutton = new JButton();
        timesbutton.setText("x");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(timesbutton, gbc);
        a9Button = new JButton();
        a9Button.setText("9");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a9Button, gbc);
        a5Button = new JButton();
        a5Button.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a5Button, gbc);
        a8Button = new JButton();
        a8Button.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a8Button, gbc);
        a7Button = new JButton();
        a7Button.setText("7");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a7Button, gbc);
        a0Button = new JButton();
        a0Button.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a0Button, gbc);
        decimalpoint = new JButton();
        decimalpoint.setText(".");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 14;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(decimalpoint, gbc);
        clearButton = new JButton();
        clearButton.setText("Clear");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(clearButton, gbc);
        equalsbutton = new JButton();
        Font equalsbuttonFont = this.$$$getFont$$$(null, -1, 36, equalsbutton.getFont());
        if (equalsbuttonFont != null) equalsbutton.setFont(equalsbuttonFont);
        equalsbutton.setText("=");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(equalsbutton, gbc);
        a4Button = new JButton();
        a4Button.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(a4Button, gbc);
        exponenButton = new JButton();
        exponenButton.setText("^");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(exponenButton, gbc);
        calculateText = new JTextField();
        Font calculateTextFont = this.$$$getFont$$$(null, -1, 20, calculateText.getFont());
        if (calculateTextFont != null) calculateText.setFont(calculateTextFont);
        calculateText.setHorizontalAlignment(10);
        calculateText.setInheritsPopupMenu(false);
        calculateText.setMargin(new Insets(2, 6, 2, 6));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(calculateText, gbc);
        deleteButton = new JButton();
        deleteButton.setText("<--");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(deleteButton, gbc);
        historyScroll = new JScrollPane();
        historyScroll.setHorizontalScrollBarPolicy(30);
        historyScroll.setVerifyInputWhenFocusTarget(true);
        historyScroll.setVerticalScrollBarPolicy(20);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(historyScroll, gbc);
        historyArea = new JTextArea();
        historyArea.setBackground(new Color(-1249039));
        historyArea.setEditable(false);
        Font historyAreaFont = this.$$$getFont$$$(null, -1, 22, historyArea.getFont());
        if (historyAreaFont != null) historyArea.setFont(historyAreaFont);
        historyArea.setForeground(new Color(-8355712));
        historyScroll.setViewportView(historyArea);
        clearHistButton = new JButton();
        clearHistButton.setText("Clear History");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(clearHistButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        UIPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        UIPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        UIPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.VERTICAL;
        UIPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.VERTICAL;
        UIPanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.VERTICAL;
        UIPanel.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        UIPanel.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        UIPanel.add(spacer8, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        UIPanel.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        UIPanel.add(spacer10, gbc);
        exitButton = new JButton();
        exitButton.setText("Exit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        UIPanel.add(exitButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return UIPanel;
    }


}
