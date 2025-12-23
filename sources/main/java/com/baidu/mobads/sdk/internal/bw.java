package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.ca;
import com.baidu.mobads.sdk.internal.cj;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class bw extends Thread {

    /* renamed from: b, reason: collision with root package name */
    private static final String f10810b = "ApkDownloadThread";

    /* renamed from: c, reason: collision with root package name */
    private static final int f10811c = 900000;

    /* renamed from: h, reason: collision with root package name */
    private static volatile bw f10812h;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f10814d;

    /* renamed from: e, reason: collision with root package name */
    private String f10815e;

    /* renamed from: f, reason: collision with root package name */
    private double f10816f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f10817g;

    /* renamed from: i, reason: collision with root package name */
    private final Context f10818i;

    /* renamed from: k, reason: collision with root package name */
    private final by f10820k;

    /* renamed from: j, reason: collision with root package name */
    private cj f10819j = null;

    /* renamed from: l, reason: collision with root package name */
    private bu f10821l = bu.a();

    /* renamed from: a, reason: collision with root package name */
    cj.a f10813a = new bx(this);

    private boolean b() {
        try {
            try {
                this.f10819j = new cj(this.f10818i, new URL(this.f10814d), this.f10820k, this.f10813a);
            } catch (MalformedURLException unused) {
                this.f10819j = new cj(this.f10818i, this.f10814d, this.f10820k, this.f10813a);
            }
            double d6 = ca.f10851q != null ? ca.f10851q.f10769b : ca.f10850p != null ? ca.f10850p.f10769b > 0.0d ? ca.f10850p.f10769b : ca.f10850p.f10769b : 0.0d;
            this.f10821l.a(f10810b, "isNewApkAvailable: local apk version is: " + d6 + ", remote apk version: " + this.f10820k.b());
            if (d6 > 0.0d) {
                if (this.f10820k.b() <= 0.0d) {
                    this.f10821l.a(f10810b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                }
                this.f10821l.a(f10810b, "remote not null, local apk version is null, force upgrade");
                this.f10816f = this.f10820k.b();
                return true;
            }
            if (this.f10820k.b() > 0.0d) {
                if (this.f10820k.b() <= d6) {
                    return false;
                }
                this.f10816f = this.f10820k.b();
                return true;
            }
            this.f10821l.a(f10810b, "remote apk version is: null, local apk version is: " + d6 + ", do not upgrade");
            return false;
        } catch (Exception e6) {
            String str = "parse apk failed, error:" + e6.toString();
            this.f10821l.a(f10810b, str);
            throw new ca.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.f10821l.a(f10810b, "download apk successfully, downloader exit");
                    f10812h = null;
                } catch (IOException e6) {
                    this.f10821l.a(f10810b, "create File or HTTP Get failed, exception: " + e6.getMessage());
                }
                this.f10821l.a(f10810b, "no newer apk, downloader exit");
                f10812h = null;
            }
        } catch (Throwable unused) {
        }
    }

    private bw(Context context, by byVar, String str, Handler handler) {
        this.f10815e = null;
        this.f10818i = context;
        this.f10820k = byVar;
        a(byVar.c());
        this.f10817g = handler;
        this.f10815e = str;
    }

    public static bw a(Context context, by byVar, String str, Handler handler) {
        if (f10812h == null) {
            f10812h = new bw(context, byVar, str, handler);
        }
        return f10812h;
    }

    public void a(String str) {
        this.f10814d = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, by byVar, String str2) {
        if (str.equals(ca.f10845k) || str.equals(ca.f10846l)) {
            Message obtainMessage = this.f10817g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ca.f10847m, byVar);
            bundle.putString(ca.f10848n, str);
            obtainMessage.setData(bundle);
            this.f10817g.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f10815e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f10819j.a(this.f10815e, str);
            return str2;
        } catch (IOException e6) {
            file.delete();
            throw e6;
        }
    }
}
