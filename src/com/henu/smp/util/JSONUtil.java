package com.henu.smp.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONUtil {
    public static String parseToString(Object object) {
        if (object instanceof Iterable<?>) {
            return JSONArray.fromObject(object).toString();
        }
        return JSONObject.fromObject(object).toString();
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> formatToList(String jsonString, Class<T> cls) {
        if (JSONUtil.isArray(jsonString)) {
            JSONArray jsonArray = JSONArray.fromObject(jsonString);
            return (List<T>) JSONArray.toCollection(jsonArray, cls);
        }
        List<T> result = new ArrayList<T>();
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        result.add((T) JSONObject.toBean(jsonObject, cls));
        return result;
    }

    public static boolean isArray(String jsonString) {
        if (jsonString.charAt(0) == '[' && jsonString.charAt(jsonString.length() - 1) == ']') {
            return true;
        }
        return false;
    }
}
