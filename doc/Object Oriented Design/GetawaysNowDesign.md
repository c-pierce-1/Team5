# Getaways Now - Software Design 

Version 1  
Prepared by Charles Pierce and Sarah Parisi
Getaways Now
Oct 20, 2025

Table of Contents
=================
* [Revision History](#revision-history)
* 1 [Product Overview](#1-product-overview)
* 2 [Use Cases](#2-use-cases)
  * 2.1 [Use Case Model](#21-use-case-model)
  * 2.2 [Use Case Descriptions](#22-use-case-descriptions)
    * 2.2.1 [Actor: Provider](#221-actor-provider)
    * 2.2.2 [Actor: Customer](#222-actor-customer) 
* 3 [UML Class Diagram](#3-uml-class-diagram)
* 4 [Database Schema](#4-database-schema)

## Revision History
| Name | Date    | Reason For Changes  | Version   |
| ---- | ------- | ------------------- | --------- |
|  Cp  |10/20    | Initial Design      |    1.0    |
|      |         |                     |           |
|      |         |                     |           |

## 1. Product Overview
Getaways Now is a web-based platform designed to connect travelers with a curated catalog of vacation rentals. Customers can browse and book their next getaway, and after their stay, leave reviews to share their experience.
Property owners can create new listings, manage their rental portfolios, and track property performance. The system supports multiple user roles, including guests, hosts, and administrators, each with tailored services to ensure a seamless, transparent, and user-friendly booking experience.



## 2. Use Cases
### 2.1 Use Case Model
![Use Case Model](https://github.com/c-pierce-1/Team5/blob/ad1daf9b2bde93c9e909e2bfe67650a8752a782e/doc/Object%20Oriented%20Design/Use-case%20model.png)

### 2.2 Use Case Descriptions

#### 2.2.1 Actor: Provider
##### 2.2.1.1 Sign Up
A provider can sign up to create their profile with their name, email, password, and phone number. Emails must be unique.
##### 2.2.1.2 Log In
A provider shall be able to sign in using their registred email and password. After logging in, the provider will be directed to the websites home page.
##### 2.2.1.3 Update Profile
A provider can modify their profile by updating phone number, email, and name.
##### 2.2.1.4 Create Listings
The provider will be able to create new listings. This includes adding images, a listing name, decription, address, rules and a price per night. This listing is only associated with one provider.
##### 2.2.1.5 Edit Listings 
Providers can update their listings, prices, name, description, and images
##### 2.2.1.6 Reply To Reviews
Providers can reply to customer reviews on their listings
##### 2.2.1.7 Compare to other Listings
Providers have the ability to search listings where they can then compare their listings to their competitors.


#### 2.2.2 Actor: Customer
##### 2.2.2.1 Sign Up
A customer can sign up to create their profile with a name, password, and email/phone number.
##### 2.2.2.2 Log In
A customer shall be able to sign in using their registred username and password. After logging in, the customer shall be directed to the home page to view listings, and they will have the option to view their favorite listings.
##### 2.2.1.3 Update Profile
A provider can modify their profile by updating phone number, email, and name.
##### 2.2.2.3 Browse listings
A customer shall be able to view listings. They can do this from the home page or using a search function. They can also filter listings by name, descriptions, or location. They will also be able to select one specific listing and view more details.
##### 2.2.1.4 Favoriting a listing
Upon selecting a listing, a customer shall be able to favorite the listing using a one-click action. This listing will then appear on their favorites page, and they will be able to view or unfavorite the listing.
##### 2.2.1.5 Review listing
A customer may write a review for a listing they booked and visited and reply to provider replies. They will be able to rate the listing with 1-5 stars.

## 3. UML Class Diagram
![UML Class Diagram](https://github.com/c-pierce-1/Team5/blob/ad1daf9b2bde93c9e909e2bfe67650a8752a782e/doc/Object%20Oriented%20Design/UML%20class%20diagram.png)
## 4. Database Schema
![UML Class Diagram](https://github.com/c-pierce-1/Team5/blob/ad1daf9b2bde93c9e909e2bfe67650a8752a782e/doc/Object%20Oriented%20Design/Database%20Schema.png)