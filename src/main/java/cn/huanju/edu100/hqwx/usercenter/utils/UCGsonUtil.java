package cn.huanju.edu100.hqwx.usercenter.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Description: 说明
 * @Author: xushengbin@hqwx.com
 * @Date: 2021-06-17
 */
public class UCGsonUtil {

    private static GsonBuilder gsonBuilder = new GsonBuilder();
    private static Gson gson = new Gson();
    private static Gson gson_underscores = new Gson();
    static {
        gsonBuilder.registerTypeAdapter(java.util.Date.class, new DateSerializerUtils());
        gsonBuilder.registerTypeAdapter(java.util.Date.class, new DateDeserializerUtils());
        gsonBuilder.setDateFormat(DateFormat.LONG);
        gson = gsonBuilder.create();
        gson_underscores = new GsonBuilder()
                .setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(java.util.Date.class,
                        new DateSerializerUtils())
                .registerTypeAdapter(java.util.Date.class,
                        new DateDeserializerUtils())
                .setDateFormat(DateFormat.LONG).create();

    }

    public static Gson getGson() {
        return gson;
    }

    /**
     * 下划线风格
     * */
    public static Gson getUnderscoresGson() {
        return gson_underscores;
    }

    public static String toJson(Object src) {

        return gson.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    /**
     * json字符串转成list
     * TODO 严重问题 返回数据是 LinkedTreeMap
     *
     * @param gsonString
     * @return
     */
    public static <T> List<T> toList(String gsonString) {
        List<T> list = null;
        if (gson != null) {
            //根据泛型返回解析指定的类型,TypeToken<List<T>>{}.getType()获取返回类型
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {}.getType());
        }
        return list;
    }
}


class DateSerializerUtils implements JsonSerializer<Date> {

    @Override
    public JsonElement serialize(Date date, Type arg1,
                                 JsonSerializationContext arg2) {
        return new JsonPrimitive(date.getTime());
    }

}


class DateDeserializerUtils implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type arg1,
                            JsonDeserializationContext arg2) throws JsonParseException {
        return new Date(json.getAsJsonPrimitive().getAsLong());
    }

}
