# ******* order **********
#{
#  "id": 0,
#  "date": "2018-03-18T13:14:53.000Z",
#  "customerId": 0,
#  "deliveryAddress": "string",
#  "contact": "string",
#  "storeId": 0,
#  "orderItems": [
#    {
#      "id": 0,
#      "orderId": 0,
#      "productId": 0,
#      "product": {
#        "id": 0,
#        "storeId": 0,
#        "name": "string",
#        "description": "string",
#        "price": 0
#      },
#      "price": 0,
#      "quantity": 0,
#      "total": 0
#    }
#  ],
#  "total": 0,
#  "status": "string",
#  "lastUpdate": "2018-03-18T13:14:53.000Z"
#}

use skipthedishes;

create table meal_order (
	ID int not null auto_increment,
	DATE timestamp default current_timestamp,
	CUSTOMER_ID int not null,
	DELIVERY_ADDRESS varchar(256),
	CONTACT varchar(50),
	STORE_ID int not null,
	STATUS varchar(20),
	LAST_UPDATE timestamp default current_timestamp,
    primary key (ID)
);

create table meal_order_item (
	ID INT NOT NULL auto_increment,
    ORDER_ID int not null,
    PRODUCT_ID int not null,
    PRICE decimal,
    QUANTITY decimal,
    primary key (ID),
    foreign key (ORDER_ID) REFERENCES meal_order (ID) ON DELETE CASCADE
);