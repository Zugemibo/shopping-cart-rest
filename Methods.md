# Rest Methods

## Products:

### Create

> Method: POST
> Address: localhost:8080/api/products

Method creates new product with post method with provided body as below:


    {
    "name": "Margherita",
    "description": "souce, cheese, oregano",
    "size": 30,
    "price": 20
    }
    
### Read

> Method: GET
> Address: localhost:8080/api/products

 This method retrieve a list of all products.

> Method: GET
> Address: localhost:8080/api/products/{id}

 This method retrieve single product by entered id.
 
> Method: GET
> Address: localhost:8080/api/products/size/{size}

 This method retrieve a list of products with desired size.
> Method: GET
> Address: localhost:8080/api/products/name/{name}

 This method retrieve a list of products with desired name.

### Update

> Method: PUT
> Address: localhost:8080/api/products/{id}

 This method retrieve product by entered id and change data within product with provided JSON body. Example:
 
 Request: http://localhost:8080/api/products/33
 JSON Body:

     {
        "name": "Funghi",
        "description": "testestest",
        "size": 50,
        "price": 30.0
    }

Response: 

     {
        "id":33,
        "name": "Funghi",
        "description": "testestest",
        "size": 50,
        "price": 30.0
    }
    
### Delete

> Method: DELETE
> Address: localhost:8080/api/products/{id}

This method deletes product with entered id.
