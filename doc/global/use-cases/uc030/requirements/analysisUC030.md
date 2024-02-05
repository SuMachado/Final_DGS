# UC030 Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
SNS User, vaccine, vaccination appointments, Health Institution, vaccine type

### _Conceptual Class Category List_ ###

**Business Transactions**

* Appointment for a vaccination

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

* 

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

*  SNS user enters his data and chosen time and center to make an appointment for a vaccination. 


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

* SNS user Data
---



###**Rationale to identify associations between conceptual classes**###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 

+ **_A_** is physically or logically part of **_B_**
+ **_A_** is physically or logically contained in/on **_B_**
+ **_A_** is a description for **_B_**
+ **_A_** known/logged/recorded/reported/captured in **_B_**
+ **_A_** uses / owns **_B_**
+ **_A_** is related with a transaction (item) of **_B_**
+ etc.



| Concept (A)             |                Association                 |               Concept (B) |
|-------------------------|:------------------------------------------:|--------------------------:|
| SNS User                |          is directly related with          |   Vaccination appointment |
| SNS User                |                 creates a                  |   vaccination appointment |
| Vaccine                 |          is directly related with          |   Vaccination appointment |
| Vaccination appointment | is physically or logically contained in/on |        Health Institution |
| Vaccine                 |  is related with a transaction (item) of   |   Vaccination appointment |
| Vaccine                 | is physically or logically contained in/on |              Vaccine Type |





## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in an SVG format**

![Domain Model](C:\Users\Suzana\Desktop\DGS_Project\DGS_Project\pds-base\sns-base\doc\global\use-cases\uc030\requirements\svg\US030-objectDiagram.svg)



