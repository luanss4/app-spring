# Use a base image with OpenJDK 17 (Alpine version)
FROM openjdk:17-jdk-alpine

# Instale o Maven
RUN apk add --no-cache maven

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie os arquivos do projeto (pom.xml e código-fonte) para o contêiner
COPY pom.xml .
COPY src ./src

# Compile a aplicação usando o Maven
RUN mvn clean package

# Copie o arquivo JAR gerado para o diretório raiz do contêiner
COPY target/*.jar app.jar

# Defina o ponto de entrada para executar a aplicação Spring
CMD ["java", "-jar", "app.jar"]