import java.util.*;
public class Vertex{
	private String name;
	private ArrayList<Vertex> adjacencyList;
	/**
		Default Constructor
	*/
	public Vertex(){
		name = "default";
		adjacencyList = new ArrayList<Vertex>();
	}
	/**
		Parameterized Constructor
		@param s, the name of the vertex
	*/
	public Vertex(String s){
		this.name = s;
		adjacencyList = new ArrayList<Vertex>();
	}
	/**
		Retrieve String Value
		@return the string value of this vertex
	*/
	public String getName(){
		return this.name;
	}
	/**
		Returns the adjacency list for this vecotr
	*/
	public ArrayList<Vertex> getAdjacencyList(){
		return this.adjacencyList;
	}
	/**
		Parameterized Constructor
		@param s, the name of the vertex
		@param list, an adjacency list containing verticies
	*/
	public Vertex(String s, ArrayList<Vertex> list){
		this.name = s;
		this.adjacencyList = list;
	}
	/**
		@param adds the vertex given to the array list
		@return the vertex if it exists, or null if it is not in that arraylist
	*/
	public Vertex find(Vertex x){
		for(int i = 0; i <this.adjacencyList.size(); ++i ){
			if(x.equals(this.adjacencyList.get(i))){
				return x;
			}
		}
		return null;
	}
	/**
		@param Vertex, the vertex that we want to check against to see if they are equal
		@return Boolean, if they are the same, return true, else return false
	*/
	public boolean equals(Vertex v){
		if(this.name.equals(v.name)){
			if(this.adjacencyList.equals(v.adjacencyList))
				return true;
		}
		return false;
	}
	/**
		@return Vertex x, a deep copy of this vertex
	*/
	public Vertex clone(){
		String s = String.copy(this.name);
		ArrayList<Vertex> l = new ArrayList<Vertex>();
		for(int i = 0; i< this.adjacencyList.size(); ++i){

		}
		return Vertex(s, l);
	}
}