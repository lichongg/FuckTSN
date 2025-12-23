package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends kotlin.reflect.jvm.internal.impl.resolve.scopes.f {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final C0875a f44459e = new C0875a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f44460f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.jvm.a$a, reason: collision with other inner class name */
    public static final class C0875a {
        public /* synthetic */ C0875a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private C0875a() {
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.f a() {
            return a.f44460f;
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h("clone");
        g0.o(h6, "identifier(...)");
        f44460f = h6;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingClass) {
        super(storageManager, containingClass);
        g0.p(storageManager, "storageManager");
        g0.p(containingClass, "containingClass");
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.f
    @NotNull
    protected List<y> k() {
        o0 g12 = o0.g1(n(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b(), f44460f, CallableMemberDescriptor.Kind.DECLARATION, e1.f44683a);
        g12.M0(null, n().V(), f0.J(), f0.J(), f0.J(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(n()).i(), Modality.OPEN, kotlin.reflect.jvm.internal.impl.descriptors.r.f44946c);
        return f0.l(g12);
    }
}
