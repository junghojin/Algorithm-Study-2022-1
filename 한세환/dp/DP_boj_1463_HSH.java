import java.io.*;

public class Main_1463 {

    static int inputN;
    static int arr[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        inputN = Integer.parseInt(br.readLine());

        arr = new int [inputN+1];

        for(int i =2 ; i<=inputN; i++){
            arr[i] = arr[i-1]+1;

            if(i%2==0)
                arr[i] = Math.min(arr[i],arr[i/2]+1);
            if(i%3==0)
                arr[i] = Math.min(arr[i],arr[i/3]+1);

        }

        System.out.println(arr[inputN]);


    }
}
