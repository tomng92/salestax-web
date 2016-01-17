
Coding exercise: Calculation of sales tax
================


This exercise uses:
 1) Maven
 2) Spring
 3) java and object-oriented techniques.
 4) Jsf

To run application in command line mode, please do this:

  - cd salestax
  - mvn compile
  - cd salestax-web
  - mvn exec:java -Dexec.mainClass=com.coding_exercise.app.SalesTaxApp 


To run application in web mode, please deploy it in Tomcat 7
(I did not test in other versions nor app servers), and enter in your browser:
  
  - http://localhost:8080/salestax-web/queryList.jsf  		



Thanks a lot!
It was very entertaining, especially the coding of the rounding up function.
Jsf was also giving me a lot of troubles.

For the future: There are some more testing to be done, and some refactoring.
Especially the ItemListServiceImpl class.


Thanh Nguyen.