# US013 OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

**Business Transactions**

* VaccinationCentersRegistration (RegistrationID, RegistrationDate, ApprovalStaus)

---

**Transaction Line Items**

*

---

**Product/Service related to a Transaction or Transaction Line Item**

*  Vaccines (Name, ID, Type, Manufacturer, AdministrationTime, Dose)

---


**Transaction Records**

*  RegistrationRecords (ID, RegistrationID, RegistrationDate, ApprovalStaus)

---  


**Roles of People or Organizations**

* Administrator (Name, AdminID, ContactInfo)


---


**Places**

*  VaccinationCenter (ID, Name, Address, ContactInfo, WorkingHours, MaxVaccinesPerDay, MaxVaccinesPerHour)
*  Facility (FacilityId, Capacity, Accessibility, PandemicSuitability)

---

**Noteworthy Events**

* ApprovalProcess

---


**Physical Objects**

*

---


**Descriptions of Things**

*  HealthGuidelines (Guideline)


---


**Catalogs**

*  

---


**Containers**

*  Facility (FacilityId, Capacity, Accessibility, PandemicSuitability)


---


**Elements of Containers**

*  ContactInfo (PhoneNumber, Email)
*  StaffDetails (Name, ID, Role)
*  Docs (Licences, Permits)

---


**Organizations**

*  DGS (ID, AdminName, AdminContactInfo)

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

| Concept (A) 		                  |            Association   	             |                   Concept (B) |
|---------------------------------|:--------------------------------------:|------------------------------:|
| VaccinationCenterRegistration  	 |   initiates registration for   		 	    |             VaccinationCenter |
| VaccinationCenterRegistration   |            logs details in             |            RegistrationRecord |
| Administrator 	                 |      performs registration for 	       | VaccinationCenterRegistration |
| VaccinationCenter  	            |           is located at		 	            |                      Location |
| VaccinationCenter 	             |            is part of 		 	             |                      Facility |
| Facility  	                     |               has   		 	               |            ContactInformation |
| Facility                        |               has   		 	               |                 Documentation |
| Facility                       |              has    		 	               |              HealthGuidelines |
| VaccinationCenterRegistration  | goes throug approval process by   		 	 |                           DGS |
| VaccinationCenter                          |              administers               |                       Vaccine |

## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![Domain Model](\Users\analu_i2sv215\Desktop\Java\Aulas\Processos de desenvolvimento de software\Exercicios\DGS_Project\pds-base\sns-base\doc\global\use-cases\uc013\requirements\svg\US013_DomainModel.svg)



