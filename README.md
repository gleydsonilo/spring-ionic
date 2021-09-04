# Implementação de Modelo Conceitual

O estudo de caso deste capítulo teve como objetivo mostrar na prática como um modelo conceitual (modelo de
domínio em nível de análise) pode ser implementado sobre o paradigma orientado a objetos, usando padrões de
mercado e boas práticas.

Tópicos abordados:

- Leitura e entendimento do diagrama de classes
- Leitura e entendimento do diagrama de objetos
- Associações
- Bidirecionais / direcionadas
- Conceito independente / dependente
- Classe de associação
- Herança
- Enumerações
- Atributos Embedded (ItemPedidoPK)
- Coleções ElementCollection (telefones de um cliente)

## Requisitos

- Maven
- Spring
- Java 8
- Hibernate
- JPA

Baixar as dependências: na raiz do projeto: executar o comando `mvn clean install`.

Para rodar a aplicação localmente, executar o metodo `main` da classe [CursomcApplication.java](https://github.com/gleydsonilo/cursomc/blob/main/src/main/java/com/nelioalves/cursomc/CursomcApplication.java).

#Endpoint disponíveis

##Obter Clientes por ID
**GET:** `http://localhost:8080/client/{id}`

##Obter Pedidos por ID
**GET:** `http://localhost:8080/demands/{id}`

##Obter Categorias de Itens por ID
**GET:** `http://localhost:8080/categories/{id}`