Flip (Preferences Tables)
=============

(╯°□°）╯︵ ┻━┻

Because pretty-printing preferences tables in Java should be easy.

Using [JakeWharton / flip-tables](https://github.com/JakeWharton/flip-tables).

Usage
-----

```java
String data = PreferencesTables.makeTable(prefs).all().toString();
Log.d("prefs", data);
```
```
╔═══════════╤══════════╗
║ key       │ value    ║
╠═══════════╪══════════╣
║ Ping      │ Pong     ║
╟───────────┼──────────╢
║ Foo       │ Bar      ║
╟───────────┼──────────╢
║ Kit       │ Kat      ║
╚═══════════╧══════════╝
```

```java
String data = PreferencesTables.makeTable(prefs).in("Foo").toString();
Log.d("prefs", data);
```
```
╔═══════════╤══════════╗
║ key       │ value    ║
╠═══════════╪══════════╣
║ Foo       │ Bar      ║
╚═══════════╧══════════╝
```

```java
String data = PreferencesTables.makeTable(prefs).notIn("Foo").toString();
Log.d("prefs", data);
```
```
╔═══════════╤══════════╗
║ key       │ value    ║
╠═══════════╪══════════╣
║ Ping      │ Pong     ║
╟───────────┼──────────╢
║ Kit       │ Kat      ║
╚═══════════╧══════════╝
```

Screenshow
-------

<img src="https://raw.github.com/rejasupotaro/preferences-tables/master/screenshot.png" width="240">

License
-------

    Copyright 2014 rejasupotaro

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
