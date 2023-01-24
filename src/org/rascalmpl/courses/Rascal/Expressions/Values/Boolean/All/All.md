---
title: Boolean All
keywords:
  - all

---

#### Synopsis

All argument expressions are true.

#### Syntax

`all ( Exp~1~, Exp~2~, ... )`

#### Types

//

| `Exp~1~` | `Exp~2~` | ... | `all ( Exp~1~, Exp~2~, ... )` |
| --- | --- | --- | --- |
|`bool`     | `bool`    | ... | `bool`                           |


#### Function

#### Description

Yields `true` when all combinations of values of _Exp_~i~ are true.

#### Examples

Are all integers 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 even?
```rascal-shell,continue
all(int n <- [1 .. 10], n % 2 == 0);
```
Are all integers 0, 2, 4, 6, 8, 10 even?
```rascal-shell,continue
all(int n <- [0, 2 .. 10], n % 2 == 0);
```

When one of the _Exp_~i~ enumerates the elements of an empty list, `all` always returns `true`:
```rascal-shell
all(int n <- [], n > 0);
```

#### Benefits

#### Pitfalls

WARNING: The Rascal interpreter and compiler give different results on an empty list. 
The interpreter returns `fals` for the abo eexample.
