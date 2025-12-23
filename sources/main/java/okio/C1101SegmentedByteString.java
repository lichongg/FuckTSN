package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n+ 2 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n63#2,12:141\n63#2,12:153\n104#2,2:165\n106#2,26:168\n135#2,5:194\n142#2:199\n145#2,3:200\n63#2,8:203\n148#2,8:211\n71#2,4:219\n156#2:223\n63#2,12:224\n160#2:236\n85#2,10:237\n161#2,9:247\n95#2,4:256\n170#2,2:260\n179#2,4:262\n85#2,10:266\n183#2,3:276\n95#2,4:279\n186#2:283\n195#2,8:284\n85#2,10:292\n203#2,3:302\n95#2,4:305\n206#2:309\n215#2,5:310\n85#2,10:315\n220#2,3:325\n95#2,4:328\n223#2:332\n226#2,4:333\n234#2,6:337\n63#2,8:343\n240#2,7:351\n71#2,4:358\n247#2,2:362\n1#3:167\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/SegmentedByteString\n*L\n54#1:141,12\n66#1:153,12\n78#1:165,2\n78#1:168,26\n80#1:194,5\n82#1:199\n84#1:200,3\n84#1:203,8\n84#1:211,8\n84#1:219,4\n84#1:223\n90#1:224,12\n96#1:236\n96#1:237,10\n96#1:247,9\n96#1:256,4\n96#1:260,2\n103#1:262,4\n103#1:266,10\n103#1:276,3\n103#1:279,4\n103#1:283\n110#1:284,8\n110#1:292,10\n110#1:302,3\n110#1:305,4\n110#1:309\n117#1:310,5\n117#1:315,10\n117#1:325,3\n117#1:328,4\n117#1:332\n131#1:333,4\n133#1:337,6\n133#1:343,8\n133#1:351,7\n133#1:358,4\n133#1:362,2\n78#1:167\n*E\n"})
/* renamed from: okio.SegmentedByteString, reason: case insensitive filesystem */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class C1101SegmentedByteString extends ByteString {

    @NotNull
    private final transient int[] directory;

    @NotNull
    private final transient byte[][] segments;

    @Override // okio.ByteString
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i6, @NotNull ByteString other, int i7, int i8) {
        g0.p(other, "other");
        if (i6 < 0 || i6 > size() - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i11 = getDirectory$okio()[segment] - i10;
            int i12 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i9, i11 + i10) - i6;
            if (!other.rangeEquals(i7, getSegments$okio()[segment], i12 + (i6 - i10), min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1101SegmentedByteString(@NotNull byte[][] segments, @NotNull int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        g0.p(segments, "segments");
        g0.p(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public void copyInto(int i6, @NotNull byte[] target, int i7, int i8) {
        g0.p(target, "target");
        long j6 = i8;
        SegmentedByteString.checkOffsetAndCount(size(), i6, j6);
        SegmentedByteString.checkOffsetAndCount(target.length, i7, j6);
        int i9 = i8 + i6;
        int segment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i11 = getDirectory$okio()[segment] - i10;
            int i12 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i9, i11 + i10) - i6;
            int i13 = i12 + (i6 - i10);
            n.v0(getSegments$okio()[segment], target, i7, i13, i13 + min);
            i7 += min;
            i6 += min;
            segment++;
        }
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        g0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = getDirectory$okio()[length + i6];
            int i9 = getDirectory$okio()[i6];
            messageDigest.update(getSegments$okio()[i6], i8, i9 - i7);
            i6++;
            i7 = i9;
        }
        byte[] digest = messageDigest.digest();
        g0.m(digest);
        return new ByteString(digest);
    }

    @NotNull
    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @NotNull
    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        g0.p(algorithm, "algorithm");
        g0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                int i8 = getDirectory$okio()[length + i6];
                int i9 = getDirectory$okio()[i6];
                mac.update(getSegments$okio()[i6], i8, i9 - i7);
                i6++;
                i7 = i9;
            }
            byte[] doFinal = mac.doFinal();
            g0.o(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] other, int i6) {
        g0.p(other, "other");
        return toByteString().indexOf(other, i6);
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] other, int i6) {
        g0.p(other, "other");
        return toByteString().lastIndexOf(other, i6);
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        g0.p(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream out) throws IOException {
        g0.p(out, "out");
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = getDirectory$okio()[length + i6];
            int i9 = getDirectory$okio()[i6];
            out.write(getSegments$okio()[i6], i8, i9 - i7);
            i6++;
            i7 = i9;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int i6, int i7) {
        g0.p(buffer, "buffer");
        int i8 = i6 + i7;
        int segment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i8) {
            int i9 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i10 = getDirectory$okio()[segment] - i9;
            int i11 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i8, i10 + i9) - i6;
            int i12 = i11 + (i6 - i9);
            Segment segment2 = new Segment(getSegments$okio()[segment], i12, i12 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                g0.m(segment3);
                Segment segment4 = segment3.prev;
                g0.m(segment4);
                segment4.push(segment2);
            }
            i6 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i7);
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        g0.n(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        g0.o(asReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        while (i6 < length) {
            int i9 = getDirectory$okio()[length + i6];
            int i10 = getDirectory$okio()[i6];
            byte[] bArr = getSegments$okio()[i6];
            int i11 = (i10 - i7) + i9;
            while (i9 < i11) {
                i8 = (i8 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i7 = i10;
        }
        setHashCode$okio(i8);
        return i8;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i6) {
        int i7;
        SegmentedByteString.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], i6, 1L);
        int segment = okio.internal.SegmentedByteString.segment(this, i6);
        if (segment == 0) {
            i7 = 0;
        } else {
            i7 = getDirectory$okio()[segment - 1];
        }
        return getSegments$okio()[segment][(i6 - i7) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int i6, int i7) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i7);
        if (i6 >= 0) {
            if (resolveDefaultParameter <= size()) {
                int i8 = resolveDefaultParameter - i6;
                if (i8 >= 0) {
                    if (i6 == 0 && resolveDefaultParameter == size()) {
                        return this;
                    }
                    if (i6 == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = okio.internal.SegmentedByteString.segment(this, i6);
                    int segment2 = okio.internal.SegmentedByteString.segment(this, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) n.l1(getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[bArr.length * 2];
                    int i9 = 0;
                    if (segment <= segment2) {
                        int i10 = segment;
                        int i11 = 0;
                        while (true) {
                            iArr[i11] = Math.min(getDirectory$okio()[i10] - i6, i8);
                            int i12 = i11 + 1;
                            iArr[i11 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i10];
                            if (i10 == segment2) {
                                break;
                            }
                            i10++;
                            i11 = i12;
                        }
                    }
                    if (segment != 0) {
                        i9 = getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i6 - i9);
                    return new C1101SegmentedByteString(bArr, iArr);
                }
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i6).toString());
            }
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i6 + " < 0").toString());
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            int i9 = getDirectory$okio()[length + i6];
            int i10 = getDirectory$okio()[i6];
            int i11 = i10 - i7;
            n.v0(getSegments$okio()[i6], bArr, i8, i9, i9 + i11);
            i8 += i11;
            i6++;
            i7 = i10;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i6, @NotNull byte[] other, int i7, int i8) {
        g0.p(other, "other");
        if (i6 < 0 || i6 > size() - i8 || i7 < 0 || i7 > other.length - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int segment = okio.internal.SegmentedByteString.segment(this, i6);
        while (i6 < i9) {
            int i10 = segment == 0 ? 0 : getDirectory$okio()[segment - 1];
            int i11 = getDirectory$okio()[segment] - i10;
            int i12 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i9, i11 + i10) - i6;
            if (!SegmentedByteString.arrayRangeEquals(getSegments$okio()[segment], i12 + (i6 - i10), other, i7, min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            segment++;
        }
        return true;
    }
}
