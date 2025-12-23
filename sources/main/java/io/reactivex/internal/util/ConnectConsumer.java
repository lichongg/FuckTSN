package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable disposable;

    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) throws Exception {
        this.disposable = disposable;
    }
}
