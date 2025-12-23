package com.acse.ottn.io.reactivex.functions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class TryCatchConsumer<T> implements Consumer<T> {
    Consumer<T> consumer;

    @Override // com.acse.ottn.io.reactivex.functions.Consumer
    public void accept(T t5) throws Exception {
        this.consumer.accept(t5);
    }

    public TryCatchConsumer(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
    public /* synthetic */ void call(Object obj) {
        c.a(this, obj);
    }
}
