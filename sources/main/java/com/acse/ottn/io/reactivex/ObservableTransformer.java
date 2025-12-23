package com.acse.ottn.io.reactivex;

import com.acse.ottn.io.reactivex.annotations.NonNull;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface ObservableTransformer<Upstream, Downstream> extends e.c<Upstream, Downstream> {
    @NonNull
    e<Downstream> apply(@NonNull e<Upstream> eVar);

    @Override // rx.functions.p
    /* bridge */ /* synthetic */ Object call(Object obj);

    e<Downstream> call(e<Upstream> eVar);
}
