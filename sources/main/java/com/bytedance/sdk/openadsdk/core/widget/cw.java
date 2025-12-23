package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.UgenLottieView;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.text.DecimalFormat;
import java.util.Stack;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends AlertDialog {

    /* renamed from: a, reason: collision with root package name */
    private JSONArray f31175a;
    private TextView ae;
    private TextView av;
    private TextView az;
    private String ch;
    private ImageView cw;

    /* renamed from: f, reason: collision with root package name */
    private String f31176f;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayout f31177g;
    private String gq;

    /* renamed from: h, reason: collision with root package name */
    private View f31178h;

    /* renamed from: i, reason: collision with root package name */
    private Button f31179i;

    /* renamed from: j, reason: collision with root package name */
    protected Context f31180j;
    private TextView jy;
    private String kt;

    /* renamed from: l, reason: collision with root package name */
    private float f31181l;
    private j la;

    /* renamed from: m, reason: collision with root package name */
    private TextView f31182m;
    private String mi;
    private TTRatingBar2 oq;

    /* renamed from: p, reason: collision with root package name */
    private RelativeLayout f31183p;
    private TextView qv;

    /* renamed from: r, reason: collision with root package name */
    private TTRoundRectImageView f31184r;

    /* renamed from: s, reason: collision with root package name */
    private String f31185s;
    private String tj;
    private LinearLayout tl;
    private TextView up;

    /* renamed from: v, reason: collision with root package name */
    private String f31186v;
    private TextView vl;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt f31187w;
    private TextView ws;

    /* renamed from: x, reason: collision with root package name */
    private String f31188x;
    Stack<View> xt;

    public interface j {
        void cw(Dialog dialog);

        void j(Dialog dialog);

        void m(Dialog dialog);

        void r(Dialog dialog);

        void up(Dialog dialog);

        void xt(Dialog dialog);
    }

    private void ae() {
        RelativeLayout relativeLayout;
        if (this.f31178h == null || (relativeLayout = this.f31183p) == null) {
            return;
        }
        final int childCount = relativeLayout.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            this.f31183p.getChildAt(i6).setVisibility(4);
        }
        this.f31178h.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.cw.7
            @Override // java.lang.Runnable
            public void run() {
                cw.this.cw(childCount);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(int i6) {
        try {
            Rect rect = new Rect();
            if (this.f31180j.getResources().getConfiguration().orientation == 1) {
                this.vl.getGlobalVisibleRect(rect);
            } else {
                this.f31179i.getGlobalVisibleRect(rect);
            }
            while (!this.xt.isEmpty()) {
                Rect rect2 = new Rect();
                View pop = this.xt.pop();
                if (pop != null && pop.getVisibility() != 8) {
                    pop.getGlobalVisibleRect(rect2);
                    if (rect2.top != 0 && rect.top >= rect2.bottom) {
                        break;
                    }
                    if (pop == this.up) {
                        View pop2 = this.xt.pop();
                        if (pop2 != null) {
                            pop2.setVisibility(8);
                        }
                    } else {
                        pop.setVisibility(8);
                    }
                }
            }
            if (this.xt.isEmpty()) {
                tl();
            }
        } catch (Throwable unused) {
        }
        this.f31183p.setVisibility(0);
        for (int i7 = 0; i7 < i6; i7++) {
            this.f31183p.getChildAt(i7).setVisibility(0);
        }
    }

    private View m() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f31180j);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.f31180j);
        this.cw = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int cw = ed.cw(this.f31180j, 46.0f);
        this.cw.setMaxHeight(cw);
        this.cw.setMaxWidth(cw);
        this.cw.setMinimumHeight(cw);
        this.cw.setMinimumWidth(cw);
        com.bytedance.sdk.openadsdk.res.cw cwVar = new com.bytedance.sdk.openadsdk.res.cw(ed.cw(this.f31180j, 14.0f));
        cwVar.j(ViewCompat.MEASURED_STATE_MASK);
        cwVar.j(ed.cw(this.f31180j, 2.0f));
        this.cw.setImageDrawable(cwVar);
        relativeLayout.addView(this.cw);
        TextView textView = new TextView(this.f31180j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("应用详情");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        this.f31183p.addView(relativeLayout);
        return j(relativeLayout);
    }

    private void tl() {
        RelativeLayout.LayoutParams layoutParams;
        Button button = this.f31179i;
        if (button != null) {
            ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
            if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
                layoutParams3.bottomMargin = layoutParams3.topMargin;
                this.f31179i.setLayoutParams(layoutParams3);
            } else if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams2;
                layoutParams4.bottomMargin = layoutParams4.topMargin;
                this.f31179i.setLayoutParams(layoutParams4);
            }
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt xtVar = this.f31187w;
        if (xtVar != null) {
            UgenLottieView g6 = xtVar.g();
            if (g6 != null) {
                layoutParams = (RelativeLayout.LayoutParams) g6.getLayoutParams();
            } else {
                int cw = ed.cw(this.f31180j, 60.0f);
                layoutParams = new RelativeLayout.LayoutParams(cw, cw);
            }
            layoutParams.topMargin = -ed.cw(this.f31180j, 53.0f);
            this.f31187w.j(layoutParams);
        }
    }

    private ImageView up() {
        ImageView imageView = new ImageView(this.f31180j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ed.cw(this.f31180j, 0.5f), ed.cw(this.f31180j, 9.0f));
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
        return imageView;
    }

    private LinearLayout xt(int i6, LinearLayout linearLayout, LinearLayout linearLayout2, int i7) {
        this.tl = new LinearLayout(this.f31180j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = ed.cw(this.f31180j, 10.0f);
        this.tl.setLayoutParams(layoutParams);
        this.tl.setOrientation(0);
        linearLayout2.addView(this.tl);
        this.f31177g = new LinearLayout(this.f31180j);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = ed.cw(this.f31180j, 10.0f);
        if (i6 == 0) {
            layoutParams2.topMargin = ed.cw(this.f31180j, 16.0f);
        } else {
            layoutParams2.topMargin = ed.cw(this.f31180j, 10.0f);
        }
        this.f31177g.setLayoutParams(layoutParams2);
        this.f31177g.setOrientation(0);
        this.oq = new TTRatingBar2(this.f31180j, null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.oq.setLayoutParams(layoutParams3);
        this.f31177g.addView(this.oq);
        this.qv = new TextView(this.f31180j);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.leftMargin = ed.cw(this.f31180j, 3.0f);
        this.qv.setTextSize(16.0f);
        this.qv.setTextColor(Color.parseColor("#161823"));
        this.qv.setLayoutParams(layoutParams4);
        this.f31177g.addView(this.qv);
        linearLayout2.addView(this.f31177g);
        return j(i6, linearLayout, i7);
    }

    public cw r(String str) {
        this.tj = str;
        return this;
    }

    public cw(Context context) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.xt = new Stack<>();
        this.f31180j = context;
    }

    public cw g(String str) {
        this.gq = str;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        j jVar = this.la;
        if (jVar != null) {
            jVar.cw(this);
        }
    }

    public String r() {
        return this.gq;
    }

    public void j() {
        if (this.f31180j == null) {
            this.f31180j = v.getContext();
        }
        if (this.f31180j.getResources().getConfiguration().orientation == 1) {
            this.f31178h = j(1);
        } else {
            this.f31178h = j(0);
        }
        setContentView(this.f31178h);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j();
        setCanceledOnTouchOutside(false);
        xt();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        cw();
    }

    public cw ae(String str) {
        this.f31188x = str;
        return this;
    }

    public cw up(String str) {
        this.f31176f = str;
        return this;
    }

    private View j(int i6) {
        int cw;
        LinearLayout xt = xt(i6);
        LinearLayout linearLayout = new LinearLayout(this.f31180j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i6 == 0) {
            cw = ed.cw(this.f31180j, 40.0f);
        } else {
            layoutParams.addRule(3, m().getId());
            cw = ed.cw(this.f31180j, 16.0f);
        }
        layoutParams.leftMargin = cw;
        layoutParams.rightMargin = cw;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        this.f31183p.addView(linearLayout);
        this.f31184r = new TTRoundRectImageView(this.f31180j);
        int cw2 = ed.cw(this.f31180j, 64.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cw2, cw2);
        layoutParams2.gravity = 1;
        if (i6 == 0) {
            layoutParams2.topMargin = ed.cw(this.f31180j, 40.0f);
        } else {
            layoutParams2.topMargin = ed.cw(this.f31180j, 36.0f);
        }
        this.f31184r.setMaxHeight(cw2);
        this.f31184r.setMaxWidth(cw2);
        this.f31184r.setMinimumHeight(cw2);
        this.f31184r.setMinimumWidth(cw2);
        this.f31184r.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f31184r);
        return j(i6, xt, linearLayout, cw);
    }

    public cw tl(String str) {
        this.ch = str;
        return this;
    }

    protected void cw() {
        String str;
        int i6;
        if (this.f31180j == null) {
            this.f31180j = v.getContext();
        }
        int i7 = this.f31180j.getResources().getConfiguration().orientation;
        TextView textView = this.up;
        if (textView != null) {
            textView.setText(this.mi);
        } else {
            TTRoundRectImageView tTRoundRectImageView = this.f31184r;
            if (tTRoundRectImageView != null) {
                tTRoundRectImageView.setVisibility(8);
            }
        }
        if (this.f31184r != null && !TextUtils.isEmpty(this.kt)) {
            com.bytedance.sdk.openadsdk.g.xt.j(this.kt).j(this.f31184r);
        } else {
            TTRoundRectImageView tTRoundRectImageView2 = this.f31184r;
            if (tTRoundRectImageView2 != null) {
                tTRoundRectImageView2.setVisibility(8);
            }
        }
        if (this.f31182m != null) {
            if (TextUtils.isEmpty(this.tj)) {
                this.f31182m.setVisibility(8);
            } else {
                this.f31182m.setText(this.tj);
            }
        }
        if (this.tl != null) {
            JSONArray jSONArray = this.f31175a;
            if (jSONArray != null && jSONArray.length() > 0) {
                WindowManager windowManager = (WindowManager) this.f31180j.getSystemService("window");
                Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
                if (defaultDisplay != null) {
                    int width = defaultDisplay.getWidth();
                    if (width > defaultDisplay.getHeight()) {
                        double r5 = ed.r(this.f31180j, width);
                        i6 = ((int) (r5 - (0.38d * r5))) - 80;
                    } else {
                        i6 = ed.r(this.f31180j, width) - 36;
                    }
                } else {
                    i6 = 0;
                }
                int length = this.f31175a.length() <= 3 ? this.f31175a.length() : 3;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    }
                    String optString = this.f31175a.optString(i8);
                    if (!TextUtils.isEmpty(optString)) {
                        TextView textView2 = new TextView(this.f31180j);
                        textView2.setText(optString);
                        textView2.setTextSize(12.0f);
                        textView2.setTextColor(Color.parseColor("#161823"));
                        textView2.setAlpha(0.75f);
                        textView2.setBackgroundColor(Color.parseColor("#0F161823"));
                        int cw = ed.cw(this.f31180j, 6.0f);
                        textView2.setPadding(cw, 0, cw, 0);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        int cw2 = ed.cw(this.f31180j, 3.0f);
                        layoutParams.leftMargin = cw2;
                        layoutParams.rightMargin = cw2;
                        textView2.setLayoutParams(layoutParams);
                        textView2.getPaint().getTextBounds(optString, 0, optString.length(), new Rect());
                        i6 -= ed.r(this.f31180j, r10.width()) + 20;
                        if (i6 >= 0) {
                            this.tl.addView(textView2);
                        } else if (this.tl.getChildCount() <= 0) {
                            this.tl.setVisibility(8);
                        }
                    }
                    i8++;
                }
            } else {
                this.tl.setVisibility(8);
            }
        }
        if (this.oq != null && this.qv != null) {
            float f6 = this.f31181l;
            if (f6 <= 0.0f) {
                LinearLayout linearLayout = this.f31177g;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                this.oq.setVisibility(8);
                this.qv.setVisibility(8);
            } else {
                if (f6 > 5.0f) {
                    f6 = 5.0f;
                }
                this.f31181l = f6;
                this.qv.setText(new DecimalFormat(".0").format(this.f31181l));
                this.oq.setRating(this.f31181l);
                this.oq.j(ed.cw(this.f31180j, 16.0f), ed.cw(this.f31180j, 15.0f));
                this.oq.j(ed.cw(this.f31180j, 3.0f), 0, ed.cw(this.f31180j, 3.0f), 0);
                this.oq.j();
            }
        }
        if (this.vl != null) {
            str = TextUtils.isEmpty(this.f31176f) ? String.format("版本号：%1$s", "暂无") : String.format("版本号：%1$s", this.f31176f);
            if (i7 == 2) {
                TextPaint paint = this.vl.getPaint();
                Rect rect = new Rect();
                paint.getTextBounds(str, 0, str.length(), rect);
                double oq = ed.oq(this.f31180j);
                int width2 = (((int) (oq - (0.4d * oq))) - rect.width()) - ed.cw(this.f31180j, 106.0f);
                TextView textView3 = this.ws;
                if (textView3 != null) {
                    TextPaint paint2 = textView3.getPaint();
                    String charSequence = this.ws.getText().toString();
                    paint2.getTextBounds(charSequence, 0, charSequence.length(), rect);
                    width2 -= rect.width();
                }
                TextView textView4 = this.ae;
                if (textView4 != null) {
                    TextPaint paint3 = textView4.getPaint();
                    String charSequence2 = this.ae.getText().toString();
                    paint3.getTextBounds(charSequence2, 0, charSequence2.length(), rect);
                    width2 -= rect.width();
                }
                TextView textView5 = this.av;
                if (textView5 != null) {
                    TextPaint paint4 = textView5.getPaint();
                    String charSequence3 = this.av.getText().toString();
                    paint4.getTextBounds(charSequence3, 0, charSequence3.length(), rect);
                    width2 -= rect.width();
                }
                if (this.az != null && !TextUtils.isEmpty(this.f31188x)) {
                    TextPaint paint5 = this.az.getPaint();
                    String charSequence4 = this.az.getText().toString();
                    paint5.getTextBounds(charSequence4, 0, TextUtils.isEmpty(charSequence4) ? 0 : charSequence4.length(), rect);
                    width2 -= rect.width();
                }
                if (width2 <= 0) {
                    ((LinearLayout.LayoutParams) this.vl.getLayoutParams()).weight = 1.0f;
                }
            }
            if (i7 == 1) {
                this.vl.setText(str);
            }
        } else {
            str = "";
        }
        TextView textView6 = this.jy;
        if (textView6 != null) {
            textView6.setSelected(true);
            String format = TextUtils.isEmpty(this.ch) ? String.format("开发者：%1$s", "补充中，可于应用官网查看") : String.format("开发者：%1$s", this.ch);
            if (i7 == 2) {
                format = format + "  " + str;
            }
            this.jy.setText(format);
        }
    }

    public cw m(String str) {
        this.f31186v = str;
        return this;
    }

    private LinearLayout xt(int i6, LinearLayout linearLayout, int i7, LinearLayout linearLayout2, View view) {
        if (i6 == 0) {
            j(i6, (ViewGroup) linearLayout2);
            if (!TextUtils.isEmpty(this.f31186v)) {
                View imageView = new ImageView(this.f31180j);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ed.cw(this.f31180j, 0.5f), ed.cw(this.f31180j, 9.0f));
                layoutParams.leftMargin = ed.cw(this.f31180j, 8.0f);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setBackgroundColor(Color.parseColor("#D8D8D8"));
                linearLayout2.addView(imageView);
            }
        }
        int cw = ed.cw(this.f31180j, 8.0f);
        j(linearLayout2, cw);
        xt(linearLayout2, cw);
        return j(i6, linearLayout, i7, linearLayout2, view, cw);
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, LinearLayout linearLayout2, int i7) {
        this.up = new TextView(this.f31180j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        if (i6 == 0) {
            layoutParams.topMargin = ed.cw(this.f31180j, 16.0f);
            int cw = ed.cw(this.f31180j, 25.0f);
            layoutParams.leftMargin = cw;
            layoutParams.rightMargin = cw;
        } else {
            layoutParams.topMargin = ed.cw(this.f31180j, 14.0f);
        }
        this.up.setLayoutParams(layoutParams);
        TextView textView = this.up;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        this.up.setTextColor(Color.parseColor("#161823"));
        this.up.setTextSize(18.0f);
        this.up.setGravity(17);
        this.up.setTypeface(null, 1);
        linearLayout2.addView(this.up);
        this.f31182m = new TextView(this.f31180j);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = ed.cw(this.f31180j, 5.0f);
        this.f31182m.setLayoutParams(layoutParams2);
        this.f31182m.setEllipsize(truncateAt);
        this.f31182m.setSingleLine(true);
        this.f31182m.setAlpha(0.5f);
        this.f31182m.setTextColor(Color.parseColor("#161823"));
        this.f31182m.setTextSize(14.0f);
        this.f31182m.setGravity(17);
        linearLayout2.addView(this.f31182m);
        return xt(i6, linearLayout, linearLayout2, i7);
    }

    private void xt(LinearLayout linearLayout, int i6) {
        linearLayout.addView(up());
        this.ae = new TextView(this.f31180j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i6;
        layoutParams.rightMargin = i6;
        this.ae.setLayoutParams(layoutParams);
        this.ae.setAlpha(0.75f);
        this.ae.setTextColor(Color.parseColor("#66161823"));
        if (this.f31180j.getResources().getConfiguration().orientation == 2) {
            this.ae.setTextSize(10.0f);
        } else {
            this.ae.setTextSize(12.0f);
        }
        this.ae.setText("权限");
        linearLayout.addView(this.ae);
    }

    private LinearLayout xt(int i6) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f31180j);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i6);
        linearLayout.setBackgroundColor(Color.parseColor("#99000000"));
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f31180j);
        if (i6 == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        this.f31183p = new RelativeLayout(this.f31180j);
        if (i6 == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ed.cw(this.f31180j, 8.0f));
        this.f31183p.setBackground(gradientDrawable);
        this.f31183p.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f31183p);
        return j(i6, linearLayout);
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, int i7) {
        Button button = new Button(this.f31180j);
        this.f31179i = button;
        button.setId(View.generateViewId());
        LinearLayout linearLayout2 = new LinearLayout(this.f31180j);
        linearLayout2.setId(View.generateViewId());
        View view = new View(this.f31180j);
        view.setId(View.generateViewId());
        TextView textView = new TextView(this.f31180j);
        this.jy = textView;
        textView.setId(View.generateViewId());
        if (i6 == 1) {
            j(i6, this.f31183p);
        } else {
            j(ed.cw(this.f31180j, 89.0f), i6);
        }
        return j(i6, linearLayout, i7, linearLayout2, view);
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, int i7, LinearLayout linearLayout2, View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, linearLayout2.getId());
        if (i6 == 1) {
            layoutParams.leftMargin = i7;
            layoutParams.rightMargin = i7;
        } else {
            int cw = ed.cw(this.f31180j, 16.0f);
            layoutParams.leftMargin = cw;
            layoutParams.rightMargin = cw;
        }
        layoutParams.topMargin = ed.cw(this.f31180j, 3.0f);
        this.jy.setEllipsize(TextUtils.TruncateAt.END);
        this.jy.setGravity(17);
        this.jy.setTextColor(Color.parseColor("#4D161823"));
        if (i6 == 0) {
            this.jy.setTextSize(10.0f);
        } else {
            this.jy.setTextSize(12.0f);
        }
        this.jy.setLayoutParams(layoutParams);
        this.f31183p.addView(this.jy);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i7;
        layoutParams2.rightMargin = i7;
        if (i6 == 1) {
            layoutParams2.topMargin = ed.cw(this.f31180j, 9.0f);
        } else {
            layoutParams2.topMargin = ed.cw(this.f31180j, 2.0f);
            layoutParams2.bottomMargin = ed.cw(this.f31180j, 20.0f);
        }
        if (i6 == 1) {
            layoutParams2.addRule(2, view.getId());
        } else {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        }
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setGravity(1);
        return xt(i6, linearLayout, i7, linearLayout2, view);
    }

    protected void xt() {
        if (this.f31180j == null) {
            this.f31180j = v.getContext();
        }
        this.xt.clear();
        this.xt.push(this.f31184r);
        this.xt.push(this.up);
        this.xt.push(this.f31182m);
        this.xt.push(this.tl);
        this.xt.push(this.f31177g);
        ae();
        this.av.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.cw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (cw.this.la == null) {
                    return;
                }
                cw.this.la.up(cw.this);
            }
        });
        if (this.az != null && !TextUtils.isEmpty(this.f31188x)) {
            this.az.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.cw.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (cw.this.la != null) {
                        cw.this.la.m(cw.this);
                    }
                }
            });
        }
        this.ae.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.cw.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (cw.this.la != null) {
                    cw.this.la.xt(cw.this);
                }
            }
        });
        this.cw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.cw.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (cw.this.la != null) {
                    cw.this.la.cw(cw.this);
                }
            }
        });
        this.ws.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.cw.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (cw.this.la != null) {
                    cw.this.la.r(cw.this);
                }
            }
        });
        this.f31179i.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.cw.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (cw.this.la != null) {
                    cw.this.la.j(cw.this);
                }
            }
        });
    }

    public cw xt(String str) {
        this.kt = str;
        return this;
    }

    private void j(LinearLayout linearLayout, int i6) {
        this.av = new TextView(this.f31180j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i6;
        layoutParams.rightMargin = i6;
        this.av.setLayoutParams(layoutParams);
        this.av.setAlpha(0.75f);
        this.av.setTextColor(Color.parseColor("#66161823"));
        if (this.f31180j.getResources().getConfiguration().orientation == 2) {
            this.av.setTextSize(10.0f);
        } else {
            this.av.setTextSize(12.0f);
        }
        this.av.setText("功能");
        linearLayout.addView(this.av);
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, int i7, LinearLayout linearLayout2, View view, int i8) {
        linearLayout2.addView(up());
        this.ws = new TextView(this.f31180j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i8;
        layoutParams.rightMargin = i8;
        this.ws.setLayoutParams(layoutParams);
        this.ws.setAlpha(0.75f);
        this.ws.setTextColor(Color.parseColor("#66161823"));
        if (this.f31180j.getResources().getConfiguration().orientation == 2) {
            this.ws.setTextSize(10.0f);
        } else {
            this.ws.setTextSize(12.0f);
        }
        this.ws.setText("隐私");
        linearLayout2.addView(this.ws);
        if (!TextUtils.isEmpty(this.f31188x)) {
            linearLayout2.addView(up());
            this.az = new TextView(this.f31180j);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = i8;
            layoutParams2.rightMargin = i8;
            this.az.setLayoutParams(layoutParams2);
            this.az.setAlpha(0.75f);
            this.az.setTextColor(Color.parseColor("#66161823"));
            if (this.f31180j.getResources().getConfiguration().orientation == 2) {
                this.az.setTextSize(10.0f);
            } else {
                this.az.setTextSize(12.0f);
            }
            this.az.setText("备案");
            linearLayout2.addView(this.az);
        }
        this.f31183p.addView(linearLayout2);
        if (i6 == 0) {
            return linearLayout;
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, ed.cw(this.f31180j, 1.0f));
        layoutParams3.topMargin = ed.cw(this.f31180j, 12.0f);
        layoutParams3.addRule(2, this.f31179i.getId());
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        this.f31183p.addView(view);
        j(i7, i6);
        return linearLayout;
    }

    public cw cw(String str) {
        this.f31185s = str;
        return this;
    }

    private LinearLayout j(int i6, LinearLayout linearLayout) {
        if (i6 == 0) {
            this.cw = new ImageView(this.f31180j);
            int cw = ed.cw(this.f31180j, 28.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(cw, cw);
            int cw2 = ed.cw(this.f31180j, 36.0f);
            layoutParams.topMargin = cw2;
            layoutParams.rightMargin = cw2;
            layoutParams.leftMargin = cw2;
            layoutParams.bottomMargin = cw2;
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.addRule(11);
            this.cw.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.cw.setLayoutParams(layoutParams);
            this.cw.setMaxHeight(cw);
            this.cw.setMaxWidth(cw);
            this.cw.setMinimumHeight(cw);
            this.cw.setMinimumWidth(cw);
            com.bytedance.sdk.openadsdk.res.xt xtVar = new com.bytedance.sdk.openadsdk.res.xt(ed.cw(this.f31180j, 28.0f));
            xtVar.j(Color.parseColor("#66161823"));
            float cw3 = ed.cw(this.f31180j, 2.0f);
            xtVar.j(cw3);
            com.bytedance.sdk.openadsdk.res.cw cwVar = new com.bytedance.sdk.openadsdk.res.cw(ed.cw(this.f31180j, 12.0f));
            cwVar.j(-1);
            cwVar.j(cw3);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{xtVar, cwVar});
            layerDrawable.setLayerInset(0, 0, 0, 0, 0);
            int cw4 = ed.cw(this.f31180j, 8.0f);
            layerDrawable.setLayerInset(1, cw4, cw4, cw4, cw4);
            this.cw.setImageDrawable(layerDrawable);
            this.f31183p.addView(this.cw);
        }
        return linearLayout;
    }

    private void j(int i6, ViewGroup viewGroup) {
        this.vl = new TextView(this.f31180j);
        if (i6 == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.jy.getId());
            int cw = ed.cw(this.f31180j, 16.0f);
            layoutParams.leftMargin = cw;
            layoutParams.rightMargin = cw;
            layoutParams.topMargin = ed.cw(this.f31180j, 30.0f);
            this.vl.setLayoutParams(layoutParams);
            this.vl.setGravity(17);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = GravityCompat.START;
            this.vl.setLayoutParams(layoutParams2);
        }
        this.vl.setEllipsize(TextUtils.TruncateAt.END);
        this.vl.setTextColor(Color.parseColor("#57161823"));
        if (i6 == 0) {
            this.vl.setTextSize(10.0f);
        } else {
            this.vl.setTextSize(12.0f);
        }
        viewGroup.addView(this.vl);
    }

    private void j(int i6, int i7) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i6;
        layoutParams.rightMargin = i6;
        if (i7 == 1) {
            layoutParams.topMargin = ed.cw(this.f31180j, 14.0f);
            layoutParams.bottomMargin = ed.cw(this.f31180j, 46.0f);
            layoutParams.addRule(12);
        } else {
            layoutParams.topMargin = ed.cw(this.f31180j, 10.0f);
            layoutParams.bottomMargin = ed.cw(this.f31180j, 24.0f);
            layoutParams.addRule(2, this.jy.getId());
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(ed.cw(this.f31180j, 3.0f));
        this.f31179i.setBackground(gradientDrawable);
        this.f31179i.setGravity(17);
        this.f31179i.setText("立即下载");
        int cw = ed.cw(this.f31180j, 13.0f);
        this.f31179i.setPadding(0, cw, 0, cw);
        this.f31179i.setTextColor(-1);
        this.f31179i.setLayoutParams(layoutParams);
        this.f31179i.setTextSize(15.0f);
        this.f31183p.addView(this.f31179i);
        if (i7 != 1 || TextUtils.isEmpty(this.f31185s)) {
            return;
        }
        int cw2 = ed.cw(this.f31180j, 60.0f);
        com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt xtVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xt(this.f31180j);
        this.f31187w = xtVar;
        xtVar.j("src", this.f31185s);
        this.f31187w.j("loop", "true");
        this.f31187w.j("autoPlay", "true");
        this.f31187w.j("width", String.valueOf(cw2));
        this.f31187w.j("height", String.valueOf(cw2));
        this.f31187w.j("scaleType", "fitXY");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cw2, cw2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(3, this.f31179i.getId());
        layoutParams2.rightMargin = ed.cw(this.f31180j, 73.0f);
        layoutParams2.topMargin = -ed.cw(this.f31180j, 85.0f);
        this.f31187w.j(layoutParams2);
        UgenLottieView g6 = this.f31187w.g();
        if (g6 == null) {
            return;
        }
        this.f31187w.xt();
        this.f31183p.addView(g6);
    }

    private View j(RelativeLayout relativeLayout) {
        View view = new View(this.f31180j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ed.cw(this.f31180j, 1.0f));
        layoutParams.addRule(3, relativeLayout.getId());
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        view.setId(View.generateViewId());
        this.f31183p.addView(view);
        return view;
    }

    public cw j(String str) {
        this.mi = str;
        return this;
    }

    public cw j(JSONArray jSONArray) {
        this.f31175a = jSONArray;
        return this;
    }

    public cw j(float f6) {
        this.f31181l = f6;
        return this;
    }

    public cw j(j jVar) {
        this.la = jVar;
        return this;
    }
}
