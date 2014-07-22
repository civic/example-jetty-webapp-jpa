glassfishで動作する軽いwebapp実装のサンプル
=======================================


glassfishで動作する軽いwebapp実装。

- servlet <http://localhost:8080/example-jetty-webapp-jpa/sample>
- JAX-RS <http://localhost:8080/example-jetty-webapp-jpa/webresources/sample-jaxrs>
- JPA <http://localhost:8080/example-jetty-webapp-jpa/jpa-servlet>
- websocket <http://localhost:8080/example-jetty-webapp-jpa/>


glassfishのWebProfileで動作させる場合は、Glassfishサーバー側にjdbc接続プールとjndiリソースを作成し、それを参照するようにする。

glassfishにそれらの設定を行うためのソースが、setup/glassfish-resources.xmlにある。

JDBCドライバのみは手動で配置しなければならない。domain/lib/extにh2のJDBCドライバを配置する。

glassfishで作成すると、domain/configにh2データベースが作成される。

