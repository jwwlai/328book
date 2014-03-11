// a hashtable for Integers
import java.util.Arrays;
import java.util.LinkedList;
public class HashTable{
	private LinkedList<Integer>[] values;
	public HashTable(){
		this.values = new LinkedList[17];
		for(int i = 0; i< values.length; ++i){
			this.values[i] = new LinkedList<Integer>();
		}
	}
	public HashTable(int size){
		this.values = new LinkedList[size];
		for(int i = 0; i < values.length; ++i){
			this.values[i] = new LinkedList<Integer>();
		}
	}
	@Override
	public String toString(){
		return Arrays.toString(this.values);
	}
	public boolean insert(Integer toInsert){
		if(-1 == this.find(toInsert)){
			this.values[this.locateInTable(toInsert)].add(toInsert);
			return true;
		}
		return false;

	}
	public int find(Integer toFind){
		if(this.values[this.locateInTable(toFind)].contains(toFind)){
			return this.locateInTable(toFind);
		}
		return -1;
	}
	public int locateInTable(Integer toFind){
		int placeToFind = toFind.hashCode() % values.length;
		return placeToFind;
	}
}