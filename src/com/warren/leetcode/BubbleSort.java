package com.warren.leetcode;
/*冒泡排序
*
* 每一次外循环中的内循环都会把大的值往前挪，所以每次外循环之后就会产生一个最小值在最末尾，并且最后一个值不参与下次内循环
* */
public class BubbleSort {
    public int[] sort(int[] array) {
        boolean flag = false;   // 如果在一次内循环中没有一次交换的操作，足以说明已经排序完成了
        int temp;
        // 外循环
        for (int i = 0; i <array.length -1 ; i++) {
            // 内循环:把小的往后移
            for (int j = 0; j <array.length -i - 2 ; j++) {
                if (array[j] < array[j+1]){
                    // 调换位置
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (flag == false){
                return array;
            }
        }
        return array;
    }

        public static void main (String[]args){
            BubbleSort bubble = new BubbleSort();
//            int arr[] = {2,1,3,5,2,9,7,8,4,0};
            int arr[] = {4,3,2,1};
            bubble.sort(arr);
            for (int num : arr){
                System.out.print(num+"\t");
            }
            BubbleSort.BubbleSort();
        }

        public static void BubbleSort(){
            System.out.println(666);
        }
}
