package tree;

import stack.Stack;

public class NonRecursiveTree<E> {
	Stack<E> stack = new Stack<>();
	private Node<E> root;

	public NonRecursiveTree(String content) {
		createTree(content);
		System.out.println("s");
	}

	public static class Node<E> {
		private char data;
		private Node<E> leftChild;
		private Node<E> rightChild;
		private int popTime = 0;

		public char getData() {
			return data;
		}
	}

	@SuppressWarnings("unchecked")
	private void createTree(String content) {
		int index = 0;
		while (index < content.length()) {
			
			char c = content.toCharArray()[index++];
			Node<E> current = new Node<>();
			if (c == '*') {
				current = null;
			}
			else {
				current.data = c;
				
			}		
			
			if (!stack.isEmpty()) {
				Node<E> top = (Node<E>) stack.top();  stack.pop();   top.popTime++;
				if (top.popTime == 1) {
					top.leftChild = current;
					stack.push((E) top);
				} else  {
					top.rightChild = current;
				} 
				
				if(current != null) {
					stack.push((E) current);
				}
			}
			
			if(index == 1) {
				if(index == 1) {
					root = current;
					stack.push((E)current);
				}

			}
		}
		
	}
	
}
