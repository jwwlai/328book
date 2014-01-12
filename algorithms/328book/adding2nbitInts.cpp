#include <vector>
#include <iostream>
using namespace std;

void printVector(vector<int> v){
	for(int i = 0; i< v.size(); ++i){
		cout<<v[i]<< " ";
	}
	cout<<endl;
}
void add2nbitNumbers(vector<int> f, vector<int> s, vector<int>* r){
	int carry;	
	for(int i = f.size()-1; i>-1; ){
		if(f[i]&&s[i])
				
int main(){
	vector<bool> firstNum = vector<bool>();
	vector<bool> secondNum = vector<bool>();
	vector<bool> result = vector<bool>();
	int n, in;
	cin>>n;
	for(int i = 0; i< n; ++i){
		cin>>in;
		if(in)
			firstNum.push_back(true);
		else
			firstNum.push_back(false);
	}
	for(int i = 0; i< n; ++i){
		cin>>in;
		if(in)
			secondNum.push_back(true);
		else 
			secondNum.push_back(false);
	}
	add2nbitNumbers(firstNum, secondNum, &result);
	for(int i = 0; i< result.size(); ++i)
		cout<<result[i]<< " ";
	cout<<endl;	
	return 0;
}
