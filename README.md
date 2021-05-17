# ecommerce-order-processing

- JDK - Java™ Platform, Standard Edition Development Kit
- Spring Boot - Framework to ease the bootstrapping and development of new Spring Applications
- Maven - Dependency Management

# Running the application with IDE
There are several ways to run a Spring Boot application on your local machine.
One way is to execute the main method in the class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open IntellijIdea
- File -> Open -> Navigate to the folder where you unzipped the zip
- Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

# API CALLBACK INSTRUCTIONS

(1)  METHOD:: POST
url: http://localhost:8080/calculateOrders

BODY:: JSON
```
{
	"tacoOrderId" : 1,
	"tacoLocoArray": [
		{
			"tacoId": "1",
			"tacoItemName": "veggie Taco",
			"tacoItemQuantity": "3"
		},
		{
			"tacoId": "2",
			"tacoItemName": "chicken Taco",
			"tacoItemQuantity": "13"
		},
		{
			"tacoId": "3",
			"tacoItemName": "beef Taco",
			"tacoItemQuantity": "1"
		},
		{
			"tacoId": "4",
			"tacoItemName": "chorizo Taco",
			"tacoItemQuantity": "1"
		}
	]
}
```

(2) METHOD:: POST

url:: http://localhost:8080/calculateOrderItem
Body::
```
{
	"veggie" : 4,
	"chicken" : 1,
	"beef": 0,
 	"chorizo": 1
}
```