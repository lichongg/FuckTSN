package okio;

import com.baidu.mobads.sdk.internal.by;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class HashingSource extends ForwardingSource implements Source {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final Mac mac;

    @Nullable
    private final MessageDigest messageDigest;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString key) {
            g0.p(source, "source");
            g0.p(key, "key");
            return new HashingSource(source, key, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString key) {
            g0.p(source, "source");
            g0.p(key, "key");
            return new HashingSource(source, key, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString key) {
            g0.p(source, "source");
            g0.p(key, "key");
            return new HashingSource(source, key, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSource md5(@NotNull Source source) {
            g0.p(source, "source");
            return new HashingSource(source, by.f10823a);
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha1(@NotNull Source source) {
            g0.p(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha256(@NotNull Source source) {
            g0.p(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource sha512(@NotNull Source source) {
            g0.p(source, "source");
            return new HashingSource(source, "SHA-512");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull MessageDigest digest) {
        super(source);
        g0.p(source, "source");
        g0.p(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha1(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha256(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource hmacSha512(@NotNull Source source, @NotNull ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource md5(@NotNull Source source) {
        return Companion.md5(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha1(@NotNull Source source) {
        return Companion.sha1(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha256(@NotNull Source source) {
        return Companion.sha256(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource sha512(@NotNull Source source) {
        return Companion.sha512(source);
    }

    @JvmName(name = "hash")
    @NotNull
    public final ByteString hash() {
        byte[] doFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            doFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            g0.m(mac);
            doFinal = mac.doFinal();
        }
        g0.m(doFinal);
        return new ByteString(doFinal);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(@NotNull Buffer sink, long j6) throws IOException {
        g0.p(sink, "sink");
        long read = super.read(sink, j6);
        if (read != -1) {
            long size = sink.size() - read;
            long size2 = sink.size();
            Segment segment = sink.head;
            g0.m(segment);
            while (size2 > size) {
                segment = segment.prev;
                g0.m(segment);
                size2 -= segment.limit - segment.pos;
            }
            while (size2 < sink.size()) {
                int i6 = (int) ((segment.pos + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i6, segment.limit - i6);
                } else {
                    Mac mac = this.mac;
                    g0.m(mac);
                    mac.update(segment.data, i6, segment.limit - i6);
                }
                size2 += segment.limit - segment.pos;
                segment = segment.next;
                g0.m(segment);
                size = size2;
            }
        }
        return read;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    @JvmName(name = "-deprecated_hash")
    @NotNull
    /* renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m316deprecated_hash() {
        return hash();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HashingSource(@org.jetbrains.annotations.NotNull okio.Source r2, @org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.g0.p(r3, r0)
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)
            java.lang.String r0 = "getInstance(...)"
            kotlin.jvm.internal.g0.o(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, java.lang.String):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull Mac mac) {
        super(source);
        g0.p(source, "source");
        g0.p(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HashingSource(@org.jetbrains.annotations.NotNull okio.Source r3, @org.jetbrains.annotations.NotNull okio.ByteString r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.g0.p(r3, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.g0.p(r4, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.g0.p(r5, r0)
            javax.crypto.Mac r0 = javax.crypto.Mac.getInstance(r5)     // Catch: java.security.InvalidKeyException -> L28
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch: java.security.InvalidKeyException -> L28
            byte[] r4 = r4.toByteArray()     // Catch: java.security.InvalidKeyException -> L28
            r1.<init>(r4, r5)     // Catch: java.security.InvalidKeyException -> L28
            r0.init(r1)     // Catch: java.security.InvalidKeyException -> L28
            kotlin.n1 r4 = kotlin.n1.f44123a     // Catch: java.security.InvalidKeyException -> L28
            kotlin.jvm.internal.g0.m(r0)
            r2.<init>(r3, r0)
            return
        L28:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, okio.ByteString, java.lang.String):void");
    }
}
