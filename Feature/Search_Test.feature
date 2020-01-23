Feature: Procurar produto por texto
 
@SearchTest @Valid
Scenario: Busca por texto de um produto válido
	Given Usuario esteja na página inicial 
	When Clicar no botão pesquisar
	And Escrever o nome de um laptop 
	And Clicar no laptop escolhido
	Then A página do laptop escolhido será exibida 
	
@SearchTest @Invalid
Scenario: Fail Search with Invalid Product 
	Given Usuario esteja na página inicial 
	When Clicar no botão pesquisar
	And Escrever o nome de um produto inválido ou inexistente
	Then Uma mensagem de erro será exibida