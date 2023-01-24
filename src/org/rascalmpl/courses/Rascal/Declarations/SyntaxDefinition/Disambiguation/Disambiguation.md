---
title: Disambiguation
---

#### Synopsis

Disambiguation is the definition of filters on the parse trees that ((Syntax Definition))s define. 
There are several ways of defining ((Disambiguation)) in Rascal.

#### Syntax

#### Types

#### Function

#### Description

There are generally three ways of removing ambiguity from parse forests that are produced by parsers generated from ((Syntax Definition))s.

*  The first way is to add disambiguation declarations to the ((Syntax Definition)). You can choose from:
   **  [Priorities]((Priority))s, which can be used to define the relative priority in expression languages
   **  ((Associativity))s, which can be used to define relative associativity between operators of 
       expression languages
   **  ((Follow)) constraints, which can be used to implement longest match using lookahead
   **  ((Precede)) constraints, which can be used to implement first match using look behind
   **  ((Reserve)) constraintss, which allow you to remove a finite sets of strings from a ((Syntax Definition))
       to implement keyword reservation
*  The second way is to add ((Action))s that will be triggered just after parsing and allow you to trim a parse forest 
   using any information necessary.
*  The third way is use the ((Statements-Visit)) statement on a parse tree and implement your own filter post-parsing time, 
   or any other kind of program that processes ((Parse Trees)).

#### Examples

#### Benefits

#### Pitfalls

