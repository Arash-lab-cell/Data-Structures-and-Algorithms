# Range Sum Query

## Problem Statement

Given an integer array `A` of size `N` and a 2D array `B` containing `Q` queries, where each query is represented as `[L, R]`, return the sum of elements from index `L` to index `R` (both inclusive) for every query.

Return an array containing the answer for each query.

---

## Example

### Input

```text
A = [1, 2, 3, 4, 5]

B = [
    [0, 2],
    [1, 3],
    [2, 4]
]
```

### Output

```text
[6, 9, 12]
```

### Explanation

- Query `[0, 2]` → `1 + 2 + 3 = 6`
- Query `[1, 3]` → `2 + 3 + 4 = 9`
- Query `[2, 4]` → `3 + 4 + 5 = 12`

---

## Approach

A brute-force solution would calculate the sum for every query by traversing the specified range.

If there are `Q` queries, this approach takes **O(Q × N)** time in the worst case.

To optimize this, we use a **Prefix Sum Array**.

A prefix sum array stores the cumulative sum of elements from the beginning of the array up to every index.

```
PrefixSum[i] = A[0] + A[1] + ... + A[i]
```

Once the prefix sum array is constructed, the sum of any range can be computed in constant time.

- If `L == 0`

```text
Sum = PrefixSum[R]
```

- Otherwise

```text
Sum = PrefixSum[R] - PrefixSum[L - 1]
```

This allows every query to be answered in **O(1)** time.

---

## Algorithm

1. Create a prefix sum array.
2. Set:

```text
PrefixSum[0] = A[0]
```

3. Build the prefix sum array.

```text
PrefixSum[i] = PrefixSum[i - 1] + A[i]
```

4. For every query:
   - If `L == 0`, answer is `PrefixSum[R]`.
   - Otherwise, answer is:

```text
PrefixSum[R] - PrefixSum[L - 1]
```

5. Store every answer in the result array.
6. Return the result array.

---

## Dry Run

### Input

```text
A = [1, 2, 3, 4, 5]
```

### Step 1: Build Prefix Sum Array

| Index | Element | Prefix Sum |
|------:|--------:|-----------:|
| 0 | 1 | 1 |
| 1 | 2 | 3 |
| 2 | 3 | 6 |
| 3 | 4 | 10 |
| 4 | 5 | 15 |

Prefix Sum Array:

```text
[1, 3, 6, 10, 15]
```

---

### Query 1

```text
L = 0
R = 2
```

Since `L = 0`

```text
Answer = PrefixSum[2] = 6
```

---

### Query 2

```text
L = 1
R = 3
```

```text
Answer = PrefixSum[3] - PrefixSum[0]

= 10 - 1

= 9
```

---

### Query 3

```text
L = 2
R = 4
```

```text
Answer = PrefixSum[4] - PrefixSum[1]

= 15 - 3

= 12
```

Final Output

```text
[6, 9, 12]
```

---

## Why Does This Work?

The prefix sum array stores the cumulative sum of elements.

To calculate the sum of a range `[L, R]`:

- `PrefixSum[R]` contains the sum from index `0` to `R`.
- `PrefixSum[L - 1]` contains the sum from index `0` to `L - 1`.

Subtracting these two values removes the unwanted portion and leaves only the sum between `L` and `R`.

This is why each query can be answered in constant time.

---

## Complexity Analysis

### Time Complexity

Building the prefix sum array:

```text
O(N)
```

Answering each query:

```text
O(1)
```

For `Q` queries:

```text
O(Q)
```

Overall Time Complexity:

```text
O(N + Q)
```

---

### Space Complexity

```text
O(N)
```

The prefix sum array requires an additional array of size `N`.

---

## Java Solution

```java
public class Solution {

    public long[] rangeSum(int[] A, int[][] B) {

        int n = A.length;

        long[] ps = new long[n];

        ps[0] = A[0];

        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + A[i];
        }

        long[] sum = new long[B.length];

        for (int i = 0; i < B.length; i++) {

            int l = B[i][0];
            int r = B[i][1];

            if (l == 0) {
                sum[i] = ps[r];
            } else {
                sum[i] = ps[r] - ps[l - 1];
            }
        }

        return sum;
    }
}
```

---

## Key Learning

- Prefix Sum is a powerful technique for answering multiple range sum queries efficiently.
- Instead of calculating the sum for every query separately, preprocess the array once.
- After preprocessing, each query can be answered in **O(1)** time.
- Use a `long` array for the prefix sums to avoid integer overflow when the array contains large values.
- Prefix Sum is a fundamental concept used in many advanced algorithms involving arrays and range queries.
