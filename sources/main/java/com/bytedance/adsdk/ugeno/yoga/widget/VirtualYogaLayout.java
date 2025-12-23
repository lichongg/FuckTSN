package com.bytedance.adsdk.ugeno.yoga.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.ae;
import com.bytedance.adsdk.ugeno.yoga.oq;
import com.bytedance.adsdk.ugeno.yoga.qv;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final oq cw;

    /* renamed from: j, reason: collision with root package name */
    private final List<View> f23923j;
    private final Map<View, oq> xt;

    public void j(View view, oq oqVar) {
        this.f23923j.add(view);
        this.xt.put(view, oqVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i6, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.j(this);
            oq yogaNode = virtualYogaLayout.getYogaNode();
            oq oqVar = this.cw;
            oqVar.j(yogaNode, oqVar.j());
            return;
        }
        oq j6 = qv.j();
        YogaLayout.j(new YogaLayout.j(layoutParams), j6, view);
        j6.j(view);
        j6.j((ae) new YogaLayout.xt());
        oq oqVar2 = this.cw;
        oqVar2.j(j6, oqVar2.j());
        j(view, j6);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.j;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.j(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.j(layoutParams);
    }

    public oq getYogaNode() {
        return this.cw;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    protected void j(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.f23923j) {
                ((VirtualYogaLayout) viewGroup).j(view, this.xt.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.f23923j) {
                ((YogaLayout) viewGroup).j(view2, this.xt.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.f23923j.clear();
    }
}
