# Count Elements Having at Least One Greater Element

## Problem Statement

Given an array `A` of `N` integers, count the number of elements that have **at least one element greater than themselves** in the array.

Return the count of such elements.

---

## Example

### Input

```text
A = [3, 1, 2, 3]
```

### Output

```text
2
```

### Explanation

The maximum element is `3`.

- `1` has an element greater than itself (`3`).
- `2` has an element greater than itself (`3`).
- Both occurrences of `3` do not have any element greater than themselves.

Therefore, the answer is `2`.

---

## Another Example

### Input

```text
A = [5, 5, 5]
```

### Output

```text
0
```

### Explanation

Every element is equal to the maximum value.

Since no element has a greater element in the array, the answer is `0`.

---

## Approach

An element has at least one greater element **if and only if it is not equal to the maximum element** in the array.

Therefore, the solution works as follows:

1. Find the maximum element in the array.
2. Count how many times the maximum element appears.
3. Every other element has at least one greater element.
4. Return:

```text
Number of Elements - Frequency of Maximum Element
```

---

## Algorithm

1. Initialize `max` as the first element of the array.
2. Traverse the array to find the maximum element.
3. Traverse the array again to count the frequency of the maximum element.
4. Return:

```text
A.length - frequency
```

---

## Dry Run

### Input

```text
A = [3, 1, 2, 3]
```

### Step 1: Find the Maximum Element

```text
Maximum = 3
```

### Step 2: Count Its Frequency

| Element | Is Maximum? | Frequency |
|---------:|:-----------:|----------:|
| 3 | Yes | 1 |
| 1 | No | 1 |
| 2 | No | 1 |
| 3 | Yes | 2 |

### Step 3: Compute the Answer

```text
Total Elements = 4
Frequency of Maximum = 2

Answer = 4 - 2 = 2
```

---

## Another Dry Run

### Input

```text
A = [7, 6, 5, 4]
```

Maximum element:

```text
7
```

Frequency of maximum:

```text
1
```

Answer:

```text
4 - 1 = 3
```

The elements `6`, `5`, and `4` each have at least one greater element (`7`).

---

## Why Does This Work?

The maximum element is the only value that **cannot** have a greater element in the array.

If the maximum occurs multiple times, none of its occurrences have a greater element.

Every other element is smaller than the maximum, so it automatically has at least one greater element.

Hence, the required count is simply:

```text
Total Number of Elements − Frequency of Maximum Element
```

---

## Complexity Analysis

### Time Complexity

- Finding the maximum element: **O(N)**
- Counting its frequency: **O(N)**

Overall:

```text
O(N)
```

---

### Space Complexity

```text
O(1)
```

Only a few variables are used regardless of the input size.

---

## Java Solution

```java
public class Solution {
    public int solve(int[] A) {
        int max = A[0];

        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        int freq = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == max) {
                freq++;
            }
        }

        return A.length - freq;
    }
}
```

---

## Key Learning

- An element has at least one greater element if it is **not the maximum**.
- Count the occurrences of the maximum element.
- The answer is the total number of elements minus the frequency of the maximum.
- This solution avoids sorting and solves the problem in **O(N)** time with **O(1)** extra space.
