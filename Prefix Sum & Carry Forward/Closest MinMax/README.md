# Smallest Subarray with Minimum and Maximum

## Problem Statement

Given an integer array `A`, find the length of the **smallest subarray** that contains:

- At least one occurrence of the **minimum element** of the array.
- At least one occurrence of the **maximum element** of the array.

Return the size of this smallest subarray.

---

## Example

### Input

```text
A = [1, 3, 2]
```

### Output

```text
2
```

### Explanation

- Minimum element = `1`
- Maximum element = `3`

The smallest subarray containing both is:

```text
[1, 3]
```

Length:

```text
2
```

---

## Another Example

### Input

```text
A = [2, 6, 1, 6, 9]
```

### Output

```text
3
```

### Explanation

- Minimum element = `1`
- Maximum element = `9`

The smallest subarray containing both is:

```text
[1, 6, 9]
```

Length:

```text
3
```

---

## Approach

The solution is completed in two phases.

### Step 1: Find the Minimum and Maximum Elements

Traverse the array once to determine:

- The smallest element.
- The largest element.

---

### Step 2: Find the Smallest Valid Subarray

Traverse the array again while keeping track of:

- The most recent index where the minimum element was found.
- The most recent index where the maximum element was found.

Whenever both indices have been seen:

- Compute the length of the subarray between them.

```text
Length = |maxIndex - minIndex| + 1
```

Keep updating the smallest length found.

Since only the latest occurrences are needed, every possible smallest subarray is considered efficiently.

---

## Algorithm

1. Find the minimum and maximum values in the array.
2. Initialize:
   - `minIndex = -1`
   - `maxIndex = -1`
   - `answer = N`
3. Traverse the array.
4. Whenever the minimum element is found:
   - Update `minIndex`.
5. Whenever the maximum element is found:
   - Update `maxIndex`.
6. If both indices have been encountered:
   - Compute the current subarray length.
   - Update the minimum answer if needed.
7. Return the smallest length.

---

## Dry Run

### Input

```text
A = [2, 6, 1, 6, 9]
```

Minimum:

```text
1
```

Maximum:

```text
9
```

---

### Traversal

| Index | Value | Min Index | Max Index | Current Length | Best Answer |
|------:|------:|----------:|----------:|---------------:|------------:|
| 0 | 2 | -1 | -1 | — | 5 |
| 1 | 6 | -1 | -1 | — | 5 |
| 2 | 1 | 2 | -1 | — | 5 |
| 3 | 6 | 2 | -1 | — | 5 |
| 4 | 9 | 2 | 4 | 3 | 3 |

Final Answer

```text
3
```

---

## Another Dry Run

### Input

```text
A = [1, 5, 2, 5, 1]
```

Minimum:

```text
1
```

Maximum:

```text
5
```

Traversal:

| Index | Value | Min Index | Max Index | Best Length |
|------:|------:|----------:|----------:|------------:|
| 0 | 1 | 0 | -1 | 5 |
| 1 | 5 | 0 | 1 | 2 |
| 2 | 2 | 0 | 1 | 2 |
| 3 | 5 | 0 | 3 | 2 |
| 4 | 1 | 4 | 3 | 2 |

Final Answer

```text
2
```

---

## Why Does This Work?

The smallest valid subarray must begin or end at an occurrence of either the minimum or maximum element.

While traversing the array:

- Every time a minimum is encountered, the algorithm checks the most recent maximum.
- Every time a maximum is encountered, it checks the most recent minimum.

The distance between these two latest occurrences gives the smallest possible subarray ending at the current position.

By keeping the minimum length found during the traversal, the algorithm guarantees the optimal answer.

---

## Complexity Analysis

### Time Complexity

Finding the minimum and maximum values:

```text
O(N)
```

Finding the smallest subarray:

```text
O(N)
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

    public int solve(int[] A) {

        int min = A[0];
        int max = A[0];

        for (int i = 0; i < A.length; i++) {

            if (A[i] > max) {
                max = A[i];
            }

            if (A[i] < min) {
                min = A[i];
            }
        }

        int max_i = -1;
        int min_i = -1;

        int sub_ar = A.length;

        for (int i = 0; i < A.length; i++) {

            int diff = 0;

            if (A[i] == max) {
                max_i = i;
            }

            if (A[i] == min) {
                min_i = i;
            }

            if (max_i != -1 && min_i != -1) {

                if (max_i > min_i) {
                    diff = max_i - min_i + 1;
                } else {
                    diff = min_i - max_i + 1;
                }

                if (diff < sub_ar) {
                    sub_ar = diff;
                }
            }
        }

        return sub_ar;
    }
}
```

---

## Key Learning

- The problem can be solved efficiently without generating all possible subarrays.
- First identify the global **minimum** and **maximum** values in the array.
- During a second traversal, keep track of the latest positions where these values occur.
- Whenever both positions are known, compute the current subarray length and update the minimum answer.
- This approach avoids the **O(N²)** brute-force solution and achieves an optimal **O(N)** time complexity with **O(1)** extra space.
