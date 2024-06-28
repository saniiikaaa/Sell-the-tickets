import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.io.IOException;

public class Sell_Tickets {

    static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("How many people are in queue?");
        int n = s.nextInt();
		int input[] = new int[n];
        System.out.println("Give priority accordingly:");
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
        System.out.println("Target person is standing at which index?");
        int k = s.nextInt();
		System.out.println("Time required by person to get ticket:-" +Solution.buyTicket(input, k)+"sec");
	}
}
class MaxPQcomparator implements Comparator<Integer>
{
	public int compare(Integer o1,Integer o2)
	{
		if(o1>o2)
		{
			return -1;
		}
		else if(o1<o2)
		{
           return 1;
		}
		else
		{
			return 0;
		}
	}
}

 class Solution {
	
	public static int buyTicket(int [] arr, int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		
		MaxPQcomparator maxcompare=new MaxPQcomparator();
        PriorityQueue<Integer> pq=new PriorityQueue<>(maxcompare);
         int yourpriority=arr[k];
		 for(int i=0;i<arr.length;i++)
		 {
			 if(i==k)
			 {
				 pq.add(yourpriority);
			 }
			 else
			 {
				 pq.add(arr[i]);
			 }
		 }
		 int time = 0;
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            indexQueue.add(i);
        }

        while (!pq.isEmpty()) {
            if (arr[indexQueue.peek()] == pq.element()) {
                time++;
                if (indexQueue.peek() == k) {
                    return time;
                }
                pq.remove();
                indexQueue.poll();
            } else {
                indexQueue.add(indexQueue.poll());
            }
        }

    return time;

	}
}
 
 
