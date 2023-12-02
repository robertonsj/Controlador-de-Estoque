# Controlador-de-Vendas
Aplicação desktop para gerenciar as vendas de uma empresa e todos os objetos que a envolvem. 

## Estrutura no Netbeans
A respectiva aplicação está estruturada basicamente em três camandas, representada principalmente pelos seguintes pacotes:
- telas: guarda as interfaces de usuário para a entrada de dados;
- modelos: guarda as classes: Cliente, Funcionario, Fornecedor, Produto, Venda, ItensVenda, e outros.
- dadostratados: onde encontra-se as classes que possuem métodos para acesso ao banco de dados. 
Por exemplo, com um objeto do tipo 'Funcionario', podemos inserir, atualizar, excluir, buscar ou listar funcionários junto ao banco de dados. Cada uma dessas ações representa um método da classe 'FuncionarioDadosTratados'. 


## Regras de Negócio
- 1 Os produtos estarão dispostos para serem selecionados;
- 2 Venda registrada
	- Id do cliente
	- Data da venda;
	- Total da Venda;
	- Observações da venda;

- 3 Retorna o id da venda efetuada;

- 4 Cadastrar todos os itens do carrinho em tb_itensvenda vinculando à última venda;

- 5 Finalizar Venda;


## Tabelas do Banco de Dados 'BD_VENDAS'
- tb_clientes 
- tb_fornecedores
- tb_funcionarios
- tb_produto
- tb_vendas
- tb_itensvendas

