package com.tencent.open.a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class d implements g {

    /* renamed from: a, reason: collision with root package name */
    private Response f40497a;

    /* renamed from: b, reason: collision with root package name */
    private String f40498b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f40499c;

    /* renamed from: d, reason: collision with root package name */
    private int f40500d;

    /* renamed from: e, reason: collision with root package name */
    private int f40501e;

    @Override // com.tencent.open.a.g
    public String a() throws IOException {
        if (this.f40498b == null) {
            ResponseBody body = this.f40497a.body();
            if (body != null) {
                this.f40498b = body.string();
            }
            if (this.f40498b == null) {
                this.f40498b = "";
            }
        }
        return this.f40498b;
    }

    @Override // com.tencent.open.a.g
    public int b() {
        return this.f40501e;
    }

    @Override // com.tencent.open.a.g
    public int c() {
        return this.f40500d;
    }

    @Override // com.tencent.open.a.g
    public int d() {
        return this.f40499c;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hashCode() + this.f40498b + this.f40499c + this.f40500d + this.f40501e;
    }

    d(Response response, int i6) {
        this.f40497a = response;
        this.f40500d = i6;
        this.f40499c = response.code();
        ResponseBody body = this.f40497a.body();
        if (body != null) {
            this.f40501e = (int) body.contentLength();
        } else {
            this.f40501e = 0;
        }
    }
}
