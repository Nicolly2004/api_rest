apirest
A api deveria funcionar possibilitando o Usuário se cadastrar, listar,deletar e atualizar;

#Inicio
Comece abrindo o intellij e abrindo o projeto, rode o docker e abra o insomnia para testar a rota de auteticação
(http://127.0.0.1:8080/autenticar/cadastro) -> esta rota deverá permitir que o usuário se cadastre colocando email, login e senha
(http://127.0.0.1:8080/autenticar/login) -> esta rota deve permitir a liberação de um token através do email,login e senha;


#Pré-requisitos
É necessário ter algumas dependências baixadas, caso não tenha, deixo aqui como deve estar na pom.yml

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>com.auth0</groupId>
			<artifactId>java-jwt</artifactId>
			<version>3.3.0</version>

somente rode o docker e teste as rotas de autenticação 
