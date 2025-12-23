package z3;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nreadPackageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 readPackageFragment.kt\norg/jetbrains/kotlin/metadata/builtins/ReadPackageFragmentKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n1#2:24\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    @NotNull
    public static final Pair<ProtoBuf.PackageFragment, a> a(@NotNull InputStream inputStream) {
        ProtoBuf.PackageFragment packageFragment;
        g0.p(inputStream, "<this>");
        try {
            a a6 = a.f56810g.a(inputStream);
            if (a6.h()) {
                f d6 = f.d();
                b.a(d6);
                packageFragment = ProtoBuf.PackageFragment.parseFrom(inputStream, d6);
            } else {
                packageFragment = null;
            }
            Pair<ProtoBuf.PackageFragment, a> a7 = o0.a(packageFragment, a6);
            kotlin.io.b.a(inputStream, null);
            return a7;
        } finally {
        }
    }
}
