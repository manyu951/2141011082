#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/syscall.h>

#define __NR_reverse_string 548  // Replace 548 with your syscall number

int main() {
    char input[100] = "manyu951";
    char output[100] = {0};  

    long result = syscall(__NR_reverse_string, input, output);

    if (result == 0) {
        printf("Reversed string: %s\n", output);
    } else {
        perror("System call failed");
    }

    return 0;
}

