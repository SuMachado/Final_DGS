# US010 OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

* Specify a new vaccine type

---

**Transaction Line Items**

* 

---

**Product/Service related to a Transaction or Transaction Line Item**

* 

---


**Transaction Records**

* 

---  


**Roles of People or Organizations**

* Administrator (user ID, active Status, name, login, phone, email)


---


**Places**

*  

---

**Noteworthy Events**

* 

---


**Physical Objects**

*

---


**Descriptions of Things**

* Types of Vaccines may be Cholera, Covid-19, Flu, Hepatitis, Smallpox, Tetanus, etc.


---


**Catalogs**

*  

---


**Containers**

* List of Vaccine Technologies 
* List of Vaccine Types

---


**Elements of Containers**

* Vaccine Technologies: Live-attenuated, Inactivated, Subunit, 
Toxoid, Viral vector, Messenger RNA (mRNA)

* Vaccine Types: Cholera, Covid-19, Flu, Hepatitis, Smallpox, Tetanus, etc.

---


**Organizations**

*  

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

* https://www.pfizer.com/news/articles/understanding_six_types_of_vaccine_technologies
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



| Concept (A) 		   | Association   	 |          Concept (B) |
|------------------|:---------------:|---------------------:|
| Vaccine  	       |   has a  		 	   |         Vaccine Type |
| Administrator  	 | specifies 		 	  |         Vaccine Type |
| Vaccine Type  	  |   has a  		 	   | Vaccine Technologies |
| Vaccine   	      |   has a  		 	   |                Brand |



## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![Domain Model](domain-model.svg)



