import sys

input = sys.stdin.read
data = list(map(int, input().split()))

N = data[0]
A = data[1:]

size = 1 # 처음에는 각 원소를 1개짜리로 보고, 1칸짜리 그룹끼리 병합을 시작합니다.
tmp = [-1] * N # 정렬 결과를 저장할 임시 리스트입니다.

while size < N :
  # size는 병합할 구간의 크기입니다.
  for start in range(0,N,size*2) :
    # start는 병합할 구간의 왼쪽 시작점을 의미합니다.
    # start ~ mid-1 , mid ~ end-1 까지 리스트로는 [start:mid] , [mid:end] 를 의미합니다.
    mid = min(start+size,N) # 항상 2개의 원소일 수는 없는 법. 
    end = min(start+size*2,N) # min은 마지막 갯수가 한개가 남았을 경우 처리를 위해 사용됩니다.

    idx1= start # 비교1 idx1 시작점
    idx2 = mid # 비교2 idx2 시작점
    idx=start # tmp 리스트에 값을 저장을 위해서 사용하는 시작점.

    while idx1 < mid and idx2 < end :
      if A[idx1] <= A[idx2] :
        tmp[idx] = A[idx1]
        idx1+=1
      else :
        tmp[idx] = A[idx2]
        idx2+=1
      idx+=1

    
    while idx1 < mid : 
      tmp[idx] = A[idx1]
      idx1 += 1
      idx += 1
    while idx2 < end :
      tmp[idx] = A[idx2]
      idx2 += 1 
      idx += 1
  
  A[:] = tmp[:]
  size *= 2

print(A,end=' ')