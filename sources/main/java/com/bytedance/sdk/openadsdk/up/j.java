package com.bytedance.sdk.openadsdk.up;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.adsdk.ugeno.cw.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.tj.a;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.w;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.upie.j;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static boolean ae(n nVar) {
        int[] up;
        if (nVar == null || (up = ln.up(nVar)) == null || up.length < 2) {
            return true;
        }
        int i6 = up[0];
        int i7 = up[1];
        int r5 = ln.r(nVar);
        int cw = ln.cw(nVar);
        return (i6 >= i7 && r5 >= cw) || (i6 <= i7 && r5 <= cw);
    }

    public static boolean cw(n nVar) {
        return nVar != null && nVar.to() == 16;
    }

    public static boolean j(n nVar) {
        return xt(nVar) || cw(nVar);
    }

    public static boolean tl(n nVar) {
        if (nVar != null && !n.xt(nVar)) {
            if (r(nVar)) {
                return true;
            }
            if (!v.xt().xj() && (a.j(nVar) || a.xt(nVar) || UGenVideoOrImgPanelView.j(nVar))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(ImageView imageView, UpieImageView upieImageView) {
        ViewGroup.LayoutParams layoutParams;
        ViewParent parent = imageView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int i6 = 0;
            while (true) {
                if (i6 >= viewGroup.getChildCount()) {
                    i6 = -1;
                    break;
                } else if (imageView == viewGroup.getChildAt(i6)) {
                    break;
                } else {
                    i6++;
                }
            }
            if (i6 != -1) {
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams2.gravity = 17;
                    layoutParams = layoutParams2;
                } else if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(imageView.getWidth(), imageView.getHeight());
                    layoutParams4.gravity = 17;
                    layoutParams = layoutParams4;
                } else {
                    layoutParams = new ViewGroup.LayoutParams(imageView.getWidth(), imageView.getHeight());
                }
                viewGroup.addView(upieImageView, i6, layoutParams);
                viewGroup.removeView(imageView);
            }
        }
    }

    public static com.bytedance.sdk.openadsdk.upie.j j(n nVar, JSONObject jSONObject) {
        j.C0506j qv = qv(nVar);
        if (jSONObject != null) {
            try {
                jSONObject.put("os", FaceEnvironment.OS);
            } catch (JSONException unused) {
            }
        }
        qv.j(jSONObject);
        return qv.j();
    }

    public static boolean m(n nVar) {
        return nVar != null && nVar.to() == 18;
    }

    public static com.bytedance.sdk.openadsdk.upie.image.lottie.j oq(final n nVar) {
        if (nVar == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.upie.image.lottie.j() { // from class: com.bytedance.sdk.openadsdk.up.j.2
            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.j
            public void j(Map<String, Object> map) {
                ws.j().j(n.this, map.get("duration"));
            }

            @Override // com.bytedance.sdk.openadsdk.upie.image.lottie.j
            public void j(int i6, String str) {
                ws.j().j(n.this, i6, str);
            }
        };
    }

    public static boolean up(n nVar) {
        return nVar != null && nVar.to() == 17;
    }

    private static String vl(n nVar) {
        List<h> fp;
        if (nVar == null || (fp = nVar.fp()) == null || fp.size() <= 0) {
            return null;
        }
        return fp.get(0).j();
    }

    public static boolean xt(n nVar) {
        return nVar != null && nVar.to() == 15;
    }

    public static com.bytedance.sdk.openadsdk.upie.j g(n nVar) {
        if (!r(nVar) && !j(nVar)) {
            return new j.C0506j().cw(vl(nVar)).j();
        }
        j.C0506j qv = qv(nVar);
        JSONObject tv2 = nVar.tv();
        if (tv2 != null) {
            try {
                tv2.put("os", FaceEnvironment.OS);
            } catch (JSONException unused) {
            }
        }
        qv.j(tv2);
        return qv.j();
    }

    private static j.C0506j qv(n nVar) {
        String str;
        int i6;
        int i7;
        int[] up = ln.up(nVar);
        w av = nVar.av();
        if (av != null) {
            str = av.cw();
        } else {
            str = null;
        }
        j.C0506j c0506j = new j.C0506j();
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        j.C0506j j6 = c0506j.j(str);
        if (up != null && up.length >= 2) {
            i6 = up[0];
        } else {
            i6 = PredefinedCaptureConfigurations.f35648o;
        }
        j.C0506j j7 = j6.j(i6);
        if (up != null && up.length >= 2) {
            i7 = up[1];
        } else {
            i7 = PredefinedCaptureConfigurations.f35647n;
        }
        j.C0506j xt = j7.xt(i7);
        if (xt(nVar)) {
            com.bykv.vk.openvk.component.video.api.cw.j av2 = ln.av(nVar);
            j.C0506j cw = xt.cw(vl(nVar));
            if (av2 != null) {
                str2 = av2.up();
            }
            cw.xt(str2).j(((long) ln.m(nVar)) * 1000);
        }
        if (r(nVar)) {
            xt.cw(vl(nVar));
        }
        return xt;
    }

    public static boolean r(n nVar) {
        if (!up(nVar) && !m(nVar)) {
            return false;
        }
        return true;
    }

    public static void j(JSONObject jSONObject, n nVar) {
        if (jSONObject != null) {
            if (j(nVar) || r(nVar)) {
                try {
                    jSONObject.put("dynamic_join_type", nVar.to());
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        }
    }

    public static void j(boolean z5, g.j jVar) {
        JSONObject r5;
        if (jVar == null || (r5 = jVar.r()) == null || !TextUtils.equals("${image[0].url}", r5.optString("src"))) {
            return;
        }
        try {
            if (z5) {
                r5.put("type", "UpieImage");
            } else {
                r5.put(CommonNetImpl.NAME, "UpieImage");
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        jVar.j("UpieImage");
    }

    public static void j(final ImageView imageView, final UpieImageView upieImageView) {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.up.j.1
            @Override // java.lang.Runnable
            public void run() {
                final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.up.j.1.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        int width = imageView.getWidth();
                        int height = imageView.getHeight();
                        if (width <= 90 || height <= 90) {
                            return;
                        }
                        imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        j.cw(imageView, upieImageView);
                    }
                };
                imageView.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
                imageView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.up.j.1.2
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        ImageView imageView2 = imageView;
                        if (imageView2 == view) {
                            imageView2.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }
                });
            }
        });
    }
}
