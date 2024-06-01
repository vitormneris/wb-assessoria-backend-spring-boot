FROM gradle:8.7-jdk21-alpine AS build

WORKDIR /home/gradle/src

# Copiar o arquivo build.gradle e settings.gradle para a imagem
COPY build.gradle .
COPY settings.gradle .

# Copiar o código-fonte
COPY src/ src/

# Realizar o build do Gradle
RUN gradle build --no-daemon

EXPOSE 8080

# Copiar o arquivo JAR gerado durante o build com Gradle
COPY --from=build /out/artifacts/wb_jar/wb.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
