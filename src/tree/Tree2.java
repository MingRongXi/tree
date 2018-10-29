package tree;

public class Tree2<T> {
	private Tree2<T> parent;
	private Tree2<T> left;
	private Tree2<T> right;
	private T value;

	public Tree2(T value, Tree2<T> parent, Tree2<T> left, Tree2<T> right) {
		this.value = value;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public Tree2(T value, Tree2<T> parent) {
		this(value, parent, null, null);
	}

	public Tree2(T value) {
		this(value, null);
	}

	static int index = 0;

	public static Tree2<Character> createTreeFromString(String cont) {
		char[] arg = cont.toCharArray();
		return createTree(arg, null);
	}

	public static Tree2<Character> createTree(char[] arg, Tree2<Character> p) {
		Tree2<Character> res;
		if (arg.length >= index && arg[index] != '*') {
			res = new Tree2<Character>(arg[index++], p);
			res.setLeft(createTree(arg, res));
			res.setRight(createTree(arg, res));
		} else {
			res = null;
			index++;
		}
		return res;
	}

	public Tree2<T> getChild(T value) {
		if (this.value == value) {
			return this;
		} else {
			Tree2<T> res;
			// = left == null? null : left.getChild(value);
			if (left != null) {
				res = left.getChild(value);
				if (res != null)
					return res;
			}

			if (right != null) {
				res = right.getChild(value);
				if (res != null)
					return res;
			}
			// Tree2<T> res = left == null? null : left.getChild(value);
			// return res == null ? right == null? null: right.getChild(value) : res;
		}
		return null;
	}

	public Tree2<T> getParent() {
		return parent;
	}

	public Tree2<T> getRoot() {
		if (parent == null) {
			return this;
		} else {
			return parent.getRoot();
		}
	}

	public void setLeft(Tree2<T> left) {
		this.left = left;
	}

	public void setRight(Tree2<T> right) {
		this.right = right;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void pre() {
		System.out.print(value + "  ");
		if (left != null)
			left.pre();
		if (right != null)
			right.pre();
	}

	public void end() {
		if (left != null)
			left.end();
		if (right != null)
			right.end();
		System.out.print(value + "  ");
	}

	public void mid() {
		if (left != null)
			left.mid();
		System.out.print(value + "  ");
		if (right != null)
			right.mid();
	}
}
