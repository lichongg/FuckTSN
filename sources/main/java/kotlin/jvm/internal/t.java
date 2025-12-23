package kotlin.jvm.internal;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.daimajia.numberprogressbar.BuildConfig;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.SinceKotlin;
import kotlin.collections.i1;
import kotlin.jvm.KotlinReflectionNotSupportedError;
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
import kotlin.reflect.KVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,290:1\n1573#2:291\n1604#2,4:292\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n107#1:291\n107#1:292,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t implements kotlin.reflect.d<Object>, s {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f44059b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<Class<? extends kotlin.n<?>>, Integer> f44060c;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f44061a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,290:1\n1#2:291\n*E\n"})
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @Nullable
        public final String b(@NotNull Class<?> jClass) {
            g0.p(jClass, "jClass");
            String str = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String name = jClass.getName();
                g0.o(name, "getName(...)");
                String a6 = a(name);
                return a6 == null ? jClass.getCanonicalName() : a6;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive()) {
                String name2 = componentType.getName();
                g0.o(name2, "getName(...)");
                String a7 = a(name2);
                if (a7 != null) {
                    str = a7 + "Array";
                }
            }
            return str == null ? "kotlin.Array" : str;
        }

        @Nullable
        public final String c(@NotNull Class<?> jClass) {
            g0.p(jClass, "jClass");
            String str = null;
            if (jClass.isAnonymousClass()) {
                return null;
            }
            if (!jClass.isLocalClass()) {
                if (!jClass.isArray()) {
                    String name = jClass.getName();
                    g0.o(name, "getName(...)");
                    String e6 = e(name);
                    return e6 == null ? jClass.getSimpleName() : e6;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive()) {
                    String name2 = componentType.getName();
                    g0.o(name2, "getName(...)");
                    String e7 = e(name2);
                    if (e7 != null) {
                        str = e7 + "Array";
                    }
                }
                return str == null ? "Array" : str;
            }
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                g0.m(simpleName);
                String K5 = kotlin.text.u.K5(simpleName, enclosingMethod.getName() + kotlin.text.v0.f47959c, null, 2, null);
                if (K5 != null) {
                    return K5;
                }
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                g0.m(simpleName);
                return kotlin.text.u.J5(simpleName, kotlin.text.v0.f47959c, null, 2, null);
            }
            g0.m(simpleName);
            return kotlin.text.u.K5(simpleName, enclosingConstructor.getName() + kotlin.text.v0.f47959c, null, 2, null);
        }

        public final boolean d(@Nullable Object obj, @NotNull Class<?> jClass) {
            g0.p(jClass, "jClass");
            Map map = t.f44060c;
            g0.n(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return u0.B(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = l3.a.g(l3.a.i(jClass));
            }
            return jClass.isInstance(obj);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        private final String a(String str) {
            int hashCode = str.hashCode();
            switch (hashCode) {
                case -2061550653:
                    if (!str.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                        return null;
                    }
                    return "kotlin.Double.Companion";
                case -2056817302:
                    if (str.equals("java.lang.Integer")) {
                        return "kotlin.Int";
                    }
                    return null;
                case -2034166429:
                    if (str.equals("java.lang.Cloneable")) {
                        return "kotlin.Cloneable";
                    }
                    return null;
                case -1979556166:
                    if (str.equals("java.lang.annotation.Annotation")) {
                        return "kotlin.Annotation";
                    }
                    return null;
                case -1571515090:
                    if (str.equals("java.lang.Comparable")) {
                        return "kotlin.Comparable";
                    }
                    return null;
                case -1383349348:
                    if (str.equals("java.util.Map")) {
                        return "kotlin.collections.Map";
                    }
                    return null;
                case -1383343454:
                    if (str.equals("java.util.Set")) {
                        return "kotlin.collections.Set";
                    }
                    return null;
                case -1325958191:
                    if (str.equals("double")) {
                        return "kotlin.Double";
                    }
                    return null;
                case -1182275604:
                    if (str.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                        return "kotlin.Byte.Companion";
                    }
                    return null;
                case -1062240117:
                    if (str.equals("java.lang.CharSequence")) {
                        return "kotlin.CharSequence";
                    }
                    return null;
                case -688322466:
                    if (str.equals("java.util.Collection")) {
                        return "kotlin.collections.Collection";
                    }
                    return null;
                case -527879800:
                    if (str.equals("java.lang.Float")) {
                        return "kotlin.Float";
                    }
                    return null;
                case -515992664:
                    if (str.equals("java.lang.Short")) {
                        return "kotlin.Short";
                    }
                    return null;
                case -246476834:
                    if (str.equals("kotlin.jvm.internal.CharCompanionObject")) {
                        return "kotlin.Char.Companion";
                    }
                    return null;
                case -207262728:
                    if (str.equals("kotlin.jvm.internal.LongCompanionObject")) {
                        return "kotlin.Long.Companion";
                    }
                    return null;
                case -165139126:
                    if (str.equals("java.util.Map$Entry")) {
                        return "kotlin.collections.Map.Entry";
                    }
                    return null;
                case 104431:
                    if (str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        return "kotlin.Int";
                    }
                    return null;
                case 3039496:
                    if (str.equals("byte")) {
                        return "kotlin.Byte";
                    }
                    return null;
                case 3052374:
                    if (str.equals("char")) {
                        return "kotlin.Char";
                    }
                    return null;
                case 3327612:
                    if (str.equals("long")) {
                        return "kotlin.Long";
                    }
                    return null;
                case 64711720:
                    if (str.equals("boolean")) {
                        return "kotlin.Boolean";
                    }
                    return null;
                case 65821278:
                    if (str.equals("java.util.List")) {
                        return "kotlin.collections.List";
                    }
                    return null;
                case 77230534:
                    if (str.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                        return "kotlin.Short.Companion";
                    }
                    return null;
                case 97526364:
                    if (str.equals("float")) {
                        return "kotlin.Float";
                    }
                    return null;
                case 109413500:
                    if (str.equals("short")) {
                        return "kotlin.Short";
                    }
                    return null;
                case 155276373:
                    if (str.equals("java.lang.Character")) {
                        return "kotlin.Char";
                    }
                    return null;
                case 226173651:
                    if (str.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                        return "kotlin.Enum.Companion";
                    }
                    return null;
                case 344809556:
                    if (str.equals("java.lang.Boolean")) {
                        return "kotlin.Boolean";
                    }
                    return null;
                case 398507100:
                    if (str.equals("java.lang.Byte")) {
                        return "kotlin.Byte";
                    }
                    return null;
                case 398585941:
                    if (str.equals("java.lang.Enum")) {
                        return "kotlin.Enum";
                    }
                    return null;
                case 398795216:
                    if (str.equals("java.lang.Long")) {
                        return "kotlin.Long";
                    }
                    return null;
                case 482629606:
                    if (str.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                        return "kotlin.Float.Companion";
                    }
                    return null;
                case 499831342:
                    if (str.equals("java.util.Iterator")) {
                        return "kotlin.collections.Iterator";
                    }
                    return null;
                case 577341676:
                    if (str.equals("java.util.ListIterator")) {
                        return "kotlin.collections.ListIterator";
                    }
                    return null;
                case 599019395:
                    if (str.equals("kotlin.jvm.internal.StringCompanionObject")) {
                        return "kotlin.String.Companion";
                    }
                    return null;
                case 761287205:
                    if (str.equals("java.lang.Double")) {
                        return "kotlin.Double";
                    }
                    return null;
                case 1052881309:
                    if (str.equals("java.lang.Number")) {
                        return "kotlin.Number";
                    }
                    return null;
                case 1063877011:
                    if (str.equals("java.lang.Object")) {
                        return "kotlin.Any";
                    }
                    return null;
                case 1195259493:
                    if (str.equals("java.lang.String")) {
                        return "kotlin.String";
                    }
                    return null;
                case 1275614662:
                    if (str.equals("java.lang.Iterable")) {
                        return "kotlin.collections.Iterable";
                    }
                    return null;
                case 1383693018:
                    if (str.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                        return "kotlin.Boolean.Companion";
                    }
                    return null;
                case 1630335596:
                    if (str.equals("java.lang.Throwable")) {
                        return "kotlin.Throwable";
                    }
                    return null;
                case 1877171123:
                    if (str.equals("kotlin.jvm.internal.IntCompanionObject")) {
                        return "kotlin.Int.Companion";
                    }
                    return null;
                default:
                    switch (hashCode) {
                        case -1811142716:
                            if (str.equals("kotlin.jvm.functions.Function10")) {
                                return "kotlin.Function10";
                            }
                            return null;
                        case -1811142715:
                            if (str.equals("kotlin.jvm.functions.Function11")) {
                                return "kotlin.Function11";
                            }
                            return null;
                        case -1811142714:
                            if (str.equals("kotlin.jvm.functions.Function12")) {
                                return "kotlin.Function12";
                            }
                            return null;
                        case -1811142713:
                            if (str.equals("kotlin.jvm.functions.Function13")) {
                                return "kotlin.Function13";
                            }
                            return null;
                        case -1811142712:
                            if (str.equals("kotlin.jvm.functions.Function14")) {
                                return "kotlin.Function14";
                            }
                            return null;
                        case -1811142711:
                            if (str.equals("kotlin.jvm.functions.Function15")) {
                                return "kotlin.Function15";
                            }
                            return null;
                        case -1811142710:
                            if (str.equals("kotlin.jvm.functions.Function16")) {
                                return "kotlin.Function16";
                            }
                            return null;
                        case -1811142709:
                            if (str.equals("kotlin.jvm.functions.Function17")) {
                                return "kotlin.Function17";
                            }
                            return null;
                        case -1811142708:
                            if (str.equals("kotlin.jvm.functions.Function18")) {
                                return "kotlin.Function18";
                            }
                            return null;
                        case -1811142707:
                            if (str.equals("kotlin.jvm.functions.Function19")) {
                                return "kotlin.Function19";
                            }
                            return null;
                        default:
                            switch (hashCode) {
                                case -1811142685:
                                    if (str.equals("kotlin.jvm.functions.Function20")) {
                                        return "kotlin.Function20";
                                    }
                                    return null;
                                case -1811142684:
                                    if (str.equals("kotlin.jvm.functions.Function21")) {
                                        return "kotlin.Function21";
                                    }
                                    return null;
                                case -1811142683:
                                    if (str.equals("kotlin.jvm.functions.Function22")) {
                                        return "kotlin.Function22";
                                    }
                                    return null;
                                default:
                                    switch (hashCode) {
                                        case 80123371:
                                            if (str.equals("kotlin.jvm.functions.Function0")) {
                                                return "kotlin.Function0";
                                            }
                                            return null;
                                        case 80123372:
                                            if (str.equals("kotlin.jvm.functions.Function1")) {
                                                return "kotlin.Function1";
                                            }
                                            return null;
                                        case 80123373:
                                            if (str.equals("kotlin.jvm.functions.Function2")) {
                                                return "kotlin.Function2";
                                            }
                                            return null;
                                        case 80123374:
                                            if (str.equals("kotlin.jvm.functions.Function3")) {
                                                return "kotlin.Function3";
                                            }
                                            return null;
                                        case 80123375:
                                            if (str.equals("kotlin.jvm.functions.Function4")) {
                                                return "kotlin.Function4";
                                            }
                                            return null;
                                        case 80123376:
                                            if (str.equals("kotlin.jvm.functions.Function5")) {
                                                return "kotlin.Function5";
                                            }
                                            return null;
                                        case 80123377:
                                            if (str.equals("kotlin.jvm.functions.Function6")) {
                                                return "kotlin.Function6";
                                            }
                                            return null;
                                        case 80123378:
                                            if (str.equals("kotlin.jvm.functions.Function7")) {
                                                return "kotlin.Function7";
                                            }
                                            return null;
                                        case 80123379:
                                            if (str.equals("kotlin.jvm.functions.Function8")) {
                                                return "kotlin.Function8";
                                            }
                                            return null;
                                        case 80123380:
                                            if (str.equals("kotlin.jvm.functions.Function9")) {
                                                return "kotlin.Function9";
                                            }
                                            return null;
                                        default:
                                            return null;
                                    }
                            }
                    }
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        private final String e(String str) {
            int hashCode = str.hashCode();
            switch (hashCode) {
                case -2061550653:
                    if (str.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -2056817302:
                    if (str.equals("java.lang.Integer")) {
                        return "Int";
                    }
                    return null;
                case -2034166429:
                    if (str.equals("java.lang.Cloneable")) {
                        return "Cloneable";
                    }
                    return null;
                case -1979556166:
                    if (str.equals("java.lang.annotation.Annotation")) {
                        return "Annotation";
                    }
                    return null;
                case -1571515090:
                    if (str.equals("java.lang.Comparable")) {
                        return "Comparable";
                    }
                    return null;
                case -1383349348:
                    if (str.equals("java.util.Map")) {
                        return "Map";
                    }
                    return null;
                case -1383343454:
                    if (str.equals("java.util.Set")) {
                        return "Set";
                    }
                    return null;
                case -1325958191:
                    if (str.equals("double")) {
                        return "Double";
                    }
                    return null;
                case -1182275604:
                    if (str.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -1062240117:
                    if (str.equals("java.lang.CharSequence")) {
                        return "CharSequence";
                    }
                    return null;
                case -688322466:
                    if (str.equals("java.util.Collection")) {
                        return "Collection";
                    }
                    return null;
                case -527879800:
                    if (str.equals("java.lang.Float")) {
                        return "Float";
                    }
                    return null;
                case -515992664:
                    if (str.equals("java.lang.Short")) {
                        return "Short";
                    }
                    return null;
                case -246476834:
                    if (str.equals("kotlin.jvm.internal.CharCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -207262728:
                    if (str.equals("kotlin.jvm.internal.LongCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -165139126:
                    if (str.equals("java.util.Map$Entry")) {
                        return "Entry";
                    }
                    return null;
                case 104431:
                    if (str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        return "Int";
                    }
                    return null;
                case 3039496:
                    if (str.equals("byte")) {
                        return "Byte";
                    }
                    return null;
                case 3052374:
                    if (str.equals("char")) {
                        return "Char";
                    }
                    return null;
                case 3327612:
                    if (str.equals("long")) {
                        return "Long";
                    }
                    return null;
                case 64711720:
                    if (str.equals("boolean")) {
                        return "Boolean";
                    }
                    return null;
                case 65821278:
                    if (str.equals("java.util.List")) {
                        return "List";
                    }
                    return null;
                case 77230534:
                    if (str.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 97526364:
                    if (str.equals("float")) {
                        return "Float";
                    }
                    return null;
                case 109413500:
                    if (str.equals("short")) {
                        return "Short";
                    }
                    return null;
                case 155276373:
                    if (str.equals("java.lang.Character")) {
                        return "Char";
                    }
                    return null;
                case 226173651:
                    if (str.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 344809556:
                    if (str.equals("java.lang.Boolean")) {
                        return "Boolean";
                    }
                    return null;
                case 398507100:
                    if (str.equals("java.lang.Byte")) {
                        return "Byte";
                    }
                    return null;
                case 398585941:
                    if (str.equals("java.lang.Enum")) {
                        return "Enum";
                    }
                    return null;
                case 398795216:
                    if (str.equals("java.lang.Long")) {
                        return "Long";
                    }
                    return null;
                case 482629606:
                    if (str.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 499831342:
                    if (str.equals("java.util.Iterator")) {
                        return "Iterator";
                    }
                    return null;
                case 577341676:
                    if (str.equals("java.util.ListIterator")) {
                        return "ListIterator";
                    }
                    return null;
                case 599019395:
                    if (str.equals("kotlin.jvm.internal.StringCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 761287205:
                    if (str.equals("java.lang.Double")) {
                        return "Double";
                    }
                    return null;
                case 1052881309:
                    if (str.equals("java.lang.Number")) {
                        return "Number";
                    }
                    return null;
                case 1063877011:
                    if (str.equals("java.lang.Object")) {
                        return "Any";
                    }
                    return null;
                case 1195259493:
                    if (str.equals("java.lang.String")) {
                        return "String";
                    }
                    return null;
                case 1275614662:
                    if (str.equals("java.lang.Iterable")) {
                        return "Iterable";
                    }
                    return null;
                case 1383693018:
                    if (str.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 1630335596:
                    if (str.equals("java.lang.Throwable")) {
                        return "Throwable";
                    }
                    return null;
                case 1877171123:
                    if (str.equals("kotlin.jvm.internal.IntCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                default:
                    switch (hashCode) {
                        case -1811142716:
                            if (str.equals("kotlin.jvm.functions.Function10")) {
                                return "Function10";
                            }
                            return null;
                        case -1811142715:
                            if (str.equals("kotlin.jvm.functions.Function11")) {
                                return "Function11";
                            }
                            return null;
                        case -1811142714:
                            if (str.equals("kotlin.jvm.functions.Function12")) {
                                return "Function12";
                            }
                            return null;
                        case -1811142713:
                            if (str.equals("kotlin.jvm.functions.Function13")) {
                                return "Function13";
                            }
                            return null;
                        case -1811142712:
                            if (str.equals("kotlin.jvm.functions.Function14")) {
                                return "Function14";
                            }
                            return null;
                        case -1811142711:
                            if (str.equals("kotlin.jvm.functions.Function15")) {
                                return "Function15";
                            }
                            return null;
                        case -1811142710:
                            if (str.equals("kotlin.jvm.functions.Function16")) {
                                return "Function16";
                            }
                            return null;
                        case -1811142709:
                            if (str.equals("kotlin.jvm.functions.Function17")) {
                                return "Function17";
                            }
                            return null;
                        case -1811142708:
                            if (str.equals("kotlin.jvm.functions.Function18")) {
                                return "Function18";
                            }
                            return null;
                        case -1811142707:
                            if (str.equals("kotlin.jvm.functions.Function19")) {
                                return "Function19";
                            }
                            return null;
                        default:
                            switch (hashCode) {
                                case -1811142685:
                                    if (str.equals("kotlin.jvm.functions.Function20")) {
                                        return "Function20";
                                    }
                                    return null;
                                case -1811142684:
                                    if (str.equals("kotlin.jvm.functions.Function21")) {
                                        return "Function21";
                                    }
                                    return null;
                                case -1811142683:
                                    if (str.equals("kotlin.jvm.functions.Function22")) {
                                        return "Function22";
                                    }
                                    return null;
                                default:
                                    switch (hashCode) {
                                        case 80123371:
                                            if (str.equals("kotlin.jvm.functions.Function0")) {
                                                return "Function0";
                                            }
                                            return null;
                                        case 80123372:
                                            if (str.equals("kotlin.jvm.functions.Function1")) {
                                                return "Function1";
                                            }
                                            return null;
                                        case 80123373:
                                            if (str.equals("kotlin.jvm.functions.Function2")) {
                                                return "Function2";
                                            }
                                            return null;
                                        case 80123374:
                                            if (str.equals("kotlin.jvm.functions.Function3")) {
                                                return "Function3";
                                            }
                                            return null;
                                        case 80123375:
                                            if (str.equals("kotlin.jvm.functions.Function4")) {
                                                return "Function4";
                                            }
                                            return null;
                                        case 80123376:
                                            if (str.equals("kotlin.jvm.functions.Function5")) {
                                                return "Function5";
                                            }
                                            return null;
                                        case 80123377:
                                            if (str.equals("kotlin.jvm.functions.Function6")) {
                                                return "Function6";
                                            }
                                            return null;
                                        case 80123378:
                                            if (str.equals("kotlin.jvm.functions.Function7")) {
                                                return "Function7";
                                            }
                                            return null;
                                        case 80123379:
                                            if (str.equals("kotlin.jvm.functions.Function8")) {
                                                return "Function8";
                                            }
                                            return null;
                                        case 80123380:
                                            if (str.equals("kotlin.jvm.functions.Function9")) {
                                                return "Function9";
                                            }
                                            return null;
                                        default:
                                            return null;
                                    }
                            }
                    }
            }
        }
    }

    static {
        int i6 = 0;
        List Q = kotlin.collections.f0.Q(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(Q, 10));
        for (Object obj : Q) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                kotlin.collections.f0.b0();
            }
            arrayList.add(kotlin.o0.a((Class) obj, Integer.valueOf(i6)));
            i6 = i7;
        }
        f44060c = i1.B0(arrayList);
    }

    public t(@NotNull Class<?> jClass) {
        g0.p(jClass, "jClass");
        this.f44061a = jClass;
    }

    private final Void e() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.d
    @SinceKotlin(version = "1.1")
    public boolean C(@Nullable Object obj) {
        return f44059b.d(obj, c());
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String D() {
        return f44059b.c(c());
    }

    @Override // kotlin.jvm.internal.s
    @NotNull
    public Class<?> c() {
        return this.f44061a;
    }

    @Override // kotlin.reflect.d
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof t) && g0.g(l3.a.g(this), l3.a.g((kotlin.reflect.d) obj));
    }

    @NotNull
    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String x() {
        return f44059b.b(c());
    }

    @Override // kotlin.reflect.d
    @Nullable
    public Object A() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean B() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.i<Object>> f() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.s> getTypeParameters() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @Nullable
    public KVisibility getVisibility() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public int hashCode() {
        return l3.a.g(this).hashCode();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.r> i() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean isAbstract() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean isFinal() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean isOpen() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean k() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean m() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d, kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> o() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean u() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean v() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean w() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.d<?>> y() {
        e();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.d<? extends Object>> z() {
        e();
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void E() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void F() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void G() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void H() {
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static /* synthetic */ void I() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void J() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void K() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void L() {
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void M() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void g() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void r() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void s() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void t() {
    }
}
