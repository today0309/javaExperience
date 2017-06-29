package com.ztw.commonUtil;

/**
 * 枚举用法
 * 
 * @author Administrator
 *
 */
public enum FcSecuMarket {

	SH("CNSESH"),

	SZ("CNSESZ"),

	HK("HKSE00");

	private FcSecuMarket(String code) {
		this.code = code;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public static boolean contains(String code) {
		if (code == null)
			return false;
		for (FcSecuMarket market : FcSecuMarket.values()) {
			if (market.code.equalsIgnoreCase(code.trim())) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(FcSecuMarket.HK.code);// HKSE00
		System.out.println(FcSecuMarket.contains("SH"));// false
		System.out.println(FcSecuMarket.contains("CNSESZ"));// true
	}

}
