// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Class.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Class extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		C=1, P=2, X=3, Y=4, I=5, ID=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"C", "P", "X", "Y", "I", "ID"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "C", "P", "X", "Y", "I", "ID"
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


	public Class(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "G0.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\bM\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4.\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5?\n\5\3\6\3\6\3\6\3\6\3\6\5\6F\n\6\3\7\7\7I\n"+
		"\7\f\7\16\7L\13\7\2\2\b\3\3\5\4\7\5\t\6\13\7\r\b\3\2\2\2Q\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\17\3\2"+
		"\2\2\5!\3\2\2\2\7-\3\2\2\2\t>\3\2\2\2\13E\3\2\2\2\rJ\3\2\2\2\17\20\5\5"+
		"\3\2\20\21\7e\2\2\21\22\7n\2\2\22\23\7c\2\2\23\24\7u\2\2\24\25\7u\2\2"+
		"\25\26\3\2\2\2\26\27\5\r\7\2\27\30\5\7\4\2\30\31\5\t\5\2\31\4\3\2\2\2"+
		"\32\33\7r\2\2\33\34\7w\2\2\34\35\7d\2\2\35\36\7n\2\2\36\37\7k\2\2\37\""+
		"\7e\2\2 \"\3\2\2\2!\32\3\2\2\2! \3\2\2\2\"\6\3\2\2\2#$\7g\2\2$%\7z\2\2"+
		"%&\7v\2\2&\'\7g\2\2\'(\7p\2\2()\7f\2\2)*\7u\2\2*+\3\2\2\2+.\5\r\7\2,."+
		"\3\2\2\2-#\3\2\2\2-,\3\2\2\2.\b\3\2\2\2/\60\7k\2\2\60\61\7o\2\2\61\62"+
		"\7r\2\2\62\63\7n\2\2\63\64\7g\2\2\64\65\7o\2\2\65\66\7g\2\2\66\67\7p\2"+
		"\2\678\7v\2\289\7u\2\29:\3\2\2\2:;\5\13\6\2;<\5\r\7\2<?\3\2\2\2=?\3\2"+
		"\2\2>/\3\2\2\2>=\3\2\2\2?\n\3\2\2\2@A\5\r\7\2AB\7.\2\2BC\5\13\6\2CF\3"+
		"\2\2\2DF\3\2\2\2E@\3\2\2\2ED\3\2\2\2F\f\3\2\2\2GI\4c|\2HG\3\2\2\2IL\3"+
		"\2\2\2JH\3\2\2\2JK\3\2\2\2K\16\3\2\2\2LJ\3\2\2\2\b\2!->EJ\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}