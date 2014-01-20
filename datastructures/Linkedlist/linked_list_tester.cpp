#include <iostream>
#include "linkedlist.cpp"
using namespace std;
int main(){
	int ints[] = {3, 5, 4, 1, 2};
	LinkedList* b= new LinkedList(ints, 5); 
	b->print();
	b->insertNth(10, 6);
	b->print();
	delete b;
	cout<<"good things are happening"<<endl;
	return 0;
}