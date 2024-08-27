/** 
 *@author Yuqi Max Zhang 
 *@classn_name CISC 190 
 */
import java.util.Scanner;
public class ArrayOp {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello there, please input the number of itmes in the array:\n");
        int number;
        while (true){
            number = scan.nextInt();
            if(number <= 0){
                System.out.println("There should be at least 1 number on this array.");
                continue;
            }
            break;
        }
        int[] arr = new int[number];
        System.out.println("Please enter " + arr.length+ " integers.");
        for(int i = 0 ; i < arr.length;i++){
            arr[i] = scan.nextInt();
        }
        boolean loop = true;
        while(loop){
            System.out.println("Your current Array is: ");
            printArray(arr);
            System.out.println("Please choose from the following options: \n1. view the sum and average for the elements in your array.\n2. view the maximum and minimum in your array.\n3. search for a specific integer in your array.\n4. sort your array.\n5. reverse the Array.\n6. exit the program.");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("The sum of all numbers in your array is " + sumArray(arr)+ ", the average of these numbers is "+ ((double)sumArray(arr)/arr.length)+ ".");
                    break;
                case 2:
                    System.out.println(("The maximum value in this array is "+ findMax(arr) + ", and the minimum value in this array is " + findMin(arr)+"."));
                    break;
                case 3:
                System.out.println("Please put in the integer you'd like to search for:");
                int target = scan.nextInt();
                if(searchValueIndex(arr, target) == -1){
                    System.out.println(target + " did not appear on this Array.");
                    break;
                }
                System.out.println("The first time " + target + " appeared on this array is at index " + searchValueIndex(arr, target) + ".");
                    break;
                case 4:
                    sortArrayAsc(arr);
                    System.out.println("Your array has been sorted!");
                    break;
                case 5:
                    reverseArray(arr);
                    System.out.println("Your array has been reversed.");
                    break;
                case 6:
                    System.out.println("Thank you for using array manipulation, goodbye.");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        scan.close();
    }
    public static void reverseArray(int[] arr){
        for(int i = 0; i < arr.length / 2 ;i ++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
    public static void sortArrayAsc(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void printArray(int[] arr){
        String result = "";
        for(int i = 0; i < arr.length; i++){
            result += arr[i] + ", ";
        }
        result = result.substring(0, result.length()-2);
        System.out.println(result);
    }
    public static int findMax(int[] arr){
        int result = arr[0];
        for(int i = 1 ; i < arr.length; i++){
            if(arr[i]> result){
                result = arr[i];
            }
        }
        return result;
    }
    public static int findMin(int[] arr){
        int result = arr[0];
        for(int i = 1 ; i < arr.length; i++){
            if(arr[i]< result){
                result = arr[i];
            }
        }
        return result;
    }
    public static int searchValueIndex(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if (arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    
    public static int sumArray(int[] arr){
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            result += arr[i];
        }
        return result;
    }
}
