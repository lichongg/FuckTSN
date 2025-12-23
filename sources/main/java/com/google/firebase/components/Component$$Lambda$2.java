package com.google.firebase.components;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final /* synthetic */ class Component$$Lambda$2 implements ComponentFactory {
    private final Object arg$1;

    public static ComponentFactory lambdaFactory$(Object obj) {
        return new Component$$Lambda$2(obj);
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(ComponentContainer componentContainer) {
        return Component.lambda$of$1(this.arg$1, componentContainer);
    }

    private Component$$Lambda$2(Object obj) {
        this.arg$1 = obj;
    }
}
