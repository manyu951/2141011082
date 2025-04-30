#include <iostream>
#include <unistd.h>
#include <sys/syscall.h>
#include <cstring>

#define SYS_reversestring 548

using namespace std;

namespace StringSyscall {
    long reverseString(char* str, int len) {
        return syscall(SYS_reversestring, str, len);
    }
}

int main() {
    char str[100];

    cout << "Enter a string: ";
    cin >> str;

    int len = strlen(str);

    long result = StringSyscall::reverseString(str, len);

    if (result == 0) {
        cout << "Reversed string: " << str << endl;
    } else {
        cerr << "System call failed with error code: " << result << endl;
    }

    return 0;
}
