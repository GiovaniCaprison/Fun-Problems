#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main(void) {
    int pipefd[2];
    pid_t cpid;
    char buf;
    const char *msg = "Greetings from parent\n";
    int msg_len = strlen(msg);

    // Create a pipe
    if (pipe(pipefd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Fork a child process
    cpid = fork();
    if (cpid == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (cpid == 0) {    /* Child process */
        close(pipefd[1]); // Close the write end, as it's not required by the child

        while (read(pipefd[0], &buf, 1) > 0) {
            write(STDOUT_FILENO, &buf, 1);
        }

        write(STDOUT_FILENO, "\n", 1);
        close(pipefd[0]); // Finally close the read end
        _exit(EXIT_SUCCESS);
    } else {            /* Parent process */
        close(pipefd[0]); // Close the read end, as it's not required by the parent

        while (1) {
            write(pipefd[1], msg, msg_len); // Write data into the pipe
            printf("parent: data written to the pipe\n");
            sleep(5); // Sleep for 5 seconds
        }

        close(pipefd[1]); // Finally close the write end
        wait(NULL); // Wait for the child to finish
        exit(EXIT_SUCCESS);
    }
}

