import java.util.Random;

public class SymbolSquares {

    private String[][] grid;

    /**
     * generates a NxN grid of X and Os
     * @param n is width/height of the grid
     */
    public SymbolSquares(int n){
       findValid(n);
    }

    public void findValid(int n){
        boolean valid = false;
        this.grid = gridArray(n);
        int count = 0;
        while(!valid){
            valid = findSquares();
            count++;
            if (count > 100){
                findValid(n);
                break;
            }
        }
    }

    /**
     * Creates array to hold a grid
     * @param n width/height of grid
     * @ array grid
     */
    public String[][] gridArray(int n){
        String[][] grid = new String[n][n];
        grid = popGrid(grid);
        return grid;
    }

    /**
     * populates the grid with X and Os randomly
     * @param grid empty grid
     * @return grid now full of values
     */
    public String[][] popGrid(String[][]grid){

        Random r =  new Random();

        for (int i = 0; i< grid.length; i++){ // for entire grid height
            for (int j = 0; j<grid[i].length;j++){ // for entire grid width
                int temp = r.nextInt(2); // holds a 0 or 1 value randomly
                String current = ""; // holds current X or O character based on random
                if (temp ==1){
                    current = "X";
                } else {
                    current = "O";
                }
                grid[i][j] = current; // sets position
            }
        }
        return grid;
    }

    public boolean findSquares(){
        // Squares are where each corner is the same symbol
        // Squares are 2x2 or larger
        grid = getGrid();
        boolean noChange = true; // if no changes made then valid
        // check if each position is top left of a square
        //therefore do not need to check all positions
        for (int i = 0; i< (grid.length-2); i++) { // height
            for (int j = 0; j < (grid[i].length-2); j++) { // width
                for (int k = 2; k<grid.length-j && k<grid.length-i;k++){ // possible square sizes (max entire grid)
                    if (grid[i][j] == grid[i][j+k]){
                        // same symbol k right  now check k below
                        if (grid[i][j] == grid[i+k][j]) {
                            // same k below now check k right and below (4th corner)
                            if(grid[i][j] == grid[i+k][j+k]){
                                // it be a square, change symbol
                                if(grid[i][j] == "X"){
                                    grid[i][j] = "O";
                                } else {
                                    grid[i][j] = "X";
                                }
                                noChange = false;
                            } // end check right and below
                        } // end check below
                    } // end check right
                } // end sizes
            } // end width
        } //end height
        //System.out.println(toString());
        return noChange;
    }




    /**
     * to string as a grid
     * @return
     */
    @Override
    public String toString(){
        grid = getGrid();
        String s = "";

        for (int i = 0; i< grid.length; i++) { // for entire grid height
            for (int j = 0; j < grid[i].length; j++) { // for entire grid width
                s+=grid[i][j];
            }
            s+="\n";
        }
        return s;
    }

    /**
     * Gets 2d array grid
     * @return
     */
    public String[][] getGrid(){
        return this.grid;
    }


}


