package xyz.adscope.common.network.simple.cache;

import java.io.Serializable;
import xyz.adscope.common.network.Headers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class Cache implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f56714a;

    /* renamed from: b, reason: collision with root package name */
    private int f56715b;

    /* renamed from: c, reason: collision with root package name */
    private Headers f56716c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f56717d;

    /* renamed from: e, reason: collision with root package name */
    private long f56718e;

    public byte[] getBody() {
        return this.f56717d;
    }

    public int getCode() {
        return this.f56715b;
    }

    public long getExpires() {
        return this.f56718e;
    }

    public Headers getHeaders() {
        return this.f56716c;
    }

    public String getKey() {
        return this.f56714a;
    }

    public void setBody(byte[] bArr) {
        this.f56717d = bArr;
    }

    public void setCode(int i6) {
        this.f56715b = i6;
    }

    public void setExpires(long j6) {
        this.f56718e = j6;
    }

    public void setHeaders(Headers headers) {
        this.f56716c = headers;
    }

    public void setKey(String str) {
        this.f56714a = str;
    }
}
