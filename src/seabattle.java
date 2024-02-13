import java.util.Random;
import java.util.Scanner;

public class seabattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[10][10];
        ships(board);
        int hitcount = 0;
        int shots = 0;

        while(hitcount < 11) {
            System.out.println("Enter the coordinates to shot");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(board[x][y] == 1 && board[x + 2][y] == 1 || board[x - 2][y] == 1 || board[x][y + 2] == 1 || board[x][y - 2] == 1) {
                System.out.println("Hit");
                board[x][y] = 0;
                hitcount++;
                shots++;
            }
            else if(board[x + 1][y] > 0 || board[x - 1][y] > 0 || board[x][y + 1] > 0 || board[x][y - 1] > 0 || board[x + 1][y + 1] > 0 || board[x + 1][y - 1] > 0 || board[x - 1][y + 1] > 0 || board[x - 1][y - 1] > 0) {
                System.out.println("Hit");
                board[x][y] = 0;
                hitcount++;
                shots++;
            }
            else if(board[x][y] > 0) {
                System.out.println("Ship is sunk");
            }
            else {
                System.out.println("Miss");
                shots++;
            }
            System.out.println();
        }
        System.out.println("Congratulations! You you sank all the ships and did " + shots + " shots");
    }
    public static void ships(int[][] board) {
        Random random = new Random();
        for(int i = 0; i < 1; i++) {
            int x = random.nextInt(2, board.length - 2);
            int y = random.nextInt(2, board.length - 2);

            boolean pos = random.nextBoolean();
            for(int j = 1; j < board.length - 1; j++) {
                for(int g = 1; g < board.length - 1; g++) {
                    board[j][g] = 0;
                }
            }
            board[x][y] = 1;
            if(pos) {
                board[x + 1][y] = 1;
                board[x - 1][y] = 1;
            }
            else {
                board[x][y + 1] = 1;
                board[x][y - 1] = 1;
            }
            for(int p = 0; p < 2; p++) {
                int x1;
                int y1;
                boolean check = true;

                do {
                    x1 = random.nextInt(2, board.length - 2);
                    y1 = random.nextInt(2, board.length - 2);
                    if (board[x1][y1] == 0 && board[x1 + 1][y1] == 0 && board[x1 - 1][y1] == 0 && board[x1][y1 + 1] == 0 && board[x1][y1 - 1] == 0 && board[x1 + 1][y1 - 1] == 0 && board[x1 + 1][y1 + 1] == 0 && board[x1 - 1][y1 + 1] == 0 && board[x1 - 1][y1 - 1] == 0) {
                        if (board[x1][y1 + 2] == 0 && board[x1 + 1][y1 + 2] == 0 && board[x1 - 1][y1 + 2] == 0) {
                            board[x1][y1] = 2;
                            board[x1][y1 + 1] = 2;
                            check = false;
                        }
                        else if (board[x1 + 2][y1] == 0 && board[x1 + 2][y1 + 1] == 0 && board[x1 + 2][y1 - 1] == 0) {
                            board[x1][y1] = 2;
                            board[x1 + 1][y1] = 2;
                            check = false;
                        }
                        else if (board[x1][y1 - 2] == 0 && board[x1 + 1][y1 - 2] == 0 && board[x1 - 1][y1 - 2] == 0) {
                            board[x1][y1] = 2;
                            board[x1][y1 - 1] = 2;
                            check = false;
                        }
                        else if (board[x1 - 2][y1] == 0 && board[x1 - 2][y1 + 1] == 0 && board[x1 - 2][y1 - 1] == 0) {
                            board[x1][y1] = 2;
                            board[x1 - 1][y1] = 2;
                            check = false;
                        }
                    }
                } while (check);

                for (int t = 0; t < 2; t++) {
                    int x2;
                    int y2;
                    boolean check2;

                    do {
                        x2 = random.nextInt(2, board.length - 1);
                        y2 = random.nextInt(2, board.length - 1);
                        if (board[x2][y2] == 0 && board[x2 + 1][y2] == 0 && board[x2 - 1][y2] == 0 && board[x2][y2 + 1] == 0 && board[x2][y2 - 1] == 0 && board[x2 + 1][y2 - 1] == 0 && board[x2 + 1][y2 + 1] == 0 && board[x2 - 1][y2 + 1] == 0 && board[x2 - 1][y2 - 1] == 0) {
                            check2 = true;
                            board[x2][y2] = 3;
                        } else {
                            check2 = false;
                        }
                    } while (!check2);
                }
            }
        }
        for(int j = 1; j < board.length - 1; j++) {
            for(int g = 1; g < board.length - 1; g++) {
                System.out.print(board[j][g] + " ");
            }
            System.out.println();
        }
    }
}