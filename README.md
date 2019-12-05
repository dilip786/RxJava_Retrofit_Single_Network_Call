### RxJava Single

- This is simpler version of an Observable. Singles work almost exactly the same as Observables. But instead of there being an onCompleted(), onNext(), and onError(), there are only two callbacks: onSuccess() and onError().

Code

// Single Creation

Code

// Single Subscriber creation

- Instead of using an Observer, we’re using a class called SingleSubscriber. It’s very similar to an Observer except that it just has the two methods we mentioned above: onSuccess() and onError(). A SingleSubscriber is to a Single what an Observer is to an Observable
