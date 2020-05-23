package entities;

import javax.swing.JOptionPane;

/**
 * @author vitorg
 */
public class JogoDaVelha {
    private int tabuleiro[][] = new int[3][3];
    private int jogador1;
    private int jogador2;
    
    
    public JogoDaVelha() {
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                this.tabuleiro[i][j] = 0;
        this.jogador1 = 1;
        this.jogador2 = 2;
    }
    
 
    public void setTabuleiro(int x, int y, int num) {
        while(x<0 || x>2 || y<0 || y>2 || tabuleiro[x][y] != 0){
            JOptionPane.showMessageDialog(null, "Valor ou posição inválido! Tente novamente!");
            x = Integer.parseInt(JOptionPane.showInputDialog("Linha: "));
            y = Integer.parseInt(JOptionPane.showInputDialog("Coluna: "));
        } 
       
        this.tabuleiro[x][y] = num;
    }
    public int getJogador1() {
        return jogador1;
    }
    public int getJogador2() {
        return jogador2;
    }
         
    public void mostrar(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(tabuleiro[i][j] == 1)
                    System.out.print(" "+"o"+" ");
                else if(tabuleiro[i][j] == 2)
                    System.out.print(" "+"x"+" ");
                else
                    System.out.print(" "+"-"+" ");
            }
            System.out.println();    
        }
    }
    public boolean vencedor(){
        ////TESTE DE TODAS AS LINHAS COM O CIRCULO////
        if(tabuleiro[0][0] == 1 && tabuleiro[0][1] == 1 && tabuleiro[0][2] == 1 || tabuleiro[1][0] == 1 && tabuleiro[1][1] == 1 && tabuleiro[1][2] == 1 || tabuleiro[2][0] == 1 && tabuleiro[2][1] == 1 && tabuleiro[2][2] == 1)
            return false;
     
        ////TESTE DE TODAS AS LINHAS COM O XIS////
        if(tabuleiro[0][0] == 2 && tabuleiro[0][1] == 2 && tabuleiro[0][2] == 2 || tabuleiro[1][0] == 2 && tabuleiro[1][1] == 2 && tabuleiro[1][2] == 2 || tabuleiro[2][0] == 2 && tabuleiro[2][1] == 2 && tabuleiro[2][2] == 2)
            return false;
   
        
        ////TESTE DE TODAS AS COLUNAS COM O XIS////
        if(tabuleiro[0][0] == 2 && tabuleiro[1][0] == 2 && tabuleiro[2][0] == 2 || tabuleiro[0][1] == 2 && tabuleiro[1][1] == 2 && tabuleiro[2][1] == 2 || tabuleiro[0][2] == 2 && tabuleiro[1][2] == 2 && tabuleiro[2][2] == 2)
            return false;
        
        ////TESTE DE TODAS AS COLUNAS COM O CIRCULO////
        if(tabuleiro[0][0] == 1 && tabuleiro[1][0] == 1 && tabuleiro[2][0] == 1 || tabuleiro[0][1] == 1 && tabuleiro[1][1] == 1 && tabuleiro[2][1] == 1 || tabuleiro[0][2] == 1 && tabuleiro[1][2] == 1 && tabuleiro[2][2] == 1)
            return false;
        
        ////TESTE DAS DIAGONAIS DO CIRCULO////
        if(tabuleiro[0][0] == 1 && tabuleiro[1][1] == 1 && tabuleiro[2][2] == 1)
                return false;
        if(tabuleiro[0][2] == 1 && tabuleiro[1][1] == 1 && tabuleiro[2][0] == 1)
            return false;
        
        ////TESTE DAS DIAGONAIS DO XIS////    
        if(tabuleiro[0][0] == 2 && tabuleiro[1][1] == 2 && tabuleiro[2][2] == 2)
            return false;
        if(tabuleiro[0][2] == 2 && tabuleiro[1][1] == 2 && tabuleiro[2][0] == 2)
            return false;     
        return true;
    }
    public boolean empate(){
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(tabuleiro[i][j] == 0)
                    return false;
        
        JOptionPane.showMessageDialog(null, "Empate!");
        return true;
    }
    
}
