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

package apijson.gson;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**JSON工具类 防止解析时异常
 * @author Lemon
 */
public class JSON extends apijson.JSON {
	public static Map<String, Object> newJSONObject() {
		return apijson.JSON.createJSONObject();
	}
	public static Map<String, Object> newJSONObject(String key, Object value) {
		return apijson.JSON.createJSONObject(key, value);
	}
	public static Map<String, Object> newJSONObject(Map<? extends String, ?> map) {
		return apijson.JSON.createJSONObject(map);
	}

	public static List<Object> newJSONArray() {
		return apijson.JSON.createJSONArray();
	}
	public static List<Object> newJSONArray(Object obj) {
		return apijson.JSON.createJSONArray(obj);
	}
	public static List<Object> newJSONArray(Collection<?> list) {
		return apijson.JSON.createJSONArray(list);
	}


	/**
	 * @param json
	 * @return
	 */
	public static Map<String, Object> parseObject(Object json) {
		return apijson.JSON.parseObject(json);
	}
	public static <T> T parseObject(Object json, Class<T> clazz) {
		return apijson.JSON.parseObject(json, clazz);
	}


	/**
	 * @param json
	 * @return
	 */
	public static List<Object> parseArray(Object json) {
		return apijson.JSON.parseArray(json);
	}
	public static <T> List<T> parseArray(Object json, Class<T> clazz) {
		return apijson.JSON.parseArray(json, clazz);
	}

	/**
	 * Get a value from a Map and convert to the specified type
	 * @param map Source map
	 * @param key The key
	 * @return The converted value
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> gainJSONObject(Map<String, Object> map, String key) {
		return apijson.JSON.getJSONObject(map, key);
	}

	/**
	 * Get a value from a Map and convert to the specified type
	 * @param map Source map
	 * @param key The key
	 * @return The converted value
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> gainJSONArray(Map<String, Object> map, String key) {
		Object obj = get(map, key);
		return apijson.JSON.getJSONArray(map, key);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> gainJSONObject(List<Object> list, int index) {
		Object obj = get(list, index);
		return (Map<String, Object>) obj;
	}

	@SuppressWarnings("unchecked")
	public static List<Object> gainJSONArray(List<Object> list, int index) {
		Object obj = get(list, index);
		return (List<Object>) obj;
	}

}
