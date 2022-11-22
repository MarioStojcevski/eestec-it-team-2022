//                     =============TEXT=============
//  There are N stones, numbered 1,2,...,N. For each i( 1 <= i <= N),the
//  height of Stone i is h_i.
//
//
//  There is a frog who is initially on Stone 1. He will repeat the
//  following action some number of times to reach Stone N:
//
//  ● If the frog is currently on Stone i, jump to Stone i+1 or Stone i+2.
//    Here, a cost of |h_i - h_j| is incurred, where j is the stone to land on.
//
//  Find the minimum possible total cost incurred before the frog reaches Stone N.
//
//  Constraints:
//  ● All values in input are integers.
//  ● 2 <=  N  <= 10^5
//  ● 1 <= h_i <= 10^4
//
//  |-------------------------------------------------------------------------|
//  | INPUT:               |  OUTPUT:                                         |
//  |-------------------------------------------------------------------------|
//  | N                    |  Print the minimum possible total cost incurred. |
//  | h_1 h_2 ... h_N      |                                                  |
//  |----------------------|--------------------------------------------------|
//  | 4                    |  30                                              |
//  | 10 30 40 20          |                                                  |
//  |----------------------|--------------------------------------------------|
//  | 2                    |  0                                               |
//  | 10 10                |                                                  |
//  |----------------------|--------------------------------------------------|
//  | 6                    |  40                                              |
//  | 30 10 60 10 60 50    |                                                  |
//  |-------------------------------------------------------------------------|
//

import java.util.Scanner;


public class Frog1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int []stones = new int[N+1];
        int []dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            stones[i] = sc.nextInt();
        }
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + Math.abs(stones[i] - stones[i-1]);
            if(i >= 3){
                dp[i] = Math.min(dp[i], dp[i-2] + Math.abs(stones[i] - stones[i-2]));
            }
        }

        System.out.println(dp[N]);

    }
}


//                     =============BLOOPERS=============
//     int result = 0;
//     int []tmp = new int[N+1];
//     for (int i = 0; i < N-2; i++) {
//         result += Math.abs(stones[i] - Math.min(stones[i+1], stones[i+2]));
//         if(i == 0){
//             tmp[i] = stones[i];
//         }else{
//             tmp[i+1] = Math.min(stones[i+1], stones[i+2]);
//         }
//     }
//     System.out.print(result);