---
title: ListRelation Reflexive Transitive Closure
keywords:
  - "*"

---

#### Synopsis

The reflexive transitive closure of a binary list relation.

#### Syntax

`Exp *`

#### Types


|`Exp`               | `Exp *`             |
| --- | --- |
| `lrel[T~1~, T~2~]` | `lrel[T~1~, T~2~]`  |


#### Function

#### Description

Reflexive transitive closure is defined by repeated composition of a list relation.
If we define for a given list relation R:

*  `R~0~ = `[<a, a>, <b, b> | <a, b> <- R];`
*  `R~1~ = R`
*  `R~2~ = R o R`
*  `R~3~ = R o R~2~`
*  `...`


then the reflexive transitive closure R* can be defined in two ways:
(also see ((ListRelation-TransitiveClosure))):

*  `R* = R~0~ + R~1~ + R~2~ + R~3~ + ...`
*  `R* = R~0~ + R+`


#### Examples

```rascal-shell
[<1,2>, <2,3>, <3,4>]*;
```

#### Benefits

#### Pitfalls

