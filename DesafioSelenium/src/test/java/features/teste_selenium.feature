# language: pt
  # encoding: utf-8

  Funcionalidade: Acessar o site da SampleApp e realizar o cadastro
  
  	Cenário: Realizar cadastro no site
			Dado que estou no site da sampleapp
			E preencho o formulário Vehicle Data e pressione next
			E preencho o formulário Insurant Data e pressione next
			E preencho o formulário Product Data e pressione next
			E preencho o formulário Price Option e pressione next
			E preencho o formulário Send Quote e pressione Send
			Então vejo a mensagem na tela a mensagem "Sending e-mail success!"
			
			