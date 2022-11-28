import java.util.Scanner;

/**
 * @Abdulrahman
 */
public class Interpolation_Search {

    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        System.out.print("Inter the  number for serch: ");
       

    
        int [] nums = new  int[100000000];
        for(int i=0;i<nums.length;i++){
        
        nums[i] = i+1;        
        }
        
  int high = nums.length-1 ,
      mid = 0 ,
      low = 0 ,
      sr= in.nextInt(),
      count=0;

  boolean loop = false;
 
  
  while(!loop){
      
  mid = low + ( (high - low) / (nums[high] - nums[low])) * (sr - nums[low]);
   
    if(nums[mid]==sr){
    System.out.println("number is found after: " + count);
    break;
    }
    
    
    if(nums[mid]<sr){
    low = mid+1;
    }
     
    if(nums[mid]>sr){
    high = mid - 1;
    }
      
  if(low>high){
  System.out.println("number is not found");
  break;
  }
  count++;
  }    
        
        
        
        
        }
    }
    





  
