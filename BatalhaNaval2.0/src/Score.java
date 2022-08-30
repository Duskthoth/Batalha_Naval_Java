import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Score {

    public JFrame frmScore;
    private Image icone  = new ImageIcon(this.getClass().getResource("/imagens/Icon.png")).getImage();
    public Image img3 = new ImageIcon(this.getClass().getResource("/imagens/SetaE.png")).getImage();
    public int i = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Score window = new Score();
                    window.frmScore.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    //========================METODOS=======================



    /**
     * Create the application.
     */
    public Score() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmScore = new JFrame();

        frmScore.setTitle("Ranking");
        frmScore.setBackground(Color.DARK_GRAY);
        frmScore.setBounds(100, 100, 489, 328);
        frmScore.setLocation(500,250);
        frmScore.setIconImage(icone);
        frmScore.getContentPane().setBackground(Color.darkGray);
        //frmScore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmScore.getContentPane().setLayout(null);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(Color.white);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setIcon(new ImageIcon(img3));
        btnVoltar.setFont(new Font("Space Age", Font.BOLD, 13));

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frmScore.dispose();
            }
        });
        btnVoltar.setBounds(12, 244, 114, 25);
        frmScore.getContentPane().add(btnVoltar);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setForeground(Color.white);
        lblNome.setBounds(34, 23, 66, 15);
        frmScore.getContentPane().add(lblNome);

        JLabel lblPontuao = new JLabel("Pontuação");
        lblPontuao.setForeground(Color.white);
        lblPontuao.setBounds(131, 23, 90, 15);
        frmScore.getContentPane().add(lblPontuao);

        JPanel escrita = new JPanel();
        escrita.setBounds(32, 42, 166, 168);
        escrita.setBackground(Color.DARK_GRAY);
        frmScore.getContentPane().add(escrita);
        try{

            Nomes.completarNomes();

            for(int i=0; i<10;i++) {
                if(Nomes.retornaLista(i) != null) {
                    escrita.add(Nomes.retornaLista(i));
                }
                else if(Nomes.retornaLista(0) == null){
                    throw new NullPointerException();
                }

        }}catch(NullPointerException e) {
            frmScore.setVisible(false);
            JOptionPane.showMessageDialog(null, "Nenhum jogador jogou ainda.");

        }
    }
}