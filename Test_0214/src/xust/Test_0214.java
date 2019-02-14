package xust;

import java.util.Arrays;

/*
575. 分糖果
 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

示例 1:
输入: candies = [1,1,2,2,3,3]
输出: 3
解析: 一共有三种种类的糖果，每一种都有两个。
     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
     
示例 2 :
输入: candies = [1,1,2,3]
输出: 2
解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
注意:
数组的长度为[2, 10,000]，并且确定为偶数。
数组中数字的大小在范围[-100,000, 100,000]内。
 */
/*
 * 分析：
 * 将糖果平均分给一个弟弟和一个妹妹，要求妹妹获得的糖果种类数最多，因此在分糖果时当然要尽量把不同种类的糖分给妹妹，
 * 计算糖果的种类数，
 * 如果糖果的种类数不小于妹妹所应得的糖果数量，那么妹妹当然能获得与应得糖果数量相同的种类数，
 * 如果糖果的种类数小于妹妹所应得的糖果数量，那么妹妹获得糖果最大种类数自然就是糖果的种类数。
 */
//public class Test_0214 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] candies = {1,1,1,1,2,2,2,3,3,3};
//		System.out.println(So.distributeCandies(candies));
//	}
//}
//class Solution {
//    public int distributeCandies(int[] candies) {
//    	if(candies.length == 0)
//    		return 0;
//    	int types_candies = 1;//糖果种类
//    	int i=0;
//    	//计算糖果种类的思想是边计算边去重，避免相同种类的糖果被反复计算
//        while(i<candies.length){
//        	if(candies[i] != candies[0]){
//        		types_candies++;
//        		//去重
//            	for(int j=i+1; j<candies.length; j++){
//            		if(candies[j] == candies[i])
//            			candies[j] = candies[0];
//            	}
//        	}
//        	i++;
//        }
//        return Math.min(candies.length/2, types_candies);
//    }
//}
/*
581. 最短无序连续子数组
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
你找到的子数组应是最短的，请输出它的长度。

示例 1:
输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :
输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
/*
 * 分析：
 * 备份数组内容，给备份数组排序，用双指针l,r从前向后、从后向前遍历数组nums，直到nums的第l,r位不同于备份数组的第l,r位，此时就得到了最短无序连续子数组的首位和末位，
 * 若l等于r，说明l,r之间没有元素，返回0，若l不等于r，返回r-l+1。
 */
public class Test_0214 {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] nums = {2,6,4,8,10,9,15};
		System.out.println(So.findUnsortedSubarray(nums));
	}
}
class Solution {
    public int findUnsortedSubarray(int[] nums) {
    	int[] temp = new int[nums.length];
    	//拷贝数组内容
    	for(int i=0; i<nums.length; i++){
    		temp[i] = nums[i];
    	}
    	Arrays.sort(temp);
    	int l=0;
    	int r=nums.length-1;
    	while(l<nums.length){
    		if(nums[l] != temp[l])
    			break;
    		l++;
    	}
    	while(r>l){
    		if(nums[r] != temp[r])
    			break;
    		r--;
    	}
    	return r-l == 0 ? 0 :r-l+1;
    }
}