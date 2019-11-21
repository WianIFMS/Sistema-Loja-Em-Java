## Sistema didático
Projeto para aprendizagem de Linguagem de Programação
## Instruções
1 - Criar banco de dados loja_db;

2 - Limpar e Construir;

## Script

1º - Criar pacote para a entidade
2º - Criar pacote datamodel dentro do pacote da entidade
3º - Criar pacote dao dentro do pacote da entidade
4º - Criar pacote bo dentro do pacote da entidade
5º - Criar pacote view dentro do pacote da entidade

Implementações:
6º - Criar uma classe para a entidade no pacote datamodel
7º - Criar uma classe dao que herde de GenericDAO dentro do pacote dao.
8º - Criar uma classe model que herde de GenericCRUDModel dentro do pacote bo.
9º - Criar um form do tipo JPanel dentro do pacote view
		*obs.: Criar getters e setters para os componentes do formulario
10º - Criar uma classe view que herde de GenericCRUDView dentro do pacote view.
11º - Criar uma classe controller que herde de GenericCRUDController dentro do pacote bo.
12º - Criar a ação de abrir a janela no menu JanelaInternaCadastro (app.view)