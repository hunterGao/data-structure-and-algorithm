package com.xunwen.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The operation for binary tree, include build binary tree 
 * by pre-order array and in-order array {@code }}
 * @author HunterGao
 *
 */
public class BinaryTreeUtil {
	
	public static void traverseTreePreOrder(BinaryTreeNode rootNode, List<Integer> list) {
		// the condition to exit recursion
		if (rootNode == null || list == null) {
			return;
		}
		list.add(rootNode.getValue());
		if (rootNode.getLeft() != null) {
			traverseTreePreOrder(rootNode.getLeft(), list);
		}
		if (rootNode.getRight() != null) {
			traverseTreePreOrder(rootNode.getRight(), list);
		}
	}
	
	public static List<Integer> traverseTreePreOrder(BinaryTreeNode rootNode) {
		if (null == rootNode) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode node = rootNode;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				list.add(node.getValue());
				stack.push(node);
				node = node.getLeft();
			}
			if (!stack.isEmpty()) {
				BinaryTreeNode top = stack.pop();
				node = top.getRight();
			}
		}
		return list;
	}
	
	public static void traverseTreeInOrder(BinaryTreeNode rootNode, List<Integer> list) {
		// the condition to exit recursion
		if (null == rootNode || null == list) {
			return;
		}
		if (null != rootNode.getLeft()) {
			traverseTreeInOrder(rootNode.getLeft(), list);
		}
		list.add(rootNode.getValue());
		if (null != rootNode.getRight()) {
			traverseTreeInOrder(rootNode.getRight(), list);
		}
	}
	
	public static void traverseTreePostOrder(BinaryTreeNode rootNode, List<Integer> list) {
		// the condition to exit recursion
		if (rootNode == null || list == null) {
			return;
		}
		if (rootNode.getLeft() != null) {
			traverseTreePostOrder(rootNode.getLeft(), list);
		}
		if (rootNode.getRight() != null) {
			traverseTreePostOrder(rootNode.getRight(), list);
		}
		list.add(rootNode.getValue());
	}
 
	/**
	 * build binary tree 
	 * @param preOrderArray the array of pre-order
	 * 	for example {1, 2, 4, 7, 3, 5, 6, 8}
	 * @param inOrderArray the array of in-order
	 *  for example {4, 7, 2, 1, 5, 3, 8, 6}
	 * @return the root node of the whole tree
	 */
	public static BinaryTreeNode buildTreeByOrder(int[] preOrderArray, 
			int[] inOrderArray) {
		if (preOrderArray == null || preOrderArray.length == 0
				|| inOrderArray == null || inOrderArray.length == 0 ||
				preOrderArray.length != inOrderArray.length) {
			return null;
		}
		int end = preOrderArray.length - 1;
		try {
			return recurseBuildTreeByOrder(preOrderArray, inOrderArray, 
					0, end, 0, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * build tree by pre-order array and in-order array recursion
	 * @param preOrderArray: the array of pre-order
	 * @param inOrderArray: the array of in-order
	 * @param startPreOrderIndex: start index in pre-order array
	 * @param endPreOrderIndex: end index in pre-order array
	 * @param startInOrderIndex: start index in in-order array
	 * @param endInOrderIndex: end index in in-order array
	 * @return the root node of the whole tree
	 * @throws Exception when the pre-order array and in-order array is error
	 */
	private static BinaryTreeNode recurseBuildTreeByOrder(
			int[] preOrderArray, int[] inOrderArray, 
			int startPreOrderIndex,int endPreOrderIndex, 
			int startInOrderIndex, int endInOrderIndex) throws Exception {
		// the first value in preOrderArray is root node
		int rootValue = preOrderArray[startPreOrderIndex];
		BinaryTreeNode rootNode = new BinaryTreeNode();
		rootNode.setValue(rootValue);
		
		// the condition to exit recurse
		if (startPreOrderIndex == endPreOrderIndex) {
			if (preOrderArray[startPreOrderIndex] == inOrderArray[startInOrderIndex]
					&& startInOrderIndex == endInOrderIndex) {
				return rootNode;
			}
			else {
				throw new Exception("Invalid input preorderarray or inorderarray");
			}
		}
		
		// find the value of root node in inOrderArray
		int rootInOrderIndex = startInOrderIndex;
		while (rootInOrderIndex <= endPreOrderIndex && inOrderArray[rootInOrderIndex] != rootValue) {
			rootInOrderIndex++;
		}
		
		if (rootInOrderIndex == endPreOrderIndex && inOrderArray[rootInOrderIndex] != rootValue) {
			throw new Exception("Invalid input preorderarray or inorderarray");
		}
		int leftTreeLength = rootInOrderIndex - startInOrderIndex;
		int leftEndPreOrderIndex = startPreOrderIndex + leftTreeLength;
		// build the left tree node
		if (leftTreeLength > 0) {
			BinaryTreeNode leftNode = recurseBuildTreeByOrder(preOrderArray, inOrderArray, 
					startPreOrderIndex + 1, leftEndPreOrderIndex, 
					startInOrderIndex, rootInOrderIndex - 1);
			rootNode.setLeft(leftNode);
		}
		// build the right tree node
		if (leftTreeLength < endPreOrderIndex - startPreOrderIndex) {
			BinaryTreeNode rightNode = recurseBuildTreeByOrder(preOrderArray, inOrderArray, 
					leftEndPreOrderIndex + 1, endPreOrderIndex, 
					rootInOrderIndex + 1, endInOrderIndex);
			rootNode.setRight(rightNode);
		}
		return rootNode;
	}
	
}
