public class Begger implements Job{
	public double pay(){
		double pay = 0;
		System.out.println("You don't have a job, so you earn this much: " + pay);
		return pay;
	}
}