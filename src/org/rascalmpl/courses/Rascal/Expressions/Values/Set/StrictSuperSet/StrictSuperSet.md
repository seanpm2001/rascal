---
title: Set StrictSuperSet
keywords:
  - ">"

---

#### Synopsis

Strict superset operator on set values.

#### Syntax

`Exp~1~ > Exp~2~`

#### Types


| `Exp~1~`    |  `Exp~2~`    | `Exp~1~ > Exp~2~`  |
| --- | --- | --- |
| `set[T~1~]` |  `set[T~2~]` | `bool`               |


#### Function

#### Description

Yields `true` if the value of Exp~1~ is a strict superset of the value of Exp~2~, and `false` otherwise.

#### Examples

```rascal-shell
{1, 2, 3, 4} > {3, 2, 1};
{1, 2, 3, 4} > {4, 3, 2, 1};
```

#### Benefits

#### Pitfalls

