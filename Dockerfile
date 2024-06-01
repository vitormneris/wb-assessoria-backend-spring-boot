# Etapa de construção
FROM gradle:8.7-jdk21-alpine AS build

WORKDIR /home/gradle/src

# Copiar o arquivo build.gradle e settings.gradle para a imagem
COPY build.gradle .
COPY settings.gradle .

# Copiar o código-fonte
COPY src/ src/

# Realizar o build do Gradle
RUN gradle build --no-daemon

# Etapa de produção
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copiar o arquivo JAR gerado durante o build
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Definir o comando de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]