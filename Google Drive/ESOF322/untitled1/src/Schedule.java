public class Schedule {
    int col = 9;
    int row = 2;
    String[][] week = new String[col][row];

    public Schedule() {



    }

    public void setDate(int col, int TOD, String shift) {
        week[col][TOD] = shift;
    }

    public void printSchedule() {
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                System.out.print(week[j][i]+" ");
            }
            System.out.println("");
        }

    }
}
