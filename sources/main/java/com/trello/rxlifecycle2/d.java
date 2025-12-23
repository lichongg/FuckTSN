package com.trello.rxlifecycle2;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<R> implements Predicate<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f40729a;

        a(Object obj) {
            this.f40729a = obj;
        }

        @Override // io.reactivex.functions.Predicate
        public boolean test(R r5) throws Exception {
            return r5.equals(this.f40729a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<R> implements BiFunction<R, R, Boolean> {
        b() {
        }

        @Override // io.reactivex.functions.BiFunction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(R r5, R r6) throws Exception {
            return Boolean.valueOf(r6.equals(r5));
        }
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> a(@Nonnull Observable<R> observable) {
        return new c<>(observable);
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> b(@Nonnull Observable<R> observable, @Nonnull Function<R, R> function) {
        a3.a.a(observable, "lifecycle == null");
        a3.a.a(function, "correspondingEvents == null");
        return a(d(observable.share(), function));
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> c<T> c(@Nonnull Observable<R> observable, @Nonnull R r5) {
        a3.a.a(observable, "lifecycle == null");
        a3.a.a(r5, "event == null");
        return a(e(observable, r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R> Observable<Boolean> d(Observable<R> observable, Function<R, R> function) {
        return Observable.combineLatest(observable.take(1L).map(function), observable.skip(1L), new b()).onErrorReturn(com.trello.rxlifecycle2.a.f40697a).filter(com.trello.rxlifecycle2.a.f40698b);
    }

    private static <R> Observable<R> e(Observable<R> observable, R r5) {
        return observable.filter(new a(r5));
    }

    private d() {
        throw new AssertionError("No instances");
    }
}
