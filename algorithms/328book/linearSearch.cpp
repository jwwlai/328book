#include <iostream>
#include <vector>
using namespace std;

int linearSearch(vector<int>* vec, int toFind){
	for(int i = 0; i<(* vec).size(); ++i){
		if((*vec)[i]== toFind)
			return i;
	}
	//not found
	return -1;
}
int main(){
	int in, foundAt, num;
	vector <int> v = vector<int>();
	cin>>num;
	while(cin>>in){
		v.push_back(in);
	}
	foundAt = linearSearch(&v, num);
	cout<<"found at: "<<foundAt<<endl;
	return 0;
}
