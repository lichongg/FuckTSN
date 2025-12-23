package com.trello.rxlifecycle2;

import io.reactivex.Completable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    static final Function<Throwable, Boolean> f40697a = new C0817a();

    /* renamed from: b, reason: collision with root package name */
    static final Predicate<Boolean> f40698b = new b();

    /* renamed from: c, reason: collision with root package name */
    static final Function<Object, Completable> f40699c = new c();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.trello.rxlifecycle2.a$a, reason: collision with other inner class name */
    static class C0817a implements Function<Throwable, Boolean> {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Throwable th) throws Exception {
            if (th instanceof OutsideLifecycleException) {
                return Boolean.TRUE;
            }
            Exceptions.propagate(th);
            return Boolean.FALSE;
        }

        C0817a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements Function<Object, Completable> {
        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Completable apply(Object obj) throws Exception {
            return Completable.error(new CancellationException());
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements Predicate<Boolean> {
        b() {
        }

        @Override // io.reactivex.functions.Predicate
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) throws Exception {
            return bool.booleanValue();
        }
    }

    private a() {
        throw new AssertionError("No instances!");
    }
}
