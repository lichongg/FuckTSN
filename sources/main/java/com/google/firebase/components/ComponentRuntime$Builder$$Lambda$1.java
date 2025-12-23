package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class ComponentRuntime$Builder$$Lambda$1 implements Provider {
    private final ComponentRegistrar arg$1;

    public static Provider lambdaFactory$(ComponentRegistrar componentRegistrar) {
        return new ComponentRuntime$Builder$$Lambda$1(componentRegistrar);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.arg$1);
    }

    private ComponentRuntime$Builder$$Lambda$1(ComponentRegistrar componentRegistrar) {
        this.arg$1 = componentRegistrar;
    }
}
