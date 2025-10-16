class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc]==color)
            return image;
        int initialColor = image[sr][sc];
        image[sr][sc] = color;

        if(sr-1 >= 0 && image[sr-1][sc]==initialColor)
            floodFill(image, sr-1, sc, color);
    
        if(sc-1 >= 0 && image[sr][sc-1]==initialColor)
            floodFill(image, sr, sc-1, color);

        if(sr+1 < image.length && image[sr+1][sc]==initialColor)
            floodFill(image, sr+1, sc, color);
        
        if(sc+1 < image[0].length && image[sr][sc+1]==initialColor)
            floodFill(image, sr, sc+1, color);
        
        return image;
    }
}