package okhttp3.internal.http2;

import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Socket;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {

    @NotNull
    private static final String KEEP_ALIVE = "keep-alive";
    private volatile boolean canceled;

    @NotNull
    private final ExchangeCodec.Carrier carrier;

    @NotNull
    private final RealInterceptorChain chain;

    @NotNull
    private final Http2Connection http2Connection;

    @NotNull
    private final Protocol protocol;

    @Nullable
    private volatile Http2Stream stream;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String CONNECTION = "connection";

    @NotNull
    private static final String HOST = "host";

    @NotNull
    private static final String PROXY_CONNECTION = "proxy-connection";

    @NotNull
    private static final String TE = "te";

    @NotNull
    private static final String TRANSFER_ENCODING = "transfer-encoding";

    @NotNull
    private static final String ENCODING = "encoding";

    @NotNull
    private static final String UPGRADE = "upgrade";

    @NotNull
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = _UtilJvmKt.immutableListOf(CONNECTION, HOST, "keep-alive", PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);

    @NotNull
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = _UtilJvmKt.immutableListOf(CONNECTION, HOST, "keep-alive", PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<Header> http2HeadersList(@NotNull Request request) {
            g0.p(request, "request");
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String header = request.header("Host");
            if (header != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i6 = 0; i6 < size; i6++) {
                String name = headers.name(i6);
                Locale US = Locale.US;
                g0.o(US, "US");
                String lowerCase = name.toLowerCase(US);
                g0.o(lowerCase, "toLowerCase(...)");
                if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (g0.g(lowerCase, Http2ExchangeCodec.TE) && g0.g(headers.value(i6), HttpHeaders.Values.TRAILERS))) {
                    arrayList.add(new Header(lowerCase, headers.value(i6)));
                }
            }
            return arrayList;
        }

        @NotNull
        public final Response.Builder readHttp2HeadersList(@NotNull Headers headerBlock, @NotNull Protocol protocol) {
            g0.p(headerBlock, "headerBlock");
            g0.p(protocol, "protocol");
            Headers.Builder builder = new Headers.Builder();
            int size = headerBlock.size();
            StatusLine statusLine = null;
            for (int i6 = 0; i6 < size; i6++) {
                String name = headerBlock.name(i6);
                String value = headerBlock.value(i6);
                if (g0.g(name, Header.RESPONSE_STATUS_UTF8)) {
                    statusLine = StatusLine.Companion.parse("HTTP/1.1 " + value);
                } else if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Http2ExchangeCodec(@NotNull OkHttpClient client, @NotNull ExchangeCodec.Carrier carrier, @NotNull RealInterceptorChain chain, @NotNull Http2Connection http2Connection) {
        g0.p(client, "client");
        g0.p(carrier, "carrier");
        g0.p(chain, "chain");
        g0.p(http2Connection, "http2Connection");
        this.carrier = carrier;
        this.chain = chain;
        this.http2Connection = http2Connection;
        List<Protocol> protocols = client.protocols();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request request, long j6) {
        g0.p(request, "request");
        Http2Stream http2Stream = this.stream;
        g0.m(http2Stream);
        return http2Stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        Http2Stream http2Stream = this.stream;
        g0.m(http2Stream);
        http2Stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public ExchangeCodec.Carrier getCarrier() {
        return this.carrier;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Socket getSocket() {
        Http2Stream http2Stream = this.stream;
        g0.m(http2Stream);
        return http2Stream;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public boolean isResponseComplete() {
        Http2Stream http2Stream = this.stream;
        return http2Stream != null && http2Stream.isSourceComplete();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response response) {
        g0.p(response, "response");
        Http2Stream http2Stream = this.stream;
        g0.m(http2Stream);
        return http2Stream.getSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Headers peekTrailers() {
        Http2Stream http2Stream = this.stream;
        g0.m(http2Stream);
        return http2Stream.peekTrailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Response.Builder readResponseHeaders(boolean z5) {
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) {
            throw new IOException("stream wasn't created");
        }
        Response.Builder readHttp2HeadersList = Companion.readHttp2HeadersList(http2Stream.takeHeaders(z5), this.protocol);
        if (z5 && readHttp2HeadersList.getCode$okhttp() == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response response) {
        g0.p(response, "response");
        if (okhttp3.internal.http.HttpHeaders.promisesBody(response)) {
            return _UtilJvmKt.headersContentLength(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request request) {
        g0.p(request, "request");
        if (this.stream != null) {
            return;
        }
        this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), request.body() != null);
        if (this.canceled) {
            Http2Stream http2Stream = this.stream;
            g0.m(http2Stream);
            http2Stream.closeLater(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream2 = this.stream;
        g0.m(http2Stream2);
        Timeout readTimeout = http2Stream2.readTimeout();
        long readTimeoutMillis$okhttp = this.chain.getReadTimeoutMillis$okhttp();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        readTimeout.timeout(readTimeoutMillis$okhttp, timeUnit);
        Http2Stream http2Stream3 = this.stream;
        g0.m(http2Stream3);
        http2Stream3.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), timeUnit);
    }
}
