---
title: MissingModifier
---

#### Synopsis

A modifier is missing in a declaration.

#### Syntax

#### Types

#### Function
       
#### Usage

#### Description

Rascal functions can be implemented in Java. This is the case for many functions in the standard library.
This requires these elements:

*  An abstract Rascal function declaration (= a function header without a body).
*  The keyword `java` should be part of the function header.
*  The function declaration is annotated (uing `javaClass`) with the name of the Java class that implements this function.


This error is generated when the `java` keyword is missing.

Remedy: Contact the Rascal developers:

*  Ask a question on StackOverflow using the [Rascal Stackoverflow Tag](http://stackoverflow.com/questions/tagged/rascal).
*  Read the currently open issues at the Rascal's [Issue Tracker on Github](https://github.com/usethesource/rascal/issues?state=open). If your problem has not yet been reported by someone else, please report it here.


If you are an expert developer and have implemented your own extension in Java, please check your own extension code first.


#### Examples

This is how the `size` function on lists is declared in the Rascal library:
```rascal-shell
@javaClass{org.rascalmpl.library.Prelude}
public java int size(list[&T] lst);
```

This is what happens if the `java` keyword is missing:
```rascal-shell,error
@javaClass{org.rascalmpl.library.Prelude}
public int size(list[&T] lst);
```

#### Benefits

#### Pitfalls

