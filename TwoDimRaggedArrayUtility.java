/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: Create a program that will be used to create sales report that will accommodate to positive and negative numbers.
 * Also, it will calculate holiday bonuses through arrays that represent the sales for each store in each category.
 * It will take in a bonus amount with the highest and lowest in the category. The results will be displayed using a GUI.
 * Due: 04/11/2022
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Renato Chavez
*/
import java.io.*;
import java.util.*;
import java.lang.*;

public class TwoDimRaggedArrayUtility {
	/**
	 * Pass in a file and return a 2D ragged array of doubles.
	 * @param file
	 * @return double raggedArr
	 */
	public static double[][] readFile(File file){
		double[][] raggedArr = new double[6][];
		String line;
		int i = 0;
		try {
			// open file 
			BufferedReader br = new BufferedReader(new FileReader(file));
			// read file
			while((line = br.readLine()) != null) {
				String[] temp = line.split(" ");
				int size = temp.length;
				raggedArr[i] = new double[size];
				// covert into doubles
				for(int j = 0; j < size; j++) {
					raggedArr[i][j] = Double.parseDouble(temp[j]);
				}
				i++;
			}
			br.close();
		}
		catch(Exception ep) {
			ep.printStackTrace();
		}
		return raggedArr;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a file. Then writes the ragged array into the file. Each row
	 * is separated by a line and each double element separated by a space.
	 * @param raggedArr
	 * @param file
	 */
	public static void writeToFile(double[][] raggedArr, File file) {
		try {
			// open file
			BufferedWriter br = new BufferedWriter(new FileWriter(file));
			// read array and print into file with spaces
			for(int i = 0; i < raggedArr.length; i++) {
				for(int j = 0; j < raggedArr[i].length; j++) {
					br.write(raggedArr[i][j] + " ");
				}
				br.newLine();
			}
			br.close();
		}
		catch(Exception ep) {
			ep.printStackTrace();
		}
	}
	
	/**
	 * Pass in a 2D array of doubles to then return the total of the elements in the array.
	 * @param raggedArray
	 * @return total
	 */
	public static double getTotal(double[][] raggedArr) {
		double total = 0;
		// find the sum of the values of the 2D array
		for(int i = 0; i < raggedArr.length; i++) {
			for(int j = 0; j < raggedArr[i].length; j++) {
				total += raggedArr[i][j];
			}
		}
		return total;
	}
	
	/**
	 * Pass in a 2D array of doubles and returns the average of the elements in the array.
	 * @param raggedArr
	 * @return (total / Number Of Elements)
	 */
	public static double getAverage(double[][] raggedArr) {
		double total = 0;
		int numOfElements = 0;
		// find the sum of the values in the 2D array
		for(int i = 0; i < raggedArr.length; i++) {
			for(int j = 0; j < raggedArr[i].length; j++) {
				total += raggedArr[i][j];
				numOfElements +=1;
			}
		}
		// find and return average
		return Double.valueOf(total / numOfElements);
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a row index to return the total of that row.
	 * Row index 0 is the first row in the array.
	 * @param raggedArr
	 * @param rowIndex
	 * @return total 
	 */
	public static double getRowTotal(double[][] raggedArr, int rowIndex) {
		double total = 0;
		for(int j = 0; j < raggedArr[rowIndex].length; j++) {
			total += raggedArr[rowIndex][j];
		}
		return total;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a column index to return the total of that column.
	 * Column index 0 is the first column in the array. If a row does not contain that column, it is not an error, but that row 
	 * will not participate in this method.
	 * @param raggedArr
	 * @param colIndex
	 * @return total
	 */
	public static double getColumnTotal(double[][] raggedArr, int colIndex) {
		double total = 0;
		for(int i = 0; i < raggedArr.length; i++) {
			if(colIndex <= raggedArr[i].length - 1)
				total += raggedArr[i][colIndex];
		}
		return total;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a row index to return the largest element in that row. 
	 * Row index 0 is the first row in the array.
	 * @param raggedArr
	 * @param rowIndex
	 * @return highest
	 */
	public static double getHighestInRow(double[][] raggedArr, int rowIndex) {
		double highest = raggedArr[rowIndex][0];
		for(int j = 0; j < raggedArr[rowIndex].length; j++) {
			if(raggedArr[rowIndex][j] > highest)
				highest = raggedArr[rowIndex][j];
		}
		return highest;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a row index to return the index of the largest element in that row.
	 * Row index 0 is the first row in the array.
	 * @param raggedArr
	 * @param row
	 * @return index 
	 */
	public static int getHighestInRowIndex(double[][] raggedArr, int row) {
		int index = 0;
		for(int i = 0; i < raggedArr[row].length; ++i) {
			if(raggedArr[row][i] > raggedArr[row][index]) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a row index to return the smallest element in that row.
	 * Row index 0 is the first row in the array.
	 * @param raggedArr
	 * @param rowIndex
	 * @return lowest
	 */
	public static double getLowestInRow(double[][] raggedArr, int rowIndex) {
		double lowest = raggedArr[rowIndex][0];
		for(int j = 0; j < raggedArr[rowIndex].length; j++) {
			if(raggedArr[rowIndex][j] < lowest)
				lowest = raggedArr[rowIndex][j];
		}
		return lowest;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a row index to return the index of the smallest element in that row.
	 * Row index 0 is the first row in the array.
	 * @param raggedArr
	 * @param row
	 * @return index
	 */
	public static int getLowestInRowIndex(double[][] raggedArr, int row) {
		int index = 0;
		for(int i = 0; i < raggedArr[row].length; ++i) {
			if(raggedArr[row][i] < raggedArr[row][index]) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a columns index to return the largest element in that column.
	 * Column index 0 is the first column in the array. If a row does not contain a column, it is not an error, 
	 * that row will not participate in this method.
	 * @param raggedArr
	 * @param colIndex
	 * @return highest
	 */
	public static double getHighestInColumn(double[][] raggedArr, int colIndex) {
		double highest = raggedArr[0][colIndex];
		for(int i = 0; i < raggedArr.length; i++) {
			if(colIndex <= raggedArr[i].length - 1) {
				if(raggedArr[i][colIndex] > highest)
					highest = raggedArr[i][colIndex];
			}
		}
		return highest;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a column index to return the index of the largest element in that column.
	 * Column index 0 is the first column in the array. If a row does not contain that column, it is not an error, 
	 * that row will not participate in this method.
	 * @param raggedArr
	 * @param col_index
	 * @return highest_ind
	 */
	public static int getHighestInColumnIndex(double[][] raggedArr, int col_index) {
		int highest_ind = 0;
		for(int i = 0; i < raggedArr.length; i++) {
			if(raggedArr[i].length > col_index) {
				if(raggedArr[i][col_index] > raggedArr[highest_ind][col_index])
					highest_ind = i;
			}
		}
		return highest_ind;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a column index to return the smallest element in that column. Column index 0 is the 
	 * first column in the array. If a row does not contain that column, it is not an error, that row will not participate in this method.
	 * @param raggedArr
	 * @param colIndex
	 * @return lowest
	 */
	public static double getLowestInColumn(double[][] raggedArr, int colIndex) {
		double lowest = raggedArr[0][colIndex];
		for(int i = 0; i < raggedArr.length; i++) {
			if(colIndex <= raggedArr[i].length - 1) {
				if(raggedArr[i][colIndex] < lowest)
					lowest = raggedArr[i][colIndex];
			}
		}
		return lowest;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles and a column index to return the index of the smallest element in that column.
	 * Column index 0 is the first column in the array. If a row does not contain that column, it is not an error,
	 * that row will not participate in this method.
	 * @param raggedArr
	 * @param col_index
	 * @return highest_ind
	 */
	public static int getLowestInColumnIndex(double[][] raggedArr, int col_index) {
		int highest_ind = 0;
		for(int i = 0; i < raggedArr.length; i++) {
			if(raggedArr[i].length > col_index) {
				if(raggedArr[i][col_index] < raggedArr[highest_ind][col_index])
					highest_ind = i;
			}
		}
		return highest_ind;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles to return the largest element in that array.
	 * @param raggedArr
	 * @return highest
	 */
	public static double getHighestInArray(double[][] raggedArr) {
		double highest = raggedArr[0][0];
		for(int i = 0; i < raggedArr.length; i++) {
			for(int j = 0; j < raggedArr[i].length; j++) {
				if(raggedArr[i][j] > highest)
					highest = raggedArr[i][j];
			}
		}
		return highest;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles to return the smallest element in that array.
	 * @param raggedArr
	 * @return lowest
	 */
	public static double getLowestInArray(double[][] raggedArr) {
		double lowest = raggedArr[0][0];
		for(int i = 0; i < raggedArr.length; i++) {
			for(int j = 0; j < raggedArr[i].length; j++) {
				if(raggedArr[i][j] < lowest)
					lowest = raggedArr[i][j];
			}
		}
		return lowest;
	}

}
