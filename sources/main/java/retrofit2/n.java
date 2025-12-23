package retrofit2;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class n<T> implements retrofit2.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f52164a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f52165b;

    /* renamed from: c, reason: collision with root package name */
    private final Call.Factory f52166c;

    /* renamed from: d, reason: collision with root package name */
    private final g<ResponseBody, T> f52167d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f52168e;

    /* renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Call f52169f;

    /* renamed from: g, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Throwable f52170g;

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f52171h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f52172a;

        a(d dVar) {
            this.f52172a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.f52172a.a(n.this, th);
            } catch (Throwable th2) {
                f0.s(th2);
                th2.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                try {
                    this.f52172a.b(n.this, n.this.e(response));
                } catch (Throwable th) {
                    f0.s(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                f0.s(th2);
                a(th2);
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            a(iOException);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        private final ResponseBody f52174a;

        /* renamed from: b, reason: collision with root package name */
        private final BufferedSource f52175b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        IOException f52176c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends ForwardingSource {
            a(Source source) {
                super(source);
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer buffer, long j6) throws IOException {
                try {
                    return super.read(buffer, j6);
                } catch (IOException e6) {
                    b.this.f52176c = e6;
                    throw e6;
                }
            }
        }

        void a() throws IOException {
            IOException iOException = this.f52176c;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f52174a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f52174a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f52174a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            return this.f52175b;
        }

        b(ResponseBody responseBody) {
            this.f52174a = responseBody;
            this.f52175b = Okio.buffer(new a(responseBody.source()));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final MediaType f52178a;

        /* renamed from: b, reason: collision with root package name */
        private final long f52179b;

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f52179b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f52178a;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }

        c(@Nullable MediaType mediaType, long j6) {
            this.f52178a = mediaType;
            this.f52179b = j6;
        }
    }

    @Override // retrofit2.b
    public void cancel() {
        Call call;
        this.f52168e = true;
        synchronized (this) {
            call = this.f52169f;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.b
    public c0<T> execute() throws IOException {
        Call c6;
        synchronized (this) {
            if (this.f52171h) {
                throw new IllegalStateException("Already executed.");
            }
            this.f52171h = true;
            c6 = c();
        }
        if (this.f52168e) {
            c6.cancel();
        }
        return e(c6.execute());
    }

    @Override // retrofit2.b
    public synchronized boolean isExecuted() {
        return this.f52171h;
    }

    @Override // retrofit2.b
    public synchronized Request request() {
        try {
        } catch (IOException e6) {
            throw new RuntimeException("Unable to create request.", e6);
        }
        return c().request();
    }

    @Override // retrofit2.b
    public synchronized Timeout timeout() {
        try {
        } catch (IOException e6) {
            throw new RuntimeException("Unable to create call.", e6);
        }
        return c().timeout();
    }

    private Call b() throws IOException {
        Call newCall = this.f52166c.newCall(this.f52164a.a(this.f52165b));
        if (newCall != null) {
            return newCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @GuardedBy("this")
    private Call c() throws IOException {
        Call call = this.f52169f;
        if (call != null) {
            return call;
        }
        Throwable th = this.f52170g;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            Call b6 = b();
            this.f52169f = b6;
            return b6;
        } catch (IOException | Error | RuntimeException e6) {
            f0.s(e6);
            this.f52170g = e6;
            throw e6;
        }
    }

    @Override // retrofit2.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public n<T> clone() {
        return new n<>(this.f52164a, this.f52165b, this.f52166c, this.f52167d);
    }

    @Override // retrofit2.b
    public boolean isCanceled() {
        boolean z5 = true;
        if (this.f52168e) {
            return true;
        }
        synchronized (this) {
            try {
                Call call = this.f52169f;
                if (call == null || !call.isCanceled()) {
                    z5 = false;
                }
            } finally {
            }
        }
        return z5;
    }

    @Override // retrofit2.b
    public void j(d<T> dVar) {
        Call call;
        Throwable th;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            try {
                if (this.f52171h) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f52171h = true;
                call = this.f52169f;
                th = this.f52170g;
                if (call == null && th == null) {
                    try {
                        Call b6 = b();
                        this.f52169f = b6;
                        call = b6;
                    } catch (Throwable th2) {
                        th = th2;
                        f0.s(th);
                        this.f52170g = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.f52168e) {
            call.cancel();
        }
        call.enqueue(new a(dVar));
    }

    n(b0 b0Var, Object[] objArr, Call.Factory factory, g<ResponseBody, T> gVar) {
        this.f52164a = b0Var;
        this.f52165b = objArr;
        this.f52166c = factory;
        this.f52167d = gVar;
    }

    c0<T> e(Response response) throws IOException {
        ResponseBody body = response.body();
        Response build = response.newBuilder().body(new c(body.contentType(), body.contentLength())).build();
        int code = build.code();
        if (code >= 200 && code < 300) {
            if (code != 204 && code != 205) {
                b bVar = new b(body);
                try {
                    return c0.m(this.f52167d.convert(bVar), build);
                } catch (RuntimeException e6) {
                    bVar.a();
                    throw e6;
                }
            }
            body.close();
            return c0.m(null, build);
        }
        try {
            return c0.d(f0.a(body), build);
        } finally {
            body.close();
        }
    }
}
