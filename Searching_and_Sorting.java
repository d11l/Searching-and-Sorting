/**
 * @Abdulrahman 
 */

public class Searching_and_Sorting {

public static void main(String[] args) {
    
String[] Names = { "YAHYA", "HASAN", "EID", "MANAL", "BDOOR", "RAWIAH", "HAIFA", 
"AMJAD", "FAHAD", "OHOOD","MAHA", "SARA", "AMAL", "MEHAD", "ZAIN" };


Integer[] ID = { 3692098, 3692102, 3692104, 3692107, 3692112, 3692256, 3692449, 
3692643, 3693199, 3757224,3757225, 3757622, 3757623, 3757625, 3757628, 3757629, 3757631 };



// Test linearSearch & binarySearch
System.out.println("linearSearch: "+(linearSearch(Names , "AMAL") ? "Found!" : "Not Found!"));
System.out.println("linearSearch: "+(linearSearch(ID , 3692107 ) ? "Found!" : "Not Found!"));
System.out.println("binarySearch: "+(binarySearch(ID , 0 , ID.length , 3692107 ) ? "Found!" : "Not Found!"));
System.out.println("binarySearch: "+(binarySearch(ID , 0 , ID.length , 3692999 ) ? "Found!" : "Not Found!"));


System.out.println();



int[] Numbers = {5,4,3,11,2,6,102,3,45};

//  Sequential sorts  =>  bubble Sort , Selection Sort, Insertion sort

bubbleSort(Numbers);
SelectionSort(Numbers);
Insertion_sort(Names);

// Logarithmic sorts  =>  quick Sort, merge Sort

quick(Names,0,Names.length-1);
mergeSort(Names,Names.length);



// Test bubble Sort & Selection Sort
// Print Numbers after sorting 
System.out.print("Numbers: { ");
 for(int i = 0 ; i < Numbers.length ; i++)
    System.out.print("["+Numbers[i]+"] ");
System.out.print("}\n");

// Test Insertion sort, quick Sort, merge Sort
// Print Names after sorting 
System.out.print("Names: { ");
for(int i = 0 ; i < Names.length ; i++)
    System.out.print("["+Names[i]+"] ");
System.out.print("}\n");



}


public static <T> boolean linearSearch(T[] data,T target) {// O(n)

int i = 0;
boolean found = false;
while (!found && i <= data.length) {
found = data[i].equals(target);
i++;
}
return found;

}


public static <T extends Comparable<T>> boolean binarySearch(T[] arr , int min ,int  max, T target) {// O(log n)
    
boolean found = false;
int midpoint = (min + max) / 2; 
if (arr[midpoint].compareTo(target) == 0)
found = true;
else if (arr[midpoint].compareTo(target) > 0) {
if (min <= midpoint - 1)
found = binarySearch(arr, min, midpoint - 1, target);
} else if (midpoint + 1 <= max)
found = binarySearch(arr, midpoint + 1, max, target);
return found;
}





public static void bubbleSort(int arr[]){ // O(n^2)
    
 int temp;   
 for(int i = 0; i < (arr.length-1); i++){
     
 for(int j = arr.length-1 ; j > i; j--){
     
 if(arr[j-1] > arr[j]){    
 temp = arr[j-1];
 arr[j-1] = arr[j];
 arr[j] = temp;
 }
 }
 
}
  
}


public static void SelectionSort(int[] arr){// O(n^2)
       
for(int i = 0 ; i < arr.length ; i++){
int temp = 0 , min_index = i;    
for(int j = i + 1 ; j < arr.length ; j++){  

if(arr[j] < arr[i] && arr[j]< arr[min_index]){  
min_index = j;
}
}

temp = arr[min_index];
arr[min_index] = arr[i];
arr[i] = temp; 

}

}



public static  <T extends Comparable<T>> void Insertion_sort(T arr[]){// O(n^2)
        
for (int i = 1; i < arr.length; i++) { 
T Value = arr[i];
int j = i-1;

while (j > 0 && arr[j - 1].compareTo(Value) > 0) { 
arr[j] = arr[j - 1];
j--;
}
arr[j] = Value;
}

}


// 2 - Quick sort 

public static <T extends Comparable<T>> int partition (T arr[], int start, int end) { 

    T pivot = arr[end];
    int i = (start - 1);  
    
  for(int j = start; j <= end - 1; j++){  
       //if (a[j].compareTo(pivot) > 0 ){ // Invert
        if (pivot.compareTo(arr[j]) > 0 ){  
              i++; 
            T t = arr[i];  
            arr[i] = arr[j];  
            arr[j] = t;  
        }  
    }  
    T t = arr[i+1];  
    arr[i+1] = arr[end];  
    arr[end] = t;  
    return (i + 1);  

}  
   
public static <T extends Comparable<T>> void quick(T arr[], int start, int end){// O(N*log^2 N) and it can be with some input O(N^2)
    if (start < end){  
        
        int p = partition(arr, start, end);  
        quick(arr, start, p - 1);  
        quick(arr, p + 1, end);  
    
    }  
}  




// 3 - Merge sort 
public static <T extends Comparable<T>> void mergeSort(T[] arr, int n) {// O(n*log n)
    if (n < 2) {
        return;
    }
    int mid = n / 2;
   
   T[] l = (T[]) (new Comparable[mid]);
   T[] r = (T[]) (new Comparable[n-mid]);
   
    for (int i = 0; i < mid; i++) {
        l[i] = arr[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = arr[i];
    }
    
    mergeSort(l , mid);
    mergeSort(r , n - mid);

    merge(arr, l , r, mid, n - mid);
}


public static <T extends Comparable<T>> void merge(T[] arr, T[] l, T[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {

         //if(l[i].compareTo(r[j]) > 0 ){ // Invert
         if(r[j].compareTo(l[i]) > 0 ){    
            arr[k++] = l[i++];
        }
        else {
            arr[k++] = r[j++];
        }
    }
    while (i < left) {
        arr[k++] = l[i++];
    }
    while (j < right) {
        arr[k++] = r[j++];
    }
}


}
