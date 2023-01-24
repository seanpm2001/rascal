---
title: Variable Pattern
---

#### Synopsis

Variable in abstract pattern.

#### Syntax

```
Var
```

#### Types

#### Function

#### Description

A variable pattern can act in two roles:

* If _Var_ has already a defined value in the current scope then it matches with that value. This means an equality check of the bound value against the subject that is matched against. Note that the presence or absence of keyword fields _anywhere_ in the subject or the bound value is ignored.

*  If _Var_ has not been defined before (or it has been declared but not initialized) then it matches any value. That value is assigned to _Var_. The scope of this variable is the outermost expression in which the pattern occurs or the enclosing ((If)), ((While)), or ((Do)) if the pattern occurs in the test expression of those statements.

#### Examples

Initialize variable `N`
```rascal-shell
N = 10;
```
and use `N` in a pattern; its value is used as value to match with:
```rascal-shell,continue
N := 10;
N := 20;
```
Use a non-existing variable in a pattern, it is bound when the match succeeds:
```rascal-shell,continue
import IO;
if(M := 10)
   println("Match succeeded, M == <M>");
```

#### Benefits

#### Pitfalls

