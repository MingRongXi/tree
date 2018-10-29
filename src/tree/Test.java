package tree;

import tree.Tree.Node;

public class Test {
	
	private static String testString = "1234**59****67**8**";

	public static void main(String[] args) {
		testOutput();
//		testGetParent('9');
		System.out.println("----------------");
		test1();
	}
	
	public static <E> void testOutput() {
		Tree<E> testTree = new Tree<>(testString);
		testTree.preOutput();
		System.out.println();
		testTree.inorderOutput();
		System.out.println();
		testTree.postOutput();
		System.out.println();
	}
	
	public static <E> void testGetParent(char c) {
		Tree<E> testTree = new Tree<>(testString);
		Node<E> result = testTree.getParent(c);
		System.out.println(result.getData());
	}
	
	public static void test1() {
		Tree2<Character> testTree = Tree2.createTreeFromString(testString);
		testTree.pre();
		System.out.println();
		testTree.mid();
		System.out.println();
		testTree.end();
		System.out.println();	
	}
}
