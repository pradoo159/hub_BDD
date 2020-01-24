Feature: Procurar produto por texto
Como um usuário
Eu quero procurar um produto pela barra de pesquisa
 
 Background: 
	Given Usuario esteja na página inicial
	When Clicar no botão pesquisar
 
@SearchTest @Valido
Scenario: Busca por texto de um produto válido
	And Escrever o nome de um laptop 
	And Clicar no laptop escolhido
	Then A página do laptop escolhido será exibida 
	
@SearchTest @Invalido
Scenario: Busca por texto de um produto inválido 
	And Escrever o nome de um produto inválido ou inexistente
	Then Uma mensagem de erro será exibida