package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.x;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class cj implements Observer {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10875a = "APKParser";

    /* renamed from: g, reason: collision with root package name */
    private static final String f10876g = "__xadsdk_downloaded__version__";

    /* renamed from: h, reason: collision with root package name */
    private static final String f10877h = "version";

    /* renamed from: b, reason: collision with root package name */
    private Context f10878b;

    /* renamed from: c, reason: collision with root package name */
    private URL f10879c;

    /* renamed from: d, reason: collision with root package name */
    private String f10880d;

    /* renamed from: e, reason: collision with root package name */
    private final by f10881e;

    /* renamed from: f, reason: collision with root package name */
    private a f10882f;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences f10883i;

    /* renamed from: j, reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f10884j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(by byVar);

        void b(by byVar);
    }

    public cj(Context context, URL url, by byVar, a aVar) {
        this.f10879c = null;
        this.f10880d = null;
        this.f10884j = new ck(this);
        this.f10879c = url;
        this.f10881e = byVar;
        a(context, aVar);
    }

    private void a(Context context, a aVar) {
        this.f10878b = context;
        this.f10882f = aVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f10876g, 0);
        this.f10883i = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this.f10884j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        x xVar = (x) observable;
        if (xVar.l() == x.a.COMPLETED) {
            this.f10882f.a(new by(this.f10881e, xVar.g(), Boolean.TRUE));
        }
        if (xVar.l() == x.a.ERROR) {
            this.f10882f.b(new by(this.f10881e, xVar.g(), Boolean.FALSE));
        }
    }

    public void a(String str, String str2) {
        am amVar = new am(this.f10878b, this.f10880d != null ? new URL(this.f10880d) : this.f10879c, str, str2, false);
        amVar.addObserver(this);
        amVar.a();
        SharedPreferences.Editor edit = this.f10883i.edit();
        edit.putString("version", this.f10881e.toString());
        edit.apply();
    }

    public cj(Context context, String str, by byVar, a aVar) {
        this.f10879c = null;
        this.f10880d = null;
        this.f10884j = new ck(this);
        this.f10880d = str;
        this.f10881e = byVar;
        a(context, aVar);
    }
}
