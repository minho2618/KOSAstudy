package niftron.week_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class Main_1517 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bs = new BufferedOutputStream(System.out);
        int n = Integer.parseInt(bf.readLine());
        int[] data = new int[n];

        String[] token = bf.readLine().split(" ");

        for(int i=0; n > i ; i++){
            data[i] = Integer.parseInt(token[i]);
        }

        int count = 0;

        for(int i =0; n - 1 > i; i++){
            boolean swap = false;
            for(int j=0; n - 1 > j; j++){
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp; 

                    count++;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
        bs.write((count + "\n").getBytes());
        bs.flush();
        bs.close();
        bf.close();
    }
}
