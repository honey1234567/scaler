https://neetcode.io/problems/climbing-stairs/question

house robber - https://neetcode.io/problems/house-robber/solution

https://www.geeksforgeeks.org/dsa/longest-palindromic-substring/-   see odd even and dp

https://neetcode.io/problems/palindromic-substrings/solution - see approach 2,3,4

https://neetcode.io/problems/decode-ways/solution -  see all approach

https://neetcode.io/problems/coin-change/solution -  see all approach till DP and leave BFS

# maximum product subarray 

https://neetcode.io/problems/maximum-product-subarray/solution - all approach

Yes. Let's dry-run **all important cases** for Maximum Product Subarray so you can see exactly why `curMax` and `curMin` are needed.

We'll use this logic:

```java
curMax = Math.max(num,
           Math.max(num * oldMax,
                    num * oldMin));

curMin = Math.min(num,
           Math.min(num * oldMax,
                    num * oldMin));

result = Math.max(result, curMax);
```

The three possibilities at every number are:

```text
1. Start new subarray:       num
2. Extend old maximum:       num * oldMax
3. Extend old minimum:       num * oldMin
```

---

# Case 1: All positive numbers

```text
nums = [2, 3, 4]
```

![Image](https://images.openai.com/static-rsc-4/0t7TtRbEylpUsNiUhG-6H7ROHQJrdoyWM7xO8x2b0UXGOqGGGln1Iu_axoPiy7dk2Nllmix0UYtQEZtuyV3G6GYmMJMI2ndnKpJq2R9DpIf0tpem7BDt82-hxdz3CExGrE8ubpC-vvGW6-9UWs-7Xy7WrY48wO_kZreN0ln3QOKqdxuCK74D3KoNdUs4KKaA?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/3LkNVsVjvEObdsMzansvOcR6YwQizWxOpGC9_Lg2dETqq1heT443-PDdS2zQYNy81TkJvzbw6kf2JBLAfj7-C1Pb-YOKper-Gz93vED7MiNT4Jqcm7iZesrpi4r98SzlgBN8_KmYIikhIZHB-0iQBHQl3ETL5K9nqeti4DQpEmVCGzPuvBLeYozAkhh3q6ZA?purpose=fullsize)

Initial:

```text
curMax = 2
curMin = 2
result = 2
```

### Number = 3

```text
num = 3

num              = 3
num * oldMax     = 3 * 2 = 6
num * oldMin     = 3 * 2 = 6
```

Therefore:

```text
curMax = 6
curMin = 3
result = 6
```

### Number = 4

```text
num              = 4
num * oldMax     = 4 * 6 = 24
num * oldMin     = 4 * 3 = 12
```

Therefore:

```text
curMax = 24
curMin = 4
result = 24
```

Answer:

```text
24
```

Subarray:

```text
[2, 3, 4]
```

---

# Case 2: All negative numbers

```text
nums = [-2, -3, -4]
```

This is interesting because the maximum can change between negative and positive.

Initial:

```text
curMax = -2
curMin = -2
result = -2
```

### Number = -3

```text
num              = -3
num * oldMax     = (-3) * (-2) = 6
num * oldMin     = (-3) * (-2) = 6
```

Therefore:

```text
curMax = 6
curMin = -3
result = 6
```

Subarray:

```text
[-2, -3]
```

Product:

```text
6
```

### Number = -4

Old:

```text
curMax = 6
curMin = -3
```

```text
num              = -4
num * oldMax     = -4 * 6 = -24
num * oldMin     = -4 * -3 = 12
```

Therefore:

```text
curMax = 12
curMin = -24
result = 12
```

Answer:

```text
12
```

Subarray:

```text
[-3, -4]
```

---

# Case 3: Positive → Negative

```text
nums = [2, -3]
```

Initial:

```text
curMax = 2
curMin = 2
result = 2
```

At `-3`:

```text
-3
-3 * 2 = -6
-3 * 2 = -6
```

Therefore:

```text
curMax = -3
curMin = -6
result = 2
```

Answer:

```text
2
```

Notice:

```text
curMax became -3
curMin became -6
```

The previous positive product became negative.

---

# Case 4: Negative → Positive

```text
nums = [-2, 3]
```

Initial:

```text
curMax = -2
curMin = -2
result = -2
```

At `3`:

```text
3
3 * (-2) = -6
3 * (-2) = -6
```

So:

```text
curMax = 3
curMin = -6
result = 3
```

The best choice is to **start a new subarray**:

```text
[3]
```

rather than:

```text
[-2, 3]
```

---

# Case 5: Two negatives

```text
nums = [-2, -3]
```

Initial:

```text
curMax = -2
curMin = -2
result = -2
```

At `-3`:

```text
-3
-3 * -2 = 6
-3 * -2 = 6
```

So:

```text
curMax = 6
curMin = -3
result = 6
```

Answer:

```text
6
```

Subarray:

```text
[-2, -3]
```

This is the basic reason we need to consider multiplication with `curMin`.

---

# Case 6: Three negatives

```text
nums = [-2, -3, -4]
```

We already partially saw this.

| num | oldMax | oldMin | num | num×max | num×min | newMax | newMin | result |
| --: | -----: | -----: | --: | ------: | ------: | -----: | -----: | -----: |
|  -2 |      — |      — |  -2 |       — |       — |     -2 |     -2 |     -2 |
|  -3 |     -2 |     -2 |  -3 |       6 |       6 |      6 |     -3 |      6 |
|  -4 |      6 |     -3 |  -4 |     -24 |      12 |     12 |    -24 |     12 |

Answer:

```text
12
```

---

# Case 7: Negative → Negative → Positive

```text
nums = [-2, -3, 4]
```

Initial:

```text
curMax = -2
curMin = -2
result = -2
```

### `-3`

```text
-3
-3 * -2 = 6
-3 * -2 = 6
```

```text
curMax = 6
curMin = -3
result = 6
```

### `4`

```text
4
4 * 6 = 24
4 * -3 = -12
```

```text
curMax = 24
curMin = -12
result = 24
```

Answer:

```text
24
```

Entire array:

```text
[-2, -3, 4]

(-2) × (-3) × 4 = 24
```

---

# Case 8: Positive → Negative → Negative

```text
nums = [2, -3, -4]
```

This is one of the most important cases.

Initial:

```text
curMax = 2
curMin = 2
result = 2
```

### `-3`

```text
-3
-3 * 2 = -6
-3 * 2 = -6
```

```text
curMax = -3
curMin = -6
result = 2
```

Now look carefully:

```text
curMin = -6
```

It looks bad.

But it is being saved.

### `-4`

```text
-4
-4 * (-3) = 12
-4 * (-6) = 24
```

Therefore:

```text
curMax = 24
```

And:

```text
result = 24
```

The winning subarray:

```text
[2, -3, -4]
```

Product:

```text
2 × (-3) × (-4)
= 24
```

**This is the most important example for understanding `curMin`.**

---

# Case 9: Negative → Positive → Negative

```text
nums = [-2, 3, -4]
```

Initial:

```text
curMax = -2
curMin = -2
result = -2
```

### `3`

```text
3
3 * -2 = -6
3 * -2 = -6
```

```text
curMax = 3
curMin = -6
result = 3
```

### `-4`

```text
-4
-4 * 3 = -12
-4 * -6 = 24
```

Therefore:

```text
curMax = 24
curMin = -12
result = 24
```

Answer:

```text
24
```

Again:

```text
curMin = -6
```

was critical.

---

# Case 10: Zero

```text
nums = [2, 3, 0, 4, 5]
```

Initial:

```text
curMax = 2
curMin = 2
result = 2
```

### `3`

```text
curMax = 6
curMin = 3
result = 6
```

### `0`

Possible:

```text
0
0 * 6 = 0
0 * 3 = 0
```

Therefore:

```text
curMax = 0
curMin = 0
result = 6
```

Zero essentially breaks the previous chain.

### `4`

```text
4
4 * 0 = 0
4 * 0 = 0
```

```text
curMax = 4
curMin = 0
result = 6
```

Notice we start fresh at `4`.

### `5`

```text
5
5 * 4 = 20
5 * 0 = 0
```

```text
curMax = 20
curMin = 0
result = 20
```

Answer:

```text
20
```

---

# Case 11: Only zero

```text
nums = [0, 0, 0]
```

Initial:

```text
curMax = 0
curMin = 0
result = 0
```

Every iteration:

```text
0
0 * 0 = 0
0 * 0 = 0
```

So:

```text
curMax = 0
curMin = 0
result = 0
```

Answer:

```text
0
```

---

# Case 12: Negative + Zero

```text
nums = [-2, 0]
```

Initial:

```text
curMax = -2
curMin = -2
result = -2
```

At zero:

```text
0
0 * -2 = 0
0 * -2 = 0
```

```text
curMax = 0
curMin = 0
result = 0
```

Answer:

```text
0
```

---

# Case 13: Positive + Zero + Negative

```text
nums = [2, 0, -3]
```

### Start

```text
curMax = 2
curMin = 2
result = 2
```

### `0`

```text
curMax = 0
curMin = 0
result = 2
```

### `-3`

```text
-3
-3 * 0 = 0
-3 * 0 = 0
```

```text
curMax = 0
curMin = -3
result = 2
```

Answer:

```text
2
```

---

# Case 14: Multiple zeros

```text
nums = [0, -2, 0, -3, -4]
```

Let's go quickly.

### `0`

```text
max = 0
min = 0
result = 0
```

### `-2`

```text
-2
-2 * 0 = 0
-2 * 0 = 0

max = 0
min = -2
result = 0
```

### `0`

```text
max = 0
min = 0
result = 0
```

### `-3`

```text
-3
-3 * 0 = 0
-3 * 0 = 0

max = 0
min = -3
result = 0
```

### `-4`

```text
-4
-4 * 0 = 0
-4 * -3 = 12
```

Therefore:

```text
max = 12
result = 12
```

Answer:

```text
12
```

Subarray:

```text
[-3, -4]
```

---

# Case 15: The classic LeetCode example

```text
nums = [2, 3, -2, 4]
```

Complete table:

|  i | num | oldMax | oldMin | num | num×oldMax | num×oldMin | newMax | newMin | result |
| -: | --: | -----: | -----: | --: | ---------: | ---------: | -----: | -----: | -----: |
|  0 |   2 |      — |      — |   2 |          — |          — |      2 |      2 |      2 |
|  1 |   3 |      2 |      2 |   3 |          6 |          6 |      6 |      3 |      6 |
|  2 |  -2 |      6 |      3 |  -2 |        -12 |         -6 |     -2 |    -12 |      6 |
|  3 |   4 |     -2 |    -12 |   4 |         -8 |        -48 |      4 |    -48 |      6 |

Answer:

```text
6
```

---

# Case 16: The most important tricky example

Let's take:

```text
[2, -5, -2, -4, 3]
```

This has multiple sign changes.

Start:

```text
max = 2
min = 2
result = 2
```

### `-5`

```text
-5
-5 × 2 = -10
-5 × 2 = -10

max = -5
min = -10
result = 2
```

### `-2`

Now the important part:

```text
-2
-2 × (-5)  = 10
-2 × (-10) = 20
```

So:

```text
max = 20
min = -2
result = 20
```

The minimum `-10` turned into:

```text
20
```

### `-4`

```text
-4
-4 × 20 = -80
-4 × -2 = 8
```

```text
max = 8
min = -80
result = 20
```

### `3`

```text
3
3 × 8 = 24
3 × -80 = -240
```

```text
max = 24
min = -240
result = 24
```

Answer:

```text
24
```

Subarray:

```text
[-2, -4, 3]
```

Product:

```text
(-2) × (-4) × 3 = 24
```

---

# The pattern behind ALL cases

At each number `num`, we ask:

```text
Can I start here?
        ↓
       num

Can I extend previous maximum?
        ↓
    num × oldMax

Can I extend previous minimum?
        ↓
    num × oldMin
```

Then:

```text
newMax = maximum of the three
newMin = minimum of the three
```

---

# Why `curMin` is absolutely necessary

Suppose:

```text
curMax = 10
curMin = -20
```

Next:

```text
num = -2
```

Then:

```text
num × curMax
= -2 × 10
= -20
```

but:

```text
num × curMin
= -2 × -20
= 40
```

So:

```text
newMax = 40
```

If you only stored `curMax`, you'd get:

```text
-20
```

and completely miss the answer.

That's the **entire trick** of Maximum Product Subarray.

---

# Final comparison with normal Kadane

### Maximum Subarray Sum

```text
curSum
```

because:

```text
negative sum is generally bad
```

### Maximum Product Subarray

```text
curMax
curMin
```

because:

```text
negative × negative = positive
```

So remember:

```text
        KADANE SUM
             |
          curSum
             |
      extend or restart


       PRODUCT KADANE
             |
      +------+------+
      |             |
    curMax        curMin
      |             |
      +------+------+
             |
       negative can
       flip them
```

**The key interview sentence:**

> At every index, `curMax` is the maximum product of a subarray ending there, while `curMin` is the minimum product ending there. We need both because multiplying by a negative swaps the role of maximum and minimum.

