# Stack of Iterators

Java conversion of Stack of Iterators Pattern from this blog
http://garethrees.org/2016/09/28/pattern/

Uses a function to create a closure over an Iterator.

The pattern is an alternative to recursion because

1. Lists can grow without limit (recursion will ultimately run out of stack)
1. Can return at any point without running back through the recursed functions
