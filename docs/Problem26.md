Nice choice for a first LeetCode patterns problem 🙂 This one is *small* but it hides a very important idea you’ll see everywhere: **two pointers on arrays**.

I’ll walk you through:

* What the problem is *really* asking
* The key concepts you need (sorted arrays, “in-place”, two pointers)
* Step-by-step reasoning on examples
* Common mistakes beginners make
* A small “practice ladder” of mini-tasks that lead to the solution

And as you asked, I **won’t** give you the actual solution or full algorithm — I’ll just equip you to build it yourself.

---

## 1. Rephrasing the problem in your own words

You’re given an array:

```text
nums = [0,0,1,1,1,2,2,3,3,4]
```

* It is **sorted in non-decreasing order** (so every next element is ≥ previous).
* It may contain **duplicates**.

You must:

1. **Modify this same array (`nums`) in-place** so that:

  * The **first `k` positions** contain **only the unique values**, in sorted order.
  * After that (`nums[k]`, `nums[k+1]`, …) the values don’t matter.

2. **Return `k`**, the number of unique values.

For example:

```text
nums (input):  [0,0,1,1,1,2,2,3,3,4]
nums (output): [0,1,2,3,4,_,_,_,_,_]
k: 5
```

Important:
LeetCode’s custom judge will only look at:

