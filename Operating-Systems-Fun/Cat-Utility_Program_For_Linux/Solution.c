#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    char filename[256];
    char buffer[10]; // Buffer to read the content
    int fd; // File descriptor
    ssize_t n; // Number of bytes read

    // Ask the user for the filename
    printf("Enter the name of the file to be printed: ");
    scanf("%255s", filename);

    // Open the file
    fd = open(filename, O_RDONLY);
    if (fd == -1) {
        perror("Error opening file");
        return 1;
    }

    // Read and display the content in blocks of 10 characters
    do {
        n = read(fd, buffer, sizeof(buffer)); 
        if (n == -1) {
            perror("Error reading file");
            close(fd);
            return 1;
        }
        write(STDOUT_FILENO, buffer, n); // Write the read characters to standard output
    } while (n == sizeof(buffer)); // Continue until read returns less than 10 characters

    close(fd);

    return 0;
}
