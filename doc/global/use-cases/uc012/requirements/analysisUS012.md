# US012 OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

* Get a List of all the Vaccines

---

**Transaction Line Items**

* List of Vaccines

---

**Product/Service related to a Transaction or Transaction Line Item**

*  

---


**Transaction Records**

* List of Vaccines Types
* List of all the Vaccines

---  


**Roles of People or Organizations**

* Administrator (user Id, active Status, name, login, phone, email)


---


**Places**

* Healthcare Centers
* Vaccination Centers

---

**Noteworthy Events**

* 

---


**Physical Objects**

* Vaccines

---


**Descriptions of Things**

*  Administrator gets Access to the list with all the vaccines


---


**Catalogs**

* List of vaccine types
* List of all the vaccines

---


**Containers**

*  

---


**Elements of Containers**

*  

---


**Organizations**

* Direcção Geral de Saúde (DGS)

---

**Other External/Collaborating Systems**

*  


---


**Records of finance, work, contracts, legal matters**

* 

---


**Financial Instruments**

*  

---


**Documents mentioned/used to perform some work/**

* 
---



###**Rationale to identify associations between conceptual classes**###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 

+ **_A_** is physically or logically part of **_B_**
+ **_A_** is physically or logically contained in/on **_B_**
+ **_A_** is a description for **_B_**
+ **_A_** known/logged/recorded/reported/captured in **_B_**
+ **_A_** uses or manages or owns **_B_**
+ **_A_** is related with a transaction (item) of **_B_**
+ etc.



| Concept (A) 		          |   Association   	    |   Concept (B) |
|-------------------------|:--------------------:|--------------:|
| GetListOfAllVaccines  	 | requested by    		 	 |        Client |
| GetListOfAllVaccines  	 |  created by    		 	  | Administrator |



## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![Domain Model](domain-model.svg)



