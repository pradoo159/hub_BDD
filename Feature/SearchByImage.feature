Feature: Consultar produto pela tela principal
 
@SearchByImageTest @Valid
Scenario: Pesquisa em categoria válida
	Given Usuario esteja na página inicial 
	When Clicar na categoria desejada
	And Clicar no tablet escolhido
	Then A pagina do tablet escolhido será exibida
	
@SearchByImageTest @Invalid
Scenario: Pesquisando produto errado pela imagem na tela principal
	Given Usuario esteja na página inicial 
	When Usuario clicar para ver detalhes do laptop
	Then Será exibida a página de outro laptop