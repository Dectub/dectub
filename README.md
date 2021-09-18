# Java CI 脚手架

## 安装所有前端依赖
```shell script
./gradlew npm_install
```

## 运行文档项目
```shell script
./gradlew :documents:npm_start
```

## 提交前代码检查
```shell script
./gradlew clean check
```

## 运行主项目
```shell script
./gradlew bootRun
```

## 运行前端项目
```shell script
./gradlew :scaffold.webui:npm_start
```

## 监听前端测试
```shell script
./gradlew :scaffold.webui:npmWatchTest
```

## 构建docker镜像并推送至镜像仓库
```shell script
./gradlew clean npm_install build push
```
