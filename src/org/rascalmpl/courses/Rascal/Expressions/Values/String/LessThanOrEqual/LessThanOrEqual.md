---
title: String LessThanOrEqual
keywords:
  - "<="

---

#### Synopsis

Less than or equal operator on string values.

#### Syntax

`Exp~1~ <= Exp~2~`

#### Types


| `Exp~1~` | `Exp~2~` | `Exp~1~ <= Exp~2~`  |
| --- | --- | --- |
| `str`     |  `str`    | `bool`                |


#### Function

#### Description

Yields `true` if the string value of _Exp_~1~ is lexicographically less
than the string value of _Exp_~2~ or if both string are equal, and `false` otherwise.

#### Examples

```rascal-shell
"abc" <= "abc";
"abc" <= "abcdef";
"abc" <= "defghi";
"abc" <= "a";
```

#### Benefits

#### Pitfalls

