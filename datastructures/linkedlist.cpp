#include "linkedlist.h"
#include <iostream>
LinkedList::LinkedList(){
	this->head = NULL;
}
LinkedList::LinkedList(int val){
	this->head = new Node();
	this->head->data = val;
	this->head->next = NULL;
}
LinkedList::LinkedList(LinkedList & a){
	this->head = a.head;
}
LinkedList::~LinkedList(){
	delete head;
}
Node* LinkedList::getHead(){
	return this->head;
}
LinkedList & LinkedList::operator = (LinkedList& a){
	this->head = a.head;
	return a;
}
void LinkedList::print()
{
    Node *cur = this->head;
    //logic: print the data, then if next isn't null, we can continue
    while(cur != NULL){
        std::cout<<cur->data<<" -> ";
        cur = cur->next;
    }  
    std::cout<<"NULL"<<std::endl;
}

void LinkedList::insertAtEnd(int val){
	Node* n = new Node();
	n->data = val;
	n->next = NULL;
	Node* cur = this->head;
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

LinkedList* LinkedList::clone(){
	Node* cur = this->head;
	LinkedList* a = new LinkedList();
	while(cur != NULL){
		a->insertAtEnd(cur->data);
		cur = cur->next;
	}
	return a;
}
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
	return 1 if they are identical, and 0 if they are not
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
	if(headA ->getHead() == NULL){
		return 1;
	}
	//2. cover the mismatching data case
	if(headA->getHead()->data != this->head->data)
		return headA->getHead()->data - this->head->data;
	return compare(this->getHead()->next, headA->getHead()->next);
}
void LinkedList::removeFront(){
	if(this->head != NULL)
		this->head = this->head->next;
}
bool LinkedList::isEmpty(){
	if(this->head==NULL)
		return true;
	return false;
}
/*
	takes in 2 sorted linked lists, and this becomes a merged list
*/
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
	this ->head = ret ->clone()->getHead();
	delete a;
	delete b;	
	delete ret;
}