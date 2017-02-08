package practice.calculator.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingView2 extends JFrame implements CalculatorView {

    private static final long serialVersionUID = -2753365007818562300L;

    private List<String> operators = initOperators();
    
    private JTextField firstNumber = new JTextField(10);
    private JButton calcOperator = new JButton("+");
    private JTextField secondNumber = new JTextField(10);
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(10);
    
    private ActionListener toggleOperator = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int currentIndex = operators.indexOf(calcOperator.getText());
            int nextIndex = (currentIndex + 1) % operators.size();
            calcOperator.setText(operators.get(nextIndex));
        }
    };
    
    SwingView2() {
        JPanel calcPanel = new JPanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        
        calcPanel.add(firstNumber);
        calcPanel.add(calcOperator);
        calcPanel.add(secondNumber);
        calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);
        
        this.add(calcPanel);
        
        calcOperator.addActionListener(toggleOperator);
        
    }
    
    private List<String> initOperators() {
        List<String> operators = new ArrayList<String>();
        operators.add("+");
        operators.add("*");
        operators.add("-");
        operators.add("/");
        return operators;
    }

    private int getFirstNumber() {
        return Integer.parseInt(firstNumber.getText());
    }
    private int getSecondNumber() {
        return Integer.parseInt(secondNumber.getText());
    }
    private String getOperator() {
        return calcOperator.getText();
    }
//    public int getCalcSolution() {
//        return Integer.parseInt(calcSolution.getText());
//    }
    
    public void setCalcSolution(String solution) {
        calcSolution.setText(solution);
    }
    
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    public void initializeDisplay() {
        this.setVisible(true);
    }
    
    /*
     * Per http://codereview.stackexchange.com/questions/43540/java-mvc-pattern...
     * Using ActionEvent and extending Controller as an ActionListener has bad smell and doesn't easily allow non
     * Swing views from working with it. This way, an event directly runs a public "changeState" method in the
     * controller.
     */
    public void setController(final CalculatorController controller) {
        calculateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.processInput();
            }
            
        });
    }

    @Override
    public String getExpression() {
        return getFirstNumber() + getOperator() + getSecondNumber();
    }
    
}
