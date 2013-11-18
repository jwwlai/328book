#include <vector>
#include <iostream>
using namespace std;

void printVector(vector<int> v){
	for(int i = 0; i< v.size(); ++i){
		cout<<v[i]<< " ";
	}
	cout<<endl;
}
void insertionSort(vector<int> *s){
	
	//must declare j outside of its for loop for variable scope reasons
	int j;
	
	//while you can, push i as far left as possible
	for(int i = 1; i< (*s).size(); ++i){
		int tmp = (*s)[i];
		for(j = i; j >0; --j){
			if((*s)[j-1]> tmp)
				(*s)[j] =(*s)[j-1];
			else break;
		}
		(*s)[j] = tmp;
	}
}

int main(){
	
	// declare variables
	vector<int> s = vector<int>();
	int d;
	
	//instantiate vector
	while(cin>>d){
		s.push_back(d);
	
	}
	
	//actually sort them
	insertionSort(&s);
	
	//print the vector
	printVector(s);	
}
