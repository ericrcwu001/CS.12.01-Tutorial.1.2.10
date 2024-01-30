import java.util.Random;

public class LightBoard {
    private boolean[][] lights;

    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][numCols];
        Random random = new Random();
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                lights[i][j] = random.nextFloat() < 0.4;
            }
        }
    }

    public boolean[][] getLights() {
        return lights;
    }

    public void setLights(boolean[][] lights) {
        this.lights = lights;
    }

    private int sumCol(int col) {
        int sum = 0;
        for (int i = 0; i < lights.length; ++i) {
            if (lights[i][col]) sum++;
        }
        return sum;
    }


    public boolean evaluateLight(int row, int col) {
        int sum = sumCol(col);
        System.out.println(sum);
        if (lights[row][col]) {
            return sum % 2 != 0;
        } else {
            return sum % 3 == 0;
        }
    }
}
