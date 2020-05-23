package lista6ex4;

import entities.JogoDaVelha;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author vitorg
 */
public class Lista6Ex4 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        JogoDaVelha partida = new JogoDaVelha();
        
        int flag = 1;
        int rodada = 1;
        partida.mostrar();
        do{
            
            if(flag == 1) JOptionPane.showMessageDialog(null, "Jogador: " +partida.getJogador1());
            else JOptionPane.showMessageDialog(null, "Jogador: " +partida.getJogador2());
         
            int linha = Integer.parseInt(JOptionPane.showInputDialog("Linha: "));
            int coluna = Integer.parseInt(JOptionPane.showInputDialog("Coluna: "));
            
            if(flag == 1){
                partida.setTabuleiro(linha, coluna, partida.getJogador1());
                flag = 0;
            }
            else if(flag == 0){
                partida.setTabuleiro(linha, coluna, partida.getJogador2());
                flag = 1;
            }
            
            System.out.println("Rodada: " +rodada++);
            partida.mostrar();
            System.out.println();
            
        }while(partida.vencedor() != false && partida.empate() != true);
        
        if(partida.empate() != true)
            JOptionPane.showMessageDialog(null, "Parabéns! Vencedor: Jogador "+(flag+1));
        
        sc.close();
    }
    
}
