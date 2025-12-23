package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,158:1\n37#2,2:159\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:159,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f43770a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f43771b = 2;

    @SinceKotlin(version = "2.2")
    @PublishedApi
    public static final int c(@NotNull BaseContinuationImpl baseContinuationImpl) {
        int b6;
        g0.p(baseContinuationImpl, "<this>");
        DebugMetadata a6 = a(baseContinuationImpl);
        if (a6 != null && a6.v() >= 2 && (b6 = b(baseContinuationImpl)) >= 0 && b6 < a6.nl().length) {
            return a6.nl()[b6];
        }
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    @Nullable
    @PublishedApi
    public static final String[] d(@NotNull BaseContinuationImpl baseContinuationImpl) {
        g0.p(baseContinuationImpl, "<this>");
        DebugMetadata a6 = a(baseContinuationImpl);
        if (a6 == null || a6.v() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int b6 = b(baseContinuationImpl);
        int[] i6 = a6.i();
        int length = i6.length;
        for (int i7 = 0; i7 < length; i7++) {
            if (i6[i7] == b6) {
                arrayList.add(a6.s()[i7]);
                arrayList.add(a6.n()[i7]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    @Nullable
    @PublishedApi
    public static final StackTraceElement e(@NotNull BaseContinuationImpl baseContinuationImpl) {
        String str;
        g0.p(baseContinuationImpl, "<this>");
        DebugMetadata a6 = a(baseContinuationImpl);
        if (a6 == null || a6.v() < 1) {
            return null;
        }
        int b6 = b(baseContinuationImpl);
        int i6 = b6 < 0 ? -1 : a6.l()[b6];
        String b7 = g.f43772a.b(baseContinuationImpl);
        if (b7 == null) {
            str = a6.c();
        } else {
            str = b7 + '/' + a6.c();
        }
        return new StackTraceElement(str, a6.m(), a6.f(), i6);
    }

    private static final DebugMetadata a(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int b(BaseContinuationImpl baseContinuationImpl) {
        Integer num;
        int i6;
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i6 = num.intValue();
            } else {
                i6 = 0;
            }
            return i6 - 1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
