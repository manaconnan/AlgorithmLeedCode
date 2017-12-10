 package googleCodeJam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

 public class FindBeautifulNum {

    public static void main(String[] args) {
        Set s ;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int index = FindBeautifulNum.findIndex(n);
            System.out.println("Case #" + i + ": " + index);
        }

    }


    public static int findIndex(int numInput){

        for(int i = 1;i<=numInput/2;i++){
            if(isBeautiful(numInput,i)){
                return i;
            }
        }
        return numInput-1;
    }

    private static boolean isBeautiful(int numInput, int i) {

        if(numInput == 1){
            return true;
        }

        while (numInput%i ==1){
            numInput = numInput/i;
            if(isBeautiful(numInput,i)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }


}
