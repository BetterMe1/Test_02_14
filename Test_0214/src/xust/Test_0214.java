package xust;

import java.util.Arrays;

/*
575. ���ǹ�
 ����һ��ż�����ȵ����飬���в�ͬ�����ִ����Ų�ͬ������ǹ���ÿһ�����ִ���һ���ǹ�������Ҫ����Щ�ǹ�ƽ���ָ�һ���ܵܺ�һ�����á��������ÿ��Ի�õ�����ǹ�����������

ʾ�� 1:
����: candies = [1,1,2,2,3,3]
���: 3
����: һ��������������ǹ���ÿһ�ֶ���������
     ���ŷ��䷽�������û��[1,2,3],�ܵ�Ҳ���[1,2,3]������ʹ���û���ǹ�����������ࡣ
     
ʾ�� 2 :
����: candies = [1,1,2,3]
���: 2
����: ���û���ǹ�[2,3],�ܻܵ���ǹ�[1,1]�����������ֲ�ͬ���ǹ����ܵ�ֻ��һ�֡�����ʹ�����ÿ��Ի�õ��ǹ���������ࡣ
ע��:
����ĳ���Ϊ[2, 10,000]������ȷ��Ϊż����
���������ֵĴ�С�ڷ�Χ[-100,000, 100,000]�ڡ�
 */
/*
 * ������
 * ���ǹ�ƽ���ָ�һ���ܵܺ�һ�����ã�Ҫ�����û�õ��ǹ���������࣬����ڷ��ǹ�ʱ��ȻҪ�����Ѳ�ͬ������Ƿָ����ã�
 * �����ǹ�����������
 * ����ǹ�����������С��������Ӧ�õ��ǹ���������ô���õ�Ȼ�ܻ����Ӧ���ǹ�������ͬ����������
 * ����ǹ���������С��������Ӧ�õ��ǹ���������ô���û���ǹ������������Ȼ�����ǹ�����������
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
//    	int types_candies = 1;//�ǹ�����
//    	int i=0;
//    	//�����ǹ������˼���Ǳ߼����ȥ�أ�������ͬ������ǹ�����������
//        while(i<candies.length){
//        	if(candies[i] != candies[0]){
//        		types_candies++;
//        		//ȥ��
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
581. �����������������
����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������
���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�

ʾ�� 1:
����: [2, 6, 4, 8, 10, 9, 15]
���: 5
����: ��ֻ��Ҫ�� [6, 4, 8, 10, 9] ��������������ô���������Ϊ��������
˵�� :
��������鳤�ȷ�Χ�� [1, 10,000]��
�����������ܰ����ظ�Ԫ�� �������������˼��<=��
 */
/*
 * ������
 * �����������ݣ�����������������˫ָ��l,r��ǰ��󡢴Ӻ���ǰ��������nums��ֱ��nums�ĵ�l,rλ��ͬ�ڱ�������ĵ�l,rλ����ʱ�͵õ�����������������������λ��ĩλ��
 * ��l����r��˵��l,r֮��û��Ԫ�أ�����0����l������r������r-l+1��
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
    	//������������
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