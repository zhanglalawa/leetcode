package base;

public class Test {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        floodFill(image, sr, sc, originalColor, newColor);
        return image;
    }
    public void floodFill(int[][] image, int i, int j, int originalColor, int newColor) {
        int row = image.length;
        int col = image[0].length;
        if (image[i][j] != originalColor) return;
        else {
            image[i][j] = newColor;
            if (i + 1 >= row) return;
            else floodFill(image, i + 1, j, originalColor, newColor);
            if (i - 1 < 0) return;
            else floodFill(image, i - 1, j, originalColor, newColor);
            if (j + 1 >= col) return;
            else floodFill(image, i, j + 1, originalColor, newColor);
            if (j - 1 < 0) return;
            else floodFill(image, i, j - 1, originalColor, newColor);
            
        }
    }
    
    public static void main(String[] args) {
    	Test test = new Test();
    	int[][] image = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
    	test.floodFill(image, 1, 1, 2);
    	
    	for(int i = 0; i < image.length; i++) {
    		for(int j = 0; j < image[0].length; j++) {
    			System.out.print(""+image[i][j] + ' ');
    		}
    		System.out.println();
    	}
    }

}
