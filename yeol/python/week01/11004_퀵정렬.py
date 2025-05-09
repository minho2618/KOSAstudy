N, M = map(int, input().split())
A = list(map(int, input().split()))

def quickSort(start, end, M):
    if start < end:
        pivot = findPivot(start, end)
        if pivot == M:
            return
        elif M < pivot:
            quickSort(start, pivot - 1, M)
        else:
            quickSort(pivot + 1, end, M)

def findPivot(start, end):
    if end - start <= 1:
        if A[start] > A[end]:
            A[start], A[end] = A[end], A[start]
        return start if A[start] <= A[end] else end
    else:
        mid = (start + end) // 2
        A[start], A[mid] = A[mid], A[start]
        pivot = A[start]
        i = start + 1
        j = end

        while i <= j:
            while i <= end and A[i] <= pivot:
                i += 1
            while j >= start + 1 and A[j] >= pivot:
                j -= 1
            if i < j:
                A[i], A[j] = A[j], A[i]

        A[start], A[j] = A[j], A[start]
        return j


quickSort(0, N - 1, M - 1)
print(A[M - 1])
