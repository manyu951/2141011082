#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>

#define SHM_SIZE 1024
#define SHM_KEY 1234

int main() {
    int shmid;
    char *shm_ptr;
    shmid = shmget(SHM_KEY, SHM_SIZE, 0666);
    shm_ptr = (char *) shmat(shmid, NULL, 0);
    printf("Message from writer : %s\n", shm_ptr);
    shmdt(shm_ptr);
    shmctl(shmid, IPC_RMID, NULL);
    
    return 0;
}
