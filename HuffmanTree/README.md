A Java program that implements the Huffman coding algorithm.


Part I reads-in a piece of text from the user. The program then counts how
many times each letter appears in the text, and prints out that information. For example:

Enter your sentence: to be or not to be

‘ ’ has a frequency of 5

‘o’ has a frequency of 4

‘t’ has a frequency of 3

‘b’ has a frequency of 2

‘e’ has a frequency of 2

‘r’ has a frequency of 1

‘n’ has a frequency of 1


Part II creates a new Binary Tree for each of the letters and adds them into a
Priority Queue, it then combines the trees until only one is left.


Part III derives the Huffman encoding for the piece of
text by using the resulting Huffman tree.
