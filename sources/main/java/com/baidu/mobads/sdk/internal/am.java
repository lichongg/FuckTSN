package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.x;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class am extends Observable implements x, Runnable {

    /* renamed from: i, reason: collision with root package name */
    protected static final int f10580i = 10240;

    /* renamed from: j, reason: collision with root package name */
    protected static final int f10581j = 10240;

    /* renamed from: k, reason: collision with root package name */
    public static final String f10582k = ".tmp";

    /* renamed from: m, reason: collision with root package name */
    private static final String f10583m = "FileDownloader";

    /* renamed from: a, reason: collision with root package name */
    protected Context f10584a;

    /* renamed from: b, reason: collision with root package name */
    protected URL f10585b;

    /* renamed from: c, reason: collision with root package name */
    protected String f10586c;

    /* renamed from: d, reason: collision with root package name */
    protected String f10587d;

    /* renamed from: e, reason: collision with root package name */
    protected int f10588e;

    /* renamed from: f, reason: collision with root package name */
    protected x.a f10589f;

    /* renamed from: g, reason: collision with root package name */
    protected int f10590g;

    /* renamed from: h, reason: collision with root package name */
    protected int f10591h;

    /* renamed from: l, reason: collision with root package name */
    protected byte[] f10592l;

    /* renamed from: n, reason: collision with root package name */
    private boolean f10593n;

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(boolean z5) {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public boolean n() {
        return false;
    }

    private void s() {
        a(x.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a() {
        a(x.a.DOWNLOADING);
        p();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public String e() {
        return this.f10585b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public String g() {
        return this.f10586c + this.f10587d;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public int j() {
        return this.f10588e;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public float k() {
        return Math.abs((this.f10590g / this.f10588e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public x.a l() {
        return this.f10589f;
    }

    public byte[] o() {
        return this.f10592l;
    }

    protected void r() {
        bs.a(this.f10586c + this.f10587d + ".tmp", this.f10586c + this.f10587d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.am.run():void");
    }

    public am(Context context, URL url, String str, String str2, boolean z5) {
        this.f10584a = context;
        this.f10585b = url;
        this.f10586c = str;
        this.f10593n = z5;
        if (str2 != null && str2.trim().length() > 0) {
            this.f10587d = str2;
        } else {
            String file = url.getFile();
            this.f10587d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.f10588e = -1;
        this.f10589f = x.a.DOWNLOADING;
        this.f10590g = 0;
        this.f10591h = 0;
    }

    protected void p() {
        be.a().a(this);
    }

    protected void q() {
        setChanged();
        notifyObservers();
    }

    protected void a(x.a aVar) {
        this.f10589f = aVar;
        q();
    }

    protected void a(int i6, float f6) {
        this.f10590g += i6;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.f10585b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void m() {
    }
}
