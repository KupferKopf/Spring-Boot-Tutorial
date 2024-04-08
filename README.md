# Spring-Boot-Tutorial
Following a YT tutorial on Spring boot to get back into it

Link:
https://www.youtube.com/watch?v=c3gKseNAs9w


Content of the tutorial: (written in obsidian)


Spring is a java Framework build to create a enterprise ready application.
Spring has a broad spectrume of tools usable for diffent scenarios

Spring makes creating an application easier but requires a lot of convig
Now springboot is a extenshion of the spring framework it can be seen as the extenshion layer for spring

Springboot helps adding other librarys  and their dependencis bye doing the needed configurations for you.

### Dependencie injection
Normaly you would create a class or a referentc to a class yourself 
	student = new Student()
But when it comes to bigger projects with 100 and 1000 of different classes and objects that manual approach becomes inefficient and bad. 
Following that *inversion of control* or *IOC* comes into picture with that we give the control of creating the objects to spring so it does that for us
Now when starting the project spring will create all those objects and store them in a spring container and so if, at any time, we need a particular object we can just tell spring to give us the object without needing to do initalise it.

### Spring initalizer
*Spring initalizer* allowes us to create the bare minimum of a springboot application which allows us to build our application on top of it.
https://start.spring.io/
Maven Project / Java / latest stable version / Jar / and what ever i have installe as the latest java version

The names are purely cosmetic so they only impact the file structure
on the right side you can add dependencies (in this case we add spring web and H2 Database)

after that we could share our project layout with others if they want to have the same setup.

Finally we generate the project and after the download finishes we move it to the desired location on our pc 

### Springboot Starters
next we open that file in a ID (InteliJ, eclipse what not) 
open the 2nd folder the one on the same level as the .idea folder

to start the project open the main file and run it
in the pom file you can strg+L-click an artifact and see all the dependencies that are used in it

### Rest API
Create Controller

add anotations
add first method: value="/" means that if we open localhost:8080/ we will get the methods return as a response

changed Requestmapping to getmapping

### Springboot DevTools
helpfull dependency which allows the changes you make on the code to be automatically used in the running application without having to restart it

### Architecture and layers

Controller layer ->  is for requests and responses handeling those get, Post, put or delete inputs, 
the routing layer 

Service layer -> is the main layer for the buisness logic, 
the logic/service layer

Data Access/Repo layer ->  handeling the data access

Database -> the database duh

### adding jpa & h2 dependencies

adding jpa in order to keep data in SQL-stores using Spring Data and hibernate 

adding code to the properties file in order to reach the h2 console
	spring.h2.console.enabled=true  
	spring.datasource.url=jdbc:h2:mem:dcbapp  
	spring.datasource.driverClassName=org.h2.Driver  
	spring.datasource.username=sa  
	spring.datasource.password=password  
	spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
with those information you can login into your h2 console under localhost:8080/h2-console/
after inputting the needed information you can test as well as directly connect to your h2 console

### Components
create new packages entity, repository and service 

add new class to entity called department
	give it variables
	 getter, setters and constructors
	 add @Entity so it can interact with the database
	 now we have to add an id so we have a primary key for our database

add new class to controller called departmentController
	 add @RestController


### Saving Entitys to the DB

http://localhost:8080/h2-console/
@RequestBody converts the json object to a java object for us 

Conrtoller
@PostMapping("/departments") // called 1st when wanting to save a department entity, calls the service layer to continue the action downwards  
public Department saveDepartment(@RequestBody Department department){  
    return departmentService.saveDepartment(department);  
}

Service
public Department saveDepartment(Department department); // 2nd to be called for department entity, continuing to the impl

ServiceImpl
@Override // 3rd to be called to save the Entity actual logic of the service layer  
public Department saveDepartment(Department department) {  
    return departmentRepository.save(department);  
}

postman Post request
json query to define all the variables correctly :
{
    "departmentName":"CE",
    "departmentAddress":"Bangalore",
    "departmentCode":"IT-07"
}

### Get all Entitys from the DB

Controller
@GetMapping("/departments")  
public List Department fetchDepartmentList()  
{  
    return departmentService.fetchDepartmentList();  
}

Service
public List Department fetchDepartmentList();

