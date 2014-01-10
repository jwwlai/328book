#include "linkedlist.h"
#include <iostream>
//initializes an empty linked list
LinkedList::LinkedList(){
	this->head = NULL;
	this->listSize = 0;
}
//creates a linked list with the value val at the head
LinkedList::LinkedList(int val){
	LinkedList* a = new LinkedList();
	a->insertAtEnd(val);
	this->head = a->getHead();
	this->listSize = 1;
}
//creates a linked list out of an array of ints
LinkedList::LinkedList(int* list, int listSize){
	LinkedList* a = new LinkedList();
	for(int i = 0; i<listSize; ++i){
		a->insertAtEnd(list[i]);
	}
	this->head = a->getHead();
	this->listSize = listSize;
}
//creates a shallow copy f a linked list
LinkedList::LinkedList(LinkedList & a){
	this->head = a.head;
	this->listSize = a.listSize;
}
//deletes a linked list
LinkedList::~LinkedList(){
	delete head;
}
//gets the front of the linked list
Node* LinkedList::getHead(){
	return this->head;
}
int LinkedList::getSize(){
	return this->listSize;
}
//returns the linked list
LinkedList & LinkedList::operator = (LinkedList& a){
	this->head = a.head;
	this->listSize = a.listSize;
	return a;
}
//prints the list front to back
void LinkedList::print()
{
	std::cout<<"list size: "<<this->listSize<<std::endl;
    Node *cur = this->head;
    //logic: print the data, then if next isn't null, we can continue
    while(cur != NULL){
        std::cout << cur->data << " -> ";
        cur = cur->next;
    }  
    std::cout << "NULL" << std::endl;
}
//puts a value at the front
void LinkedList::insertAtFront(int data)
{
	this->listSize++;
    Node* insertedNode = new Node();
    insertedNode -> data = data;
    if(this->head !=NULL)
    	insertedNode->next = this->head;
    else
    	insertedNode->next = NULL;
    this->head = insertedNode;
}
//puts a value at the end
void LinkedList::insertAtEnd(int data){
	Node* n = new Node();
	n->data = data;
	n->next = NULL;
	Node* cur = this->head;
	this->listSize++;
	//check the empty list
	if(cur == NULL){
		this->head = n;
		return;
	}
	//find the right place to insert
	while(cur->next != NULL){
		cur = cur->next;
	}
	cur->next = n;
}
//insert a value at the nth position
void LinkedList::insertNth(int data, int position){
	if(position> this->getSize()){
		this->insertAtEnd(data);
		return;
	}
	if(position == 0){
		this->insertAtFront(data);
		return;
	}
	Node* a = this->head;
	while(position-- >1){
		a = a->next;
	}
	Node* n = new Node();
	n->data = data;
	n->next = a->next;
	a->next = n;
	return;
}
//creates a deepcopy of a linked list
LinkedList* LinkedList::clone(){
	Node* cur = this->head;
	LinkedList* a = new LinkedList();
	while(cur != NULL){
		a->insertAtEnd(cur->data);
		cur = cur->next;
	}
	a->listSize = this->listSize;
	return a;
}
//used to compare 2 linked lists
int compare(Node* a, Node* b){
	if(a == NULL){
		if(b == NULL){
			return 0;
		}
		return 1;
	}
	if(a->data != b->data)
		return a->data - b->data;
	return compare(a->next, b->next);
}
/*
	Compare 2 linked lists, A and B.
	return 1 headA < this 0 if equal, -1 if this < headA
*/
int LinkedList::compareTo(LinkedList *headA){
	//compare them
	//1. cover the null pointer problem first
	if(this->head == NULL){
		if(headA->getHead() == NULL){
			return 0;
		}
		return -1;
	}
	if(headA->getHead() == NULL){
		return 1;
	}
	//2. cover the mismatching data case
	if(headA->getHead()->data != this->head->data)
		return headA->getHead()->data - this->head->data;
	return compare(this->getHead()->next, headA->getHead()->next);
}
//take the front off of a linked list
void LinkedList::removeFront(){
	if(this->head != NULL){
		this->listSize--;
		this->head = this->head->next;
	}
}
//checks to see if the linked list is empty
bool LinkedList::isEmpty(){
	if(this->listSize>0)
		return true;
	return false;
}
// takes in 2 sorted linked lists, and this becomes a merged list
void LinkedList::mergeLists(LinkedList *headA){
	//Options: 
	//1. do it like mergesort's merge
	//2. alter one of the lists (probably starting with the smaller one)
	LinkedList* a = headA->clone();
	LinkedList* b = this->clone();
	LinkedList* ret = new LinkedList();
	int compTo;
	while(!a->isEmpty() || !b->isEmpty()){
		compTo = a->compareTo(b);
		if(compTo >0){
			ret->insertAtEnd(a->getHead()->data);
			a->removeFront();
		}
		else {
			ret->insertAtEnd(b->getHead()->data);
			b->removeFront();
		}
	}
	this ->head = ret -> getHead();
	delete a;
	delete b;	
}