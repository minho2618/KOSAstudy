N = int(input())

A =list(map(int,input().split()))

for  i in range(1,len(A)) :
  point = i
  value = A[i]
  for j in range(i-1,-1,-1) :
    if A[j] < A[i] :
      point = j+1
      break
    if(j==0) :
      point = 0
  for j in range(i,point,-1) :
    A[j] = A[j-1]
  A[point] = value

sum = 0
for index,value in enumerate(A) :
  sum += (value) * (len(A)-(index))


print(sum)