package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class k implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final PrimitiveType f44541a;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.name.c typeFqName_delegate$lambda$0;
        typeFqName_delegate$lambda$0 = PrimitiveType.typeFqName_delegate$lambda$0(this.f44541a);
        return typeFqName_delegate$lambda$0;
    }

    public k(PrimitiveType primitiveType) {
        this.f44541a = primitiveType;
    }
}
