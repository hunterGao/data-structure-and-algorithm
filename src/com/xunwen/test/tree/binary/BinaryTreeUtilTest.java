package com.xunwen.test.tree.binary;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xunwen.tree.binary.BinaryTreeNode;
import com.xunwen.tree.binary.BinaryTreeUtil;

public class BinaryTreeUtilTest {

	/**
	 * run before execution of all test case
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp()");
	}
	
	/**
	 * run after execution of all test case
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown()");
	}
	
	/**
	 * run before execution of each test case
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass()");
	}

	/**
	 * run after execution of each test case
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
	}

	@Test
	public void testBuildTreeByOrder() {
		int[] preOrderArray = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inOrderArray = {4, 7, 2, 1, 5, 3, 8, 6};
		Integer[] postOrderArray = {7, 4, 2, 5, 8, 6, 3, 1};
		BinaryTreeNode root = BinaryTreeUtil.buildTreeByOrder(preOrderArray, inOrderArray);
		List<Integer> list = new ArrayList<Integer>();
		BinaryTreeUtil.traverseTreePostOrder(root, list);
		Integer[] resultArray = new Integer[postOrderArray.length];
		resultArray = list.toArray(resultArray);
		Assert.assertArrayEquals(postOrderArray, resultArray);
		
		list = BinaryTreeUtil.traverseTreePreOrder(root);
		resultArray = list.toArray(resultArray);
		Assert.assertArrayEquals(new Integer[]{1, 2, 4, 7, 3, 5, 6, 8}, resultArray);
		
	}
	
	

}
