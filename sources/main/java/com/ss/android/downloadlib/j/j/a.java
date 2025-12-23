package com.ss.android.downloadlib.j.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.downloadlib.j.j.cw;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: k, reason: collision with root package name */
    private static String f38169k = "";

    /* renamed from: l, reason: collision with root package name */
    private static String f38170l = "";

    /* renamed from: m, reason: collision with root package name */
    private static String f38171m = "";

    /* renamed from: n, reason: collision with root package name */
    private static volatile a f38172n;

    /* renamed from: d, reason: collision with root package name */
    private Context f38176d;

    /* renamed from: f, reason: collision with root package name */
    public cw f38178f;

    /* renamed from: a, reason: collision with root package name */
    private boolean f38173a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38174b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f38175c = false;

    /* renamed from: e, reason: collision with root package name */
    private final List<Pair<xt, r>> f38177e = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List<Object> f38179g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final ServiceConnection f38180h = new ServiceConnectionC0760a();

    /* renamed from: i, reason: collision with root package name */
    private String f38181i = "";

    /* renamed from: j, reason: collision with root package name */
    public final Object f38182j = new Object();

    /* renamed from: com.ss.android.downloadlib.j.j.a$a, reason: collision with other inner class name */
    class ServiceConnectionC0760a implements ServiceConnection {
        ServiceConnectionC0760a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f38182j) {
                try {
                    a.this.e(false);
                    a.this.f38178f = cw.j.e(iBinder);
                    a.this.a();
                    Iterator<Object> it = a.this.f38179g.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f38182j) {
                try {
                    a.this.e(false);
                    a aVar = a.this;
                    aVar.f38178f = null;
                    Iterator<Object> it = aVar.f38179g.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static a c() {
        if (f38172n == null) {
            synchronized (a.class) {
                try {
                    if (f38172n == null) {
                        f38172n = new a();
                    }
                } finally {
                }
            }
        }
        return f38172n;
    }

    public void a() {
        for (Pair<xt, r> pair : this.f38177e) {
            try {
                this.f38178f.b((xt) pair.first, (r) pair.second);
            } catch (RemoteException e6) {
                vl.j(e6);
            }
        }
        this.f38177e.clear();
    }

    public Intent b(Context context) {
        Intent intent = new Intent();
        intent.setAction(f38169k);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f38170l.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void d(xt xtVar, r rVar) {
        synchronized (this.f38182j) {
            try {
                xtVar.f38192e = f38171m;
                if (TextUtils.isEmpty(xtVar.f38193f)) {
                    xtVar.f38193f = this.f38181i;
                }
                cw cwVar = this.f38178f;
                if (cwVar != null) {
                    try {
                        cwVar.b(xtVar, rVar);
                    } catch (RemoteException e6) {
                        vl.j(e6);
                    }
                } else if (g() || f(this.f38176d, this.f38174b)) {
                    this.f38177e.add(Pair.create(xtVar, rVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(boolean z5) {
        this.f38175c = z5;
    }

    public boolean f(Context context, boolean z5) {
        if (TextUtils.isEmpty(f38169k)) {
            JSONObject f6 = m.f();
            String optString = f6.optString("s");
            f38169k = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("q"), optString);
            f38170l = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString("u"), optString);
            f38171m = com.ss.android.socialbase.appdownloader.m.a.b(f6.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.f38174b = z5;
        if (context == null) {
            return true;
        }
        this.f38176d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (TextUtils.isEmpty(f38171m)) {
            f38171m = this.f38176d.getPackageName();
        }
        if (this.f38178f != null || g()) {
            return true;
        }
        return this.f38176d.bindService(b(context), this.f38180h, 33);
    }

    public boolean g() {
        return this.f38175c;
    }

    public void h() {
        if (this.f38178f != null) {
            this.f38176d.unbindService(this.f38180h);
            this.f38178f = null;
        }
        this.f38179g.clear();
        this.f38177e.clear();
    }

    private a() {
    }
}
