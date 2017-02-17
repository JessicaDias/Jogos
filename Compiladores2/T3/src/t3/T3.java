package t3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class T3 {

    public static void main(String args[]) throws IOException, RecognitionException, InterruptedException {

        Saida out = new Saida();
        String in = args[0];
        
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
        
        
        //ANTLRInputStream input = new ANTLRInputStream(T3.class.getResourceAsStream("codigo.txt"));
        
        codeFunLexer lexer = new codeFunLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        codeFunParser parser = new codeFunParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new T3ErrorListener(out));
        codeFunParser.ProgramaContext tree = parser.programa();

        ParseTreeWalker walker = new ParseTreeWalker();
        ParserListener extractor = new ParserListener(out);
        walker.walk(extractor, tree);

        Semantico semantico = new Semantico();
        GeradorCodigo gerador = new GeradorCodigo();

        if (out.getTexto().length() > 2) {
            System.out.println(out.getTexto());
        } else {
            semantico.Programa(tree);
            if (semantico.getTexto().length() > 2) {
                System.out.println(semantico.getTexto());
            } else {
                gerador.Programa(tree);
                try {
                    PrintWriter writer = new PrintWriter("codigoGerado.txt", "UTF-8");
                    writer.print(gerador.getTexto());
                    writer.close();
                } catch (IOException e) {
                    System.out.println("erro");
                }
                try {
                    PrintWriter writer = new PrintWriter("funcoes.py", "UTF-8");
                    writer.print(gerador.getFuncao());
                    writer.close();
                } catch (IOException e) {
                    // do something
                }
                try {
                    String cmd = "python3 join.py";
                    Process p = Runtime.getRuntime().exec(cmd);   
                    p.waitFor();
                } catch (IOException ex) {
                    System.out.println("Erro ao executar join.py");
                }
                try {
                    String cmd = "python3 codeFunGame.py";
                    Process p = Runtime.getRuntime().exec(cmd);   
                    p.waitFor();
                } catch (IOException ex) {
                    System.out.println("Erro ao executar codeFunGame.py");
                }
            }
        }
    }
}
