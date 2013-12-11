First, add an user with administrator access right for Tomcat. 

To add Tomcat user, edit this file – “%TOMCAT_PATH%/conf/tomcat-users.xml“.

<?xml version='1.0' encoding='utf-8'?>
<tomcat-users>
  <role rolename="manager"/>
  <role rolename="admin"/>
  <user username="admin" password="password" roles="admin,manager"/>
</tomcat-users>

Ensure that maven settings "%MAVEN_HOME%/.m2/settings.xml is existing and contains the same host id as the server in pom.xml

  <servers>
   	<server>
		<id>localhost</id>
		<username>admin</username>
		<password>admin</password>
	</server>
  </servers>
  
start tomcat server.
 
go to project directory and run mvn tomcat:deploy
  
go to http://localhost:8080/Weather/usweather