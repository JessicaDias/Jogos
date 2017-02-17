// Generated from codeFun.g4 by ANTLR 4.5.3
package t3;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class codeFunLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "COMENTARIO", 
		"IDENT", "NUM_INT", "NUM_REAL", "ENTER", "COMENTARIO_ERRADO", "SIMBOLO_NAO_INDENTIFICADO"
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


	    public static String grupo="<<587001, 489336>>";  


	public codeFunLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "codeFun.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 45:
			COMENTARIO_ERRADO_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMENTARIO_ERRADO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 ErrosSintaticos.comentario = true;
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u0195\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3(\3(\3(\3)\3)\3*\3*\7*\u0166\n*\f*\16*\u0169\13*\3*\3*\3*\3*\3+"+
		"\3+\7+\u0171\n+\f+\16+\u0174\13+\3,\6,\u0177\n,\r,\16,\u0178\3-\6-\u017c"+
		"\n-\r-\16-\u017d\3-\3-\6-\u0182\n-\r-\16-\u0183\3.\3.\3.\3.\3/\3/\3/\7"+
		"/\u018d\n/\f/\16/\u0190\13/\3/\3/\3\60\3\60\3\u0167\2\61\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\6\5\2C\\aac|\6\2\62;C\\aac|\5\2\13"+
		"\f\17\17\"\"\4\2\f\f%%\u019a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5g\3\2\2\2\7n\3\2\2\2\tr\3\2\2\2\13"+
		"t\3\2\2\2\rz\3\2\2\2\17\u0081\3\2\2\2\21\u0084\3\2\2\2\23\u0087\3\2\2"+
		"\2\25\u0089\3\2\2\2\27\u008b\3\2\2\2\31\u0091\3\2\2\2\33\u0097\3\2\2\2"+
		"\35\u00a1\3\2\2\2\37\u00a3\3\2\2\2!\u00a5\3\2\2\2#\u00aa\3\2\2\2%\u00b2"+
		"\3\2\2\2\'\u00b8\3\2\2\2)\u00bd\3\2\2\2+\u00c3\3\2\2\2-\u00c8\3\2\2\2"+
		"/\u00d0\3\2\2\2\61\u00d7\3\2\2\2\63\u00dd\3\2\2\2\65\u00e5\3\2\2\2\67"+
		"\u00ee\3\2\2\29\u00f5\3\2\2\2;\u0106\3\2\2\2=\u0111\3\2\2\2?\u0117\3\2"+
		"\2\2A\u011e\3\2\2\2C\u012e\3\2\2\2E\u0135\3\2\2\2G\u013a\3\2\2\2I\u014b"+
		"\3\2\2\2K\u0150\3\2\2\2M\u0157\3\2\2\2O\u015e\3\2\2\2Q\u0161\3\2\2\2S"+
		"\u0163\3\2\2\2U\u016e\3\2\2\2W\u0176\3\2\2\2Y\u017b\3\2\2\2[\u0185\3\2"+
		"\2\2]\u0189\3\2\2\2_\u0193\3\2\2\2ab\7h\2\2bc\7c\2\2cd\7u\2\2de\7g\2\2"+
		"ef\7<\2\2f\4\3\2\2\2gh\7k\2\2hi\7p\2\2ij\7k\2\2jk\7e\2\2kl\7k\2\2lm\7"+
		"q\2\2m\6\3\2\2\2no\7h\2\2op\7k\2\2pq\7o\2\2q\b\3\2\2\2rs\7?\2\2s\n\3\2"+
		"\2\2tu\7o\2\2uv\7c\2\2vw\7i\2\2wx\7k\2\2xy\7c\2\2y\f\3\2\2\2z{\7h\2\2"+
		"{|\7w\2\2|}\7p\2\2}~\7e\2\2~\177\7c\2\2\177\u0080\7q\2\2\u0080\16\3\2"+
		"\2\2\u0081\u0082\7*\2\2\u0082\u0083\7+\2\2\u0083\20\3\2\2\2\u0084\u0085"+
		"\7}\2\2\u0085\u0086\7\f\2\2\u0086\22\3\2\2\2\u0087\u0088\7}\2\2\u0088"+
		"\24\3\2\2\2\u0089\u008a\7\177\2\2\u008a\26\3\2\2\2\u008b\u008c\7c\2\2"+
		"\u008c\u008d\7p\2\2\u008d\u008e\7f\2\2\u008e\u008f\7c\2\2\u008f\u0090"+
		"\7t\2\2\u0090\30\3\2\2\2\u0091\u0092\7x\2\2\u0092\u0093\7k\2\2\u0093\u0094"+
		"\7t\2\2\u0094\u0095\7c\2\2\u0095\u0096\7t\2\2\u0096\32\3\2\2\2\u0097\u0098"+
		"\7r\2\2\u0098\u0099\7g\2\2\u0099\u009a\7t\2\2\u009a\u009b\7i\2\2\u009b"+
		"\u009c\7w\2\2\u009c\u009d\7p\2\2\u009d\u009e\7v\2\2\u009e\u009f\7c\2\2"+
		"\u009f\u00a0\7t\2\2\u00a0\34\3\2\2\2\u00a1\u00a2\7*\2\2\u00a2\36\3\2\2"+
		"\2\u00a3\u00a4\7+\2\2\u00a4 \3\2\2\2\u00a5\u00a6\7w\2\2\u00a6\u00a7\7"+
		"u\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7t\2\2\u00a9\"\3\2\2\2\u00aa\u00ab"+
		"\7t\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\u00af\7v\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7t\2\2\u00b1$\3\2\2\2\u00b2"+
		"\u00b3\7i\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6\7o\2\2"+
		"\u00b6\u00b7\7c\2\2\u00b7&\3\2\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7c\2"+
		"\2\u00ba\u00bb\7x\2\2\u00bb\u00bc\7c\2\2\u00bc(\3\2\2\2\u00bd\u00be\7"+
		"r\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2"+
		"\7c\2\2\u00c2*\3\2\2\2\u00c3\u00c4\7i\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6"+
		"\7n\2\2\u00c6\u00c7\7q\2\2\u00c7,\3\2\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca"+
		"\7u\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7p\2\2\u00cd"+
		"\u00ce\7j\2\2\u00ce\u00cf\7q\2\2\u00cf.\3\2\2\2\u00d0\u00d1\7c\2\2\u00d1"+
		"\u00d2\7t\2\2\u00d2\u00d3\7x\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7t\2\2"+
		"\u00d5\u00d6\7g\2\2\u00d6\60\3\2\2\2\u00d7\u00d8\7e\2\2\u00d8\u00d9\7"+
		"c\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7z\2\2\u00db\u00dc\7c\2\2\u00dc\62"+
		"\3\2\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7k\2\2\u00e0"+
		"\u00e1\7o\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7i\2\2\u00e3\u00e4\7q\2\2"+
		"\u00e4\64\3\2\2\2\u00e5\u00e6\7h\2\2\u00e6\u00e7\7q\2\2\u00e7\u00e8\7"+
		"i\2\2\u00e8\u00e9\7w\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7k\2\2\u00eb\u00ec"+
		"\7t\2\2\u00ec\u00ed\7c\2\2\u00ed\66\3\2\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0"+
		"\7t\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7p\2\2\u00f2\u00f3\7e\2\2\u00f3"+
		"\u00f4\7q\2\2\u00f48\3\2\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7\7q\2\2\u00f7"+
		"\u00f8\7i\2\2\u00f8\u00f9\7w\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7k\2\2"+
		"\u00fb\u00fc\7t\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe\7a\2\2\u00fe\u00ff"+
		"\7c\2\2\u00ff\u0100\7r\2\2\u0100\u0101\7c\2\2\u0101\u0102\7i\2\2\u0102"+
		"\u0103\7c\2\2\u0103\u0104\7f\2\2\u0104\u0105\7c\2\2\u0105:\3\2\2\2\u0106"+
		"\u0107\7e\2\2\u0107\u0108\7j\2\2\u0108\u0109\7c\2\2\u0109\u010a\7q\2\2"+
		"\u010a\u010b\7a\2\2\u010b\u010c\7r\2\2\u010c\u010d\7g\2\2\u010d\u010e"+
		"\7f\2\2\u010e\u010f\7t\2\2\u010f\u0110\7c\2\2\u0110<\3\2\2\2\u0111\u0112"+
		"\7v\2\2\u0112\u0113\7g\2\2\u0113\u0114\7t\2\2\u0114\u0115\7t\2\2\u0115"+
		"\u0116\7c\2\2\u0116>\3\2\2\2\u0117\u0118\7e\2\2\u0118\u0119\7c\2\2\u0119"+
		"\u011a\7d\2\2\u011a\u011b\7c\2\2\u011b\u011c\7p\2\2\u011c\u011d\7c\2\2"+
		"\u011d@\3\2\2\2\u011e\u011f\7c\2\2\u011f\u0120\7t\2\2\u0120\u0121\7x\2"+
		"\2\u0121\u0122\7q\2\2\u0122\u0123\7t\2\2\u0123\u0124\7g\2\2\u0124\u0125"+
		"\7a\2\2\u0125\u0126\7s\2\2\u0126\u0127\7w\2\2\u0127\u0128\7g\2\2\u0128"+
		"\u0129\7k\2\2\u0129\u012a\7o\2\2\u012a\u012b\7c\2\2\u012b\u012c\7f\2\2"+
		"\u012c\u012d\7c\2\2\u012dB\3\2\2\2\u012e\u012f\7r\2\2\u012f\u0130\7q\2"+
		"\2\u0130\u0131\7t\2\2\u0131\u0132\7v\2\2\u0132\u0133\7c\2\2\u0133\u0134"+
		"\7n\2\2\u0134D\3\2\2\2\u0135\u0136\7c\2\2\u0136\u0137\7i\2\2\u0137\u0138"+
		"\7w\2\2\u0138\u0139\7c\2\2\u0139F\3\2\2\2\u013a\u013b\7e\2\2\u013b\u013c"+
		"\7c\2\2\u013c\u013d\7k\2\2\u013d\u013e\7z\2\2\u013e\u013f\7c\2\2\u013f"+
		"\u0140\7a\2\2\u0140\u0141\7o\2\2\u0141\u0142\7k\2\2\u0142\u0143\7u\2\2"+
		"\u0143\u0144\7v\2\2\u0144\u0145\7g\2\2\u0145\u0146\7t\2\2\u0146\u0147"+
		"\7k\2\2\u0147\u0148\7q\2\2\u0148\u0149\7u\2\2\u0149\u014a\7c\2\2\u014a"+
		"H\3\2\2\2\u014b\u014c\7h\2\2\u014c\u014d\7q\2\2\u014d\u014e\7i\2\2\u014e"+
		"\u014f\7q\2\2\u014fJ\3\2\2\2\u0150\u0151\7c\2\2\u0151\u0152\7v\2\2\u0152"+
		"\u0153\7c\2\2\u0153\u0154\7s\2\2\u0154\u0155\7w\2\2\u0155\u0156\7g\2\2"+
		"\u0156L\3\2\2\2\u0157\u0158\7h\2\2\u0158\u0159\7t\2\2\u0159\u015a\7g\2"+
		"\2\u015a\u015b\7p\2\2\u015b\u015c\7v\2\2\u015c\u015d\7g\2\2\u015dN\3\2"+
		"\2\2\u015e\u015f\7?\2\2\u015f\u0160\7?\2\2\u0160P\3\2\2\2\u0161\u0162"+
		"\7A\2\2\u0162R\3\2\2\2\u0163\u0167\7%\2\2\u0164\u0166\13\2\2\2\u0165\u0164"+
		"\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168"+
		"\u016a\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\7%\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\b*\2\2\u016dT\3\2\2\2\u016e\u0172\t\2\2\2\u016f\u0171"+
		"\t\3\2\2\u0170\u016f\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173V\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0177\4\62;\2"+
		"\u0176\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179"+
		"\3\2\2\2\u0179X\3\2\2\2\u017a\u017c\4\62;\2\u017b\u017a\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2"+
		"\2\2\u017f\u0181\7\60\2\2\u0180\u0182\4\62;\2\u0181\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184Z\3\2\2\2"+
		"\u0185\u0186\t\4\2\2\u0186\u0187\3\2\2\2\u0187\u0188\b.\2\2\u0188\\\3"+
		"\2\2\2\u0189\u018a\b/\3\2\u018a\u018e\7%\2\2\u018b\u018d\n\5\2\2\u018c"+
		"\u018b\3\2\2\2\u018d\u0190\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2"+
		"\2\2\u018f\u0191\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0192\7\f\2\2\u0192"+
		"^\3\2\2\2\u0193\u0194\13\2\2\2\u0194`\3\2\2\2\t\2\u0167\u0172\u0178\u017d"+
		"\u0183\u018e\4\b\2\2\3/\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}