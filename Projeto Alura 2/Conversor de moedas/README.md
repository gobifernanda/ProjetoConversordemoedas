💱 Conversor de Moedas

Projeto de backend do One Oracle Next Education, que visa o aprendizado de: Java, Orientação a objeto,Consumo de API, entre outras habilidades. 
Um simples e eficiente conversor de moedas desenvolvido para facilitar a conversão entre diferentes moedas em tempo real, utilizando taxas atualizadas via API de Câmbio em tempo real.

🚀 Funcionalidades

- Interface simples e intuitiva.
- Conversão em tempo real usando a ExchangeRateAPI


🛠️ Tecnologias Utilizadas

- Java 17
- Swing (GUI)
- Maven
- Gson para manipulação de JSON
- java-dotenv para variáveis de ambiente

📦 Como executar

1. Clone o repositório

git clone https://github.com/seu-usuario/conversor-de-moedas.git
cd conversor-de-moedas

2. Crie um arquivo .env na raiz do projeto

EXCHANGE_API_KEY="sua-chave-da-api-aqui"

Você pode obter uma chave gratuita em exchangerate-api.com

3. Compile o projeto com Maven

mvn clean package

4. Execute o .jar

java -jar target/conversor-de-moedas-1.0.0-jar-with-dependencies.jar

🛡️ Segurança

O arquivo .env está no .gitignore e não será enviado ao GitHub

Para sua segurança! Nunca compartilhe sua chave da API publicamente.

📁 Estrutura do projeto

├── src/
│   └── main/
│       └── java/
│           └── com/gobifernanda/conversor/
│               ├── ConversorGUI.java
│               ├── ConversorService.java
│               └── ExchangeApiClient.java
├── .env.example
├── pom.xml
└── README.md

🙋‍♀️ Autora

Fernanda Gobi - @gobifernanda
LinkedIn • GitHub

🙋‍♀️ Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

