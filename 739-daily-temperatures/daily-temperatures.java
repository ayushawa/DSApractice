class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st =new Stack<>();
        int n  = arr.length;

        int ans[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<= arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }

        return ans;
    }
}