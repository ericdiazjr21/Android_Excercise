# Android Excercise
### Implemented Libraries
* RxJava
* RxAndroid
* Retrofit
* OkHttp
* Dagger
* Play Services - Location
* Material Design
* LiveData and ViewModel
* Room
* Picasso

### Specifics 
- This application was developed in Android Studio v 3.5
- Application uses MVVM architecture
- Emulator should have play services setup 

### Features
- Current weather information displayed at top of screen
- RecyclerView displaying daily forecast at bottom of screen
- Referesh button to reload data
- Weather data aquired through Retofit GET
- Data stored locally supporting offline mode
- User location acquired from play services

### Comments
- Needs unit testing
- Weather icon links are hard-coded, would prefer to extract to API
- Dagger compilation issue due to kapt bug - refer to app build.gradle
- Network error noted when using Pixel 2 API 25 on initial run after install
