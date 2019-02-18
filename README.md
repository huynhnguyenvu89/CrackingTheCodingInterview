

### Chapter 2 - LinkedList
A linked list is a data structure that represents a sequence of nodes. In a singly linked list, each node points to the
next node in the linked list. A doubly linked list gives each node points to the next and the previous next.
Unlike an array, a linked list does not provide constant time access to a particular "index" within the list.
This means that if you'd like to find the Kth element in the list, you will need to iterate through K elements.
The benefit of a linked list is that you can add and remove items in the list in constant time.
For specific applications, this can be useful.


## The "runner" technique
The "runner" (or second pointer) technique is used in many linked list problems. The runner technique means that you
iterate through the linked list with two pointers simultaneously, with one ahead of the other. The "fast" node might be
ahead by a fixed amount, or it might be hopping multiple nodes for each one node that the "slow" node iterates through.

## Recursive problems
A number of linked list problems rely on recursion. IF you're having trouble solving a linked list problem, you should
explore if a recursive approach will work. However, you should remember that recursive algorithms take at least O(n) space,
where n is the depth of the recursive call.