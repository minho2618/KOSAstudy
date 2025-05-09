import sys

input = sys.stdin.read
data = list(map(int, input().split()))

N = data[0]
A = data[1:]
indexed_A = [(value, idx) for idx, value in enumerate(A)]

sorted_A = sorted(indexed_A)

max_diff = 0
for sorted_idx, (value, original_idx) in enumerate(sorted_A):
    diff = original_idx - sorted_idx
    max_diff = max(max_diff, diff)

print(max_diff + 1)
