package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.util.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a0 implements f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f47382a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends a0 {

        /* renamed from: b, reason: collision with root package name */
        private final int f47383b;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "must have at least "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " value parameter"
                r0.append(r1)
                r1 = 1
                if (r3 <= r1) goto L18
                java.lang.String r1 = "s"
                goto L1a
            L18:
                java.lang.String r1 = ""
            L1a:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2.<init>(r0, r1)
                r2.f47383b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.a0.a.<init>(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
            g0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.g().size() >= this.f47383b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends a0 {

        /* renamed from: b, reason: collision with root package name */
        private final int f47384b;

        public b(int i6) {
            super("must have exactly " + i6 + " value parameters", null);
            this.f47384b = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
            g0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.g().size() == this.f47384b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends a0 {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f47385b = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
            g0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.g().isEmpty();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends a0 {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final d f47386b = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.f
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
            g0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.g().size() == 1;
        }
    }

    public /* synthetic */ a0(String str, kotlin.jvm.internal.v vVar) {
        this(str);
    }

    private a0(String str) {
        this.f47382a = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @NotNull
    public String getDescription() {
        return this.f47382a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @Nullable
    public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        return f.a.a(this, yVar);
    }
}
