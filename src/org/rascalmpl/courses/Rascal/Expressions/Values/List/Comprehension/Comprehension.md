---
title: List Comprehension
keywords:
  - "["
  - "|"
  - "]"

---

#### Synopsis

A list comprehension generates a list value.

#### Syntax

`[ Exp~1~, Exp~2~, ... | Gen~1~, Gen~2~, ... ]`

#### Types


| `Exp~1~` | `Exp~2~` | ... | `[ Exp~1~, Exp~2~, ... \| Gen~1~, Gen~2~, ... ]`  |
| --- | --- | --- | --- | --- |
| `T~1~`   | `T~2~`   | ... | `list[ lub( T~1~, T~2~, ... ) ]`                   |


#### Function

#### Description

A list comprehension consists of a number of contributing expressions _Exp_~1~, _Exp_~2~, ... and a number of
generators _Gen_~1~, _Gen_~2~, _Gen_~3~, ... that are evaluated as described in ((Expressions-Comprehensions)).

#### Examples

Computing a list of squares of the numbers from 0 to 10 that are divisible by 3:
```rascal-shell
[n * n | int n <- [0 .. 10], n % 3 == 0];
```
But we can also include the relevant `n` in the resulting list:
```rascal-shell
[n, n * n | int n <- [0 .. 10], n % 3 == 0];
```

#### Benefits

#### Pitfalls

