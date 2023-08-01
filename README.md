# Projeto de Encurtamento de URLs

Este projeto é uma aplicação de encurtamento de URLs desenvolvida com Spring Boot e Kotlin, que utiliza Redis como banco de dados em memória para armazenar as URLs encurtadas.

## Tecnologias Utilizadas

- Spring Boot: Framework Java que facilita o desenvolvimento de aplicações web.
- Kotlin: Linguagem de programação moderna e concisa, que roda na JVM.
- Docker: Plataforma que permite criar, implantar e executar aplicações em containers.
- Docker Compose: Ferramenta para definir e executar aplicativos Docker compostos por vários containers.
- Gradle: Ferramenta de automação de compilação utilizada para construir o projeto e gerenciar dependências.
- Redis: Banco de dados em memória utilizado para armazenar as URLs encurtadas.

## Pré-requisitos

- Docker e Docker Compose instalados na máquina local.
- Java JDK e Kotlin configurados no ambiente de desenvolvimento.

## Como executar o projeto

1. Clone este repositório para a sua máquina local.

2. Abra o terminal na pasta raiz do projeto.

3. Execute o seguinte comando para criar o arquivo JAR da aplicação:

   ```bash
   ./gradlew build

## Uso da API
Você pode usar a API para encurtar URLs, acessando o endpoint POST /encurtar, enviando um JSON com a URL a ser encurtada:

Exemplo de requisição:

    {
        "url": "https://www.exemplo.com.br/pagina"
    }

A resposta conterá o hash da URL encurtada:

    {
        "hash": "abcd123"
    }



    