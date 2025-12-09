# Getaways Now Requirements Testing
## Actors
- Provider P: Property Owner
- Customer C: Customer
- Service S: Rental Listing

### Use Cases

#### Provider - Create Listing:
1. Provider P1 logs in and navigates to the Create Listing page.
2. P1 enters values into all fields and uploads listing images.
3. P1 submits the form, and the newly created listing page appears displaying the configured values.
4. P1 exits the app.

#### . Customer - Search Listings:
1. Customer C1 navigates to the Home Page, where all listings are displayed by default.
2. C1 filters listings by name, city, minimum price, and maximum price.
3. Only listings matching each criterion are shown.

#### . Customer - View Listing:
1. Customer C1 navigates to the Home Page.
2. C1 selects any listing and opens the View Listing page, where all details for that listing are displayed.
3. C1 uses the image carousel to view all photos associated with the listing.
4. C1 scrolls to the bottom of the page to view any existing reviews for that listing.

#### . Customer - Book a Listing:

#### . Customer - Write review (Rate a listing):
1. Customer C1 navigates to a listing they previously booked.
2. C1 enters free-text into the review box at the bottom of the page and submits it.
3. The page refreshes and the newly submitted review is displayed.

#### . Provider -  Reply to Review, View Statistics, & Modify listings:
1. Provider P1 navigates to the My Listings page.
2. P1 edits an existing listing; the Edit Listing page appears with all fields pre-populated, and P1 updates the desired values.
3. P1 views booking information. They may filter bookings by selecting a specific listing or choose Show All Bookings to view bookings across all listings they own.
4. P1 replies to customer reviews where applicable.
5. P1 exits the app.