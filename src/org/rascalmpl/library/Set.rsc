@license{
  Copyright (c) 2009-2015 CWI
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Paul Klint - Paul.Klint@cwi.nl - CWI}
@contributor{Jurgen J. Vinju - Jurgen.Vinju@cwi.nl - CWI}
@contributor{Tijs van der Storm - Tijs.van.der.Storm@cwi.nl}
@doc{
#### Synopsis

Library functions for sets.

#### Usage

#### Description

For operators on sets see [Set]((Rascal:Values-Set)) in the Rascal Language Reference.

The following functions are defined for sets:
(((TOC)))
}
module Set

import Exception;
import List;
import util::Math;

@doc{
#### Synopsis

Classify elements in a set.

#### Examples

We classify animals by their number of legs.
```rascal-shell
import Set;
```
Create a map from animals to number of legs.
```rascal-shell,continue
legs = ("bird": 2, "dog": 4, "human": 2, "snake": 0, "spider": 8, "millepede": 1000, "crab": 8, "cat": 4);
```
Define function `nLegs` that returns the number of legs for each animal (or `0` when the animal is unknown):
```rascal-shell,continue
int nLegs(str animal){
    return legs[animal] ? 0;
}
```
Now classify a set of animals:
```rascal-shell,continue
classify({"bird", "dog", "human", "spider", "millepede", "zebra", "crab", "cat"}, nLegs);
```
}
public map[&K,set[&V]] classify(set[&V] input, &K (&V) getClass) = toMap({<getClass(e),e> | e <- input});



@doc{
#### Synopsis

Group elements in a set given an equivalence function.

#### Examples

We classify animals by their number of legs.
```rascal-shell
import Set;
```
Create a map from animals to number of legs.
```rascal-shell,continue
legs = ("bird": 2, "dog": 4, "human": 2, "snake": 0, "spider": 8, "millepede": 1000, "crab": 8, "cat": 4);
```
Define function `nLegs` that returns the number of legs fro each animal (or `0` when the animal is unknown):
```rascal-shell,continue
int nLegs(str animal){
    return legs[animal] ? 0;
}
bool similar(str a, str b) = nLegs(a) == nLegs(b);
```
Now group a set of animals:
```rascal-shell,continue
group({"bird", "dog", "human", "spider", "millepede", "zebra", "crab", "cat"}, similar);
```
WARNING: check compiler.
}
public set[set[&T]] group(set[&T] input, bool (&T a, &T b) similar) {
  sinput = sort(input, bool (&T a, &T b) { return similar(a,b) ? false : a < b ; } );
  lres = while (!isEmpty(sinput)) {
    h = head(sinput);
    sim = h + takeWhile(tail(sinput), bool (&T a) { return similar(a,h); });
	append toSet(sim);
	sinput = drop(size(sim), sinput);
  }
  return toSet(lres); 
}

@doc{
#### Synopsis

Map set elements to a fixed index.

#### Examples

```rascal-shell
import Set;
index({"elephant", "zebra", "snake"});
```}
public map[&T,int] index(set[&T] s) {
  sl = toList(s);
  return (sl[i] : i | i <- index(sl));
}





@doc{
#### Synopsis

Test whether a set is empty.

#### Description

Yields `true` if `s` is empty, and `false` otherwise.

#### Examples

```rascal-shell
import Set;
isEmpty({1, 2, 3});
isEmpty({});
```}
@javaClass{org.rascalmpl.library.Prelude}
public java bool isEmpty(set[&T] st);

@doc{
#### Synopsis

Apply a function to all set elements and return set of results.

#### Description

Return a set obtained by applying function `fn` to all elements of set `s`.

#### Examples

```rascal-shell
import Set;
int incr(int x) { return x + 1; }
mapper({1, 2, 3, 4}, incr);
```}
public set[&U] mapper(set[&T] st, &U (&T) fn)
{
  return {fn(elm) | &T elm <- st};
}

@doc{
#### Synopsis

Determine the largest element of a set.

#### Examples

```rascal-shell
import Set;
max({1, 3, 5, 2, 4});
max({"elephant", "zebra", "snake"});
```}
public &T max(set[&T] st) {
	<h,t> = takeOneFrom(st);
	return (h | e > it ? e : it | e <- t);
}

@doc{
#### Synopsis

Smallest element of a set.

#### Examples

```rascal-shell
import Set;
min({1, 3, 5, 2, 4});
min({"elephant", "zebra", "snake"});
```}
@doc{
#### Synopsis

Determine the smallest element of a set.

#### Examples

```rascal-shell
import Set;
min({1, 3, 5, 4, 2});
```
}
public &T min(set[&T] st) {
	<h,t> = takeOneFrom(st);
	return (h | e < it ? e : it | e <- t);
}

