package kotlin.reflect.jvm.internal.impl.load.java;

import com.acse.ottn.l3;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\npropertiesConventionUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 propertiesConventionUtil.kt\norg/jetbrains/kotlin/load/java/PropertiesConventionUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n774#2:103\n865#2,2:104\n*S KotlinDebug\n*F\n+ 1 propertiesConventionUtil.kt\norg/jetbrains/kotlin/load/java/PropertiesConventionUtilKt\n*L\n90#1:103\n90#1:104,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n0 {
    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.f> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.g0.p(name, "name");
        String b6 = name.b();
        kotlin.jvm.internal.g0.o(b6, "asString(...)");
        return h0.c(b6) ? kotlin.collections.f0.R(b(name)) : h0.d(b6) ? f(name) : i.f45440a.b(name);
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.f b(@NotNull kotlin.reflect.jvm.internal.impl.name.f methodName) {
        kotlin.jvm.internal.g0.p(methodName, "methodName");
        kotlin.reflect.jvm.internal.impl.name.f e6 = e(methodName, l3.f4736f, false, null, 12, null);
        return e6 == null ? e(methodName, "is", false, null, 8, null) : e6;
    }

    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.name.f c(@NotNull kotlin.reflect.jvm.internal.impl.name.f methodName, boolean z5) {
        kotlin.jvm.internal.g0.p(methodName, "methodName");
        return e(methodName, l3.f4738h, false, z5 ? "is" : null, 4, null);
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f e(kotlin.reflect.jvm.internal.impl.name.f fVar, String str, boolean z5, String str2, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = true;
        }
        if ((i6 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z5, str2);
    }

    @NotNull
    public static final List<kotlin.reflect.jvm.internal.impl.name.f> f(@NotNull kotlin.reflect.jvm.internal.impl.name.f methodName) {
        kotlin.jvm.internal.g0.p(methodName, "methodName");
        return kotlin.collections.f0.S(c(methodName, false), c(methodName, true));
    }

    private static final kotlin.reflect.jvm.internal.impl.name.f d(kotlin.reflect.jvm.internal.impl.name.f fVar, String str, boolean z5, String str2) {
        if (fVar.i()) {
            return null;
        }
        String identifier = fVar.getIdentifier();
        kotlin.jvm.internal.g0.o(identifier, "getIdentifier(...)");
        if (!kotlin.text.u.H2(identifier, str, false, 2, null) || identifier.length() == str.length()) {
            return null;
        }
        char charAt = identifier.charAt(str.length());
        if ('a' <= charAt && charAt < '{') {
            return null;
        }
        if (str2 != null) {
            return kotlin.reflect.jvm.internal.impl.name.f.h(str2 + kotlin.text.u.v4(identifier, str));
        }
        if (!z5) {
            return fVar;
        }
        String c6 = f4.a.c(kotlin.text.u.v4(identifier, str), true);
        if (!kotlin.reflect.jvm.internal.impl.name.f.j(c6)) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.name.f.h(c6);
    }
}
