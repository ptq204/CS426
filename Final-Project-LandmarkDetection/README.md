a. Circular main menu:  
We used the circular menu code found on Github for the main menu. The items consist of Start – select photos for recognizing the place, Change IP – changing the IP of the server wifi, About – information about us, Favorite – list of favorite places, Currency – currency converter, and OCR – as mentioned in section III. The PNG icons are collected from Flaticon with size 64x64.  
b. Currency converter:  
We added Currency Converter feature, using an API to get the current rate between eleven types of currency: USD, EUR, SGD, JPY, CNY, AUD, VND, GBP, CAD, MYR, and KRW.  
For the UI, we used Recycler View for currency choosing menu. Moreover, only number-typed input is allowed.  
c. Author section:  
We added About section to present the information of us. We used two animations UI found on Github written by Ramotion: Paper Onboarding and Circle Menu.  
d. Camera:  
We added the Camera section in Landmark recognition and OCR sections, so the user has two choices for selecting a photo: from the gallery or taking from the camera. When testing the OCR section, we noticed that in some test cases, it returned bad results. Referencing the paper of Thai-Nghi Pham’s team in the WR227 course, we found out that text orientation and font affect the results significantly. Moreover, when testing on Redmi Note 5 device, the speed of the application was slow because the resolution of the taken photo was quite large.  
e. Favorite list:  
Android SQLite is used in this section to store the user’s favorite places. Users can add their favorite places to the list by pressing the heart-shaped button in the Detail section and remove the place by a long press at the place in the Favorite section.  
f. Facebook sharing:  
We followed the tutorial on Facebook Developers and reused the code from mini-project 1. Users can share the information about the location (the sharing icon at the top-right in the Detail section) and the application (the middle Vietnamese flag at the main menu) through Facebook. This section could not be tested on Genymotion VM because it does not have the Facebook app.  
References  
https://github.com/tesseract-ocr/tesseract  
https://www.flaticon.com/  
https://free.currencyconverterapi.com/  
https://github.com/Ramotion/circle-menu-android  
https://github.com/Ramotion/paper-onboarding-android  
https://developers.facebook.com/docs/sharing/android/  
https://github.com/hongyangAndroid/Android-CircleMenu  
https://github.com/oguzbilgener/CircularFloatingActionMenu  
http://laptrinhandroid.vn/viewpager-trong-android/  
https://developers.google.com/places/web-service/details  
https://developers.google.com/maps/documentation/android-sdk/map-with-marker  
https://www.dev2qa.com/how-to-get-real-file-path-from-android-uri/  
