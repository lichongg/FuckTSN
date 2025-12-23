package okhttp3.internal.ws;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.impl.km.f;
import kotlin.text.u;
import okhttp3.Headers;
import okhttp3.internal._UtilCommonKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@IgnoreJRERequirement
/* loaded from: D:\Downloads\app\classes4.dex */
public final class WebSocketExtensions {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @JvmField
    @Nullable
    public final Integer clientMaxWindowBits;

    @JvmField
    public final boolean clientNoContextTakeover;

    @JvmField
    public final boolean perMessageDeflate;

    @JvmField
    @Nullable
    public final Integer serverMaxWindowBits;

    @JvmField
    public final boolean serverNoContextTakeover;

    @JvmField
    public final boolean unknownValues;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers responseHeaders) throws IOException {
            g0.p(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            boolean z5 = false;
            Integer num = null;
            boolean z6 = false;
            Integer num2 = null;
            boolean z7 = false;
            boolean z8 = false;
            for (int i6 = 0; i6 < size; i6++) {
                if (u.a2(responseHeaders.name(i6), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String value = responseHeaders.value(i6);
                    int i7 = 0;
                    while (i7 < value.length()) {
                        int i8 = i7;
                        int delimiterOffset$default = _UtilCommonKt.delimiterOffset$default(value, StringUtil.COMMA, i8, 0, 4, (Object) null);
                        int delimiterOffset = _UtilCommonKt.delimiterOffset(value, ';', i8, delimiterOffset$default);
                        String trimSubstring = _UtilCommonKt.trimSubstring(value, i8, delimiterOffset);
                        int i9 = delimiterOffset + 1;
                        if (u.a2(trimSubstring, "permessage-deflate", true)) {
                            if (!z5) {
                                z8 = true;
                                while (i9 < delimiterOffset$default) {
                                    int delimiterOffset2 = _UtilCommonKt.delimiterOffset(value, ';', i9, delimiterOffset$default);
                                    int delimiterOffset3 = _UtilCommonKt.delimiterOffset(value, '=', i9, delimiterOffset2);
                                    String trimSubstring2 = _UtilCommonKt.trimSubstring(value, i9, delimiterOffset3);
                                    String E4 = delimiterOffset3 < delimiterOffset2 ? u.E4(_UtilCommonKt.trimSubstring(value, delimiterOffset3 + 1, delimiterOffset2), "\"") : null;
                                    int i10 = delimiterOffset2 + 1;
                                    if (u.a2(trimSubstring2, "client_max_window_bits", true)) {
                                        if (num != null) {
                                            z8 = true;
                                        }
                                        num = E4 != null ? u.n1(E4) : null;
                                        i9 = num == null ? i10 : i10;
                                    } else if (u.a2(trimSubstring2, "client_no_context_takeover", true)) {
                                        if (z6) {
                                            z8 = true;
                                        }
                                        if (E4 != null) {
                                            z8 = true;
                                        }
                                        i9 = i10;
                                        z6 = true;
                                    } else if (u.a2(trimSubstring2, "server_max_window_bits", true)) {
                                        if (num2 != null) {
                                            z8 = true;
                                        }
                                        num2 = E4 != null ? u.n1(E4) : null;
                                        if (num2 == null) {
                                        }
                                    } else if (u.a2(trimSubstring2, "server_no_context_takeover", true)) {
                                        if (z7) {
                                            z8 = true;
                                        }
                                        if (E4 != null) {
                                            z8 = true;
                                        }
                                        i9 = i10;
                                        z7 = true;
                                    }
                                }
                                i7 = i9;
                                z5 = true;
                            }
                            z8 = true;
                        } else {
                            i7 = i9;
                            z8 = true;
                        }
                    }
                }
            }
            return new WebSocketExtensions(z5, num, z6, num2, z7, z8);
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && g0.g(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && g0.g(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public WebSocketExtensions(boolean z5, @Nullable Integer num, boolean z6, @Nullable Integer num2, boolean z7, boolean z8) {
        this.perMessageDeflate = z5;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z6;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z7;
        this.unknownValues = z8;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z5, Integer num, boolean z6, Integer num2, boolean z7, boolean z8, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            z5 = webSocketExtensions.perMessageDeflate;
        }
        if ((i6 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i6 & 4) != 0) {
            z6 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i6 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i6 & 16) != 0) {
            z7 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i6 & 32) != 0) {
            z8 = webSocketExtensions.unknownValues;
        }
        boolean z9 = z7;
        boolean z10 = z8;
        return webSocketExtensions.copy(z5, num, z6, num2, z9, z10);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    @Nullable
    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean z5, @Nullable Integer num, boolean z6, @Nullable Integer num2, boolean z7, boolean z8) {
        return new WebSocketExtensions(z5, num, z6, num2, z7, z8);
    }

    public int hashCode() {
        int a6 = f.a(this.perMessageDeflate) * 31;
        Integer num = this.clientMaxWindowBits;
        int hashCode = (((a6 + (num == null ? 0 : num.hashCode())) * 31) + f.a(this.clientNoContextTakeover)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        return ((((hashCode + (num2 != null ? num2.hashCode() : 0)) * 31) + f.a(this.serverNoContextTakeover)) * 31) + f.a(this.unknownValues);
    }

    public final boolean noContextTakeover(boolean z5) {
        return z5 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public /* synthetic */ WebSocketExtensions(boolean z5, Integer num, boolean z6, Integer num2, boolean z7, boolean z8, int i6, v vVar) {
        this((i6 & 1) != 0 ? false : z5, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? false : z6, (i6 & 8) != 0 ? null : num2, (i6 & 16) != 0 ? false : z7, (i6 & 32) != 0 ? false : z8);
    }
}
