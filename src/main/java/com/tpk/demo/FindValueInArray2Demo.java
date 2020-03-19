package com.tpk.demo;

/**
 * @program: offer
 * @description: 二维数组排序
 * @author: tianpanke
 * @create: 2020-03-19
 **/
public class FindValueInArray2Demo {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     */

    // 如果你会写个简单的嵌套循环，那么该问题的解决也一定游刃有余，但关键点是如何做到最优解。
    // 采用常规遍历方法解决，可以达到目的，但是整个算犯法的时间复杂度O(i*j);
    // 认真研读题目，你会发现题目中给出的二维数组是有严格的递增规律的。将整个二维数组的展开图
    // 铺到脑海里，你会发现左下角的数据key,往上走比之小，往左走比之小。可在该规律的基础上，利用
    // 单层循环，判断目标值和key值大小，从而控制指针移动或成功退出。该算法时间复杂度O(i+j).

    public static void main(String[] args) {
        FindValueInArray2Demo demo=new FindValueInArray2Demo();
        System.out.println(demo.find(6,demo.initArrayData()));
    }
    public int[][] initArrayData(){
        int [][]array={{1,2,3},{2,4,6},{5,7,9}};
        return array;
    }
    public boolean find(int target,int [][]array){
        if(array==null||array.length==0||array[0].length==0){
            return false;
        }
        int width=array[0].length;
        int height=array.length;

        int i=height-1;
        int j=0;
        while(i>=0&&j<width){
            int value=array[i][j];
            if(value==target){
                return true;
            }else if(value>target){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }

}
