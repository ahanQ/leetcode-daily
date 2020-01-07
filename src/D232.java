import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author luliuquan
 * @date 2020/1/7 9:22
 */
public class D232 {

    public static void main(String[] args) {

        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param2 = obj.pop();
        int param3 = obj.peek();
        boolean param4 = obj.empty();
    }

    static
    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            turn();
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            turn();
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            turn();
            return stack2.empty();
        }

        private void turn() {
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
