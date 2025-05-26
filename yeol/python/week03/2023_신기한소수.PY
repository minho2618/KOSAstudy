n=int(input())

def isPrime(num) :
  if num < 2 : return False
  for i in range(2,int(num**(0.5))+1) : 
    if num % i == 0: return False
  return True

def DFS(cur) :
  if len(str(cur)) == n :
    print(cur)
  else :
    for i in range(1,10) :
      if(isPrime(10*cur + i)) :
        DFS(10*cur + i)

for start in [2,3,5,7] :
  DFS(start)
  
