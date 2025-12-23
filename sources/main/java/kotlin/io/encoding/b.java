package kotlin.io.encoding;

import kotlin.SinceKotlin;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,843:1\n13880#2,3:844\n13880#2,3:847\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n*L\n785#1:844,3\n801#1:847,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final byte[] f43833a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final int[] f43834b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final byte[] f43835c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final int[] f43836d;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f43833a = bArr;
        int[] iArr = new int[256];
        n.T1(iArr, -1, 0, 0, 6, null);
        iArr[61] = -2;
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            iArr[bArr[i7]] = i8;
            i7++;
            i8++;
        }
        f43834b = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f43835c = bArr2;
        int[] iArr2 = new int[256];
        n.T1(iArr2, -1, 0, 0, 6, null);
        iArr2[61] = -2;
        int length2 = bArr2.length;
        int i9 = 0;
        while (i6 < length2) {
            iArr2[bArr2[i6]] = i9;
            i6++;
            i9++;
        }
        f43836d = iArr2;
    }

    @SinceKotlin(version = "1.8")
    public static final boolean e(int i6) {
        if (i6 < 0) {
            return false;
        }
        int[] iArr = f43834b;
        return i6 < iArr.length && iArr[i6] != -1;
    }
}
