package cn.lanehub.ai.core.spell.impl;

import cn.lanehub.ai.core.spell.IMagicSpell;
import cn.lanehub.ai.core.spell.IMagicSpellResolver;
import cn.lanehub.ai.exceptions.Assert;
import cn.lanehub.ai.exceptions.SpellNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MagicSpellResolver implements IMagicSpellResolver {


    private static List<IMagicSpell> supportedMagicSpells= new ArrayList<>();
    static{
        supportedMagicSpells.add(new CallSpell());
        supportedMagicSpells.add(new SearchSpell());
        supportedMagicSpells.add(new ViewSpell());
        supportedMagicSpells.add(new SqlSpell());
        supportedMagicSpells.add(new MatchSpell());
    }


    @Override
    public IMagicSpell resolve(String spellText) {

        List<String> spellParts = getSpellParts(spellText);

        String spellName = spellParts.get(0).toLowerCase();
        Assert.isNotBlank(spellName, "Spell name");

        for (IMagicSpell spell : supportedMagicSpells){
            if(spell.fit(spellName)){
                return spell;
            }
        }

        throw new SpellNotFoundException(spellParts.get(0));
    }



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
