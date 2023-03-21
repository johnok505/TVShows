# TV Show App

## Project Setup
There should be no extra steps other than cloning the github repository and building the project in your preferred IDE. 


## Task Approach
I divided the project into the following tasks
1. Set up the project with a clean architecture to build upon
2. Make a simple UI item to display the tv show name and poster and display a list of these items.
3. Add the functionality to sort the items alphabetically
4. Test and document throughout
5. Finalize documentation and submit


## App Architecture
The app follows the MVVM architecture. The ViewModel receives data from the backend through a repository and network layer. The ViewModel then publishes data to the UI through a livedata that can be observed.
Retrofit is used to handle the API call to fetch the data.
The data is displayed in a recycler view.
When the data is received, the sort A-Z button becomes enabled so the user can sort items alphabetically.
Some simple tests have been added to test the functionality of the app.

## Next Steps
If I were to spend more time on the app I would:
- Add more tests
- We are not using a lot of the data received from the API call. It would be good to add an on click event to each TV Show that brings the user to a screen with more detail on each TV Show. We could also tidy up the UI with a base MainActivity, a TVShowListFragment with our recyclerView and a DetailFragment that displays the rating, description, etc., of each show.
- The design of the sort A-Z button could be much better. It might be nice to have an option to sort Z-A too or perhaps some other filter options like sorting by the show's rating.
- Perhaps, store the data locally after a fetch so it can be used offline in the future.
- Add a refresh option, e.g. swipe to refresh so the user doesn't have to close and re-open the app to refresh the data.
- In hindsight, using a test driven development approach would have been great but I wanted to focus on getting the app functioning first.


### Tools used
- Kotlin data class from JSON plugin in android studio to generate model from the JSON response of the API call
- Retrofit for API calls
- Moshi for JSON parsing
- Kotlin Coroutines for asynchronous programming
- Picasso for image displaying
- Espresso and Truth for testing
