/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package t3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class TabelaDeSimbolos {
    private String escopo;
    private List<EntradaTabelaDeSimbolos> simbolos;
    
    public TabelaDeSimbolos(String escopo) {
        simbolos = new ArrayList<EntradaTabelaDeSimbolos>();
        this.escopo = escopo;
    }
        public void adicionarSimbolo(String nome, String tipo) {
        simbolos.add(new EntradaTabelaDeSimbolos(nome,tipo));
    }
    
    public void adicionarSimbolos(List<String> nomes, String tipo) {
        for(String s:nomes) {
            simbolos.add(new EntradaTabelaDeSimbolos(s, tipo));
        }
    }
    
    public boolean existeSimbolo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
      public String tipo(String nome) {
        for(EntradaTabelaDeSimbolos etds:simbolos) {
            if(etds.getNome().equals(nome)) {
                return etds.getTipo();
            }
        }
        return "";
    }
   /* public static void imprimirTabela(SaidaParser out) {
        for (EntradaTabelaDeSimbolos etds : getInstancia().tabela) {
            out.println(etds.toString());
        }
    }
       private TabelaDeSimbolos() {
        tabela = new ArrayList<EntradaTabelaDeSimbolos>();
        this.escopo = "global";
    }
     private static TabelaDeSimbolos instancia;
     private List<EntradaTabelaDeSimbolos> tabela;
    private static TabelaDeSimbolos getInstancia() {
        if (instancia == null) {
            instancia = new TabelaDeSimbolos();
        }
        return instancia;
    }*/
    @Override
    public String toString() {
        int cont = 0;
        String ret = "Escopo: "+escopo;
        
        return ret;
    }
}