# 🪙 CotaCoin - Conversor de Moedas

O **CotaCoin** é uma aplicação Java de linha de comando (CLI) que realiza a conversão de moedas em tempo real, consumindo dados atualizados da [ExchangeRate-API](https://www.exchangerate-api.com/).

## Funcionalidades

O sistema permite a conversão bidirecional entre as seguintes moedas:
* **USD** - Dólar Americano
* **BRL** - Real Brasileiro
* **ARS** - Peso Argentino
* **COP** - Peso Colombiano

## Tecnologias Utilizadas

* **Java (JDK 17+)**: Utiliza recursos modernos como `Records`, `Text Blocks` e `HttpClient`.
* **Gson**: Biblioteca do Google para desserialização do JSON retornado pela API.
* **ExchangeRate-API**: Fonte dos dados de cotação.

## Configuração
1. Baixe o .jar do Gson [aqui](https://mvnrepository.com/artifact/com.google.gson/gson) e adicione ao classpath do projeto.
2. Obtenha uma chave gratuita em [ExchangeRate-API](https://www.exchangerate-api.com/).
3. Substitua a chave na URL dentro do método `consultarValor`:

```java
var url = "https://v6.exchangerate-api.com/v6/SUA_NOVA_CHAVE/latest/" + moedaBase;