---
title: Concrete Syntax
keywords: 
  - "`"
  - "("
  - ")"
---

#### Synopsis

Concrete syntax is a notation for patterns that match parse trees and expressions that generate them.

#### Syntax

``````
`(Nonterminal) `sentence``
``````

Where each `sentence` is a string over the language generated from `Nonterminal`. This language is extended in the following way. Each non-terminal reachable `X` from _Non_-terminal has an added alternative to allow nested Rascal ((Patterns)) inside of concrete syntax fragments:

```rascal
syntax X = "<" Type Var ">";`
```

#### Types


#### Function


#### Description

A concrete syntax fragment allows the programmer to write patterns and expressions in the language that is currently analyzed, 
transformed or generated. The ((Concrete Syntax)) feature is derived from ((Syntax Definition))s. 
For any non-terminal defined in a ((Syntax Definition)), you may use ((Concrete Syntax)) to match or generate its parse trees.

#### Examples

#### Benefits

* Easy notation for complex structures
* The leading Nonterminal always scopes the right parser to run.
* Source-to-source transformations are easy with concrete syntax patterns.

#### Pitfalls


