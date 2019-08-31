# Brewer
Sistema de venda de bebidas desenvolvido em Java com Spring MVC

## Tecnologias utilizadas

> - [Java 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
> - [Spring Framework MVC](https://start.spring.io/)
> - [Spring Security](https://projects.spring.io/spring-security/)
> - [Thymeleaf](http://www.thymeleaf.org/)
> - [Bootstrap](http://getbootstrap.com/)
> - [Bootstrap Switch](http://bootstrapswitch.com/)
> - [Log4j 2](https://logging.apache.org/log4j/2.x/)
> - [Spring IoC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html)
> - [JPA, Hibernate](http://hibernate.org/)
> - [Flyway](https://flywaydb.org/)
> - [Spring Data](http://projects.spring.io/spring-data/)
> - [MySQL](https://www.mysql.com/)
> - [My JRebel](https://my.jrebel.com/)
> - [Tomcat 8](http://tomcat.apache.org/download-80.cgi)
> - [Guava - Cache](https://github.com/google/guava)


#### <i class="icon-file"></i> Dados de acesso para teste

A aplicação funciona somente com a seguinte configuração

- Tomcat v8.0
- Baixar : mysql-connector-java-5.1.39-bin.jar e adicionar em C:\apache-tomcat-8.0.35\lib
- Baixar : c3p0-0.9.5.2.jar e adicionar em C:\apache-tomcat-8.0.35\lib
- Baixar : mchange-commons-java-0.2.11.jar e adicionar em C:\apache-tomcat-8.0.35\lib 
- Arquivo context.xml em src > main > webapp > META-INF apontando para o banco existente na base de dados
- Em Run Configuration, criar uma nova configuração de Maven Build, chamada de Brewer - Migration

-	Onde:
 	
		- Base directory = aponta o workspace do projeto
		- Goals = flyway:migrate
		- Add parameters
		
			name: flyway.user
			value: root
		
			name: flyway.password
			value: root
	
			name: flyway.url
			value: jdbc:mysql://localhost/brewer?useSSL=false
- Executar Brewer - Migration
- Startar o projeto pelo TomCat		


###### Obs:caso ocorra algum erro, apagar as tabelas do banco e criar novamente.
	