package tree;

import stack.Stack;

public class NonRecursiveTree<E> {
	Stack<E> stack = new Stack<>();
	private Node<E> root;

	public NonRecursiveTree(String content) {
		createTree(content);
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
				} else if (top.popTime == 2) {
					top.rightChild = current;
					top.popTime = 0;
					//stack.push((E) top);   注：当一个元素被取出两次时，它就不能入栈。
				} 
				
				if(current != null) {
					stack.push((E) current);
				}
			}
			
			if(index == 1) {
				root = current;
				stack.push((E) current);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Node<E> getFirstInPostOrder(){
		stack.clean();
		stack.push((E)root);
		return getNextInPostOrder();
	}
	
	@SuppressWarnings("unchecked")
	public Node<E> getNextInPostOrder(){
		if(stack.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for( ; ; ) {	
				Node<E> top = (Node<E>)stack.top();  stack.pop();	
				top.popTime++;
				if(top.popTime == 3) {
					top.popTime = 0;
					return top;
				}
				else if(top.popTime == 2) {
					stack.push((E)top);
					if(top.rightChild != null) {
						stack.push((E)top.rightChild);
					}
				}
				else {
					stack.push((E)top);
					if(top.leftChild != null) {
						stack.push((E)top.leftChild);
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Node<E> getFirstInOrder(){
		stack.clean();
		stack.push((E)root);
		return getNextInOrder();
	}
	
	
	@SuppressWarnings("unchecked")
	public Node<E> getNextInOrder(){
		if(stack.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for( ; ; ) {
				Node<E> top = (Node<E>) stack.top();  stack.pop();
				top.popTime++;
				if(top.popTime == 1 ) {
					stack.push((E) top);
					if(top.leftChild != null)	stack.push((E)top.leftChild);
				}
				else {
					if(top.rightChild != null)  stack.push((E)top.rightChild);
					top.popTime = 0;
					return top;
				}
			}
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public Node<E> getFirstInPreOrder(){
		stack.clean();
		stack.push((E)root);
		return getNextInPreOrder();
	}
	@SuppressWarnings("unchecked")
	public Node<E> getNextInPreOrder(){
		if(stack.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			Node<E> top = (Node<E>) stack.top();
			stack.pop();
			if (top.rightChild != null) stack.push((E) top.rightChild);
			if(top.leftChild != null) stack.push((E) top.leftChild);
			return top;
		}
	}
	
	public Stack<E> getStack() {
		return stack;
	}
	
}
