import java.util.Random;

public class GumballMachine {
	// There are four states - so let us create an instance variable to
	// hold the current state and define values for each of the states
	private final static int SOLD_OUT = 0;
	private final static int NO_QUARTER = 1;
	private final static int HAS_QUARTER = 2;
	private final static int SOLD = 3;
	private final static int WINNER = 4;

	// here is an instance variable that holds the current state.
	// We will set it to SOLD_OUT since the machine will be
	// unfilled when it is first taken out of its box and turned on
	private int state = SOLD_OUT;
	private int count = 0;

	public GumballMachine(int count) {
		this.count = count;
		if (count > 0)
			state = NO_QUARTER;
	}

	// There are four actions that we can do with a gumball machine
	// insert quarter, turn crank, eject quarter and dispense. These
	// actions are the gumball machine's interface.
	// Note that dispense is more of an internal action the machine
	// invokes on itself

	public void insertQuarter() {
		// we check each possible state with a conditional statement

		// if a quarter is already inserted, we tell the customer
		if (state == HAS_QUARTER)
			System.out.println("You can't insert another quarter");

		else if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		}

		// if the machine is sold out, we reject the quarter
		else if (state == SOLD_OUT)
			System.out
					.println("You can't insert a quarter, the machine is sold out");

		// if the customer just bought a gumball, he/she needs to wait until the
		// transaction is complete before inserting another quarter
		else if (state == SOLD)
			System.out
					.println("Please wait, we are already giving you a gumball");

		else if (state == WINNER)
			System.out
					.println("Please wait, you won an extra gumball and we are giving it");
	}

	public void ejectQuarter() { // customer tries to remove the quarter
		// if there is a quarter, we return it and go back to the
		// NO_QUARTER state
		if (state == HAS_QUARTER) {
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		}
		// otherwise, if there isn't one and we can't give it back
		else if (state == NO_QUARTER) {
			System.out.println("You haven't inserted a quarter");
		}

		// if the customer just turned the crank, we can't give a refund;
		// he already has the gumball
		else if (state == SOLD)
			System.out.println("Sorry, you already turned the crank");

		// if the machine is sold out, it doesn't accept quarters
		// so you cannot eject!
		else if (state == SOLD_OUT)
			System.out
					.println("You can't eject, you haven't inserted a quarter yet");

		else if (state == WINNER)
			System.out.println("Sorry, you already turned the crank");
	}

	public void turnCrank() { // customer tries to turn the crank
		// someone is trying to cheat the machine
		if (state == SOLD)
			System.out
					.println("Turning twice does not give you another gumball");

		if (state == WINNER)
			System.out
					.println("Turning twice does not give you another 2 gumballs");

		if (state == NO_QUARTER) // we need a quarter first
			System.out.println("You turned but there is no quarter");

		else if (state == SOLD_OUT) // we can't deliver gumballs; there are none
			System.out.println("You turned, but there are no gumballs");

		else if (state == HAS_QUARTER) {
			// Success! They get a gumball, Change the state and call
			// the mahcine's dispense() method
			System.out.println("You turned...");
			Random generator = new Random();
			int winner = generator.nextInt(10);
			if (winner == 0)
				state = WINNER;
			else
				state = SOLD;
			dispense();
		}
	}

	public void dispense() { // called to dispense a gumball
		if (state == SOLD) {
			// we are in the SOLD state; give them a gumball
			System.out.println("A gumball comes rolling out of the slot");
			count--;
			if (count == 0) {
				// if this was the last one, we set the machine' state to
				// SOLD_OUT;
				System.out.println("Oops, out of gumballs");
				state = SOLD_OUT;
			} else {
				// otherwise we are back to not having a quarter
				state = NO_QUARTER;
			}
		}

		else if (state == WINNER) {
			// we are in the WINNER state; give them two gumballs
			System.out
					.println("YOU ARE A WINNER! You get two gumballs for your quarter");
			System.out.println("A gumball comes rolling out of the slot");
			count--;
			if (count == 0) {
				// if this was the last one, we set the machine' state to
				// SOLD_OUT;
				System.out.println("Oops, out of gumballs");
				state = SOLD_OUT;
			} else {
				System.out.println("A gumball comes rolling out of the slot");
				count--;
				if (count == 0) {
					// if this was the last one, we set the machine' state to
					// SOLD_OUT;
					System.out.println("Oops, out of gumballs");
					state = SOLD_OUT;
				} else
					state = NO_QUARTER;
			}
		}

		else if (state == NO_QUARTER)
			System.out.println("You need to pay first");

		else if (state == SOLD_OUT)
			System.out.println("No gumball dispensed");

		else if (state == HAS_QUARTER)
			System.out.println("No gumball dispensed");
	}

	public String toString() {
		String s = "\nMighty Gumball, Inc.\n";
		s += "Java enabled Standing Gumball Model #2014\n";
		s += "Inventory: " + count + " gumballs\n";
		if (count == 0)
			s += "Machine is sold out\n";
		else
			s += "Machine is waiting for quarter\n";
		return s;
	}
}