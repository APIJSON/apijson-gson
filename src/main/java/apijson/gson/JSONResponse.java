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

import java.util.*;

import java.util.List;
import java.util.Map;

/**parser for response
 * @author Lemon
 * @see #getObject
 * @see #getList
 * @use JSONResponse response = new JSONResponse(json);
 * <br> User user = response.getObject(User.class);//not a must
 * <br> List<Comment> commenntList = response.getList("Comment[]", Comment.class);//not a must
 */
public class JSONResponse extends LinkedHashMap<String, Object> implements apijson.JSONResponse<Map<String, Object>, List<Object>> {
	private static final long serialVersionUID = 1L;

	public JSONResponse() {
		super();
	}
	public JSONResponse(Object json) {
		this(JSON.parseObject(json));
	}
	public JSONResponse(Map<String, Object> object) {
		super(format(object));
	}


	/**获取内部的JSONResponse
	 * @param key
	 * @return
	 */
	public JSONResponse getJSONResponse(String key) {
		return getObject(key, JSONResponse.class);
	}
	//cannot get javaBeanDeserializer
	//	/**获取内部的JSONResponse
	//	 * @param response
	//	 * @param key
	//	 * @return
	//	 */
	//	public static JSONResponse getJSONResponse(JSONRequest response, String key) {
	//		return response == null ? null : response.getObject(key, JSONResponse.class);
	//	}
	//状态信息，非GET请求获得的信息>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public static boolean isSuccess(Map<String, Object> response) {
		return apijson.JSONResponse.isSuccess(response);
	}

	public static boolean isExist(Map<String, Object> response) {
		return apijson.JSONResponse.isExist(response);
	}

	/**
	 * key = clazz.getSimpleName()
	 * @param clazz
	 * @return
	 */
	public <T> T getObject(Class<T> clazz) {
		return getObject(clazz == null ? "" : clazz.getSimpleName(), clazz);
	}
	/**
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T> T getObject(String key, Class<T> clazz) {
		return getObject(this, key, clazz);
	}
	/**
	 * @param object
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T> T getObject(Map<String, Object> object, String key, Class<T> clazz) {
		return toObject(object == null ? null : apijson.JSON.get(object, apijson.JSONResponse.formatObjectKey(key)), clazz);
	}

	/**
	 * @param clazz
	 * @return
	 */
	public <T> T toObject(Class<T> clazz) {
		return toObject(this, clazz);
	}

	/**
	 * @param object
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(Map<String, Object> object, Class<T> clazz) {
		return JSON.parseObject(object, clazz);
	}


	/**
	 * key = KEY_ARRAY
	 * @param clazz
	 * @return
	 */
	public <T> List<T> getList(Class<T> clazz) {
		return getList(KEY_ARRAY, clazz);
	}
	/**
	 * arrayObject = this
	 * @param key
	 * @param clazz
	 * @return
	 */
	public <T> List<T> getList(String key, Class<T> clazz) {
		return getList(this, key, clazz);
	}

	/**
	 * key = KEY_ARRAY
	 * @param object
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> getList(Map<String, Object> object, Class<T> clazz) {
		return getList(object, KEY_ARRAY, clazz);
	}
	/**
	 * @param object
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> getList(Map<String, Object> object, String key, Class<T> clazz) {
		return object == null ? null : apijson.JSON.parseArray(apijson.JSON.getString(object, apijson.JSONResponse.formatArrayKey(key)), clazz);
	}

	/**
	 * key = KEY_ARRAY
	 * @return
	 */
	public List<Object> getArray() {
		return getArray(KEY_ARRAY);
	}
	/**
	 * @param key
	 * @return
	 */
	public List<Object> getArray(String key) {
		return getArray(this, key);
	}
	/**
	 * @param object
	 * @return
	 */
	public static List<Object> getArray(Map<String, Object> object) {
		return getArray(object, KEY_ARRAY);
	}
	/**
	 * key = KEY_ARRAY
	 * @param object
	 * @param key
	 * @return
	 */
	public static List<Object> getArray(Map<String, Object> object, String key) {
		return apijson.JSONResponse.getArray(object, key);
	}


	/**格式化key名称
	 * @param object
	 * @return
	 */
	public static Map<String, Object> format(Map<String, Object> object) {
		return apijson.JSONResponse.format(object);
	}

	/**格式化key名称
	 * @param array
	 * @return
	 */
	public static List<Object> format(List<Object> array) {
		return apijson.JSONResponse.format(array);
	}

	public LinkedHashMap<String, Object> toJSONObject() {
		return toObject(LinkedHashMap.class);
	}

}
