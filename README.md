# Open J2EE Web Template

This is a working template project, which show cases a sample multi-tier J2EE web application with __Apache Wicket__, __Spring IoC__ and __JPA/Hibernate__ integration and a __Bootstrap__ based frontend. It demonstrates _MvC_, _SoC_, _IoC_, _DAO_, _Service layer_ and _Open Session in View_ patterns and other J2EE best practices.

This template can easily be extended into a fully functional J2EE web application.

## Usage

This template uses maven and is tested on Tomcat7 against Postgres 9.2 database. In order to deploy it follow the below steps:

1. Clone this project git clone git://github.com/kamranzafar/spring-jpa-wicket-bootstrap.git
2. Create a postgres database
3. Update pom.xml file and provide database details.
4. Build the war file with maven
5. Deploy on Tomcat (this will create a "users" table in the database)
6. Run the users.sql script in src/main/script on the postgres database

After this you can login to the application from the browser using the given username and password.
