package practice.calculator.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingView extends JFrame implements CalculatorView {

    private static final long serialVersionUID = -2753365007818562300L;
    
    private JTextField expression = new JTextField(30);
    private JButton calculateButton = new JButton("Calculate");
    private JTextField calcSolution = new JTextField(30);
    
    SwingView() {
        JPanel calcPanel = new JPanel();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        
        calcPanel.add(expression);
        calcPanel.add(calculateButton);
        calcPanel.add(calcSolution);
        
        this.add(calcPanel);
        
    }
    
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
        return expression.getText();
    }
    
}
