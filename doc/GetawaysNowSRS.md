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
Web pages using HTML, CSS, and JavaScript

#### 3.1.2 Hardware interfaces
Any device that has web browser capabilities

#### 3.1.3 Software interfaces
* Java jdk 21
* PostgreSQL 17
* SpringBoot 3.4.5

### 3.2 Non Functional Requirements 
* NFR 0: The "create listing" function should be intuitive for beginner providers.

#### 3.2.1 Performance
* NFR 1: The log in process should not take longer than 10 seconds, when given valid credentials.
* NFR 2: The average user should be able to find a specific listing they already know exists in less than 30 seconds, either through using the search function, or their favorites.

#### 3.2.2 Security
* NFR 3: The system should only allow authorized users, who have an account and are logged in, to create/book listings.

#### 3.2.3 Reliability

#### 3.2.4 Availability
* NFR 4: Getaways Now will be available 24/7, with required maintenance updates scheduled past midnight.

#### 3.2.5 Compliance

#### 3.2.6 Cost
* NFR 5: This project will cost nothing to create.
#### 3.2.7 Deadline
* NFR 7: The final version of the project must be delivered by December 2025.
