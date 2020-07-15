import java.util.*;

public class Main {

    static  List<Integer> resList = new ArrayList<>();

    static boolean isUnique(List<Integer> a, int n, int key){
        boolean flag = true;
        for(int i=0; i<n; i++){
            if(a.get(i) == key){
                // It's repeating man! So make it zero
                a.set(i, 0);
                flag = false;
            }
        }

        return flag;
    }

    static void combination(int a[], int data[], int start, int end, int index, int m){
        int sum = 0;
        if(index == m){
            for(int j=0; j<m; j++){
                sum += data[j];
                //System.out.print(data[j] + " ");
            }
            if(isUnique(resList, resList.size(), sum)){
                resList.add(sum);
            }
            //System.out.println(sum);
            return;
        }

        for(int i=start; i<=end && end-i+1 >= m-index; i++){
            data[index] = a[i];
            combination(a,data,i+1,end,index+1,m);
        }
    }

    static void combination_wrap(int [] a, int n, int m){
        int data[] = new int[m];
        combination(a, data, 0, n-1, 0, m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        String[] s = line.split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int a[] = new int[n];

        for(int i=0; i<n; i++)
            a[i] = in.nextInt();

        combination_wrap(a, n, m);

        int sum = 0;
        for(int i=0; i<resList.size(); i++){
            if(resList.get(i) != 0)
                sum += resList.get(i);
        }
        System.out.println(sum);
    }
}
