package calculadora;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] btnNumeros;
    private JButton btnSuma, btnResta, btnMulti, btnDiv, btnIgual, btnC;
    private int n1, result;
    private String oper="";
    private boolean nuevoNum =true;
  
    public Calculadora(){
        setTitle("Mi calculadora");
        setSize(390, 460);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        //Campo de texto
        display = new JTextField();
        display.setEditable(false);
        display.setBounds(15, 10, 345, 50);
        display.setBackground(Color.WHITE);
        add(display);

        //Botones números
        btnNumeros = new JButton[10];
        for (int i=0; i<10; i++) {
            btnNumeros[i] = new JButton(String.valueOf(i));
            btnNumeros[i].addActionListener(this);
            btnNumeros[i].setBackground(Color.WHITE);
        }
        
        btnNumeros[0].setBounds(103, 325, 80, 80);
        btnNumeros[1].setBounds(15, 70, 80, 80);
        btnNumeros[2].setBounds(103, 70, 80, 80);
        btnNumeros[3].setBounds(191, 70, 80, 80);
        btnNumeros[4].setBounds(15, 155, 80, 80);
        btnNumeros[5].setBounds(103, 155, 80, 80);
        btnNumeros[6].setBounds(191, 155, 80, 80);
        btnNumeros[7].setBounds(15, 240, 80, 80);
        btnNumeros[8].setBounds(103, 240, 80, 80);
        btnNumeros[9].setBounds(191, 240, 80, 80);
        
        //Botones operaciones
        btnSuma = new JButton("+");
        btnSuma.setBounds(278, 70, 80, 80);
        
        btnResta = new JButton("-");
        btnResta.setBounds(278, 155, 80, 80);
        
        btnMulti = new JButton("*");
        btnMulti.setBounds(278, 240, 80, 80);
        
        btnDiv = new JButton("/");
        btnDiv.setBounds(278, 325, 80, 80);
        
        btnIgual = new JButton("=");
        btnIgual.setBounds(191, 325, 80, 80);
        
        btnC = new JButton("C");
        btnC.setBounds(15, 325, 80, 80);
        
        JButton[] operaciones = {btnSuma, btnResta, btnMulti, btnDiv, btnIgual, btnC};
        for (JButton boton : operaciones) {
            boton.addActionListener(this);
            boton.setBackground(Color.WHITE);
        }
        
        //Orden de los botones
        add(btnSuma);
        add(btnResta);
        add(btnMulti);
        add(btnDiv);
        add(btnNumeros[3]);
        add(btnNumeros[6]);
        add(btnNumeros[9]);
        add(btnIgual);
        add(btnNumeros[2]);
        add(btnNumeros[5]);
        add(btnNumeros[8]);
        add(btnNumeros[0]);
        add(btnNumeros[1]);
        add(btnNumeros[4]);
        add(btnNumeros[7]);
        add(btnC);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object opt = e.getSource();
        for (int i=0; i<10; i++){
            if (opt == btnNumeros[i]){
                if (nuevoNum) {
                    display.setText("");
                    nuevoNum = false;
                }
                display.setText(display.getText()+i);
                return;
            }
        }
        
        if (opt == btnSuma || opt == btnResta || opt == btnMulti|| opt == btnDiv) {
            n1 = Integer.parseInt(display.getText());
            oper = ((JButton)opt).getText();
            display.setText(display.getText() + " " + oper + " ");
            nuevoNum = true;
            return;
        }
        
        if (opt == btnIgual){
            int n2 = Integer.parseInt(display.getText());
            switch (oper){
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    result = n2 != 0 ? n1 / n2 : 0;
                    break;
            }
            
            display.setText(String.valueOf(result));
            nuevoNum = true;
        }else if (opt==btnC){
            display.setText("");
            oper = "";
            n1 = result = 0;
            nuevoNum = true;
        }
    }
    
    public static void main(String[] args) {
         new Calculadora();
    }
}