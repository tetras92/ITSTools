/*
* generated by Xtext
*/

package fr.lip6.move.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class GALGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class SystemElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "System");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSystemKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cVariablesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cVariablesVariableDeclarationParserRuleCall_3_0 = (RuleCall)cVariablesAssignment_3.eContents().get(0);
		private final Assignment cTransitionsAssignment_4 = (Assignment)cGroup.eContents().get(4);
		private final RuleCall cTransitionsTRANSITIONParserRuleCall_4_0 = (RuleCall)cTransitionsAssignment_4.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_5 = (Keyword)cGroup.eContents().get(5);
		
		//System:
		//	("System" name=ID "{" variables+=VariableDeclaration* transitions+=TRANSITION+ "}")?;
		public ParserRule getRule() { return rule; }

		//("System" name=ID "{" variables+=VariableDeclaration* transitions+=TRANSITION+ "}")?
		public Group getGroup() { return cGroup; }

		//"System"
		public Keyword getSystemKeyword_0() { return cSystemKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//variables+=VariableDeclaration*
		public Assignment getVariablesAssignment_3() { return cVariablesAssignment_3; }

		//VariableDeclaration
		public RuleCall getVariablesVariableDeclarationParserRuleCall_3_0() { return cVariablesVariableDeclarationParserRuleCall_3_0; }

		//transitions+=TRANSITION+
		public Assignment getTransitionsAssignment_4() { return cTransitionsAssignment_4; }

		//TRANSITION
		public RuleCall getTransitionsTRANSITIONParserRuleCall_4_0() { return cTransitionsTRANSITIONParserRuleCall_4_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_5() { return cRightCurlyBracketKeyword_5; }
	}

	public class VariableDeclarationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VariableDeclaration");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cInitValAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cInitValINTTerminalRuleCall_2_0 = (RuleCall)cInitValAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//VariableDeclaration returns Variable:
		//	name=ID "=" initVal=INT ";";
		public ParserRule getRule() { return rule; }

		//name=ID "=" initVal=INT ";"
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//initVal=INT
		public Assignment getInitValAssignment_2() { return cInitValAssignment_2; }

		//INT
		public RuleCall getInitValINTTerminalRuleCall_2_0() { return cInitValINTTerminalRuleCall_2_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}

	public class TRANSITIONElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TRANSITION");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cTransitionKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Keyword cTRUEKeyword_3 = (Keyword)cGroup.eContents().get(3);
		private final Keyword cRightSquareBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Keyword cLabelKeyword_5_0 = (Keyword)cGroup_5.eContents().get(0);
		private final Assignment cLabelAssignment_5_1 = (Assignment)cGroup_5.eContents().get(1);
		private final RuleCall cLabelSTRINGTerminalRuleCall_5_1_0 = (RuleCall)cLabelAssignment_5_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		private final Assignment cAssignmentsAssignment_7 = (Assignment)cGroup.eContents().get(7);
		private final RuleCall cAssignmentsAssignmentParserRuleCall_7_0 = (RuleCall)cAssignmentsAssignment_7.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_8 = (Keyword)cGroup.eContents().get(8);
		
		//TRANSITION:
		//	"transition" name=ID "[" "TRUE" "]" ("label" label=STRING)? "{" assignments+=Assignment+ "}";
		public ParserRule getRule() { return rule; }

		//"transition" name=ID "[" "TRUE" "]" ("label" label=STRING)? "{" assignments+=Assignment+ "}"
		public Group getGroup() { return cGroup; }

		//"transition"
		public Keyword getTransitionKeyword_0() { return cTransitionKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2() { return cLeftSquareBracketKeyword_2; }

		//"TRUE"
		public Keyword getTRUEKeyword_3() { return cTRUEKeyword_3; }

		//"]"
		public Keyword getRightSquareBracketKeyword_4() { return cRightSquareBracketKeyword_4; }

		//("label" label=STRING)?
		public Group getGroup_5() { return cGroup_5; }

		//"label"
		public Keyword getLabelKeyword_5_0() { return cLabelKeyword_5_0; }

		//label=STRING
		public Assignment getLabelAssignment_5_1() { return cLabelAssignment_5_1; }

		//STRING
		public RuleCall getLabelSTRINGTerminalRuleCall_5_1_0() { return cLabelSTRINGTerminalRuleCall_5_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_6() { return cLeftCurlyBracketKeyword_6; }

		//assignments+=Assignment+
		public Assignment getAssignmentsAssignment_7() { return cAssignmentsAssignment_7; }

		//Assignment
		public RuleCall getAssignmentsAssignmentParserRuleCall_7_0() { return cAssignmentsAssignmentParserRuleCall_7_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_8() { return cRightCurlyBracketKeyword_8; }
	}

	public class ConstanteElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Constante");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueINTTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//Constante:
		//	value=INT;
		public ParserRule getRule() { return rule; }

		//value=INT
		public Assignment getValueAssignment() { return cValueAssignment; }

		//INT
		public RuleCall getValueINTTerminalRuleCall_0() { return cValueINTTerminalRuleCall_0; }
	}

	public class MultiplicationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Multiplication");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cPrimaryParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cMultiplicationLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cAsteriskKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightPrimaryParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Multiplication returns Expression:
		//	Primary ({Multiplication.left=current} "*" right=Primary)*;
		public ParserRule getRule() { return rule; }

		//Primary ({Multiplication.left=current} "*" right=Primary)*
		public Group getGroup() { return cGroup; }

		//Primary
		public RuleCall getPrimaryParserRuleCall_0() { return cPrimaryParserRuleCall_0; }

		//({Multiplication.left=current} "*" right=Primary)*
		public Group getGroup_1() { return cGroup_1; }

		//{Multiplication.left=current}
		public Action getMultiplicationLeftAction_1_0() { return cMultiplicationLeftAction_1_0; }

		//"*"
		public Keyword getAsteriskKeyword_1_1() { return cAsteriskKeyword_1_1; }

		//right=Primary
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//Primary
		public RuleCall getRightPrimaryParserRuleCall_1_2_0() { return cRightPrimaryParserRuleCall_1_2_0; }
	}

	public class PrimaryElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Primary");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cVariableRefParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cConstanteParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final Group cGroup_2 = (Group)cAlternatives.eContents().get(2);
		private final Keyword cLeftParenthesisKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final RuleCall cAdditionParserRuleCall_2_1 = (RuleCall)cGroup_2.eContents().get(1);
		private final Keyword cRightParenthesisKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		
		//Primary returns Expression:
		//	VariableRef | Constante | "(" Addition ")";
		public ParserRule getRule() { return rule; }

		//VariableRef | Constante | "(" Addition ")"
		public Alternatives getAlternatives() { return cAlternatives; }

		//VariableRef
		public RuleCall getVariableRefParserRuleCall_0() { return cVariableRefParserRuleCall_0; }

		//Constante
		public RuleCall getConstanteParserRuleCall_1() { return cConstanteParserRuleCall_1; }

		//"(" Addition ")"
		public Group getGroup_2() { return cGroup_2; }

		//"("
		public Keyword getLeftParenthesisKeyword_2_0() { return cLeftParenthesisKeyword_2_0; }

		//Addition
		public RuleCall getAdditionParserRuleCall_2_1() { return cAdditionParserRuleCall_2_1; }

		//")"
		public Keyword getRightParenthesisKeyword_2_2() { return cRightParenthesisKeyword_2_2; }
	}

	public class VariableRefElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VariableRef");
		private final Assignment cVarAssignment = (Assignment)rule.eContents().get(1);
		private final CrossReference cVarVariableCrossReference_0 = (CrossReference)cVarAssignment.eContents().get(0);
		private final RuleCall cVarVariableIDTerminalRuleCall_0_1 = (RuleCall)cVarVariableCrossReference_0.eContents().get(1);
		
		//VariableRef:
		//	var=[Variable];
		public ParserRule getRule() { return rule; }

		//var=[Variable]
		public Assignment getVarAssignment() { return cVarAssignment; }

		//[Variable]
		public CrossReference getVarVariableCrossReference_0() { return cVarVariableCrossReference_0; }

		//ID
		public RuleCall getVarVariableIDTerminalRuleCall_0_1() { return cVarVariableIDTerminalRuleCall_0_1; }
	}

	public class AdditionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Addition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cMultiplicationParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Action cAdditionLeftAction_1_0 = (Action)cGroup_1.eContents().get(0);
		private final Keyword cPlusSignKeyword_1_1 = (Keyword)cGroup_1.eContents().get(1);
		private final Assignment cRightAssignment_1_2 = (Assignment)cGroup_1.eContents().get(2);
		private final RuleCall cRightMultiplicationParserRuleCall_1_2_0 = (RuleCall)cRightAssignment_1_2.eContents().get(0);
		
		//Addition returns Expression:
		//	Multiplication ({Addition.left=current} "+" right=Multiplication)*;
		public ParserRule getRule() { return rule; }

		//Multiplication ({Addition.left=current} "+" right=Multiplication)*
		public Group getGroup() { return cGroup; }

		//Multiplication
		public RuleCall getMultiplicationParserRuleCall_0() { return cMultiplicationParserRuleCall_0; }

		//({Addition.left=current} "+" right=Multiplication)*
		public Group getGroup_1() { return cGroup_1; }

		//{Addition.left=current}
		public Action getAdditionLeftAction_1_0() { return cAdditionLeftAction_1_0; }

		//"+"
		public Keyword getPlusSignKeyword_1_1() { return cPlusSignKeyword_1_1; }

		//right=Multiplication
		public Assignment getRightAssignment_1_2() { return cRightAssignment_1_2; }

		//Multiplication
		public RuleCall getRightMultiplicationParserRuleCall_1_2_0() { return cRightMultiplicationParserRuleCall_1_2_0; }
	}

	public class AssignmentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Assignment");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVarAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cVarVariableRefParserRuleCall_0_0 = (RuleCall)cVarAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExprAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExprAdditionParserRuleCall_2_0 = (RuleCall)cExprAssignment_2.eContents().get(0);
		private final Keyword cSemicolonKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//Assignment:
		//	var=VariableRef "=" expr=Addition ";";
		public ParserRule getRule() { return rule; }

		//var=VariableRef "=" expr=Addition ";"
		public Group getGroup() { return cGroup; }

		//var=VariableRef
		public Assignment getVarAssignment_0() { return cVarAssignment_0; }

		//VariableRef
		public RuleCall getVarVariableRefParserRuleCall_0_0() { return cVarVariableRefParserRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//expr=Addition
		public Assignment getExprAssignment_2() { return cExprAssignment_2; }

		//Addition
		public RuleCall getExprAdditionParserRuleCall_2_0() { return cExprAdditionParserRuleCall_2_0; }

		//";"
		public Keyword getSemicolonKeyword_3() { return cSemicolonKeyword_3; }
	}
	
	
	private SystemElements pSystem;
	private VariableDeclarationElements pVariableDeclaration;
	private TRANSITIONElements pTRANSITION;
	private ConstanteElements pConstante;
	private MultiplicationElements pMultiplication;
	private PrimaryElements pPrimary;
	private VariableRefElements pVariableRef;
	private AdditionElements pAddition;
	private AssignmentElements pAssignment;
	
	private final GrammarProvider grammarProvider;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public GALGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammarProvider = grammarProvider;
		this.gaTerminals = gaTerminals;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//System:
	//	("System" name=ID "{" variables+=VariableDeclaration* transitions+=TRANSITION+ "}")?;
	public SystemElements getSystemAccess() {
		return (pSystem != null) ? pSystem : (pSystem = new SystemElements());
	}
	
	public ParserRule getSystemRule() {
		return getSystemAccess().getRule();
	}

	//VariableDeclaration returns Variable:
	//	name=ID "=" initVal=INT ";";
	public VariableDeclarationElements getVariableDeclarationAccess() {
		return (pVariableDeclaration != null) ? pVariableDeclaration : (pVariableDeclaration = new VariableDeclarationElements());
	}
	
	public ParserRule getVariableDeclarationRule() {
		return getVariableDeclarationAccess().getRule();
	}

	//TRANSITION:
	//	"transition" name=ID "[" "TRUE" "]" ("label" label=STRING)? "{" assignments+=Assignment+ "}";
	public TRANSITIONElements getTRANSITIONAccess() {
		return (pTRANSITION != null) ? pTRANSITION : (pTRANSITION = new TRANSITIONElements());
	}
	
	public ParserRule getTRANSITIONRule() {
		return getTRANSITIONAccess().getRule();
	}

	//Constante:
	//	value=INT;
	public ConstanteElements getConstanteAccess() {
		return (pConstante != null) ? pConstante : (pConstante = new ConstanteElements());
	}
	
	public ParserRule getConstanteRule() {
		return getConstanteAccess().getRule();
	}

	//Multiplication returns Expression:
	//	Primary ({Multiplication.left=current} "*" right=Primary)*;
	public MultiplicationElements getMultiplicationAccess() {
		return (pMultiplication != null) ? pMultiplication : (pMultiplication = new MultiplicationElements());
	}
	
	public ParserRule getMultiplicationRule() {
		return getMultiplicationAccess().getRule();
	}

	//Primary returns Expression:
	//	VariableRef | Constante | "(" Addition ")";
	public PrimaryElements getPrimaryAccess() {
		return (pPrimary != null) ? pPrimary : (pPrimary = new PrimaryElements());
	}
	
	public ParserRule getPrimaryRule() {
		return getPrimaryAccess().getRule();
	}

	//VariableRef:
	//	var=[Variable];
	public VariableRefElements getVariableRefAccess() {
		return (pVariableRef != null) ? pVariableRef : (pVariableRef = new VariableRefElements());
	}
	
	public ParserRule getVariableRefRule() {
		return getVariableRefAccess().getRule();
	}

	//Addition returns Expression:
	//	Multiplication ({Addition.left=current} "+" right=Multiplication)*;
	public AdditionElements getAdditionAccess() {
		return (pAddition != null) ? pAddition : (pAddition = new AdditionElements());
	}
	
	public ParserRule getAdditionRule() {
		return getAdditionAccess().getRule();
	}

	//Assignment:
	//	var=VariableRef "=" expr=Addition ";";
	public AssignmentElements getAssignmentAccess() {
		return (pAssignment != null) ? pAssignment : (pAssignment = new AssignmentElements());
	}
	
	public ParserRule getAssignmentRule() {
		return getAssignmentAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
