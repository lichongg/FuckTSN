package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.util.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class k implements f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f47408a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends k {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final a f47409b = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
            g0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.c0() != null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends k {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f47410b = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
            g0.p(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.c0() == null && functionDescriptor.f0() == null) ? false : true;
        }
    }

    public /* synthetic */ k(String str, kotlin.jvm.internal.v vVar) {
        this(str);
    }

    private k(String str) {
        this.f47408a = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @NotNull
    public String getDescription() {
        return this.f47408a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @Nullable
    public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        return f.a.a(this, yVar);
    }
}
