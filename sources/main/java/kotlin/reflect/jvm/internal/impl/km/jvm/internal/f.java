package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.km.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.i {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f45228c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.km.internal.extensions.f f45229d = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.f(o0.d(f.class));

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<s> f45230a = new ArrayList(0);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private String f45231b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    @NotNull
    public final List<s> a() {
        return this.f45230a;
    }

    @Nullable
    public final String b() {
        return this.f45231b;
    }

    public final void c(@Nullable String str) {
        this.f45231b = str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.e
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.f getType() {
        return f45229d;
    }
}
