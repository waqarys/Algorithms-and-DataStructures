# Hashing Overview
- Hashing derives a fixed size result from an input
- Stable 
	- The same input generates the same output every time
- Uniform
	- The hash value should be uniformly distributed through the available space
- Efficient
	- The cost of generating a hash must be balanced with application needs
- Secure
	- The cost of finding data that produces a given hash is prohibitive
	
# Hashing a String
- Naive implementation
	- summing ASCII value of each character
 --- --- ---		 ----- ----- -----
| F | O | O |  	->  | 101 | 111 | 111 |		= 324
 --- --- ---   		 ----- ----- -----
 
 - Pros
 	- Stable
 	- Efficient
 	
 - Cons
 	- Not uniform
 		- AdditiveHash('foo') equals AdditiveHash('oof')
 	- Not secure 
 	
# Handling Collisisons
- Two distinct items have same hash value
	- Items are assigned to the same index in the hash table
- Two common strategies
	- Open Addressing
		- Moving to next index in table
	- Chaining
		- Storing items in a Linked List
		
# Growing the Collection
- Load Factor
	- The ratio of filled hash table array slots
	- Also known as `fill factor`
- Add item
```
if(fillFactor >= maxFillFactor){
	_newArray = new Array[_array.length*2];
	foreach(item in _array){
		AddItemToHashTable(_newArray, item);
	}
	_array = _newArray
}
AddItemToHashTable(_array, item);
```

