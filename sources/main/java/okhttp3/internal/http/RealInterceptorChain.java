package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nRealInterceptorChain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealInterceptorChain.kt\nokhttp3/internal/http/RealInterceptorChain\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n1#2:140\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class RealInterceptorChain implements Interceptor.Chain {

    @NotNull
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;

    @Nullable
    private final Exchange exchange;
    private final int index;

    @NotNull
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;

    @NotNull
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(@NotNull RealCall call, @NotNull List<? extends Interceptor> interceptors, int i6, @Nullable Exchange exchange, @NotNull Request request, int i7, int i8, int i9) {
        g0.p(call, "call");
        g0.p(interceptors, "interceptors");
        g0.p(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i6;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i7;
        this.readTimeoutMillis = i8;
        this.writeTimeoutMillis = i9;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i6, Exchange exchange, Request request, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = realInterceptorChain.index;
        }
        if ((i10 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        if ((i10 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        if ((i10 & 8) != 0) {
            i7 = realInterceptorChain.connectTimeoutMillis;
        }
        if ((i10 & 16) != 0) {
            i8 = realInterceptorChain.readTimeoutMillis;
        }
        if ((i10 & 32) != 0) {
            i9 = realInterceptorChain.writeTimeoutMillis;
        }
        int i11 = i8;
        int i12 = i9;
        return realInterceptorChain.copy$okhttp(i6, exchange, request, i7, i11, i12);
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @Nullable
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.getConnection$okhttp();
        }
        return null;
    }

    @NotNull
    public final RealInterceptorChain copy$okhttp(int i6, @Nullable Exchange exchange, @NotNull Request request, int i7, int i8, int i9) {
        g0.p(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i6, exchange, request, i7, i8, i9);
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    @Nullable
    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    @NotNull
    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Response proceed(@NotNull Request request) throws IOException {
        g0.p(request, "request");
        if (this.index >= this.interceptors.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            if (!exchange.getFinder$okhttp().getRoutePlanner().sameHostAndPort(request.url())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        RealInterceptorChain copy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response intercept = interceptor.intercept(copy$okhttp$default);
        if (intercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.exchange == null || this.index + 1 >= this.interceptors.size() || copy$okhttp$default.calls == 1) {
            return intercept;
        }
        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withConnectTimeout(int i6, @NotNull TimeUnit unit) {
        g0.p(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, _UtilJvmKt.checkDuration("connectTimeout", i6, unit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withReadTimeout(int i6, @NotNull TimeUnit unit) {
        g0.p(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, _UtilJvmKt.checkDuration("readTimeout", i6, unit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withWriteTimeout(int i6, @NotNull TimeUnit unit) {
        g0.p(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, _UtilJvmKt.checkDuration("writeTimeout", i6, unit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
