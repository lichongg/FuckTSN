package com.jg.ids.h;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class a extends com.jg.ids.a {

    /* renamed from: b, reason: collision with root package name */
    private static final Uri f35531b = Uri.parse("content://cn.nubia.identity/identity");

    public a(Context context) {
        super(context, "nubia_thread");
    }

    @Override // com.jg.ids.a
    protected final void a(Message message) {
        String str = null;
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i6 = message.getData().getInt("type", -1);
                    String str2 = "";
                    switch (i6) {
                        case 0:
                            str2 = "getOAID";
                            break;
                        case 1:
                            str2 = "getVAID";
                            str = this.f35525a.getPackageName();
                            break;
                        case 2:
                            str2 = "getAAID";
                            str = this.f35525a.getPackageName();
                            break;
                    }
                    a(i6, a(this.f35525a, str2, str));
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.jg.ids.a
    protected final void b() {
        a(2);
        a(0);
        a(1);
    }

    private void a(int i6) {
        try {
            Message a6 = a();
            a6.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i6);
            a6.setData(bundle);
            b(a6);
        } catch (Throwable th) {
        }
    }

    private static String a(Context context, String str, String str2) {
        Bundle call;
        if (context == null) {
            return "";
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(f35531b);
                if (acquireContentProviderClient == null) {
                    return "";
                }
                call = acquireContentProviderClient.call(str, str2, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(f35531b, str, str2, (Bundle) null);
            }
            if (call != null && call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
        } catch (Throwable th) {
        }
        return "";
    }

    @Override // com.jg.ids.a
    protected final void a(int i6, String str) {
        switch (i6) {
            case 0:
                a(new b(this, str));
                break;
            case 1:
                a(new c(this, str));
                break;
            case 2:
                a(new d(this, str));
                break;
        }
    }
}
