package cn.lanehub.ai.exceptions;

public class ViewSpellCustomizeNotSupport  extends RuntimeException{


    public ViewSpellCustomizeNotSupport(){
        super("View Spell is already built-in to the system and there is no need for users to register it again.");
    }


}
