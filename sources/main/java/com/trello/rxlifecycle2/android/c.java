package com.trello.rxlifecycle2.android;

import android.view.View;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class c implements ObservableOnSubscribe<Object> {

    /* renamed from: b, reason: collision with root package name */
    static final Object f40710b = new Object();

    /* renamed from: a, reason: collision with root package name */
    final View f40711a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends MainThreadDisposable implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final ObservableEmitter<Object> f40712a;

        public a(ObservableEmitter<Object> observableEmitter) {
            this.f40712a = observableEmitter;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void onDispose() {
            c.this.f40711a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f40712a.onNext(c.f40710b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }
    }

    public c(View view) {
        this.f40711a = view;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
        MainThreadDisposable.verifyMainThread();
        a aVar = new a(observableEmitter);
        observableEmitter.setDisposable(aVar);
        this.f40711a.addOnAttachStateChangeListener(aVar);
    }
}
