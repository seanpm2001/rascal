---
title: Continue
keywords:
  - continue

---

#### Synopsis

Continue with the next iteration of while, do or for loop.

#### Syntax

```rascal
continue;

continue Label;
```

#### Types

#### Function

#### Description

A continue statement is only allowed inside the body of a ((While)), ((Do)) or ((For)) statement
and is associated with the innermost loop statement in which it is contained.
Its effect is to end the execution of the block for the current iteration of the loop
and to continue with the next iteration of the loop.

If the continue occurs in a nested loop, then it can also break to the outer loop if
it is labeled with `Label` and the break is also labeled with the same `Label`.

Also see ((Break)) and ((Fail)).

#### Examples

Here is an example using continue to avoid printing numbers that are divisible by 3:
```rascal-shell
import IO;
for (int i <- [1 .. 10]) {
    if (i % 3 == 0)
       continue;
    println("i = <i>");
}
```

#### Benefits

#### Pitfalls

