import sys

input = sys.stdin.read
data = list(map(int, input().split()))

N = data[0]
A = data[1:]



count = [0]*10001
for idx in A :
    count[idx] += 1

for i in range(len(count)) :
    if count[i] != 0 :
        for _ in range(count[i]) :
          print(i)