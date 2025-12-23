package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.m;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RewardLandingPageAppInfoView extends LinearLayout {

    /* renamed from: j, reason: collision with root package name */
    private DownloadItemView f28455j;

    public void j(n nVar, String str) {
        if (nVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        j(nVar);
        m et = nVar.et();
        if (et == null) {
            return;
        }
        int cw = ed.cw(context, 12.0f);
        View j6 = j(context, et);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = cw;
        addView(j6, layoutParams);
        View j7 = j(context, nVar, et, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = cw;
        addView(j7, layoutParams2);
        int cw2 = ed.cw(context, 16.0f);
        setPadding(cw2, cw, cw2, cw);
    }

    private View cw(Context context, RelativeLayout relativeLayout, int i6) {
        TextView textView = new TextView(context);
        textView.setText("功能");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i6);
        layoutParams.rightMargin = ed.cw(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int cw = ed.cw(context, 6.0f);
        ed.j(textView, cw, cw, 0, 0);
        return textView;
    }

    private View r(Context context, RelativeLayout relativeLayout, int i6) {
        TextView textView = new TextView(context);
        textView.setText("权限");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        textView.setId(View.generateViewId());
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i6);
        layoutParams.rightMargin = ed.cw(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int cw = ed.cw(context, 6.0f);
        ed.j(textView, cw, cw, 0, 0);
        return textView;
    }

    private View xt(Context context, RelativeLayout relativeLayout, int i6) {
        TextView textView = new TextView(context);
        textView.setText("隐私");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i6 == -1) {
            layoutParams.addRule(11, -1);
        } else {
            layoutParams.addRule(0, i6);
            layoutParams.rightMargin = ed.cw(context, 6.0f);
        }
        relativeLayout.addView(textView, layoutParams);
        int cw = ed.cw(context, 6.0f);
        ed.j(textView, cw, cw, 0, 0);
        return textView;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.f28455j;
        if (downloadItemView == null || onClickListener == null) {
            return;
        }
        downloadItemView.setOnClickListener(onClickListener);
    }

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private void j(n nVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.f28455j = downloadItemView;
        downloadItemView.j(nVar);
        addView(this.f28455j);
    }

    private View j(Context context, m mVar) {
        TextView textView = new TextView(context);
        textView.setText(mVar.ae());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    private View j(final Context context, final n nVar, m mVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText(String.format("版本号：%s", mVar.up()));
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i6 = -1;
        layoutParams.addRule(9, -1);
        textView.setId(View.generateViewId());
        relativeLayout.addView(textView, layoutParams);
        if (!TextUtils.isEmpty(mVar.qv())) {
            View j6 = j(context, relativeLayout);
            i6 = j(context, relativeLayout, j6.getId()).getId();
            j6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.core.rn.m.j(nVar, context, str);
                }
            });
        }
        View xt = xt(context, relativeLayout, i6);
        xt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.rn.m.xt(nVar, context, str);
            }
        });
        View r5 = r(context, relativeLayout, j(context, relativeLayout, xt.getId()).getId());
        r5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.rn.m.cw(nVar, context, str);
            }
        });
        cw(context, relativeLayout, j(context, relativeLayout, r5.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLandingPageAppInfoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.bytedance.sdk.openadsdk.core.rn.m.j(context, nVar, str);
            }
        });
        return relativeLayout;
    }

    private View j(Context context, RelativeLayout relativeLayout, int i6) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ed.cw(context, 1.5f), ed.cw(context, 8.0f));
        layoutParams.rightMargin = ed.cw(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i6);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View j(Context context, RelativeLayout relativeLayout) {
        TextView textView = new TextView(context);
        textView.setText("备案");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(textView, layoutParams);
        int cw = ed.cw(context, 6.0f);
        ed.j(textView, cw, cw, 0, 0);
        return textView;
    }
}
