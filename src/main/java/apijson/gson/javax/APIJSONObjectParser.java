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
import apijson.RequestMethod;
import apijson.orm.Join;
import apijson.orm.Parser;
import apijson.orm.SQLConfig;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import java.util.List;


/**简化Parser，getObject和getArray(getArrayConfig)都能用
 * @author Lemon
 */
public class APIJSONObjectParser<T> extends apijson.framework.javax.APIJSONObjectParser<T, Map<String, Object>, List<Object>> {
	public static final String TAG = "APIJSONObjectParser";

	/**for single object
	 * @param session
	 * @param request
	 * @param parentPath
	 * @param arrayConfig
	 * @param isSubquery
	 * @param isTable
	 * @param isArrayMainTable
	 * @throws Exception
	 */
	public APIJSONObjectParser(HttpSession session, @NotNull Map<String, Object> request, String parentPath
			, SQLConfig<T, Map<String, Object>, List<Object>> arrayConfig
			, boolean isSubquery, boolean isTable, boolean isArrayMainTable) throws Exception {
		super(session, request, parentPath, arrayConfig, isSubquery, isTable, isArrayMainTable);
	}

	@Override
	public APIJSONObjectParser<T> setMethod(RequestMethod method) {
		super.setMethod(method);
		return this;
	}

	@Override
	public APIJSONObjectParser<T> setParser(Parser<T, Map<String, Object>, List<Object>> parser) {
		super.setParser(parser);
		return this;
	}


	@Override
	public SQLConfig<T, Map<String, Object>, List<Object>> newSQLConfig(RequestMethod method, String table, String alias
			, Map<String, Object> request, List<Join<T, Map<String, Object>, List<Object>>> joinList, boolean isProcedure) throws Exception {
		return APIJSONSQLConfig.newSQLConfig(method, table, alias, request, joinList, isProcedure);
	}

}
