import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Creditos {

    JFrame frmAlunos;
    private JButton btnVoltar;
    private Image icone  = new ImageIcon(this.getClass().getResource("/imagens/Icon.png")).getImage();


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Creditos window = new Creditos();
                    window.frmAlunos.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Creditos() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmAlunos = new JFrame();
        frmAlunos.setTitle("ALUNOS");
        frmAlunos.getContentPane().setBackground(Color.DARK_GRAY);
        frmAlunos.setBackground(Color.DARK_GRAY);
        frmAlunos.setBounds(100, 100, 489, 328);
        frmAlunos.setLocation(500,250);
        frmAlunos.setIconImage(icone);
        frmAlunos.getContentPane().setLayout(null);
        Image img = new ImageIcon(this.getClass().getResource("/imagens/Ifc.png")).getImage();

        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Space Age", Font.BOLD, 13));
        btnVoltar.setBackground(Color.DARK_GRAY);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setForeground(Color.white);
        btnVoltar.setVisible(true);
        Image img2 = new ImageIcon(this.getClass().getResource("/imagens/SetaE.png")).getImage();
        btnVoltar.setIcon(new ImageIcon(img2));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmAlunos.dispose();
            }
        });
        btnVoltar.setBounds(25, 238, 124, 36);
        frmAlunos.getContentPane().add(btnVoltar);

        JTextArea txtrAlunosAndrewBrendha = new JTextArea();
        txtrAlunosAndrewBrendha.setFont(new Font("Space Age", Font.PLAIN, 14));

        txtrAlunosAndrewBrendha.setVisible(true);
        txtrAlunosAndrewBrendha.setEditable(false);
        txtrAlunosAndrewBrendha.setForeground(Color.white);
        txtrAlunosAndrewBrendha.setText("Alunos:\n\nAndrew de Carvalho Dellamea\nBrendha Iara Gruber de Lima\nFelipe Alves Santana \n\n\nEco - 2 Semestre 2019 ");
        txtrAlunosAndrewBrendha.setBackground(Color.DARK_GRAY);
        txtrAlunosAndrewBrendha.setBounds(39, 79, 226, 136);

        frmAlunos.getContentPane().add(txtrAlunosAndrewBrendha);


        JLabel label = new JLabel("");
        frmAlunos.getContentPane().add(label);
        label.setIcon(new ImageIcon(img));
        label.setBounds(39, 12, 200, 55);
        label.setVisible(true);
    }
}