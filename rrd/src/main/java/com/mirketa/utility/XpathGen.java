package com.mirketa.utility;

public class XpathGen {
	public static String createXpath(String xpathExp, Object... args) {
		for (int i = 0; i < args.length; i++) {
			xpathExp = xpathExp.replace("{" + i + "}", (CharSequence) args[i]);
		}
		return xpathExp;
	}

	public static void main(String[] args) {
		String x1 = createXpath("//input[@id='{0}']", "test");
        System.out.println(x1);
	}




}
