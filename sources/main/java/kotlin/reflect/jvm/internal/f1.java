package kotlin.reflect.jvm.internal;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\Downloads\app\classes8.dex */
class f1 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f44345a;

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int N;
        N = KDeclarationContainerImpl.N(this.f44345a, obj, obj2);
        return N;
    }

    public f1(Function2 function2) {
        this.f44345a = function2;
    }
}
