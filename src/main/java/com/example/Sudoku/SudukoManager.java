package com.example.Sudoku;

import java.util.*;


public class SudukoManager {

	/**
	 * This is suduko solver
	 * @param arr
	 * @param mainRow
	 * @param mainCol
	 * @param row
	 * @param col
	 * @return
	 */
	public int [][][][] sudukoSolver(){
		int arr[][][][]=new int[3][3][3][3];



		//for randomising certain value
		//		int mainRow = 0, row = 0, mainCol = 0, col = 0, min = 0, max = 2;
		//		for(int i=0; i<9; ) {
		//			mainRow = min + (int)(Math.random() * ((max - min) + 1));
		//			row = min + (int)(Math.random() * ((max - min) + 1));
		//			mainCol = min + (int)(Math.random() * ((max - min) + 1));
		//			col = min + (int)(Math.random() * ((max - min) + 1));
		//
		//			int num= 1 + (int)(Math.random() * ((9 - 1) + 1));
		//			//			System.out.println(mainRow+" "+row+" "+mainCol+" "+col+" "+num);
		//			if(valid(arr, mainRow, mainCol, row, col, num)) {
		//				arr[mainRow][row][mainCol][col] = num;
		//				i++;
		//			}
		//		}

		sudukoSolver(arr, 0, 0, 0, 0);
		return arr;
	}
	public boolean sudukoSolver(int [][][][]arr, int mainRow, int mainCol, int row, int col) {

		if(col>2) {
			row++;
			col=0;
		}
		if(row>2) {
			mainCol++;
			row=0;
		}
		if(mainCol>2) {
			mainRow++;
			mainCol=0;
		}
		if(mainRow>2) {
			return true;
		}

		if(arr[mainRow][row][mainCol][col]>0) 
			return sudukoSolver(arr, mainRow, mainCol, row, col+1);

		Set<Integer> mySet = new HashSet<Integer>(Set.of(1,2,3,4,5,6,7,8,9));
		List<Integer> asList = new ArrayList<Integer>(mySet);
		Collections.shuffle(asList);

		for(int i=0; i<asList.size(); i++) {
			int elm = asList.get(i);
			if(valid(arr, mainRow, mainCol, row, col, elm)) {
				arr[mainRow][row][mainCol][col]=elm;
				if(sudukoSolver(arr, mainRow, mainCol, row, col+1))
					return true;
				arr[mainRow][row][mainCol][col]=0;
			}
		}

		return false;
	}
	public boolean valid(int arr[][][][], int mainRow, int mainCol, int row, int col, int num) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[mainRow][row][i][j]==num || 
						arr[mainRow][i][mainCol][j]==num || arr[i][j][mainCol][col]==num)
					return false;
			}
		}
		return true;
	}


	public int [][] createQuestion(int arr[][], int type) {
		int[] num={35,45,55,60};
		//		if(type==1) {
		//			num = 35;
		//		}
		//		else if(type==2) {
		//			num = 45;
		//		}
		//		else if(type==3) {
		//			num = 55;
		//		}
		//		else if(type==4) {
		//			num = 60;
		//		}

		question(arr, num[type-1]);

		return arr;
	}
	public void question(int arr[][], int n) {
		int row = 0, col = 0, min = 0, max = 8;
		for(int i=0; i<n; ) {
			row = min + (int)(Math.random() * ((max - min) + 1));
			col = min + (int)(Math.random() * ((max - min) + 1));
			if(arr[row][col] != 0 ) {
				arr[row][col] = 0;
				i++;
			}

		}
	}

	/**
	 * for array copy
	 * @param arr
	 */
	public int [][] copy(int arr[][][][]){
		int question[][]=new int [9][9];
		int row = 0, col = 0;

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				for(int k=0; k<arr[i][j].length; k++) {
					for(int l=0; l<arr[i][j][k].length; l++) {
						if(col==9) {
							row++;
							col=0;
						}
						question[row][col] = arr[i][j][k][l];
						col++;
					}
				}
			}
		}
		return question;
	}

	/**
	 * For printing array.
	 * @param arr
	 */
	public void print(int [][]arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
				if((j+1)%3==0) {
					System.out.print("| ");
				}

			}
			System.out.println();
			if((i+1)%3==0) {
				System.out.println("=====================");
			}
		}
		System.out.println();
	}

	public void print(int [][][][]arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				for(int k=0; k<arr[i][j].length; k++) {
					for(int l=0; l<arr[i][j][k].length; l++) {
						System.out.print(arr[i][j][k][l]+" ");
					}
					if(k<2) {
						System.out.print("| ");
					}
				}
				System.out.println();
			}
			if(i<2)
				System.out.println("=====================");
		}
		System.out.println();
	}





}
