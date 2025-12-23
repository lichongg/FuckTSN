package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nreflectClassUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 reflectClassUtil.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectClassUtilKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n1563#2:100\n1634#2,3:101\n1563#2:104\n1634#2,3:105\n1573#2:108\n1604#2,4:109\n*S KotlinDebug\n*F\n+ 1 reflectClassUtil.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectClassUtilKt\n*L\n34#1:100\n34#1:101,3\n35#1:104\n35#1:105,3\n50#1:108\n50#1:109,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<kotlin.reflect.d<? extends Object>> f45002a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> f45003b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<Class<? extends Object>, Class<? extends Object>> f45004c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<Class<? extends kotlin.n<?>>, Integer> f45005d;

    static {
        int i6 = 0;
        List<kotlin.reflect.d<? extends Object>> Q = kotlin.collections.f0.Q(o0.d(Boolean.TYPE), o0.d(Byte.TYPE), o0.d(Character.TYPE), o0.d(Double.TYPE), o0.d(Float.TYPE), o0.d(Integer.TYPE), o0.d(Long.TYPE), o0.d(Short.TYPE));
        f45002a = Q;
        List<kotlin.reflect.d<? extends Object>> list = Q;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kotlin.reflect.d dVar = (kotlin.reflect.d) it.next();
            arrayList.add(kotlin.o0.a(l3.a.g(dVar), l3.a.h(dVar)));
        }
        f45003b = i1.B0(arrayList);
        List<kotlin.reflect.d<? extends Object>> list2 = f45002a;
        ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.d dVar2 = (kotlin.reflect.d) it2.next();
            arrayList2.add(kotlin.o0.a(l3.a.h(dVar2), l3.a.g(dVar2)));
        }
        f45004c = i1.B0(arrayList2);
        List Q2 = kotlin.collections.f0.Q(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.f0.d0(Q2, 10));
        for (Object obj : Q2) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            arrayList3.add(kotlin.o0.a((Class) obj, Integer.valueOf(i6)));
            i6 = i7;
        }
        f45005d = i1.B0(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterizedType a(ParameterizedType it) {
        kotlin.jvm.internal.g0.p(it, "it");
        Type ownerType = it.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.sequences.m b(ParameterizedType it) {
        kotlin.jvm.internal.g0.p(it, "it");
        Type[] actualTypeArguments = it.getActualTypeArguments();
        kotlin.jvm.internal.g0.o(actualTypeArguments, "getActualTypeArguments(...)");
        return kotlin.collections.n.T5(actualTypeArguments);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.b e(@NotNull Class<?> cls) {
        kotlin.reflect.jvm.internal.impl.name.b e6;
        kotlin.jvm.internal.g0.p(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            kotlin.jvm.internal.g0.o(simpleName, "getSimpleName(...)");
            if (simpleName.length() != 0) {
                Class<?> declaringClass = cls.getDeclaringClass();
                if (declaringClass != null && (e6 = e(declaringClass)) != null) {
                    kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(cls.getSimpleName());
                    kotlin.jvm.internal.g0.o(h6, "identifier(...)");
                    kotlin.reflect.jvm.internal.impl.name.b d6 = e6.d(h6);
                    if (d6 != null) {
                        return d6;
                    }
                }
                b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
                String name = cls.getName();
                kotlin.jvm.internal.g0.o(name, "getName(...)");
                return aVar.c(new kotlin.reflect.jvm.internal.impl.name.c(name));
            }
        }
        String name2 = cls.getName();
        kotlin.jvm.internal.g0.o(name2, "getName(...)");
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c(name2);
        return new kotlin.reflect.jvm.internal.impl.name.b(cVar.d(), kotlin.reflect.jvm.internal.impl.name.c.f46338c.a(cVar.f()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @NotNull
    public static final String f(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                kotlin.jvm.internal.g0.o(name, "getName(...)");
                return kotlin.text.u.w2(name, '.', '/', false, 4, null);
            }
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            String name2 = cls.getName();
            kotlin.jvm.internal.g0.o(name2, "getName(...)");
            sb.append(kotlin.text.u.w2(name2, '.', '/', false, 4, null));
            sb.append(';');
            return sb.toString();
        }
        String name3 = cls.getName();
        switch (name3.hashCode()) {
            case -1325958191:
                if (name3.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name3.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    return "I";
                }
                break;
            case 3039496:
                if (name3.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name3.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name3.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name3.equals("void")) {
                    return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                }
                break;
            case 64711720:
                if (name3.equals("boolean")) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name3.equals("float")) {
                    return "F";
                }
                break;
            case 109413500:
                if (name3.equals("short")) {
                    return ExifInterface.LATITUDE_SOUTH;
                }
                break;
        }
        throw new IllegalArgumentException("Unsupported primitive type: " + cls);
    }

    @Nullable
    public static final Integer g(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        return f45005d.get(cls);
    }

    @NotNull
    public static final List<Type> h(@NotNull Type type) {
        kotlin.jvm.internal.g0.p(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return kotlin.collections.f0.J();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return kotlin.sequences.p.I3(kotlin.sequences.p.k1(kotlin.sequences.p.t(type, d.f44998a), e.f45000a));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        kotlin.jvm.internal.g0.o(actualTypeArguments, "getActualTypeArguments(...)");
        return kotlin.collections.n.dz(actualTypeArguments);
    }

    @Nullable
    public static final Class<?> i(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        return f45003b.get(cls);
    }

    @NotNull
    public static final ClassLoader j(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        kotlin.jvm.internal.g0.o(systemClassLoader, "getSystemClassLoader(...)");
        return systemClassLoader;
    }

    @Nullable
    public static final Class<?> k(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        return f45004c.get(cls);
    }

    public static final boolean l(@NotNull Class<?> cls) {
        kotlin.jvm.internal.g0.p(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
