import java.util.*;  
import java.lang.reflect.Array; 

public class Main
{
	public static void main(String[] args) {
		System.out.println("Enter number of ways :");
		Scanner sc= new Scanner(System.in);
		int no_of_ways = sc.nextInt();
		int all[] = new int[no_of_ways];
		for(int i= 0 ; i <no_of_ways ; i++){
		  all[i] = sc.nextInt();
		}
		for(int i = 0 ; i<no_of_ways ; i++ ) {
		  int count =0;
		  int val = all[i];
		  while(val >= 1){
		    val = val/2;
		    
		    count ++;
		  }
		  System.out.println(count);
		}
		}
}
