import java.util.Scanner;

public class mergeSort {
  public static void merging(int[] nums,int low,int mid,int high){
    int[] temp=new int[nums.length];
    int k=0;
    int left=low,right=mid+1;
    while(left<=mid && right<=high){
      if(nums[left]<=nums[right]){
        temp[k++]=nums[left++];
      }
      else{
        temp[k++]=nums[right++];
      }
    }
    while(left<=mid) temp[k++]=nums[left++];
    while(right<=high) temp[k++]=nums[right++];

    for(int i=low;i<=high;i++)
      nums[i]=temp[i-low];

  }


  public static void divide(int[] nums,int low,int high){
    if(low>=high) //base case
      return;
    int mid=(low+high)/2;
    divide(nums,low,mid);
    divide(nums,mid+1,high);
    merging(nums,low,mid,high); 
  }
  
  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter no. of elements in the array: ");
      int n=sc.nextInt();
      int[] nums=new int[n];
      System.out.println("Enter "+n+" elements: ");
      for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

      int low=0,high=n-1;  
      divide(nums,low,high);

      for(int i=0;i<nums.length;i++)
        System.out.print(nums[i]+" ");
  }
}
