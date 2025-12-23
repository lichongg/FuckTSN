package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nutfEncoding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utfEncoding.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/UtfEncodingKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,73:1\n37#2:74\n36#2,3:75\n1#3:78\n*S KotlinDebug\n*F\n+ 1 utfEncoding.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/UtfEncodingKt\n*L\n55#1:74\n55#1:75,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {
    @NotNull
    public static final byte[] a(@NotNull String[] strings) {
        g0.p(strings, "strings");
        int i6 = 0;
        for (String str : strings) {
            i6 += str.length();
        }
        byte[] bArr = new byte[i6];
        int i7 = 0;
        for (String str2 : strings) {
            int length = str2.length();
            int i8 = 0;
            while (i8 < length) {
                bArr[i7] = (byte) str2.charAt(i8);
                i8++;
                i7++;
            }
        }
        return bArr;
    }
}
