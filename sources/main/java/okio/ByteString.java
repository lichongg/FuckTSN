package okio;

import com.baidu.mobads.sdk.internal.by;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.n;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okio.internal.ByteStringNonJs;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 Util.kt\nokio/-SegmentedByteString\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n42#2,7:365\n52#2:372\n55#2:373\n62#2,4:374\n66#2:379\n68#2:381\n74#2,23:382\n102#2,23:405\n129#2,2:428\n131#2,9:431\n143#2:440\n146#2:441\n149#2:442\n152#2:443\n160#2:444\n170#2,3:445\n169#2:448\n183#2,2:449\n188#2:451\n192#2:452\n196#2:453\n200#2:454\n204#2,7:455\n217#2:462\n221#2,8:463\n233#2,4:471\n242#2,5:475\n251#2,6:480\n257#2,9:487\n301#2,8:496\n129#2,2:504\n131#2,9:507\n312#2,9:516\n67#3:378\n73#3:380\n73#3:486\n1#4:430\n1#4:506\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString\n*L\n66#1:365,7\n71#1:372\n108#1:373\n110#1:374,4\n110#1:379\n110#1:381\n112#1:382,23\n114#1:405,23\n118#1:428,2\n118#1:431,9\n120#1:440\n129#1:441\n131#1:442\n133#1:443\n152#1:444\n159#1:445,3\n159#1:448\n166#1:449,2\n168#1:451\n170#1:452\n172#1:453\n174#1:454\n180#1:455,7\n183#1:462\n186#1:463,8\n188#1:471,4\n190#1:475,5\n192#1:480,6\n192#1:487,9\n194#1:496,8\n194#1:504,2\n194#1:507,9\n194#1:516,9\n110#1:378\n110#1:380\n192#1:486\n118#1:430\n194#1:506\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n+ 2 ByteString.kt\nokio/internal/-ByteString\n+ 3 ByteStringNonJs.kt\nokio/internal/-ByteStringNonJs\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,364:1\n269#2:365\n273#2,3:366\n280#2,3:369\n287#2,2:372\n25#3:374\n27#3,7:376\n1#4:375\n1#4:383\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/ByteString$Companion\n*L\n234#1:365\n239#1:366,3\n251#1:369,3\n259#1:372,2\n262#1:374\n262#1:376,7\n262#1:375\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m305deprecated_of(@NotNull ByteBuffer buffer) {
            g0.p(buffer, "buffer");
            return of(buffer);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull ByteBuffer byteBuffer) {
            g0.p(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        private Companion() {
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                charset = kotlin.text.e.f47851b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                i6 = 0;
            }
            if ((i8 & 2) != 0) {
                i7 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i6, i7);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @JvmName(name = "-deprecated_decodeBase64")
        @Nullable
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m301deprecated_decodeBase64(@NotNull String string) {
            g0.p(string, "string");
            return decodeBase64(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        @NotNull
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m302deprecated_decodeHex(@NotNull String string) {
            g0.p(string, "string");
            return decodeHex(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        @NotNull
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m303deprecated_encodeString(@NotNull String string, @NotNull Charset charset) {
            g0.p(string, "string");
            g0.p(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        @NotNull
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m304deprecated_encodeUtf8(@NotNull String string) {
            g0.p(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m306deprecated_of(@NotNull byte[] array, int i6, int i7) {
            g0.p(array, "array");
            return of(array, i6, i7);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        @NotNull
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m307deprecated_read(@NotNull InputStream inputstream, int i6) {
            g0.p(inputstream, "inputstream");
            return read(inputstream, i6);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String str) {
            g0.p(str, "<this>");
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String str) {
            g0.p(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = i6 * 2;
                bArr[i6] = (byte) ((ByteStringNonJs.decodeHexDigit(str.charAt(i7)) << 4) + ByteStringNonJs.decodeHexDigit(str.charAt(i7 + 1)));
            }
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = "encodeString")
        @NotNull
        public final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
            g0.p(str, "<this>");
            g0.p(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            g0.o(bytes, "getBytes(...)");
            return new ByteString(bytes);
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String str) {
            g0.p(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        @JvmName(name = "read")
        @NotNull
        public final ByteString read(@NotNull InputStream inputStream, int i6) throws IOException {
            g0.p(inputStream, "<this>");
            if (i6 < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + i6).toString());
            }
            byte[] bArr = new byte[i6];
            int i7 = 0;
            while (i7 < i6) {
                int read = inputStream.read(bArr, i7, i6 - i7);
                if (read == -1) {
                    throw new EOFException();
                }
                i7 += read;
            }
            return new ByteString(bArr);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... data) {
            g0.p(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            g0.o(copyOf, "copyOf(...)");
            return new ByteString(copyOf);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull byte[] bArr, int i6, int i7) {
            g0.p(bArr, "<this>");
            int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i7);
            SegmentedByteString.checkOffsetAndCount(bArr.length, i6, resolveDefaultParameter);
            return new ByteString(n.f1(bArr, i6, resolveDefaultParameter + i6));
        }
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return byteString.indexOf(byteString2, i6);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i7 & 2) != 0) {
            i6 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i6);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    public final boolean endsWith(@NotNull ByteString suffix) {
        g0.p(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString other) {
        g0.p(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString other) {
        g0.p(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int i6, @NotNull ByteString other, int i7, int i8) {
        g0.p(other, "other");
        return other.rangeEquals(i7, getData$okio(), i6, i8);
    }

    public final boolean startsWith(@NotNull ByteString prefix) {
        g0.p(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        for (int i6 = 0; i6 < getData$okio().length; i6++) {
            byte b6 = getData$okio()[i6];
            if (b6 >= 65 && b6 <= 90) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                g0.o(copyOf, "copyOf(...)");
                copyOf[i6] = (byte) (b6 + 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b7 = copyOf[i7];
                    if (b7 >= 65 && b7 <= 90) {
                        copyOf[i7] = (byte) (b7 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        for (int i6 = 0; i6 < getData$okio().length; i6++) {
            byte b6 = getData$okio()[i6];
            if (b6 >= 97 && b6 <= 122) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                g0.o(copyOf, "copyOf(...)");
                copyOf[i6] = (byte) (b6 - 32);
                for (int i7 = i6 + 1; i7 < copyOf.length; i7++) {
                    byte b7 = copyOf[i7];
                    if (b7 >= 97 && b7 <= 122) {
                        copyOf[i7] = (byte) (b7 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public ByteString(@NotNull byte[] data) {
        g0.p(data, "data");
        this.data = data;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i6, byte[] bArr, int i7, int i8, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i9 & 1) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        byteString.copyInto(i6, bArr, i7, i8);
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return Companion.decodeBase64(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return Companion.decodeHex(str);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return byteString.indexOf(bArr, i6);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return Companion.of(bArr);
    }

    @JvmStatic
    @JvmName(name = "read")
    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i6) throws IOException {
        return Companion.read(inputStream, i6);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i6, int i7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        if ((i8 & 2) != 0) {
            i7 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.substring(i6, i7);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        g0.o(asReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return asReadOnlyBuffer;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull ByteString other) {
        g0.p(other, "other");
        int size = size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i6 = 0; i6 < min; i6++) {
            int i7 = getByte(i6) & 255;
            int i8 = other.getByte(i6) & 255;
            if (i7 != i8) {
                return i7 < i8 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public void copyInto(int i6, @NotNull byte[] target, int i7, int i8) {
        g0.p(target, "target");
        n.v0(getData$okio(), target, i7, i6, i8 + i6);
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        g0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] digest = messageDigest.digest();
        g0.m(digest);
        return new ByteString(digest);
    }

    public final boolean endsWith(@NotNull byte[] suffix) {
        g0.p(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @NotNull
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    @Nullable
    public final String getUtf8$okio() {
        return this.utf8;
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        g0.p(algorithm, "algorithm");
        g0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            g0.o(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString key) {
        g0.p(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString key) {
        g0.p(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString key) {
        g0.p(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] other) {
        g0.p(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] other) {
        g0.p(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    @NotNull
    public final ByteString md5() {
        return digest$okio(by.f10823a);
    }

    public boolean rangeEquals(int i6, @NotNull byte[] other, int i7, int i8) {
        g0.p(other, "other");
        return i6 >= 0 && i6 <= getData$okio().length - i8 && i7 >= 0 && i7 <= other.length - i8 && SegmentedByteString.arrayRangeEquals(getData$okio(), i6, other, i7, i8);
    }

    public final void setHashCode$okio(int i6) {
        this.hashCode = i6;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final boolean startsWith(@NotNull byte[] prefix) {
        g0.p(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        g0.p(charset, "charset");
        return new String(this.data, charset);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring(int i6) {
        return substring$default(this, i6, 0, 2, null);
    }

    public void write(@NotNull OutputStream out) throws IOException {
        g0.p(out, "out");
        out.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int i6, int i7) {
        g0.p(buffer, "buffer");
        okio.internal.ByteString.commonWrite(this, buffer, i6, i7);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i7 & 2) != 0) {
            i6 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(bArr, i6);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i6, int i7) {
        return Companion.of(bArr, i6, i7);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m299deprecated_getByte(int i6) {
        return getByte(i6);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m300deprecated_size() {
        return size();
    }

    @NotNull
    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    @JvmName(name = "getByte")
    public final byte getByte(int i6) {
        return internalGet$okio(i6);
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i6 = 0;
        for (byte b6 : getData$okio()) {
            int i7 = i6 + 1;
            cArr[i6] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b6 >> 4) & 15];
            i6 += 2;
            cArr[i7] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[b6 & 15];
        }
        return u.J1(cArr);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString other, int i6) {
        g0.p(other, "other");
        return indexOf(other.internalArray$okio(), i6);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i6) {
        return getData$okio()[i6];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString other, int i6) {
        g0.p(other, "other");
        return lastIndexOf(other.internalArray$okio(), i6);
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int i6, int i7) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i7);
        if (i6 >= 0) {
            if (resolveDefaultParameter <= getData$okio().length) {
                if (resolveDefaultParameter - i6 >= 0) {
                    return (i6 == 0 && resolveDefaultParameter == getData$okio().length) ? this : new ByteString(n.f1(getData$okio(), i6, resolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        g0.o(copyOf, "copyOf(...)");
        return copyOf;
    }

    @NotNull
    public String toString() {
        ByteString byteString;
        if (getData$okio().length != 0) {
            int codePointIndexToCharIndex = okio.internal.ByteString.codePointIndexToCharIndex(getData$okio(), 64);
            if (codePointIndexToCharIndex == -1) {
                if (getData$okio().length <= 64) {
                    return "[hex=" + hex() + ']';
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[size=");
                sb.append(getData$okio().length);
                sb.append(" hex=");
                int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, 64);
                if (resolveDefaultParameter <= getData$okio().length) {
                    if (resolveDefaultParameter >= 0) {
                        if (resolveDefaultParameter == getData$okio().length) {
                            byteString = this;
                        } else {
                            byteString = new ByteString(n.f1(getData$okio(), 0, resolveDefaultParameter));
                        }
                        sb.append(byteString.hex());
                        sb.append("…]");
                        return sb.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex");
                }
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
            String utf8 = utf8();
            String substring = utf8.substring(0, codePointIndexToCharIndex);
            g0.o(substring, "substring(...)");
            String x22 = u.x2(u.x2(u.x2(substring, "\\", "\\\\", false, 4, null), com.snail.antifake.deviceid.e.f37542d, "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + getData$okio().length + " text=" + x22 + "…]";
            }
            return "[text=" + x22 + ']';
        }
        return "[size=0]";
    }

    @NotNull
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
            setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8$okio;
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] other, int i6) {
        g0.p(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i6, 0);
        if (max > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(getData$okio(), max, other, 0, other.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] other, int i6) {
        g0.p(other, "other");
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(this, i6), getData$okio().length - other.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }
}
