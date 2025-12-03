## 1. First: What is a singly linked list (in Java)?

You’re given this class:

```java
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

A **singly linked list** is:

* A chain of nodes.
* Each node stores:

  * a value (`val`)
  * a reference to the next node (`next`), or `null` if it’s the last one.

Example: list `[1, 2, 4]` in memory is:

```text
list1
  ↓
[1] -> [2] -> [4] -> null
```

If `list1` is `null`, that means the list is empty (`[]`).

Key operations you should be comfy with:

* Access head: just the variable (e.g., `list1`).
* Move along the list: `node = node.next`.
* Check if you reached the end: `node == null`.

---

## 2. Understanding the problem in your own words

You have **two** sorted linked lists:

* `list1`: sorted in non-decreasing order
* `list2`: also sorted

You must:

* **Merge** them into **one sorted list**, reusing the original nodes ("splicing together the nodes").
* Return the **head** of this merged list.

Think of it like merging two sorted queues into one sorted queue.

Example:

```text
list1: 1 -> 2 -> 4 -> null
list2: 1 -> 3 -> 4 -> null

merged: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
```

Important: you’re not asked to create a Java `List<Integer>` or array. You must manipulate the `ListNode` structure.

---

## 3. Core idea: “Two pointers” merge (like merge sort)

This is basically the **merge step of merge sort**, but with linked lists instead of arrays.

### Imagine this:

* You have `p1` pointing to the current node in `list1`.
* You have `p2` pointing to the current node in `list2`.
* You have `tail` pointing to the **last node** of your merged list so far.

At each step:

1. Compare `p1.val` and `p2.val`.
2. Take the **smaller or equal** one.
3. Attach that node to `tail.next`.
4. Move `tail` to that node.
5. Advance the pointer (`p1` or `p2`) that you used.

Repeat until one list is exhausted.

When one of them is `null`, just connect `tail.next` to the other list (because it’s already sorted).

---

## 4. Why people use a “dummy” node

A very common technique is to use a **dummy head** node to simplify the logic of building a new list.

### What’s a dummy node?

It’s a node you create just to make your life easier:

* It can have any value (commonly `0` or `-1`).
* You never return it.
* You only return `dummy.next` in the end.

Picture:

```text
dummy -> ? (will point to the real first node later)

