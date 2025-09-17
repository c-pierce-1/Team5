# Software Requirements Specification
## For <project name>

Version 0.1  
Prepared by Charles Pierce & Sarah Parisi  
CSC340  
September 12, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Introduction](#1-introduction)
  * 1.1 [Document Purpose](#11-document-purpose)
  * 1.2 [Product Scope](#12-product-scope)
  * 1.3 [Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
  * 1.4 [References](#14-references)
  * 1.5 [Document Overview](#15-document-overview)
* 2 [Product Overview](#2-product-overview)
  * 2.1 [Product Functions](#21-product-functions)
  * 2.2 [Product Constraints](#22-product-constraints)
  * 2.3 [User Characteristics](#23-user-characteristics)
  * 2.4 [Assumptions and Dependencies](#24-assumptions-and-dependencies)
* 3 [Requirements](#3-requirements)
  * 3.1 [Functional Requirements](#31-functional-requirements)
    * 3.1.1 [User Interfaces](#311-user-interfaces)
    * 3.1.2 [Hardware Interfaces](#312-hardware-interfaces)
    * 3.1.3 [Software Interfaces](#313-software-interfaces)
  * 3.2 [Non-Functional Requirements](#32-non-functional-requirements)
    * 3.2.1 [Performance](#321-performance)
    * 3.2.2 [Security](#322-security)
    * 3.2.3 [Reliability](#323-reliability)
    * 3.2.4 [Availability](#324-availability)
    * 3.2.5 [Compliance](#325-compliance)
    * 3.2.6 [Cost](#326-cost)
    * 3.2.7 [Deadline](#327-deadline)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
| SP   | 09/2025 | Inital Changes 1 & 2| V 0.0.1   |
|      |         |                     |           |
|      |         |                     |           |

## 1. Introduction

### 1.1 Document Purpose
The purpose of this Software Requirements Specification (SRS) is to define the functional and non-functional requirements for Getaways Now. The SRS will also serve as a reference for future maintenance and enhancement activities throught this semester.

### 1.2 Product Scope
Getaways Now is a vacation rental application designed to connect property owners with travelers seeking short-term accommodations. This SRS outlines the requirements for version 1.0 of the platform, which includes core functionalities for property listing, search, booking, and user interaction.

The software enables customers to:
- Search for rental properties by location, availability, and price
- View detailed property descriptions and compare listings
- Book accommodations securely through the platform
Property owners can:
- Create and manage property listings with photos, pricing, and availability
- Communicate with potential renters through integrated messaging
- Access booking statistics and performance analytics

### 1.3 Definitions, Acronyms and Abbreviations            
| Reference  | Definition                                                                                                                                                                         |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Java       | A programming language originally developed by James Gosling at Sun Microsystems. We will be using this language to build the backend service for GetawaysNow                |
| Postgresql | Open-source relational database management system.                                                                                                                                 |
| API        | Application Programming Interface. This will be used to interface the backend and the fronted of our application.                                                                  |
| HTML       | Hypertext Markup Language. This is the code that will be used to structure and design the web application and its content.                                                         |
| CSS        | Cascading Style Sheets. Will be used to add styles and appearance to the web app.                                                                                                  |
| JavaScript | An object-oriented computer programming language commonly used to create interactive effects within web browsers.Will be used in conjuction with HTML and CSS to make the web app. |
| VS Code    | An integrated development environment (IDE) for Java. This is where our system will be created.                                                                                    |
|            |                                                              

### 1.4 References

### 1.5 Document Overview
Pass this point this document will cover an overview of Getaways Now as well as go into detail of the specified functional and non-functional requirments for this system.

## 2. Product Overview
This section should describe the general factors that affect the product and its requirements. This section does not state specific requirements. Instead, it provides a background for those requirements, which are defined in detail in Section 3, and makes them easier to understand.

### 2.1 Product Functions
At a high level, Getaways Now will support the following major functions: 
  - Rental search
  - Listing management
  - Booking system
  - Profile Management
  - Listing Statistics

### 2.2 Product Constraints
Getaways Now is should follow the following constraints:  

* Web-based application
* Should not take more than 2 secs to load screens and listings 
* Will follow a code and design standard that way it is easily legiable for future developers
* Must be inline with standards established during class lectures
  
### 2.3 User Characteristics
There are two types of users
  - Customers: Customers are users that come to this application in search of rental homes for vacations
  - Providers: Providers are property owners who come to this application to list their properties for rent.

### 2.4 Assumptions and Dependencies
The following assumptions and dependencies may impact the system’s requirements:
- Assumptions
  - Users will have access to stable internet connections
  - Third-party APIs (e.g., Stripe, Google Maps) will remain available and stable
  - Users will access the platform via modern browsers (Chrome, Firefox, Safari)
- Dependenciesg
  - Google Maps API for geolocation and property mapping
  - Email service provider for booking confirmations and notifications
  - Hosting infrastructure (e.g., Github) for deployment


## 3. Requirements

### 3.1 Functional Requirements 
* FR0: The system will allow users to create an account.
* FR1: The system will allow users to register as a property owner and create their own listings.
* FR2: The system shall allow all users to browse a list of listings, or search for specific ones.
* FR3: The system will allow users to favorite certain listings.
* FR4: The system will allow customers to review listings that they booked, after their visit is over.
* FR5: The system will allow providers to respond to customer reviews.
* FR6: All users will be able to modify/update their profiles at anytime.

#### 3.1.1 User interfaces
Define the software components for which a user interface is needed. Describe the logical characteristics of each interface between the software product and the users. This may include sample screen images, any GUI standards or product family style guides that are to be followed, screen layout constraints, standard buttons and functions (e.g., help) that will appear on every screen, keyboard shortcuts, error message display standards, and so on. Details of the user interface design should be documented in a separate user interface specification.

Could be further divided into Usability and Convenience requirements.

#### 3.1.2 Hardware interfaces
Describe the logical and physical characteristics of each interface between the software product and the hardware components of the system. This may include the supported device types, the nature of the data and control interactions between the software and the hardware, and communication protocols to be used.

#### 3.1.3 Software interfaces
Describe the connections between this product and other specific software components (name and version), including databases, operating systems, tools, libraries, and integrated commercial components. Identify the data items or messages coming into the system and going out and describe the purpose of each. Describe the services needed and the nature of communications. Refer to documents that describe detailed application programming interface protocols. Identify data that will be shared across software components. If the data sharing mechanism must be implemented in a specific way (for example, use of a global data area in a multitasking operating system), specify this as an implementation constraint.

### 3.2 Non Functional Requirements 

#### 3.2.1 Performance
If there are performance requirements for the product under various circumstances, state them here and explain their rationale, to help the developers understand the intent and make suitable design choices. Specify the timing relationships for real time systems. Make such requirements as specific as possible. You may need to state performance requirements for individual functional requirements or features.

#### 3.2.2 Security
Specify any requirements regarding security or privacy issues surrounding use of the product or protection of the data used or created by the product. Define any user identity authentication requirements. Refer to any external policies or regulations containing security issues that affect the product. Define any security or privacy certifications that must be satisfied.

#### 3.2.3 Reliability
Specify the factors required to establish the required reliability of the software system at time of delivery.

#### 3.2.4 Availability
Specify the factors required to guarantee a defined availability level for the entire system such as checkpoint, recovery, and restart.

#### 3.2.5 Compliance
Specify the requirements derived from existing standards or regulations

#### 3.2.6 Cost
Specify monetary cost of the software product.

#### 3.2.7 Deadline
Specify schedule for delivery of the software product.
