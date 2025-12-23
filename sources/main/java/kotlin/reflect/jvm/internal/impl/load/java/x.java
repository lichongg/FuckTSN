package kotlin.reflect.jvm.internal.impl.load.java;

import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.v1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s3.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s f45855a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s f45856b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.descriptors.s f45857c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<v1, kotlin.reflect.jvm.internal.impl.descriptors.s> f45858d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends kotlin.reflect.jvm.internal.impl.descriptors.p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = Constants.FROM;
            } else if (i6 == 2) {
                objArr[0] = "fromPackage";
            } else if (i6 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "myPackage";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            if (i6 == 2 || i6 == 3) {
                objArr[2] = "visibleFromPackage";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return x.d(oVar, kVar);
        }

        a(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends kotlin.reflect.jvm.internal.impl.descriptors.p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return x.e(hVar, oVar, kVar);
        }

        b(v1 v1Var) {
            super(v1Var);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends kotlin.reflect.jvm.internal.impl.descriptors.p {
        private static /* synthetic */ void g(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = Constants.FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.s
        public boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, boolean z5) {
            if (oVar == null) {
                g(0);
            }
            if (kVar == null) {
                g(1);
            }
            return x.e(hVar, oVar, kVar);
        }

        c(v1 v1Var) {
            super(v1Var);
        }
    }

    private static /* synthetic */ void a(int i6) {
        String str = (i6 == 5 || i6 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 5 || i6 == 6) ? 2 : 3];
        switch (i6) {
            case 1:
                objArr[0] = Constants.FROM;
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i6 == 5 || i6 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i6 == 2 || i6 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i6 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i6 != 5 && i6 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i6 != 5 && i6 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(@Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.o oVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (oVar == null) {
            a(0);
        }
        if (kVar == null) {
            a(1);
        }
        if (d(kotlin.reflect.jvm.internal.impl.resolve.i.M(oVar), kVar)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.r.f44946c.e(hVar, oVar, kVar, false);
    }

    static {
        a aVar = new a(a.C1081a.f54598c);
        f45855a = aVar;
        b bVar = new b(a.c.f54600c);
        f45856b = bVar;
        c cVar = new c(a.b.f54599c);
        f45857c = cVar;
        f45858d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        if (kVar == null) {
            a(2);
        }
        if (kVar2 == null) {
            a(3);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var = (kotlin.reflect.jvm.internal.impl.descriptors.l0) kotlin.reflect.jvm.internal.impl.resolve.i.r(kVar, kotlin.reflect.jvm.internal.impl.descriptors.l0.class, false);
        kotlin.reflect.jvm.internal.impl.descriptors.l0 l0Var2 = (kotlin.reflect.jvm.internal.impl.descriptors.l0) kotlin.reflect.jvm.internal.impl.resolve.i.r(kVar2, kotlin.reflect.jvm.internal.impl.descriptors.l0.class, false);
        return (l0Var2 == null || l0Var == null || !l0Var.d().equals(l0Var2.d())) ? false : true;
    }

    private static void f(kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        f45858d.put(sVar.b(), sVar);
    }

    @NotNull
    public static kotlin.reflect.jvm.internal.impl.descriptors.s g(@NotNull v1 v1Var) {
        if (v1Var == null) {
            a(4);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = f45858d.get(v1Var);
        if (sVar != null) {
            return sVar;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.s j6 = kotlin.reflect.jvm.internal.impl.descriptors.r.j(v1Var);
        if (j6 == null) {
            a(5);
        }
        return j6;
    }
}
