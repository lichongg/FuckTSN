package s3;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.u1;
import kotlin.reflect.jvm.internal.impl.descriptors.v1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f54597a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: s3.a$a, reason: collision with other inner class name */
    public static final class C1081a extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final C1081a f54598c = new C1081a();

        private C1081a() {
            super(WiseOpenHianalyticsData.UNION_PACKAGE, false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @Nullable
        public Integer a(@NotNull v1 visibility) {
            g0.p(visibility, "visibility");
            if (this == visibility) {
                return 0;
            }
            return u1.f45044a.b(visibility) ? 1 : -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @NotNull
        public String b() {
            return "public/*package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @NotNull
        public v1 d() {
            return u1.g.f45053c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final b f54599c = new b();

        private b() {
            super("protected_and_package", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @Nullable
        public Integer a(@NotNull v1 visibility) {
            g0.p(visibility, "visibility");
            if (g0.g(this, visibility)) {
                return 0;
            }
            if (visibility == u1.b.f45048c) {
                return null;
            }
            return u1.f45044a.b(visibility) ? 1 : -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @NotNull
        public String b() {
            return "protected/*protected and package*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @NotNull
        public v1 d() {
            return u1.g.f45053c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends v1 {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final c f54600c = new c();

        private c() {
            super("protected_static", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @NotNull
        public String b() {
            return "protected/*protected static*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.v1
        @NotNull
        public v1 d() {
            return u1.g.f45053c;
        }
    }

    private a() {
    }
}
