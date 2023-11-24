import java.util.*;
class Main 
{
    public static int solve (int arr[], int n, int k) 
    {
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            int a = arr[i];
            int id1 = i;
            int id2 = i;

            if (i == 0)
    	    {
                while (arr[id2 + 1] == a)
                    id2 += 1;
                if (arr[id2 + 1] <= a + k && arr[id2 + 1] >= a - k)
                    count += 1;
            }
        	else if (i < n - 1)
    	    {
                while (arr[id2 + 1] == a)
                    id2 += 1;
                while (arr[id1 - 1] == a)
                    id1 -= 1;
                if (((arr[id1 - 1] <= a + k) && (arr[id1 - 1] >= a - k))|| ((arr[id2 + 1] <= a + k) && (arr[id2 + 1] >= a - k)))
                    count += 1;
            }
		    else
    	    {
                while (arr[id1 - 1] == a)
                    id1 = id1 - 1;
	   
                if (arr[id1 - 1] <= a + k && arr[id1 - 1] >= a - k)
                    count += 1;
            }
        }
        return count;
    }
  
    public static void main (String[]args) 
    {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int k = sc.nextInt ();
        int arr[] = new int[n];
    
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt ();
        Arrays.sort (arr);
    
        System.out.println (solve (arr, n, k));
    } 
}
