package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class ComponentRuntime$$Lambda$3 implements Runnable {
    private final OptionalProvider arg$1;
    private final Provider arg$2;

    public static Runnable lambdaFactory$(OptionalProvider optionalProvider, Provider provider) {
        return new ComponentRuntime$$Lambda$3(optionalProvider, provider);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.arg$1.set(this.arg$2);
    }

    private ComponentRuntime$$Lambda$3(OptionalProvider optionalProvider, Provider provider) {
        this.arg$1 = optionalProvider;
        this.arg$2 = provider;
    }
}
