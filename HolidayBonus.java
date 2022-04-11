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
public class HolidayBonus {
	
	/**
	 * Pass in a 2D ragged array of doubles and the bonus amount for the store with the highest sales in a category, as well as the 
	 * bonus amount for the store with the lowest sales in a category and bonus amount for all other stores. Returns an array of doubles
	 * that represents the holiday bonuses for each of the stores in the district. The first entry dimensional ragged array of doubles.
	 * Uses the methods from TwoDimRaggedArrayUtility when needed.
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return holidayBonusPerStore
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[][] holidayBonusArr = new double[data.length][];
		for(int i = 0; i < data.length; i++) {
			holidayBonusArr[i] = new double[data[i].length];
		}
		for(int i = 0, j = 0; i < holidayBonusArr.length; i++, j++) {
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			if(i < holidayBonusArr[j].length) {
				holidayBonusArr[highIndex][i] = high;
				holidayBonusArr[lowIndex][i] = low;
				if(j == highIndex || j == lowIndex) {
					continue;
				}
				else {
					holidayBonusArr[j][i] = other;
				}
			}
		}
		double[] holidayBonusPerStore = new double[data.length];
		for(int i = 0; i < holidayBonusArr.length; i++) {
			for(int j = 0; j < holidayBonusArr[i].length; j++) {
				holidayBonusPerStore[i] += holidayBonusArr[i][j];
			}
		}
		return holidayBonusPerStore;
	}
	
	/**
	 * Pass in a 2D ragged array of doubles, the bonus amount for the store with the highest sales in the category, the bonus amount
	 * for the store with the lowest sales in a category, and the bonus amount for all other stores. It will return a double which represents
	 * the total of all Holiday Bonuses for the District. You will be using methods from the TwoDimRaggedArrayUtility when needed.
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return holidayTotal
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[][] holidayBonusArr = new double[data.length][];
		for(int i = 0; i < data.length; i++) {
			holidayBonusArr[i] = new double[data[i].length];
		}
		for(int i = 0, j = 0; i < holidayBonusArr.length; i++, j++) {
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			if(i < holidayBonusArr[j].length) {
				holidayBonusArr[highIndex][i] = high;
				holidayBonusArr[lowIndex][i] = low;
				if(j == highIndex || j == lowIndex) {
					continue;
				}
				else {
					holidayBonusArr[j][i] = other;
				}
			}
		}
		double holidayTotal = 0.0;
		for(int i = 0; i < holidayBonusArr.length; i++) {
			for(int j = 0; j < holidayBonusArr[i].length; j++) {
				holidayTotal += holidayBonusArr[i][j];
			}
		}
		return holidayTotal;
	}

}
