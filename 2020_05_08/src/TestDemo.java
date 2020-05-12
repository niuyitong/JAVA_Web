public class TestDemo {
    //连续子数组的最大和
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            nums[i] += Math.max(nums[i-1],0);
            res = Math.max(res,nums[i]);
        }
        return res;
    }
    //找前k个最小的数
    public int parttion(int[] arr, int l, int r){
        int tmp = arr[l];
        while(l<r){
            while(l<r && arr[r]>=tmp){
                r--;
            }
            if(l<r){
                arr[l] = arr[r];
            }
            while(l<r && arr[l]<=tmp){
                l++;
            }
            if(l<r){
                arr[r] = arr[l];
            }
        }
        arr[l] = tmp;
        return l;
    }
    public void quick(int[] arr, int l, int r, int k){
        if(l>=r){
            return;
        }
        int pivot = parttion(arr,l,r);
        if((pivot-l+1)==k) return ;
        if((pivot-l+1)>k) quick(arr,l,pivot-1,k);
        if((pivot-l+1)<k) quick(arr,pivot+1,r,k-(pivot-l+1));

    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //快排的思想
        quick(arr,0,arr.length-1,k);
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int num = nums[0];
        for(int i=0; i<nums.length; i++){
            if(num == nums[i]){
                count++;
            }else if(count>0){
                count--;
            }else{
                num = nums[i];
            }
        }
        return num;
    }
}
