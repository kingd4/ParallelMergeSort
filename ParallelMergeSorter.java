import java.util.Arrays;
import java.lang.*;

class ParallelMergeSorter{
    
	public static void sort(int[] A, double tCount )
	{
		double aCount = Math.sqrt(tCount);
		int lCount = (int)aCount;
		ParallelMergeSorter.ssort(A, lCount );
	}
	
	public static void ssort( int[] A, int l)
	{
		if (A.length < 2)
		{
			return;
		}
		if (l == 1)
		{
			Arrays.sort(A);
			return; 
		}

		int[] left = Arrays.copyOfRange(A, 0, A.length/2);
		int[] right = Arrays.copyOfRange(A, A.length/2, A.length);

		Thread lThread = new Thread(new Sorter(left, l-1));
		Thread rThread = new Thread(new Sorter(right, l-1));
		lThread.start();
		rThread.start();
		try {
			lThread.join();
			rThread.join();
		} 
		catch (InterruptedException ie)
		{
			
		}

		
		System.arraycopy(left, 0, A, 0,  left.length);
		System.arraycopy(right, 0, A, left.length, right.length);
	}
}
