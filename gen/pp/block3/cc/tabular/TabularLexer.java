// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/block3/cc/tabular\Tabular.g4 by ANTLR 4.7
package pp.block3.cc.tabular;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TabularLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, TEXT=3, WS=4, COMMENT=5, BEGIN=6, END=7, ARGUMENT=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "TEXT", "WS", "COMMENT", "BEGIN", "END", "ARGUMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'&'", "'\\\\'", null, null, null, null, "'\\end{tabular}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "TEXT", "WS", "COMMENT", "BEGIN", "END", "ARGUMENT"
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


	public TabularLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tabular.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\ni\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\6\4\32\n\4\r\4\16\4\33\3\4\6\4\37\n\4\r\4\16\4 \3\4\6\4$\n\4"+
		"\r\4\16\4%\3\4\6\4)\n\4\r\4\16\4*\5\4-\n\4\3\5\6\5\60\n\5\r\5\16\5\61"+
		"\3\5\3\5\3\6\3\6\7\68\n\6\f\6\16\6;\13\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7S\n\7\f"+
		"\7\16\7V\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\6\n\2\13"+
		"\f\17\17\"\"%(^^`a}}\177\u0080\5\2\13\f\17\17\"\"\3\2\f\f\5\2eenntt\2"+
		"p\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\25\3\2\2\2\7,\3\2\2\2\t"+
		"/\3\2\2\2\13\65\3\2\2\2\r@\3\2\2\2\17Y\3\2\2\2\21g\3\2\2\2\23\24\7(\2"+
		"\2\24\4\3\2\2\2\25\26\7^\2\2\26\27\7^\2\2\27\6\3\2\2\2\30\32\n\2\2\2\31"+
		"\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35"+
		"\37\5\t\5\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2"+
		"\"$\n\2\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&-\3\2\2\2\')\n\2"+
		"\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,\31\3\2\2\2,("+
		"\3\2\2\2-\b\3\2\2\2.\60\t\3\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61"+
		"\62\3\2\2\2\62\63\3\2\2\2\63\64\b\5\2\2\64\n\3\2\2\2\659\7\'\2\2\668\n"+
		"\4\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2"+
		"\2<=\7\f\2\2=>\3\2\2\2>?\b\6\2\2?\f\3\2\2\2@A\7^\2\2AB\7d\2\2BC\7g\2\2"+
		"CD\7i\2\2DE\7k\2\2EF\7p\2\2FG\7}\2\2GH\7v\2\2HI\7c\2\2IJ\7d\2\2JK\7w\2"+
		"\2KL\7n\2\2LM\7c\2\2MN\7t\2\2NO\7\177\2\2OP\7}\2\2PT\3\2\2\2QS\5\21\t"+
		"\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\177"+
		"\2\2X\16\3\2\2\2YZ\7^\2\2Z[\7g\2\2[\\\7p\2\2\\]\7f\2\2]^\7}\2\2^_\7v\2"+
		"\2_`\7c\2\2`a\7d\2\2ab\7w\2\2bc\7n\2\2cd\7c\2\2de\7t\2\2ef\7\177\2\2f"+
		"\20\3\2\2\2gh\t\5\2\2h\22\3\2\2\2\13\2\33 %*,\619T\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}