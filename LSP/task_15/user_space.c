#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/syscall.h>
#include <errno.h>

#define SYS_REVERSE_STRING 451  

int main() {
    char input[100];

    printf("Enter a string to reverse: ");
    if (fgets(input, sizeof(input), stdin) == NULL) {
        perror("Failed to read input");
        return EXIT_FAILURE;
    }

    size_t len = strlen(input);
    if (len > 0 && input[len - 1] == '\n') {
        input[len - 1] = '\0';
        len--;
    }

    char *output = malloc(len + 1);
    if (!output) {
        perror("Memory allocation failed");
        return EXIT_FAILURE;
    }

    long status = syscall(SYS_REVERSE_STRING, input, output, len);
    if (status == -1) {
        perror("System call failed");
        free(output);
        return EXIT_FAILURE;
    }

    output[len] = '\0';

    printf("Reversed string: %s\n", output);

    free(output);
    return EXIT_SUCCESS;
}

