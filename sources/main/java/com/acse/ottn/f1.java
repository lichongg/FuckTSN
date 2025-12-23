package com.acse.ottn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class f1<T> extends g3<T, Float> {
    public abstract void a(T t5, float f6);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.g3
    public /* bridge */ /* synthetic */ void a(Object obj, Float f6) {
        a2((f1<T>) obj, f6);
    }

    public f1(String str) {
        super(Float.class, str);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public final void a2(T t5, Float f6) {
        a((f1<T>) t5, f6.floatValue());
    }
}
