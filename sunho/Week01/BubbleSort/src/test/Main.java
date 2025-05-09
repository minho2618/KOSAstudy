package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		mData[] md = new mData[n];
		for (int i=0;i<n;i++) {
			md[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(md);
		int max = 0;
		for (int i=0;i<n;i++) {
			if (max < md[i].index - i)
				max = md[i].index - i;
		}
		bw.write(max);
		bw.flush();
		bw.close();
	}

}

class mData implements Comparable<mData>{
	int value;
	int index;
	mData(int value, int index){
		this.value = value;
		this.index = index;
	}
	
	@Override
	public int compareTo(mData o) {
		return this.value - o.value;
	}

}