package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i extends a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<k> f46775b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public i(@NotNull Function0<? extends k> getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        g0.p(getScope, "getScope");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ i(kotlin.reflect.jvm.internal.impl.storage.n r1, kotlin.jvm.functions.Function0 r2, int r3, kotlin.jvm.internal.v r4) {
        /*
            r0 = this;
            r3 = r3 & 1
            if (r3 == 0) goto Lb
            kotlin.reflect.jvm.internal.impl.storage.n r1 = kotlin.reflect.jvm.internal.impl.storage.f.f47092e
            java.lang.String r3 = "NO_LOCKS"
            kotlin.jvm.internal.g0.o(r1, r3)
        Lb:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.i.<init>(kotlin.reflect.jvm.internal.impl.storage.n, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.v):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.a
    @NotNull
    protected k j() {
        return this.f46775b.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k l(Function0 function0) {
        k kVar = (k) function0.invoke();
        if (kVar instanceof a) {
            return ((a) kVar).i();
        }
        return kVar;
    }

    @JvmOverloads
    public i(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull Function0<? extends k> getScope) {
        g0.p(storageManager, "storageManager");
        g0.p(getScope, "getScope");
        this.f46775b = storageManager.e(new h(getScope));
    }
}
