# Sum of All Subarray Sums

## Problem Statement

You are given an integer array `A` of length `N`.

Your task is to calculate the **sum of the sums of all possible subarrays** of the array.

A **subarray** is a contiguous part of an array obtained by removing zero or more elements from either end.

A **subarray sum** is the sum of all elements present in that subarray.

> **Note:** Since the answer can be very large, use an appropriate data type such as `long` to avoid integer overflow.

---

## Example

### Input

```text
A = [1, 2, 3]
```

### Output

```text
20
```

### Explanation

All possible subarrays are:

| Subarray | Sum |
|----------|----:|
| [1] | 1 |
| [1, 2] | 3 |
| [1, 2, 3] | 6 |
| [2] | 2 |
| [2, 3] | 5 |
| [3] | 3 |

Total:

```text
1 + 3 + 6 + 2 + 5 + 3 = 20
```

---

## Approach

A brute-force solution would:

1. Generate every possible subarray.
2. Calculate the sum of each subarray.
3. Add all the sums together.

This approach takes **O(N²)** subarrays, and each subarray may require **O(N)** time to compute its sum, resulting in **O(N³)** time complexity.

A much better observation is that **each array element contributes to multiple subarrays**.

Instead of generating every subarray, calculate **how many subarrays include each element**.

---

### Contribution of an Element

Consider an element at index `i`.

It can be the part of every subarray that:

- Starts anywhere from index `0` to `i`.
- Ends anywhere from index `i` to `N - 1`.

Number of possible starting positions:

```text
i + 1
```

Number of possible ending positions:

```text
N - i
```

Therefore, the number of subarrays containing `A[i]` is:

```text
(i + 1) × (N - i)
```

Hence, the contribution of `A[i]` to the final answer is:

```text
A[i] × (i + 1) × (N - i)
```

Adding the contribution of every element gives the required answer.

---

## Algorithm

1. Initialize the answer as `0`.
2. Traverse the array.
3. For each index `i`:
   - Calculate the number of subarrays containing `A[i]`.

```text
Frequency = (i + 1) × (N - i)
```

4. Add the contribution:

```text
Answer += A[i] × Frequency
```

5. Return the final answer.

---

## Dry Run

### Input

```text
A = [1, 2, 3]
```

| Index | Value | Frequency `(i+1) × (N-i)` | Contribution |
|------:|------:|--------------------------:|-------------:|
| 0 | 1 | 3 | 3 |
| 1 | 2 | 4 | 8 |
| 2 | 3 | 3 | 9 |

Total:

```text
3 + 8 + 9 = 20
```

Final Answer

```text
20
```

---

## Another Dry Run

### Input

```text
A = [4, 5]
```

Subarrays:

```text
[4]
[4, 5]
[5]
```

Sum:

```text
4 + 9 + 5 = 18
```

Using the formula:

| Index | Value | Frequency | Contribution |
|------:|------:|----------:|-------------:|
| 0 | 4 | 2 | 8 |
| 1 | 5 | 2 | 10 |

Total:

```text
8 + 10 = 18
```

---

## Why Does This Work?

Instead of calculating every subarray separately, the algorithm counts **how many times each element appears across all subarrays**.

For an element at index `i`:

- It can be paired with any starting index from `0` to `i`.
- It can be paired with any ending index from `i` to `N - 1`.

Thus, the total number of subarrays containing that element is:

```text
(i + 1) × (N - i)
```

Multiplying this count by the element's value gives its total contribution.

Summing the contributions of all elements produces the sum of all subarray sums in linear time.

---

## Complexity Analysis

### Time Complexity

The array is traversed once.

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

    public long subarraySum(int[] A) {

        long n = A.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {

            long freq = (long) (i + 1) * (n - i);

            ans += (long) A[i] * freq;
        }

        return ans;
    }
}
```

---

## Key Learning

- Instead of generating every subarray, calculate the **contribution** of each element.
- An element at index `i` appears in exactly **(i + 1) × (N − i)** subarrays.
- Contribution techniques are powerful for optimizing problems involving all subarrays or all subsequences.
- Using this observation reduces the time complexity from **O(N³)** (or **O(N²)** with prefix sums) to **O(N)**.
- Since the number of subarrays and the final answer can be very large, use the `long` data type to avoid integer overflow.
