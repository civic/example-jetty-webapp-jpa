jetty-guice-jpa webapp
=======================================

jettyで動作し、JPAとJAX-RS2.0を使うwebapp実装の模索。

jettyからJAX-RS2.0, JPAを使い、できるかぎり標準APIでWebAppを作る方法を検討。
DIはCDI(Weld)ではなくGuiceを使う方法で検討。

JAX-RSは、jersey2を使用。 JPAはEclipse Toplinkを使用。データベースにH2を埋め込みで使用。


- JAX-RS <http://localhost:8080/rest/sample-jaxrs>, <http://localhost:8080/rest/sample-jaxrs/cust>
- WebSocket <http://localhost:8080/>

## 構成

JAX-RSをGuice化で使用するためにJavaEEの@ApplicationPathを使ったJAX-RSの起動方法ではなく、
`org.glassfish.jersey.servlet.ServletContainer`のServletを経由したリソースクラスの実行を設定している。

- Guiceで定義したFilterを通過させるために、すべてGuice経由で実行したいため
- guice-jerseyのモジュールは、jersey1.8系だったため動作が違った
- ServletContainerに @Singletonアノテーションをつけるため継承しただけのServletを作成し、それをGuiceServletのservceメソッドで登録した。  
この時のURLパターンが、@ApplicationPathに相当する


## JPAのEntityManagerの取得

- Servlet FilterでEntityManagerを生成
    - transactionの開始
    - requestオブジェクトに設定
- JAX-RSでリクエスト属性からGuiceのInjector取得
- InjectorからEntityManagerを取得 
    - Providerはrequest属性からEntityManagerを取得
- Filterでtransactionをコミット

## 課題

- WebSocket のServerEndpointからInjectorを取得できないか？
    - Configuratorで設定すればできそうだが、ServletContextにアクセスできない

