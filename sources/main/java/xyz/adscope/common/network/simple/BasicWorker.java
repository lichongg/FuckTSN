package xyz.adscope.common.network.simple;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.Callable;
import xyz.adscope.common.network.Headers;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.exception.NoCacheError;
import xyz.adscope.common.network.exception.ParseError;
import xyz.adscope.common.network.simple.SimpleRequest;
import xyz.adscope.common.network.simple.cache.Cache;
import xyz.adscope.common.network.simple.cache.CacheMode;
import xyz.adscope.common.network.simple.cache.CacheStore;
import xyz.adscope.common.network.util.IOUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
abstract class BasicWorker<T extends SimpleRequest, Succeed, Failed> implements Callable<SimpleResponse<Succeed, Failed>> {

    /* renamed from: f, reason: collision with root package name */
    private static final long f56663f = System.currentTimeMillis() + 3153600000000L;

    /* renamed from: a, reason: collision with root package name */
    private final T f56664a;

    /* renamed from: b, reason: collision with root package name */
    private final CacheStore f56665b = Kalle.getConfig().getCacheStore();

    /* renamed from: c, reason: collision with root package name */
    private final Converter f56666c;

    /* renamed from: d, reason: collision with root package name */
    private final Type f56667d;

    /* renamed from: e, reason: collision with root package name */
    private final Type f56668e;

    private void a() {
        Cache cache;
        int i6 = AnonymousClass1.f56669a[this.f56664a.cacheMode().ordinal()];
        if ((i6 == 1 || i6 == 2) && (cache = this.f56665b.get(this.f56664a.cacheKey())) != null) {
            a(cache.getHeaders());
        }
    }

    private Response b() {
        Cache cache;
        int i6 = AnonymousClass1.f56669a[this.f56664a.cacheMode().ordinal()];
        if (i6 == 1) {
            Cache cache2 = this.f56665b.get(this.f56664a.cacheKey());
            if (cache2 != null && cache2.getExpires() > System.currentTimeMillis()) {
                return a(cache2.getCode(), cache2.getHeaders(), cache2.getBody());
            }
        } else {
            if (i6 == 7) {
                Cache cache3 = this.f56665b.get(this.f56664a.cacheKey());
                if (cache3 != null) {
                    return a(cache3.getCode(), cache3.getHeaders(), cache3.getBody());
                }
                throw new NoCacheError("No cache found.");
            }
            if ((i6 == 8 || i6 == 9) && (cache = this.f56665b.get(this.f56664a.cacheKey())) != null) {
                return a(cache.getCode(), cache.getHeaders(), cache.getBody());
            }
        }
        return null;
    }

    protected abstract Response a(T t5);

    public abstract void cancel();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.simple.BasicWorker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56669a;

