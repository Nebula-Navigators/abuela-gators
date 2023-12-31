# Abuela-Gators [Group-project/Capstone-2]
### Team Members
- Hally Amor (**Project Manager** and **Software engineer** @ Nebula Gators org.)
- Elizabeth (**Software engineer** and **Github Manager** @ Nebula Gators org.)
- Shankar (**Lead Software Engineer** and **Product Manager** @ Nebula Gators org.)

### Introduction:
Welcome to the Abuela Gators! Home of the Abuela Gators! Can I take your order?!

Thank you for choosing our deli! Just like that, this application takes an order from the customer and prints the receipt. This README serves as your guide to the details of the application.

### About:
At Abuela Gators we take pride in crafting a diverse menu inspired by a fusion of culinary traditions.
From flavorful sandwiches, to tasty snacks and refreshing beverages, our deli offers a great satifaction to your cravings!
Our commitment to quality ingredients and phenomonal service is sure to make you feel right at home just as abuela does.

### Features:
- Explore our sandwich menu by first choosing your size and bread preference.
- These options include three sizes of 4, 8, and 12 inches and bread options of White, Wrap, Wheat, and Rye.
- Customers can then customize their sandwich by choosing toppings such as cheese, meats, sauces, and the option to toast their meal.
- Options to add on chips or drinks of preference is available at an extra cost.
- Completed orders are then made to customers satisfaction as they are given a receipt and await their purchase.


### Getting Started
#### Requirement
- Java Development (JDK) installed
- Environment Variables (Optional): While not strictly necessary, setting the ``JAVA_HOME`` environment variable can be useful. This variable points to the directory where the JDK is installed. Additionally, adding the ```bin ```directory of the JDK to the system's ``PATH`` variable allows you to run Java commands from any location in the terminal or command prompt.

