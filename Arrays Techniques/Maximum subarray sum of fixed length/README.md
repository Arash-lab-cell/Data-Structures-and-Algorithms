# Maximum Sum Subarray of Size B

## Problem Statement

You are given:

- An integer array `A` of length `N`.
- An integer `B` representing the required subarray size.

Your task is to find the **maximum sum** among all contiguous subarrays of length `B`.

Return the maximum possible subarray sum.

---

## Example

### Input

```text
A = [2, 1, 5, 1, 3, 2]

B = 3
```

### Output

```text
9
```

### Explanation

All subarrays of length `3` are:

| Subarray | Sum |
|----------|----:|
| [2, 1, 5] | 8 |
| [1, 5, 1] | 7 |
| [5, 1, 3] | 9 |
| [1, 3, 2] | 6 |

The maximum sum is:

```text
9
```

---

## Another Example

### Input

```text
A = [4, 2, 1, 7]

B = 2
```

### Output

```text
8
```

### Explanation

Subarrays of length `2`:

| Subarray | Sum |
|----------|----:|
| [4, 2] | 6 |
| [2, 1] | 3 |
| [1, 7] | 8 |

Maximum sum:

```text
8
```

---

## Approach

A brute-force solution would generate every subarray of length `B` and compute its sum separately.

This requires **O(N × B)** time.

A more efficient solution uses the **Sliding Window Technique**.

### Sliding Window

1. Calculate the sum of the first window of size `B`.
2. Store it as the current maximum.
3. Slide the window one position to the right by:
   - Removing the leftmost element.
   - Adding the next element.
4. Update the maximum sum after each slide.

Since each new window is derived from the previous one, every update takes constant time.

---

## Algorithm

1. Compute the sum of the first `B` elements.
2. Initialize the answer with this sum.
3. Slide the window through the remaining array.
4. For every new window:
   - Remove the outgoing element.
   - Add the incoming element.
   - Update the maximum sum if needed.
5. Return the maximum sum.

---

## Dry Run

### Input

```text
A = [2, 1, 5, 1, 3, 2]

B = 3
```

---

### Initial Window

```text
[2, 1, 5]
```

Sum:

```text
8
```

Maximum:

```text
8
```

---

### Slide 1

Remove:

```text
2
```

Add:

```text
1
```

Window:

```text
[1, 5, 1]
```

Sum:

```text
7
```

Maximum:

```text
8
```

---

### Slide 2

Remove:

```text
1
```

Add:

```text
3
```

Window:

```text
[5, 1, 3]
```

Sum:

```text
9
```

Maximum:

```text
9
```

---

### Slide 3

Remove:

```text
5
```

Add:

```text
2
```

Window:

```text
[1, 3, 2]
```

Sum:

```text
6
```

Maximum remains:

```text
9
```

Final Answer:

```text
9
```

---

## Why Does This Work?

Every contiguous subarray of length `B` differs from the previous one by exactly one element.

Instead of recalculating the entire sum for each window:

- Subtract the element leaving the window.
- Add the element entering the window.

```text
New Window Sum
=
Previous Window Sum
- Outgoing Element
+ Incoming Element
```

This allows every window sum to be computed in **O(1)** time.

Since every possible window is checked once, the algorithm correctly finds the maximum subarray sum.

---

## Complexity Analysis

### Time Complexity

Computing the first window:

```text
O(B)
```

Sliding the window through the remaining elements:

```text
O(N - B)
```

Overall:

```text
O(N)
```

---

### Space Complexity

Only a few variables are used.

```text
O(1)
```

---

## Java Solution

```java
public class Solution {

    public long solve(int[] A, int B) {

        long n = A.length;

        long sum = 0;

        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        long ans = sum;

        for (int i = 1, j = B; j < n; i++, j++) {

            sum = sum - A[i - 1] + A[j];

            ans = Math.max(sum, ans);
        }

        return ans;
    }
}
```

---

## Key Learning

- The **Sliding Window Technique** is an efficient approach for problems involving fixed-size contiguous subarrays.
- Compute the sum of the first window once, then update it by removing the outgoing element and adding the incoming element.
- This avoids recalculating the entire sum for every window, reducing the time complexity from **O(N × B)** to **O(N)**.
- The technique uses only **O(1)** extra space, making it both time- and space-efficient.
- Sliding windows are widely used in problems involving fixed-length subarrays, such as finding maximum sums, minimum sums, averages, and frequency-based computations.
