package com.company;

public class Main {

    public static void main(String[] args) {
	Object[][]array = {{"Nice", 942208},{"Abu Dhabi", 1482816},{"Naples", 2186853},{"Vatican City", 572}};
    array=millionsRounding(array);
    for (int i = 0; i < array.length; i ++) {
        for (int j = 0; j < array[i].length; j ++) {
            System.out.print(array[i][j] + " ");
        }
        System.out.println();
    }
    }

    public static Object[][] millionsRounding (Object[][] array){
        for (int i = 0; i < array.length; i++) {
            array[i][1] = Math.round((double)(int)array[i][1]/1000000)*1000000;
        }
    return array;
    }
}
