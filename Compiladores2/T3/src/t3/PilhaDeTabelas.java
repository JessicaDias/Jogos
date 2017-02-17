/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3;
import java.util.LinkedList;
import java.util.List;

public class PilhaDeTabelas {
    private LinkedList<TabelaDeSimbolos> pilha;

    public PilhaDeTabelas() {
        pilha = new LinkedList<TabelaDeSimbolos>();
    }

    public void empilhar(TabelaDeSimbolos ts) {
        pilha.push(ts);
    }

    public TabelaDeSimbolos topo() {
        return pilha.peek();
    }

    public boolean existeSimbolo(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
            if (ts.existeSimbolo(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public String tipo(String nome) {
        for (TabelaDeSimbolos ts : pilha) {
           if (ts.existeSimbolo(nome)) {
                return ts.tipo(nome);
            }
        }
        return "sem tipo";
    }

    public void desempilhar() {
        TabelaDeSimbolos ret = pilha.pop();
        
    }

    public List getTodasTabelas() {
        return pilha;
    }
    
}
