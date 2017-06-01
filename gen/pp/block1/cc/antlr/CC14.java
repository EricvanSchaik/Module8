// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/block1/cc/antlr\CC14.g4 by ANTLR 4.7
package pp.block1.cc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CC14 extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TOKEN=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"TOKEN"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TOKEN"
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


	public CC14(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CC14.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\3X\b\1\4\2\t\2\3"+
		"\2\3\2\6\2\b\n\2\r\2\16\2\t\3\2\7\2\r\n\2\f\2\16\2\20\13\2\3\2\3\2\6\2"+
		"\24\n\2\r\2\16\2\25\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\6\2 \n\2\r"+
		"\2\16\2!\3\2\7\2%\n\2\f\2\16\2(\13\2\3\2\3\2\6\2,\n\2\r\2\16\2-\3\2\7"+
		"\2\61\n\2\f\2\16\2\64\13\2\3\2\3\2\6\28\n\2\r\2\16\29\3\2\7\2=\n\2\f\2"+
		"\16\2@\13\2\3\2\3\2\6\2D\n\2\r\2\16\2E\3\2\7\2I\n\2\f\2\16\2L\13\2\3\2"+
		"\3\2\3\2\3\2\7\2R\n\2\f\2\16\2U\13\2\5\2W\n\2\2\2\3\3\3\3\2\2\2f\2\3\3"+
		"\2\2\2\3V\3\2\2\2\5\7\7N\2\2\6\b\7c\2\2\7\6\3\2\2\2\b\t\3\2\2\2\t\7\3"+
		"\2\2\2\t\n\3\2\2\2\n\16\3\2\2\2\13\r\7\"\2\2\f\13\3\2\2\2\r\20\3\2\2\2"+
		"\16\f\3\2\2\2\16\17\3\2\2\2\17W\3\2\2\2\20\16\3\2\2\2\21\23\7N\2\2\22"+
		"\24\7c\2\2\23\22\3\2\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26"+
		"\32\3\2\2\2\27\31\7\"\2\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32"+
		"\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\37\7N\2\2\36 \7c\2\2\37\36"+
		"\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"&\3\2\2\2#%\7\"\2\2$#\3\2\2"+
		"\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'W\3\2\2\2(&\3\2\2\2)+\7N\2\2*,\7c\2"+
		"\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\62\3\2\2\2/\61\7\"\2\2\60"+
		"/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62"+
		"\3\2\2\2\65\67\7N\2\2\668\7c\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\29"+
		":\3\2\2\2:>\3\2\2\2;=\7\"\2\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2"+
		"?A\3\2\2\2@>\3\2\2\2AC\7N\2\2BD\7c\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2E"+
		"F\3\2\2\2FJ\3\2\2\2GI\7\"\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2"+
		"KM\3\2\2\2LJ\3\2\2\2MN\7N\2\2NO\7k\2\2OS\3\2\2\2PR\7\"\2\2QP\3\2\2\2R"+
		"U\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TW\3\2\2\2US\3\2\2\2V\5\3\2\2\2V\21\3\2\2"+
		"\2V)\3\2\2\2W\4\3\2\2\2\21\2\t\16\25\32!&-\629>EJSV\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}