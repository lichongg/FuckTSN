package com.bytedance.sdk.openadsdk.core.qv;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements r {

    /* renamed from: j, reason: collision with root package name */
    private cw f29989j;

    private String xt(String str, String str2, String str3, int i6, String str4, String str5, int i7, String str6, String str7) {
        if (!this.f29989j.j()) {
            return "enable_install_notification";
        }
        com.bytedance.sdk.openadsdk.i.cw.cw.r w5 = oq.i().w();
        if (w5 != null && !w5.tl()) {
            return "isCanUseMessage";
        }
        if (i7 == 0) {
            return "enable_notification=0";
        }
        if (!com.bytedance.sdk.openadsdk.core.x.up.j().xt(v.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (j(1440L, this.f29989j.m(), this.f29989j.up() * 1000)) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r
    public boolean j(final String str, final String str2, final String str3, final int i6, final String str4, String str5, int i7, final String str6, final String str7) {
        String xt = xt(str, str2, str3, i6, str4, str5, i7, str6, str7);
        if (TextUtils.isEmpty(xt)) {
            com.bytedance.sdk.component.utils.tl.j().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.up.1
                @Override // java.lang.Runnable
                public void run() {
                    up.this.j(str, str2, str3, i6, str4, str6, str7, "startUnInstallNotification");
                }
            }, this.f29989j.r() * 1000);
            return true;
        }
        j("notification", str7, str4, "install", str3, "othershow", xt, "failure");
        return false;
    }

    public up(cw cwVar) {
        this.f29989j = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r
    public boolean j(String str, String str2, String str3, String str4, int i6, String str5, String str6) {
        String xt = xt(str, str2, str3, str4, i6, str5, str6);
        if (TextUtils.isEmpty(xt)) {
            j(str, str2, str3, str3.hashCode(), str4, str5, str6, "pushUnActiveFromMarketMessage");
            return true;
        }
        j("notification", str6, str4, "open", str3, "othershow", xt, "failure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str, final String str2, final String str3, final int i6, final String str4, final String str5, final String str6, final String str7) {
        com.bytedance.sdk.openadsdk.g.xt.j(str2).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.qv.up.2
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i7, String str8, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv<Bitmap> qvVar) {
                if (qvVar != null) {
                    Bitmap cw = qvVar.cw();
                    final Bitmap j6 = up.j(cw, 10.0f);
                    if (cw != null) {
                        final boolean cw2 = uf.cw(v.getContext(), str3);
                        String str8 = str6;
                        String str9 = str4;
                        String str10 = cw2 ? "open" : "install";
                        up.j("notification", str8, str9, str10, str3, "othershow", str7 + "_" + str3, "success");
                        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.up.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.bytedance.sdk.openadsdk.core.qv.cw.xt.xt.j(str, str2, str4, "com.csj.install", i6, cw2 ? 1 : 2, j6, str3, str5, str6);
                            }
                        });
                    }
                }
            }
        }, 4);
    }

    private String xt(String str, String str2, String str3, String str4, int i6, String str5, String str6) {
        if (!this.f29989j.xt()) {
            return "enable_action_notification=0";
        }
        if (i6 == 0) {
            return "enable_notification=0";
        }
        if (!com.bytedance.sdk.openadsdk.core.x.up.j().xt(v.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (j(1440L, this.f29989j.m(), this.f29989j.up() * 1000)) {
            return null;
        }
        return "max_times_limit";
    }

    public static void j(String str, String str2, String str3, final String str4, final String str5, String str6, final String str7, final String str8) {
        com.bytedance.sdk.openadsdk.core.jy.cw.j(str, str6, str2, str3, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.up.3
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", str4);
                jSONObject2.put("installer_package_name", str5);
                if (!TextUtils.isEmpty(str7)) {
                    jSONObject2.put("detail_info", str7);
                }
                if (!TextUtils.isEmpty(str8)) {
                    jSONObject2.put(NotificationCompat.CATEGORY_STATUS, str8);
                }
                if (jSONObject != null) {
                    jSONObject.put("ad_extra_data", jSONObject2);
                }
            }
        });
    }

    public static Bitmap j(Bitmap bitmap, float f6) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f6, f6, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public boolean j(long j6, int i6, long j7) {
        int i7;
        try {
            Long l6 = -1L;
            try {
                l6 = Long.valueOf(60000 * j6);
                i7 = i6;
            } catch (Exception e6) {
                vl.xt("xgc_notification", "error", e6.getMessage());
                i7 = -1;
            }
            if (l6.longValue() >= 0 && i7 >= 0 && l6.longValue() != 0 && i7 != 0) {
                String j8 = j();
                StringBuilder sb = new StringBuilder();
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(j8)) {
                    sb.append(currentTimeMillis);
                    j(sb.toString());
                    return true;
                }
                String[] split = j8.split("_");
                int length = split.length;
                if (length < i7) {
                    if (currentTimeMillis - Long.parseLong(split[length - 1]) <= j7) {
                        return false;
                    }
                    for (String str : split) {
                        sb.append(str);
                        sb.append("_");
                    }
                    sb.append(currentTimeMillis);
                    j(sb.toString());
                    return true;
                }
                int i8 = length - i7;
                long parseLong = Long.parseLong(split[i8]);
                if (currentTimeMillis - Long.parseLong(split[length - 1]) > j7 && currentTimeMillis - parseLong > l6.longValue()) {
                    for (int i9 = i8; i9 < length; i9++) {
                        String str2 = split[i9];
                        if (i9 != i8 && !TextUtils.isEmpty(str2)) {
                            sb.append(str2);
                            sb.append("_");
                        }
                    }
                    sb.append(currentTimeMillis);
                    j(sb.toString());
                    return true;
                }
            }
            return false;
        } catch (Exception e7) {
            vl.j(e7);
            vl.xt("xgc_notification", "exception:" + e7.getMessage());
            return false;
        }
    }

    public static String j() {
        return com.bytedance.sdk.openadsdk.core.xt.j().xt("notification_a", "");
    }

    public static void j(String str) {
        com.bytedance.sdk.openadsdk.core.xt.j().j("notification_a", str);
    }
}
