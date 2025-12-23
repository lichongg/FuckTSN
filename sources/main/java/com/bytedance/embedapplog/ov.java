package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.av;
import com.bytedance.embedapplog.oq;
import com.bytedance.embedapplog.tk;

/* loaded from: D:\Downloads\app\classes3.dex */
final class ov implements tk {

    /* renamed from: j, reason: collision with root package name */
    private final tk f24026j;
    private wf<Boolean> xt;

    ov() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[Catch: Exception -> 0x0052, TryCatch #1 {Exception -> 0x0052, blocks: (B:11:0x0028, B:13:0x0030, B:15:0x003c, B:17:0x0054), top: B:10:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String cw(android.content.Context r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch: java.lang.Exception -> L14
            java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Exception -> L14
            r2 = 64
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r2)     // Catch: java.lang.Exception -> L14
            if (r8 == 0) goto L16
            android.content.pm.Signature[] r8 = r8.signatures     // Catch: java.lang.Exception -> L14
            goto L1c
        L14:
            r8 = move-exception
            goto L18
        L16:
            r8 = r0
            goto L1c
        L18:
            com.bytedance.embedapplog.uc.j(r8)
            goto L16
        L1c:
            if (r8 == 0) goto L5c
            int r1 = r8.length
            if (r1 <= 0) goto L5c
            r1 = 0
            r8 = r8[r1]
            byte[] r8 = r8.toByteArray()
            java.lang.String r2 = "SHA1"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Exception -> L52
            if (r2 == 0) goto L5c
            byte[] r8 = r2.digest(r8)     // Catch: java.lang.Exception -> L52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L52
            r2.<init>()     // Catch: java.lang.Exception -> L52
            int r3 = r8.length     // Catch: java.lang.Exception -> L52
        L3a:
            if (r1 >= r3) goto L54
            r4 = r8[r1]     // Catch: java.lang.Exception -> L52
            r4 = r4 & 255(0xff, float:3.57E-43)
            r4 = r4 | 256(0x100, float:3.59E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch: java.lang.Exception -> L52
            r5 = 3
            r6 = 1
            java.lang.String r4 = r4.substring(r6, r5)     // Catch: java.lang.Exception -> L52
            r2.append(r4)     // Catch: java.lang.Exception -> L52
            int r1 = r1 + 1
            goto L3a
        L52:
            r8 = move-exception
            goto L59
        L54:
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Exception -> L52
            return r8
        L59:
            com.bytedance.embedapplog.uc.j(r8)
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ov.cw(android.content.Context):java.lang.String");
    }

    ov(tk tkVar) {
        this.xt = new wf<Boolean>() { // from class: com.bytedance.embedapplog.ov.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.embedapplog.wf
            /* renamed from: cw, reason: merged with bridge method [inline-methods] */
            public Boolean j(Object... objArr) {
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    uc.j(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.f24026j = tkVar;
    }

    @Override // com.bytedance.embedapplog.tk
    public boolean j(Context context) {
        if (context == null) {
            return false;
        }
        Boolean xt = this.xt.xt(context);
        return (this.f24026j == null || xt.booleanValue()) ? xt.booleanValue() : this.f24026j.j(context);
    }

    @Override // com.bytedance.embedapplog.tk
    public tk.j xt(final Context context) {
        if (this.f24026j != null && !this.xt.xt(new Object[0]).booleanValue()) {
            return this.f24026j.xt(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = (String) new oq(context, intent, new oq.xt<av, String>() { // from class: com.bytedance.embedapplog.ov.2
            @Override // com.bytedance.embedapplog.oq.xt
            public String j(av avVar) {
                if (avVar == null) {
                    return null;
                }
                String cw = ov.this.cw(context);
                if (TextUtils.isEmpty(cw)) {
                    return null;
                }
                return avVar.j(context.getPackageName(), cw, "OUID");
            }

            @Override // com.bytedance.embedapplog.oq.xt
            /* renamed from: xt, reason: merged with bridge method [inline-methods] */
            public av j(IBinder iBinder) {
                return av.j.j(iBinder);
            }
        }).j();
        tk.j jVar = new tk.j();
        jVar.xt = str;
        return jVar;
    }
}
