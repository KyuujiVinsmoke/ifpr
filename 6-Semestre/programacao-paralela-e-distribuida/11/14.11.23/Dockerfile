# Usa a imagem base do OpenJDK 11 para construir a imagem Docker.
FROM openjdk:11

# Copia todos os arquivos do contexto de construção para o diretório /usr/src/app na imagem.
COPY . /usr/src/app

# Define /usr/src/app como o diretório de trabalho atual para as instruções seguintes.
WORKDIR /usr/src/app

# Compila o arquivo Main.java na imagem usando o compilador Java (javac).
RUN javac Main.java

# Define o comando que será executado ao iniciar um contêiner baseado nesta imagem.
# Neste caso, executa a aplicação Java usando o comando "java Main".
CMD ["java", "Corrida"]