@doc{
#### Synopsis

Determine the powerset of a set.

#### Description

Returns a set with all subsets of `s`.

#### Examples

```rascal-shell
import Set;
power({1,2,3,4});
```}
public set[set[&T]] power(set[&T] st)
{
  // the power set of a set of size n has 2^n-1 elements 
  // so we enumerate the numbers 0..2^n-1
  // if the nth bit of a number i is 1 then
  // the nth element of the set should be in the
  // ith subset 
  stl = [*st];
  i = 0;
  res = while(i < pow(2,size(st))) {
	j = i;
	elIndex = 0;
	sub = while(j > 0) {;
	  if(j mod 2 == 1) {
		append stl[elIndex];
	  }
	  elIndex += 1;
	  j /= 2;
	}
	append {*sub};
	i+=1;
  }
  return {*res};
}

@doc{
#### Synopsis

The powerset (excluding the empty set) of a set value.

#### Description

Returns all subsets (excluding the empty set) of `s`.

#### Examples

```rascal-shell
import Set;
power1({1,2,3,4});
```}
public set[set[&T]] power1(set[&T] st) = power(st) - {{}};

@doc{
#### Synopsis

Apply a function to successive elements of a set and combine the results (__deprecated__).

#### Description

Apply the function `fn` to successive elements of set `s` starting with `unit`.

#### Examples

```rascal-shell
import Set;
int add(int x, int y) { return x + y; }
reducer({10, 20, 30, 40}, add, 0); 
```

#### Pitfalls

WARNING: This function is *deprecated*, use a [reducer]((Rascal:Expressions-Reducer)) instead.
}
public &T reducer(set[&T] st, &T (&T,&T) fn, &T unit) =
	(unit | fn(it,elm) | elm <- st);

public &T reducer(set[&T] _:{}) { throw EmptySet(); }

@doc{
#### Synopsis

Determine the number of elements in a set.

#### Examples

```rascal-shell
import Set;
size({1,2,3,4});
size({"elephant", "zebra", "snake"});
size({});
```}
@javaClass{org.rascalmpl.library.Prelude}
public java int size(set[&T] st);


