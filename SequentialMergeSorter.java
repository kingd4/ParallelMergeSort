class SequentialMergeSorter
{
    
	private static int min(int a, int b)
	{
		return (a<b)?a:b;
	}
    
	private static void dump(int[] A)
	{
		for(int i=0;i<A.length;++i)
		{
			System.out.print(A[i]+" ");
		}
		System.out.println();
	}
    
	public static void sort(int[] A)
	{
		int[] B = new int[A.length];
		int[] s=A;
		int[] d=B;
		int cs=1;
        
		while( cs < A.length )
		{
			for(int s1=0;s1<A.length;s1+=cs*2)
			{
				int i=s1;
				int e1 = min(s1+cs,A.length);
				int j=e1;
				int e2 = min(j+cs,A.length);
				int k=s1;
                
				while( i<e1 && j<e2)
				{
					if( s[i] <= s[j] )
						d[k++] = s[i++];
					else
						d[k++] = s[j++];
				}
                
				while( i<e1 )
					d[k++] = s[i++];
				while( j<e2 )
					d[k++] = s[j++];
			}
            
			int[] tmp = s;
			s=d;
			d=tmp;
			cs *= 2;
		}
        
		if( s == B )
		{
			for(int i=0;i<s.length;++i)
				A[i]=s[i];
		}
	}
}
