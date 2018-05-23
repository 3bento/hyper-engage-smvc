# Hyper Engage SMVC

That is web application  that can make the users share information, added friends and more.
I will put more details here, so soon. That project is started to improve my skills with Spring Framework.

## Authors

** Eduardo Bento Rocha Junior ** - *Initial work* - [Hyper-Engage-smvc](https://github.com/eduardobento2/hyper-engage-smvc)


### Database set up

I am using docker to set up the database. If you don't know about docker, go to [Docker Official] https://www.docker.com/
You can set up your database using normal Mysql, go to [Mysql Official] https://www.mysql.com/

The reason that i am using Docker is to make easier to set up the mysql and Windows or Linux.

Code to set up simple mysql server by Docker.
```
docker run -detach --name=dev-mysql --env="MYSQL_ROOT_PASSWORD=root" --publish 6603:3306 mysql
```
I am using the port 6603, you can change it to 3306:3306, 5555:3306, etc. That is your choose.

## Built with

That is the most important itens to use that project, part of them already inside of the project like SpringBoot, 
SpringMVC, etc, but Maven, Tomcat 8 and Mysql you have to download and configure in your computer.
I will add or remove links in the list while i am coding more.

* [Spring Boot] https://projects.spring.io/spring-boot/
* [Spring MVC]  https://spring.io/guides/gs/serving-web-content/
* [JPA] http://www.oracle.com/technetwork/java/javaee/tech/persistence-jsp-140049.html
* [Maven] https://maven.apache.org/
* [Tomcat 8] http://openejb.apache.org/apache-tomee.html

## Utils 

I am using and folloing that links, i will update it with more details and links.

* [.gitignore] https://github.com/spring-projects/spring-mvc-showcase/blob/master/.gitignore
* [Maven Repository] https://mvnrepository.com/
* [Docker] https://www.docker.com/
* [Mysql] https://www.mysql.com
* [Lombok Project] https://projectlombok.org

I am not using lombok yet, but i will use it.

## Progress of the project
That is simple Scrum kanban! Maybe will remove it. I don't know, i like it XD

-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
To-Do
- signup (frontend / backend)
- configure the database / memcache
- signin (frontend / backend)
- forgetpassowrd (front / backend)
- profile (show, update)
-------------------------------------------------------------------------------------------------
In-Progress
- signup (frontend) 98%/100% (I need to compare passwords.)
- signup (backend) 98%/100% (I need to change hard strings to internationalization.)
-------------------------------------------------------------------------------------------------
Done
- [x] configured Spring Boot (Spring MVC)
- [x] configured internationalization (en,jp,pt-BR)
- [x] configured page error 404/500 (no layout added)
- [x] configure the database (mysql)
-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------

## Acknowledgments
* Maven
	* What is Maven?
	* Why should i use mavem? 
	* How to use maven?
* Java EE (Spring MVC)
	* Java EE
	* Spring
	* Spring Boot
	* Spring MVC
	* JPA or Hibernate
	