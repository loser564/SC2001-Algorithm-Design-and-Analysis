def knapsack_bottom_up(C, weights, profits):
    n = len(weights)
    P = [0] * (C + 1)

    for c in range(1, C + 1):
        for i in range(n):
            if weights[i] <= c:
                P[c] = max(P[c], P[c - weights[i]] + profits[i])
                print("P[", c, "] = ", P[c])
    return P[C],P

def print_solution_tree(capacity, levels):
    if levels == 0:
        return
    print(f"Level {levels - 1}: Capacity = {capacity}")
    print(" " * (levels - 1) * 4 + "/\\")
    print(" " * (levels - 1) * 4 + "/  \\")
    print(" " * (levels - 1) * 4 + "/    \\")
    print_solution_tree(capacity, levels - 1)
    print_solution_tree(capacity - weights[levels - 1], levels - 1)

weights = [4, 6, 8]
profits = [7, 6, 9]
C = 14
n = len(weights)

print_solution_tree(C, n)




# Example 1
weights1 = [4, 6, 8]
profits1 = [7, 6, 9]
C1 = 14
result1 = knapsack_bottom_up(C1, weights1, profits1)
print("Maximum Profit for P(14) - Example 1:", result1)





