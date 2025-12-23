package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class OptionalProvider$$Lambda$4 implements Deferred.DeferredHandler {
    private static final OptionalProvider$$Lambda$4 instance = new OptionalProvider$$Lambda$4();

    private OptionalProvider$$Lambda$4() {
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        OptionalProvider.lambda$static$0(provider);
    }
}
