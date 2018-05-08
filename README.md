JSON I/O
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