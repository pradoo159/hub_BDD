Feature: Consultar produto pela tela principal
Como um usuário
Eu quero procurar um produto pela categoria da tela principal

Background: 
	Given Usuario esteja na página inicial
 
@SearchByImageTest @Valido
Scenario: Pesquisa em categoria válida
	When Clicar na categoria desejada
	And Clicar no tablet escolhido
	Then A pagina do tablet escolhido será exibida
	
@SearchByImageTest @Invalido
Scenario: Pesquisando produto errado pela imagem na tela principal
	When Usuario clicar para ver detalhes do laptop
	Then Será exibida a página de outro laptop