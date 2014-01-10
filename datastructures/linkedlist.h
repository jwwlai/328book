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
			int listSize;
		public:
			//constructors and destructor
			LinkedList();
			LinkedList(int val);
			LinkedList(LinkedList & a);
			LinkedList(int* list, int listSize);
			~LinkedList();
			//operators
			LinkedList & operator = (LinkedList & a);
			//getters
			Node* getHead();
			int getSize();
			// methods that will alter the list
			void insertAtEnd(int data);
			void insertAtFront(int data);
			void insertNth(int data, int position);
			void mergeLists(LinkedList* headA);
			void removeFront();
			//utilities
			int compareTo(LinkedList* headA);
			LinkedList* clone();
			bool isEmpty();
			void print();
	};
#endif 