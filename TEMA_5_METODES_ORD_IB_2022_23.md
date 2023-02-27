# TEMA_5_METODES_ORD_IB_2022_23.pdf

[TEMA_5_METODES_ORD_IB_2022_23.pdf](TEMA_5_METODES_ORD_IB_2022_23/TEMA_5_METODES_ORD_IB_2022_23.pdf)

# Mètodes d’ordenació

## Mètode de selecció

```jsx
function selectionSort(arr):
    n = length(arr)
    for i from 0 to n-2:
        minIndex = i
        for j from i+1 to n-1:
            if arr[j] < arr[minIndex]:
                minIndex = j
        if minIndex != i:
            swap arr[i] and arr[minIndex]
    return arr
```

In this pseudocode, **`arr`** represents the array to be sorted. The **`selectionSort`** function takes this array as an input and returns the sorted array.

The algorithm works by iterating over the array and finding the smallest element in the unsorted portion of the array, swapping it with the first unsorted element, and continuing until the entire array is sorted.

The outer loop starts at the first element and iterates up to the second to last element (**`n-2`**) because the last element will already be sorted by the time the inner loop finishes sorting the second to last element.

The inner loop starts at the next element after the outer loop index (**`i+1`**) and iterates up to the last element (**`n-1`**). It finds the smallest element in the unsorted portion of the array by comparing each element to the current minimum (**`arr[minIndex]`**) and updating **`minIndex`** if a smaller element is found.

If the smallest element is not the current element (**`minIndex != i`**), then the elements at indices **`i`** and **`minIndex`** are swapped.

Finally, the sorted array is returned.

## Mètode d’inserció

```jsx
function insertionSort(arr):
    n = length(arr)
    for i from 1 to n-1:
        currentValue = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > currentValue:
            arr[j+1] = arr[j]
            j = j - 1
        arr[j+1] = currentValue
    return arr
```

In this pseudocode, **`arr`** represents the array to be sorted. The **`insertionSort`** function takes this array as an input and returns the sorted array.

The algorithm works by iterating over the array and inserting each element into its proper place in the sorted portion of the array.

The outer loop starts at the second element (**`i=1`**) and iterates up to the last element (**`n-1`**). The current value to be inserted into the sorted portion of the array is stored in the **`currentValue`** variable.

The inner loop starts at the element before the current value (**`j=i-1`**) and iterates backwards until it finds the proper place for the current value in the sorted portion of the array. It does this by comparing each element to the current value and shifting elements up one position until it finds the correct place for the current value.

Once the correct position is found, the current value is inserted into that position (**`arr[j+1] = currentValue`**).

Finally, the sorted array is returned.

## Sorting algorithms flowcharts

![sorting algorithms.png](TEMA_5_METODES_ORD_IB_2022_23%20/sorting_algorithms.png)

# Mètodes de búsqueda

## Mètode de búsqueda lineal

```jsx
function linearSearch(arr, target):
    n = length(arr)
    for i from 0 to n-1:
        if arr[i] == target:
            return i
    return -1
```

In this pseudocode, **`arr`** represents the array to be searched, and **`target`** represents the value being searched for. The **`linearSearch`** function takes these two inputs and returns the index of the first occurrence of the target value in the array. If the target value is not found in the array, it returns -1.

The algorithm works by iterating over the array and comparing each element to the target value. If a match is found, the function immediately returns the index of that element. If no match is found, the function returns -1 after iterating over the entire array.

The outer loop iterates over each element in the array (**`i`** from 0 to n-1). Inside the loop, the current element is compared to the target value using an **`if`** statement. If the current element is equal to the target value, the function returns the index of that element (**`i`**). If the entire loop finishes without finding a match, the function returns -1.

## Mètode de búsqueda binària

```jsx
function binarySearch(arr, target):
    left = 0
    right = length(arr) - 1
    while left <= right:
        mid = floor((left + right) / 2)
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
```

In this pseudocode, **`arr`** represents the sorted array to be searched, and **`target`** represents the value being searched for. The **`binarySearch`** function takes these two inputs and returns the index of the target value in the array. If the target value is not found in the array, it returns -1.

The algorithm works by repeatedly dividing the search interval in half until the target value is found or the search interval is empty.

The function starts by initializing two pointers: **`left`** and **`right`**. The **`left`** pointer is set to the beginning of the array (index 0), and the **`right`** pointer is set to the end of the array (index **`length(arr) - 1`**).

