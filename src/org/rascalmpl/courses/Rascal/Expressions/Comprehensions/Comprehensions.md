---
title: Comprehensions
keywords:
  - comprehensions
  - query
  - filter
  - "["
  - "]"
  - "{"
  - "}"
  - "("
  - ")"
  - "|"
  - "<-"

---

#### Synopsis

Comprehensions provide a concise notation to conditionally generate new values.

#### Syntax

```rascal
[ Exp~1~, ..., Exp~n~ | Exp~n+1~, ..., Exp~n+m~]
{ Exp~1~, ..., Exp~n~ | Exp~n+1~, ..., Exp~n+m~}
( Exp~1~ : Exp~2~ | Exp~3~, ..., Exp~n+m~)
( Exp~1~ | Exp~2~ | Exp~3~, ..., Exp~n+m~)
```

#### Types

#### Function

#### Description

Comprehensions are defined for the following types:

*  `list`, see [list comprehension]((List-Comprehension)),
*  `set`, see [set comprehension]((Set-Comprehension)),
*  `map`, see [map comprehension]((Map-Comprehension))
*  for reducing to any value, see ((Reducer)) expressions.


The syntax varies slightly for each type, but comprehensions have the following common elements:

*  Generators can come in two flavours:
   * ((Boolean-Enumerator)) that generates all the values in some subject value.
   * ((Boolean-Filter)) that performs an arbitrary test on previously generated values.

*  One or more _contributing expressions_ that are added to the list, set or map that is being constructed.


The contributing expressions are evaluated for all possible values of the enumerators that are not
excluded by a test. When a filter fails, execution continues with the preceding enumerator (if any).

Each enumerator may introduce new variables that can be used in subsequent generators as well as in the contributing expressions.
A generator can use the variables introduced by preceding generators. 

#### Examples

A list comprehension:
```rascal-shell
[ 3 * X | int X <- [1 .. 10] ];
```
A list comprehension with a filter:
```rascal-shell,continue
[ 3 * X | int X <- [1 .. 10], X > 5];
```
A list comprehension with multiple contributing expressions:
```rascal-shell,continue
[X, X * X | int X <- [1, 2, 3, 4, 5], X >= 3];
```
A set comprehension with a filter:
```rascal-shell,continue
{X | int X <- {1, 2, 3, 4, 5}, X >= 3};
```
A set comprehension that constructs a relation:
```rascal-shell,continue
{<X, Y> | int X <- {1, 2, 3}, int Y <- {2, 3, 4}, X >= Y};
{<Y, X> | <int X, int Y> <- {<1,10>, <2,20>}};
```
Introduce a map of `fruits` and use a map comprehension to filter fruits with an associated value larger than 10:
```rascal-shell,continue
fruits = ("pear" : 1, "apple" : 3, "banana" : 0, "berry" : 25, "orange": 35);
(fruit : fruits[fruit] | fruit <- fruits, fruits[fruit] > 10);
```

See ((List-Comprehension)), ((Set-Comprehension)), ((Map-Comprehension)), or ((Reducer)) for more examples.

#### Benefits

#### Pitfalls

