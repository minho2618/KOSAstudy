package sort3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arrNum = new int[n];
		for (int i=0;i<n;i++) {
			arrNum[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		for (int num : arrNum) {
			if (max < num)
				max = num;
		}
		int exp = 1;
		
		while (max / exp > 0) {
			int[] temp = new int[arrNum.length];
			int[] count = new int[10];
			for (int i=0;i<arrNum.length;i++) {
				count[(arrNum[i]/exp) % 10]++; 
			}
			for (int i=1;i<10;i++) {
				count[i] += count[i - 1];
			}
			for (int i=arrNum.length-1;i>=0;i--) {
				int digit = (arrNum[i] / exp % 10);
				temp[--count[digit]] = arrNum[i];
			}
			for (int i=0;i<arrNum.length;i++)
				arrNum[i] = temp[i];
			exp *= 10;
		}
		for (int i : arrNum)
			bw.write(i + "\n");
		bw.flush();
		bw.close();
	}

}
