# Assignment 1 — Divide and Conquer Algorithms

## What I did
In this project, I implemented **4 classic divide-and-conquer algorithms** in Java:

- MergeSort
- QuickSort
- Deterministic Select (Median of Medians)
- Closest Pair of Points (2D)

I also created **JUnit5 tests** for every algorithm (10 tests each, 40 tests total).  
All tests passed successfully.

Additionally, I integrated a **Metrics system** to count:
- number of comparisons
- number of allocations
- recursion depth
- execution time (using `System.nanoTime`)

The project is organized as a Maven project with sources in `src/main/java` and tests in `src/test/java`.  
This README is my report and analysis.

---

## Algorithms and Analysis

### 1. MergeSort
- Splits array into halves, sorts recursively, and merges.
- Uses **insertion sort** for small subarrays (`cutoff = 16`).
- Uses one **shared buffer** to reduce memory allocations.

**Recurrence:**  
T(n) = 2T(n/2) + O(n)

By **Master theorem (case 2):**  
T(n) = Θ(n log n)

---

### 2. QuickSort
- Picks a **random pivot**.
- Always recurses on the **smaller partition**, iterates on the larger one → stack depth O(log n).

**Recurrence (average case):**  
T(n) = T(k) + T(n-k-1) + O(n),   k ≈ n/2

**Average case:** Θ(n log n)  
**Worst case:** Θ(n²)  
**Uneven splits:** analyzed with **Akra–Bazzi**.

---

### 3. Deterministic Select (Median of Medians)
- Finds the **k-th smallest element**.
- Groups into 5s, finds medians, then uses median of medians as pivot.
- Recurses only into the side containing the element.

**Recurrence:**  
T(n) = T(n/5) + T(7n/10) + O(n)

By **Akra–Bazzi:**  
T(n) = Θ(n)

---

### 4. Closest Pair of Points (2D)
- Sorts points by **x-coordinate**, recursively splits.
- In the strip near the middle line, sorts by **y** and checks against ≤ 7 neighbors.

**Recurrence:**  
T(n) = 2T(n/2) + O(n)

By **Master theorem (case 2):**  
T(n) = Θ(n log n)

---

## Testing
I wrote **10 JUnit tests per algorithm** (40 total).

The tests cover:
- empty arrays
- single elements
- sorted arrays
- reverse sorted arrays
- arrays with duplicates
- arrays with equal values
- negative numbers
- large random arrays
- for Closest Pair: lines, squares, diagonals, duplicates, clusters

✅ All tests passed:Tests run: 40, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
---

## Metrics & Measurements

I measured **time, comparisons, allocations, and recursion depth** using the `Metrics` class.

Example results (for demo arrays):

| Algorithm          | Time (ms) | Comparisons | Allocations | Max Depth |
|--------------------|-----------|-------------|-------------|-----------|
| MergeSort          | ~0.05     | 6           | 0           | 0         |
| QuickSort          | ~0.04     | 15          | 0           | 1         |
| DeterministicSelect| ~0.02     | 18          | 2           | 2         |
| Closest Pair       | ~0.07     | 22          | 7           | 1         |

(For real experiments I ran arrays of different sizes: n = 100, 1000, 5000. The results matched the expected growth rates from theory: MergeSort/QuickSort ≈ n log n, Select ≈ n, Closest Pair ≈ n log n.)

Plots:
- **time vs n** (MergeSort and QuickSort nearly the same, Select linear, Closest Pair ~n log n).
- **depth vs n** (QuickSort bounded by O(log n), MergeSort grows log n, Select small, Closest Pair log n).

---

## Connection to Lecture 2

- **Recursion on JVM:** each method call creates a stack frame; deep recursion may cause `StackOverflowError`. → QuickSort recurses only on smaller partition to keep depth ≈ O(log n).
- **Recursion vs Recurrence:** recursion = programming technique, recurrence = mathematical runtime model.
- **Tail-call elimination:** JVM does not guarantee it → I used safe recursion patterns.
- **Divide & Conquer:** all 4 algorithms follow split → recurse → combine.
- **Recurrence Trees:**
    - MergeSort and Closest Pair → balanced trees (Master theorem).
    - QuickSort and Select → uneven trees (Akra–Bazzi).

---

## GitHub Workflow

I followed the required workflow:

- Branches:
    - `main` (stable releases)
    - `feature/mergesort`
    - `feature/quicksort`
    - `feature/select`
    - `feature/closest`
    - `feature/metrics`

- Commits with meaningful messages:
    - `feat(mergesort): add buffer + cut-off`
    - `feat(quicksort): randomized pivot + safe recursion`
    - `feat(select): implement median-of-medians`
    - `feat(closest): add divide-and-conquer`

- Tags: `v0.1`, `v1.0`

---

## Conclusion
- Implemented **4 divide-and-conquer algorithms**.
- Verified correctness with **JUnit5 tests (40/40 passed)**.
- Integrated **Metrics**: comparisons, allocations, recursion depth, and time.
- Theoretical analysis (Master theorem & Akra–Bazzi) **matches experimental results**.
- Project is complete and ready for submission.  