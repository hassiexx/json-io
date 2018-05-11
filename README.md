JSON I/O [![CircleCI](https://circleci.com/gh/hassieswift621/json-io.svg?style=svg)](https://circleci.com/gh/hassieswift621/json-io)  [ ![Download](https://api.bintray.com/packages/hassieswift621/maven/json-io/images/download.svg) ](https://bintray.com/hassieswift621/maven/json-io/_latestVersion) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/b77d753820154f4487659ab990e5926f)](https://www.codacy.com/app/hassieswift621/json-io?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=hassieswift621/json-io&amp;utm_campaign=Badge_Grade)
========

JSON I/O is a Java library providing common JSON I/O utilities to preserve UTF-8 encoding.

It includes utilities such as converting input streams to UTF-8 JSON objects, converting a JSON file to a UTF-8 JSON
object and outputting a JSON object to a UTF-8 file.

Running the Java app in UTF-8 mode
-----------------------------
To fully support UTF-8, you need to run your Java app in UTF-8 mode.
Simply supply the following command line parameter:```-Dfile.encoding=UTF8```

Dependencies
------------
The library is available on JCenter. The current version is 1.0.0

**Gradle Setup**
```gradle
implementation 'uk.co.hassieswift621.libraries:json-io:1.0.0
```

**Maven Setup**
```maven
<dependency>
  <groupId>uk.co.hassieswift621.libraries</groupId>
  <artifactId>json-io</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

Tutorial
--------
**Converting an input stream to UTF-8 JSON**
```java
try {
  JSONObject json = JsonIO.toJSON(inputStream);
} catch (IOException e) {}
```

**Converting a file to UTF-8 JSON**
```java
try {
  JSONObject json = JsonIO.toJSON(new File("sample_json.json"));
} catch (IOException e) {}
```

**Converting a string to UTF-8 JSON**
```java
try {
  JSONObject json = JsonIO.toJSON("{"text": "Some text"}");
} catch (IOException e) {}
```

**Converting JSON to file**
```java
JSONObject json = some JSON;
try {
  JsonIO.toFile(json, new File("output.json"));
} catch (IOException e) {}
```

**Converting JSON to file (append to a file)**
```java
JSONObject json = some JSON;
try {
  JsonIO.toFile(json, new File("output.json"), true);
}
catch (IOException e) {}
```

**Converting JSON to a UTF-8 string**
```java
JSONObject json = some JSON;
try {
  String jsonString = JsonIO.toString(json);
} catch (IOException e) {}
```

License
-------
Copyright &copy;2018 HassieSwift621.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
