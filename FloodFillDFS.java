
public class FloodFillDFS {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc]; // original color of start pixel

        if (originalColor == color) return image; // no change needed

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    public static void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        // Boundary conditions
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length) return;

        // Not the same color? Stop
        if (image[row][col] != originalColor) return;

        // Fill current pixel
        image[row][col] = newColor;

        // Visit 4 directions
        dfs(image, row + 1, col, originalColor, newColor); // down
        dfs(image, row - 1, col, originalColor, newColor); // up
        dfs(image, row, col + 1, originalColor, newColor); // right
        dfs(image, row, col - 1, originalColor, newColor); // left
    }

    // ✅ Main function to test
    public static void main(String[] args) {
        int[][] image = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr = 1, sc = 1, color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        // Print result
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
