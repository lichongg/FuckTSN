package com.bytedance.sdk.component.g;

import com.bytedance.sdk.component.xt.j.qv;
import java.io.File;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    qv ae;
    final Map<String, String> cw;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f26449g;

    /* renamed from: j, reason: collision with root package name */
    final int f26450j;

    /* renamed from: m, reason: collision with root package name */
    final long f26451m;

    /* renamed from: r, reason: collision with root package name */
    final String f26452r;
    final long up;
    final String xt;
    private File tl = null;
    private byte[] oq = null;

    public int j() {
        return this.f26450j;
    }

    public File ae() {
        return this.tl;
    }

    public Map<String, String> cw() {
        return this.cw;
    }

    public long g() {
        return this.up - this.f26451m;
    }

    public void j(File file) {
        this.tl = file;
    }

    public long m() {
        return this.f26451m;
    }

    public byte[] oq() {
        return this.oq;
    }

    public qv qv() {
        return this.ae;
    }

    public String r() {
        return this.f26452r;
    }

    public boolean tl() {
        return this.f26449g;
    }

    public long up() {
        return this.up;
    }

    public String xt() {
        return this.xt;
    }

    public xt(boolean z5, int i6, String str, Map<String, String> map, String str2, long j6, long j7) {
        this.f26449g = z5;
        this.f26450j = i6;
        this.xt = str;
        this.cw = map;
        this.f26452r = str2;
        this.up = j6;
        this.f26451m = j7;
    }

    public void j(byte[] bArr) {
        this.oq = bArr;
    }

    public void j(qv qvVar) {
        this.ae = qvVar;
    }
}
