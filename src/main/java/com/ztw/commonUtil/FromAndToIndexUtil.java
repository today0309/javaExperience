package com.ztw.commonUtil;

public class FromAndToIndexUtil {

	/**
	 * getFromAndToIndex:(获取起始和结束坐标). <br/>
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param totalSize
	 * @return
	 * @since JDK 1.8
	 */
	public static int[] getFromAndToIndex(int pageNum, int pageSize, int totalSize) {
		int fromIndex = (pageNum - 1) * pageSize; // 起始
		int toIndex = pageNum * pageSize; // 截止
		if (fromIndex > totalSize) {
			return null;
		} else if (toIndex > totalSize) {
			toIndex = totalSize;
		}
		int[] fromAndToIndex = { fromIndex, toIndex };
		return fromAndToIndex;
	}

}
