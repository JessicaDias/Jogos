
package t3;

public class Saida {
    private static StringBuffer texto = new StringBuffer();
    boolean modificado;
    
    public void println(String txt) {
        if(!modificado && !txt.equals("")) modificado = true;
        
        
        texto.append(txt).append("\n");
    }
    
    public static void clear() {
        texto = new StringBuffer();
    }
    
    public static String getTexto() {
        return texto.toString();
    }
    public boolean isModificado() {
        return modificado;
    }
}