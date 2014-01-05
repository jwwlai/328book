struct Node
{
 int data;
 struct Node *next;
};
void Print(Node *head)
{
     if(head == NULL)//if the head is pointing to an empty list we don't want to print anything
         return;
    else{
        //logic: print the data, then if next isn't null, we can continue
        while(true){
            printf("%d\n", head->data);
            if(head->next == NULL){
                   break;
            }
            head= head->next;
        }
     
    }
    // This is a "method-only" submission. 
  // You only need to complete this method. 
}

Node* insertAtEnd(Node* head, int val){
	Node* n = new Node();
	n->data = val;
	n->next = NULL;
	Node* cur = head;
	//check the empty list
	if(cur == NULL){
		return n;
	}
	//find the right place to insert
	while(cur->next != NULL){
		cur = cur->next;
	}
	cur->next = n;
	return head;
}
/*
	Compare 2 linked lists, A and B.
	return 1 if they are identical, and 0 if they are not
*/
int CompareLists(Node *headA, Node *headB){
	//compare them
	//1. cover the null pointer problem first
	if(headA == NULL || headB == NULL){
		//if one is null, both must be null, else return false
		if(headA == headB){
			return 1;
		}
		return 0;
	}
	//2. cover the mismatching data case
	if(headA->data != headB->data)
		return 0;
	return CompareLists(headA->next, headB ->next);
}
/*
	takes in 2 sorted linked lists, and returns a merged list
*/
bool isEmpty(Node *h){
	if(h==NULL)
		return true;
	return false;
}
int compareTo(Node* headA, Node *headB){
	if(headA == NULL){
		//if a is null and b is null, they are equal
		if(headB == NULL){
			return 0;
		}
		//if a is null and b is null, call a less than b
		return 1;
	}
	if(headB == NULL){
		//a is not null, but b is null, so a is less than b
		return -1;
	}
	//neither a nor b is null, so determine by their data
	return headA->data - headB->data;
}
Node* MergeLists(Node *headA, Node *headB){
	//Options: 
	//1. do it like mergesort's merge
	//2. alter one of the lists (probably starting with the smaller one)
	Node* a = headA;
	Node* b = headB;
	Node* ret = NULL;
	int compTo;
	while(!isEmpty(headA) && !isEmpty(headB)){
		compTo = compareTo(a, b);
		if(compTo <=0){
			insertAtEnd(ret, a);
			a = a->next;
		}
		else {
			insertAtEnd(ret, b);
			b = b->next;
		}
	}
	return ret;
}
