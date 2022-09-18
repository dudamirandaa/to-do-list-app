# To-do list app - REST API

Este projeto foi desenvolvido durante o curso de **Spring Boot API REST** da Alura. A aplicação cria uma tabela no banco de dados referente a uma lista de tarefas.

A aplicação foi feita utilizando conceitos de JpaRepository, Data Transfer Object, Injeção de dependência, JpaSpecificationExecutor, ResponseEntity, Liquibase, testes unitários com JUnit, entre outros.

Você pode utilizar o postman para realizar as seguintes ações:

- Listar todas as tarefas
- Filtrar tarefas por nome, prioridade ou data
- Inserir nova tarefa
- Alterar nome, prioridade ou data de uma tarefa
- Deletar uma tarefa

A aplicação retorna um erro 404 caso ocorra tentativa de alterar ou deletar um item inexistente.

Os testes unitários validam as seguintes características:

- Get:
  - Listagem de todas as tarefas;
  - Listagem de todas as tarefas com filtros por nome, prioridade, data ou conbinações entre os três;
  - Listagem de todas as tarefas caso a prioridade seja setada para "ALL".
- Post:
  - Inclusão de nova tarefa;
  - Não inclusão de nova tarefa caso fornecida prioridade ou data inválida;
  - Não inclusão de nova tarefa caso não fornecidos nome, prioridade ou data.
- Put:
  - Edição de uma tarefa;
  - Retorno de erro 404 em caso de tentativa de editar tarefa não existente;
  - Não editar tarefa caso não sejam fornecidos nome, prioridade ou data.
- Delete:
  - Deleção de tarefa;
  - Retorno de erro 404 em caso de tentativa de deletar tarefa não existente.

---

### Imagens

Tests passsed:

![Tests](images/tests-passed.png)

Listagem de tarefas:

![List](images/list.png)

Listagem de tarefas com filtro por prioridade:

![List by priority](images/filtered-list.png)

Inserção de nova tarefa:

![Insert](images/insert.png)

Alteração da prioridade de uma tarefa:

![Edit](images/edit.png)

Deleção de uma tarefa:

![Delete](images/delete.png)

Erro 404 ao tentar deletar uma tarefa não existente:

![Error 404](images/error-404.png)
