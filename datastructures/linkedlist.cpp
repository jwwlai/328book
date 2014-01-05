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
	this->print();
	Node* cur = this->head;
	LinkedList* a = new LinkedList();
	while(cur != NULL){
		std::cout<<"data to be inserted: "<< cur->data<<std::endl;
		a->insertAtEnd(cur->data);
		a->print();
		cur = cur->next;
	}
	return a;
}
// /*
// 	Compare 2 linked lists, A and B.
// 	return 1 if they are identical, and 0 if they are not
// */
// int LinkedList::compareLists(LinkedList *headA){
// 	//compare them
// 	//1. cover the null pointer problem first
// 	if(headA->getHead() == NULL || this->head== NULL){
// 		//if one is null, both must be null, else return false
// 		if(headA->getHead() == this->head){
// 			return 1;
// 		}
// 		return 0;
// 	}
// 	//2. cover the mismatching data case
// 	if(headA.getHead()->data != this->head->data)
// 		return 0;
// 	return compareLists(headA.getHead()->next, this->head->next);
// }
// /*
// 	takes in 2 sorted linked lists, and returns a merged list
// */
// bool LinkedList::isEmpty(){
// 	if(this->head==NULL)
// 		return true;
// 	return false;
// }
// void LinkedList::mergeLists(LinkedList *headA){
// 	//Options: 
// 	//1. do it like mergesort's merge
// 	//2. alter one of the lists (probably starting with the smaller one)
// 	LinkedList* a = headA.getHead();
// 	LinkedList* b = this->head;
// 	LinkedList* ret = NULL;
// 	int compTo;
// 	while(!headA->isEmpty() && !this->isEmpty()){
// 		compTo = a.compareLists(b);
// 		if(compTo <=0){
// 			ret.insertAtEnd(a);
// 			a = a->getHead()->next;
// 		}
// 		else {
// 			ret.insertAtEnd(b);
// 			b = b->getHead()->next;
// 		}
// 	}
// 	this->head = ret;
// }