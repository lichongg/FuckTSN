package io.reactivex.internal.operators.flowable;

import defpackage.H5BaseWebChromeClient;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FlowableScalarXMap {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final T value;

        @Override // io.reactivex.Flowable
        public void subscribeActual(Subscriber<? super R> subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
                if (!(publisher instanceof Callable)) {
                    publisher.subscribe(subscriber);
                    return;
                }
                try {
                    Object call = ((Callable) publisher).call();
                    if (call == null) {
                        EmptySubscription.complete(subscriber);
                    } else {
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptySubscription.error(th, subscriber);
                }
            } catch (Throwable th2) {
                EmptySubscription.error(th2, subscriber);
            }
        }

        ScalarXMapFlowable(T t5, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.value = t5;
            this.mapper = function;
        }
    }

    public static <T, U> Flowable<U> scalarXMap(T t5, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.onAssembly(new ScalarXMapFlowable(t5, function));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (!(publisher instanceof Callable)) {
            return false;
        }
        try {
            H5BaseWebChromeClient h5BaseWebChromeClient = (Object) ((Callable) publisher).call();
            if (h5BaseWebChromeClient == null) {
                EmptySubscription.complete(subscriber);
                return true;
            }
            try {
                Publisher publisher2 = (Publisher) ObjectHelper.requireNonNull(function.apply(h5BaseWebChromeClient), "The mapper returned a null Publisher");
                if (publisher2 instanceof Callable) {
                    try {
                        Object call = ((Callable) publisher2).call();
                        if (call == null) {
                            EmptySubscription.complete(subscriber);
                            return true;
                        }
                        subscriber.onSubscribe(new ScalarSubscription(subscriber, call));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        EmptySubscription.error(th, subscriber);
                        return true;
                    }
                } else {
                    publisher2.subscribe(subscriber);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                EmptySubscription.error(th2, subscriber);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            EmptySubscription.error(th3, subscriber);
            return true;
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }
}
