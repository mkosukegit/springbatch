# springbatch
```
// ビルド(./build/libs/配下にjarが作られる)
gradle build

// 実行
// java -Dspring.batch.job.names=[job名] -jar [jar実行ファイル] param1=[パラメータ]
java -Dspring.batch.job.names=helloJob -jar build/libs/batchsample-0.0.1-SNAPSHOT.jar
```
