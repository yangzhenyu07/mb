package com.yzy.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author yangzhenyu
 * */
public class commonUtil {

	public final static Pattern yyy = Pattern.compile("_(\\w)");
	public static String lineToHump(String string) {
        Matcher matcher = yyy.matcher(string.toLowerCase(Locale.CHINESE));
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
	
	
    public static String captureName(String string) {
        char[] cs = string.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }
}