ServiceImpl
@Override  
public List Department fetchDepartmentList() {  
    return departmentRepository.findAll();  

### Delete Department by ID

Controller
@DeleteMapping("/departments/{id}")  
public String deleteDepartmentById(@PathVariable("id") Long departmentId){  
    departmentService.deleteDepartmentById(departmentId);  
    return "Department has been successfully deleted";  
}

Service
public void deleteDepartmentById(Long departmentId);

ServiceImpl
@Override  
public void deleteDepartmentById(Long departmentId) {  
    departmentRepository.deleteById(departmentId);  
}

### Update Department by ID

Controller
@PutMapping("/departments/{id}")  
public Department updateDepartment(@PathVariable("id") Long departmentId,  
                                   @RequestBody Department department){  
    return departmentService.updateDepartment(departmentId,department);  
}

Service
public Department updateDepartment(Long departmentId, Department department);

ServiceImpl
@Override  
public Department updateDepartment(Long departmentId, Department department) {  
    Department departmentDB = departmentRepository.findById(departmentId).get();  
  
    if(Objects.nonNull(department.getDepartmentName()) &&  
    !"".equalsIgnoreCase(department.getDepartmentName())) {  
        departmentDB.setDepartmentName(department.getDepartmentName());  
    }  
  
    if(Objects.nonNull(department.getDepartmentCode()) &&  
            !"".equalsIgnoreCase(department.getDepartmentCode())) {  
        departmentDB.setDepartmentCode(department.getDepartmentCode());  
    }  
  
    if(Objects.nonNull(department.getDepartmentAddress()) &&  
            !"".equalsIgnoreCase(department.getDepartmentAddress())) {  
        departmentDB.setDepartmentAddress(department.getDepartmentAddress());  
    }  
  
    return departmentRepository.save(departmentDB);  
}


### Get Department by property Name

Controller
@GetMapping("/departments/name/{name}")  
public Department fetchDepartmentByName(@PathVariable("name") String departmentName){  
    LOGGER.info("Inside fetchDepartmentByName of DeparmentController");  
    return departmentService.fetchDepartmentByName(departmentName);  
}

Service
public Department fetchDepartmentByName(String departmentName);

ServiceImpl
@Override  
public Department fetchDepartmentByName(String departmentName) {  
    return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);  
}


### Changing from h2 to mysql as a DB

in pom file:
<dependency>  
    <groupId>com.mysql</groupId>  
    <artifactId>mysql-connector-j</artifactId>  
    <scope>runtime</scope>  
</dependency>

in application propersties:
spring.jpa.hibernate.ddl-auto=update  
 in mysql to connect the database to the project/ so the database knows who is working with it  
spring.datasource.url=jdbc:mysql://localhost:3306/dcbapp 
spring.datasource.username=root  
spring.datasource.password=admin  
spring.datatasource.drive-class-name= com.mysql.jdbc.Driver  
spring.jpa.show-sql: true

create new mysql sheme with dcbapp as the name and start the application, now all actions will be saved in this mysql database


### Units testsing
in order to test a specific layer freely and easily you need to moke all the other layers that play a part in the functionality of the specific layer. So you get fake, pre writen and provided ojects/answers what not 


### layer Testing
depending on the layer you will need to call the certant methodes you want to test and those have somewhat connections to other layer. these connections you will need to fake/moke.

For testing the controllers you will need to moke the services
for the services you will ned the repository
and for the repository you will need to moke the database/the Data needed

### Using yaml Files
yaml files work same as the propertie files but remove the redundant beginnings of some parts and it converts the propertie code into a more clean and structured 


### Springboot Profiles
deploying a project can be done in multiple diffrent servers which all need diffrent configurations in order to tell spring what kind of config is used for what server we create profiles that spring recocnises and uses depending on the used server


### Bugs
I forgot how easy it is to fuck something up when it comes to coding. It doesn't even need to be the code itself. Just now i spend the 3h on installing maven, trying to add the path correctly 

Still can't mvn clean install
options: change java version or change maven compiler version
others install newer jdk/java version and put that path for JAVA_HOME (internet says so)

If i can't fix this problem tomorrow i will skip implementing the last 20 min of the video and just watch what he is doing.

installed jdk 17 and added it to my path variable as well as added as the new JAVA_HOME
that resolved the problem

### Converting application into a jar
mvn clean install converts the application into a runnable jar

### run the jar
java -jar Spring-boot-tutorial-1.0.0.jar --spring.profiles.active=prod
that command runs the jar file with the given user profile and the configs defined in that profile
stoping an executed jar file is done by opening the cmd and typing in the comand "jps" which will display all running java applications/programs with ther PIDs and sometimes name 
now look which one is yours and stop it by using the "taskkill -f /PID 'PID-number' " comand
### Springboot actuator
used to monitor the running program, lets you see stats of the current program

<dependency>  
    <groupId>org.springframework.boot</groupId>  
    <artifactId>spring-boot-starter-actuator</artifactId>  
</dependency>


starting the application and adding /actuator leads to an info screen with links to to more info pages showing different stats of the application 

management:  
  endpoints:  
    web:  
      exposure:  
        include: "*"

including this allows you to see all the info sites possible 

shown in the "FeatureEndpoint" class is how to create another endpoint for the Actuator and dislpay variables and details

exclude: "env,beans"
allows you to exclude certain endpoints from the displayed list