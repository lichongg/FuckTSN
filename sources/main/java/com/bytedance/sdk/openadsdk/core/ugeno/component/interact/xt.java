package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.av;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt {
    protected cw cw;

    /* renamed from: j, reason: collision with root package name */
    protected final n f30617j;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f30618r = false;
    private EasyPlayableContainer up;
    protected j xt;

    protected abstract int j();

    public abstract boolean j(int i6, int i7);

    public abstract ae xt();

    public xt(n nVar, j jVar, cw cwVar) {
        this.f30617j = nVar;
        this.xt = jVar;
        this.cw = cwVar;
    }

    protected void j(final ViewGroup viewGroup, final View view, final View view2, final boolean z5, final boolean z6, final float[] fArr, final com.bytedance.sdk.openadsdk.core.f.xt xtVar) {
        final HashMap hashMap = new HashMap();
        hashMap.put("render_type", Integer.valueOf(j()));
        if (viewGroup != null && view != null && view2 != null) {
            view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!xt.this.j(view.getWidth(), view.getHeight())) {
                        hashMap.put("view_width", Integer.valueOf(view.getWidth()));
                        hashMap.put("view_height", Integer.valueOf(view.getHeight()));
                        hashMap.put("error_code", 103);
                        xt.this.cw.j(false, (Map<String, Object>) hashMap);
                        return;
                    }
                    boolean[] zArr = {true};
                    av j6 = xt.this.j(zArr, fArr, xtVar, view.getWidth(), view.getHeight());
                    if (!zArr[0]) {
                        xt.this.j(xtVar);
                        return;
                    }
                    xt xtVar2 = xt.this;
                    xtVar2.cw.xt(xtVar2.j());
                    if (view2.getParent() != null) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                    }
                    xt.this.up = new EasyPlayableContainer(v.getContext(), xt.this.xt(), j6, xt.this.f30617j);
                    xt.this.up.setTag("easy_pfwv");
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    xt.this.up.addView(view2, layoutParams);
                    hashMap.put("container_name", viewGroup.getClass().getName());
                    int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationInWindow(iArr2);
                    ViewGroup viewGroup2 = viewGroup;
                    if (viewGroup2 instanceof RelativeLayout) {
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams2.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        xt.this.up.setLayoutParams(layoutParams2);
                        viewGroup.addView(xt.this.up);
                        if (!z5) {
                            viewGroup.setClipChildren(false);
                        }
                        if (!z6) {
                            xt.this.cw.j(true, (Map<String, Object>) hashMap);
                            xt.this.j(xtVar, j6);
                            return;
                        }
                        hashMap.put("error_code", 105);
                    } else if (viewGroup2 instanceof FrameLayout) {
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                        layoutParams3.setMargins(iArr[0] - iArr2[0], iArr[1] - iArr2[1], 0, 0);
                        xt.this.up.setLayoutParams(layoutParams3);
                        viewGroup.addView(xt.this.up);
                        if (!z5) {
                            viewGroup.setClipChildren(false);
                        }
                        if (!z6) {
                            xt.this.cw.j(true, (Map<String, Object>) hashMap);
                            xt.this.j(xtVar, j6);
                            return;
                        }
                        hashMap.put("error_code", 105);
                    }
                    xt.this.cw.j(false, (Map<String, Object>) hashMap);
                }
            });
        } else {
            hashMap.put("error_code", 102);
            this.cw.j(false, (Map<String, Object>) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public av j(boolean[] zArr, float[] fArr, com.bytedance.sdk.openadsdk.core.f.xt xtVar, float f6, float f7) {
        av avVar;
        final double d6;
        av j6 = xtVar != null ? av.j(xtVar.xt()) : null;
        if (fArr == null) {
            if (j6 == null) {
                return new av(0.0d, 0.0d, ed.r(v.getContext(), f6), ed.r(v.getContext(), f7));
            }
            return j6;
        }
        final av j7 = j(fArr, f6, f7);
        if (j6 == null) {
            return j7;
        }
        double j8 = av.j(j6, j7);
        final double d7 = j7.cw * j7.f30222r;
        final double d8 = j6.cw * j6.f30222r;
        final av xt = av.xt(j6, j7);
        if (xt != null) {
            avVar = null;
            d6 = xt.cw * xt.f30222r;
        } else {
            avVar = null;
            d6 = 0.0d;
        }
        if (xtVar != null) {
            xtVar.j(new com.bytedance.sdk.openadsdk.core.f.cw() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xt.2
                @Override // com.bytedance.sdk.openadsdk.core.f.cw
                public JSONObject getActualRectJson() {
                    return av.j(j7);
                }

                @Override // com.bytedance.sdk.openadsdk.core.f.cw
                public double getExceedAreaRate() {
                    double d9 = d8;
                    if (d9 <= 0.0d) {
                        return 1.0d;
                    }
                    if (d7 <= 0.0d) {
                        return -1.0d;
                    }
                    return (d6 - d9) / d9;
                }

                @Override // com.bytedance.sdk.openadsdk.core.f.cw
                public JSONObject getMaxRectJson() {
                    return av.j(xt);
                }
            });
        }
        if (d8 <= 0.0d) {
            zArr[0] = false;
            return avVar;
        }
        if (d7 <= 0.0d) {
            zArr[0] = false;
            return avVar;
        }
        double d9 = j8 / d7;
        boolean z5 = d9 >= 0.8d;
        com.bytedance.sdk.component.utils.vl.j("xeasy", "A:" + d8 + " B:" + d7 + " o:" + j8 + " R:" + d9);
        if (z5) {
            return xt;
        }
        zArr[0] = false;
        return avVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.f.xt xtVar, av avVar) {
        if (xtVar != null) {
            xtVar.j(true, av.j(avVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.bytedance.sdk.openadsdk.core.f.xt xtVar) {
        if (xtVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.vl.xt("xeasy", e6.getMessage());
            }
            xtVar.j(false, jSONObject);
        }
    }

    private av j(float[] fArr, float f6, float f7) {
        int r5 = ed.r(v.getContext(), f6);
        int r6 = ed.r(v.getContext(), f7);
        float f8 = fArr[1];
        float f9 = fArr[0];
        float f10 = (r5 - f8) - fArr[3];
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        return new av(f8, f9, f10, (r6 - f9) - fArr[2] >= 0.0f ? r15 : 0.0f);
    }
}
