import java.util.*;
public class MinHeap{
	private Integer[] table;
	public static final int rootAddress = 1;
	private int load;
	/**
		Constructor
	*/
	public MinHeap(){
		//default table size = 1000
		table = new Integer[1000];
		load = 0;
	}
	/**
		@param The array to be turned into a heap
	*/
	public void build_heap(Integer[] ar){

	}
	/**
		Find the parent of a given node
		@return the address of the parent of the input node
		@param the node that we are trying to find the parent of.
	*/
	public int parent(int i){
		return i/2;//note this algorithm actually wants the floor, but int division gives that already
	}
	/**
		Find the left child of a given node
		@return the addrest of the parent to the input node.
		@param the address of the node we are tyring to find the parent of.
	*/
	public int leftChild(int i){
		return 2*i;
	}
	public int rightChild(int i){

	}
	/**
		@param The value to be inserted into the heap.
		@return No value.
	*/
	public void insert(Integer t){
		//percolate up
	    int hole = this.load + MinHeap.rootAddress; //number of elements in heap
	    for(; hole > 1 && t.compareTo(this.table[hole/2]) < 0; hole /= 2)
	        this.table[hole] = this.table[hole/2];
	    this.table[hole] = t;
	    this.load++;
	}
	/**
		@return the minimum value in the heap
	*/
	public Integer pop()
	{
	    Integer data = (Integer) this.table[MinHeap.rootAddress];
	    if(this.load == 1){
	    	this.load--;
	    	this.table[MinHeap.rootAddress] = null;
	    	return data;
	    }
	    this.table[MinHeap.rootAddress] = this.table[this.load--];
	    percolateDown(1);
	    return data;
	}
	/**
		Percolate down the tree the object located at array[index].
	*/
	private void percolateDown(int index)
	{
	    int child;
	    Integer tmp = this.table[index];
	    for(; (child=2*index) <= load; index = child)
	    {
	        if(child != load && this.table[child+1].compareTo(this.table[child]) < 0)
	            child++;
	        if(this.table[child].compareTo(tmp) < 0)
	            this.table[index] = this.table[child];
			else break;
		}
	    this.table[index] = tmp;
	}
	/**
		@return the string value of the array that represents this heap
	*/
	public String toString(){
		String out = "";
		for(int i = 1; i<this.table.length; ++i){
			if(this.table[i] == null)
				return out;
			out += this.table[i] + " ";
		}
		return out;
	}
	/**
		Check to see if the heap is empty
		@return true if heap is empty, false if heap is not empty
	*/
	public boolean isEmpty(){
		if(this.table[MinHeap.rootAddress] == null)
			return true;
		return false;
	}
}