        static {
            int[] iArr = new int[CacheMode.values().length];
            f56669a = iArr;
            try {
                iArr[CacheMode.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56669a[CacheMode.HTTP_YES_THEN_WRITE_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56669a[CacheMode.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56669a[CacheMode.NETWORK_YES_THEN_HTTP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f56669a[CacheMode.NETWORK_YES_THEN_WRITE_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f56669a[CacheMode.NETWORK_NO_THEN_READ_CACHE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f56669a[CacheMode.READ_CACHE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f56669a[CacheMode.READ_CACHE_NO_THEN_NETWORK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f56669a[CacheMode.READ_CACHE_NO_THEN_HTTP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public final SimpleResponse<Succeed, Failed> call() {
        Response b6 = b();
        if (b6 != null) {
            return a(b6, true);
        }
        a();
        try {
            try {
                Response a6 = a((BasicWorker<T, Succeed, Failed>) this.f56664a);
                int code = a6.code();
                if (code == 304) {
                    Response a7 = a(-1);
                    if (a7 != null) {
                        SimpleResponse<Succeed, Failed> a8 = a(a7, true);
                        IOUtils.closeQuietly(a6);
                        return a8;
                    }
                    SimpleResponse<Succeed, Failed> a9 = a(a6, false);
                    IOUtils.closeQuietly(a6);
                    return a9;
                }
                Headers headers = a6.headers();
                byte[] bArr = new byte[0];
                if (code != 204 && code != 302) {
                    bArr = a6.body().byteArray();
                }
                String locationUrl = a6.locationUrl();
                IOUtils.closeQuietly(a6);
                b(code, headers, bArr);
                Response a10 = a(code, headers, bArr, locationUrl);
                SimpleResponse<Succeed, Failed> a11 = a(a10, false);
                IOUtils.closeQuietly(a10);
                return a11;
            } catch (IOException e6) {
                Response a12 = a(-1);
                if (a12 == null) {
                    throw e6;
                }
                SimpleResponse<Succeed, Failed> a13 = a(a12, true);
                IOUtils.closeQuietly(b6);
                return a13;
            }
        } catch (Throwable th) {
            IOUtils.closeQuietly(b6);
            throw th;
        }
    }

    BasicWorker(T t5, Type type, Type type2) {
        Converter converter;
        this.f56664a = t5;
        this.f56667d = type;
        this.f56668e = type2;
        if (t5.converter() == null) {
            converter = Kalle.getConfig().getConverter();
        } else {
            converter = t5.converter();
        }
        this.f56666c = converter;
    }

    private Response a(int i6) {
        Cache cache;
        Cache cache2;
        int i7 = AnonymousClass1.f56669a[this.f56664a.cacheMode().ordinal()];
        if (i7 == 1 || i7 == 2) {
            if (i6 != 304 || (cache = this.f56665b.get(this.f56664a.cacheKey())) == null) {
                return null;
            }
            return a(cache.getCode(), cache.getHeaders(), cache.getBody());
        }
        if (i7 == 6) {
            Cache cache3 = this.f56665b.get(this.f56664a.cacheKey());
            if (cache3 != null) {
                return a(cache3.getCode(), cache3.getHeaders(), cache3.getBody());
            }
            return null;
        }
        if (i7 == 9 && i6 == 304 && (cache2 = this.f56665b.get(this.f56664a.cacheKey())) != null) {
            return a(cache2.getCode(), cache2.getHeaders(), cache2.getBody());
        }
        return null;
    }

    private void b(int i6, Headers headers, byte[] bArr) {
        int i7 = AnonymousClass1.f56669a[this.f56664a.cacheMode().ordinal()];
        if (i7 == 1) {
            long analysisCacheExpires = Headers.analysisCacheExpires(headers);
            if (analysisCacheExpires > 0 || headers.getLastModified() > 0) {
                a(i6, headers, bArr, analysisCacheExpires);
                return;
            }
            return;
        }
        if (i7 == 2) {
            a(i6, headers, bArr, f56663f);
            return;
        }
        if (i7 == 4) {
            long analysisCacheExpires2 = Headers.analysisCacheExpires(headers);
            if (analysisCacheExpires2 > 0 || headers.getLastModified() > 0) {
                a(i6, headers, bArr, analysisCacheExpires2);
                return;
            }
            return;
        }
        if (i7 == 5) {
            a(i6, headers, bArr, f56663f);
            return;
        }
        if (i7 != 9) {
            return;
        }
        long analysisCacheExpires3 = Headers.analysisCacheExpires(headers);
        if (analysisCacheExpires3 > 0 || headers.getLastModified() > 0) {
            a(i6, headers, bArr, analysisCacheExpires3);
        }
    }

    private void a(Headers headers) {
        Headers headers2 = this.f56664a.headers();
        String eTag = headers.getETag();
        if (eTag != null) {
            headers2.set("If-None-Match", eTag);
        }
        long lastModified = headers.getLastModified();
        if (lastModified > 0) {
            headers2.set("If-Modified-Since", Headers.formatMillisToGMT(lastModified));
        }
    }

    private void a(int i6, Headers headers, byte[] bArr, long j6) {
        String cacheKey = this.f56664a.cacheKey();
        Cache cache = new Cache();
        cache.setKey(cacheKey);
        cache.setCode(i6);
        cache.setHeaders(headers);
        cache.setBody(bArr);
        cache.setExpires(j6);
        this.f56665b.replace(cacheKey, cache);
    }

    private Response a(int i6, Headers headers, byte[] bArr, String str) {
        return Response.newBuilder().code(i6).headers(headers).body(new ByteArrayBody(headers.getContentType(), bArr)).locationUrl(str).build();
    }

    private Response a(int i6, Headers headers, byte[] bArr) {
        return Response.newBuilder().code(i6).headers(headers).body(new ByteArrayBody(headers.getContentType(), bArr)).build();
    }

    private SimpleResponse<Succeed, Failed> a(Response response, boolean z5) {
        try {
            return this.f56666c.convert(this.f56667d, this.f56668e, response, z5);
        } catch (IOException e6) {
            throw e6;
        } catch (Exception e7) {
            throw new ParseError("An exception occurred while parsing the data.", e7);
        }
    }
}
