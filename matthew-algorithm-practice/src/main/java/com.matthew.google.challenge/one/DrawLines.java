package com.matthew.google.challenge.one;

/**
 * google编程挑战赛
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-24 14:46
 */
public class DrawLines {
    public String[] execute(String[] commands) {

        int[][] map = new int[20][20];
        int x = 0, y = 0;
        //分别代表{x轴正反方向移动，y轴正反方向移动}
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int directionIndex = 0;
        /**
         * 处理command进行相应操作
         */
        for (String command : commands) {
            if ("LEFT".equals(command)) {
                directionIndex++;
                directionIndex = directionIndex % 4;
            } else {
                map[x][y] = 1;
                int moves = Integer.parseInt(command.substring(8).toString());
                for (int i = 0; i < moves; i++) {
                    x += directions[directionIndex][0];
                    y += directions[directionIndex][1];
                    map[x][y] = 1;
                }
            }
        }

        String[] canvas = new String[20];
        /**
         * 收到map对canvas进行处理
         */
        for (int i = 0; i < 20; i++) {
            canvas[i] = "";
            for (int j = 0; j < 20; j++) {
                canvas[i] += map[i][j] == 0 ? "." : "X";
            }
        }
        for (String line : canvas) {
            System.out.println(line);
        }
        return canvas;

    }

    public static void main(String[] args) {
        String[] s;
        s = new String[]{"FORWARD 19", "LEFT", "FORWARD 19", "LEFT", "FORWARD 19", "LEFT", "FORWARD 19"};
        new DrawLines().execute(s);
        System.out.println();
        s = new String[]{"LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT"};
        new DrawLines().execute(s);
        System.out.println();
        s = new String[]{"FORWARD 1"};
        new DrawLines().execute(s);
        System.out.println();
        s = new String[]{"LEFT", "FORWARD 19", "LEFT", "LEFT", "LEFT",
                "FORWARD 18", "LEFT", "LEFT", "LEFT", "FORWARD 17",
                "LEFT", "LEFT", "LEFT", "FORWARD 16", "LEFT",
                "LEFT", "LEFT", "FORWARD 15", "LEFT", "LEFT", "LEFT",
                "FORWARD 14", "LEFT", "LEFT", "LEFT", "FORWARD 13",
                "LEFT", "LEFT", "LEFT", "FORWARD 12", "LEFT", "LEFT",
                "LEFT", "FORWARD 11", "LEFT", "LEFT", "LEFT", "FORWARD 10",
                "LEFT", "LEFT", "LEFT", "FORWARD 9", "LEFT", "LEFT",
                "LEFT", "FORWARD 8", "LEFT", "LEFT", "LEFT", "FORWARD 7"};
        new DrawLines().execute(s);
    }
}
