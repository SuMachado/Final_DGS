# OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 

Facility
Receptionist
Vaccine appointment
SNS User

### _Conceptual Class Category List_ ###

**Business Transactions**

*

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

* receptionist



---


**Places**

* Vaccination center
* Health center

---

**Noteworthy Events**

* schedule an vaccination appointment

---


**Physical Objects**

*

---


**Descriptions of Things**

*  


---


**Catalogs**

*  

---


**Containers**

*  

---


**Elements of Containers**

*  

---


**Organizations**

*  DGS

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



| Concept (A) 		| Association   	 |         Concept (B) |
|----------	   		|:---------------:|--------------------:|
| Facility  	|       has       |      Receptionist   |
| Receptionist |    schedules    | Vaccine appointment |
| SNS User  	|      has a      | Vaccine appointment |



## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![Domain Model](C:\Users\Dell\IdeaProjects\Software Development Overview\Projecto DGS\DGS_Project\DGS_Project\DGS_Project\pds-base\sns-base\doc\global\use-cases\uc021\requirements\analysis\us021-domain-model-US021___As_receptionist__I_want_to_schedule_a_vaccination.svg)



