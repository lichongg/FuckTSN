package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.p0003l.t3;
import com.amap.api.col.p0003l.u3;
import com.amap.api.col.p0003l.x3;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private static int f9033a;

    /* renamed from: b, reason: collision with root package name */
    private a f9034b;

    /* renamed from: c, reason: collision with root package name */
    private t3 f9035c;

    /* renamed from: d, reason: collision with root package name */
    private t3[] f9036d = new t3[32];

    /* renamed from: e, reason: collision with root package name */
    private int f9037e = -1;

    /* renamed from: f, reason: collision with root package name */
    private u3 f9038f;

    private void a(t3 t3Var) {
        try {
            a aVar = this.f9034b;
            if (aVar != null) {
                aVar.h();
                this.f9034b = null;
            }
            a c6 = c(t3Var);
            this.f9034b = c6;
            if (c6 != null) {
                this.f9035c = t3Var;
                c6.d(this);
                this.f9034b.b();
                this.f9034b.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr() {
        try {
            if (a((Bundle) null)) {
                return;
            }
            a aVar = this.f9034b;
            if (aVar != null) {
                aVar.h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (i6 == 4) {
            try {
                a aVar = this.f9034b;
                if (aVar != null && !aVar.f()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f9033a == 1) {
                        finish();
                    }
                    return false;
                }
                this.f9037e = -1;
                f9033a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i6, keyEvent);
    }

    private void b(t3 t3Var) {
        try {
            f9033a++;
            a(t3Var);
            int i6 = (this.f9037e + 1) % 32;
            this.f9037e = i6;
            this.f9036d[i6] = t3Var;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a c(t3 t3Var) {
        try {
            if (t3Var.f7261a != 1) {
                return null;
            }
            if (this.f9038f == null) {
                this.f9038f = new u3();
            }
            return this.f9038f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a aVar = this.f9034b;
            if (aVar != null) {
                aVar.c(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.f9034b.g());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            x3.f(StubApp.getOrigApplicationContext(getApplicationContext()));
            this.f9037e = -1;
            f9033a = 0;
            b(new t3());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            a aVar = this.f9034b;
            if (aVar != null) {
                aVar.h();
                this.f9034b = null;
            }
            this.f9035c = null;
            this.f9036d = null;
            u3 u3Var = this.f9038f;
            if (u3Var != null) {
                u3Var.h();
                this.f9038f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            a aVar = this.f9034b;
            if (aVar != null) {
                aVar.h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i6 = f9033a;
            if ((i6 != 1 || this.f9034b == null) && i6 > 1) {
                f9033a = i6 - 1;
                int i7 = (this.f9037e + 31) % 32;
                this.f9037e = i7;
                t3 t3Var = this.f9036d[i7];
                t3Var.f7262b = bundle;
                a(t3Var);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
