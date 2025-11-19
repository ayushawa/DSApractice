class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st =new Stack<>();
        int i=0;
        int j=0;
        int n = pushed.length;
        while(i<n && j<n){
            if(st.isEmpty()) {
                st.push(pushed[i++]);
            }
            else if(st.peek() == popped[j]){
                st.pop();
                j++;
            }
            else st.push(pushed[i++]);
        }
        if(st.isEmpty()) return true;
        while(j<n &&  !st.isEmpty()){
            if(st.peek() == popped[j]) st.pop();
            j++;
        }

        return st.isEmpty();
    }
}