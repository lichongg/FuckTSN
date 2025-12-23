package com.acse.ottn;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k1 extends EventListener {

    /* renamed from: d, reason: collision with root package name */
    public static final String f4690d = "HttpEventListener";

    /* renamed from: e, reason: collision with root package name */
    public static final EventListener.Factory f4691e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final long f4692a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4693b;

    /* renamed from: c, reason: collision with root package name */
    public StringBuilder f4694c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements EventListener.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicLong f4695a = new AtomicLong(1);

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            return new k1(this.f4695a.getAndIncrement(), call.request().url(), System.nanoTime());
        }
    }

    public k1(long j6, HttpUrl httpUrl, long j7) {
        this.f4692a = j6;
        this.f4693b = j7;
        StringBuilder sb = new StringBuilder(httpUrl.toString());
        sb.append(" ");
        sb.append(j6);
        sb.append(":");
        this.f4694c = sb;
    }

    public final void a(String str) {
        long nanoTime = System.nanoTime() - this.f4693b;
        StringBuilder sb = this.f4694c;
        sb.append(String.format(Locale.CHINA, "%.3f-%s", Double.valueOf(nanoTime / 1.0E9d), str));
        sb.append(";");
        if (!str.equalsIgnoreCase("callEnd") && !str.equalsIgnoreCase("callFailed")) {
            return;
        }
        c2.a(f4690d, this.f4694c.toString());
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        a("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        a("callFailed");
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        a("callStart");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        a("connectEnd");
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        a("connectFailed");
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        a("connectStart");
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        a("connectionAcquired");
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        a("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        a("dnsEnd");
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        a("dnsStart");
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j6) {
        super.requestBodyEnd(call, j6);
        a("requestBodyEnd");
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        a("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        a("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        a("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j6) {
        super.responseBodyEnd(call, j6);
        a("responseBodyEnd");
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        a("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        a("responseHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        a("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        a("secureConnectEnd");
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        a("secureConnectStart");
    }
}
