package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.Protocol;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class StatusLine {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    public final int code;

    @JvmField
    @NotNull
    public final String message;

    @JvmField
    @NotNull
    public final Protocol protocol;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final StatusLine get(@NotNull Response response) {
            g0.p(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        @NotNull
        public final StatusLine parse(@NotNull String statusLine) throws IOException {
            Protocol protocol;
            int i6;
            String str;
            g0.p(statusLine, "statusLine");
            if (u.H2(statusLine, "HTTP/1.", false, 2, null)) {
                i6 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                int charAt = statusLine.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (charAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else if (u.H2(statusLine, "ICY ", false, 2, null)) {
                protocol = Protocol.HTTP_1_0;
                i6 = 4;
            } else {
                if (!u.H2(statusLine, "SOURCETABLE ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                protocol = Protocol.HTTP_1_1;
                i6 = 12;
            }
            int i7 = i6 + 3;
            if (statusLine.length() < i7) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            String substring = statusLine.substring(i6, i7);
            g0.o(substring, "substring(...)");
            Integer n12 = u.n1(substring);
            if (n12 == null) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            int intValue = n12.intValue();
            if (statusLine.length() <= i7) {
                str = "";
            } else {
                if (statusLine.charAt(i7) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                str = statusLine.substring(i6 + 4);
                g0.o(str, "substring(...)");
            }
            return new StatusLine(protocol, intValue, str);
        }
    }

    public StatusLine(@NotNull Protocol protocol, int i6, @NotNull String message) {
        g0.p(protocol, "protocol");
        g0.p(message, "message");
        this.protocol = protocol;
        this.code = i6;
        this.message = message;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        return sb.toString();
    }
}
