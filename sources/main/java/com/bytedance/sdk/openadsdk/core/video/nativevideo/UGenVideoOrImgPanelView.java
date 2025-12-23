package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.adsdk.ugeno.cw.f;
import com.bytedance.sdk.component.adexpress.xt.ws;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kt;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.express.xt;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class UGenVideoOrImgPanelView extends NativeExpressView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f31013a;
    private final AtomicBoolean ch;
    private final NativeVideoTsView cw;

    /* renamed from: f, reason: collision with root package name */
    private View f31014f;

    /* renamed from: j, reason: collision with root package name */
    private final n f31015j;

    /* renamed from: r, reason: collision with root package name */
    private final View f31016r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f31017s;
    private final j tj;
    private final CopyOnWriteArrayList<Message> up;

    /* renamed from: v, reason: collision with root package name */
    private ViewGroup f31018v;

    /* renamed from: x, reason: collision with root package name */
    private final Context f31019x;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.r xt;

    static class j extends Handler {

        /* renamed from: j, reason: collision with root package name */
        UGenVideoOrImgPanelView f31031j;

        private j(Looper looper) {
            super(looper);
        }

        public void j(UGenVideoOrImgPanelView uGenVideoOrImgPanelView) {
            this.f31031j = uGenVideoOrImgPanelView;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r3) {
            /*
                r2 = this;
                super.handleMessage(r3)
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r0 = r2.f31031j
                if (r0 != 0) goto L8
                goto L30
            L8:
                boolean r0 = com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.up(r0)
                if (r0 == 0) goto Lf
                goto L30
            Lf:
                if (r3 != 0) goto L12
                goto L30
            L12:
                java.lang.Object r0 = r3.obj
                boolean r1 = r0 instanceof java.lang.ref.WeakReference
                if (r1 == 0) goto L25
                java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
                java.lang.Object r0 = r0.get()
                boolean r1 = r0 instanceof android.view.View
                if (r1 == 0) goto L25
                android.view.View r0 = (android.view.View) r0
                goto L26
            L25:
                r0 = 0
            L26:
                if (r0 != 0) goto L29
                goto L30
            L29:
                int r3 = r3.what
                if (r3 == 0) goto L37
                r1 = 2
                if (r3 == r1) goto L31
            L30:
                return
            L31:
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r3 = r2.f31031j
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.cw(r3, r0)
                return
            L37:
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView r3 = r2.f31031j
                com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.xt(r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.j.handleMessage(android.os.Message):void");
        }
    }

    public UGenVideoOrImgPanelView(Context context, n nVar, NativeVideoTsView nativeVideoTsView, View view, ViewGroup viewGroup, String str, boolean z5) {
        super(context, nVar, new com.bytedance.sdk.openadsdk.i.cw.cw.xt(new SparseArray()), str);
        this.up = new CopyOnWriteArrayList<>();
        j jVar = new j(Looper.getMainLooper());
        this.tj = jVar;
        this.ch = new AtomicBoolean(true);
        this.f31017s = false;
        this.f31013a = false;
        this.f31019x = context;
        this.f31015j = nVar;
        this.cw = nativeVideoTsView;
        this.f31016r = view;
        this.f31018v = viewGroup;
        jVar.j(this);
        this.f31013a = z5;
        ws();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void jy() {
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.8
            @Override // java.lang.Runnable
            public void run() {
                UGenVideoOrImgPanelView.this.f31017s = true;
                if (UGenVideoOrImgPanelView.this.f31014f != null) {
                    ViewParent parent = UGenVideoOrImgPanelView.this.f31014f.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(UGenVideoOrImgPanelView.this.f31014f);
                    }
                }
                UGenVideoOrImgPanelView.super.jy();
                if (UGenVideoOrImgPanelView.this.xt != null) {
                    UGenVideoOrImgPanelView.this.xt.qv();
                }
            }
        });
    }

    public void setAdSlot(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        this.tl = xtVar;
    }

    public void ws() {
        n nVar;
        JSONObject lx;
        JSONArray optJSONArray;
        if (this.ch.getAndSet(false) && (nVar = this.f31015j) != null) {
            if ((this.cw == null && this.f31016r == null) || nVar.ve() == 166 || (lx = this.f31015j.lx()) == null || (optJSONArray = lx.optJSONArray("components")) == null) {
                return;
            }
            this.mi = v.xt().r(uf.g(this.f31015j));
            int length = optJSONArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                final int optInt = optJSONObject.optInt("render_sequence");
                final int optInt2 = optJSONObject.optInt("displayAreaAndroid");
                String optString = optJSONObject.optString("ugen_md5");
                String optString2 = optJSONObject.optString("ugen_url");
                final String optString3 = optJSONObject.optString("ugen_id");
                JSONObject xt = oq.xt(optString, optString2);
                if (xt == null || xt.length() <= 0) {
                    oq.j(optString, optString2, new com.bytedance.sdk.openadsdk.core.ugeno.cw() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.1
                        @Override // com.bytedance.sdk.openadsdk.core.ugeno.cw
                        public void j(String str) {
                            try {
                                UGenVideoOrImgPanelView.this.j(new JSONObject(str), optInt2, optString3, optInt);
                            } catch (Throwable th) {
                                vl.j(th);
                            }
                        }
                    });
                } else {
                    j(xt, optInt2, optString3, optInt);
                }
            }
        }
    }

    private void cw(final int i6, final String str) {
        this.xt.j(new com.bytedance.sdk.component.adexpress.xt.ae() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.4
            @Override // com.bytedance.sdk.component.adexpress.xt.ae
            public void j(View view, ws wsVar) {
                View childAt;
                if ((UGenVideoOrImgPanelView.this.cw == null && UGenVideoOrImgPanelView.this.f31016r == null) || view == null) {
                    return;
                }
                UGenVideoOrImgPanelView.this.f31014f = view;
                boolean j6 = UGenVideoOrImgPanelView.this.j(view, i6);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (viewGroup.getChildCount() > 0 && (childAt = viewGroup.getChildAt(0)) != null && childAt.getVisibility() == 8) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("error_code", 105);
                        hashMap.put("render_type", 1);
                        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(UGenVideoOrImgPanelView.this.f31015j, false, str, 3, (Map<String, Object>) hashMap);
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(UGenVideoOrImgPanelView.this.f31015j, j6, str, 3, (Map<String, Object>) null);
            }

            @Override // com.bytedance.sdk.component.adexpress.xt.ae
            public void j(int i7, String str2) {
                HashMap hashMap = new HashMap();
                hashMap.put("error_code", Integer.valueOf(i7));
                hashMap.put("error_msg", str2);
                hashMap.put("render_type", 1);
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(UGenVideoOrImgPanelView.this.f31015j, false, str, 3, (Map<String, Object>) hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xt(final View view) {
        ViewGroup viewGroup = this.f31018v;
        if (viewGroup == null || view == null || this.cw == null) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.6
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.f31018v.getWidth(), UGenVideoOrImgPanelView.this.f31018v.getHeight()));
                view.setVisibility(0);
                UGenVideoOrImgPanelView.this.cw.removeView(view);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.cw.addView(view);
                UGenVideoOrImgPanelView.this.f31018v.getGlobalVisibleRect(new Rect());
                UGenVideoOrImgPanelView.this.cw.getGlobalVisibleRect(new Rect());
                view.setTranslationY(r2.top - r3.top);
                for (ViewParent parent2 = UGenVideoOrImgPanelView.this.cw.getParent(); parent2 != null; parent2 = parent2.getParent()) {
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).setClipChildren(false);
                        if (parent2.hashCode() == UGenVideoOrImgPanelView.this.f31018v.hashCode()) {
                            return;
                        }
                    }
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cw(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.f31018v;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.7
            @Override // java.lang.Runnable
            public void run() {
                view.setLayoutParams(new ViewGroup.LayoutParams(UGenVideoOrImgPanelView.this.f31018v.getWidth(), UGenVideoOrImgPanelView.this.f31018v.getHeight()));
                view.setVisibility(0);
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                UGenVideoOrImgPanelView.this.f31018v.removeView(view);
                UGenVideoOrImgPanelView.this.f31018v.addView(view);
            }
        });
        return true;
    }

    public static boolean j(n nVar) {
        JSONObject lx;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        return (nVar == null || (lx = nVar.lx()) == null || (optJSONArray = lx.optJSONArray("components")) == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null || TextUtils.isEmpty(optJSONObject.optString("ugen_url"))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final JSONObject jSONObject, final int i6, final String str, final int i7) {
        if (jSONObject == null) {
            return;
        }
        NativeVideoTsView nativeVideoTsView = this.cw;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.2
                @Override // java.lang.Runnable
                public void run() {
                    UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                    uGenVideoOrImgPanelView.j(uGenVideoOrImgPanelView.cw, jSONObject, i6, str, i7);
                }
            });
            return;
        }
        View view = this.f31016r;
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (i6 == 0) {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView.j(uGenVideoOrImgPanelView.f31018v, jSONObject, i6, str, i7);
                    } else {
                        UGenVideoOrImgPanelView uGenVideoOrImgPanelView2 = UGenVideoOrImgPanelView.this;
                        uGenVideoOrImgPanelView2.j(uGenVideoOrImgPanelView2.f31016r, jSONObject, i6, str, i7);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(View view, JSONObject jSONObject, int i6, String str, int i7) {
        if (i7 == 3) {
            jSONObject = com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(this.f31015j, com.bytedance.sdk.openadsdk.core.nativeexpress.xt.xt.j(view), jSONObject, this.f31013a);
        }
        JSONObject j6 = oq.j(this.f31015j, view, this.f31013a);
        if (j6 != null && !TextUtils.isEmpty(str)) {
            try {
                j6.put("ugen_id", str);
            } catch (JSONException unused) {
            }
        }
        xt.j jVar = new xt.j();
        jVar.up(j6);
        jVar.j(jSONObject);
        jVar.j((f) new kt());
        jVar.xt(view.getHeight());
        jVar.j(view.getWidth());
        jVar.j(com.bytedance.sdk.openadsdk.core.oq.i().up());
        jVar.oq(this.f31015j.ae());
        com.bytedance.sdk.openadsdk.core.ugeno.express.xt j7 = jVar.j();
        if (i7 == 3) {
            this.xt = new com.bytedance.sdk.openadsdk.core.ugeno.express.m(this.f31019x, this.f31015j, j7, this.f31018v);
        } else {
            this.xt = new com.bytedance.sdk.openadsdk.core.ugeno.express.r(this.f31019x, this.f31015j, j7, this.f31018v);
        }
        this.xt.j(this);
        cw(i6, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean j(android.view.View r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.f31017s
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            if (r5 == 0) goto L57
            r2 = 2
            if (r5 == r2) goto L3b
            com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r5 = r3.cw
            if (r5 == 0) goto L32
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == 0) goto L1f
            android.view.ViewParent r5 = r4.getParent()
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r5.removeView(r4)
        L1f:
            android.view.ViewGroup$LayoutParams r5 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            r5.<init>(r2, r2)
            r4.setLayoutParams(r5)
            r4.setVisibility(r1)
            com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView r5 = r3.cw
            r5.addView(r4)
        L30:
            r1 = 1
            goto L73
        L32:
            android.view.View r5 = r3.f31016r
            if (r5 == 0) goto L73
            boolean r1 = r3.j(r4)
            goto L73
        L3b:
            android.view.ViewGroup r5 = r3.f31018v
            if (r5 == 0) goto L44
            boolean r1 = r3.xt(r4)
            goto L73
        L44:
            android.os.Message r5 = android.os.Message.obtain()
            r5.what = r2
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            r5.obj = r1
            java.util.concurrent.CopyOnWriteArrayList<android.os.Message> r1 = r3.up
            r1.add(r5)
            goto L30
        L57:
            android.view.ViewGroup r5 = r3.f31018v
            if (r5 == 0) goto L60
            boolean r1 = r3.cw(r4)
            goto L73
        L60:
            android.os.Message r5 = android.os.Message.obtain()
            r5.what = r1
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            r5.obj = r1
            java.util.concurrent.CopyOnWriteArrayList<android.os.Message> r1 = r3.up
            r1.add(r5)
            goto L30
        L73:
            android.view.View r5 = r3.f31016r
            if (r5 != 0) goto L7f
            r4.bringToFront()
            boolean r4 = r3.mi
            r3.j(r4)
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.j(android.view.View, int):boolean");
    }

    private boolean j(final View view) {
        if (view == null) {
            return false;
        }
        ViewGroup viewGroup = this.f31018v;
        if (!(viewGroup instanceof FrameLayout) && !(viewGroup instanceof RelativeLayout)) {
            return false;
        }
        this.f31016r.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.UGenVideoOrImgPanelView.5
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                UGenVideoOrImgPanelView.this.f31016r.getLocationInWindow(iArr);
                int[] iArr2 = new int[2];
                UGenVideoOrImgPanelView.this.f31018v.getLocationInWindow(iArr2);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (UGenVideoOrImgPanelView.this.f31018v instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UGenVideoOrImgPanelView.this.f31016r.getWidth(), UGenVideoOrImgPanelView.this.f31016r.getHeight());
                    layoutParams.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.f31018v.addView(view, layoutParams);
                }
                if (UGenVideoOrImgPanelView.this.f31018v instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UGenVideoOrImgPanelView.this.f31016r.getWidth(), UGenVideoOrImgPanelView.this.f31016r.getHeight());
                    layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                    view.setVisibility(0);
                    UGenVideoOrImgPanelView.this.f31018v.addView(view, layoutParams2);
                }
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xt.tl
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar) {
        super.j(view, i6, cwVar);
        View view2 = this.cw;
        if (view2 == null) {
            view2 = this.f31016r;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(this.f31015j, com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(view2, cwVar), com.bytedance.sdk.openadsdk.core.ugeno.component.interact.oq.j(cwVar), 3, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.xt.tl
    public void j(View view, int i6, com.bytedance.sdk.component.adexpress.cw cwVar, int i7) {
        super.j(view, i6, cwVar, i7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.qv
    public void j(boolean z5) {
        NativeVideoTsView nativeVideoTsView = this.cw;
        if (nativeVideoTsView == null) {
            return;
        }
        this.mi = z5;
        nativeVideoTsView.xt(z5, true);
        com.bykv.vk.openvk.component.video.api.r.cw nativeVideoController = this.cw.getNativeVideoController();
        if (nativeVideoController != null) {
            nativeVideoController.xt(z5);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.r rVar = this.xt;
        if (rVar == null) {
            return;
        }
        rVar.setSoundMute(z5);
    }
}
