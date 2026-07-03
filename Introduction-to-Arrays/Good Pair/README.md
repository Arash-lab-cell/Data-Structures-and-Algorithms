# Pair with Given Sum

## Problem Statement

Given an integer array `A` and an integer `B`, determine whether there exists a pair of elements in the array whose sum is equal to `B`.

- Return `1` if such a pair exists.
- Return `0` otherwise.

---

## Example

### Input

```text
A = [2, 7, 11, 15]
B = 9
```

### Output

```text
1
```

### Explanation

The pair `(2, 7)` has a sum equal to `9`.

---

## Approach

The array is first sorted in ascending order. After sorting, the **Two Pointer Technique** is used to efficiently search for the required pair.

Two pointers are maintained:

- `i` starts from the beginning of the array.
- `j` starts from the end of the array.

At every iteration:

- If `A[i] + A[j] == B`, the required pair is found, so return `1`.
- If the sum is greater than `B`, move the right pointer (`j`) one step left to decrease the sum.
- If the sum is less than `B`, move the left pointer (`i`) one step right to increase the sum.

The process continues until the two pointers meet.

---

## Algorithm

1. Sort the array.
2. Initialize:
   - `i = 0`
   - `j = A.length - 1`
3. While `i < j`:
   - Compute `sum = A[i] + A[j]`
   - If `sum == B`, return `1`
   - If `sum > B`, decrement `j`
   - Otherwise, increment `i`
4. If no valid pair is found, return `0`.

---

## Dry Run

### Input

```text
A = [5, 1, 4, 2]
B = 6
```

### Step 1: Sort the Array

```text
[1, 2, 4, 5]
```

| Left (`i`) | Right (`j`) | Pair | Sum | Action |
|------------|-------------|------|-----|--------|
| 1 | 5 | (1, 5) | 6 | Pair Found |

Result:

```text
1
```

---

### Another Example

### Input

```text
A = [1, 3, 5, 7]
B = 20
```

| Left (`i`) | Right (`j`) | Pair | Sum | Action |
|------------|-------------|------|-----|--------|
| 1 | 7 | (1, 7) | 8 | Move Left Pointer |
| 3 | 7 | (3, 7) | 10 | Move Left Pointer |
| 5 | 7 | (5, 7) | 12 | Move Left Pointer |

No valid pair exists.

Result:

```text
0
```

---

## Complexity Analysis

### Time Complexity

- Sorting: **O(N log N)**
- Two Pointer Traversal: **O(N)**

Overall Time Complexity:

```text
O(N log N)
```

---

### Space Complexity

```text
O(1)
```

The algorithm uses only a constant amount of extra space.

---

## Java Solution

```java
public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);

        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            int sum = A[i] + A[j];

            if (sum == B) {
                return 1;
            } else if (sum > B) {
                j--;
            } else {
                i++;
            }
        }

        return 0;
    }
}
```

---

## Key Learning

- Sorting an array enables the efficient use of the **Two Pointer Technique**.
- Two pointers eliminate the need for checking every possible pair.
- If the current sum is too large, moving the right pointer decreases the sum.
- If the current sum is too small, moving the left pointer increases the sum.
- This approach is significantly more efficient than the brute-force solution, which has a time complexity of **O(N²)**.
