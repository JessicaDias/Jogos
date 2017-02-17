/*
 * Gera um código em Python e salva no arquivo codigoGerado.
 */
package t3;

import java.util.HashMap;
import java.util.Map;

public class GeradorCodigo {

    private int identacao = 1;
    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    private StringBuffer codigo = new StringBuffer(); //Concatena todos as linhas de código
    private StringBuffer funcoes = new StringBuffer();
    Map<String, String> variaveis_tipo;

    public void println(String txt) {
        this.codigo.append(txt).append("\n");
    }

    public void print(String txt) {
        this.codigo.append(txt);
    }

    public void printF(String txt) {
        this.funcoes.append(txt);
    }

      public void printlnF(String txt) {
        this.funcoes.append(txt).append("\n");
    }
    
    //Limpa a string para o próximo arquivo
    public void clear() {
        this.codigo = new StringBuffer();
    }

    public String getTexto() {
        return this.codigo.toString();
    }

    public String getFuncao() {
        return this.funcoes.toString();
    }

    void Programa(codeFunParser.ProgramaContext ctx) {
        
        variaveis_tipo = new HashMap<String, String>();
        clear();
        println("#fase: " + ctx.NUM_INT().getText());
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("Global"));
        if (!ctx.corpo().getText().equals("")) {
            Corpo(ctx.corpo());
        }
        pilhaDeTabelas.desempilhar();
    }

    void Corpo(codeFunParser.CorpoContext ctx) {

        Comandos(ctx.comandos());
    }

    void Comandos(codeFunParser.ComandosContext ctx) {
        
        Cmd(ctx.cmd());
        
        if (!ctx.comandos().getText().equals("")) {
            Comandos(ctx.comandos());
        }
    }

    void Cmd(codeFunParser.CmdContext ctx) {
        //Variável identação auxilia na identação do código em Python
        if (identacao == 1 && ctx.declaracoes() == null) {
            println("");
        } else {
            for(int i = 1; i < identacao; i++)
                print("     ");
        }

        if (ctx.declaracoes() != null) {
            Declaracoes(ctx.declaracoes());
        
        } else if (ctx.IDENT() != null) { //Comando usar(magia)
            
            String id = ctx.IDENT().getText();
            int id_line = ctx.IDENT().getSymbol().getLine();
            
            if (ctx.getStart().getText().equals("usar")) {                  
                println("player.usar(" +  id + ")");
            } else {
                println(id +"(player)");
            }
            
        } else if (ctx.getStart().getText().equals("perguntar")) { //Comando perguntar (frente == agua?) { comandos }

            String t = ctx.expressao().tipo_bloco().getText();
            println("frente = atualiza_frente(player)");
            for(int i = 1; i < identacao; i++)
                print("     ");
            println("if frente == '"+ t + "':");
            if(!ctx.resultado().comandos().getText().equals("")){
                identacao += 1;
                Comandos(ctx.resultado().comandos());
                identacao -= 1;
            }
            else
                println("nada = 0"); //Quando não houver nenhum comando
        
        }
        else if (ctx.getStart().getText().equals("repetir")){ //Comando repetir(n){ }
            
            String n = ctx.repetir().NUM_INT().getText();
            
            println("for i in range(" + n + "): ");
            if(!ctx.repetir().comandos().getText().equals("")){
                identacao += 1;
                Comandos(ctx.repetir().comandos());
                identacao -= 1;
            }
            else
                println("nada = 0"); //Quando não houver nenhum comando         
        }
        else  { //player.andar() e player.virar()    
                println("player."+ctx.getText());
        }
    }

    void Declaracoes(codeFunParser.DeclaracoesContext ctx) {
        
        if (ctx.getStart().getText().equals("funcao")) { //Declaração de função
            String id = ctx.declaracoes_funcao().IDENT().getText();
            int id_line = ctx.declaracoes_funcao().IDENT().getSymbol().getLine();  
            
            println("");
            println("def " + id + "(player):"); //Parâmentro Player do código em Python
            identacao += 1;
            Comandos(ctx.declaracoes_funcao().comandos());
            identacao -= 1;
            
        } else if (ctx.getStart().getText().equals("magia")) { //Declaração de magia
            String id = ctx.declaracoes_objetos().obj_magia().IDENT().getText();
            println(id + "= ''");

        } else {
            //Atribuição do tipo da magia (agua, fogo ou ataque)
            String id = ctx.declaracoes_objetos().atribuicao().IDENT().getText();
            String at = ctx.declaracoes_objetos().atribuicao().tipo_magia().getText();
            
            println(id + "='" + at + "'");
        }
    }
}
