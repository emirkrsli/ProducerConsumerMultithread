
import java.util.*;



class Resource
{
	private int numResources;
	public Resource(int startLevel)
	{
		numResources = startLevel;
	}

	public int getLevel()
	{
		return numResources;
	}
	public int popItem;

	public Stack<Integer> stack = new Stack<>();


	public synchronized void addOne()
	{
		try
		{
			while (numResources >= 5)	wait();

			numResources++;

			System.out.println("PUSHED ITEM = " + stack.push((int)(Math.random() *100)));
			if(stack.size() == 5) System.out.println("STACK IS FULL");

			notifyAll();

		}
		catch (InterruptedException interruptEx)
		{
			System.out.println(interruptEx);
		}
	}

	public synchronized int takeOne()
	{
		try
		{
			while (numResources == 0) wait();


			popItem = stack.pop();
			numResources--;

			System.out.println("POPED ITEM = " + popItem);

			if(stack.isEmpty()){
				System.out.println("STACK IS EMPTY");
			}


			notify();

		}
		catch (InterruptedException interruptEx)
		{
			System.out.println(interruptEx);
		}
		return popItem;
	}
}
