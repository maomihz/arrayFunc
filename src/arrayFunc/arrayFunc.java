package arrayFunc;

import java.util.Random;
/**
 * java array function collection
 * contains different kinds of array functions.
 * @author MaomiHz
 * 
 */
public class arrayFunc {

	final private static String SEPERATOR = ",";
	
	/* function: quicksort
	 * 
	 */
	public static void sort(int[] x){
		quickSort(x, 0, x.length - 1);
	}
	public static int[] sortReturn(int[] x){
		int[] temp = new int[x.length];
		for (int i=0;i<x.length;i++){
			temp[i] = x[i];
		}
		quickSort(temp, 0, temp.length - 1);
		return temp;
	}
	private static void quickSort(int[] x, int start, int end) {
		if ((end - start) <= 0) return;
		int pivot = end;
		int index = start;
		for(int i=start;i<end;i++) {
			if (x[i] < x[pivot]){
				swap(x, i, index);
				index++;
			}
		}
		swap(x, pivot, index);
		
		if (index > start){
			quickSort(x, start, index-1);
		}
		if (index < end) {
			quickSort(x, index+1, end);
		}
	}
	
	/*
	 * function: isSorted
	 */
	public static boolean isSorted(int[] x) {
		for (int i=0;i<x.length-1;i++){
			if (x[i] > x[i+1]) return false;
		}
		return true;
	}
	
	
	/*
	 * function: reverse an array
	 * usage: reverse(array[])
	 */
	
	public static void reverse(int[] x){
		int[] temp = reverseReturn(x);
		for(int i=0;i<x.length;i++){
			x[i] = temp[i];
		}
		
	}
	public static int[] reverseReturn(int[] x) {
		int[] temp = x.clone();
		for (int i=0;i<temp.length;i++){
			temp[i] = x[temp.length - i - 1];
		}
		return temp;
	}
	
	/*
	 * 
	 * function: generate a random array
	 * 
	 * usage: arrayFunc.randomArray(10,10);
	 * generate an array with int element(0-9) and length 10.
	 * 
	 * arrayFunc.randomArray(10,20,8);
	 * generate an array with int element(10-20) and length 8.
	 */
	public static int[] randomArray() {
		int[] x = randomArray(0,9,10);
		return x;
	}
	public static int[] randomArray(int length) {
		int[] x = randomArray(0,9,length);
		return x;
	}
	public static int[] randomArray(int scope, int length) {
		int[] x = randomArray(0, scope-1, length);
		return x;
	}
	public static int[] randomArray(int start, int end, int length) {
		int scope = end - start + 1;
		int[] x = new int[length];
		Random randomGen = new Random();
		for (int i = 0;i<x.length;i++){
			x[i] = randomGen.nextInt(scope) + start;
		}
		return x;
	}
	public static String randomString() {
		String x = randomString(32,127,20);
		return x;
	}
	public static String randomString(int length) {
		String x = randomString(32,127, length);
		return x;
	}
	public static String randomString(int start, int end, int length) {
		int scope = end - start + 1;
		Random randomGen = new Random();
		String r = new String();
		for (int i = 0;i<length;i++){
			r += (char)(randomGen.nextInt(scope) + start);
		}
		return r;
		
	}
	
	/*
	 * function:find the max or min value of an array.
	 */
	public static int max(int[] x) {
		int[] temp = x.clone();
		for (int i=0;i<temp.length-1;i++){
			if (temp[temp.length - 1 - i] > temp[temp.length - 2 - i])
				swap(temp, temp.length - 1 - i, temp.length - 2 - i);
		}
		return temp[0];
		
	}
	public static int min(int[] x) {
		int[] temp = x.clone();
		for (int i=0;i<temp.length-1;i++){
			if (temp[temp.length - 1 - i] < temp[temp.length - 2 - i])
				swap(temp, temp.length - 1 - i, temp.length - 2 - i);
		}
		return temp[0];
	}
	
	/*
	 * function: sort an array randomly
	 */
	public static int[] shuffleReturn(int[] x){
		Random randomGen = new Random();
		boolean[] flag = new boolean[x.length];
		int[] temp = x.clone();
		for (int i=0;i<x.length;i++){
			int index;
			do {
				index = randomGen.nextInt(x.length);
			}while(flag[index]);
			temp[i] = x[index];
			flag[index] = true;
		}
		return temp;
	}
	public static char[] shuffleReturn(char[] x){
		Random randomGen = new Random();
		boolean[] flag = new boolean[x.length];
		char[] temp = x.clone();
		for (int i=0;i<x.length;i++){
			int index;
			do {
				index = randomGen.nextInt(x.length);
			}while(flag[index]);
			temp[i] = x[index];
			flag[index] = true;
		}
		return temp;
	}
	
	public static void shuffle(int[] x) {
		int[] temp = shuffleReturn(x);
		for(int i=0;i<x.length;i++){
			x[i] = temp[i];
		}
	}
	public static void shuffle(char[] x) {
		char[] temp = shuffleReturn(x);
		for(int i=0;i<x.length;i++){
			x[i] = temp[i];
		}
	}
	public static String shuffle(String x) {
		char[] temp = new char[x.length()];
		for(int i=0;i<x.length();i++){
			temp[i] = x.charAt(i);
		}
		shuffle(temp);
		String r = new String();
		for (int i:temp){
			r+=String.format("%c", i);
		}
		return r;
	}
	/*
	 * function: count an element in an array.
	 */
	public static int countElement(int[] x, int element) {
		int count = 0;
		for (int i: x) {
			if (i == element)
				count++;
		}
		return count;
	}
	
	/*
	 * function: if the array have repeated elements, then return true.
	 */
	public static boolean isRepeated(int[] x){
		for (int i: x){
			if (countElement(x, i) > 1) return true;
		}
		return false;
	}
	
	/*
	 * function: print an array
	 */
	public static void printArray(int[] x) {
		for(int i=0;i<x.length;i++){
			System.out.printf("%d%s", x[i], i==x.length-1?"\n":SEPERATOR);
		}
	}
	public static void printArray(char[] x) {
		for(int i=0;i<x.length;i++){
			System.out.printf("%c%s", x[i], i==x.length-1?"\n":SEPERATOR);
		}
	}
	/*
	 * function: swap element
	 */
	private static void swap(int[] x, int index1, int index2){
		int temp = x[index1];
		x[index1] = x[index2];
		x[index2] = temp;
	}
}
