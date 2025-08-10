
import java.util.HashMap;
import java.util.Scanner;

public class maxSubarrayZero{
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter no. of elements: ");
      int n=sc.nextInt();
      int[] nums=new int[n];
      System.out.println("Enter "+n+" elements:");
      for(int i=0;i<n;i++)  nums[i]=sc.nextInt(); 
      
      int ans=maxSubarray(nums,n);
      System.out.println("Max length of subarray which sums to zero is "+ans);
  }
  public static int maxSubarray(int[] nums,int n){
    int max=0,count,sum=0;
    HashMap<Integer,Integer> prefixSum=new HashMap<>();
    prefixSum.put(0,0);
    for(int i=0;i<n;i++){
      sum+=nums[i];
      if(prefixSum.containsKey(sum)){
        count=i-prefixSum.get(sum);
        max=Math.max(max,count);
      }
      else prefixSum.put(sum, i);
    }
    return max;
  }
}