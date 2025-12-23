package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    private Context f6608a;

    private boolean c(ax axVar) {
        if (axVar != null) {
            String pinyin = axVar.getPinyin();
            boolean b6 = b(pinyin, this.f6608a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z5 = true;
            boolean z6 = b(pinyin, this.f6608a, "map/") || b6;
            if (!d(a1.i(axVar.getUrl()), this.f6608a, "map/") && !z6) {
                z5 = false;
            }
            if (z5) {
                axVar.B();
                return z5;
            }
            axVar.A();
        }
        return false;
    }

    public j0(Context context) {
        this.f6608a = context;
    }

    private static boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String X = b3.X(context);
        try {
            File file = new File(X + str2 + str + ".dat");
            if (file.exists()) {
                if (!a1.l(file)) {
                    return false;
                }
            }
            try {
                a1.h(X + str2);
                a1.k(str, context);
                return true;
            } catch (IOException e6) {
                e6.printStackTrace();
                return false;
            } catch (Exception e7) {
                e7.printStackTrace();
                return false;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
            return false;
        } catch (Exception e9) {
            e9.printStackTrace();
            return false;
        }
    }

    private static boolean d(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String v5 = b3.v(context);
        try {
            File file = new File(v5 + str2 + str);
            if (file.exists()) {
                if (!a1.l(file)) {
                    return false;
                }
            }
            try {
                a1.h(v5 + str2);
                a1.k(str, context);
                return true;
            } catch (IOException e6) {
                e6.printStackTrace();
                return false;
            } catch (Exception e7) {
                e7.printStackTrace();
                return false;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
            return false;
        } catch (Exception e9) {
            e9.printStackTrace();
            return false;
        }
    }

    public final void a(ax axVar) {
        c(axVar);
    }
}
