package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.embedapplog.nu;
import com.bytedance.embedapplog.oq;
import com.bytedance.embedapplog.tk;

/* loaded from: D:\Downloads\app\classes3.dex */
final class ll implements tk {
    private static final wf<Boolean> xt = new wf<Boolean>() { // from class: com.bytedance.embedapplog.ll.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.wf
        /* renamed from: cw, reason: merged with bridge method [inline-methods] */
        public Boolean j(Object... objArr) {
            return Boolean.valueOf(qo.j((Context) objArr[0]));
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private String f24011j;

    static boolean cw(Context context) {
        if (context == null) {
            return false;
        }
        return xt.xt(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.tk
    public boolean j(Context context) {
        return up(context);
    }

    static class j extends tk.j {

        /* renamed from: j, reason: collision with root package name */
        long f24013j = 0;

        j() {
        }
    }

    private static int j(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e6) {
            uc.j(e6);
            return 0;
        }
    }

    @Nullable
    private Pair<String, Boolean> m(Context context) {
        if (TextUtils.isEmpty(this.f24011j)) {
            return null;
        }
        return (Pair) new oq(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.f24011j), new oq.xt<nu, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.ll.2
            @Override // com.bytedance.embedapplog.oq.xt
            public Pair<String, Boolean> j(nu nuVar) {
                if (nuVar == null) {
                    return null;
                }
                return new Pair<>(nuVar.j(), Boolean.valueOf(nuVar.xt()));
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public nu j(IBinder iBinder) {
                return nu.j.j(iBinder);
            }
        }).j();
    }

    private boolean up(Context context) {
        PackageManager packageManager;
        if (context == null) {
            return false;
        }
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
            this.f24011j = "com.huawei.hwid";
            return true;
        }
        if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
            this.f24011j = "com.huawei.hwid.tv";
            return true;
        }
        this.f24011j = "com.huawei.hms";
        return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
    }

    @Override // com.bytedance.embedapplog.tk
    @Nullable
    @WorkerThread
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public j xt(Context context) {
        j jVar = new j();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    jVar.xt = string;
                    jVar.cw = Boolean.parseBoolean(string2);
                    jVar.f24013j = 202003021704L;
                    return jVar;
                }
            } catch (Throwable th) {
                uc.j(th);
            }
        }
        Pair<String, Boolean> m6 = m(context);
        if (m6 != null) {
            jVar.xt = (String) m6.first;
            jVar.cw = ((Boolean) m6.second).booleanValue();
            jVar.f24013j = j(context, this.f24011j);
        }
        return jVar;
    }

    ll() {
    }
}
