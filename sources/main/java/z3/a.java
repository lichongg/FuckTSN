package z3;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.d1;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.ranges.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends kotlin.reflect.jvm.internal.impl.metadata.deserialization.a {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final C1100a f56810g = new C1100a(null);

    /* renamed from: h, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final a f56811h = new a(1, 0, 7);

    /* renamed from: i, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final a f56812i = new a(new int[0]);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nBuiltInsBinaryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltInsBinaryVersion.kt\norg/jetbrains/kotlin/metadata/builtins/BuiltInsBinaryVersion$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1563#2:41\n1634#2,3:42\n*S KotlinDebug\n*F\n+ 1 BuiltInsBinaryVersion.kt\norg/jetbrains/kotlin/metadata/builtins/BuiltInsBinaryVersion$Companion\n*L\n36#1:41\n36#1:42,3\n*E\n"})
    /* renamed from: z3.a$a, reason: collision with other inner class name */
    public static final class C1100a {
        public /* synthetic */ C1100a(v vVar) {
            this();
        }

        private C1100a() {
        }

        @NotNull
        public final a a(@NotNull InputStream stream) {
            g0.p(stream, "stream");
            DataInputStream dataInputStream = new DataInputStream(stream);
            m mVar = new m(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(f0.d0(mVar, 10));
            Iterator<Integer> it = mVar.iterator();
            while (it.hasNext()) {
                ((d1) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] Z5 = f0.Z5(arrayList);
            return new a(Arrays.copyOf(Z5, Z5.length));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull int... numbers) {
        super(Arrays.copyOf(numbers, numbers.length));
        g0.p(numbers, "numbers");
    }

    public boolean h() {
        return f(f56811h);
    }
}
