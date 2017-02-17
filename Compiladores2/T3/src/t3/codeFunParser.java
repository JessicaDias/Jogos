// Generated from codeFun.g4 by ANTLR 4.5.3
package t3;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class codeFunParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, COMENTARIO=41, IDENT=42, NUM_INT=43, NUM_REAL=44, 
		ENTER=45, COMENTARIO_ERRADO=46, SIMBOLO_NAO_INDENTIFICADO=47;
	public static final int
		RULE_programa = 0, RULE_corpo = 1, RULE_declaracoes_objetos = 2, RULE_atribuicao = 3, 
		RULE_obj_magia = 4, RULE_declaracoes_funcao = 5, RULE_declaracoes = 6, 
		RULE_comandos = 7, RULE_cmd = 8, RULE_repetir = 9, RULE_tipo = 10, RULE_tipo_bloco = 11, 
		RULE_tipo_magia = 12, RULE_expressao = 13, RULE_resultado = 14;
	public static final String[] ruleNames = {
		"programa", "corpo", "declaracoes_objetos", "atribuicao", "obj_magia", 
		"declaracoes_funcao", "declaracoes", "comandos", "cmd", "repetir", "tipo", 
		"tipo_bloco", "tipo_magia", "expressao", "resultado"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fase:'", "'inicio'", "'fim'", "'='", "'magia'", "'funcao'", "'()'", 
		"'{\n'", "'{'", "'}'", "'andar'", "'virar'", "'perguntar'", "'('", "')'", 
		"'usar'", "'repetir'", "'grama'", "'lava'", "'pedra'", "'gelo'", "'espinho'", 
		"'arvore'", "'caixa'", "'inimigo'", "'fogueira'", "'tronco'", "'fogueira_apagada'", 
		"'chao_pedra'", "'terra'", "'cabana'", "'arvore_queimada'", "'portal'", 
		"'agua'", "'caixa_misteriosa'", "'fogo'", "'ataque'", "'frente'", "'=='", 
		"'?'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "COMENTARIO", "IDENT", "NUM_INT", "NUM_REAL", 
		"ENTER", "COMENTARIO_ERRADO", "SIMBOLO_NAO_INDENTIFICADO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "codeFun.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public static String grupo="<<587001, 489336>>";  

	public codeFunParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(codeFunParser.NUM_INT, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			match(NUM_INT);
			setState(32);
			match(T__1);
			setState(33);
			corpo();
			setState(34);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorpoContext extends ParserRuleContext {
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitCorpo(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_corpo);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				comandos();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracoes_objetosContext extends ParserRuleContext {
		public Obj_magiaContext obj_magia() {
			return getRuleContext(Obj_magiaContext.class,0);
		}
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public Declaracoes_objetosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes_objetos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterDeclaracoes_objetos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitDeclaracoes_objetos(this);
		}
	}

	public final Declaracoes_objetosContext declaracoes_objetos() throws RecognitionException {
		Declaracoes_objetosContext _localctx = new Declaracoes_objetosContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracoes_objetos);
		try {
			setState(42);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				obj_magia();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				atribuicao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(codeFunParser.IDENT, 0); }
		public Tipo_magiaContext tipo_magia() {
			return getRuleContext(Tipo_magiaContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitAtribuicao(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(IDENT);
			setState(45);
			match(T__3);
			setState(46);
			tipo_magia();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Obj_magiaContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(codeFunParser.IDENT, 0); }
		public Obj_magiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj_magia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterObj_magia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitObj_magia(this);
		}
	}

	public final Obj_magiaContext obj_magia() throws RecognitionException {
		Obj_magiaContext _localctx = new Obj_magiaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_obj_magia);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__4);
			setState(49);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracoes_funcaoContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(codeFunParser.IDENT, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Declaracoes_funcaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterDeclaracoes_funcao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitDeclaracoes_funcao(this);
		}
	}

	public final Declaracoes_funcaoContext declaracoes_funcao() throws RecognitionException {
		Declaracoes_funcaoContext _localctx = new Declaracoes_funcaoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracoes_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__5);
			setState(52);
			match(IDENT);
			setState(53);
			match(T__6);
			setState(54);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(55);
			comandos();
			setState(56);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesContext extends ParserRuleContext {
		public Declaracoes_objetosContext declaracoes_objetos() {
			return getRuleContext(Declaracoes_objetosContext.class,0);
		}
		public Declaracoes_funcaoContext declaracoes_funcao() {
			return getRuleContext(Declaracoes_funcaoContext.class,0);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitDeclaracoes(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracoes);
		try {
			setState(60);
			switch (_input.LA(1)) {
			case T__4:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				declaracoes_objetos();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				declaracoes_funcao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosContext extends ParserRuleContext {
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitComandos(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comandos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << IDENT))) != 0)) {
				{
				setState(62);
				cmd();
				setState(63);
				comandos();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ResultadoContext resultado() {
			return getRuleContext(ResultadoContext.class,0);
		}
		public RepetirContext repetir() {
			return getRuleContext(RepetirContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(codeFunParser.IDENT, 0); }
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(T__10);
				setState(68);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(T__11);
				setState(70);
				match(T__6);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(T__12);
				setState(72);
				match(T__13);
				setState(73);
				expressao();
				setState(74);
				match(T__14);
				setState(75);
				resultado();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				repetir();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(IDENT);
				setState(79);
				match(T__6);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				match(T__15);
				setState(81);
				match(T__13);
				setState(82);
				match(IDENT);
				setState(83);
				match(T__14);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(84);
				declaracoes();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepetirContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(codeFunParser.NUM_INT, 0); }
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public RepetirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterRepetir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitRepetir(this);
		}
	}

	public final RepetirContext repetir() throws RecognitionException {
		RepetirContext _localctx = new RepetirContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_repetir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__16);
			setState(88);
			match(T__13);
			setState(89);
			match(NUM_INT);
			setState(90);
			match(T__14);
			setState(91);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(92);
			comandos();
			setState(93);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public Tipo_blocoContext tipo_bloco() {
			return getRuleContext(Tipo_blocoContext.class,0);
		}
		public Tipo_magiaContext tipo_magia() {
			return getRuleContext(Tipo_magiaContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				tipo_bloco();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				tipo_magia();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_blocoContext extends ParserRuleContext {
		public Tipo_blocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterTipo_bloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitTipo_bloco(this);
		}
	}

	public final Tipo_blocoContext tipo_bloco() throws RecognitionException {
		Tipo_blocoContext _localctx = new Tipo_blocoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tipo_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_magiaContext extends ParserRuleContext {
		public Tipo_magiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_magia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterTipo_magia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitTipo_magia(this);
		}
	}

	public final Tipo_magiaContext tipo_magia() throws RecognitionException {
		Tipo_magiaContext _localctx = new Tipo_magiaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tipo_magia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__33) | (1L << T__35) | (1L << T__36))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public Tipo_blocoContext tipo_bloco() {
			return getRuleContext(Tipo_blocoContext.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expressao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__37);
			setState(104);
			match(T__38);
			setState(105);
			tipo_bloco();
			setState(106);
			match(T__39);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultadoContext extends ParserRuleContext {
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public ResultadoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultado; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).enterResultado(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof codeFunListener ) ((codeFunListener)listener).exitResultado(this);
		}
	}

	public final ResultadoContext resultado() throws RecognitionException {
		ResultadoContext _localctx = new ResultadoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_resultado);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__8) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(109);
			comandos();
			setState(110);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61s\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\5\3)\n\3\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\5\b?\n\b\3\t\3\t\3\t\5\tD\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nX\n\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\5\fd\n\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\2\2\21\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36\2\5\3\2\n\13\3\2\24%\4\2$$&\'n\2 \3\2\2"+
		"\2\4(\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n\62\3\2\2\2\f\65\3\2\2\2\16>\3\2"+
		"\2\2\20C\3\2\2\2\22W\3\2\2\2\24Y\3\2\2\2\26c\3\2\2\2\30e\3\2\2\2\32g\3"+
		"\2\2\2\34i\3\2\2\2\36n\3\2\2\2 !\7\3\2\2!\"\7-\2\2\"#\7\4\2\2#$\5\4\3"+
		"\2$%\7\5\2\2%\3\3\2\2\2&)\5\20\t\2\')\3\2\2\2(&\3\2\2\2(\'\3\2\2\2)\5"+
		"\3\2\2\2*-\5\n\6\2+-\5\b\5\2,*\3\2\2\2,+\3\2\2\2-\7\3\2\2\2./\7,\2\2/"+
		"\60\7\6\2\2\60\61\5\32\16\2\61\t\3\2\2\2\62\63\7\7\2\2\63\64\7,\2\2\64"+
		"\13\3\2\2\2\65\66\7\b\2\2\66\67\7,\2\2\678\7\t\2\289\t\2\2\29:\5\20\t"+
		"\2:;\7\f\2\2;\r\3\2\2\2<?\5\6\4\2=?\5\f\7\2><\3\2\2\2>=\3\2\2\2?\17\3"+
		"\2\2\2@A\5\22\n\2AB\5\20\t\2BD\3\2\2\2C@\3\2\2\2CD\3\2\2\2D\21\3\2\2\2"+
		"EF\7\r\2\2FX\7\t\2\2GH\7\16\2\2HX\7\t\2\2IJ\7\17\2\2JK\7\20\2\2KL\5\34"+
		"\17\2LM\7\21\2\2MN\5\36\20\2NX\3\2\2\2OX\5\24\13\2PQ\7,\2\2QX\7\t\2\2"+
		"RS\7\22\2\2ST\7\20\2\2TU\7,\2\2UX\7\21\2\2VX\5\16\b\2WE\3\2\2\2WG\3\2"+
		"\2\2WI\3\2\2\2WO\3\2\2\2WP\3\2\2\2WR\3\2\2\2WV\3\2\2\2X\23\3\2\2\2YZ\7"+
		"\23\2\2Z[\7\20\2\2[\\\7-\2\2\\]\7\21\2\2]^\t\2\2\2^_\5\20\t\2_`\7\f\2"+
		"\2`\25\3\2\2\2ad\5\30\r\2bd\5\32\16\2ca\3\2\2\2cb\3\2\2\2d\27\3\2\2\2"+
		"ef\t\3\2\2f\31\3\2\2\2gh\t\4\2\2h\33\3\2\2\2ij\7(\2\2jk\7)\2\2kl\5\30"+
		"\r\2lm\7*\2\2m\35\3\2\2\2no\t\2\2\2op\5\20\t\2pq\7\f\2\2q\37\3\2\2\2\b"+
		"(,>CWc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}