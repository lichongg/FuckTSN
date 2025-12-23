package com.bytedance.sdk.openadsdk.upie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.sdk.component.ae.r;
import com.bytedance.sdk.component.g.xt.cw;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.az;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final String f31950j;

    /* renamed from: r, reason: collision with root package name */
    private static volatile xt f31951r;
    private static final String xt;
    private final com.bytedance.sdk.component.r.j.xt cw = new r.j().j("lottie_tpl_info").j(com.bytedance.sdk.component.adexpress.j.j.j.j().cw().getContext()).j(1).j(com.bytedance.sdk.component.adexpress.j.j.j.j().cw().vl()).j();

    public interface j<T> {
        void j(int i6, String str);

        void j(T t5);
    }

    static {
        StringBuilder sb = new StringBuilder("tt_derive");
        String str = File.separator;
        sb.append(str);
        sb.append("lottie");
        sb.append(str);
        sb.append("audio");
        f31950j = sb.toString();
        xt = "tt_derive" + str + "lottie" + str + "anim_img";
    }

    public static xt j() {
        if (f31951r == null) {
            synchronized (xt.class) {
                try {
                    if (f31951r == null) {
                        f31951r = new xt();
                    }
                } finally {
                }
            }
        }
        return f31951r;
    }

    private xt() {
    }

    public void xt(String str, final j<Bitmap> jVar) {
        az up = com.bytedance.sdk.component.adexpress.j.j.j.j().up();
        if (up == null) {
            if (jVar != null) {
                jVar.j(-1, "imageCenter is null");
                return;
            }
            return;
        }
        up.j(str).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.xt.3
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv<Bitmap> qvVar) {
                j jVar2;
                try {
                    Bitmap cw = qvVar.cw();
                    if (cw == null || (jVar2 = jVar) == null) {
                        return;
                    }
                    jVar2.j(cw);
                } catch (Throwable th) {
                    vl.j(th);
                }
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i6, String str2, Throwable th) {
                j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j(i6, "load ad pic fail: ".concat(String.valueOf(str2)));
                }
            }
        }, 4);
    }

    public void j(Context context, com.bytedance.sdk.openadsdk.upie.j jVar) {
        if (jVar != null) {
            String cw = jVar.cw();
            if (!TextUtils.isEmpty(cw)) {
                xt(cw, null);
            }
            String j6 = jVar.j();
            if (TextUtils.isEmpty(j6) || !TextUtils.isEmpty(j(j6))) {
                return;
            }
            j(j6, (j<String>) null);
        }
    }

    public void j(final String str, final j<String> jVar) {
        cw up = com.bytedance.sdk.component.adexpress.j.j.j.j().cw().up();
        if (up == null) {
            return;
        }
        up.j(str);
        up.j(new com.bytedance.sdk.component.g.j.j() { // from class: com.bytedance.sdk.openadsdk.upie.xt.1
            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, com.bytedance.sdk.component.g.xt xtVar) {
                String r5;
                boolean z5 = false;
                if (xtVar != null) {
                    try {
                        if (xtVar.tl() && (r5 = xtVar.r()) != null) {
                            try {
                                vl.j("TTDeriveTplManager", "lottie content is ok, version: " + new JSONObject(r5).optString("v"));
                                xt.this.j(str, r5);
                                j jVar2 = jVar;
                                if (jVar2 != null) {
                                    jVar2.j(r5);
                                    return;
                                }
                                return;
                            } catch (JSONException e6) {
                                vl.j(e6);
                                if (jVar != null) {
                                    String message = e6.getMessage();
                                    if (message != null && message.length() > 100) {
                                        message = message.substring(0, 100);
                                    }
                                    jVar.j(10006, "lottieJsonUrl加载失败0, " + message);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        vl.j(th);
                        j jVar3 = jVar;
                        if (jVar3 != null) {
                            jVar3.j(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                j jVar4 = jVar;
                if (jVar4 != null) {
                    StringBuilder sb = new StringBuilder("lottieJsonUrl加载失败1, response is not null:");
                    sb.append(xtVar != null);
                    sb.append(", isSuccess:");
                    if (xtVar != null && xtVar.tl()) {
                        z5 = true;
                    }
                    sb.append(z5);
                    jVar4.j(10001, sb.toString());
                }
            }

            @Override // com.bytedance.sdk.component.g.j.j
            public void j(com.bytedance.sdk.component.g.xt.r rVar, IOException iOException) {
                j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j(10001, "lottieJsonUrl加载失败3, " + iOException.getMessage());
                }
            }
        });
    }

    public void j(Context context, String str, final j<Bitmap> jVar) {
        az up = com.bytedance.sdk.component.adexpress.j.j.j.j().up();
        if (up != null) {
            up.j(str).cw(j(context)).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.xt.2
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv<Bitmap> qvVar) {
                    j jVar2;
                    try {
                        Bitmap cw = qvVar.cw();
                        if (cw == null || (jVar2 = jVar) == null) {
                            return;
                        }
                        jVar2.j(cw);
                    } catch (Throwable th) {
                        vl.j(th);
                    }
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str2, Throwable th) {
                    j jVar2 = jVar;
                    if (jVar2 != null) {
                        jVar2.j(i6, "load lottie pic fail: ".concat(String.valueOf(str2)));
                    }
                }
            }, 4);
        } else if (jVar != null) {
            jVar.j(-1, "imageCenter is null");
        }
    }

    public String j(String str) {
        String xt2 = up.xt(str);
        if (TextUtils.isEmpty(xt2)) {
            return null;
        }
        return this.cw.xt(xt2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2) {
        String xt2 = up.xt(str);
        if (TextUtils.isEmpty(xt2)) {
            return;
        }
        this.cw.j(xt2, str2);
    }

    public String j(Context context) {
        return m.j(context, com.bytedance.sdk.component.adexpress.j.j.j.j().cw().vl(), xt).getAbsolutePath();
    }
}
