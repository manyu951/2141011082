#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <dirent.h>
#include <sys/stat.h>
#include <sys/types.h>

int main() {
    DIR *d;
    struct dirent *dir;
    char cwd[1024];
    printf("Current Directory: %s\n", cwd);
    
    d = opendir(".");
    if (d) {
        printf("Files and Directories:\n");
        while ((dir = readdir(d)) != NULL) {
            printf("%s\n", dir->d_name);
        }
        closedir(d);
    }
    chdir("/tmp");
    mkdir("testdir", 0755);

    return 0;
}
