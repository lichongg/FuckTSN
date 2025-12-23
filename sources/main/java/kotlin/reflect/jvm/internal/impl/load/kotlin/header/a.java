package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.tencent.open.SocialConstants;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.load.java.i0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.x;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a implements x.c {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f45925j;

    /* renamed from: k, reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.b, KotlinClassHeader.Kind> f45926k;

    /* renamed from: a, reason: collision with root package name */
    private int[] f45927a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f45928b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f45929c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f45930d = null;

    /* renamed from: e, reason: collision with root package name */
    private String[] f45931e = null;

    /* renamed from: f, reason: collision with root package name */
    private String[] f45932f = null;

    /* renamed from: g, reason: collision with root package name */
    private String[] f45933g = null;

    /* renamed from: h, reason: collision with root package name */
    private KotlinClassHeader.Kind f45934h = null;

    /* renamed from: i, reason: collision with root package name */
    private String[] f45935i = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class b implements x.b {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f45936a = new ArrayList();

        private static /* synthetic */ void e(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i6 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i6 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i6 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i6 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        protected abstract void f(@NotNull String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
        public void a(@Nullable Object obj) {
            if (obj instanceof String) {
                this.f45936a.add((String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
        @Nullable
        public x.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
            if (bVar != null) {
                return null;
            }
            e(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
        public void c(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull f fVar) {
            if (bVar == null) {
                e(0);
            }
            if (fVar == null) {
                e(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
        public void d(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar) {
            if (fVar == null) {
                e(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.b
        public void visitEnd() {
            f((String[]) this.f45936a.toArray(new String[0]));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements x.a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$c$a, reason: collision with other inner class name */
        class C0896a extends b {
            private static /* synthetic */ void e(int i6) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
            }

            C0896a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f45931e = strArr;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b extends b {
            private static /* synthetic */ void e(int i6) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
            }

            b() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f45932f = strArr;
            }
        }

        private c() {
        }

        private static /* synthetic */ void f(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "enumClassId";
            } else if (i6 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i6 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i6 == 1 || i6 == 2) {
                objArr[2] = "visitEnum";
            } else if (i6 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.b e(@Nullable f fVar) {
            String b6 = fVar != null ? fVar.b() : null;
            if ("d1".equals(b6)) {
                return g();
            }
            if ("d2".equals(b6)) {
                return h();
            }
            return null;
        }

        @NotNull
        private x.b g() {
            return new C0896a();
        }

        @NotNull
        private x.b h() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void a(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull f fVar2) {
            if (bVar == null) {
                f(1);
            }
            if (fVar2 == null) {
                f(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.a b(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void c(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar2 == null) {
                f(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void d(@Nullable f fVar, @Nullable Object obj) {
            if (fVar == null) {
                return;
            }
            String b6 = fVar.b();
            if ("k".equals(b6)) {
                if (obj instanceof Integer) {
                    a.this.f45934h = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(b6)) {
                if (obj instanceof int[]) {
                    a.this.f45927a = (int[]) obj;
                    return;
                }
                return;
            }
            if ("xs".equals(b6)) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.isEmpty()) {
                        return;
                    }
                    a.this.f45928b = str;
                    return;
                }
                return;
            }
            if ("xi".equals(b6)) {
                if (obj instanceof Integer) {
                    a.this.f45929c = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(b6) && (obj instanceof String)) {
                String str2 = (String) obj;
                if (str2.isEmpty()) {
                    return;
                }
                a.this.f45930d = str2;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void visitEnd() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d implements x.a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$d$a, reason: collision with other inner class name */
        class C0897a extends b {
            private static /* synthetic */ void e(int i6) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
            }

            C0897a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f45935i = strArr;
            }
        }

        private d() {
        }

        private static /* synthetic */ void f(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "enumClassId";
            } else if (i6 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i6 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i6 == 1 || i6 == 2) {
                objArr[2] = "visitEnum";
            } else if (i6 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.b e(@Nullable f fVar) {
            if ("b".equals(fVar != null ? fVar.b() : null)) {
                return g();
            }
            return null;
        }

        @NotNull
        private x.b g() {
            return new C0897a();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void a(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull f fVar2) {
            if (bVar == null) {
                f(1);
            }
            if (fVar2 == null) {
                f(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.a b(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void c(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar2 == null) {
                f(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void d(@Nullable f fVar, @Nullable Object obj) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e implements x.a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.header.a$e$a, reason: collision with other inner class name */
        class C0898a extends b {
            private static /* synthetic */ void e(int i6) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
            }

            C0898a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f45931e = strArr;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b extends b {
            private static /* synthetic */ void e(int i6) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
            }

            b() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.a.b
            protected void f(@NotNull String[] strArr) {
                if (strArr == null) {
                    e(0);
                }
                a.this.f45932f = strArr;
            }
        }

        private e() {
        }

        private static /* synthetic */ void f(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "enumClassId";
            } else if (i6 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i6 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i6 == 1 || i6 == 2) {
                objArr[2] = "visitEnum";
            } else if (i6 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.b e(@Nullable f fVar) {
            String b6 = fVar != null ? fVar.b() : null;
            if ("data".equals(b6) || "filePartClassNames".equals(b6)) {
                return g();
            }
            if ("strings".equals(b6)) {
                return h();
            }
            return null;
        }

        @NotNull
        private x.b g() {
            return new C0898a();
        }

        @NotNull
        private x.b h() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void a(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull f fVar2) {
            if (bVar == null) {
                f(1);
            }
            if (fVar2 == null) {
                f(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        @Nullable
        public x.a b(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.b bVar) {
            if (bVar != null) {
                return null;
            }
            f(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void c(@Nullable f fVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.f fVar2) {
            if (fVar2 == null) {
                f(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void d(@Nullable f fVar, @Nullable Object obj) {
            if (fVar == null) {
                return;
            }
            String b6 = fVar.b();
            if ("version".equals(b6)) {
                if (obj instanceof int[]) {
                    a.this.f45927a = (int[]) obj;
                }
            } else if ("multifileClassName".equals(b6)) {
                a.this.f45928b = obj instanceof String ? (String) obj : null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.a
        public void visitEnd() {
        }
    }

    private static /* synthetic */ void c(int i6) {
        Object[] objArr = new Object[3];
        if (i6 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = SocialConstants.PARAM_SOURCE;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        try {
            f45925j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        } catch (AccessControlException unused) {
            f45925j = false;
        }
        HashMap hashMap = new HashMap();
        f45926k = hashMap;
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.k(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.k(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.k(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.k(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(kotlin.reflect.jvm.internal.impl.name.b.k(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private boolean n() {
        KotlinClassHeader.Kind kind = this.f45934h;
        return kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
    @Nullable
    public x.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull e1 e1Var) {
        KotlinClassHeader.Kind kind;
        if (bVar == null) {
            c(0);
        }
        if (e1Var == null) {
            c(1);
        }
        kotlin.reflect.jvm.internal.impl.name.c a6 = bVar.a();
        if (a6.equals(i0.f45446a)) {
            return new c();
        }
        if (a6.equals(i0.f45465t)) {
            return new d();
        }
        if (f45925j || this.f45934h != null || (kind = f45926k.get(bVar)) == null) {
            return null;
        }
        this.f45934h = kind;
        return new e();
    }

    @Nullable
    public KotlinClassHeader l(kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar) {
        if (this.f45934h == null || this.f45927a == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar2 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.c(this.f45927a, (this.f45929c & 8) != 0);
        if (!cVar2.h(cVar)) {
            this.f45933g = this.f45931e;
            this.f45931e = null;
        } else if (n() && this.f45931e == null) {
            return null;
        }
        String[] strArr = this.f45935i;
        return new KotlinClassHeader(this.f45934h, cVar2, this.f45931e, this.f45933g, this.f45932f, this.f45928b, this.f45929c, this.f45930d, strArr != null ? kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.a.e(strArr) : null);
    }

    @Nullable
    public KotlinClassHeader m() {
        return l(kotlin.reflect.jvm.internal.impl.metadata.deserialization.c.f46236i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.x.c
    public void visitEnd() {
    }
}
