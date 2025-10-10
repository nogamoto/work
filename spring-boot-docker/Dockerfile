# ベースイメージとして OpenJDK 17 を使用
  FROM maven:4.0.0-rc-4-eclipse-temurin-17-noble
  # 作業ディレクトリを設定
  WORKDIR /app
  # 依存関係を事前にダウンロード（ビルド時間短縮のため）
  COPY pom.xml .
  RUN mvn dependency:go-offline -B
  # プロジェクトのソースコードをコピー
  COPY . .
  # JAR ファイルを作成（テストはスキップ）
  RUN mvn clean package -DskipTests
  # ホットリロードを有効にする環境変数を設定
  ENV JAVA_OPTS="-Dspring.devtools.restart.enabled=true -Dspring.devtools.livereload.enabled=true"
  # DB起動まで待機用script
  COPY wait-for-it.sh /usr/local/bin/wait-for-it.sh
  RUN chmod +x /usr/local/bin/wait-for-it.sh
  # アプリケーションの起動
  CMD ["wait-for-it.sh", "db:3306", "--timeout=60", "--","java", "-jar", "target/spring-boot-docker-0.0.1-SNAPSHOT.jar", "--spring.devtools.restart.enabled=true"]