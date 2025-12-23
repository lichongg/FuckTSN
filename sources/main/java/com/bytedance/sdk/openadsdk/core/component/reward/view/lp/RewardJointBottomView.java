package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.j.cw.cw;
import com.bytedance.sdk.component.widget.recycler.j.cw.r;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.rn.rn;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RewardJointBottomView extends FrameLayout implements cw {
    private View.OnClickListener ae;
    private int[] cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28450g;

    /* renamed from: j, reason: collision with root package name */
    private float f28451j;

    /* renamed from: m, reason: collision with root package name */
    private int f28452m;
    private final SlideUpLoadMoreArrow oq;

    /* renamed from: r, reason: collision with root package name */
    private SSWebView f28453r;
    private boolean tl;
    private r up;
    private int[] xt;

    private r getScrollingChildHelper() {
        if (this.up == null) {
            this.up = new r(this);
        }
        return this.up;
    }

    public SSWebView getWebView() {
        return this.f28453r;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.ae = onClickListener;
    }

    public void xt() {
        j();
    }

    public RewardJointBottomView(Context context, n nVar) {
        super(context);
        this.xt = new int[2];
        this.cw = new int[2];
        this.f28452m = 0;
        this.tl = false;
        this.f28450g = false;
        SSWebView sSWebView = new SSWebView(context);
        this.f28453r = sSWebView;
        sSWebView.setMaterialMeta(rn.j(nVar));
        this.f28453r.setWebViewClient(null);
        addView(this.f28453r, new ViewGroup.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT >= 23) {
            this.f28453r.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView.1
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i6, int i7, int i8, int i9) {
                    if (Math.abs((RewardJointBottomView.this.f28453r.getWebView().getHeight() + RewardJointBottomView.this.f28453r.getWebView().getScrollY()) - (RewardJointBottomView.this.f28453r.getWebView().getContentHeight() * RewardJointBottomView.this.f28453r.getWebView().getScale())) >= 10.0f) {
                        RewardJointBottomView.this.tl = false;
                    } else {
                        if (RewardJointBottomView.this.tl) {
                            return;
                        }
                        RewardJointBottomView.this.tl = true;
                    }
                }
            });
        }
        getScrollingChildHelper().j(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.oq = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.j();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return super.dispatchNestedFling(f6, f7, z5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return super.dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y5 = motionEvent.getY() - this.f28451j;
                    float f6 = 0.0f;
                    if (y5 < 0.0f) {
                        j();
                        if (j(0, (int) y5, this.xt, this.cw, 0)) {
                            y5 -= this.xt[1];
                        }
                        if (Math.floor(Math.abs(y5)) != 0.0d) {
                            f6 = y5;
                        }
                        this.f28452m += j((int) (f6 - this.f28452m));
                    } else {
                        int i6 = (int) (y5 - this.f28452m);
                        int j6 = j(i6);
                        this.f28452m += j6;
                        j(0, i6 - j6, this.xt, this.cw, 0);
                    }
                }
            } else if (this.f28450g && this.f28451j - motionEvent.getY() > 100.0f && (onClickListener = this.ae) != null) {
                onClickListener.onClick(this);
            }
        } else {
            this.f28452m = 0;
            this.f28451j = motionEvent.getY();
            j(2, 0);
            this.f28450g = this.tl;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void j(String str) {
        this.f28453r.loadUrl(str);
    }

    public boolean j(int i6, int i7) {
        return getScrollingChildHelper().xt(0);
    }

    public boolean j(int i6, int i7, int[] iArr, int[] iArr2, int i8) {
        return getScrollingChildHelper().j(i6, i7, iArr, iArr2, i8);
    }

    public int j(int i6) {
        if (i6 < 0) {
            return (int) (-Math.abs(Math.min(this.f28453r.getWebView().getContentHeight() - (this.f28453r.getWebView().getHeight() + this.f28453r.getWebView().getScrollY()), -i6)));
        }
        if (i6 > 0) {
            return Math.min(this.f28453r.getWebView().getScrollY(), i6);
        }
        return 0;
    }

    public void j() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.oq;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.oq.xt();
        }
    }
}