tail starts at dummy
p1 = list1
p2 = list2
```

As you choose nodes from `p1` or `p2`, you do:

```text
tail.next = chosenNode
tail = tail.next
```

At the end:

```text
return dummy.next; // the true head of the merged list
```

This avoids edge cases like:

* "Is this the first node I'm adding?"
* "Do I need to initialize the head differently?"

---

## 5. Walking through an example step-by-step

Let’s simulate:
`list1 = [1, 2, 4]`, `list2 = [1, 3, 4]`.

Initial:

```text
p1: 1 -> 2 -> 4 -> null
p2: 1 -> 3 -> 4 -> null
dummy: [x] -> null
tail: points at dummy
```

### Step 1

* Compare `p1.val = 1` and `p2.val = 1`
* Choose *either* (commonly `p1` if you use `<=`)
* Attach `p1` to `tail.next`

Result:

```text
dummy -> 1 -> 2 -> 4 -> null
tail: at that 1
p1: now 2 -> 4 -> null
p2: still 1 -> 3 -> 4 -> null
```

### Step 2

* Compare `p1.val = 2`, `p2.val = 1`
* Smaller is `p2`
* Attach `p2`

```text
dummy -> 1 -> 1 -> 3 -> 4 -> null
tail: at the second 1 (from list2)
p1: 2 -> 4 -> null
p2: 3 -> 4 -> null
```

Note: the merged list is growing, but it's literally the original nodes being rearranged, no new nodes created.

### Step 3

* Compare `2` and `3` → take `2` from `p1`.

```text
dummy -> 1 -> 1 -> 2 -> 4 -> null
tail: at 2
p1: 4 -> null
p2: 3 -> 4 -> null
```

### Step 4

* Compare `4` and `3` → take `3` from `p2`.

```text
dummy -> 1 -> 1 -> 2 -> 3 -> 4 -> null
tail: at 3
p1: 4 -> null
p2: 4 -> null
```

### Step 5

* Compare `4` and `4` → take (for example) `p1`.

```text
dummy -> 1 -> 1 -> 2 -> 3 -> 4 -> null
tail: at 4 (from list1)
p1: null
p2: 4 -> null
```

Now `p1` is `null`, loop ends.

### Attach remainder

Since `p1 == null`, attach what’s left of `p2`:

```text
tail.next = p2;
// p2 is 4 -> null
```

Final linked list (starting at `dummy.next`):

```text
1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
```

Return `dummy.next`.

---

## 6. Important edge cases to think about

You should think *before* coding: “What happens if…?”

1. **Both lists empty**:

  * `list1 = null`, `list2 = null`
  * Then `dummy.next` should still be `null`.
  * You return `null` → represents `[]`.

2. **One list empty**:

  * `list1 = null`, `list2 = [0]`
  * You should just return `list2`.
  * In the algorithm: your while loop may not run at all, then you attach remaining list (which will be `list2`).

3. **All values come from one list**:

  * Example: `list1 = [1, 2, 3]`, `list2 = [100, 200]`
  * The algorithm should simply attach `list2` at the end once `p1` is `null`.

4. **Duplicates**:

  * Example: `[1, 1, 1]` and `[1, 1]`.
  * Order doesn’t matter between equal elements, but it must be non-decreasing.

5. **Negative numbers**:

  * Values can be from `-100` to `100`.
  * The comparison logic is the same.

---

## 7. Complexity (you should always think about this)

Let `n` be the length of `list1`, `m` be the length of `list2`.

* You look at each node exactly once.
* Time: **O(n + m)**
* Extra space:

  * Iterative approach: **O(1)** (you reuse existing nodes, only a few pointers).
  * Recursive approach (if you choose it): O(n + m) call stack.

For LeetCode, the iterative approach is usually preferred here.

---

## 8. Recursive way (conceptual view)

You don’t have to implement this, but you should understand the idea:

Think recursively:

* If one list is `null`, the answer is the other list.
* Otherwise:

  * If `list1.val <= list2.val`:

    * The head of the merged list is `list1`
    * And `list1.next` should be the result of merging `list1.next` with `list2`.
  * Else:

    * Head is `list2`
    * And `list2.next` is merging `list1` with `list2.next`.

In words:

> The smaller head becomes the head of the merged list, and we recursively merge the rest.

This is a beautiful, elegant definition, but you must be comfortable with recursion and call stacks.

---

## 9. Very common mistakes to avoid

When you implement in Java, watch out for these:

1. **Creating new nodes unnecessarily**

  * Problem says: “splicing together the nodes.”
  * You should mostly reuse the existing `ListNode` objects, not create totally new ones for each value.

2. **Forgetting to move the pointers**

  * After you attach a node to `tail.next`, you must:

    * move `tail = tail.next`
    * move `p1` or `p2` (whichever node you used).
  * If you forget, you’ll end up with infinite loops or repeated nodes.

3. **Forgetting to connect the remainder**

  * After the `while (p1 != null && p2 != null)` loop, you must:

    * attach whichever list is not null.
  * If you don’t, you’ll lose part of the list.

4. **Returning the wrong head**

  * If you use a dummy node, **do not** return `dummy`.
  * You must return `dummy.next`.

5. **Messing up null checks**

  * Always check `node != null` before accessing `node.val` or `node.next`.

6. **Accidentally forming a cycle**

  * If you reuse nodes incorrectly (e.g., you attach a node whose `next` still points to some earlier node), you might create a cycle.
  * Make sure each node appears only once in the final sequence and the last node’s `next` is `null`.

---

## 10. A good step-by-step plan for you to implement

When you go to your `mergeTwoLists` method, think like this:

1. Handle trivial cases mentally: lists may be empty.
2. Decide: **iterative with dummy node** (recommended for you).
3. Start by:

  * Creating a `dummy` node.
  * Creating a `tail` that points to `dummy`.
  * Setting `p1 = list1`, `p2 = list2`.
4. Implement the loop that:

  * Runs while both `p1` and `p2` are not null.
  * Chooses the smaller node and attaches it to `tail.next`.
  * Advances `tail` and either `p1` or `p2`.
5. After the loop, attach the non-null list (if any).
6. Return `dummy.next`.

If you want to be systematic, you can even **write comments first** and then code under them:

```java
// 1. create dummy and tail
// 2. use p1 and p2 to walk list1 and list2
// 3. while both not null, pick smaller, attach to tail
// 4. attach the remaining nodes
// 5. return dummy.next
```

Then fill in code under each comment.

---

# What do you mean by "Creating a tail that points to dummy." ?

---

Nice, that’s a super important detail to get clear.

When I said **“creating a tail that points to dummy”**, I meant this kind of code:

```java
ListNode dummy = new ListNode(-1); // value doesn't really matter
ListNode tail = dummy;             // tail points to the same node as dummy
```

Let’s unpack what that actually means.

---

## 1. What is `dummy`?

`dummy` is just a **normal `ListNode`** that we create to act as a **fake head** of the result list.

* At the beginning, the result list is empty.
* Instead of having to treat the “first node” as a special case, we say:

  > “Let’s pretend the list already has a first node, this fake dummy node, and we’ll always attach new nodes after it.”

So initially:

```text
dummy
  ↓
