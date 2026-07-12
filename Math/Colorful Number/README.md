# Colorful Number

## Problem Statement
Given a number `A`, find if it is a COLORFUL number or not. A number can be broken into different consecutive sequences of digits. For example, the number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245. A number is COLORFUL if the product of every one of its consecutive digit sub-sequences is different (no two sub-sequences produce the same product). If `A` is a COLORFUL number, return `1`; otherwise return `0`.

**Constraints:** `1 <= A <= 2 * 10^9`

**Input Format:** A single integer `A`.

**Output Format:** `1` if `A` is COLORFUL, else `0`.

## Example(s)

| Input | Output | Why |
|---|---|---|
| `A = 23` | `1` | Sub-sequences: 2→2, 3→3, 23→6 — all three products (2, 3, 6) are distinct |
| `A = 236` | `0` | Sub-sequences include 23→6 and 6→6 — both produce the product 6, so it's not colorful |

## Approach
Extract the digits of `A` into a list (this naturally reverses their order, so the list is reversed back to restore left-to-right order). Then, for every starting digit position, walk forward multiplying in each subsequent digit to generate the product of every consecutive sub-sequence starting at that position. Track every product seen so far in a set/list; if any newly computed product has already been seen, the number is not colorful.

## Algorithm
1. Extract digits of `A` one at a time using `A % 10` and `A / 10`, appending each to a list — this yields digits in reverse order.
2. Reverse the digit list with a two-pointer swap so digits are back in their original left-to-right order.
3. For each starting index `i` from `0` to `size-1`:
   - Initialize a running product `prod = 1`.
   - For each ending index `j` from `i` to `size-1`, multiply `prod` by digit `j`.
   - If `prod` has already been recorded, return `0` immediately (duplicate product found).
   - Otherwise record `prod` as seen.
4. If no duplicate product was ever found, return `1`.

## Dry Run
`A = 236` → digits (after extraction+reversal) = [2, 3, 6]
- i=0: j=0 → prod=2 (new); j=1 → prod=2*3=6 (new); j=2 → prod=6*6=36 (new)
- i=1: j=1 → prod=3 (new); j=2 → prod=3*6=18 (new)
- i=2: j=2 → prod=6 → **already seen** (from i=0, j=1) → return 0

## Why Does This Work?
Every consecutive digit sub-sequence corresponds to exactly one `(i, j)` start/end pair, and the nested loop enumerates all of them exactly once. Because the check for a duplicate product happens immediately after each product is computed, the very first repeat is caught as soon as it occurs, giving an early and correct exit the moment the "colorful" property is violated.

## Complexity Analysis
**Time Complexity:** O(D²) where D is the number of digits in `A` (at most 10 for the given constraints) — the nested loop considers every sub-sequence once.
**Space Complexity:** O(D²) in the worst case, since up to O(D²) distinct products may be stored before a duplicate (if any) is found.

## Solution
```java
public class Solution {
    public int colorful(int A) {
        ArrayList <Integer> al = new ArrayList<>();
        while(A > 0){
            al.add(A%10);
            A = A/10;
        }
        int l = 0;
        int r = al.size() - 1;
        while(l < r){
            int temp = al.get(l);
            al.set(l, al.get(r));
            al.set(r, temp);
            l++;
            r--;
        }
        ArrayList<Long> product = new ArrayList<>();
        for(int i = 0; i < al.size(); i++){
            Long prod = 1L;
            for(int j = i; j < al.size(); j++){
              prod = prod * al.get(j);
              if(product.contains(prod)){
                  return 0;
              }else{
                  product.add(prod);
              }

            }
        }
        return 1;
    }
}
```

## Key Learning
Digit extraction via repeated `% 10` / `/ 10` always yields digits in reverse order — remembering to reverse them back (or adjusting the traversal direction) is a small but easy-to-miss detail whenever a problem cares about digit order, not just digit values. Using `Long` for the running product also matters here: with up to 10 digits, the product could otherwise overflow a 32-bit `int`.
