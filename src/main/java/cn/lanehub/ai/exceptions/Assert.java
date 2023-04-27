package cn.lanehub.ai.exceptions;

public class Assert {




    public static void test(boolean expression, String errorMessage){

        if(!expression){
            throw new OmniGPTGeneralException(errorMessage);
        }

    }

    public static void isNotBlank(String targetString, String targetName){

        test(targetString != null && !targetString.isEmpty(), targetName + " should not be empty!");

    }


}
