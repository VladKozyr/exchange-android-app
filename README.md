# Exchange android app 
Simple MVVM application for viewing exchange rates. 
All information is stored in a local database, when data is fetched, the state of the database is updated.
The logic for receiving data from a third-party api has been moved to a separate module.
We also set up a dependency system for the entire project through a separate buildSrc module.
## Used libs:
* Koin
* OkHttp
* Retrofit
* Room
* Coroutines
* Databinding
## Demo:
<img src="exchange-demo.gif" width="216" height="468"/>
