N=input()
A=[]
for i in N :
  A.append(int(i))
for i in range(len(A)) :
  max = i
  for j in range(i+1,len(A)) :
    if(A[j] > A[max]) :
      MAX = j
  if A[i] < A[max] :
    A[i],A[max] = A[max],A[i]

B = ""
for j in A :
  B += str(j)
print(B)
