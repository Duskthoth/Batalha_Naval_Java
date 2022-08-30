import javax.swing.*;
import java.awt.*;

public class Nomes {
    public static String[] nomes = new String[10];
    public static int[] pontuacao = new int[10];
    public static JLabel[] grade = new JLabel[10];
    public static int i = 0;

    public static void rank(String nome, int ponto){

        if(nomes[i] == null){
            nomes[i] = nome;
            pontuacao[i] = ponto;
            i++;
        }
    }


    public static void organizapontuacao() {
        int aux;
        String nome;
        for(int i = 0;i<10;i++) {
            for(int j=i+1;j<10;j++) {
                if(nomes[i] != null){
                    if(pontuacao[i] < pontuacao[j]) {
                        aux = pontuacao[i];
                        nome = nomes[i];
                        pontuacao[i] = pontuacao[j];
                        nomes[i] = nomes[j];
                        pontuacao[j] = aux;
                        nomes[j] = nome;
                    }
                }

            }
        }
    }


    public static void completarNomes() {
        for(int i = 0;i<10;i++){
            if(nomes[i] != null) {
                grade[i] = new JLabel();
                grade[i].setForeground(Color.white);
                grade[i].setBackground(Color.DARK_GRAY);
                grade[i].setText(nomes[i] + "                   " + pontuacao[i]+"\n");
                grade[i].setVisible(true);
            }
        }
    }


    public static JLabel retornaLista(int i){
        return grade[i];
    }

    }


