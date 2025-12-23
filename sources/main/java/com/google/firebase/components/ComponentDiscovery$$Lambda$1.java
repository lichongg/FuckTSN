package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class ComponentDiscovery$$Lambda$1 implements Provider {
    private final String arg$1;

    public static Provider lambdaFactory$(String str) {
        return new ComponentDiscovery$$Lambda$1(str);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        ComponentRegistrar instantiate;
        instantiate = ComponentDiscovery.instantiate(this.arg$1);
        return instantiate;
    }

    private ComponentDiscovery$$Lambda$1(String str) {
        this.arg$1 = str;
    }
}
