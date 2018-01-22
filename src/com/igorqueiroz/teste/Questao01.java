package com.igorqueiroz.teste;

/**
 * 
 * @author Igor Queiroz
 * 
 * The present class goal is to find the maximum contiguous sum and the start and end indexes from the original array. 
 *
 */

public class Questao01 {
	
	/**
	 * Takes an array as argument and returns another array with the start and end indexes of the original array corresponding to
	 * the maximum contiguous sum of the original array. 
	 * @param array
	 * @return 
	 */
	static int[] maximumSubArraySum(int array[]){
		int[] result = {0,0};
        int current_maximum = Integer.MIN_VALUE, last_maximum = 0, start = 0, end = 0, s = 0;
 
        for (int i = 0; i < array.length; i++){
            last_maximum += array[i];
 
            if (current_maximum < last_maximum){
                current_maximum = last_maximum;
                start = s;
                end = i;
            }
 
            if (last_maximum < 0){
                last_maximum = 0;
                s = i + 1;
            }
        }
        
        result[0] = start;
        result[1] = end;
        
        System.out.println("Maximum contiguous sum is " + current_maximum);
        System.out.println("Starting index " + result[0]);
        System.out.println("Ending index " + result[1] + "\n");
        
        return result;
    }

	public static void main(String[] args) {
		
		long startOfProcess = System.currentTimeMillis();
		
		int[] teste = {-1,2,-5,-10,20,-2,-3,10};
		int[] teste2 = {-10,-5,-150,-4,-2,-1};
		
		System.gc();
		
		maximumSubArraySum(teste);
		maximumSubArraySum(teste2);
		
		long endOfProcess = System.currentTimeMillis();
        System.out.println("Time spent: " + (endOfProcess - startOfProcess) + " miliseconds");

	}

}
