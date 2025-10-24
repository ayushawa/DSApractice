class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek() == ch){
                count.push(count.pop()+1);
            }
            else {
                st.push(ch);
                count.push(1);
            }

            if(count.peek() == k){
                st.pop();
                count.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            char c = st.pop();
            int n = count.pop();
            for(int i=0;i<n;i++) sb.append(c);
        }

        return sb.reverse().toString();
    }
}