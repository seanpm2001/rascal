---
title: Concrete Patterns
keywords:
  - "("
  - ")"
  - "`"
  - "<"
  - ">"

---

#### Synopsis

Concrete patterns.

#### Syntax

```rascal
Concrete pattern with expected symbol type: (_Symbol_) ` Token~1~ Token~2~ ... Token~n~ `
```
```rascal
Typed variable inside a concrete pattern: <_Type_ _Var_>
```

#### Types

#### Function

#### Description

A concrete pattern is a pattern for matching a ((Library:module:ParseTree)). The notation of a concrete pattern is the *object language* itself, the language that the parse tree describes. 
In other words, you can use a code example to match parsed code using a concrete pattern. These concrete code examples can contain ((Variable Patterns))s like the other ((Patterns)).

The mechanism of concete patterns gives a good notation for matching complex structures such as a ((Library:module:ParseTree)), and it works in a simple manner:
   
   * the input code is parsed using a parser generated from a ((Syntax Definition)); this generates parse trees.
   * the pattern example code is parsed using the *same* parser; this generates parse trees with ((Variable Patterns))s.
   * the parse tree with the ((Variable Patterns))s is matches against the parse tree of the input code, similarly to the way ((Node Patterns)) work.     
 
So, you could say that ((Concrete Patterns)) are a short notation for otherwise highly complex ((Node Patterns)) on ((Library:module:ParseTree)).  Note that the ((Patterns-VariableDeclaration))s in a concrete pattern can
only occur in the pattern at the location where the code for a full non-terminal of the ((Syntax Definition)) would be. The structure of a concrete pattern follows the structure of the 
grammar in the ((SyntaxDefinition)) and the types of the ((Patterns-Variable))s are the syntax non-terminals of the ((Syntax Definition)).  

Inside concrete syntax patterns, layout is ignored while pattern matching. So parse trees which have different whitespace and comments but are otherwise the same will match anyway.

#### Examples

Examples (in a context where an appropriate concrete syntax has been defined):

*  Quoted syntax pattern with two pattern variable declarations:
```rascal-shell
import ParseTree;
syntax Id = [a-z]+;
syntax Num = [0-9]+;
syntax Exp = left Exp "*" Exp > Exp "+" Exp |  Id | Num;
layout WS = [\ \n\r\t]*;
visit (parse(#Exp, "x + x")) {
   case (Exp) `<Id a> + <Id b>` => (Exp) `2 * <Id a>` when a == b
}
```
Some observations about this example:

** Notice how the non-terminals `Exp` and `Id` from the ((Syntax Definition)) become types for the pattern.

** When this example pattern actually matches the variable `a` is bound and can be used again like any other ((Variable Patterns)). 


A full example of concrete patterns can be found in [WithLayout](/docs/recipes/languages/exp/concrete/withlayout/).

#### Benefits

#### Pitfalls

