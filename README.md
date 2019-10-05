# RecyclerView With Images - MVP architecture

  Fetching images from https://pixabay.com and showing on gridview , MVP architecture, Recylerview, Retrofit & Kotlin

![rsz_1mpv_](https://user-images.githubusercontent.com/10658016/65838925-d64a4f00-e325-11e9-84a7-a12611de80cb.png)
![rsz_mvp_1](https://user-images.githubusercontent.com/10658016/65838926-d6e2e580-e325-11e9-863b-66dc1e13a26f.png)


## Dependencies

```
def retrofit_version = "2.6.2";

implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
   
```

# Android MVP Architecture 

<p align="left">
  <img src="https://user-images.githubusercontent.com/10658016/66260242-ac87a100-e7d9-11e9-8548-020ab1255db9.png?raw=true" alt="Home Page" width="300"/>
</p>

* Model: This handles the data part of our application
* Presenter: It acts as a bridge that connects a Model and a View.
* View: This is responsible for laying out views with the relevant data as instructed by the Presenter

### Android MVP Guidelines
* Activity, Fragment and a CustomView act as the View part of the application.
* The Presenter is responsible for listening to user interactions (on the View) and model updates (database, APIs) as well as   updating the Model and the View.
* Interfaces need to be defined and implemented to communicate between View-Presenter and Presenter-Model.
* The View and Model classes can’t have a reference of one another.


