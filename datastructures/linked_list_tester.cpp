#include <iostream>
#include "linkedlist.cpp"
using namespace std;
int main(){
	LinkedList* a = new LinkedList();
	LinkedList* b = new LinkedList();
	for(int i = 0; i< 10; ++i){
		a->insertAtEnd(i);
	}
	for(int i = 10; i< 20; ++i){
		b->insertAtEnd(i);
	}
	a->print();
	b->print();
	a->mergeLists(b);
	a->print();
	b->print();
	delete a;
	delete b;
	cout<<"good things are happening"<<endl;
	return 0;
}