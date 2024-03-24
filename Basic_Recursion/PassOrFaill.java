public class PassOrFail {
    public static void main(String[] args) {
        // Again, we can replace hard coded values with user input from scanner if desired.
        String attendance = "PPALLP";
        char [] attendanceArray = attendance.toCharArray();
        checkAttendance(attendanceArray, 0, 0, 0, attendanceArray.length);
    }

    public static void checkAttendance(char [] attendanceArray, int index, int consecutiveLate, int absent, int n) {
        if (index == n) {
            System.out.println("PASS");
            return;
        }

        if (attendanceArray[index] == 'L') {
            consecutiveLate++;
            if (consecutiveLate == 3) {
                System.out.println("FAIL");
                return;
            }
        } else {
            consecutiveLate = 0;
        }

        if(attendanceArray[index] == 'A') {
            absent++;
            if (absent == 2) {
                System.out.println("FAIL");
                return;
            }
        }

        checkAttendance(attendanceArray, index + 1, consecutiveLate, absent, n);
    }
}
