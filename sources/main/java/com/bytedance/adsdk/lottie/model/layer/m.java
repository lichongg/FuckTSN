package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.kt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m extends ae {

    /* renamed from: g, reason: collision with root package name */
    private final LinearLayout.LayoutParams f23395g;
    private final List<String> oq;
    private final List<TextView> qv;
    private LinearLayout tl;
    private String vl;

    private void j(TextView textView, g.xt xtVar, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(xtVar.cw)) {
            textView.setTextColor(Color.parseColor(xtVar.cw));
        } else if (!TextUtils.isEmpty(xtVar.f23234r)) {
            textView.setTextColor(Color.parseColor(xtVar.f23234r));
        }
        if (!TextUtils.isEmpty(xtVar.up)) {
            textView.setBackgroundColor(Color.parseColor(xtVar.up));
        }
        if (xtVar.ae == 0) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, xtVar.f23233m);
    }

    private void xt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.tl.setGravity(17);
            return;
        }
        str.getClass();
        if (str.equals(ScrollClickView.DIR_LEFT)) {
            this.tl.setGravity(3);
        } else if (str.equals("right")) {
            this.tl.setGravity(5);
        } else {
            this.tl.setGravity(17);
        }
    }

    private void cw(float f6) {
        List<g.xt> cw;
        com.bytedance.adsdk.lottie.g gVar = ((ae) this).ae;
        if (gVar == null || (cw = gVar.cw()) == null || cw.size() <= 0) {
            return;
        }
        this.tl.setOrientation(0);
        this.tl.setGravity(17);
        if (this.tl.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.tl.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.tl.removeAllViews();
        if (linearLayout.getChildCount() != cw.size()) {
            return;
        }
        List<String> ws = ws();
        this.qv.clear();
        int i6 = 0;
        while (i6 < cw.size()) {
            g.xt xtVar = cw.get(i6);
            TextView textView = (TextView) linearLayout.getChildAt(i6);
            this.qv.add(textView);
            j(textView, xtVar, (ws == null || i6 >= ws.size()) ? "" : ws.get(i6));
            i6++;
        }
        linearLayout.removeAllViews();
        for (int i7 = 0; i7 < cw.size(); i7++) {
            g.xt xtVar2 = cw.get(i7);
            TextView textView2 = this.qv.get(i7);
            textView2.setAlpha(f6);
            linearLayout.setAlpha(f6);
            int i8 = xtVar2.tl;
            if (i8 != 0) {
                this.f23395g.bottomMargin = (int) (i8 * com.bytedance.adsdk.lottie.up.g.j());
                linearLayout.addView(textView2, this.f23395g);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.tl.setAlpha(f6);
        this.tl.addView(linearLayout);
        float j6 = com.bytedance.adsdk.lottie.up.g.j();
        j(this.tl, (int) (((ae) this).ae.j() * j6), (int) (((ae) this).ae.xt() * j6));
    }

    private List<String> ws() {
        com.bytedance.adsdk.lottie.tl tlVar;
        kt ch;
        List<g.xt> cw;
        if (((ae) this).ae == null || (tlVar = this.xt) == null || (ch = tlVar.ch()) == null) {
            return null;
        }
        String r5 = ((ae) this).ae.r();
        if ((!TextUtils.isEmpty(r5) || !TextUtils.isEmpty(this.vl)) && (cw = ((ae) this).ae.cw()) != null) {
            String str = this.vl;
            if (TextUtils.isEmpty(str)) {
                str = ch.j(r5);
            }
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                this.oq.clear();
                for (int i6 = 0; i6 < cw.size(); i6++) {
                    g.xt xtVar = cw.get(i6);
                    int i7 = xtVar.f23232j;
                    int i8 = xtVar.xt;
                    if (i7 < 0) {
                        i7 = Math.max(i7 + length, 0);
                    }
                    if (i8 < 0) {
                        i8 = Math.max(i8 + length, 0);
                    }
                    if (i7 + i8 > length) {
                        this.oq.add("");
                    } else {
                        if (cw.size() == 1 && i7 == 0 && i8 == 0) {
                            i8 = length;
                        }
                        this.oq.add(str.substring(i7, i8 + i7));
                    }
                }
                return this.oq;
            }
        }
        return null;
    }

    public m(com.bytedance.adsdk.lottie.tl tlVar, tl tlVar2, Context context) {
        super(tlVar, tlVar2);
        List<g.xt> cw;
        String str;
        this.f23395g = new LinearLayout.LayoutParams(-2, -2);
        this.oq = new ArrayList();
        this.qv = new ArrayList();
        com.bytedance.adsdk.lottie.g gVar = ((ae) this).ae;
        if (gVar != null && (cw = gVar.cw()) != null && cw.size() > 0) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.tl = linearLayout;
            linearLayout.setOrientation(0);
            xt(cw.get(0).f23231g);
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(80);
            this.tl.addView(linearLayout2);
            List<String> ws = ws();
            for (int i6 = 0; i6 < cw.size(); i6++) {
                g.xt xtVar = cw.get(i6);
                TextView textView = new TextView(context);
                if (ws != null && i6 < ws.size()) {
                    str = ws.get(i6);
                } else {
                    str = "";
                }
                j(textView, xtVar, str);
                int i7 = xtVar.tl;
                if (i7 != 0) {
                    this.f23395g.bottomMargin = (int) (i7 * com.bytedance.adsdk.lottie.up.g.j());
                    linearLayout2.addView(textView, this.f23395g);
                } else {
                    linearLayout2.addView(textView);
                }
            }
            float j6 = com.bytedance.adsdk.lottie.up.g.j();
            j(this.tl, (int) (((ae) this).ae.j() * j6), (int) (((ae) this).ae.xt() * j6));
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ae, com.bytedance.adsdk.lottie.model.layer.cw
    public void xt(Canvas canvas, Matrix matrix, int i6) {
        if (this.tl != null) {
            canvas.save();
            canvas.concat(matrix);
            j(i6);
            cw(tl());
            this.tl.draw(canvas);
            canvas.restore();
            return;
        }
        super.xt(canvas, matrix, i6);
    }

    private static void j(View view, int i6, int i7) {
        view.layout(0, 0, i6, i7);
        view.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i7, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void j(String str) {
        this.vl = str;
    }
}
