The purpose is to define a range of numbers which we want to traverse and find the Collatz-Steps of each respectively. 
We use multi-threading for this, and a future promise to store the steps of each number for each thread. 

Then we use a basic Quick-Sort algorithm to sort the list of numbers based on their Collatz-Steps, and print it to the console.

NOTE: (I have found the memory to run out going past a max range of 100 thousand). 
