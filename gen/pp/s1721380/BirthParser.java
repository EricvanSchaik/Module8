// Generated from C:/Users/Eric/IdeaProjects/Module8/src/pp/s1721380\Birth.g4 by ANTLR 4.7
package pp.s1721380;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BirthParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=1, LEFT=2, RIGHT=3, BEGET=4, ENTER=5, MALE=6, FEMALE=7, ID=8, WS=9;
	public static final int
		RULE_branch = 0, RULE_enter = 1, RULE_beget = 2, RULE_sex = 3;
	public static final String[] ruleNames = {
		"branch", "enter", "beget", "sex"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'['", "']'", "'beget'", "'enter'", "'male'", "'female'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMA", "LEFT", "RIGHT", "BEGET", "ENTER", "MALE", "FEMALE", "ID", 
		"WS"
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
	public String getGrammarFileName() { return "Birth.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BirthParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BranchContext extends ParserRuleContext {
		public List<EnterContext> enter() {
			return getRuleContexts(EnterContext.class);
		}
		public EnterContext enter(int i) {
			return getRuleContext(EnterContext.class,i);
		}
		public List<BegetContext> beget() {
			return getRuleContexts(BegetContext.class);
		}
		public BegetContext beget(int i) {
			return getRuleContext(BegetContext.class,i);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).enterBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).exitBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BirthVisitor ) return ((BirthVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_branch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(10);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ENTER:
					{
					setState(8);
					enter();
					}
					break;
				case LEFT:
				case ID:
					{
					setState(9);
					beget();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LEFT) | (1L << ENTER) | (1L << ID))) != 0) );
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

	public static class EnterContext extends ParserRuleContext {
		public TerminalNode ENTER() { return getToken(BirthParser.ENTER, 0); }
		public SexContext sex() {
			return getRuleContext(SexContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(BirthParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BirthParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BirthParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BirthParser.COMMA, i);
		}
		public EnterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).enterEnter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).exitEnter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BirthVisitor ) return ((BirthVisitor<? extends T>)visitor).visitEnter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnterContext enter() throws RecognitionException {
		EnterContext _localctx = new EnterContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_enter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(ENTER);
			setState(15);
			sex();
			setState(16);
			match(ID);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(17);
				match(COMMA);
				setState(18);
				match(ID);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class BegetContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(BirthParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BirthParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BirthParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BirthParser.COMMA, i);
		}
		public TerminalNode BEGET() { return getToken(BirthParser.BEGET, 0); }
		public SexContext sex() {
			return getRuleContext(SexContext.class,0);
		}
		public TerminalNode LEFT() { return getToken(BirthParser.LEFT, 0); }
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public TerminalNode RIGHT() { return getToken(BirthParser.RIGHT, 0); }
		public BegetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beget; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).enterBeget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).exitBeget(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BirthVisitor ) return ((BirthVisitor<? extends T>)visitor).visitBeget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BegetContext beget() throws RecognitionException {
		BegetContext _localctx = new BegetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_beget);
		int _la;
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				match(ID);
				setState(25);
				match(COMMA);
				setState(26);
				match(ID);
				setState(27);
				match(BEGET);
				setState(28);
				sex();
				setState(29);
				match(ID);
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(30);
					match(COMMA);
					setState(31);
					match(ID);
					}
					}
					setState(36);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(LEFT);
				setState(38);
				branch();
				setState(39);
				match(RIGHT);
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

	public static class SexContext extends ParserRuleContext {
		public TerminalNode MALE() { return getToken(BirthParser.MALE, 0); }
		public TerminalNode FEMALE() { return getToken(BirthParser.FEMALE, 0); }
		public SexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).enterSex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BirthListener ) ((BirthListener)listener).exitSex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BirthVisitor ) return ((BirthVisitor<? extends T>)visitor).visitSex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexContext sex() throws RecognitionException {
		SexContext _localctx = new SexContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !(_la==MALE || _la==FEMALE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\60\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\6\2\r\n\2\r\2\16\2\16\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\26\n\3\f\3\16\3\31\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4#\n\4"+
		"\f\4\16\4&\13\4\3\4\3\4\3\4\3\4\5\4,\n\4\3\5\3\5\3\5\2\2\6\2\4\6\b\2\3"+
		"\3\2\b\t\2\60\2\f\3\2\2\2\4\20\3\2\2\2\6+\3\2\2\2\b-\3\2\2\2\n\r\5\4\3"+
		"\2\13\r\5\6\4\2\f\n\3\2\2\2\f\13\3\2\2\2\r\16\3\2\2\2\16\f\3\2\2\2\16"+
		"\17\3\2\2\2\17\3\3\2\2\2\20\21\7\7\2\2\21\22\5\b\5\2\22\27\7\n\2\2\23"+
		"\24\7\3\2\2\24\26\7\n\2\2\25\23\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27"+
		"\30\3\2\2\2\30\5\3\2\2\2\31\27\3\2\2\2\32\33\7\n\2\2\33\34\7\3\2\2\34"+
		"\35\7\n\2\2\35\36\7\6\2\2\36\37\5\b\5\2\37$\7\n\2\2 !\7\3\2\2!#\7\n\2"+
		"\2\" \3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%,\3\2\2\2&$\3\2\2\2\'(\7"+
		"\4\2\2()\5\2\2\2)*\7\5\2\2*,\3\2\2\2+\32\3\2\2\2+\'\3\2\2\2,\7\3\2\2\2"+
		"-.\t\2\2\2.\t\3\2\2\2\7\f\16\27$+";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}