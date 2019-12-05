### RxJava Single

This is simpler version of an Observable. Singles work almost exactly the same as Observables. But instead of there being an ```onCompleted()```, ```onNext()```, and ```onError()```, there are only two callbacks: ```onSuccess()``` and ```onError()```.

Code Setup

```

Make sure you require Internet permission in your manifest file.

<uses-permission android:name="android.permission.INTERNET" />

We need following dependencies for this project. Add the lines below to your app/build.gradle in your app project under dependencies.

def rxjava_version ="2.1.8"
def rxandroid_version = "2.0.1"
def retrofit_version ="2.0.2"
def gson_version ="2.6.2"
def retrofit_adapter ="1.0.0"

dependencies 
{
	// Retrofit, Gson
	implementation "com.google.code.gson:gson:$gson_version"
	implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
	implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
	implementation "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:$retrofit_adapter"

	// RxJava2
	implementation "io.reactivex.rxjava2:rxjava:$rxjava_version"
	implementation "io.reactivex.rxjava2:rxandroid:$rxandroid_version"
}

```

```
val apiService = ApiClient.client!!.create(ApiInterface::class.java)

        apiService.getWeatherReport(apiKey, "$latitude,$longitude").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<WeatherResponseDO> {
                override fun onSuccess(t: WeatherResponseDO) {
                    // Success case
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    // Failure case
                }
            })
```

Instead of using an Observer, we’re using a class called ```SingleObserver```. It’s very similar to an Observer except that it just has the two methods we mentioned above: ```onSuccess() ``` and ``` onError()```. A ``` SingleObserver ``` is to a Single what an Observer is to an Observable

### Output

<p align="left">
  <img src="https://user-images.githubusercontent.com/10658016/66260067-413ccf80-e7d7-11e9-9363-9a1e7e0f0370.gif?raw=true" alt="Home Page" width="300"/>
</p>
