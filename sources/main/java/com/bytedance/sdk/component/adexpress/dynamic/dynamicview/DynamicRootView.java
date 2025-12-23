package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.m;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.adexpress.xt.qv;
import com.bytedance.sdk.component.adexpress.xt.ws;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.r, com.bytedance.sdk.component.adexpress.theme.j {
    private ThemeStatusBroadcastReceiver ae;
    private Context av;
    private jy az;
    public View cw;

    /* renamed from: g, reason: collision with root package name */
    private ViewGroup f25689g;

    /* renamed from: i, reason: collision with root package name */
    private String f25690i;

    /* renamed from: j, reason: collision with root package name */
    protected final ws f25691j;
    private int jy;

    /* renamed from: m, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.up.j f25692m;
    private int oq;
    private List<com.bytedance.sdk.component.adexpress.dynamic.cw> qv;

    /* renamed from: r, reason: collision with root package name */
    private qv f25693r;
    private com.bytedance.sdk.component.adexpress.dynamic.xt tl;
    private DynamicBaseWidget up;
    private com.bytedance.sdk.component.adexpress.dynamic.up vl;

    /* renamed from: w, reason: collision with root package name */
    private Map<Integer, String> f25694w;
    private int ws;
    boolean xt;

    public void j(tl tlVar, int i6) {
        this.up = j(tlVar, this, i6);
        this.f25691j.j(true);
        this.f25691j.j(this.up.up);
        this.f25691j.xt(this.up.f25659m);
        this.f25691j.j(this.cw);
        this.f25693r.j(this.f25691j);
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.j
    public void b_(int i6) {
        DynamicBaseWidget dynamicBaseWidget = this.up;
        if (dynamicBaseWidget == null) {
            return;
        }
        dynamicBaseWidget.j(i6);
    }

    public String getBgColor() {
        return this.f25690i;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.f25694w;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.up.j getDynamicClickListener() {
        return this.f25692m;
    }

    public int getLogoUnionHeight() {
        return this.jy;
    }

    public qv getRenderListener() {
        return this.f25693r;
    }

    public jy getRenderRequest() {
        return this.az;
    }

    public int getScoreCountWithIcon() {
        return this.ws;
    }

    public ViewGroup getTimeOut() {
        return this.f25689g;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.cw> getTimeOutListener() {
        return this.qv;
    }

    public int getTimedown() {
        return this.oq;
    }

    public void setBgColor(String str) {
        this.f25690i = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.f25694w = map;
    }

    public void setDislikeView(View view) {
        this.f25692m.xt(view);
    }

    public void setLogoUnionHeight(int i6) {
        this.jy = i6;
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.xt xtVar) {
        this.tl = xtVar;
    }

    public void setRenderListener(qv qvVar) {
        this.f25693r = qvVar;
        this.f25692m.j(qvVar);
    }

    public void setScoreCountWithIcon(int i6) {
        this.ws = i6;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.r
    public void setSoundMute(boolean z5) {
        com.bytedance.sdk.component.adexpress.dynamic.xt xtVar = this.tl;
        if (xtVar != null) {
            xtVar.setSoundMute(z5);
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.f25689g = viewGroup;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.cw cwVar) {
        this.qv.add(cwVar);
    }

    public void setTimeUpdate(int i6) {
        this.vl.setTimeUpdate(i6);
    }

    public void setTimedown(int i6) {
        this.oq = i6;
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.up upVar) {
        this.vl = upVar;
    }

    public void xt() {
        j(this.up, 4);
    }

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z5, jy jyVar, com.bytedance.sdk.component.adexpress.dynamic.up.j jVar) {
        super(context);
        this.f25689g = null;
        this.oq = 0;
        this.qv = new ArrayList();
        this.jy = 0;
        this.ws = 0;
        this.av = context;
        ws wsVar = new ws();
        this.f25691j = wsVar;
        wsVar.j(2);
        this.f25692m = jVar;
        jVar.j(this);
        this.ae = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.j(this);
        this.xt = z5;
        this.az = jyVar;
    }

    public DynamicBaseWidget j(tl tlVar, ViewGroup viewGroup, int i6) {
        if (tlVar == null) {
            return null;
        }
        List<tl> qv = tlVar.qv();
        DynamicBaseWidget j6 = com.bytedance.sdk.component.adexpress.dynamic.j.xt.j(this.av, this, tlVar);
        if (j6 instanceof DynamicUnKnowView) {
            j(i6 == 3 ? 128 : 118, "unknow widget");
            return null;
        }
        j(tlVar);
        j6.j();
        if (viewGroup != null) {
            viewGroup.addView(j6);
            j(viewGroup, tlVar);
        }
        if (qv == null || qv.size() <= 0) {
            return null;
        }
        Iterator<tl> it = qv.iterator();
        while (it.hasNext()) {
            j(it.next(), j6, i6);
        }
        return j6;
    }

    private void j(tl tlVar) {
        m up;
        com.bytedance.sdk.component.adexpress.dynamic.cw.up oq = tlVar.oq();
        if (oq == null || (up = oq.up()) == null) {
            return;
        }
        this.f25691j.xt(up.nu());
    }

    private void j(ViewGroup viewGroup, tl tlVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !tlVar.x()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void j(double d6, double d7, double d8, double d9, float f6) {
        this.f25691j.cw(d6);
        this.f25691j.r(d7);
        this.f25691j.up(d8);
        this.f25691j.m(d9);
        this.f25691j.j(f6);
        this.f25691j.xt(f6);
        this.f25691j.cw(f6);
        this.f25691j.r(f6);
    }

    public void j(int i6, String str) {
        this.f25691j.j(false);
        this.f25691j.xt(i6);
        this.f25691j.j(str);
        this.f25693r.j(this.f25691j);
    }

    public void j() {
        j(this.up, 0);
    }

    public void j(DynamicBaseWidget dynamicBaseWidget, int i6) {
        if (dynamicBaseWidget == null) {
            return;
        }
        if (dynamicBaseWidget.getBeginInvisibleAndShow()) {
            dynamicBaseWidget.setVisibility(i6);
            View view = dynamicBaseWidget.az;
            if (view != null) {
                view.setVisibility(i6);
            }
        }
        int childCount = dynamicBaseWidget.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            if (dynamicBaseWidget.getChildAt(i7) instanceof DynamicBaseWidget) {
                j((DynamicBaseWidget) dynamicBaseWidget.getChildAt(i7), i6);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.r
    public void j(CharSequence charSequence, int i6, int i7, boolean z5) {
        for (int i8 = 0; i8 < this.qv.size(); i8++) {
            if (this.qv.get(i8) != null) {
                this.qv.get(i8).j(charSequence, i6 == 1, i7, z5);
            }
        }
    }
}
