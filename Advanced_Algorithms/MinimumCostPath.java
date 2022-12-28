public class MinimumCostPath {

    public static int getMinimumCostPath(int[][] gridCost){
        int rows = gridCost.length;
        int cols = gridCost[0].length;
        for(int i =0; i < rows; i++){
            for(int j = 0;j < cols; j++){
                if(i == 0 && j == 0){
                    continue;
                }
                else if(i == 0){
                    gridCost[i][j] += gridCost[i][j-1];
                }
                else if(j == 0){
                    gridCost[i][j] += gridCost[i-1][j];
                }
                else{
                    gridCost[i][j] += Math.min(gridCost[i-1][j],gridCost[i][j-1]);
                }
            }
        }
        return gridCost[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] gridCost = {
                {3, 5, 7, 10},
                {6, 4, 3, 9},
                {6, 5, 4, 5}
        };
        System.out.println("Grid cost: ");
        for(int i =0; i < gridCost.length; i++){
            for(int j = 0; j < gridCost[0].length; j++){
                System.out.print(gridCost[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Minimum cost: "+getMinimumCostPath(gridCost));
    }
}
