package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SingleEquals<T> extends Single<Boolean> {
    final SingleSource<? extends T> first;
    final SingleSource<? extends T> second;

    @Override // io.reactivex.Single
    protected void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        this.first.subscribe(new SingleObserver<T>(0, compositeDisposable, objArr, atomicInteger, singleObserver) { // from class: io.reactivex.internal.operators.single.SingleEquals.1InnerObserver
            final int index;
            final /* synthetic */ AtomicInteger val$count;
            final /* synthetic */ SingleObserver val$s;
            final /* synthetic */ CompositeDisposable val$set;
            final /* synthetic */ Object[] val$values;

            {
                this.val$set = compositeDisposable;
                this.val$values = objArr;
                this.val$count = atomicInteger;
                this.val$s = singleObserver;
                this.index = r2;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                int i6;
                do {
                    i6 = this.val$count.get();
                    if (i6 >= 2) {
                        RxJavaPlugins.onError(th);
                        return;
                    }
                } while (!this.val$count.compareAndSet(i6, 2));
                this.val$set.dispose();
                this.val$s.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                this.val$set.add(disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t5) {
                this.val$values[this.index] = t5;
                if (this.val$count.incrementAndGet() == 2) {
                    SingleObserver singleObserver2 = this.val$s;
                    Object[] objArr2 = this.val$values;
                    singleObserver2.onSuccess(Boolean.valueOf(ObjectHelper.equals(objArr2[0], objArr2[1])));
                }
            }
        });
        this.second.subscribe(new SingleObserver<T>(1, compositeDisposable, objArr, atomicInteger, singleObserver) { // from class: io.reactivex.internal.operators.single.SingleEquals.1InnerObserver
            final int index;
            final /* synthetic */ AtomicInteger val$count;
            final /* synthetic */ SingleObserver val$s;
            final /* synthetic */ CompositeDisposable val$set;
            final /* synthetic */ Object[] val$values;

            {
                this.val$set = compositeDisposable;
                this.val$values = objArr;
                this.val$count = atomicInteger;
                this.val$s = singleObserver;
                this.index = r2;
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                int i6;
                do {
                    i6 = this.val$count.get();
                    if (i6 >= 2) {
                        RxJavaPlugins.onError(th);
                        return;
                    }
                } while (!this.val$count.compareAndSet(i6, 2));
                this.val$set.dispose();
                this.val$s.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSubscribe(Disposable disposable) {
                this.val$set.add(disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(T t5) {
                this.val$values[this.index] = t5;
                if (this.val$count.incrementAndGet() == 2) {
                    SingleObserver singleObserver2 = this.val$s;
                    Object[] objArr2 = this.val$values;
                    singleObserver2.onSuccess(Boolean.valueOf(ObjectHelper.equals(objArr2[0], objArr2[1])));
                }
            }
        });
    }

    public SingleEquals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        this.first = singleSource;
        this.second = singleSource2;
    }
}
