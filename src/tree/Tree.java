package tree;

public class Tree<E> {
	private int index = 0;
	private Node<E> root;
	public Tree(String content) {
		creatTree(content, root);
	}
	
	
	public static class Node<E>{
		private char data;
		private Node<E> leftChild;
		private Node<E> rightChild;
		
		public char getData(){
			return data;
		}
	}
	
	
	private Node<E> creatTree(String content, Node<E> current) {
		if(index < content.length()) {  //Make sure the string won't out.
			char c = content.charAt(index++);
			//System.out.println(c);
			if (c == '*') {
				current = null;
			}
			
			else {
				current = new Node<E>();
				if(index == 1) {
					root = current;		//If the current is the first element of the tree, it is the root.
				}
				current.data = c;
				current.leftChild = creatTree(content, current.leftChild);
				current.rightChild = creatTree(content, current.rightChild);
			}
			
			return current;
		}
		return null;
	}
	
	
	public Node<E> getParent(char value){
		return getParent(root, value);
	}
	
	public Node<E> getParent(Node<E> current, char value){
		if(current == null) {
			return null;
		}
		
		if((current.leftChild != null && current.leftChild.data == value) || (current.rightChild != null && current.rightChild.data == value)) {
			return current;
		}
		
		else {
			Node<E> p;
			if((p = getParent(current.leftChild, value)) != null) {
				return p;
			}
			else {
				return getParent(current.rightChild, value);
			}
		}
		
//错误代码：	原因：在查找时得到一个没有得到查找结果就进行了返回		更正：在得到查找结果后需判断是否为空，如果不为空才能返回
//		else {
//		if(current.leftChild != null) {
//			return getParent(current.leftChild, value);
//		}
//		
//		else if(current.rightChild != null) {
//			return getParent(current.rightChild, value);
//		}
//		else {
//			return null;
//		}
//	

		

	}
	
	
	public void preOutput() {
		preOutput(root);  //Traverse the tree from the root.
	}
	
	private void preOutput(Node<E> current) {
		if(current != null) {
			System.out.print(current.data + "  ");
			if(current.leftChild != null) {
				preOutput(current.leftChild);
			}
			if(current.rightChild != null) {
				preOutput(current.rightChild);
			}
		}
	}
	
	
	public void inorderOutput() {
		inorderOutput(root);
	}
	
	private void inorderOutput(Node<E> current) {
		if(current != null) {
			if(current.leftChild != null) {
				inorderOutput(current.leftChild);
			}
			System.out.print(current.data + "  ");
			if(current.rightChild != null) {
				inorderOutput(current.rightChild);
			}
		}
	}
	
	
	public void postOutput() {
		postOutput(root);
	}
	
	private void postOutput(Node<E> current) {
		if(current != null) {
			if(current.leftChild != null) {
				postOutput(current.leftChild);
			}
			if(current.rightChild != null) {
				postOutput(current.rightChild);
			}
			System.out.print(current.data + "  ");
		}
	}
	
}
