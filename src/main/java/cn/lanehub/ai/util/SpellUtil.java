package cn.lanehub.ai.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpellUtil {


    public static List<String> getSpellParts(String commandString) {
        List<String> matches = new ArrayList<String>();
        // 匹配任意数量的非引号和非空格字符或用双引号括起来的任意字符串
        Pattern pattern = Pattern.compile("[^\\s\"]+|\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(commandString);
        // 匹配所有匹配项并去掉引号
        while (matcher.find()) {
            String match = matcher.group(0);
            // 如果是用引号括起来的字符串，去掉引号
            if (match.startsWith("\"") && match.endsWith("\"")) {
                match = match.substring(1, match.length() - 1);
                matches.add(match);
            }
            else{
                matches.add(match.trim());
            }
        }
        return matches;
    }

    // 示例用法
    public static void main(String[] args) {
        String commandString = "cmd \"    ar  g1    \"   arg2    arg3";
        List<String> parsedArgs = getSpellParts(commandString);
        System.out.println(parsedArgs);
    }

}
