# api-entregas
Mergulho Spring Rest - AlgaWorks

O curso foi realizado durante uma semana com vídeos que foram disponibilizados através da plataforma YouTube, no canal AlgaWorks. 
Com o objetivo de desenvolver uma API utilizando o framework Spring Boot. A proposta da API é realizar o back end de uma aplicação de entrega, com cliente, destinatário e ocorrência.   

  ![image](https://github.com/ebpacheco/api-entregas/assets/113384855/1e5cc58c-222e-478d-8b40-a7dfb3a5c19a)
  
Conteúdo disponibilizados no treinamento:  
Foi comentado sobre conceito de JSON(chave valor) e verbos do HTTP (get, put, post e delete).  

Dicas de boas práticas como utilizar URI (deve se referir a um substantivo e não a um verbo/ação, utilizar a URI sempre no plural) e boas práticas para trabalhar com data/hora.  

Criamos o projeto com ecossistema Spring, aplicamos a dependência Lombok e usando suas anotações, utilizamos o postman para verificar as chamadas, e a ferramenta flyway pra gerenciar os schemas do banco de dados.  

Adicionamos content negotiation para XML na dependência do projeto, a dependência devtool para otimizar o desenvolvimento, e a dependência spring data jpa e mysql driver  

Adicionamos a pasta db/migration na estrutura do projeto e criamos as transacoes DDL atraves do flyway. Utilizamos o Jakarta Persistence com a implementação hibernate, e Spring Data JPA. 
