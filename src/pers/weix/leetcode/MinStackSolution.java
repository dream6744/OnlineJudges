package pers.weix.leetcode;

import java.util.Stack;

public class MinStackSolution {
	public static class MinStack {
		private Stack<Integer> stack = new Stack<Integer>();
		private Stack<Integer> minStack = new Stack<Integer>();

		public void push(int x) {
			if (minStack.isEmpty() || x <= minStack.peek())
				minStack.push(x);
			stack.push(x);
		}

		public void pop() {
			if (stack.peek().equals(minStack.peek()))
				minStack.pop();
			stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return minStack.peek();
		}
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.getMin());
		System.out.println(stack.getMin());
		System.out.println(stack.getMin());
		System.out.println(stack.getMin());
		System.out.println(stack.getMin());
	}
}
