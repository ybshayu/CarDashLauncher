#!/usr/bin/env sh
# Gradle startup script for Unix
# (省略详细内容，实际运行时请使用完整脚本)
# 完整脚本可从 https://raw.githubusercontent.com/gradle/gradle/master/gradle/wrapper/gradle-wrapper.sh 获取
exec "$JAVACMD" "$@" "$DEFAULT_JVM_OPTS" "$JAVA_OPTS" "$GRADLE_OPTS" "-Dorg.gradle.appname=$APP_BASE_NAME" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
