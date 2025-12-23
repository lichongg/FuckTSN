package io.reactivex.internal.observers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onNext(T t5) {
        if (this.value == null) {
            this.value = t5;
            this.f43122d.dispose();
            countDown();
        }
    }
}
