public class GumballMachineTest {
	public static void main(String args[]) {
		GumballMachine myMachine = new GumballMachine(5);
		
		System.out.println(myMachine);
		
		// throw a quarter in
		myMachine.insertQuarter();
		myMachine.turnCrank();
		System.out.println(myMachine);
		
		myMachine.insertQuarter();
		myMachine.ejectQuarter();
		myMachine.turnCrank();
		System.out.println(myMachine);
		
		myMachine.insertQuarter();
		myMachine.turnCrank();
		myMachine.insertQuarter();
		myMachine.turnCrank();
		myMachine.ejectQuarter();
		System.out.println(myMachine);
		
		myMachine.insertQuarter();
		myMachine.insertQuarter();
		myMachine.turnCrank();
		myMachine.insertQuarter();
		myMachine.turnCrank();
		myMachine.insertQuarter();
		myMachine.turnCrank();
		System.out.println(myMachine);
	}
}
