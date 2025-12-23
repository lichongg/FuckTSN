package io.netty.handler.codec.http.cors;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class CorsConfigBuilder {
    boolean allowCredentials;
    boolean allowNullOrigin;
    final boolean anyOrigin;
    boolean enabled;
    final Set<String> exposeHeaders;
    long maxAge;
    private boolean noPreflightHeaders;
    final Set<String> origins;
    final Map<CharSequence, Callable<?>> preflightHeaders;
    final Set<String> requestHeaders;
    final Set<HttpMethod> requestMethods;
    boolean shortCircuit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.cors.CorsConfigBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ConstantValueGenerator implements Callable<Object> {
        private final Object value;

        /* synthetic */ ConstantValueGenerator(Object obj, AnonymousClass1 anonymousClass1) {
            this(obj);
        }

        private ConstantValueGenerator(Object obj) {
            if (obj == null) {
                throw new IllegalArgumentException("value must not be null");
            }
            this.value = obj;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.value;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class DateValueGenerator implements Callable<Date> {
        static final DateValueGenerator INSTANCE = new DateValueGenerator();

        @Override // java.util.concurrent.Callable
        public Date call() throws Exception {
            return new Date();
        }

        private DateValueGenerator() {
        }
    }

    CorsConfigBuilder(String... strArr) {
        this.enabled = true;
        this.exposeHeaders = new HashSet();
        this.requestMethods = new HashSet();
        this.requestHeaders = new HashSet();
        this.preflightHeaders = new HashMap();
        this.origins = new LinkedHashSet(Arrays.asList(strArr));
        this.anyOrigin = false;
    }

    public CorsConfigBuilder allowCredentials() {
        this.allowCredentials = true;
        return this;
    }

    public CorsConfigBuilder allowNullOrigin() {
        this.allowNullOrigin = true;
        return this;
    }

    public CorsConfigBuilder allowedRequestHeaders(String... strArr) {
        this.requestHeaders.addAll(Arrays.asList(strArr));
        return this;
    }

    public CorsConfigBuilder disable() {
        this.enabled = false;
        return this;
    }

    public CorsConfigBuilder exposeHeaders(String... strArr) {
        this.exposeHeaders.addAll(Arrays.asList(strArr));
        return this;
    }

    public CorsConfigBuilder noPreflightResponseHeaders() {
        this.noPreflightHeaders = true;
        return this;
    }

    public CorsConfigBuilder preflightResponseHeader(CharSequence charSequence, Object... objArr) {
        if (objArr.length == 1) {
            this.preflightHeaders.put(charSequence, new ConstantValueGenerator(objArr[0], null));
            return this;
        }
        preflightResponseHeader(charSequence, Arrays.asList(objArr));
        return this;
    }

    public CorsConfigBuilder shortCircuit() {
        this.shortCircuit = true;
        return this;
    }

    public static CorsConfigBuilder forAnyOrigin() {
        return new CorsConfigBuilder();
    }

    public static CorsConfigBuilder forOrigin(String str) {
        return "*".equals(str) ? new CorsConfigBuilder() : new CorsConfigBuilder(str);
    }

    public static CorsConfigBuilder forOrigins(String... strArr) {
        return new CorsConfigBuilder(strArr);
    }

    public CorsConfigBuilder allowedRequestHeaders(CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            this.requestHeaders.add(charSequence.toString());
        }
        return this;
    }

    public CorsConfigBuilder allowedRequestMethods(HttpMethod... httpMethodArr) {
        this.requestMethods.addAll(Arrays.asList(httpMethodArr));
        return this;
    }

    public CorsConfig build() {
        if (this.preflightHeaders.isEmpty() && !this.noPreflightHeaders) {
            this.preflightHeaders.put(HttpHeaderNames.DATE, DateValueGenerator.INSTANCE);
            this.preflightHeaders.put(HttpHeaderNames.CONTENT_LENGTH, new ConstantValueGenerator("0", null));
        }
        return new CorsConfig(this);
    }

    public CorsConfigBuilder exposeHeaders(CharSequence... charSequenceArr) {
        for (CharSequence charSequence : charSequenceArr) {
            this.exposeHeaders.add(charSequence.toString());
        }
        return this;
    }

    public CorsConfigBuilder maxAge(long j6) {
        this.maxAge = j6;
        return this;
    }

    public <T> CorsConfigBuilder preflightResponseHeader(CharSequence charSequence, Iterable<T> iterable) {
        this.preflightHeaders.put(charSequence, new ConstantValueGenerator(iterable, null));
        return this;
    }

    public <T> CorsConfigBuilder preflightResponseHeader(CharSequence charSequence, Callable<T> callable) {
        this.preflightHeaders.put(charSequence, callable);
        return this;
    }

    CorsConfigBuilder() {
        this.enabled = true;
        this.exposeHeaders = new HashSet();
        this.requestMethods = new HashSet();
        this.requestHeaders = new HashSet();
        this.preflightHeaders = new HashMap();
        this.anyOrigin = true;
        this.origins = Collections.EMPTY_SET;
    }
}
