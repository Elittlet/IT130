import java.util.Scanner;

public class sorting {
	public int[] array;
	
	
	//method for selectionSort
	public static void selectionSort(int array[]){
		//for loop that traverses the array
		for (int i = 0; i < array.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < array.length; j++){  
                if (array[j] < array[index]){  
                    index = j;
                }  
            }
            }
		
		
	}
	//method to perform Insertion Sort on chosen array
	public static void insertionSort(int array[]){
		int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
		
	}
	
	//method to perform Bubble Sort
	public static void bubbleSort(int array[]){
		int n = array.length;
	    int x = 0;
	    //Iterate over the array until the array is sorted
	    for (int i = 0; i < n; i++) {
	        for (int j = 1; j < (n - i); j++) {
	        	//If the last element is more than the next element, swap elements
	            if (array[j - 1] > array[j]) {
	                x = array[j - 1];
	                array[j - 1] = array[j];
	                array[j] = x;
	            }
	        }
	    }
	}
	
	//Quicksort Main function
	public static void quickSortleft(int[] array) {
		//call to the quick sort helper function
        quickSorthelper(array, 0, array.length - 1);
    }
	
	//QuickSort helper function
	public static void quickSorthelper(int[] array, int start, int end) {
	     //splitting the array
        int idx = partition(array, start, end);

        // Recursively call quicksort with left part of the partitioned array
        if (start < idx - 1) {
            quickSorthelper(array, start, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (end > idx) {
            quickSorthelper(array, idx, end);
        }
    }
	
	public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // exchange the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increases left index and decreases right index
                left++;
                right--;
            }
        }
        return left;
    }

	public static void quickSortMed(int[] array, int low, int high) {
		//If the array is empty return
		if (array == null || array.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// Get the pivot point
		int middle = low + (high - low) / 2;
		int pivot = array[middle];
 
		// make left less pivot and right more pivot
		int i = low, j = high;
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
 
			while (array[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSortMed(array, low, j);
 
		if (high > i)
			quickSortMed(array, i, high);
	}
	
	//method for user to choose which type of input to sort
	public static int[] choose(){
		Scanner s=new Scanner(System.in);
		//Ask the user for the size of the array
	    System.out.print("enter number of elements in Array: ");

	    int n=s.nextInt();
	    //Creates the array for the user
	    int inputArray[]=new int[n];
	    // A for loop, asking the user for the elements in the array until the array filled
	    for(int i=0;i<n;i++){//for reading array
	    	System.out.print("Enter intergers for the array: ");
	        inputArray[i]=s.nextInt();

	    }

		s.close();
		
		return inputArray; //return the array to be used
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		int[] theArray = choose();
		
		//Runs selection sort while logging the time in Nano Seconds
		long startTime = System.nanoTime();
		selectionSort(theArray);
		long stopTime = System.nanoTime();
		long total = stopTime - startTime;
		System.out.println("Total time to run Selection sort: " + total + "ns");
		
		//Runs Bubble Sort while logging the time in Nano Seconds
		startTime = System.nanoTime();
		bubbleSort(theArray);
		stopTime = System.nanoTime();
		total = stopTime - startTime;
		System.out.println("Total time to run Bubble sort: " + total + "ns");
		
		//Runs Insertion sort while logging the time in Nano seconds
		startTime = System.nanoTime();
		insertionSort(theArray);
		stopTime = System.nanoTime();
		total = stopTime - startTime;
		System.out.println("Total time to run Insertion sort: " + total + "ns");
		
		//Runs Quick Sort with right most element as pivot and logs time in nano seconds
		startTime = System.nanoTime();
		quickSortleft(theArray);
		stopTime = System.nanoTime();
		total = stopTime - startTime;
		System.out.println("Total time to run Quicksort Right Pivot: " + total + "ns");
		
		//Runs Quick sort with median pivot and log time in nano seconds
		startTime = System.nanoTime();
		quickSortMed(theArray, theArray[0], theArray.length -1);
		stopTime = System.nanoTime();
		total = stopTime - startTime;
		System.out.println("Total time to run Quicksort Median Pivot: " + total + "ns");
			
		
		
	}

}
