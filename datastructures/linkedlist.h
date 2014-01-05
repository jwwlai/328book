#ifndef LINKEDLIST_H
#define LINKEDLIST_H
	struct Node
	{
		int data;
		struct Node* next;
	};
	class LinkedList
	{
	private:
		Node* head;
	public:
		LinkedList();
		LinkedList(int val);
		LinkedList(LinkedList & a);
		~LinkedList();
		LinkedList & operator = (LinkedList & a);
		LinkedList* clone();
		Node* getHead();
		void print();
		void insertAtEnd(int val);
		// int compareLists(LinkedList* headA);
		// bool isEmpty();
		// Node* mergeLists(LinkedList* headA);
	};
#endif 