package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSignatureBuildingComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponents\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,40:1\n11228#2:41\n11563#2,3:42\n11563#2,3:49\n37#3:45\n36#3,3:46\n*S KotlinDebug\n*F\n+ 1 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponents\n*L\n21#1:41\n21#1:42,3\n26#1:49,3\n21#1:45\n21#1:46,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f0 f45887a = new f0();

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence l(String it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return f45887a.c(it);
    }

    @NotNull
    public final String[] b(@NotNull String... signatures) {
        kotlin.jvm.internal.g0.p(signatures, "signatures");
        ArrayList arrayList = new ArrayList(signatures.length);
        for (String str : signatures) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @NotNull
    public final Set<String> d(@NotNull String internalName, @NotNull String... signatures) {
        kotlin.jvm.internal.g0.p(internalName, "internalName");
        kotlin.jvm.internal.g0.p(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + '.' + str);
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> e(@NotNull String name, @NotNull String... signatures) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signatures, "signatures");
        return d(h(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    @NotNull
    public final Set<String> f(@NotNull String name, @NotNull String... signatures) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signatures, "signatures");
        return d(i(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    @NotNull
    public final String g(@NotNull String name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return "java/util/function/" + name;
    }

    @NotNull
    public final String h(@NotNull String name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return "java/lang/" + name;
    }

    @NotNull
    public final String i(@NotNull String name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return "java/util/" + name;
    }

    @NotNull
    public final String j(@NotNull String name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return "java/util/concurrent/atomic/" + name;
    }

    @NotNull
    public final String k(@NotNull String name, @NotNull List<String> parameters, @NotNull String ret) {
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(parameters, "parameters");
        kotlin.jvm.internal.g0.p(ret, "ret");
        return name + '(' + kotlin.collections.f0.r3(parameters, "", null, null, 0, null, e0.f45886a, 30, null) + ')' + c(ret);
    }

    @NotNull
    public final String m(@NotNull String internalName, @NotNull String jvmDescriptor) {
        kotlin.jvm.internal.g0.p(internalName, "internalName");
        kotlin.jvm.internal.g0.p(jvmDescriptor, "jvmDescriptor");
        return internalName + '.' + jvmDescriptor;
    }

    private f0() {
    }

    private final String c(String str) {
        if (str.length() > 1) {
            return 'L' + str + ';';
        }
        return str;
    }
}
