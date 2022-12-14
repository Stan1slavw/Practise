package codewars;

public class Snail {
    public static int[] snail(int[][] array) {
        if (array == null || array.length == 0 || array.length == 1 && array[0].length == 0) {
            return new int[0];
        }

        final int height = array.length;
        final int width = array[0].length;
        final int lastY = height / 2;
        final int lastX = width % 2 == 0 ? width / 2 - 1 : width / 2;

        int y = 0, x = 0, dirX = 1, dirY = 0, i = 0;
        int leftBorder = -1, rightBorder = width;
        int upperBorder = -1, lowerBorder = height;
        int[] output = new int[height * width];

        while (true) {
            if (x == rightBorder && y == upperBorder + 1) {
                x--;
                y++;
                dirX = 0;
                dirY = 1;
                upperBorder++;
            } else if (x == leftBorder && y == lowerBorder - 1) {
                x++;
                y--;
                dirX = 0;
                dirY = -1;
                lowerBorder--;
            } else if (y == lowerBorder && x == rightBorder - 1) {
                y--;
                x--;
                dirX = -1;
                dirY = 0;
                rightBorder--;
            } else if (y == upperBorder && x == leftBorder + 1) {
                y++;
                x++;
                dirX = 1;
                dirY = 0;
                leftBorder++;
            }
            output[i] = array[y][x];

            if (y == lastY && x == lastX) {
                break;
            }

            x += dirX;
            y += dirY;
            i++;
        }

        return output;
    }
}
