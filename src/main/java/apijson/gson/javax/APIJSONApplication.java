/*Copyright ©2025 APIJSON(https://github.com/APIJSON)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package apijson.gson.javax;

import apijson.NotNull;
import apijson.framework.javax.APIJSONCreator;

import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**启动入口 Application
 * 调用 APIJSONApplication.init
 * @author Lemon
 */
public class APIJSONApplication extends apijson.framework.javax.APIJSONApplication {

    public static Gson GSON;
    public static TypeToken<?> JSON_OBJECT_TOKEN;
    public static Class<?> JSON_OBJECT_CLASS;
    public static TypeToken<?> JSON_ARRAY_TOKEN;
    public static Class<?> JSON_ARRAY_CLASS;
    static {
        GSON = apijson.gson.APIJSONApplication.GSON;
        JSON_OBJECT_TOKEN = apijson.gson.APIJSONApplication.JSON_OBJECT_TOKEN;
        JSON_OBJECT_CLASS = apijson.gson.APIJSONApplication.JSON_OBJECT_CLASS;
        JSON_ARRAY_TOKEN = apijson.gson.APIJSONApplication.JSON_ARRAY_TOKEN;
        JSON_ARRAY_CLASS = apijson.gson.APIJSONApplication.JSON_ARRAY_CLASS;

        // apijson.JSON.DEFAULT_JSON_PARSER = JSON.DEFAULT_JSON_PARSER; // 解决 DEFAULT_JSON_PARSER 初始化前就自测导致抛异常

        JSON.DEFAULT_JSON_PARSER = new JSONParser() {
            @Override
            public Map<String, Object> createJSONObject() {
                return JSONParser.super.createJSONObject();
            }

            @Override
            public List<Object> createJSONArray() {
                return JSONParser.super.createJSONArray();
            }

            @Override
            public String toJSONString(Object obj, boolean format) {
                if (obj instanceof String) {
                    if (! format) {
                        return (String) obj;
                    }

                    obj = parse(obj);
                }

                if (format) { // TODO 格式化
                    return GSON.toJson(obj);
                }

                return GSON.toJson(obj);
            }

            @Override
            public Object parse(Object json) {
                return GSON.fromJson(toJSONString(json), Object.class);
            }

            @Override
            public Map<String, Object> parseObject(Object json) {
                return GSON.fromJson(toJSONString(json), JSON_OBJECT_TOKEN.getType());
            }

            @Override
            public <T> T parseObject(Object json, Class<T> clazz) {
                return GSON.fromJson(toJSONString(json), clazz);
            }

            @Override
            public List<Object> parseArray(Object json) {
                return GSON.fromJson(toJSONString(json), JSON_ARRAY_TOKEN.getType());
            }

            @Override
            public <T> List<T> parseArray(Object json, Class<T> clazz) {
                return GSON.fromJson(toJSONString(json), new TypeToken<List<T>>(){}.getType());
            }
        };
    }


    //public static <T> APIJSONParser<T> createParser() {
    //    return (APIJSONParser<T>) DEFAULT_APIJSON_CREATOR.createParser();
    //}

    /**初始化，加载所有配置并校验
     * @return
     * @throws Exception
     */
    public static void init() throws Exception {
        init(true, DEFAULT_APIJSON_CREATOR);
    }
    /**初始化，加载所有配置并校验
     * @param shutdownWhenServerError
     * @return
     * @throws Exception
     */
    public static void init(boolean shutdownWhenServerError) throws Exception {
        init(shutdownWhenServerError, DEFAULT_APIJSON_CREATOR);
    }
    /**初始化，加载所有配置并校验
     * @param creator
     * @return
     * @throws Exception
     */
    public static <T, M extends Map<String, Object>, L extends List<Object>> void init(
            @NotNull APIJSONCreator<T, M, L> creator) throws Exception {
        init(true, creator);
    }
    /**初始化，加载所有配置并校验
     * @param shutdownWhenServerError
     * @param creator
     * @return
     * @throws Exception
     */
    public static <T, M extends Map<String, Object>, L extends List<Object>> void init(
            boolean shutdownWhenServerError, @NotNull APIJSONCreator<T, M, L> creator) throws Exception {
        apijson.framework.javax.APIJSONApplication.init(shutdownWhenServerError, creator);
    }

}
