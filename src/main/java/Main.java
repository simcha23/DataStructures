public class Main
{
    public static void main(String[] args)
    {

        int[][] grid = { { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }
        };

        currentGeneration(grid);
        nextGeneration(grid);
    }

    //Function of the current generation

    public static void currentGeneration(int grid[][]){

        System.out.println("Original Generation");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
               if(grid[i][j] == 1){
                   System.out.print("#");// Printing the live cells of the current generation
               }else {
                   System.out.print("+");// Printing the death cells of the current generation
               }
            }
            System.out.println();
        }
        System.out.println();
    }

    //Function of the next generation

    public static void nextGeneration(int grid[][])
    {
        int gridLength = grid.length;
        int[][] future = new int[gridLength][gridLength];

        // Goes through every cell
        for (int x = 1; x < gridLength - 1; x++)
        {
            for (int m = 1; m < gridLength - 1; m++)
            {
                // Finding number of neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++){
                    for (int z = -1; z <= 1; z++)
                        aliveNeighbours += grid[x + i][m + z];
                }

                aliveNeighbours -= grid[x][m]; // Subtracting cell that was counted before from its neighbours

                if ((grid[x][m] == 1) && (aliveNeighbours < 2)) // Cell dies due to loneliness
                    future[x][m] = 0;


                else if ((grid[x][m] == 1) && (aliveNeighbours > 3)){ // Cell dies due to over population
                    future[x][m] = 0;
                }
                else if((grid[x][m] == 0) && (aliveNeighbours == 3)){ // New live cell is born
                    future[x][m] = 1;
                }
                else{
                    future[x][m] = grid[x][m];// No changes for the next generation
                }
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < future.length; i++)
        {
            for (int j = 0; j < future.length; j++)
            {
                if (future[i][j] == 0)
                    System.out.print("+");// Printing the death cells on a next generation
                else
                    System.out.print("#");// Printing the live cells on a next generation
            }
            System.out.println();
        }
    }
}
