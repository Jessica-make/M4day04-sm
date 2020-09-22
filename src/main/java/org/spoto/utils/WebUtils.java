package org.spoto.utils;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;

public class WebUtils {

    public static String returnData(Object td ){

        JSONObject data =(JSONObject)JSONObject.toJSON(td);
        return data.toJSONString();
    }
}