public (&T <:num) sum(set[(&T <:num)] _:{}) {
	throw ArithmeticException(
		"For the emtpy set it is not possible to decide the correct precision to return.\n
		'If you want to call sum on empty set, use sum({0.000}+st) or sum({0r} +st) or sum({0}+st) 
		'to make the set non-empty and indicate the required precision for the sum of the empty set 
		");
}
@doc{
#### Synopsis

Sum the elements of a set.

#### Examples

```rascal-shell
import Set;
sum({3, 1, 4, 5});
sum({3, 1.5, 4, 5});
```}
public default (&T <:num) sum({(&T <: num) e, *(&T <: num) r})
	= (e | it + i | i <- r);


@doc{
#### Synopsis

Pick an arbitrary element from a set.

#### Description

#### Examples

```rascal-shell
import Set;
getOneFrom({"elephant", "zebra", "snake"});
getOneFrom({"elephant", "zebra", "snake"});
getOneFrom({"elephant", "zebra", "snake"});
getOneFrom({"elephant", "zebra", "snake"});
```}
@javaClass{org.rascalmpl.library.Prelude}
public java &T getOneFrom(set[&T] st);

@doc{
#### Synopsis

Get "first" element from a set.

#### Description

Get "first" element of a set. Of course, sets are unordered and do not have a first element.
However, we may assume that sets are internally ordered in some way and this ordering is reproducible.
Applying `getFirstFrom` on the same set will always returns the same element.

#### Benefits

This function helps to make set-based code more deterministic, for instance, for testing purposes.
}
public &T getFirstFrom({&T f, *&T _}) = f;
public &T getFirstFrom(set[&T] _:{}) { throw EmptySet(); }

@doc{
#### Synopsis

Remove an arbitrary element from a set, returns the element and a set without that element.

#### Description

Remove an arbitrary element from set `s` and return a tuple consisting of the element and a set without that element.
 Also see ((Set-getOneFrom)).

#### Examples

```rascal-shell
import Set;
takeOneFrom({1, 2, 3, 4});
takeOneFrom({1, 2, 3, 4});
takeOneFrom({1, 2, 3, 4});
```
}
@javaClass{org.rascalmpl.library.Prelude}
public java tuple[&T, set[&T]] takeOneFrom(set[&T] st);

 @doc{
#### Synopsis

Remove "first" element from a set, returns the element and a set without that element.

#### Description

element of a set.
}
public tuple[&T, set[&T]] takeFirstFrom({&T f, *&T r}) = <f, r>;  
public tuple[&T, set[&T]] takeFirstFrom(set[&T] _:{}) { throw EmptySet(); }  
 
@doc{
#### Synopsis

Convert a set to a list.

#### Examples

```rascal-shell
import Set;
toList({1, 2, 3, 4});
toList({"elephant", "zebra", "snake"});
```
Note that the same result can be obtained using splicing:
```rascal-shell,continue
s = {1,2,3,4};
l = [*s];
```

#### Pitfalls

Recall that the elements of a set are unordered and that there is no guarantee in which order the set elements will be placed in the resulting list.}
public list[&T] toList(set[&T] st) = [*st];

@doc{
#### Synopsis

Convert a set of tuples to a map; each key is associated with a set of values.

#### Description

Convert a set of tuples to a map in which the first element of each tuple 
is associated with the set of second elements of all tuples with the same first element.

#### Examples

```rascal-shell
import Set;
toMap({<"a", 1>, <"b", 2>, <"a", 10>});
```}
@javaClass{org.rascalmpl.library.Prelude}
public java map[&A,set[&B]] toMap(rel[&A, &B] st);

@doc{
#### Synopsis

Convert a set of tuples to a map (provided that there are no multiple keys).

#### Description

Convert a set of tuples to a map. The result should be a legal map (i.e., without multiple keys).

#### Examples

```rascal-shell,error
import Set;
toMapUnique({<"a", 1>, <"b", 2>, <"c", 10>});
```
Now explore an erroneous example:
```rascal-shell,continue,error
toMapUnique({<"a", 1>, <"b", 2>, <"a", 10>});
```}
@javaClass{org.rascalmpl.library.Prelude}
public java map[&A,&B] toMapUnique(rel[&A, &B] st) throws MultipleKey;

@doc{
#### Synopsis

Convert a set to a string.

#### Examples

```rascal-shell
import Set;
toString({1, 2, 3});
toString({"elephant", "zebra", "snake"});
```

#### Pitfalls

Recall that the elements of a set are unordered and that there is no guarantee in which order the set elements will be placed in the resulting string.}
@javaClass{org.rascalmpl.library.Prelude}
public java str toString(set[&T] st);

@doc{
#### Synopsis

Convert a set to an indented string.

#### Examples

```rascal-shell
import Set;
toString({1, 2, 3});
toString({"elephant", "zebra", "snake"});
```

#### Pitfalls

Recall that the elements of a set are unordered and that there is no guarantee in which order the set elements will be placed in the resulting string.

}
@javaClass{org.rascalmpl.library.Prelude}
public java str itoString(set[&T] st);


@doc{ 
#### Synopsis

Sort the elements of a set.

Sort the elements of a set:

*  Use the built-in ordering on values to compare list elements.
*  Give an additional `lessThan` function that will be used to compare elements. 

This function `lessThan` (<) function should implement a strict partial order, meaning:

*  that it is not reflexive, i.e. never `a < a`
*  is anti-symmetric, i.e. never `a < b && b < a`.
*  is transitive, i.e. if `a < b` and `b < c` then `a < c`.

#### Examples

```rascal-shell
import Set;
import String;
sort({10, 4, -2, 11, 100, 5});
fruits = {"mango", "strawberry", "pear", "pineapple", "banana", "grape", "kiwi"};
sort(fruits);
sort(fruits, bool(str a, str b){ return size(a) > size(b); });
```}
public list[&T] sort(set[&T] s) =
	sort(s, bool (&T a,&T b) { return a < b; } );
	
@javaClass{org.rascalmpl.library.Prelude}
public java list[&T] sort(set[&T] l, bool (&T a, &T b) less) ;

@doc{
.Synopsis Produce the smallest `k` elements of a set as sorted by the `less` function

#### Description

This function is fast if `k` is relatively small, say 10 out of a 1000 elements.
It operates in O(n*k) time where n is the size of the set.
 
If `k` is a larger value, say `k > 10`, then it's perhaps better to just sort the entire set 
using the asympotically faster (n*log^2(n)) sort function and take the first `k` elements of the resulting list.

If `k` is a negative number, `top` will return the largest `abs(k)` elements of the set instead of the smallest.
}
@javaClass{org.rascalmpl.library.Prelude}
public java list[&T] top(int k, set[&T] l, bool (&T a, &T b) less) ;

public list[&T] top(int k, set[&T] l) = top(k, l, bool (&T a, &T b) { return a < b; });

@doc{
#### Synopsis

Flatten a set of sets into a single set.  
}
public set[&T] union(set[set[&T]] sets) = {*s | s <- sets};

@doc{
#### Synopsis

Compute the Jaccard similarity between two sets.
}
real jaccard(set[value] x, set[value] y) = (1. * size(x & y)) / size(x + y);