#### Installation
- git clone [Click me to copy link to clone](https://github.com/Nebula-Navigators/abuela-gators.git)
- Review the license section

### Quick-Start Guide
1. Run the program
  - Open IDE and Open the project and run the program (intelliJ is prefferred)
  - Using command line (Optional)
    - Navigate to the project
     ```
     cd <path>/abuela-gators
     ```
    - Compile all the file
     ```
     javac -d out src/**/*.java
     ```
    - Run the program
     ```
     java -cp out com.pluralsight.AbuelaGators
     ```
2. Follow the instructions for user input
3. See the receipt file under the project **abuela-gators** in the format ".txt"

### Project Structure
Our project is organized into several packages and subclasses, each serving a specific purpose for our deli:

```UserInterface``` Class:

The ```UserInterface``` Class contains the entry point of the application. This is the starting class that initializes the application and handles user interactions.

It works as a blueprint by implementing classes and  methods. The customer would input their order in the intelliJ terminal in order to run our code to order their meal.

Other classes included are ```Sandwiches```, ```Chip```, ```Drink```,  ```Receipt```, ```OrderManager```, ```Topping``` and ```Order```.

We have also created Enum classes which is used to add methods in order to define a set of constant values.


### UML diagram
We break it down to three parts

<img src = "https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/UMLDiagram.png">
<img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/UMLPart1.png">
<img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/UMLPart2.png">


### Classes and Packages

Below packages are the list of package that we used in our project
##### Package


| Package | Usage |
| -------- | -------- |
| ```time```      | To get the real time to create a file '.txt' so that we can save receipt    |
|```util``` package | To use ArrayList to save sandwich, drinks and chips |
|```com.pluralsight``` | The package that holds all the classes and enum mentioned in below |

Below are the classes that we have used in our project.


##### classes



| Classes | Usage |
| -------- | -------- | 
| ```AbuelaGators```    | Main function in Java that runs the application     | 
| `UserInterface` | Show the instructions and get the userInput |
|`Order` | Blueprint for orders which holds, list of sandwich, drinks and chips |
| `OrderManager` | Handles the order. Add the order type in order |
| `Receipt` | Blueprint for receipt that shows tax amount and total amount after tax |
| `ReceiptFileManager` | Saves the receipt for future reference |
| `Sandwich` | blueprint for sandwich which also store list of toppings |
| `Topping` | blueprint for Toppings |
| `Drink` | blueprint for drink i.e. size and type and price |
|`Chip` | blueprint for chip i.e. chiptype and price |


- ```AbuelaGators```
- ```UserInterface```
  - ```HomeScreen```
  - ```OrderScreen```
  - ```DrinkScreen```
  - ```ChipScreen```
  - ```SandwichScreen```
  - ```CheckOutScreen```
- ```Order```
  - ```OrderManager```
- ```Receipt```
  - ```ReceiptFileManager```
- ```Sandwich```
  - ```Topping```
- ```Drink```
- ```Chip```

##### Enum
- ```Size```
- ```BreadType```
- ```DrinkType```
- ```ChipType```

### Relationships
- ```AbuelaGators - UserInterface```
  AbuelaGators is the main class that call UserInterface to start the application. They have one-to-one relationship
- ```UserInterface``` - Screens Class (```HomeScreen```, ```OrderScreen```, ```DrinkScreen```, ```ChipScreen```, ```SandwichScreen```, ```CheckOutScreen```)
  ```UserInerface``` call these class to display menu and get user input. They have One-to-one relationship.
- ```UserInterface - OrderManager```
  ```OrderManager``` get the user input data from UserInterface.
- ```OrderManager - Order```
  ```OrderManager``` handles the data and maintain Order class which includes ```Sandwich```, ```Drinks``` and ```Chips```. Calculate the total amount along with the tax. ```OrderManager``` can handle many orders so They have One to many relationship.
- ```Order ```- type classes(```Sandwich```, ```Drink``` and ```Chip```)
  ```Order``` - ```Sandwich``` have one to many relationship. One order can have many sandwiches and similarly goes for drinks and chips.
- ```Receipt - ReceiptFileManager```
  ```ReceiptFileManager``` handles may receipts so it has one to many relationship. ```ReceiptFileManager``` creates the Receipt and save it in a particular file in the '.txt' format.
- ``Receipt - Order``
  Receipt holds the orders. It has one-to-one relationship
- ``Sandwich - topping``
  They have one-to-many relations because a sandwich can have many toppings in it.
- ```Sandwich ```- enum (```BreadType``` and ```Size```)
  They have one-to-one relationship as each sandwich have one enum that is one ```breadType``` and one ```Size```.
- ```Drink``` - enum (```DrinkType``` and ```Size```)
  Similar to above they also have one-to-one relationship as drink can have only one enum that is ```Drinktype``` and ```Size.```
- ```Chip ```- ```ChipType```
  They also have one-to-one relationship as Chip can have only one ChipType

### Screenshots


| Home Screen                                                                                                  | Order Menu                                                                                                    | CheckOut Menu                                                                                                    |  Receipt Menu |
|--------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------| ------- |
| <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/HomeScreen.png" width=400> | <img src = "https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/OrderMenu.png" width=400> | <img src = "https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/CheckOutMenu.png" width=400> | <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/Receipt.png" width=400>

###### Sandwich screens:


| Bread Menu                                                                                                  | Cheese Menu                                                                                                  | Meat Menu                                                                                                  |
|-------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/BreadMenu.png" width=400> | <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/CheeseMenu.png" width=400> | <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/MeatMenu.png" width=400> | 



| Extra Meat                                                                                                      | Extra Cheese                                                                                                  | Size Menu                                                                                                  |
|-----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/ExtraMeatMenu.png" width=400> | <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/ExtraCheese.png" width=400> | <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/SizeMenu.png" width=400> |



| Regular Topping                                                                                                      | Sauces                                                                                                      | Sides                                                                                                       |
|----------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------|
| <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/RegularToppingMenu.png" width=400> | <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/SauceMenu.png" width=400> | <img src="https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/SidesMenu.png" width=400> |



| DrinkMenu | Chip | 
| --------- | ---- | 
| <img src = "https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/DrinkMenu.png" width=400>    | <img src = "https://github.com/Nebula-Navigators/abuela-gators/blob/main/screenshot/ChipsMenu.png" width=400> | 



### Tools we used
- **intelliJ ultimate** To create UML diagram
- **appdiagram.net** To modify the UML
- **Hackmd.io** To collaborate while writing README.md file
- **Github** for collaboration
- **Slack** for communication


### Contribution
We Gators welcome all for contribution and creativity. You have to fork the project, add features and send pull request.
[click me to fork](https://github.com/Nebula-Navigators/abuela-gators/fork)

All contributors will be given credit.

### Credit
- **StackOverFlow** for Loading Bar https://stackoverflow.com/questions/852665/command-line-progress-bar-in-java
- **StackOverFlow** for ANSIColors https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println


### License
This project is owned by Nebula-Gators Org. All students are welcome to use this code in their projects, but referencing is strongly suggested. No monetary transactions should be involved.

***Thank you for choosing Abuela Gators! Enjoy your meal! Get ready to savor the extraordinary! 🍽️***