package l3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.s;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "JvmClassMappingKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @NotNull
    public static final <T extends Annotation> d<? extends T> a(@NotNull T t5) {
        g0.p(t5, "<this>");
        Class<? extends Annotation> annotationType = t5.annotationType();
        g0.o(annotationType, "annotationType(...)");
        d<? extends T> i6 = i(annotationType);
        g0.n(i6, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return i6;
    }

    private static final <E extends Enum<E>> Class<E> b(Enum<E> r12) {
        g0.p(r12, "<this>");
        Class<E> declaringClass = r12.getDeclaringClass();
        g0.o(declaringClass, "getDeclaringClass(...)");
        return declaringClass;
    }

    @NotNull
    public static final <T> Class<T> d(@NotNull T t5) {
        g0.p(t5, "<this>");
        Class<T> cls = (Class<T>) t5.getClass();
        g0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    @JvmName(name = "getJavaClass")
    @NotNull
    public static final <T> Class<T> e(@NotNull d<T> dVar) {
        g0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((s) dVar).c();
        g0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @NotNull
    public static final <T> Class<T> g(@NotNull d<T> dVar) {
        g0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((s) dVar).c();
        if (!cls.isPrimitive()) {
            g0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    cls = (Class<T>) Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    cls = (Class<T>) Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    cls = (Class<T>) Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                    break;
                }
                break;
        }
        g0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    @Nullable
    public static final <T> Class<T> h(@NotNull d<T> dVar) {
        g0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((s) dVar).c();
        if (cls.isPrimitive()) {
            g0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    @JvmName(name = "getKotlinClass")
    @NotNull
    public static final <T> d<T> i(@NotNull Class<T> cls) {
        g0.p(cls, "<this>");
        return o0.d(cls);
    }

    @JvmName(name = "getRuntimeClassOfKClassInstance")
    @NotNull
    public static final <T> Class<d<T>> j(@NotNull d<T> dVar) {
        g0.p(dVar, "<this>");
        Class<d<T>> cls = (Class<d<T>>) dVar.getClass();
        g0.n(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    public static final /* synthetic */ boolean l(Object[] objArr) {
        g0.p(objArr, "<this>");
        g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    @SinceKotlin(version = "1.7")
    @InlineOnly
    public static /* synthetic */ void c(Enum r02) {
    }

    public static /* synthetic */ void f(d dVar) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void k(d dVar) {
    }
}
