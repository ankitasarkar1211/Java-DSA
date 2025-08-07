import java.util.Scanner;

public class countInversion {
  public static int merging(int[] nums,int low,int mid,int high){
    int[] temp=new int[nums.length];
    int k=0,c=0;
    int left=low,right=mid+1;
    while(left<=mid && right<=high){
      if(nums[left]<=nums[right]){
        temp[k++]=nums[left++];
      }
      else{
        c+=mid-left+1;
        temp[k++]=nums[right++];
      }
    }
    while(left<=mid) temp[k++]=nums[left++];
    while(right<=high) temp[k++]=nums[right++];

    for(int i=low;i<=high;i++)
      nums[i]=temp[i-low];

    return c;  
  }


  public static int divide(int[] nums,int low,int high){
    int count=0;
    if(low>=high) //base case
      return count;
    int mid=(low+high)/2;
    count+=divide(nums,low,mid);
    count+=divide(nums,mid+1,high);
    count+=merging(nums,low,mid,high); 

    return count;
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
      int invCount=divide(nums,low,high);
      System.out.println("Inversion count= "+invCount);
      System.out.flush();
      System.out.println("Sorted array: ");
      for(int i=0;i<nums.length;i++)
        System.out.print(nums[i]+" ");
  }
}