[-1] -> null
```

(the value `-1` is arbitrary; it won’t be returned)

---

## 2. What is `tail`?

`tail` is **not** a field in `ListNode`.
It’s just a **local variable** in your method that *points* to the last node of the merged list **so far**.

At the start, we set:

```java
ListNode tail = dummy;
```

Now both variables point to the **same node**:

```text
dummy, tail
   ↓
[-1] -> null
```

So when I say **“tail points to dummy”**, I mean:

> The variable `tail` holds a reference to the same node that `dummy` points to.

---

## 3. How they evolve when building the list

Imagine we’re constructing a result list step-by-step (not the full problem solution, just building a list):

### Step 1 – attach the first real node

Say we decided the first real node to add is a node with value `1`, called `n1`.

```java
tail.next = n1;   // attach n1 after tail (which is currently dummy)
tail = tail.next; // move tail to the newly added node
```

Visually:

Before:

```text
dummy, tail
   ↓
[-1] -> null

n1: [1] -> null
```

After `tail.next = n1`:

```text
dummy, tail
   ↓
[-1] -> [1] -> null
```

After `tail = tail.next`:

```text
dummy
  ↓
[-1] -> [1] -> null
          ↑
         tail
```

So now:

* `dummy` still points to the fake head.
* `tail` now points to the **last real node** (`1`).

### Step 2 – attach another node

Suppose next node is `n2` with value `3`:

```java
tail.next = n2;
tail = tail.next;
```

After this:

```text
dummy
  ↓
[-1] -> [1] -> [3] -> null
                 ↑
                tail
```

You can see the pattern:

* `tail.next = <chosenNode>` attaches a node.
* `tail = tail.next` moves the tail to the end.

---

## 4. Why do we need both `dummy` and `tail`?

* `dummy`:

  * Stays at the **very beginning** of the list.
  * Never moves.
  * Lets us easily return the actual head at the end:

    ```java
    return dummy.next;
    ```
* `tail`:

  * Always points to the **last node** of the list we’re building.
  * Moves forward as we add more nodes.
  * Makes it easy to do:

    ```java
    tail.next = someNode; // append
    tail = tail.next;     // advance tail
    ```

So:

* `dummy` = anchor at the start
* `tail` = cursor at the end, where we’re appending stuff

---

## 5. Final picture

At the very end, you might have something like:

```text
dummy
  ↓
[-1] -> [1] -> [1] -> [2] -> [3] -> [4] -> [4] -> null
                                      ↑
                                     tail
```

What do you return?

```java
return dummy.next; // the node with value 1 (the real head)
```

You **never** return `dummy` itself; it’s just a helper.

---

If you want, next step we can:

* Write a tiny **toy method** that uses `dummy` and `tail` just to build a list from an array (e.g., `[1, 2, 3]`) so you can play with the idea without mixing it with the merge logic yet.

