package bean;

import formation.domain.ParamtypeQuestion;

import java.util.HashMap;
import java.util.List;

/**
 * Created by victor on 13/01/2016.
 */
public class StaticList {

    private static HashMap<String,ParamtypeQuestion> mapTypeQuestion;


    public static HashMap<String,ParamtypeQuestion> getList() {
        return mapTypeQuestion;
    }

    public static void setList(HashMap<String,ParamtypeQuestion> list) {
        mapTypeQuestion = new HashMap<String,ParamtypeQuestion>();
        mapTypeQuestion = list;
        //test
    }
}

