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

import apijson.JSONResponse;
import apijson.RequestMethod;
import apijson.orm.SQLConfig;
import java.util.List;
import java.util.Map;
import jakarta.servlet.http.HttpSession;

/**请求解析器
 * @author Lemon
 */
public class APIJSONParser<T> extends apijson.framework.APIJSONParser<T, Map<String, Object>, List<Object>> {
	public static final String TAG = "APIJSONParser";
	
	public APIJSONParser() {
		super();
	}
	public APIJSONParser(RequestMethod method) {
		super(method);
	}
	public APIJSONParser(RequestMethod method, boolean needVerify) {
		super(method, needVerify);
	}

	public APIJSONParser<T> setSession(HttpSession session) {
		super.setSession(session);
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public apijson.framework.APIJSONParser<T, Map<String, Object>, List<Object>> createParser() {
		return APIJSONApplication.createParser();
	}
	@Override
	public apijson.framework.APIJSONFunctionParser<T, Map<String, Object>, List<Object>> createFunctionParser() {
		return APIJSONApplication.createFunctionParser();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public apijson.framework.APIJSONVerifier<T, Map<String, Object>, List<Object>> createVerifier() {
		return APIJSONApplication.createVerifier();
	}
	
	@Override
	public apijson.framework.APIJSONSQLConfig<T, Map<String, Object>, List<Object>> createSQLConfig() {
		return APIJSONApplication.createSQLConfig();
	}
	@Override
	public apijson.framework.APIJSONSQLExecutor<T, Map<String, Object>, List<Object>> createSQLExecutor() {
		return APIJSONApplication.createSQLExecutor();
	}

	@Override
	public APIJSONParser<T> setNeedVerify(boolean needVerify) {
		super.setNeedVerify(needVerify);
		return this;
	}

	@Override
	public APIJSONParser<T> setNeedVerifyLogin(boolean needVerifyLogin) {
		super.setNeedVerifyLogin(needVerifyLogin);
		return this;
	}

	@Override
	public APIJSONParser<T> setNeedVerifyRole(boolean needVerifyRole) {
		super.setNeedVerifyRole(needVerifyRole);
		return this;
	}

	@Override
	public APIJSONParser<T> setNeedVerifyContent(boolean needVerifyContent) {
		super.setNeedVerifyContent(needVerifyContent);
		return this;
	}

	public APIJSONFunctionParser<T> getFunctionParser() {
		return (APIJSONFunctionParser<T>) super.getFunctionParser();
	}

	@Override
	public APIJSONObjectParser<T> createObjectParser(Map<String, Object> request, String parentPath
			, SQLConfig<T, Map<String, Object>, List<Object>> arrayConfig
			, boolean isSubquery, boolean isTable, boolean isArrayMainTable) throws Exception {
		return (APIJSONObjectParser<T>) super.createObjectParser(
				request, parentPath, arrayConfig, isSubquery, isTable, isArrayMainTable
		);
	}

	public static Map<String, Object> parseRequest(String request) {
		try {
			return JSON.parseObject(request);
		} catch (Exception e) {
			return (Map<String, Object>) APIJSONApplication.createParser().newResult(
					JSONResponse.CODE_ILLEGAL_ARGUMENT, "JSON 格式不合法！" + e.getMessage() + "! " + request
			);
		}
	}

}
