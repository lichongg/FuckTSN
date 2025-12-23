package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.component.video.api.j;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends ae {
    private final Runnable az;

    /* renamed from: g, reason: collision with root package name */
    private float f23429g;
    private LottieAnimationView jy;
    private com.bykv.vk.openvk.component.video.j.r.r oq;
    private volatile boolean qv;
    private float tl;
    private TextureView vl;
    private final Handler ws;

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        this.ws.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        ViewParent parent = this.vl.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.vl);
        }
        ViewParent parent2 = this.jy.getParent();
        if (parent2 instanceof ViewGroup) {
            this.vl.setTranslationX(2.1474836E9f);
            ((ViewGroup) parent2).addView(this.vl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        if (this.oq != null) {
            if (this.qv) {
                this.oq.r();
            }
            this.oq.up();
            this.oq = null;
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ae, com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        if (this.tl <= 0.0f || this.vl == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        j(i6);
        float tl = tl();
        j(this.vl, (int) this.tl, (int) this.f23429g);
        this.vl.setAlpha(tl);
        this.vl.draw(canvas);
        canvas.restore();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public xt(com.bytedance.adsdk.lottie.tl r3, com.bytedance.adsdk.lottie.model.layer.tl r4, final android.content.Context r5) {
        /*
            r2 = this;
            r2.<init>(r3, r4)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2.tl = r4
            r2.f23429g = r4
            android.os.Handler r4 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r4.<init>(r0)
            r2.ws = r4
            com.bytedance.adsdk.lottie.model.layer.xt$4 r4 = new com.bytedance.adsdk.lottie.model.layer.xt$4
            r4.<init>()
            r2.az = r4
            com.bytedance.adsdk.lottie.g r4 = r2.ae
            if (r4 == 0) goto La6
            if (r3 == 0) goto La6
            if (r5 == 0) goto La6
            com.bytedance.adsdk.lottie.LottieAnimationView r4 = r3.xt()
            r2.jy = r4
            if (r4 != 0) goto L2d
            goto La6
        L2d:
            float r4 = com.bytedance.adsdk.lottie.up.g.j()
            com.bytedance.adsdk.lottie.g r0 = r2.ae
            int r0 = r0.j()
            float r0 = (float) r0
            float r0 = r0 * r4
            int r0 = (int) r0
            float r0 = (float) r0
            r2.tl = r0
            com.bytedance.adsdk.lottie.g r0 = r2.ae
            int r0 = r0.xt()
            float r0 = (float) r0
            float r0 = r0 * r4
            int r4 = (int) r0
            float r4 = (float) r4
            r2.f23429g = r4
            com.bytedance.adsdk.lottie.kt r3 = r3.ch()
            if (r3 == 0) goto L6b
            com.bytedance.adsdk.lottie.g r4 = r2.ae
            java.lang.String r4 = r4.vl()
            java.lang.String r3 = r3.j(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L6b
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L67
            r4.<init>(r3)     // Catch: org.json.JSONException -> L67
            goto L6c
        L67:
            r3 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r3)
        L6b:
            r4 = 0
        L6c:
            if (r4 == 0) goto La6
            java.lang.String r3 = "file_hash"
            java.lang.String r3 = r4.optString(r3)
            java.lang.String r0 = "video_url"
            java.lang.String r0 = r4.optString(r0)
            java.lang.String r1 = "video_duration"
            r4.optString(r1)
            java.lang.String r1 = "resolution"
            r4.optString(r1)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto La6
            android.view.TextureView r4 = new android.view.TextureView
            r4.<init>(r5)
            r2.vl = r4
            com.bytedance.adsdk.lottie.model.layer.xt$1 r1 = new com.bytedance.adsdk.lottie.model.layer.xt$1
            r1.<init>()
            r4.setSurfaceTextureListener(r1)
            com.bytedance.adsdk.lottie.LottieAnimationView r3 = r2.jy
            com.bytedance.adsdk.lottie.model.layer.xt$2 r4 = new com.bytedance.adsdk.lottie.model.layer.xt$2
            r4.<init>()
            r3.addOnAttachStateChangeListener(r4)
            r2.az()
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.xt.<init>(com.bytedance.adsdk.lottie.tl, com.bytedance.adsdk.lottie.model.layer.tl, android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        av();
        if (this.jy != null) {
            this.ws.postDelayed(this.az, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        ws();
        com.bykv.vk.openvk.component.video.j.r.r rVar = new com.bykv.vk.openvk.component.video.j.r.r("uttie");
        this.oq = rVar;
        rVar.j(surfaceTexture);
        this.oq.j(new j.InterfaceC0305j() { // from class: com.bytedance.adsdk.lottie.model.layer.xt.3
            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void xt(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void xt(com.bykv.vk.openvk.component.video.api.j jVar) {
                xt.this.qv = true;
                jVar.cw(true);
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, int i6, int i7, int i8) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, long j6) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, long j6, long j7) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, boolean z5) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void j(com.bykv.vk.openvk.component.video.api.j jVar, com.bykv.vk.openvk.component.video.api.cw.xt xtVar) {
                com.bytedance.sdk.component.utils.vl.r("uttie-video", xtVar.j() + ":" + xtVar.xt() + ":" + xtVar.cw());
            }

            @Override // com.bykv.vk.openvk.component.video.api.j.InterfaceC0305j
            public void cw(com.bykv.vk.openvk.component.video.api.j jVar) {
            }
        });
        com.bykv.vk.openvk.component.video.api.cw.cw cwVar = new com.bykv.vk.openvk.component.video.api.cw.cw();
        cwVar.cw(str);
        cwVar.up(str2);
        this.oq.j(new com.bykv.vk.openvk.component.video.api.cw.r(com.bytedance.adsdk.lottie.up.xt.xt(context), cwVar, null, 0, 0));
        this.oq.j(true);
        this.oq.j(true, 0L, true);
    }

    private static void j(View view, int i6, int i7) {
        view.layout(0, 0, i6, i7);
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
