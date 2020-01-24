Feature: Cadastrar Usuario
Como um usuário
Eu quero realizar um cadastro

Background:
	Given Usuario esteja na página inicial 
	When Usuario navegar até a página de cadastro 

@Cadastro @Valido 
Scenario: Cadastro com dados válidos 
	And Preencher os campos com dados válidos 
	Then Será redirecionado para a página inicial com a conta logada 
	
@Cadastro @Invalido 
Scenario: Cadastro com dados inválidos 
	And Preencher os campos com dados inválidos 
	Then O usuário receberá um erro e continuará na mesma página