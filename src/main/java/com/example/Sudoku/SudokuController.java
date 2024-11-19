package com.example.Sudoku;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SudokuController {
	
	
	private int [][][][] answer;
	
	private SudukoManager sm = new SudukoManager(); 
	
	@GetMapping("/getSolution")
	public int[][] getSolution(){
		
		
		answer = sm.sudukoSolver();
		
		return sm.copy(answer);
	}
	@GetMapping("/getQuestion{num}")
	public int[][] getQuestion(@PathVariable int num){
		
		
		
		return sm.createQuestion(sm.copy(answer), num);
	}
}
