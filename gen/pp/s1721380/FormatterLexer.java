// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Formatter.g4 by ANTLR 4.7
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
public class FormatterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ARGINDEX=2, FLAG=3, WIDTH=4, PRECISION=5, GENERAL=6, CHARACTER=7, 
		INTEGRAL=8, FLOAT=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "ARGINDEX", "FLAG", "WIDTH", "PRECISION", "GENERAL", "B", "H", 
		"S", "CHARACTER", "C", "INTEGRAL", "X", "FLOAT", "E", "G", "A"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ARGINDEX", "FLAG", "WIDTH", "PRECISION", "GENERAL", "CHARACTER", 
		"INTEGRAL", "FLOAT"
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


	public FormatterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formatter.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13a\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\4\3\4\3\5\3\5\7\5\65"+
		"\n\5\f\5\16\58\13\5\3\6\3\6\7\6<\n\6\f\6\16\6?\13\6\3\7\3\7\3\7\5\7D\n"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\5\rR\n\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\5\17Z\n\17\3\20\3\20\3\21\3\21\3\22\3\22\2\2\23\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\2\25\t\27\2\31\n\33\2\35\13\37\2"+
		"!\2#\2\3\2\f\7\2\"\"%%**-/\62\62\4\2DDdd\4\2JJjj\4\2UUuu\4\2EEee\4\2f"+
		"fqq\4\2ZZzz\4\2GGgg\4\2IIii\4\2CCcc\2a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2"+
		"\35\3\2\2\2\3%\3\2\2\2\5\'\3\2\2\2\7\60\3\2\2\2\t\62\3\2\2\2\139\3\2\2"+
		"\2\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27M\3\2"+
		"\2\2\31Q\3\2\2\2\33S\3\2\2\2\35Y\3\2\2\2\37[\3\2\2\2!]\3\2\2\2#_\3\2\2"+
		"\2%&\7\'\2\2&\4\3\2\2\2\'+\4\63;\2(*\4\62;\2)(\3\2\2\2*-\3\2\2\2+)\3\2"+
		"\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7&\2\2/\6\3\2\2\2\60\61\t\2\2\2\61"+
		"\b\3\2\2\2\62\66\4\63;\2\63\65\4\62;\2\64\63\3\2\2\2\658\3\2\2\2\66\64"+
		"\3\2\2\2\66\67\3\2\2\2\67\n\3\2\2\28\66\3\2\2\29=\7\60\2\2:<\4\62;\2;"+
		":\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\f\3\2\2\2?=\3\2\2\2@D\5\17\b"+
		"\2AD\5\21\t\2BD\5\23\n\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\16\3\2\2\2EF\t"+
		"\3\2\2F\20\3\2\2\2GH\t\4\2\2H\22\3\2\2\2IJ\t\5\2\2J\24\3\2\2\2KL\5\27"+
		"\f\2L\26\3\2\2\2MN\t\6\2\2N\30\3\2\2\2OR\t\7\2\2PR\5\33\16\2QO\3\2\2\2"+
		"QP\3\2\2\2R\32\3\2\2\2ST\t\b\2\2T\34\3\2\2\2UZ\7h\2\2VZ\5\37\20\2WZ\5"+
		"!\21\2XZ\5#\22\2YU\3\2\2\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\36\3\2\2\2["+
		"\\\t\t\2\2\\ \3\2\2\2]^\t\n\2\2^\"\3\2\2\2_`\t\13\2\2`$\3\2\2\2\t\2+\66"+
		"=CQY\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}