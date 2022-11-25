//                 ==========TEXT==========
//
//      Најди ја најдолгата опаѓачка секвенца во една низа.
//      Броевите во секвенцата не мора да се наоѓаат на последователни индекси во низата.
//
//
//     -------------------------------------------------------
//     |  Input                        |    Output           |
//     |-------------------------------|---------------------|
//     |  8                            |  1                  |
//     |  1 2 3 4 5 6 7 8              |                     |
//     |-------------------------------|---------------------|
//     | 6                             |  5                  |
//     | 0 -10 -20 -30 -50 0           |                     |
//     |-------------------------------|---------------------|
//     |  14                           |  5                  |
//     |  1 2 2 3 3 4 5 4 3 3 2 2 1 1  |                     |
//     |-------------------------------|---------------------|
//     |  1                            |  1                  |
//     |  -2                           |                     |
//     |-------------------------------|---------------------|
//     |  2                            |  1                  |
//     |  -2 3                         |                     |
//     -------------------------------------------------------
//

import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        // Vasiot kod tuka
        int size = a.length;                            // za da ne se povikuva nekolku pati

        int []dp = new int[size];                       // niza dp koja ke gi sledi dolzinite na opagackite sekvenci za sekoj element posebno

        int longest = 0;                                // longest e promenliva koja go zema brojot koj e najgolem vo nizata dp

        for (int i = 0; i < size; i++) {
            dp[i] = 1;                                  // gi postavuvam site elementi od nizata dp na 1, bidejki najmalata najdolgaOpagackaSekvenca moze da bide samo 1
        }

        for (int i = 1; i < size; i++) {                // prvin se stava i na 1 za da pocnemegledame od vtoriot element na nizata a nanazad, za sporedba so prviot
            for (int k = 0; k < i; k++) {               // k e iterator na koj ke go koristime za sporeda na sekoj elemetn so prethodnite, odnosno se dodeka ne dojde do elementot so koj sporeduvame
                if (a[i] < a[k] && dp[i] < dp[k]+1){    // ovdeka se proveruva i vo nizata a i vo nizata dp, vo nizata a se proveruva dali momentalniot element e pomal od site prethodni i gledame vo nizata dp dali brojot na prethodnici koi bile pogolemi od nego e pomal
                    dp[i] = dp[k] + 1;                  // dokolku toj e pomal od prethodnite elementi i brojot na prethodnici koi bile pogolemi od nego e pomal od segasniot broj na prethodnici koi bile pogolemi od nego, go stavame prethodniot broj na prethodnici koi bile pogolemi od nego na segasnite
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (longest < dp[i]) {
                longest = dp[i];                    // ovde se iterira niz dp i se bara najgolemiot broj, koj pretstavuva najgolema dolzina na opagacka podniza
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}

//                 ==========BLOOPERS==========
//
//    int size = a.length;
//    int []dp = new int[size];
//        dp[0] = 1;
//
//                for (int i = 1; i < size; i++) {
//        if (a[i] < a[i-1]) {
//        dp[i] += 1;
//        }
//        for (int j = 1; j < size; j++) {
//        dp[j] = Math.max(dp[i], dp[i-1]);
//        }
//        }
//        return dp[size-1];
//
//========================================================
//
//     int size = a.length;
//        int []dp = new int[size];
//        dp[0] = 1;
//
//        for (int i = 1; i < size; i++) {
//            if (a[i] < a[i-1]) {
//                dp[i] += 1;
//            }else{
//                dp[i] -= 1;
//            }
//            for (int j = 1; j < size; j++) {
//                dp[j] = Math.max(dp[i], dp[i-1]);
//            }
//        }
//        return dp[size-1];
//
//===============================================
//           =======Python Code=======
//       def lis(A)
//          L = [1] * len(A)
//          for i in range (1, len(L)):
//              subproblems = [L[k] for k in range(i) if A[k] < A[i]]
//              L[i] = 1 + max(subproblems, default=0)
//          return max(L, default=0)