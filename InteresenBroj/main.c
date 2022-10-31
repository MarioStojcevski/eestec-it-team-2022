#include <stdio.h>

/*
 * Eден природен e „интересен“ ако неговиот обратен број е делив со неговиот број на цифри.
 * Обратен број е бројот составен од истите цифри, но во обратен редослед (на пример,
 * 653 е обратен број на бројот 356). Од тастатура се внесува природен број n ( n > 9).
 * Да се најде и отпечати најголемиот природен број помал од n кој што е „интересен“.
 * Ако внесениот број не е валиден, да се отпечати соодветна порака (Brojot ne e validen).*/

int main() {

    int n;
    scanf("%d", &n);
    if(n < 10) {
        printf("Brojot ne e validen");
        return 0;
    }

    for(int i=n-1;i>0;i--) {
        int reverse_n = 0;
        int no_digits = 0;
        int current = i;

        while(current) {
            reverse_n *= 10;
            reverse_n += current%10;
            current /= 10;
            no_digits++;
        }

        if(reverse_n % no_digits == 0) {
            printf("%d", i);
            return 0;
        }
    }

    return 0;
}
