package kotlin.uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nUuidJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UuidJVM.kt\nkotlin/uuid/UuidKt__UuidJVMKt\n*L\n1#1,277:1\n277#1:278\n277#1:279\n277#1:280\n277#1:281\n277#1:282\n277#1:283\n277#1:284\n277#1:285\n*S KotlinDebug\n*F\n+ 1 UuidJVM.kt\nkotlin/uuid/UuidKt__UuidJVMKt\n*L\n139#1:278\n140#1:279\n184#1:280\n185#1:281\n224#1:282\n225#1:283\n271#1:284\n272#1:285\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class c {
    @ExperimentalUuidApi
    public static final void a(long j6, @NotNull byte[] dst, int i6, int i7, int i8) {
        g0.p(dst, "dst");
        d.r(j6, dst, i6, i7, i8);
    }

    @ExperimentalUuidApi
    public static final long b(@NotNull byte[] bArr, int i6) {
        g0.p(bArr, "<this>");
        return d.s(bArr, i6);
    }

    @SinceKotlin(version = "2.0")
    @ExperimentalUuidApi
    @NotNull
    public static final Uuid c(@NotNull ByteBuffer byteBuffer) {
        g0.p(byteBuffer, "<this>");
        if (byteBuffer.position() + 15 >= byteBuffer.limit()) {
            throw new BufferUnderflowException();
        }
        long j6 = byteBuffer.getLong();
        long j7 = byteBuffer.getLong();
        if (g0.g(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
            j6 = Long.reverseBytes(j6);
            j7 = Long.reverseBytes(j7);
        }
        return Uuid.Companion.b(j6, j7);
    }

    @SinceKotlin(version = "2.0")
    @ExperimentalUuidApi
    @NotNull
    public static final Uuid d(@NotNull ByteBuffer byteBuffer, int i6) {
        g0.p(byteBuffer, "<this>");
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("Negative index: " + i6);
        }
        if (i6 + 15 < byteBuffer.limit()) {
            long j6 = byteBuffer.getLong(i6);
            long j7 = byteBuffer.getLong(i6 + 8);
            if (g0.g(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
                j6 = Long.reverseBytes(j6);
                j7 = Long.reverseBytes(j7);
            }
            return Uuid.Companion.b(j6, j7);
        }
        throw new IndexOutOfBoundsException("Not enough bytes to read a uuid at index: " + i6 + ", with limit: " + byteBuffer.limit() + ' ');
    }

    @SinceKotlin(version = "2.0")
    @ExperimentalUuidApi
    @NotNull
    public static final ByteBuffer e(@NotNull ByteBuffer byteBuffer, int i6, @NotNull Uuid uuid) {
        ByteBuffer putLong;
        g0.p(byteBuffer, "<this>");
        g0.p(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("Negative index: " + i6);
        }
        if (i6 + 15 < byteBuffer.limit()) {
            if (g0.g(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
                byteBuffer.putLong(i6, mostSignificantBits);
                putLong = byteBuffer.putLong(i6 + 8, leastSignificantBits);
            } else {
                byteBuffer.putLong(i6, Long.reverseBytes(mostSignificantBits));
                putLong = byteBuffer.putLong(i6 + 8, Long.reverseBytes(leastSignificantBits));
            }
            g0.o(putLong, "toLongs(...)");
            return putLong;
        }
        throw new IndexOutOfBoundsException("Not enough capacity to write a uuid at index: " + i6 + ", with limit: " + byteBuffer.limit() + ' ');
    }

    @SinceKotlin(version = "2.0")
    @ExperimentalUuidApi
    @NotNull
    public static final ByteBuffer f(@NotNull ByteBuffer byteBuffer, @NotNull Uuid uuid) {
        ByteBuffer putLong;
        g0.p(byteBuffer, "<this>");
        g0.p(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (byteBuffer.position() + 15 >= byteBuffer.limit()) {
            throw new BufferOverflowException();
        }
        if (g0.g(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
            byteBuffer.putLong(mostSignificantBits);
            putLong = byteBuffer.putLong(leastSignificantBits);
        } else {
            byteBuffer.putLong(Long.reverseBytes(mostSignificantBits));
            putLong = byteBuffer.putLong(Long.reverseBytes(leastSignificantBits));
        }
        g0.o(putLong, "toLongs(...)");
        return putLong;
    }

    @ExperimentalUuidApi
    @NotNull
    public static final Uuid h() {
        byte[] bArr = new byte[16];
        a.f48058a.a().nextBytes(bArr);
        return d.w(bArr);
    }

    @ExperimentalUuidApi
    @NotNull
    public static final Object i(@NotNull Uuid uuid) {
        g0.p(uuid, "uuid");
        return new e(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    @ExperimentalUuidApi
    public static final void j(@NotNull byte[] bArr, int i6, long j6) {
        g0.p(bArr, "<this>");
        d.t(bArr, i6, j6);
    }

    @SinceKotlin(version = "2.0")
    @ExperimentalUuidApi
    @NotNull
    public static final UUID k(@NotNull Uuid uuid) {
        g0.p(uuid, "<this>");
        return new UUID(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    @SinceKotlin(version = "2.0")
    @ExperimentalUuidApi
    @NotNull
    public static final Uuid l(@NotNull UUID uuid) {
        g0.p(uuid, "<this>");
        return Uuid.Companion.b(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    @ExperimentalUuidApi
    @NotNull
    public static final Uuid m(@NotNull String hexString) {
        g0.p(hexString, "hexString");
        return d.x(hexString);
    }

    @ExperimentalUuidApi
    @NotNull
    public static final Uuid n(@NotNull String hexDashString) {
        g0.p(hexDashString, "hexDashString");
        return d.y(hexDashString);
    }

    public static final long g(long j6) {
        return Long.reverseBytes(j6);
    }
}
