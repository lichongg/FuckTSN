package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;

/* loaded from: D:\Downloads\app\classes8.dex */
class l implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    private final PrimitiveType f44542a;

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        kotlin.reflect.jvm.internal.impl.name.c arrayTypeFqName_delegate$lambda$1;
        arrayTypeFqName_delegate$lambda$1 = PrimitiveType.arrayTypeFqName_delegate$lambda$1(this.f44542a);
        return arrayTypeFqName_delegate$lambda$1;
    }

    public l(PrimitiveType primitiveType) {
        this.f44542a = primitiveType;
    }
}
