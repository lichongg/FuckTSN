package b0;

import com.orhanobut.logger.j;
import io.netty.buffer.ByteBuf;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.text.b;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nByteHexExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteHexExt.kt\ncom/bxkj/base/v2/netty4android/client/ext/ByteHexExt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,54:1\n1#2:55\n1563#3:56\n1634#3,3:57\n*S KotlinDebug\n*F\n+ 1 ByteHexExt.kt\ncom/bxkj/base/v2/netty4android/client/ext/ByteHexExt\n*L\n28#1:56\n28#1:57,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f1020a = new a();

    @NotNull
    public final byte[] e(int i6) {
        byte[] array = ByteBuffer.allocate(4).putInt(i6).array();
        g0.o(array, "array(...)");
        return array;
    }

    @NotNull
    public final byte[] f(short s5) {
        byte[] bArr = new byte[2];
        ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(s5);
        return bArr;
    }

    public static /* synthetic */ String d(a aVar, ByteBuf byteBuf, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "解析数据：";
        }
        return aVar.c(byteBuf, str);
    }

    @NotNull
    public final byte[] a(@NotNull String str) {
        g0.p(str, "<this>");
        if (str.length() % 2 != 0) {
            throw new IllegalStateException("Must have an even length");
        }
        List<String> T6 = u.T6(str, 2);
        ArrayList arrayList = new ArrayList(f0.d0(T6, 10));
        Iterator<T> it = T6.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), b.a(16))));
        }
        return f0.T5(arrayList);
    }

    @NotNull
    public final String b(@NotNull byte[] bArr) {
        g0.p(bArr, "<this>");
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            t0 t0Var = t0.f44062a;
            String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b6)}, 1));
            g0.o(format, "format(...)");
            sb.append(format);
        }
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public final String c(@NotNull ByteBuf byteBuf, @Nullable String str) {
        g0.p(byteBuf, "<this>");
        byte[] bArr = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bArr);
        String b6 = b(bArr);
        j.g(str + b6, new Object[0]);
        return b6;
    }

    private a() {
    }
}
