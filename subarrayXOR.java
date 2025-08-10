
import java.util.HashMap;
import java.util.Scanner;

public class subarrayXOR {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter no. of elements: ");
      int n = sc.nextInt();

      int[] nums=new int[n];

      System.out.println("Enter "+n+" elements: ");
      for (int i = 0; i < n; i++) {
          nums[i] = sc.nextInt();
      }

      System.out.print(("Enter target: "));
      int target = sc.nextInt();

      xorGate(nums,n,target);
  }
  public static void xorGate(int[] nums,int n,int k){
    int xor=0,count=0;
    HashMap<Integer,Integer> prefixMap = new HashMap<>();
    prefixMap.put(0, 1);

    for(int i=0; i<n; i++){
      xor^=nums[i];
      if(prefixMap.containsKey(xor^k))
        count+= prefixMap.get(xor^k);

      if(prefixMap.containsKey(xor))
        prefixMap.put(xor, prefixMap.get(xor)+1);
      else
        prefixMap.put(xor, 1);
    }

    System.out.println("Ans= "+count);
  }
}
