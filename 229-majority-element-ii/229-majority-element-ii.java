class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m1=0,m2=0,count1=0,count2=0;
        for(int i:nums){
            if(i==m1)count1++;
            else if(i==m2)count2++;
            else if(count1==0){
                m1=i;
                count1++;
            }else if(count2==0){
                m2=i;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i:nums){
            if(i==m1)count1++;
            else if(i==m2)count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(count1>nums.length/3)ans.add(m1);
        if(count2>nums.length/3)ans.add(m2);
        return ans;
    }
}