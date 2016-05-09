package com.xunwen.tree.binary;

/**
 * The operation for binary tree, include build binary tree 
 * by pre-order array and in-order array {@code }}
 * @author HunterGao
 *
 */
public class BinaryTreeUtil {
 
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
		if (startInOrderIndex == endInOrderIndex) {
			if (preOrderArray[startPreOrderIndex] == inOrderArray[startInOrderIndex]) {
				return rootNode;
			}
			else {
				throw new Exception("Invalid input preorderarray or inorderarray");
			}
		}
		
		// find the value of root node in inOrderArray
		int rootInOrderIndex = startPreOrderIndex;
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
		return null;
	}
	
}
