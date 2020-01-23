Feature: Cadastrar Usuario

@Cadastro @Valido 
Scenario: Cadastro com dados válidos 
	Given Usuario esteja na página inicial 
	When Usuario navegar até a página de cadastro 
	And Preencher os campos com dados válidos 
	Then Será redirecionado para a página inicial com a conta logada 
	
@Cadastro @Invalido 
Scenario: Cadastro com dados inválidos 
	Given Usuario esteja na página inicial 
	When Usuario navegar até a página de cadastro 
	And Preencher os campos com dados inválidos 
	Then O usuário receberá um erro e continuará na mesma página