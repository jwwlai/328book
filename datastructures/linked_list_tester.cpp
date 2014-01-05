#include <iostream>
#include "linkedlist.cpp"
using namespace std;
int main(){
	LinkedList* a = new LinkedList(1);
	a->print();
	LinkedList* b = a->clone();
	a->insertAtEnd(2);
	b->print(); 
	a->print();
	delete a;
	delete b;
	cout<<"good things are happening"<<endl;
	return 0;
}