
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Tela2 extends Frame {

    public JFrame tutorial;
    private Image icone  = new ImageIcon(this.getClass().getResource("/imagens/Icon.png")).getImage();
    private Image img = new ImageIcon(this.getClass().getResource("/imagens/SetaD.png")).getImage();
    private Image img2 = new ImageIcon(this.getClass().getResource("/imagens/SetaE.png")).getImage();
    private Image img3 = new ImageIcon(this.getClass().getResource("/imagens/Icon.png")).getImage();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tela2 window = new Tela2();
                    window.tutorial.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Tela2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */



    private void initialize() {
        tutorial = new JFrame();
        tutorial.setForeground(Color.WHITE);
        tutorial.setFont(new Font("Space Age", Font.BOLD, 13));
        tutorial.setIconImage(img3);
        tutorial.setBackground(Color.DARK_GRAY);
        tutorial.getContentPane().setBackground(Color.DARK_GRAY);
        tutorial.setTitle("TUTORIAL");
        tutorial.setIconImage(icone);
        //tutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tutorial.setBounds(100, 100, 489, 328);
        tutorial.getContentPane().setLayout(null);
        tutorial.setLocation(500,250);

        JButton btnNewButton_1 = new JButton("Voltar");
        btnNewButton_1.setForeground(Color.white);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setFont(new Font("Space Age", Font.BOLD, 13));
        btnNewButton_1.setIcon(new ImageIcon(img2));
        btnNewButton_1.setBounds(26, 234, 175, 25);
        tutorial.getContentPane().add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tutorial.dispose();
            }
        });

        JLabel lblNewLabel = new JLabel("");
        Image img4 = new ImageIcon(this.getClass().getResource("/imagens/Importante.png")).getImage();
        lblNewLabel.setIcon(new ImageIcon(img4));
        lblNewLabel.setBounds(22, 12, 65, 66);
        tutorial.getContentPane().add(lblNewLabel);



        JButton btnNewButton_2 = new JButton("Continuar");
        btnNewButton_2.setForeground(Color.white);
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setContentAreaFilled(false);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setFont(new Font("Space Age", Font.BOLD, 13));
        btnNewButton_2.setIcon(new ImageIcon(img));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tutorial.dispose();
                Tabuleiro tabuleiro = new Tabuleiro();
                tabuleiro.frame.setVisible(true);

            }
        });
        btnNewButton_2.setBounds(263, 234, 175, 25);
        tutorial.getContentPane().add(btnNewButton_2);

        JTextArea txtrOObjetivo = new JTextArea();
        txtrOObjetivo.setBackground(Color.DARK_GRAY);
        txtrOObjetivo.setForeground(Color.white);
        txtrOObjetivo.setFont(new Font("Space Age", Font.PLAIN, 13));
        txtrOObjetivo.setText("O tabuleiro e 10x10\n\nO objetivo do jogo e encontrar\n as embarcacoes e afunda-las.\n\nA quantidade de jogadas \nnecessarias para encontrar\ntodas as embarcacoes definem\nsua pontuacao \n\nQuanto menos jogadas mais pontos!!");
        txtrOObjetivo.setBounds(83, 26, 372, 194);
        txtrOObjetivo.setEditable(false);
        tutorial.getContentPane().add(txtrOObjetivo);
        Image img3 = new ImageIcon(this.getClass().getResource("/imagens/Importante.png")).getImage();
    }
}