The while loop continues until the search interval is empty (**`left > right`**). Inside the loop, the middle index (**`mid`**) of the search interval is calculated using integer division and the **`floor`** function. The middle element is then compared to the target value using an **`if`** statement.

If the middle element is equal to the target value, the function immediately returns the index of that element (**`mid`**).

If the middle element is less than the target value, the search interval is narrowed to the right half of the array (**`left = mid + 1`**).

If the middle element is greater than the target value, the search interval is narrowed to the left half of the array (**`right = mid - 1`**).

If the entire loop finishes without finding a match, the function returns -1.

## Search algorithms flowcharts

![search methods.png](TEMA_5_METODES_ORD_IB_2022_23%20/search_methods.png)

## Improvements for these methods

### Selection Sort

One possible improvement to the selection sort algorithm is to use a heap data structure to select the maximum element in each iteration, rather than iterating over the unsorted portion of the array. This would improve the time complexity of the algorithm from O(n^2) to O(n log n).

```python
function heapSort(arr):
    def heapify(parent_idx, end_idx):
        largest_idx = parent_idx
        left_child_idx = 2 * parent_idx + 1
        right_child_idx = 2 * parent_idx + 2
        if left_child_idx <= end_idx and arr[left_child_idx] > arr[largest_idx]:
            largest_idx = left_child_idx
        if right_child_idx <= end_idx and arr[right_child_idx] > arr[largest_idx]:
            largest_idx = right_child_idx
        if largest_idx != parent_idx:
            arr[parent_idx], arr[largest_idx] = arr[largest_idx], arr[parent_idx]
            heapify(largest_idx, end_idx)

    n = len(arr)
    for i in range(n//2 - 1, -1, -1):
        heapify(i, n - 1)
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(0, i - 1)

    return arr
```

### Insertion Sort

One possible improvement to the insertion sort algorithm is to use binary search to find the correct position to insert each element, rather than iterating over the sorted portion of the array. This would improve the time complexity of the algorithm from O(n^2) to O(n log n).

```python
def binaryInsertionSort(arr):
    def binarySearch(left, right, target):
        while left <= right:
            mid = (left + right) // 2
            if arr[mid] == target:
                return mid
            elif arr[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left

    n = len(arr)
    for i in range(1, n):
        temp = arr[i]
        j = i - 1
        insert_idx = binarySearch(0, j, temp)
        while j >= insert_idx:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = temp

    return arr
```

### Linear Search and Binary Search

One possible improvement to both linear and binary search algorithms is to use a hash table or dictionary to store the elements of the array along with their indices. This would allow for constant-time lookup of elements, improving the time complexity of the algorithms. However, this would require extra memory for storing the hash table or dictionary, so it may not be practical for very large arrays.

```python
def linearSearchDict(arr, target):
    dict_arr = {arr[i]: i for i in range(len(arr))}
    if target in dict_arr:
        return dict_arr[target]
    else:
        return -1
```

```python
def binarySearchDict(arr, target):
    dict_arr = {arr[i]: i for i in range(len(arr))}
    left = 0
    right = len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return dict_arr[target]
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
```

# Mètode Quicksort

QuickSort is a divide-and-conquer sorting algorithm that sorts an array by selecting a "pivot" element and partitioning the array into two sub-arrays, according to whether they are smaller or larger than the pivot. The pivot element can be chosen in several ways, but a common approach is to choose the last element in the array.

The algorithm works as follows:

1. Choose a pivot element from the array.
2. Partition the array into two sub-arrays: one with elements smaller than the pivot, and one with elements larger than the pivot.
3. Recursively sort the sub-arrays by applying the same procedure to them.
4. Combine the sorted sub-arrays into a single sorted array.

The partitioning step is performed as follows:

1. Set two pointers, i and j, to the first and second-to-last elements in the array, respectively.
2. Move i to the right until an element greater than or equal to the pivot is found.
3. Move j to the left until an element less than or equal to the pivot is found.
4. If i < j, swap the elements at positions i and j and continue.
5. If i >= j, swap the pivot element with the element at position i and return i (the position of the pivot element).

After the partitioning step is performed, the pivot element is in its final sorted position, and the array is partitioned into two sub-arrays, which are sorted recursively.

The time complexity of QuickSort depends on the choice of pivot, but on average, it is O(n log n). However, in the worst case (when the pivot is always the smallest or largest element), the time complexity can be O(n^2). Various techniques can be used to mitigate this problem, such as choosing a random pivot or using the median-of-three pivot selection method. QuickSort is a popular sorting algorithm due to its relatively fast average-case performance and ease of implementation.
