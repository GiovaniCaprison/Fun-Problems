#include <fcntl.h> /* for using the O_mode constants */
#include <sys/stat.h> /* for using other mode constants */
#include <mqueue.h> /* Defines the mqueue functions */
#include <string.h>
#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[]) {
    int modeflags = O_CREAT | O_WRONLY; /*Create if it doesn’t exist*/
    mode_t permissions = 0600; /* Read/Write for owner only */
    struct mq_attr attr;
    mqd_t mq;
    char qname [20];
    int max_size = 512;
    char buffer[max_size];
    int priority;

    strcpy(qname, "/test_queue");
    attr.mq_flags = 0; /* Blocking allowed mode */
    attr.mq_maxmsg = 10;
    attr.mq_msgsize = max_size;
    mq = mq_open(qname, modeflags, permissions, &attr);

    if (mq < 0) {
        printf("Couldn't create queue %s\n", qname);
        exit(-1);
    }

    printf("Opened a message queue called %s and got descriptor %d\n", qname, mq);

    for (int i = 0; i < 5; i++) {
        printf("Enter message %d: ", i+1);
        fgets(buffer, max_size, stdin); // Reads message from user
        buffer[strcspn(buffer, "\n")] = 0; // Removes newline character at the end

        printf("Enter priority for message %d: ", i+1);
        scanf("%d", &priority);
        while(getchar() != '\n'); // Clears the buffer after reading the integer

        printf("Sending message: '%s' with priority %d to message queue\n", buffer, priority);
        mq_send(mq, buffer, strlen(buffer), priority);
    }

    if (!mq_close(mq))
        printf("Closed the queue\n");
}

