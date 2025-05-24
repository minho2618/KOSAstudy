package yjungs2.week02;

import java.util.Scanner;

// BOJ 2023 신기한 소수
class BOJ2023 {
	static int n; // 다른 메소드에서 사용하기 위해 main 밖에 선언

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		// 소수(2, 3, 5, 7)로 시작하는 수에서만 시작
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
	
	static void DFS(int num, int len) {
	// n자리까지 재귀 함수 형태로 탐색하는 dfs
		if(len == n) { // n의 자리 숫자이면서
			if(isPrime(num)) // 소수라면
				System.out.println(num);
			return;
		}
		for(int i=1; i<10; i+=2) { // 짝수는 고려하지 않음
			if(isPrime(num*10+i)) // len 자리까지 모두 소수라면
				DFS(num*10+i, len+1); // 한 자리 더 늘리기
		}
	}
	
	static boolean isPrime(int n) { // 소수 판별
		for(int i=2; i<n/2; i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}