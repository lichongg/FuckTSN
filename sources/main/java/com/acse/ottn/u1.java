package com.acse.ottn;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class u1<T> extends g3<T, Integer> {
    public abstract void a(T t5, int i6);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.acse.ottn.g3
    public /* bridge */ /* synthetic */ void a(Object obj, Integer num) {
        a2((u1<T>) obj, num);
    }

    public u1(String str) {
        super(Integer.class, str);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public final void a2(T t5, Integer num) {
        num.intValue();
        a2((u1<T>) t5, num);
    }
}
