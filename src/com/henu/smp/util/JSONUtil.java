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

    public static String getString(JSONObject object, String key) {
        return object.get(key).toString();
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> formatToList(String jsonStr, Class<T> cls) {
        if (JSONUtil.isArray(jsonStr)) {
            JSONArray jsonArray = JSONArray.fromObject(jsonStr);
            return (List<T>) JSONArray.toCollection(jsonArray, cls);
        }
        List<T> result = new ArrayList<T>();
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        result.add((T) JSONObject.toBean(jsonObject, cls));
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T formatToBean(String jsonStr, Class<T> cls) {
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);
        return (T) JSONObject.toBean(jsonObject, cls);
    }

    public static JSONObject formatToMap(String jsonStr) {
        return JSONObject.fromObject(jsonStr);
    }

    public static boolean isArray(String jsonStr) {
        if (jsonStr.charAt(0) == '[' && jsonStr.charAt(jsonStr.length() - 1) == ']') {
            return true;
        }
        return false;
    }

    public static String formatString(String jsonStr) {
        StringBuilder result = new StringBuilder();
        String[] datas = jsonStr.split("\\\\");
        for (String data : datas) {
            result.append(data);
        }
        return result.toString();
    }
}
