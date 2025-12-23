package com.beizi.ad.internal.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.beizi.ad.internal.h.e;
import com.beizi.ad.internal.h.h;
import com.kuaishou.weapon.p0.g;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static d f11941a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<a> f11942b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private Timer f11943c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11944d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a {

        /* renamed from: a, reason: collision with root package name */
        String f11949a;

        /* renamed from: b, reason: collision with root package name */
        int f11950b = 0;

        a(String str) {
            this.f11949a = str;
        }
    }

    public static d a(Context context) {
        if (f11941a == null) {
            f11941a = new d(context);
        }
        return f11941a;
    }

    private void c(Context context) {
        if (this.f11943c == null) {
            final WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.f11943c = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: com.beizi.ad.internal.f.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 == null) {
                        d.this.a();
                        return;
                    }
                    while (!d.this.f11942b.isEmpty() && d.this.b(context2)) {
                        boolean z5 = false;
                        final a aVar = (a) d.this.f11942b.remove(0);
                        if (aVar.f11950b < 3) {
                            new com.beizi.ad.internal.h.d(z5, true) { // from class: com.beizi.ad.internal.f.d.1.1
                                /* JADX INFO: Access modifiers changed from: protected */
                                @Override // com.beizi.ad.internal.h.d, android.os.AsyncTask
                                /* renamed from: a */
                                public void onPostExecute(e eVar) {
                                    if (eVar == null || (!eVar.a() && eVar.b() == h.CONNECTION_FAILURE)) {
                                        aVar.f11950b++;
                                        d.this.f11942b.add(aVar);
                                    }
                                }

                                @Override // com.beizi.ad.internal.h.d
                                protected String a() {
                                    return aVar.f11949a;
                                }
                            }.execute(new Void[0]);
                        }
                    }
                    if (d.this.f11942b.isEmpty()) {
                        d.this.a();
                    }
                }
            }, 10000L, 10000L);
        }
    }

    public boolean b(Context context) {
        try {
            if (!this.f11944d) {
                return true;
            }
            if (context != null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private d(Context context) {
        boolean z5;
        if (context != null) {
            if (context.getPackageManager().checkPermission(g.f36042b, context.getPackageName()) == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f11944d = z5;
        }
    }

    public synchronized void a(String str, Context context) {
        this.f11942b.add(new a(str));
        c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Timer timer = this.f11943c;
        if (timer != null) {
            timer.cancel();
            this.f11943c = null;
        }
    }
}
