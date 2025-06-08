# apijson-gson  [![](https://jitpack.io/v/APIJSON/apijson-gson.svg)](https://jitpack.io/#APIJSON/apijson-gson)
腾讯 [APIJSON](https://github.com/Tencent/APIJSON) 8.0.0+ 的 gson 插件，简化使用。<br />
A gson plugin for Tencent [APIJSON](https://github.com/Tencent/APIJSON) 8.0.0+.<br />


## 添加依赖
## Add Dependency

### Maven
#### 1. 在 pom.xml 中添加 JitPack 仓库
#### 1. Add the JitPack repository to pom.xml
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

![image](https://user-images.githubusercontent.com/5738175/167263399-339dad4f-2884-461e-9781-f2de6d100340.png)

<br />

#### 2. 在 pom.xml 中添加 apijson-gson 依赖
#### 2. Add the apijson-gson dependency to pom.xml
```xml
	<dependency>
	    <groupId>com.github.APIJSON</groupId>
	    <artifactId>apijson-gson</artifactId>
	    <version>LATEST</version>
	</dependency>
```


<br />
<br />

### Gradle
#### 1. 在项目根目录 build.gradle 中最后添加 JitPack 仓库
#### 1. Add the JitPack repository in your root build.gradle at the end of repositories
```gradle
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```
<br />

#### 2. 在项目某个 module 目录(例如 `app`) build.gradle 中添加 apijson-gson 依赖
#### 2. Add the apijson-gson dependency in one of your modules(such as `app`)
```gradle
	dependencies {
	        implementation 'com.github.APIJSON:apijson-gson:latest'
	}
```

<br />
<br />

## 初始化
## Initialization

#### 1.把所有 apijson.framework 中的解析类都替换成 apijson.gson 的
#### 1.Replace all apijson.framework classes to that of apijson.gson what have same names

```java
import apijson.gson.APIJSONApplication; // apijson.framework.APIJSONApplication;

public class DemoApplication {
    public static void main(String[] args) {
        // ...
        APIJSONApplication.init();
        // ...
    }
}
```

```java
import apijson.gson.APIJSONController; // apijson.framework.APIJSONController;

public class DemoController extends APIJSONController<Long> { // apijson.framework.APIJSONController<Long, Map<String, Object>, List<Object>>
}
```

```java
import apijson.gson.APIJSONParser; // apijson.framework.APIJSONParser;

public class DemoParser extends APIJSONParser<Long> { // apijson.framework.APIJSONParser<Long, Map<String, Object>, List<Object>>
}
```

```java
import apijson.gson.APIJSONObjectParser; // apijson.framework.APIJSONObjectParser;

public class DemoParser extends APIJSONObjectParser<Long> { // apijson.framework.APIJSONObjectParser<Long, Map<String, Object>, List<Object>>
}
```

```java
import apijson.gson.APIJSONFunctionParser; // apijson.framework.APIJSONFunctionParser;

public class DemoParser extends APIJSONFunctionParser<Long> { // apijson.framework.APIJSONFunctionParser<Long, Map<String, Object>, List<Object>>
}
```

```java
import apijson.gson.APIJSONVerifier; // apijson.framework.APIJSONVerifier;

public class DemoParser extends APIJSONVerifier<Long> { // apijson.framework.APIJSONVerifier<Long, Map<String, Object>, List<Object>>
}
```

```java
import apijson.gson.APIJSONSQLConfig; // apijson.framework.APIJSONSQLConfig;

public class DemoSQLConfig extends APIJSONSQLConfig<Long> { // apijson.framework.APIJSONSQLConfig<Long, Map<String, Object>, List<Object>>
}
```

```java
import apijson.gson.APIJSONSQLExecutor; // apijson.framework.APIJSONSQLExecutor;

public class DemoSQLExecutor extends APIJSONSQLExecutor<Long> { // apijson.framework.APIJSONSQLExecutor<Long, Map<String, Object>, List<Object>>
}
```

...

<br />


参考 [APIJSONController](/apijson/gson/APIJSONController.java) 的注释及 [APIJSONBoot](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot) 的 [DemoController](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoController.java) 和 [DemoApplication](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoApplication.java) <br />

See document in [APIJSONController](/apijson/gson/APIJSONController.java) and [DemoController](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoController.java), [DemoApplication](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot/src/main/java/apijson/boot/DemoApplication.java)  in [APIJSONBoot](https://github.com/APIJSON/APIJSON-Demo/blob/master/APIJSON-Java-Server/APIJSONBoot)

<br />

<br />
有问题可以去 Tencent/APIJSON 提 issue <br />
https://github.com/Tencent/APIJSON/issues/36

<br /><br />

#### 点右上角 ⭐Star 支持一下，谢谢 ^_^
#### Please ⭐Star this project ^_^
https://github.com/APIJSON/apijson-gson
