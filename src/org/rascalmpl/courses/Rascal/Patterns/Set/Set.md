---
title: Set Pattern
keywords:
  - "{"
  - "}"

---

#### Synopsis

Set in abstract pattern.

#### Syntax

```rascal
{Pat~1~, Pat~2~, * Pat~3~, ..., Pat~n~}
```

#### Types

#### Function

#### Description

A set pattern matches a set value (the subject), provided that _Pat_~1~, _Pat_~2~, ..., _Pat_~n~ match the elements of that set in *any* order
(recall that the elements of a set are unordered and do not contain duplicates).

Completely analogous to list patterns, there are special cases when one of the patterns _Pat_~i~ is

*  a ((MultiVariable Patterns)), with an optional element type that is an arbitrary sub-type of the element type of the subject set: set matching is applied and the variable can match an arbitrary number of elements of the subject set.

*  a ((Variable Patterns)), where the variable has been declared with a subtype of the element type of the subject, but not initialized, outside the pattern: the variable is matched with the value at the corresponding element in the subject set. And the type of the element is checked to match the declared type of the variable.


#### Examples

```rascal-shell
import IO;
```

* A single variable
```rascal-shell,continue
if({10, 30, 40, 50, int N} := {10, 20, 30, 40, 50})
   println("Match succeeded, N = <N>");
```

* An untyped multi-variable:
```rascal-shell,continue
if({10, *S, 50} := {50, 40, 30, 20, 10})
   println("Match succeeded, S = <S>");
```

* A typed multi-variable:
```rascal-shell,continue
if({10, *int S, 50} := {50, 40, 30, 20, 10})
   println("Match succeeded, S = <S>");
```
Here we see an example, where all possible splits of a set in two subsets are printed:
```rascal-shell,continue
for({*S1, *S2} :={30, 20, 10})
    println("<S1> and <S2>");
```

* Already declared set variable:
```rascal-shell,continue
set[int] S;
if({10, *S, 50} := {10, 20, 30, 40, 50})
   println("Match succeeded, S = <S>");
```

* Already declared element variable:
```rascal-shell,continue
int N;
if({10, N, 30, 40, 50} := {50, 40, 30, 20, 10})
   println("Match succeeded, N = <N>");
```

#### Benefits

#### Pitfalls

