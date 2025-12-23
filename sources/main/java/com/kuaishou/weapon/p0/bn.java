package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    private Context f35798a;

    public static String b(String str) {
        try {
            String str2 = new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i6 = 0; i6 < 16 - length; i6++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            return new String(d.b(i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), c.a(str.getBytes(), 2)), str2.substring(0, 16))));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(String str, String str2) {
        try {
            return c(str, new String(c.a(str2.getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str) {
        try {
            return c(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public bn(Context context) {
        this.f35798a = context;
    }

    public String a(String str) {
        try {
            return b(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str2.length() < 16) {
            int length = str2.length();
            StringBuilder sb = new StringBuilder(str2);
            for (int i6 = 0; i6 < 16 - length; i6++) {
                sb.append("0");
            }
            str2 = sb.toString();
        } else if (str2.length() > 16) {
            str2 = str2.substring(0, 16);
        }
        byte[] a6 = d.a(str.getBytes());
        if (Engine.loadSuccess) {
            bArr = Engine.getInstance(this.f35798a).ac(Engine.getInstance(this.f35798a).ar(a6, str2.getBytes()), str2.substring(0, 16).getBytes());
        } else {
            try {
                bArr = b.a(str2.substring(0, 16), str2.substring(0, 16), i.b(a6, str2));
            } catch (Throwable unused) {
                bArr = null;
            }
        }
        if (bArr != null && bArr.length > 0) {
            return c.b(bArr, 2);
        }
        return null;
    }

    public String b(String str, String str2) {
        byte[] a6;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i6 = 0; i6 < 16 - length; i6++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] a7 = c.a(str.getBytes(), 2);
            if (Engine.loadSuccess) {
                a6 = Engine.getInstance(this.f35798a).dr(Engine.getInstance(this.f35798a).dc(a7, str2.substring(0, 16).getBytes()), str2.getBytes());
            } else {
                a6 = i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), a7), str2.substring(0, 16));
            }
            return new String(d.b(a6));
        } catch (Exception unused) {
            return null;
        }
    }
}
