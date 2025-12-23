package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    Paint f25586j;

    /* renamed from: m, reason: collision with root package name */
    private int f25587m;

    /* renamed from: r, reason: collision with root package name */
    private int f25588r;
    private int up;
    Path xt = new Path();
    Path cw = new Path();

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(android.graphics.Canvas r21, com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt r22, android.view.View r23) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.view.j.j(android.graphics.Canvas, com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt, android.view.View):void");
    }

    public j() {
        Paint paint = new Paint();
        this.f25586j = paint;
        paint.setAntiAlias(true);
    }

    public void j(View view, float f6) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.f25587m * f6);
        view.setTranslationX((r1 - r6) / 2);
        if (view instanceof DynamicImageView) {
            int i6 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i6 >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i6).setTranslationX((-(this.f25587m - layoutParams.width)) / 2);
                i6++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void j(View view, int i6, int i7) {
        String str;
        this.f25588r = i6 / 2;
        this.up = i7 / 2;
        if (this.f25587m == 0 && view.getLayoutParams().width > 0) {
            this.f25587m = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.cw.addRoundRect(new RectF(0.0f, 0.0f, i6, i7), i7 / 2, i7 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.f25588r * 2);
            view.setPivotY(this.up);
        } else if (ScrollClickView.DIR_LEFT.equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.up);
        } else {
            view.setPivotX(this.f25588r);
            view.setPivotY(this.up);
        }
    }
}
