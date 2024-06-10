# Lec 5
## Access Control
```
private -- only access in the class (.java)
package private -- only within the package
protected -- accessed from classes in the same package or subclasses
public
```

## Primitive Data Type
int
long
char
float
double
boolean


## ADT
e.g. Array, List, Set, Map

Constructor: if not assigned, compiler will create a default on with no parameter
Destructor

Getter / Setter

## Sorting

### Bubble Sort
Best Cases (improved: already sorted): $O(n)$
Worst Case: $O(n^2)$

### Selection Sort
Selection Sort divides the input list into two parts: a sorted sublist of items which is built up from left to right at the front of the list, and a sublist of the remaining unsorted items. It repeatedly selects the smallest (or largest, depending on the order) element from the unsorted sublist and moves it to the sorted sublist.

So you might need a function like `findMin(ls, i, j)`

Best Case: $O(n^2)$
Worst Case: $O(n^2)$

### Insertion Sort
Use a ptr whose left sublist is sorted and right sublist is not. Each time take the element at ptr compare with left sublist to find the proper place for it then insert. 
Shifting elements might be necessary.

Best Case: $O(n)$
Worst Case: $O(n^2)$

### Merge Sort
Best Case: $O(nlogn)$
Worst Case: $O(nlogn)$
Space Complexity: $O(n)$

### Heap Sort
Heap Sort involves building a binary heap from the input data and then repeatedly extracting the maximum element from the heap (placing it at the end of the sorted list) and rebuilding the heap until all elements are sorted.

Best Case: $O(nlogn)$
Worst Case: $O(nlogn)$


### Quick Sort
```py
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[-1]
        left = [x for x in arr[:-1] if x <= pivot]
        right = [x for x in arr[:-1] if x > pivot]
        return quick_sort(left) + [pivot] + quick_sort(right)
```
```java
public class QuickSort {
    
    // Main function to sort an array using quick sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Partitioning index
            quickSort(arr, low, pi - 1); // Recursively sort elements before partition
            quickSort(arr, pi + 1, high); // Recursively sort elements after partition
        }
    }
    
    // Function to partition the array on the basis of pivot element
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;        // i will trace the index of first 'greater' element than pivot, ready for swapping with 'smaller' element on the right side
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    // Utility function to print the array
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Main method to test the sorting algorithm
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("Original array:");
        printArray(arr);
        
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
```

`partition()` choose the last element as pivot, swap some element on its left to part them into two parts according to the comparison result with pivot. Then swap the pivot to the first element in the 'larger' part.

Best Case: $O(nlogn)$
Worst Case: $(n^2)$ (reversely sorted)

$$
\begin{align*}
T_{best}(n)&=2T(\frac{n}{2})+n\\
&=2[2[2T(\frac{n}{8}) + \frac{n}{4}] + \frac{n}{2}] +n \\
&=8T(\frac{n}{8}) + n + n+ n\\
&=2^kT(\frac{n}{2^k}) + kn\\
&=nT(1)+n\cdot logn\\
&\to O(n\cdot logn)
\end{align*}
$$
$$
\begin{align*}
T_{worsts}(n)&=2T(n)+n\\
&=2[2[2T(n) + n] + n] +n \\
&=8T(n) + 8n + 4n+ n\\
&=2^kT(n) + 2^k\cdot n\\
&=nT(1)+n\cdot n\\
&\to O(n^2)
\end{align*}
$$$

### Counting Sort
Prerequisite: Known, limited input value scale.

Time Complexity: $O(n+k)$, k is range of input, n is the size of unsorted array 


### Radix Sort
Starting from least significant digit, put the elements to corresponding buckets labeled by the radix ($O(n)$). Right after than, immediately combined these buckets together in order ($O(k)$). Then repeat for each digit (d times)

Complexity: $O(d\cdot (n+k))$

## Data Structure

### Linked List
