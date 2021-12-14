package sudoku;
//this project is created with help of youtube video code with john 
public class SudokuSolver {
	private static final int GRID_SIZE =9;
	public static void main(String[] args) {
		
		//replace this grid with your sudoku grid
		int[][] board = {
		        {7, 0, 2, 0, 5, 0, 6, 0, 0},
		        {0, 0, 0, 0, 0, 3, 0, 0, 0},
		        {1, 0, 0, 0, 0, 9, 5, 0, 0},
		        {8, 0, 0, 0, 0, 0, 0, 9, 0},
		        {0, 4, 3, 0, 0, 0, 7, 5, 0},
		        {0, 9, 0, 0, 0, 0, 0, 0, 8},
		        {0, 0, 9, 7, 0, 0, 0, 0, 5},
		        {0, 0, 0, 2, 0, 0, 0, 0, 0},
		        {0, 0, 7, 0, 4, 0, 2, 0, 3} 
		      };
		if(solverBoard(board)) {
			System.out.println("Solved sudoku successfully");
		}
		else{
			System.out.println("Unsolvable board ");
		}
		
		printBoard(board);
	}
	
	private static void printBoard(int[][] board) {
		for(int row=0; row< GRID_SIZE; row++) {
			for(int column =0; column< GRID_SIZE; column++){
				System.out.print(board[row][column]);
				if((column+1)%3==0) {
					System.out.print("|");
				}
			}
			System.out.println();
			if((row+1)%3==0) {
				System.out.println("____________");
			}
		
		}
	}

	private static boolean isNumberInRow(int[][] board, int number, int row) {
		for(int i=0;i<GRID_SIZE; i++) {
			if(board[row][i]==number) {
				return true;
			}
		}
		return false;
	}
	private static boolean isNumberInColumn(int[][] board, int number, int column) {
		for(int i=0;i<GRID_SIZE; i++) {
			if(board[i][column]==number) {
				return true;
			}
		}
		return false;
	}
	private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
		int localBoxRow = row-row%3;
		int localBoxColumn = column-column%3;
		for(int i=localBoxRow; i< localBoxRow+3; i++) {
			for(int j=localBoxColumn; j< localBoxColumn+3;j++) {
				if(board[i][j]==number) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
		return !isNumberInBox(board, number, row, column) && !isNumberInColumn(board, number, column) && !isNumberInRow(board, number, row);
		
	}
	
	private static boolean solverBoard(int[][] board) {
		for(int row=0; row< GRID_SIZE; row++) {
			for(int column=0; column< GRID_SIZE; column++) {
				if(board[row][column]==0) {
					for(int numberToTry =1; numberToTry<=GRID_SIZE; numberToTry++) {
						if(isValidPlacement(board, numberToTry, row, column)){
							board[row][column]= numberToTry;
							
							if(solverBoard(board)) {
								return true;
							}
							else {
								board[row][column]=0;
							} 
						}
					}
					return false;
				}
			}
		}
		return true;
	}
}










