package com.xunwen.tree.binary;

/**
 * The binary tree node that include value, left node pointer, right node pointer.
 * @author HunterGao
 * @since 1.0
 * @version 1.0
 */
public class BinaryTreeNode {

	private int value; 
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public BinaryTreeNode() {
		super();
	}

	public BinaryTreeNode(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
}
