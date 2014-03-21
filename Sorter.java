import java.lang.Thread;
import java.util.*;



class Sorter implements Runnable
{
	private int[] A;
	private int l;
	
	public Sorter(int[] A, int l)
	{
		this.A = A;
		this.l = l;
	}
	
	public void run()
	{
		ParallelMergeSorter.ssort(A, l);
	}
}
