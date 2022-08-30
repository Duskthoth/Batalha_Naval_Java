
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Tabuleiro extends JFrame implements ActionListener{


    //=================VARIAVEIS===============================
    //PUBLIC
    public Random random = new Random();
    public JFrame frame;
    public static int pontoFinal = 0;
    //PRIVATE
    //=======IMAGENS==========
    private Image icone  = new ImageIcon(this.getClass().getResource("/imagens/Icon.png")).getImage();
    private Image submarino = new ImageIcon(this.getClass().getResource("/imagens/submarino.png")).getImage();
    private Image agua  = new ImageIcon(this.getClass().getResource("/imagens/image10.png")).getImage();
    private Image explosao = new ImageIcon(this.getClass().getResource("/imagens/explosao2.png")).getImage();
    //=======VETORES===========
    private int[][] posicoes = new int[10][10];
    private JButton[][] botoes = new JButton[10][10];
    //=======RESTO============
    private int score = 0;
    private JTextField pontuacao;
    private int submarinos = 15;
    private JTextField submarinosRestantes;
    private String nome;

    //=================GETS//SETS=============
    public Image getAtingido() {
        return submarino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSubmarinos() {
        return submarinos;
    }

    public void setSubmarinos(int submarinos) {
        this.submarinos = submarinos;
    }

    public void setAtingido(Image atingido) {
        this.submarino = atingido;
    }


    public Image getImg() {
        return agua;
    }

    public void setImg(Image img) {
        this.agua = img;
    }

    public JButton[][] getBotoes() {
        return botoes;
    }

    public void setBotoes(JButton[][] botoes) {
        this.botoes = botoes;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //================METODO PARA RANKING============
    public int pontuacao(){
        return getScore();
    }
    public String nome(){
        return getNome();
    }

    //================MAIN====================
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Tabuleiro window = new Tabuleiro();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //=================CONSTRUTOR=======================
    public Tabuleiro() {
        initialize();
    }

    //=================METODO QUE INICIA A JANELA========================
    private void initialize() {

        frame = new JFrame();

        frame.setTitle("Jogo");
        frame.setBounds(100, 100, 489, 328);
        frame.setLocation(500, 250);
        frame.setBackground(Color.DARK_GRAY);
        frame.setIconImage(icone);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel jogo = new JPanel();
        jogo.setBackground(Color.DARK_GRAY);
        jogo.setBounds(20, 20, 250, 250);
        frame.getContentPane().add(jogo);
        jogo.setLayout(new GridLayout(10, 10, 1, 1));

        //=============MOSTRA O SCORE================
        JLabel lblTirosRestantes = new JLabel("Score:");
        lblTirosRestantes.setForeground(Color.white);
        lblTirosRestantes.setBackground(Color.DARK_GRAY);
        lblTirosRestantes.setBounds(323, 12, 131, 15);
        frame.getContentPane().add(lblTirosRestantes);
        //============MOSTRA O CONTADOR DE SUBMARINOS RESTANTES===========
        JLabel lblScore = new JLabel("Submarinos:");
        lblScore.setForeground(Color.white);
        lblScore.setBackground(Color.DARK_GRAY);
        lblScore.setBounds(323, 63, 141, 15);
        frame.getContentPane().add(lblScore);

        //MONTA O TABULEIRO
        for(int i = 0; i<10; i++) {
            for(int j = 0; j<10;j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].addActionListener(this);
                botoes[i][j].setVisible(true);
                jogo.add(botoes[i][j]);
                botoes[i][j].setIcon(new ImageIcon(agua));
            }
        }

        //ALOCA SUBMARINOS
        int o = 0;
        do {
            int i = random.nextInt(9);
            int j = random.nextInt(9);
            if(posicoes[i][j] == 0) {
                posicoes[i][j] = 1;
                o++;
            }
        }while(o <= 15);
    }



    //=====================RECONHECE O BOTAO PRESSIONADO=================
    @Override
    public void actionPerformed(ActionEvent e) {
        //LEGENDAS NO LADO DIREITO DA TELA
        submarinosRestantes = new JTextField();
        submarinosRestantes.setForeground(Color.white);
        submarinosRestantes.setBackground(Color.DARK_GRAY);
        submarinosRestantes.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.DARK_GRAY));
        submarinosRestantes.setBounds(323, 84, 124, 19);
        frame.getContentPane().add(submarinosRestantes);
        submarinosRestantes.setColumns(10);
        submarinosRestantes.setEditable(false);


        pontuacao = new JTextField();
        pontuacao.setForeground(Color.white);
        pontuacao.setBackground(Color.DARK_GRAY);
        pontuacao.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.DARK_GRAY));
        pontuacao.setBounds(323, 32, 124, 19);
        frame.getContentPane().add(pontuacao);
        pontuacao.setColumns(10);
        pontuacao.setEditable(false);

        //REALIZA O CALCULO DA PONTUACAO
        submarinosRestantes.setText(""+getSubmarinos());
        pontuacao.setText(""+getScore());
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                if(botoes[i][j] == e.getSource()) {
                    if((posicoes[i][j]) == 1) {
                        botoes[i][j].setIcon(new ImageIcon(submarino));
                        setScore(getScore()+200);
                        if(getSubmarinos() > 0);
                        setSubmarinos(getSubmarinos()-1);
                        posicoes[i][j] = 2;
                    }
                    else if (posicoes[i][j] == 0){
                        botoes[i][j].setIcon(new ImageIcon(explosao));
                        posicoes[i][j] = 3;
                        if(getScore() > 0 ) {
                            setScore(getScore()-15);
                        }
                        else {
                            setScore(0);
                        }
                    }

                    pontuacao.setText(""+getScore());
                    submarinosRestantes.setText(""+getSubmarinos());
                }
            }
        }
        if(getSubmarinos() == 0){
            JOptionPane.showMessageDialog(null, "Você Venceu!!!","Vitória",JOptionPane.INFORMATION_MESSAGE);
            pontoFinal = getScore();
            Nomes.rank(JOptionPane.showInputDialog("Informe seu nome:"),pontoFinal);
            Nomes.organizapontuacao();

            frame.dispose();
        }




    }
}		