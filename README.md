glassfish WebProfileで動作するライトなwebapp実装の模索
=======================================


glassfishで動作する軽いwebapp実装。

EJBは使用せず、JAX-RS2.0, CDI, JPAを使用。
lassfishサーバー側にjdbc接続プールとjndiリソースを作成し、それを参照するようにする。

glassfishにそれらの設定を行うためのソースが、setup/glassfish-resources.xmlにある。
JDBCドライバは手動で配置しなければならない？domain/lib/extにh2のJDBCドライバを配置する。
glassfishで作成すると、domain/configにh2データベースが作成される。

## Servlet 3.0 Serlvet

アノテーションを使ったサーブレット

<http://localhost:8080/example-jetty-webapp-jpa/sample>

## JPA+CDIを使用したサーブレット

<http://localhost:8080/example-jetty-webapp-jpa/jpa-servlet>


## JAX-RS + CDI + JPA

基本的なWebApp実装を想定

 <http://localhost:8080/example-jetty-webapp-jpa/rest/customers>

以下のREST APIを実装

- customers (GET)で全customer取得
- customers/{id}    (GET)で指定idのcustomer取得
- customers (POST)でcustomer作成 x-www-form-urlencodedでname=顧客名で名前指定
- customers (DELETE)でcustomer全件削除

## WebSocket + CDI + JPA

 <http://localhost:8080/example-jetty-webapp-jpa/>



