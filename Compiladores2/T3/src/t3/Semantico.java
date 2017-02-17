/*
 * "Constrói" a parte semântica da linguagem.
 * Identifica os erros semanticos.
 */
package t3;

import java.util.HashMap;
import java.util.Map;

public class Semantico {

    PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    private StringBuffer erros = new StringBuffer(); //Concatena todos as linhas de código
    Map<String, String> variaveis_tipo;

    public void println(String txt) {
        this.erros.append(txt).append("\n");
    }

    public void print(String txt) {
        this.erros.append(txt);
    }

    //Limpa a string para o próximo arquivo
    public void clear() {
        this.erros = new StringBuffer();
    }

    public String getTexto() {
        return this.erros.toString();
    }

    void Programa(codeFunParser.ProgramaContext ctx) {
        clear();
        variaveis_tipo = new HashMap<String, String>();
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("Global"));
        //Verifica número da fase (1 a 5)
        if (Integer.parseInt(ctx.NUM_INT().getText()) < 1 || Integer.parseInt(ctx.NUM_INT().getText()) > 4) {
            println("[ERROR] Level " + ctx.NUM_INT() + " doesn't exist\nSet a value between 1 to 4");
        }
        else if (!ctx.corpo().getText().equals("")) {
            Corpo(ctx.corpo());
        } else { //Corpo do código não deve estar vazio (sem comandos)
            println("[ERROR] Body is empty");
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
        if (ctx.declaracoes() != null) {
            Declaracoes(ctx.declaracoes());
        }
        if (ctx.IDENT() != null) {
            String id = ctx.IDENT().getText();
            int id_line = ctx.IDENT().getSymbol().getLine();
            if (ctx.getStart().getText().equals("usar")) {
                if (!pilhaDeTabelas.existeSimbolo(id)) { //Usar magia não definida
                    println("[SEMANTIC ERROR] Line " + id_line + " : Magic " + id + " not defined");
                } else {
                    if (!variaveis_tipo.containsKey(id)) { //Usar magia que não possui tipo (atribuição)
                        println("[SEMANTIC ERROR] Line " + id_line + " : Magic " + id + " has no type");
                    }
                }
            } else if (!pilhaDeTabelas.existeSimbolo(id)) { //Chamar função não definida
                println("[SEMANTIC ERROR] Line " + id_line + " : Function " + id + " not defined");
            }
        }
        
        if (ctx.getStart().getText().equals("perguntar")) {
            if(!ctx.resultado().comandos().getText().equals(""))
                Comandos(ctx.resultado().comandos());  
        }
        if (ctx.getStart().getText().equals("repetir")) {
           if(!ctx.repetir().comandos().getText().equals(""))
            Comandos(ctx.repetir().comandos());
           else
            println("[ERROR] Repetir is empty");
        
        }
        
    }

    void Declaracoes(codeFunParser.DeclaracoesContext ctx) {
        
        if (ctx.getStart().getText().equals("magia")) {

            String id = ctx.declaracoes_objetos().obj_magia().IDENT().getText();
            int id_line = ctx.declaracoes_objetos().obj_magia().IDENT().getSymbol().getLine();
            
            if (!pilhaDeTabelas.existeSimbolo(id)) { //Coloca o identificador na pilha de tabelas
                pilhaDeTabelas.topo().adicionarSimbolo(id, "magia");
            } else { //Usar identificador já definido no mesmo escopo
                println("[SEMANTIC ERROR] Line " + id_line + " : Identifier " + id + " already defined");
            }

        } else if (ctx.getStart().getText().equals("funcao")) {

            String id = ctx.declaracoes_funcao().IDENT().getText();
            int id_line = ctx.declaracoes_funcao().IDENT().getSymbol().getLine();
            
            if (!pilhaDeTabelas.existeSimbolo(id)) { //Coloca a função na pilha de tabelas
                pilhaDeTabelas.topo().adicionarSimbolo(id, "funcao");
                pilhaDeTabelas.empilhar(new TabelaDeSimbolos(id));
                if(!ctx.declaracoes_funcao().comandos().getText().equals(""))
                Comandos(ctx.declaracoes_funcao().comandos());
                else
                println("[ERROR] Function body is empty");
                pilhaDeTabelas.desempilhar();
            } else { //Atribuir mesmo nome para funções
                println("[SEMANTIC ERROR] Line " + id_line + " : Function " + id + " already defined");
            }
        } else {
            
            String id = ctx.declaracoes_objetos().atribuicao().IDENT().getText();
            String at = ctx.declaracoes_objetos().atribuicao().tipo_magia().getText();
            int id_line = ctx.declaracoes_objetos().atribuicao().IDENT().getSymbol().getLine();
            
            if (!pilhaDeTabelas.existeSimbolo(id)) { //Atribuir um tipo a uma magia não definida
                println("[SEMANTIC ERROR] Line " + id_line + " : Magic " + id + " not defined");
            }
            else {
                if (variaveis_tipo.containsKey(id)) {
                    variaveis_tipo.remove(id);
                }
                variaveis_tipo.put(id, at);
            }
        }
    }
}
