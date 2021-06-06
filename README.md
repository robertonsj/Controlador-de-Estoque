# Controlador-de-Vendas
Aplicação desktop para registrar as vendas de uma empresa. 

##ESTRUTURA NO NETBEANS
A respectiva aplicação está estruturada basicamente em três camandas, representada principalmente pelos seguintes pacotes:
-> telas
-> modelos
-> dadostratados

Camada Tela
É onde estarão as telas de interação usuário-aplicação, onde poderá ser feito o imput ou ouput de dados do banco de dados.
Basicamente, é por onde o usuário irá interagir com a aplicação.

Camada Modelo
É onde estarão as classes cujos objetos instanciados representam as entidades de grande importância para as regras de negócio, com
seus atributos e métodos getters e setters. São eles: Cliente, Funcionário, Fornecedor, Produto, Venda, ItensVenda, e outros.

Camada DadosTratados
É onde estarão todos os métodos que farão a comunicação com o banco de dados. Cada entidade da camada anterior terá uma classe 'DadosTratados'.
Por exemplo, com um objeto do tipo 'Funcionario', podemos inserir, atualizar, excluir, buscar ou listar funcionários junto ao banco de dados. 
Cada uma dessas ações representa um método da classe 'FuncionarioDadosTratados'. 


##REGRAS DE NEGÓCIO
1 - Usuário seleciona os produtos que o cliente vai comprar;

2 - Venda registrada
	-> Id do cliente
	-> Data da venda;
	-> Total da Venda;
	-> Observações da venda;

3 - Retorna o id da venda efetuada;

4 - Cadastrar todos os itens do carrinho em tb_itensvenda vinculando à última venda;

5 - Finalizar Venda;


##TABELAS DO BANCO BD_VENDAS
tb_clientes 
tb_fornecedores
tb_funcionarios
tb_produto
tb_vendas
tb_itensvendas

