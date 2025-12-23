package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "CollectionToArray")
@SourceDebugExtension({"SMAP\nCollectionToArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n1#1,88:1\n63#1,22:89\n63#1,22:111\n*S KotlinDebug\n*F\n+ 1 CollectionToArray.kt\nkotlin/jvm/internal/CollectionToArray\n*L\n22#1:89,22\n37#1:111,22\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Object[] f44063a = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    private static final int f44064b = 2147483645;

    @JvmName(name = "toArray")
    @NotNull
    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] a(@NotNull Collection<?> collection) {
        g0.p(collection, "collection");
        int size = collection.size();
        if (size == 0) {
            return f44063a;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return f44063a;
        }
        Object[] objArr = new Object[size];
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            objArr[i6] = it.next();
            if (i7 >= objArr.length) {
                if (!it.hasNext()) {
                    return objArr;
                }
                int i8 = ((i7 * 3) + 1) >>> 1;
                if (i8 <= i7) {
                    i8 = f44064b;
                    if (i7 >= f44064b) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr = Arrays.copyOf(objArr, i8);
                g0.o(objArr, "copyOf(...)");
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr, i7);
                g0.o(copyOf, "copyOf(...)");
                return copyOf;
            }
            i6 = i7;
        }
    }

    @JvmName(name = "toArray")
    @NotNull
    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.9")
    public static final Object[] b(@NotNull Collection<?> collection, @Nullable Object[] objArr) {
        Object[] objArr2;
        g0.p(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i6 = 0;
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    g0.n(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i7 = i6 + 1;
                    objArr2[i6] = it.next();
                    if (i7 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i8 = ((i7 * 3) + 1) >>> 1;
                        if (i8 <= i7) {
                            i8 = f44064b;
                            if (i7 >= f44064b) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i8);
                        g0.o(objArr2, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i7] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i7);
                        g0.o(copyOf, "copyOf(...)");
                        return copyOf;
                    }
                    i6 = i7;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] c(Collection<?> collection, Function0<Object[]> function0, Function1<? super Integer, Object[]> function1, Function2<? super Object[], ? super Integer, Object[]> function2) {
        int size = collection.size();
        if (size == 0) {
            return function0.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return function0.invoke();
        }
        Object[] invoke = function1.invoke(Integer.valueOf(size));
        int i6 = 0;
        ?? r32 = invoke;
        while (true) {
            int i7 = i6 + 1;
            r32[i6] = it.next();
            if (i7 >= r32.length) {
                if (!it.hasNext()) {
                    return r32;
                }
                int i8 = ((i7 * 3) + 1) >>> 1;
                if (i8 <= i7) {
                    i8 = f44064b;
                    if (i7 >= f44064b) {
                        throw new OutOfMemoryError();
                    }
                }
                r32 = Arrays.copyOf((Object[]) r32, i8);
                g0.o(r32, "copyOf(...)");
            } else if (!it.hasNext()) {
                return function2.invoke(r32, Integer.valueOf(i7));
            }
            i6 = i7;
            r32 = r32;
        }
    }
}
