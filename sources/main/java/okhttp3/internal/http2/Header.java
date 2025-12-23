package okhttp3.internal.http2;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Header {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final ByteString PSEUDO_PREFIX;

    @JvmField
    @NotNull
    public static final ByteString RESPONSE_STATUS;

    @NotNull
    public static final String RESPONSE_STATUS_UTF8 = ":status";

    @JvmField
    @NotNull
    public static final ByteString TARGET_AUTHORITY;

    @NotNull
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";

    @JvmField
    @NotNull
    public static final ByteString TARGET_METHOD;

    @NotNull
    public static final String TARGET_METHOD_UTF8 = ":method";

    @JvmField
    @NotNull
    public static final ByteString TARGET_PATH;

    @NotNull
    public static final String TARGET_PATH_UTF8 = ":path";

    @JvmField
    @NotNull
    public static final ByteString TARGET_SCHEME;

    @NotNull
    public static final String TARGET_SCHEME_UTF8 = ":scheme";

    @JvmField
    public final int hpackSize;

    @JvmField
    @NotNull
    public final ByteString name;

    @JvmField
    @NotNull
    public final ByteString value;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    public Header(@NotNull ByteString name, @NotNull ByteString value) {
        g0.p(name, "name");
        g0.p(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.size() + 32 + value.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return g0.g(this.name, header.name) && g0.g(this.value, header.value);
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PSEUDO_PREFIX = companion.encodeUtf8(":");
        RESPONSE_STATUS = companion.encodeUtf8(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = companion.encodeUtf8(TARGET_METHOD_UTF8);
        TARGET_PATH = companion.encodeUtf8(TARGET_PATH_UTF8);
        TARGET_SCHEME = companion.encodeUtf8(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = companion.encodeUtf8(TARGET_AUTHORITY_UTF8);
    }

    public static /* synthetic */ Header copy$default(Header header, ByteString byteString, ByteString byteString2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            byteString = header.name;
        }
        if ((i6 & 2) != 0) {
            byteString2 = header.value;
        }
        return header.copy(byteString, byteString2);
    }

    @NotNull
    public final ByteString component1() {
        return this.name;
    }

    @NotNull
    public final ByteString component2() {
        return this.value;
    }

    @NotNull
    public final Header copy(@NotNull ByteString name, @NotNull ByteString value) {
        g0.p(name, "name");
        g0.p(value, "value");
        return new Header(name, value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    @NotNull
    public String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Header(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.g0.p(r3, r0)
            okio.ByteString$Companion r0 = okio.ByteString.Companion
            okio.ByteString r2 = r0.encodeUtf8(r2)
            okio.ByteString r3 = r0.encodeUtf8(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Header.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(@NotNull ByteString name, @NotNull String value) {
        this(name, ByteString.Companion.encodeUtf8(value));
        g0.p(name, "name");
        g0.p(value, "value");
    }
}
