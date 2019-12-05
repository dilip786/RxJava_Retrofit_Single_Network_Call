### RxJava Single

This is simpler version of an Observable. Singles work almost exactly the same as Observables. But instead of there being an ```onCompleted()```, ```onNext()```, and ```onError()```, there are only two callbacks: ```onSuccess()``` and ```onError()```.

Code Setup

```
val apiService = ApiClient.client!!.create(ApiInterface::class.java)

        apiService.getWeatherReport(apiKey, "$latitude,$longitude").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<WeatherResponseDO> {
                override fun onSuccess(t: WeatherResponseDO) {
                    view.onSuccess(countryName, t)
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    view.onFailure(e.message)
                }
            })
```

Instead of using an Observer, we’re using a class called ```SingleObserver```. It’s very similar to an Observer except that it just has the two methods we mentioned above: ```onSuccess() ``` and ``` onError()```. A ``` SingleObserver ``` is to a Single what an Observer is to an Observable

### Output

<p align="left">
  <img src="https://user-images.githubusercontent.com/10658016/66260067-413ccf80-e7d7-11e9-9363-9a1e7e0f0370.gif?raw=true" alt="Home Page" width="300"/>
</p>
