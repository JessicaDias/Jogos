// Generated from codeFun.g4 by ANTLR 4.5.3
package t3;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link codeFunParser}.
 */
public interface codeFunListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link codeFunParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(codeFunParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(codeFunParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(codeFunParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(codeFunParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#declaracoes_objetos}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes_objetos(codeFunParser.Declaracoes_objetosContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#declaracoes_objetos}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes_objetos(codeFunParser.Declaracoes_objetosContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(codeFunParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(codeFunParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#obj_magia}.
	 * @param ctx the parse tree
	 */
	void enterObj_magia(codeFunParser.Obj_magiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#obj_magia}.
	 * @param ctx the parse tree
	 */
	void exitObj_magia(codeFunParser.Obj_magiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#declaracoes_funcao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes_funcao(codeFunParser.Declaracoes_funcaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#declaracoes_funcao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes_funcao(codeFunParser.Declaracoes_funcaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(codeFunParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(codeFunParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(codeFunParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(codeFunParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(codeFunParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(codeFunParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#repetir}.
	 * @param ctx the parse tree
	 */
	void enterRepetir(codeFunParser.RepetirContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#repetir}.
	 * @param ctx the parse tree
	 */
	void exitRepetir(codeFunParser.RepetirContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(codeFunParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(codeFunParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#tipo_bloco}.
	 * @param ctx the parse tree
	 */
	void enterTipo_bloco(codeFunParser.Tipo_blocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#tipo_bloco}.
	 * @param ctx the parse tree
	 */
	void exitTipo_bloco(codeFunParser.Tipo_blocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#tipo_magia}.
	 * @param ctx the parse tree
	 */
	void enterTipo_magia(codeFunParser.Tipo_magiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#tipo_magia}.
	 * @param ctx the parse tree
	 */
	void exitTipo_magia(codeFunParser.Tipo_magiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(codeFunParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(codeFunParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link codeFunParser#resultado}.
	 * @param ctx the parse tree
	 */
	void enterResultado(codeFunParser.ResultadoContext ctx);
	/**
	 * Exit a parse tree produced by {@link codeFunParser#resultado}.
	 * @param ctx the parse tree
	 */
	void exitResultado(codeFunParser.ResultadoContext ctx);
}