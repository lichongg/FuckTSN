package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g implements com.bumptech.glide.load.c {

    /* renamed from: j, reason: collision with root package name */
    private static final String f15425j = "@#&=*+-_.,:!?()/~'%;$";

    /* renamed from: c, reason: collision with root package name */
    private final h f15426c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final URL f15427d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f15428e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private String f15429f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private URL f15430g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private volatile byte[] f15431h;

    /* renamed from: i, reason: collision with root package name */
    private int f15432i;

    public g(URL url) {
        this(url, h.f15434b);
    }

    public g(String str) {
        this(str, h.f15434b);
    }

    private byte[] d() {
        if (this.f15431h == null) {
            this.f15431h = c().getBytes(com.bumptech.glide.load.c.f14919b);
        }
        return this.f15431h;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f15429f)) {
            String str = this.f15428e;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) com.bumptech.glide.util.k.d(this.f15427d)).toString();
            }
            this.f15429f = Uri.encode(str, f15425j);
        }
        return this.f15429f;
    }

    private URL g() throws MalformedURLException {
        if (this.f15430g == null) {
            this.f15430g = new URL(f());
        }
        return this.f15430g;
    }

    public String c() {
        String str = this.f15428e;
        return str != null ? str : ((URL) com.bumptech.glide.util.k.d(this.f15427d)).toString();
    }

    public Map<String, String> e() {
        return this.f15426c.getHeaders();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (c().equals(gVar.c()) && this.f15426c.equals(gVar.f15426c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f15432i == 0) {
            int hashCode = c().hashCode();
            this.f15432i = hashCode;
            this.f15432i = (hashCode * 31) + this.f15426c.hashCode();
        }
        return this.f15432i;
    }

    public g(URL url, h hVar) {
        this.f15427d = (URL) com.bumptech.glide.util.k.d(url);
        this.f15428e = null;
        this.f15426c = (h) com.bumptech.glide.util.k.d(hVar);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String h() {
        return f();
    }

    public URL i() throws MalformedURLException {
        return g();
    }

    public String toString() {
        return c();
    }

    public g(String str, h hVar) {
        this.f15427d = null;
        this.f15428e = com.bumptech.glide.util.k.b(str);
        this.f15426c = (h) com.bumptech.glide.util.k.d(hVar);
    }
}