```java
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

So only the **first `k` elements** matter.

---

## 2. Key concepts you must understand

### 2.1. “Sorted in non-decreasing order”

* “Non-decreasing” means each element is **>=** the previous one.
* Example of non-decreasing:

  * `[1, 1, 2, 2, 3]`
  * `[0, 0, 0]`
  * `[-3, -3, -1, 0, 10]`
* Thanks to sorting, **all duplicates are grouped together**:

  * `[0,0,1,1,1,2,2,3,3,4]` → all `0`s together, all `1`s together, etc.

This “grouping” is the main reason this problem is easy with O(n) time.

---

### 2.2. “In-place” & O(1) extra memory

“In-place” means:

* You **cannot** use another array like `int[] aux = new int[nums.length]` and copy everything there.
* You are supposed to **reuse `nums` itself** to store the result.
* You’re allowed a **few extra variables** (`int i`, `int count`, etc.) — this is still **O(1) extra memory**.

Many beginners try:

* Creating a `Set<Integer>`, add all elements, then copy back.
  → This uses extra memory proportional to `n` (O(n)) — not what the problem wants (though LeetCode might still accept, but it misses the point).

The challenge is: **update the existing array while scanning it once**.

---

### 2.3. Two-pointers technique (high-level)

This is the key pattern.

General idea in many array problems:

* You use **two indexes** into the same array:

  * One pointer that **reads** elements (think: scanning).
  * One pointer that **writes** or tracks where to place something.

A very similar training problem:

> **Toy problem:** Given an array, move all non-zero elements to the front, keeping order, and return how many non-zero elements there are.

Example:

```text
[0, 1, 0, 3, 12] -> [1, 3, 12, ?, ?], k = 3
```

One common pattern to solve this:

* A pointer `read` goes from left to right.
* A pointer `write` marks the position where the next “good” element (e.g., non-zero) should go.
* When `nums[read]` is a “good” element, you copy it into `nums[write]` and move `write` forward.

You don’t need the exact algorithm here; just understand this **pattern**:

> “Scan with one pointer, store results compactly at the start with another pointer.”

You’ll do **something very similar** for this duplicates problem — but instead of “non-zero”, you’re looking for elements that are **different from the previous element** (because of the sorted property).

---

## 3. Understanding what the output should be

Let’s practice just understanding *what* we want, ignoring *how* to implement it.

### Example A

Input:

```text
[1,1,2]
```

Groups:

* `1,1`
* `2`

Unique values: `1`, `2`

So:

* `k = 2`
* `nums` after modification: `[1,2,_, ...]`

---

### Example B

Input:

```text
[0,0,1,1,1,2,2,3,3,4]
```

Groups:

* `0,0`
* `1,1,1`
* `2,2`
* `3,3`
* `4`

Unique values: `0,1,2,3,4`

So:

* `k = 5`
* `nums` after modification: `[0,1,2,3,4,_,_,_,_,_]`

Mini-check:
If `nums.length == 1`, say `[9]`, what should happen?

* There are no duplicates to remove.
* `k = 1`
* `nums` stays `[9]`.

If `nums` is something like `[1,2,3,4]` (already unique):

* `k = 4`
* `nums` unchanged.

Understanding these corner cases helps avoid bugs.

---

## 4. Strategy thinking (without giving you the solution)

Now let’s reason like we’re designing an algorithm, but I’ll stop short of finishing it for you.

Facts:

1. The array is sorted, so duplicates are consecutive.
2. You want to keep **one copy** of each value.
3. You want to compact those unique values at the **start** of the array.

Questions to guide your thinking:

1. **How can we detect a duplicate when scanning the array?**

  * Hint: In a sorted array, compare each element with something near it.

2. **What information do you need to store as you scan?**

  * Maybe:

    * the last unique value you placed
    * or the position where the next unique value should go
    * or both

3. **How will you update `k`?**

  * `k` equals **how many unique elements you have found**.
  * As soon as you decide “this is a new unique element”, you could:

    * copy it to some position at the start of the array, and
    * increase some counter.

4. **Which index should you start from?**

  * Think about `nums.length == 1`.
  * Think about comparisons: if you compare with “previous element”, does starting at index 0 make sense?

Try to sketch something like:

* “I’ll always keep the first element.”
* “Then, for each next element, if it’s different from X, I’ll …”
* “I’ll also have a variable that tells me where to put the next unique number.”

If you can turn those sentences into Java code, you basically have the solution.

---

## 5. Walking through a possible approach (with an example, conceptually)

Let’s mentally simulate the kind of approach you might write.

Take:

```text
nums = [0,0,1,1,1,2,2,3,3,4]
```

Imagine we have:

* A variable that tells us **where the next unique element should be written** (call it mentally `writePos`).
* Another variable (or pointer `i`) that scans from left to right.

You might think something like:

1. Start by keeping the first element as unique.
2. For each next element, ask:

  * “Is this equal to the last unique one I kept?”
  * If **no**, then it’s a new unique element → write it in the next position, and update `k`.
  * If **yes**, it’s a duplicate → skip it (don’t update the write position).

Simulate that idea on the example by hand on paper. You should see the array gradually becoming:

```text
[0, 1, 2, 3, 4, ?, ?, ?, ?, ?]
```

and you’ll be able to see what `k` ends up being.

> 💡 **Exercise for you:**
> Take `nums = [1,1,2,3,3,3,5]` and simulate your imagined algorithm step by step.
> Track:
>
> * The current index you’re reading from
> * The current “write” position
> * The content of `nums` after each write
> * The current value of `k`

If your algorithm idea gives you `[1,2,3,5,?, ?, ?]` and `k == 4`, you’re on the right track.

---

## 6. Common mistakes in this problem

When you implement, watch out for these:

### 6.1. Using extra data structures

* Using `ArrayList`, `HashSet`, or creating another array is **not necessary** here.
* The problem specifically wants **in-place** with **O(1)** extra space.
* It’s a good exercise to constrain yourself to:

  * `int[] nums` and a few `int` variables.

### 6.2. Returning the wrong `k`

Sometimes beginners:

* Correctly modify the array, but forget to:

  * return the right count of unique elements
  * or they confuse index vs count.

Remember:

* If you filled unique elements into positions `0` to `k-1`, then:

  * the **number of unique elements** is `k`.
  * NOT `k-1`, NOT `nums.length`, etc.

A good mental check:

* For `[1,1,2]` → `k` must be `2`.

### 6.3. Off-by-one errors

Typical traps:

* Starting your loop at the wrong index.
* Accessing `nums[i - 1]` when `i = 0`.
* Forgetting to handle length `1` properly.

Test your algorithm idea on:

* `[1]`
* `[1,1]`
* `[1,2]`
* `[1,1,1]`
* `[1,2,2,3]`

If any of these break, fix your loop boundaries or comparison logic.

### 6.4. Forgetting “relative order should be kept the same”

You must **not** reorder the unique elements.

* Good: `[0,1,2,3,4]`
* Bad: `[4,3,2,1,0]` (even if elements and `k` are correct).

If you stick to scanning from left to right and writing unique elements in that same order, this property will be preserved automatically.

---

## 7. A mini practice ladder (to guide your coding)

Before writing the final `removeDuplicates` code, you can do 2 warm-up methods in your head or mini scratch Java class (not LeetCode):

### 7.1. Warm-up 1: Count unique elements in a sorted array

Write a method (in a scratch file, not LeetCode) like:

```java
public static int countUnique(int[] nums) {
    // no modifications to nums, just return the count
}
```

Hints (not code):

* Handle the case `nums.length == 0` or `1`.
* Iterate through the array and compare each element with the **previous** one.
* Every time you find an element that is **different from the previous one**, increase your counter.

Test manually:

* `[1,1,2]` → `2`
* `[1,2,3]` → `3`
* `[1,1,1]` → `1`

If this works, you’re very close to the main problem.

---

### 7.2. Warm-up 2: Move non-zero elements to the front

Another separate method for practice:

```java
public static int moveNonZeroToFront(int[] nums) {
    // move all non-zero elements to the front, keep their order
    // return how many non-zero elements
}
```

Example:

* Input: `[0, 1, 0, 3, 12]`
* Output array: `[1, 3, 12, ?, ?]`
* Return: `3`

This is **pure two-pointer**:

* One pointer scans.
* One pointer writes.

Once you’re comfortable writing this, adapting to “unique elements” instead of “non-zero elements” will feel natural.

---

## 8. What I suggest you do next

1. **Manually simulate** on paper (or in your head) a two-pointer style approach on examples.
2. Implement:

  * `countUnique(int[] nums)` (just as training).
  * `moveNonZeroToFront(int[] nums)` (if you want extra practice).
3. Then implement `removeDuplicates(int[] nums)` in LeetCode following the **same pattern**, but with the logic:

  * “Is this element equal to the last unique element or not?”

When you have a draft of your Java code, paste it here and I’ll:

* Review it like a senior dev in code review.
* Point out style improvements, complexity, and edge cases.
* Suggest variations for similar problems (like “at most two duplicates”, etc.).
