# Lab_4_LinkedList[Uploading Lab4.docx…]() 
Lab 4: 30 pts

The main new components in this lab are discussed in Chapter 3's section on singly linked lists and were reviewed in class.

IMPORTANT:  This lab builds on Lab 3, so if you didn't do it, then complete Lab 3 as a part of this lab, but see next comment on GRADING to understand how that works.

GRADING:  I won't be deducting points if you didn't do parts of the Lab 3 piece correctly.  
I will only be grading your implementation of the Linked List and how you use it and the player move count.


1.	SUMMARY

a.	Add to Lab 3 by tracking the player's moves in a linked list.  Then, before printing out the maze at the end, cycle through all the nodes of the linked list and change the cell value of each grid spot where the user has been to a number like 8 or 5 or 3 or any integer other than 0 or 1.  This way the grid print out at the end will show the player's path.

b.	Secondly, track the number of moves the player makes and print that out at the end as well.

c.	This lab will involve the following new features:
i.	Singly Linked List

2.	DETAILS

a.	There won't be as much detail on the singly linked list since we went over an implementation in class.

b.	Classes and Adjustments to Lab 3.

i.	Node - This is a new class that needs to be added to Lab 3.
1.	Instance variables:
a.	xPosition - int type.
b.	yPosition - int type.
c.	nextNode - Node type.

ii.	LinkedList - This class will hold the linked list.
1.	Instance variables:
a.	headNode - Node type.
2.	Methods:<br>
a.	addHeadNode<br>
i.	Takes in two parameters, x and y, which are integer types.<br>
ii.	Returns nothing.<br>
iii.	With the x and y params, it creates a new node object and sets the nextNode on the new node object to the existing headNode object.<br>
iv.	It then assigns this new node object to the headNode variable.<br>
b.	removeHeadNode<br>
i.	Takes in no parameters.<br>
ii.	This is tricky so you need to carefully think through how to do this, but the following is what it needs to accomplish:<br>
1.	It needs to change the current head node to the node that is in the head node's nextNode variable; and it needs to return that previous head node to the method caller.<br>
2.	Essentially, you're taking the head node out of the linked list and returning it and setting the next node in line as the new head node.<br>

iii.	Updating run method in GameGrid class.<br>
1.	You need to instantiate a LinkedList instance.<br>
2.	In the while loop, use the iUserRow and iUserCol values to call the addHeadNode method on the LinkedList instance to add a node for every user move.<br>
3.	Create second while loop:  AFTER the existing while loop exits but BEFORE the grid print out.<br>
a.	This loop will run until all LinkedList nodes have been processed.<br>
b.	In the loop, call the removeHeadNode method on the LinkedList instance and use the returned node's xPosition and yPosition to update the grid at that position with any number you choose besides 0 and 1.  DO NOT use the nextNode prop of each node to traverse the linked list, because the whole point of using the remove head node method is to take it out of the list once it’s been processed.<br>
c.	You can also use this loop to count the number of player moves.<br>
4.	Print out the total number of player moves at the end when printing the grid.<br>


3.	TURNING IN LAB: <br>

a.	Turn your lab into Canvas.<br>
b.	IMPORTANT: DO NOT ZIP your folders/files please.  <br>
c.	Turn in ALL the java files for this lab (that includes all the Lab 3 files you used in this lab).<br>

