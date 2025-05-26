import sys
data = sys.stdin.read().strip().split('\n')
n = int(data[0])
arr = list(map(int, data[1].split()))
m = int(data[2])
targets = list(map(int, data[3].split()))


arr = sorted(arr)
def binary_search(arr,target) :
  left = 0 
  right = len(arr) -1 
  while left <= right :
    mid = (left+ right ) // 2
    if arr[mid] == target :
      return 1
    elif arr[mid] < target :
      left = mid+1
    else :
      right = mid-1
  return 0

for target in targets :
  result = binary_search(arr,target)
  if result == 1 :
    print(1)
  else :
    print(0)