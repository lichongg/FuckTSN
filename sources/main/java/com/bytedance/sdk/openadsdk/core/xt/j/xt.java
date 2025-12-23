package com.bytedance.sdk.openadsdk.core.xt.j;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {
    public xt() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.j.j
    public int j(Map<String, Object> map, cw cwVar) {
        return !xt(this.f31326r) ? 1 : 0;
    }

    public boolean xt(View view) {
        if (view != null && this.f31325j != null) {
            String valueOf = String.valueOf(view.getTag(2097610717));
            if (view.getTag(2097610717) != null && !TextUtils.isEmpty(valueOf)) {
                if (AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK.equals(valueOf)) {
                    return this.cw.up();
                }
                return true;
            }
            Context context = this.xt;
            if (context == null) {
                context = v.getContext();
            }
            if (j(view, context)) {
                return this.f31325j.nd() != 1 || this.cw.up();
            }
            if (this.f31325j.n() == 1 && !this.cw.up()) {
                return false;
            }
        }
        return true;
    }

    public xt(n nVar, Context context) {
        this.f31325j = nVar;
        this.xt = context;
    }

    public boolean j(View view, Context context) {
        int id = view.getId();
        List<Integer> qv = this.cw.qv();
        if (qv != null && qv.size() == 0) {
            qv.add(2114387836);
            qv.add(2114387870);
            qv.add(2114387639);
            qv.add(2114387472);
            qv.add(2114387474);
            qv.add(2114387962);
            qv.add(2114387631);
        }
        return qv != null && qv.contains(Integer.valueOf(id));
    }

    public boolean j(View view, Point point) {
        int i6;
        int i7;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                View childAt = viewGroup.getChildAt(i8);
                Context context = this.xt;
                if (context == null) {
                    context = v.getContext();
                }
                if (j(childAt, context)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    int i9 = point.x;
                    int i10 = iArr[0];
                    return i9 >= i10 && i9 <= i10 + childAt.getWidth() && (i6 = point.y) >= (i7 = iArr[1]) && i6 <= i7 + childAt.getHeight();
                }
                if (j(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
