# Special Index

## Problem Statement

Given an integer array `A` of size `N`, count the number of **special indices**.

An index is called **special** if, after removing the element at that index, the sum of elements at **even indices** becomes equal to the sum of elements at **odd indices** in the resulting array.

Return the total number of such indices.

> **Note:** After removing an element, all elements to its right shift one position to the left, causing their indices (and parity) to change.

---

## Example

### Input

```text
A = [2, 1, 6, 4]
```

### Output

```text
1
```

### Explanation

Removing the element at index `1`:

```text
Original Array

Index : 0  1  2  3
Value : 2  1  6  4
```

After removal:

```text
[2, 6, 4]
```

New indices:

```text
Index : 0  1  2
Value : 2  6  4
```

Even-indexed sum:

```text
2 + 4 = 6
```

Odd-indexed sum:

```text
6
```

Since both sums are equal, index `1` is a special index.

---

## Approach

Removing an element changes the parity (even/odd position) of every element to its right.

Therefore:

- Elements before the removed index keep their original parity.
- Elements after the removed index switch parity:
  - Even indices become odd.
  - Odd indices become even.

To efficiently calculate the sums after every possible removal, the solution constructs two prefix sum arrays:

- `ps_even` → Prefix sum of elements at even indices.
- `ps_odd` → Prefix sum of elements at odd indices.

For every index:

- Calculate the new even-index sum.
- Calculate the new odd-index sum.
- If both are equal, increment the answer.

This avoids recomputing sums for every removal.

---

## Algorithm

1. Build a prefix sum array for even indices.
2. Build a prefix sum array for odd indices.
3. Traverse every index.
4. For each index:
   - Compute the new even-index sum after removal.
   - Compute the new odd-index sum after removal.
5. If both sums are equal:
   - Increment the count.
6. Return the count.

---

## Dry Run

### Input

```text
A = [2, 1, 6, 4]
```

### Step 1: Build Prefix Sum Arrays

#### Even Index Prefix Sum

| Index | Value | Prefix Sum |
|------:|------:|-----------:|
| 0 | 2 | 2 |
| 1 | 1 | 2 |
| 2 | 6 | 8 |
| 3 | 4 | 8 |

```text
ps_even = [2, 2, 8, 8]
```

#### Odd Index Prefix Sum

| Index | Value | Prefix Sum |
|------:|------:|-----------:|
| 0 | 2 | 0 |
| 1 | 1 | 1 |
| 2 | 6 | 1 |
| 3 | 4 | 5 |

```text
ps_odd = [0, 1, 1, 5]
```

---

### Check Every Index

#### Remove Index 0

New even sum:

```text
5
```

New odd sum:

```text
6
```

Not special.

---

#### Remove Index 1

New even sum:

```text
6
```

New odd sum:

```text
6
```

Special index found.

---

#### Remove Index 2

New even sum:

```text
6
```

New odd sum:

```text
5
```

Not special.

---

#### Remove Index 3

New even sum:

```text
8
```

New odd sum:

```text
1
```

Not special.

Total Special Indices:

```text
1
```

---

## Why Does This Work?

When an element is removed:

- Elements before it remain at the same indices.
- Every element after it shifts left by one position.

This shift changes the parity of all elements to the right:

```text
Even Index → Odd Index

Odd Index → Even Index
```

Using separate prefix sums for even and odd indices allows the algorithm to compute the updated sums after each removal in constant time.

Without prefix sums, every removal would require rebuilding the array or recalculating the sums, resulting in a much slower solution.

---

## Complexity Analysis

### Time Complexity

Building the prefix sum arrays:

```text
O(N)
```

Checking every index:

```text
O(N)
```

Overall:

```text
O(N)
```

---

### Space Complexity

Two prefix sum arrays are used.

```text
O(N)
```

---

## Java Solution

```java
public class Solution {

    public int solve(int[] A) {

        int n = A.length;

        int[] ps_even = new int[n];
        ps_even[0] = A[0];

        for (int i = 1; i < n; i++) {

            if (i % 2 == 0) {
                ps_even[i] = ps_even[i - 1] + A[i];
            } else {
                ps_even[i] = ps_even[i - 1];
            }
        }

        int[] ps_odd = new int[n];
        ps_odd[0] = 0;

        for (int i = 1; i < n; i++) {

            if (i % 2 != 0) {
                ps_odd[i] = ps_odd[i - 1] + A[i];
            } else {
                ps_odd[i] = ps_odd[i - 1];
            }
        }

        int sum_even = 0;
        int sum_odd = 0;
        int special_index = 0;

        for (int i = 0; i < n; i++) {

            if (i == 0) {

                sum_even = ps_odd[n - 1] - ps_odd[i];
                sum_odd = ps_even[n - 1] - ps_even[i];

            } else {

                sum_even = ps_even[i - 1] + (ps_odd[n - 1] - ps_odd[i]);
                sum_odd = ps_odd[i - 1] + (ps_even[n - 1] - ps_even[i]);
            }

            if (sum_even == sum_odd) {
                special_index++;
            }
        }

        return special_index;
    }
}
```

---

## Key Learning

- Removing an element changes the parity (even/odd index) of all elements to its right.
- Prefix sums for even and odd indices allow these updated sums to be computed efficiently.
- Instead of recalculating sums after every removal (**O(N²)**), preprocessing enables each removal to be evaluated in **O(1)** time.
- The overall solution runs in **O(N)** time with **O(N)** extra space.
- This problem demonstrates how prefix sums can be adapted to solve problems involving dynamic index changes after element removal.
