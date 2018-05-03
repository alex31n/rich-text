# RichText
### Simple and fast way to create awesome TextView, EditText and View.
&nbsp;

Features:
* **Border**
* **Radius**
* **Background color**

&nbsp;
&nbsp;
## Installation

&nbsp;
#### Gradle 

```
dependencies {
        compile 'com.ornach.richtext:richtext:1.0'
}
```

&nbsp;
#### Maven

```
<dependency>
    <groupId>com.ornach.richtext</groupId>
    <artifactId>richtext</artifactId>
    <version>1.0</version>
    <type>pom</type>
</dependency>
```



&nbsp;
#### XML
Include namespace to the root View/Layout :
```
xmlns:app="http://schemas.android.com/apk/res-auto"
```



&nbsp;
&nbsp;
xml code with custom params

```

<com.ornach.richtext.RichText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center"
    android:padding="15dp"
    android:text="Simple Text"
    android:textStyle="bold"
    app:rt_borderColor="#0F7CB7"
    app:rt_borderWidth="1dp"
    app:rt_radius="10dp" />

<com.ornach.richtext.RichEditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="30dp"
    android:hint="username"
    android:padding="15dp"
    app:rt_backgroundColor="#00000000"
    app:rt_borderColor="#0F7CB7"
    app:rt_borderWidth="1dp"
    app:rt_radius="10dp" />
  
```

&nbsp;
&nbsp;
## License
    Copyright 2018 Alex Beshine
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and limitations under the License.
    
