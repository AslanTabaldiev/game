import java.util.Random;
import java.util.Scanner;

public class seagame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[10][10];
        ships(board);
        output(board);
    }
    public static void ships(int[][] board) {
        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            int x = random.nextInt(2, board.length - 1);
            int y = random.nextInt(2, board.length - 1);
            /*System.out.print(x + " " + y);*/
            boolean pos = random.nextBoolean();
            for (int j = 1; j < board.length - 1; j++) {
                for (int g = 1; g < board.length - 1; g++) {
                    board[j][g] = 0;
                }
            }
            board[x][y] = 1;
            if (pos) {
                board[x + 1][y] = 1;
                board[x - 1][y] = 1;
            } else {
                board[x][y + 1] = 1;
                board[x][y - 1] = 1;
            }
            for (int p = 0; p < 2; p++) {
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
                        } else if (board[x1][y1 - 2] == 0 && board[x1 + 1][y1 - 2] == 0 && board[x1 - 1][y1 - 2] == 0) {
                            board[x1][y1] = 2;
                            board[x1][y1 - 1] = 2;
                            check = false;
                        } else if (board[x1 + 2][y1] == 0 && board[x1 + 2][y1 + 1] == 0 && board[x1 + 2][y1 - 1] == 0) {
                            board[x1][y1] = 2;
                            board[x1 + 1][y1] = 2;
                            check = false;
                        } else if (board[x1 - 2][y1] == 0 && board[x1 - 2][y1 + 1] == 0 && board[x1 - 2][y1 - 1] == 0) {
                            board[x1][y1] = 2;
                            board[x1 - 1][y1] = 2;
                            check = false;
                        }
                    }
                } while (check);

                /*System.out.print(x1 + " " + y1);
                System.out.println();*/
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
            for(int j = 1; j < board.length; j++) {
                for(int g = 1; g < board.length; g++) {
                    System.out.print(board[j][g] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void output(int[][] board) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder str1 = new StringBuilder("1 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str2 = new StringBuilder("2 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str3 = new StringBuilder("3 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str4 = new StringBuilder("4 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str5 = new StringBuilder("5 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str6 = new StringBuilder("6 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str7 = new StringBuilder("7 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str8 = new StringBuilder("8 |   |   |   |   |   |   |   |   |   |");
        StringBuilder str9 = new StringBuilder("9 |   |   |   |   |   |   |   |   |   |");

        int hitcounter = 0;
        int shotcounter = 0;
        while (shotcounter < 12) {
            System.out.println();
            System.out.println("Please enter shot coordinates");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            char place;
            if(board[row][column] > 0 && board[row + 1][column] == 0 && board[row - 1][column] == 0 && board[row][column + 1] == 0 && board[row][column - 1] == 0 && board[row + 1][column - 1] == 0 && board[row + 1][column + 1] == 0 && board[row - 1][column + 1] == 0 && board[row - 1][column - 1] == 0) {
                place = 'X';
            }
            else if(board[row][column] > 0) {
                place = '*';
                board[row][column] = 0;
            }
            else {
                place = 'O';
            }

            System.out.println("  | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |");
            System.out.println("---------------------------------------");
            if (row == 1) {
                StringBuilder strBuffer1 = new StringBuilder(str1);
                char c = strBuffer1.charAt(column * 4);
                strBuffer1.setCharAt(column * 4, place);
                System.out.println(strBuffer1.toString());
                str1 = strBuffer1;
            } else {
                System.out.println(str1);
            }
            System.out.println("---------------------------------------");
            if (row == 2) {
                StringBuilder strBuffer2 = new StringBuilder(str2);
                char t = strBuffer2.charAt(column * 4);
                strBuffer2.setCharAt(column * 4, place);
                System.out.println(strBuffer2.toString());
                str2 = strBuffer2;
            } else {
                System.out.println(str2);
            }
            System.out.println("---------------------------------------");
            if (row == 3) {
                StringBuilder strBuffer3 = new StringBuilder(str3);
                char h = strBuffer3.charAt(column * 4);
                strBuffer3.setCharAt(column * 4, place);
                System.out.println(strBuffer3.toString());
                str3 = strBuffer3;
            } else {
                System.out.println(str3);
            }
            System.out.println("---------------------------------------");
            if (row == 4) {
                StringBuilder strBuffer4 = new StringBuilder(str4);
                char t = strBuffer4.charAt(column * 4);
                strBuffer4.setCharAt(column * 4, place);
                System.out.println(strBuffer4.toString());
                str4 = strBuffer4;
            } else {
                System.out.println(str4);
            }
            System.out.println("---------------------------------------");
            if (row == 5) {
                StringBuilder strBuffer5 = new StringBuilder(str5);
                char t = strBuffer5.charAt(column * 4);
                strBuffer5.setCharAt(column * 4, place);
                System.out.println(strBuffer5.toString());
                str5 = strBuffer5;
            } else {
                System.out.println(str5);
            }
            System.out.println("---------------------------------------");
            if (row == 6) {
                StringBuilder strBuffer6 = new StringBuilder(str6);
                char t = strBuffer6.charAt(column * 4);
                strBuffer6.setCharAt(column * 4, place);
                System.out.println(strBuffer6.toString());
                str6 = strBuffer6;
            } else {
                System.out.println(str6);
            }
            System.out.println("---------------------------------------");
            if (row == 7) {
                StringBuilder strBuffer7 = new StringBuilder(str7);
                char t = strBuffer7.charAt(column * 4);
                strBuffer7.setCharAt(column * 4, place);
                System.out.println(strBuffer7.toString());
                str7 = strBuffer7;
            } else {
                System.out.println(str7);
            }
            System.out.println("---------------------------------------");
            if (row == 8) {
                StringBuilder strBuffer8 = new StringBuilder(str8);
                char t = strBuffer8.charAt(column * 4);
                strBuffer8.setCharAt(column * 4, place);
                System.out.println(strBuffer8.toString());
                str2 = strBuffer8;
            } else {
                System.out.println(str8);
            }
            System.out.println("---------------------------------------");
            if (row == 9) {
                StringBuilder strBuffer9 = new StringBuilder(str9);
                char t = strBuffer9.charAt(column * 4);
                strBuffer9.setCharAt(column * 4, place);
                System.out.println(strBuffer9.toString());
                str2 = strBuffer9;
            } else {
                System.out.println(str9);
            }
            System.out.println("---------------------------------------");
            shotcounter++;
        }
        System.out.println("Congratulations! To sink all the ships you did " + shotcounter + " shots");
    }
}