package org.example.problems;

/**
 * 661. Image Smoother
 * <p>
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
 * <p>
 *
 * Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * [smooth-grid.jpg]
 * Input: img = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[0,0,0],[0,0,0],[0,0,0]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * <p>
 *
 * Example 2:
 * <p>
 * [smooth2-grid.jpg]
 * Input: img = [[100,200,100],[200,50,200],[100,200,100]]
 * Output: [[137,141,137],[141,138,141],[137,141,137]]
 * Explanation:
 * For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 * <p>
 *
 * Constraints:
 * <p>
 * m == img.length
 * n == img[i].length
 * 1 <= m, n <= 200
 * 0 <= img[i][j] <= 255
 */
public class ImageSmoother {
    public int[][] imageSmoother_9ms(int[][] img) {
        int out[][]=new int[img.length][img[0].length];
        int dir[][]=new int[][]{{1,0},{-1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,-1},{-1,1},{0,0}};
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){
                int sum=0,count=0;
                for(int k=0;k<dir.length;k++){
                    int row=i+dir[k][0];
                    int col=j+dir[k][1];
                    if(row >=0 && col >=0 && row< img.length && col<img[0].length){
                        sum+=img[row][col];
                        count++;
                    }
                }
                out[i][j]=(int)Math.floor(sum/count) ;
            }
        }
        return out;
    }
}
