#include <stdio.h>

int main() {
    int sum = 0;
    int i = 1;

    while (i <= 10){  
        sum += i;
        i++;
    }
    
    printf("Sum = %d\n", sum);
    return 0;
}

