package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,101:1\n5343#2,7:102\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion\n*L\n73#1:102,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final C0901a f46200f = new C0901a(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final int[] f46201a;

    /* renamed from: b, reason: collision with root package name */
    private final int f46202b;

    /* renamed from: c, reason: collision with root package name */
    private final int f46203c;

    /* renamed from: d, reason: collision with root package name */
    private final int f46204d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<Integer> f46205e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,101:1\n1563#2:102\n1634#2,3:103\n37#3:106\n36#3,3:107\n*S KotlinDebug\n*F\n+ 1 BinaryVersion.kt\norg/jetbrains/kotlin/metadata/deserialization/BinaryVersion$Companion\n*L\n97#1:102\n97#1:103,3\n98#1:106\n98#1:107,3\n*E\n"})
    /* renamed from: kotlin.reflect.jvm.internal.impl.metadata.deserialization.a$a, reason: collision with other inner class name */
    public static final class C0901a {
        public /* synthetic */ C0901a(v vVar) {
            this();
        }

        private C0901a() {
        }
    }

    public a(@NotNull int... numbers) {
        List<Integer> J;
        g0.p(numbers, "numbers");
        this.f46201a = numbers;
        Integer ff = n.ff(numbers, 0);
        this.f46202b = ff != null ? ff.intValue() : -1;
        Integer ff2 = n.ff(numbers, 1);
        this.f46203c = ff2 != null ? ff2.intValue() : -1;
        Integer ff3 = n.ff(numbers, 2);
        this.f46204d = ff3 != null ? ff3.intValue() : -1;
        if (numbers.length <= 3) {
            J = f0.J();
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + '.');
            }
            J = f0.a6(n.r(numbers).subList(3, numbers.length));
        }
        this.f46205e = J;
    }

    public final int a() {
        return this.f46202b;
    }

    public final int b() {
        return this.f46203c;
    }

    public final boolean c(int i6, int i7, int i8) {
        int i9 = this.f46202b;
        if (i9 > i6) {
            return true;
        }
        if (i9 < i6) {
            return false;
        }
        int i10 = this.f46203c;
        if (i10 > i7) {
            return true;
        }
        return i10 >= i7 && this.f46204d >= i8;
    }

    public final boolean d(@NotNull a version) {
        g0.p(version, "version");
        return c(version.f46202b, version.f46203c, version.f46204d);
    }

    public final boolean e(int i6, int i7, int i8) {
        int i9 = this.f46202b;
        if (i9 < i6) {
            return true;
        }
        if (i9 > i6) {
            return false;
        }
        int i10 = this.f46203c;
        if (i10 < i7) {
            return true;
        }
        return i10 <= i7 && this.f46204d <= i8;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !g0.g(getClass(), obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        return this.f46202b == aVar.f46202b && this.f46203c == aVar.f46203c && this.f46204d == aVar.f46204d && g0.g(this.f46205e, aVar.f46205e);
    }

    protected final boolean f(@NotNull a ourVersion) {
        g0.p(ourVersion, "ourVersion");
        int i6 = this.f46202b;
        return i6 == 0 ? ourVersion.f46202b == 0 && this.f46203c == ourVersion.f46203c : i6 == ourVersion.f46202b && this.f46203c <= ourVersion.f46203c;
    }

    @NotNull
    public final int[] g() {
        return this.f46201a;
    }

    public int hashCode() {
        int i6 = this.f46202b;
        int i7 = i6 + (i6 * 31) + this.f46203c;
        int i8 = i7 + (i7 * 31) + this.f46204d;
        return i8 + (i8 * 31) + this.f46205e.hashCode();
    }

    @NotNull
    public String toString() {
        int[] g6 = g();
        ArrayList arrayList = new ArrayList();
        for (int i6 : g6) {
            if (i6 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i6));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        return f0.r3(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
