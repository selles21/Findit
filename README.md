# Findit
## Search songs from [iTunes API](https://developer.apple.com/library/archive/documentation/AudioVideo/Conceptual/iTuneSearchAPI/index.html#//apple_ref/doc/uid/TP40017632-CH3-SW1)
In this sample project, we created an application to search this `API` and show the results.

## Main features
1. Open new search view.
  * Write your label to search for.
  * Apply filters and execute a new search.
  * Clear filters and show a the search screen.
  * The `media` and `type` section are fixed because the goal of this sample was search songs.
2. Show a list with the results of this search.
  * The users will be able to see the track name, artist name, collection name, genre tags, price.
  * By clicking the artist name a browser will open with the artist detail page.
  * By clicking the collection name, a browser will open with the collection detail page.
  * By clicking an item, a second screen will show a more detailed view of it.
3. Show an item detail.
  * Showing detailed item view.
  * Added a button to play the song preview.
  * Showing song image.

## Project architecture
In this project we are using a MVVM, Clean architectures with SOLID principies.
