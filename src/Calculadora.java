import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {
    private static JFrame janela;
    private static  JLabel numero1;
    private static JLabel numero2;
    private static JTextField campoNumero1;
    private static JTextField campoNumero2;
    private static  JButton soma;
    private static JButton divisao;
    private static  JButton subtracao;
    private static JButton multiplicacao;


    public Calculadora(){
        janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        numero1 = new JLabel("Numero 1: ");
        numero2 = new JLabel("Numero 2:");
        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();

        soma = new JButton("+");
        subtracao = new JButton("-");
        divisao = new JButton("/");
        multiplicacao = new JButton("*");
        montarJanela();
        
    }

    private void montarJanela(){
        janela.setLayout(new BorderLayout());

        JPanel painel_superior = new JPanel();
        painel_superior.setLayout(new GridLayout(1,4) );
        painel_superior.add(numero1);
        painel_superior.add(campoNumero1);
        painel_superior.add(numero2);
        painel_superior.add(campoNumero2);
        janela.add(painel_superior,BorderLayout.NORTH);


        JPanel painel_inferior = new JPanel();
        painel_inferior.setLayout(new GridLayout(1,4));
        painel_inferior.add(soma);
        painel_inferior.add(subtracao);
        painel_inferior.add(multiplicacao);
        painel_inferior.add(divisao);
        soma.addActionListener(this);
        subtracao.addActionListener(this);
        divisao.addActionListener(this);
        multiplicacao.addActionListener(this);

        janela.add(painel_inferior,BorderLayout.SOUTH);

        janela.pack();//ajusta o tamanho da janela com o tamanho dos componentes;
    }



    public void exibirJanela(){
        janela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            double num1 = Double.parseDouble(campoNumero1.getText());
            double num2 = Double.parseDouble(campoNumero2.getText());
            if (e.getSource() == soma) {
                somaMetodo(num1, num2);
            }else if (e.getSource() == subtracao) {
                subtracaoMetodo(num1, num2);
            }else if (e.getSource() == multiplicacao) {
                multiplicacaoMetodo(num1, num2);
            }else if (e.getSource() == divisao) {
                divisaoMetodo(num1, num2);
            }

    }

    private void somaMetodo(double num1,double num2){
        double soma = num1 + num2;
        JOptionPane.showMessageDialog(janela,"O resultado da soma é " + soma);
    }

    private void subtracaoMetodo(double num1,double num2){
        double valor = num1 - num2;
        JOptionPane.showMessageDialog(janela,"O resultado da subtração é " + valor);
    }

    private void divisaoMetodo(double num1,double num2) {
        if (num2 != 0) {
            double valor = num1 / num2;
            JOptionPane.showMessageDialog(janela, "O resultado da divisão é " + valor);
        }else{
            JOptionPane.showMessageDialog(janela, "Impossivel realizar divisao por 0");
        }
    }

    private void multiplicacaoMetodo(double num1,double num2){
        double valor = num1 * num2;
        JOptionPane.showMessageDialog(janela,"O resultado da multiplicacao é " + valor);
    }



}
