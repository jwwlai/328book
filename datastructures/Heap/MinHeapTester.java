public class MinHeapTester{
	public static void main(String [] argv){
		MinHeap x = new MinHeap();
		for(int i = 5; i < 10; ++i){
			x.insert((Integer) i);
		}
		for (int i = 5; i> 0; --i){
			x.insert((Integer) i);
		}
		while(!x.isEmpty()){
			System.out.println(x.pop());
		}
	}
}