class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=nums[0],candidate2=nums[0],count1=0,count2=0;
        for(int i:nums){
            if(i==candidate1)
                count1++;
            else if(i==candidate2)
                count2++;
            else if(count1==0){
                candidate1 = i;
                count1=1;
            }
            else if(count2==0){
                candidate2 = i;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i:nums){
            if(i==candidate1)
                count1++;
            else if(i==candidate2)
                count2++;
        }
        List<Integer> x = new ArrayList<>();
        if(count1>nums.length/3)
            x.add(candidate1);
        if(count2>nums.length/3)
            x.add(candidate2);
        return x;
    }
}