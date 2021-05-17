API CALLBACK INSTRUCTIONS

(1)  METHOD:: POST
url: http://localhost:8080/calculateOrders

BODY:: JSON

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



(2) METHOD:: POST

url:: http://localhost:8080/calculateOrderItem
Body::
{
	"veggie" : 4,
	"chicken" : 1,
	"beef": 0,
 	"chorizo": 1
}