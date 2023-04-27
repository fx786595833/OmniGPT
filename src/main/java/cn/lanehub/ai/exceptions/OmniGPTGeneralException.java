package cn.lanehub.ai.exceptions;

public class OmniGPTGeneralException  extends RuntimeException{


    public OmniGPTGeneralException(String message){
        super("OmniGPT: " + message);
    }

}
