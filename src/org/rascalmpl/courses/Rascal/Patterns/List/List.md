---
title: List Pattern
keywords:
  - "["
  - "]"

---

#### Synopsis

List in abstract pattern.

#### Syntax

```rascal
[Pat~1~, Pat~2~, * Pat~3~, ..., Pat~n~]
```

#### Types

#### Function

#### Description

A list pattern matches a list value (the subject), provided that _Pat_~1~, _Pat_~2~, ..., _Pat_~n~ match the elements of that list in order. We've made Pat~3~ a ((MultiVariable Patterns)) to illustrate that those are to be expected often in list patterns.

Special cases exist when one of the patterns _Pat_~i~ is

*  a ((MultiVariable Patterns)), with an optional element type that is an arbitrary sub-type of the element type of the subject list: list matching is applied and the variable can match an arbitrary number of elements of the subject list.

*  a ((Variable Patterns)), where the variable has been declared with a subtype of the element type of the subject, but not initialized, outside the pattern: the variable is matched with the value at the corresponding position in the subject list. And the type of the element is checked to match the declared type of the variable.


#### Examples

```rascal-shell
import IO;
```

* A single variable
```rascal-shell,continue
if([10, int N, 30, 40, 50] := [10, 20, 30, 40, 50])
   println("Match succeeded, N = <N>");
```

* An untyped multi-variable:
```rascal-shell,continue
if([10, *L, 50] := [10, 20, 30, 40, 50])
   println("Match succeeded, L = <L>");
```

* A typed multi-variable:
```rascal-shell,continue
if([10, *int L, 50] := [10, 20, 30, 40, 50])
   println("Match succeeded, L = <L>");
```

A list pattern may also be __non-linear__, i.e., it may contain uses of variables that were bound earlier in the pattern
(here, the second occurence of `L`):
```rascal-shell,continue
if([10, *L, 40, *L, 50] := [10, 20, 30, 40, 20, 30, 50])
   println("Match succeeded, L = <L>");
```
Here we see an example, where all pairs of equal elements in a list are printed:
```rascal-shell,continue
for([*L1, int N, *L2, N, *L3] := [ 5, 10, 20, 30, 40, 30, 15, 20, 10])
    println("N = <N>");
```
Here we print all ways in which a given list can be partitioned in two lists:
```rascal-shell,continue
for([*L1, *L2] := [10, 20, 30, 40, 50]) 
    println("<L1> and <L2>");
```

* Already declared list variable:
```rascal-shell,continue
list[int] L;
if([10, L, 50] := [10, 20, 30, 40, 50])
   println("Match succeeded, L = <L>");
```

* Already declared element variable:
```rascal-shell,continue
int N;
if([10, N, 30, 40, 50] := [10, 20, 30, 40, 50])
   println("Match succeeded, N = <N>");
```

#### Benefits

#### Pitfalls

