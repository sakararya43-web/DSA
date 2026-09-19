class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        ArrayList<Integer> list =new ArrayList<>();
        int l1=0,l2=0;
        int i=0;
        while(l1<m && l2<n)
        {
            if(nums1[l1]<nums2[l2])
            {
                list.add(nums1[l1]);
                l1++;
            }
            else{
                list.add(nums2[l2]);
                l2++;
            }
        }
        while(l1<m)
        {
            list.add(nums1[l1]);
            l1++;
        }
        while(l2<n)
        {
            list.add(nums2[l2]);
            l2++;
        }
        double median =0;
        
        int size =list.size();
        if(size % 2==0)
        {
             median = (double)((list.get(size/2-1) + list.get(size/2))/2.0);
            return median;
        }
        else{
            return list.get(size/2);
        }
        
    }
}