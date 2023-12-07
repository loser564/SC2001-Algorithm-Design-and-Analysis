def unboundedKnapsack(W, index, val, wt):
    # Base case of recursion when only one element is there.
    if index == 0:
        print(f"Checking item {index}, W={W}, wt={wt[index]}")
        return (W // wt[0]) * val[0]

    # If the element with referred by index doesn't occur even once in the required solution
    print(f"Not taking item {index}, W={W}, wt={wt[index]}")
    notTake = 0 + unboundedKnapsack(W, index - 1, val, wt)

    # If the element is occurring at least once in the required solution
    take = -100000
    if wt[index] <= W:
        print(f"Taking item {index}, W={W - wt[index]}, wt={wt[index]}, val={val[index]}")
        take = val[index] + unboundedKnapsack(W - wt[index], index, val, wt)

    print(f"At item {index}, W={W}: Take = {take}, Not Take = {notTake}")
    return max(take, notTake)

# Driver program
W = 14
wt = [5, 6, 8]
val = [7, 6, 9]
n = len(val)

print(unboundedKnapsack(W, n - 1, val, wt))
