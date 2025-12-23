package com.jg.ids.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class i extends com.jg.ids.g {

    /* renamed from: b, reason: collision with root package name */
    private String f35543b;

    /* renamed from: c, reason: collision with root package name */
    private String f35544c;

    public i(Context context) {
        super(context);
        this.f35543b = "";
        this.f35544c = "";
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        switch (this.f35544c) {
            case "openid":
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                return intent;
            case "mcsid":
                Intent intent2 = new Intent("action.com.oplus.stdid.ID_SERVICE");
                intent2.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
                return intent2;
            case "stdid":
                Intent intent3 = new Intent("action.com.oplus.stdid.ID_SERVICE");
                intent3.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
                return intent3;
            default:
                return null;
        }
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        h hVar = null;
        try {
            switch (this.f35544c) {
                case "openid":
                    hVar = b.a(iBinder);
                    break;
                case "mcsid":
                    hVar = e.a(iBinder);
                    break;
                case "stdid":
                    hVar = e.a(iBinder);
                    break;
            }
            String a6 = a(this.f35525a, hVar, "AUID");
            String a7 = a(this.f35525a, hVar, "OUID");
            String a8 = a(this.f35525a, hVar, "DUID");
            a(a6);
            b(a8);
            c(a7);
            b();
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f35525a == null) {
            return false;
        }
        if (g.a(this.f35525a)) {
            this.f35544c = "openid";
        }
        if (com.jg.ids.j.b(this.f35525a)) {
            this.f35544c = "mcsid";
        }
        if (j.d(this.f35525a)) {
            this.f35544c = "stdid";
        }
        return !TextUtils.isEmpty(this.f35544c);
    }

    private String a(Context context, h hVar, String str) {
        Signature[] signatureArr;
        String str2 = null;
        if (context == null || hVar == null || !d()) {
            return "";
        }
        String packageName = this.f35525a.getPackageName();
        if (TextUtils.isEmpty(this.f35543b)) {
            try {
                signatureArr = this.f35525a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable th) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b6 : digest) {
                            sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Throwable th2) {
                }
            }
            this.f35543b = str2;
        }
        return hVar.a(context.getPackageName(), this.f35543b, str);
    }
}
