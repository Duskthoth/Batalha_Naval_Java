
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TelaInicial {

    //================VARIAVEIS===========

    JFrame frmBatalhaNaval;
    private Image icone  = new ImageIcon(this.getClass().getResource("/imagens/Icon.png")).getImage();



    /**frame
     * Launch the application.
     */

    //===============MAIN=================
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial window = new TelaInicial();
                    window.frmBatalhaNaval.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    //=================CONSTRUTOR===============
    public TelaInicial() {
        initialize();
    }

    //================GETS / SETS===============

    //==============METODOS==============
    private void initialize() {
        frmBatalhaNaval = new JFrame();
        frmBatalhaNaval.setFont(new Font("Space Age", Font.BOLD, 14));
        frmBatalhaNaval.setBackground(Color.DARK_GRAY);
        frmBatalhaNaval.getContentPane().setFont(new Font("Space Age", Font.PLAIN, 12));
        frmBatalhaNaval.getContentPane().setBackground(Color.GRAY);
        frmBatalhaNaval.setTitle("Batalha Naval");
        frmBatalhaNaval.setIconImage(icone);
        frmBatalhaNaval.setBounds(100, 100, 489, 328);
        frmBatalhaNaval.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBatalhaNaval.getContentPane().setLayout(null);
        frmBatalhaNaval.setLocation(500,250);


        //===============INICIA O JOGO==============
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Tela2 tela2 = new Tela2();
                tela2.tutorial.setVisible(true);

            }
        });

        JLabel lblifc = new JLabel("®️IFC - 2019");
        lblifc.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
        lblifc.setBounds(400, 261, 77, 15);
        frmBatalhaNaval.getContentPane().add(lblifc);
        btnIniciar.setFont(new Font("Space Age", Font.BOLD, 13));
        btnIniciar.setBounds(39, 44, 138, 25);
        frmBatalhaNaval.getContentPane().add(btnIniciar);

        //=============INCIA O RANKING=================
        JButton btnScore = new JButton("Ranking");
        btnScore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Score window = new Score();
                window.frmScore.setVisible(true);
            }
        });
        btnScore.setFont(new Font("Space Age", Font.BOLD, 13));
        btnScore.setBounds(39, 97, 138, 25);
        frmBatalhaNaval.getContentPane().add(btnScore);

        //=============FINALIZA O PROGRAMA===============
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSair.setFont(new Font("Space Age", Font.BOLD, 13));
        btnSair.setBounds(39, 200, 138, 25);
        frmBatalhaNaval.getContentPane().add(btnSair);


        //================MOSTRA OS CREDITOS=================
        JButton btnCreditos = new JButton("Creditos");
        btnCreditos.setFont(new Font("Space Age", Font.BOLD, 13));
        btnCreditos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Creditos creditos = new Creditos();
                creditos.frmAlunos.setVisible(true);

            }
        });
        btnCreditos.setBounds(39, 151, 138, 25);
        frmBatalhaNaval.getContentPane().add(btnCreditos);

        JLabel label = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/imagens/Fun1.jpg")).getImage();
        label.setIcon(new ImageIcon(img));
        label.setBounds(-27, -14, 516, 314);
        frmBatalhaNaval.getContentPane().add(label);

    }
}
