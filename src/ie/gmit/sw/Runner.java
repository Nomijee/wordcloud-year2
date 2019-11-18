//G00351754
package ie.gmit.sw;
 
public class Runner extends Menu{

	public static void main(String[] args) throws Exception {
		
		Parser r1 = new Parser();
		r1.printMenu();
		long start = System.nanoTime();
		r1.Parse();
		long finish = System.nanoTime();
		long timeEslaped = finish-start;
		System.out.println("Running time (ns): " + (System.nanoTime() - timeEslaped));
		}
}


