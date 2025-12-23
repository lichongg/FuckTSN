package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class ComponentRuntime$$Lambda$1 implements Provider {
    private final ComponentRuntime arg$1;
    private final Component arg$2;

    public static Provider lambdaFactory$(ComponentRuntime componentRuntime, Component component) {
        return new ComponentRuntime$$Lambda$1(componentRuntime, component);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return ComponentRuntime.lambda$discoverComponents$0(this.arg$1, this.arg$2);
    }

    private ComponentRuntime$$Lambda$1(ComponentRuntime componentRuntime, Component component) {
        this.arg$1 = componentRuntime;
        this.arg$2 = component;
    }
}
