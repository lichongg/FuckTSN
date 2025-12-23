package cn.jiguang.ah;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.jiguang.ah.c;
import cn.jiguang.bb.f;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    Context f1509a;

    /* renamed from: b, reason: collision with root package name */
    String f1510b = cn.jiguang.d.a.c("7vqR3nNqKoDAlUrx74tE1g==");

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f1511c = new LinkedBlockingQueue<>(1);

    /* renamed from: d, reason: collision with root package name */
    ServiceConnection f1512d = new ServiceConnection() { // from class: cn.jiguang.ah.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f1511c.put(iBinder);
            } catch (Throwable th) {
                f.i("MsaOpenIDHelper", "linkedBlockingQueue error: " + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public String a() {
        try {
            String packageName = this.f1509a.getPackageName();
            a(packageName);
            Intent intent = new Intent();
            intent.setClassName(this.f1510b, cn.jiguang.d.a.c("dYE0CPNDFJTaYbJHvdYTEBK/MhYfAvKlbba3ZFsuZ+on9OG47ABUmhfzcQhqhJOU"));
            intent.setAction(cn.jiguang.d.a.c("AdKS/+o+CvOMDbvCnPWRYUnA2ZKRLZpCerAAd95VliYNvOuVTnj4/o7GUNhJXhWl"));
            intent.putExtra(cn.jiguang.d.a.c("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), packageName);
            if (!this.f1509a.bindService(intent, this.f1512d, 1)) {
                return "";
            }
            try {
                c.a.C0023a c0023a = new c.a.C0023a(this.f1511c.take());
                String a6 = c0023a.a();
                c0023a.b();
                return a6;
            } catch (Throwable th) {
                try {
                    f.i("MsaOpenIDHelper", "getOAID error: " + th.getMessage());
                    this.f1509a.unbindService(this.f1512d);
                    return "";
                } finally {
                    this.f1509a.unbindService(this.f1512d);
                }
            }
        } catch (Throwable th2) {
            f.i("MsaOpenIDHelper", "get o failed: " + th2.getMessage());
            return "";
        }
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.setClassName(this.f1510b, cn.jiguang.d.a.c("dYE0CPNDFJTaYbJHvdYTELPkLL9xmlHysh4O1rCwUiLYHLJ6VxirNHcrSo3Xn2UJ"));
        intent.setAction(cn.jiguang.d.a.c("AdKS/+o+CvOMDbvCnPWRYS8wCU0Ooy6tyMT0tXjLMUvWRKeDq6D985Ar35mAOPu+"));
        intent.putExtra(cn.jiguang.d.a.c("iCmt493CpcicRY98bz8pUhEUlhy7cl4p/yoqnN2nlNM="), str);
        try {
            intent.putExtra(cn.jiguang.d.a.c("iCmt493CpcicRY98bz8pUjI+wbDT5u8oLPJxFa2B2Zg="), true);
            this.f1509a.startService(intent);
        } catch (Throwable th) {
            f.i("MsaOpenIDHelper", "startMsaklServer error: " + th.getMessage());
        }
    }

    public b(Context context) {
        this.f1509a = context;
    }
}
