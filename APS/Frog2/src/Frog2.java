//                     =============TEXT=============
//  There are N stones, numbered 1,2,...,N. For each i( 1 <= i <= N),the
//  height of Stone i is h_i.
//
//  There is a frog who is initially on Stone 1. He will repeat the
//  following action some number of times to reach Stone N:
//
//  ● If the frog is currently on Stone i, jump to one of the following
//    Stone i+1, Stone i+2, ... , Stone i+K.
//    Here, a cost of |h_i - h_j| is incurred, where j is the stone to land on.
//
//  Find the minimum possible total cost incurred before the frog reaches Stone N.
//
//  Constraints:
//  ● All values in input are integers.
//  ● 2 <=  N  <= 10^5
//  ● 1 <=  K  <= 100
//  ● 1 <= h_i <= 10^4
//
//  |----------------------------------------------------------------------------------|
//  | INPUT:                        |  OUTPUT:                                         |
//  |----------------------------------------------------------------------------------|
//  | N K                           |  Print the minimum possible total cost incurred. |
//  | h_1 h_2 ... h_N               |                                                  |
//  |-------------------------------|--------------------------------------------------|
//  | 5 3                           |  30                                              |
//  | 10 30 40 50 20                |                                                  |
//  |-------------------------------|--------------------------------------------------|
//  | 3 1                           |  20                                              |
//  | 10 20 10                      |                                                  |
//  |-------------------------------|--------------------------------------------------|
//  | 2 100                         |  0                                               |
//  | 10 10                         |                                                  |
//  |-------------------------------|--------------------------------------------------|
//  | 10 4                          |  40                                                |
//  | 40 10 20 70 80 10 20 70 80 60 |                                                  |
//  |----------------------------------------------------------------------------------|
//

import java.util.Scanner;


public class Frog2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int []stones = new int[N+1];
        int []dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            stones[i] = sc.nextInt();
        }
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = 1000000000;
            for (int j = 1; j <= K; j++) {
                if (i-j <= 0) {
                    break;
                }
                dp[i]= Math.min(dp[i], dp[i-j] + Math.abs(stones[i] - stones[i-j]));
            }
        }

        System.out.println(dp[N]);

    }
}


//                     =============BLOOPERS=============
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int K = sc.nextInt();
//
//        int []stones = new int[N+1];
//        int []dp = new int[N+1];
//
//        for (int i = 1; i <= N; i++) {
//            stones[i] = sc.nextInt();
//        }
//        dp[K+1] = 0;
//
//        for (int i = K+1; i <= N; i++) {
//            dp[i] = dp[i-K] + Math.abs(stones[i] - stones[i-K]);
//            if(i >= K+2){
//                dp[i] = Math.min(dp[i], dp[i-K] + Math.abs(stones[i] - stones[i-K]));
//            }
//        }
//
//        System.out.println(Math.abs(dp[N]-dp[N-1]));