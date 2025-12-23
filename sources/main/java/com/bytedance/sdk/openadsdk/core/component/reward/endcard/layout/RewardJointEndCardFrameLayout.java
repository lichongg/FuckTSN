package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.j.cw.m;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.tj;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.g.xt;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements m {
    private FrameLayout cw;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f28263m;

    /* renamed from: r, reason: collision with root package name */
    private View f28264r;
    private RewardJointBottomView up;

    private void cw() {
        if (n.xt(this.xt)) {
            xt.j(ln.xt(this.xt)).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv<Bitmap> qvVar) {
                    Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(RewardJointEndCardFrameLayout.this.getContext(), qvVar.cw(), 25);
                    if (j6 == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), j6);
                    ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.f28263m != null) {
                                RewardJointEndCardFrameLayout.this.f28263m.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        } else {
            xt.j(this.xt.fp().get(0)).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv<Bitmap> qvVar) {
                    Bitmap j6 = com.bytedance.sdk.component.adexpress.r.xt.j(RewardJointEndCardFrameLayout.this.getContext(), qvVar.cw(), 25);
                    if (j6 == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), j6);
                    ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.cw != null) {
                                RewardJointEndCardFrameLayout.this.cw.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    private boolean r() {
        if (this.xt.ve() == 15) {
            return true;
        }
        if (this.xt.ve() == 5) {
            return false;
        }
        if (this.xt.fp() == null || this.xt.fp().isEmpty()) {
            return true;
        }
        h hVar = this.xt.fp().get(0);
        return hVar.cw() > hVar.xt();
    }

    private void xt(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(ed.cw(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(ed.cw(getContext(), 40.0f), ed.cw(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView.setGravity(16);
        textView.setMaxWidth(ed.cw(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, ed.cw(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(truncateAt);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(ed.cw(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ed.cw(getContext(), 70.0f), ed.cw(getContext(), 24.0f));
        layoutParams2.setMarginEnd(ed.cw(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, ed.cw(getContext(), 60.0f)));
        this.f28264r = linearLayout;
        h ig = this.xt.ig();
        if (ig == null || TextUtils.isEmpty(ig.j())) {
            kt.j(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
        } else {
            xt.j(ig).j(tTRoundRectImageView);
        }
        if (this.xt.by() == null || TextUtils.isEmpty(this.xt.by().cw())) {
            textView.setText(this.xt.rs());
        } else {
            textView.setText(this.xt.by().cw());
        }
        textView2.setText(this.xt.hw());
        textView3.setText(this.xt.sf());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.up.getWebView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.f28263m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void j() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        j(linearLayout);
        xt(linearLayout);
        cw(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(com.bytedance.sdk.openadsdk.core.xt.xt xtVar) {
        ed.j(this.f28264r, (View.OnClickListener) xtVar, "bar_view");
        this.up.setClickListener(xtVar);
    }

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, n nVar) {
        super(tTBaseVideoActivity, nVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.bytedance.sdk.component.widget.recycler.j.cw.up
    public boolean onNestedPreFling(View view, float f6, float f7) {
        return super.onNestedPreFling(view, f6, f7);
    }

    private void cw(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.xt);
        this.up = rewardJointBottomView;
        if (r()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, ed.cw(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.j(tj.j(this.xt));
    }

    private void j(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.cw = frameLayout;
        if (r()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, ed.cw(getContext(), 200.0f)));
        }
        cw();
        if (!n.xt(this.xt)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            xt.j(this.xt.fp().get(0)).j(Bitmap.Config.ARGB_4444).cw(2).j(new av<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.1
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv<Bitmap> qvVar) {
                    imageView.setImageBitmap(qvVar.cw());
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.f28263m = frameLayout2;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.j.cw.m
    public boolean j(View view, View view2, int i6, int i7) {
        return r();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.j.cw.m
    public void j(View view, int i6, int i7, int[] iArr, int i8) {
        int j6 = j(i7);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.up.getLayoutParams();
        layoutParams.height -= j6;
        this.up.setLayoutParams(layoutParams);
        if (j6 != 0) {
            this.f28260j.hl().rh();
        }
        iArr[1] = iArr[1] + j6;
    }

    private int j(int i6) {
        if (i6 > 0) {
            int height = this.up.getHeight() - ed.cw(getContext(), 200.0f);
            if (height > 0) {
                if (height < Math.abs(i6)) {
                    i6 = height;
                }
            }
            i6 = 0;
        } else {
            int height2 = this.cw.getHeight() - ed.cw(getContext(), 160.0f);
            if (height2 > 0) {
                if (height2 < Math.abs(i6)) {
                    i6 = -height2;
                }
            }
            i6 = 0;
        }
        if (Math.abs(i6) > 400) {
            return 0;
        }
        return i6;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void xt() {
        super.xt();
        RewardJointBottomView rewardJointBottomView = this.up;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.xt();
        }
    }
}
