import java.util.*;
public class Graph{
	private HashMap<String, Vertex> listOfVerticies;
	/**
		Default Constructor
	*/
	public Graph(){
		listOfVerticies = new HashMap<Vertex>();
	}
	/**
		@param Vertex n The vertex to be placed into the graph
	*/
	public void place(Vertex v){
		listOfVerticies.put(n.name, n);
	}
	public Vertex get(String name){
		return listOfVerticies.get(name);
	}
	public void remove(Vertex v){
		listOfVerticies.remove(v.name);
	}
}