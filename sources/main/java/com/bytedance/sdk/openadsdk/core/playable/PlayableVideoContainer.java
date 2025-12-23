package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class PlayableVideoContainer extends FrameLayout {
    private long ae;
    private float cw;

    /* renamed from: j, reason: collision with root package name */
    private final Paint f29846j;

    /* renamed from: m, reason: collision with root package name */
    private View f29847m;

    /* renamed from: r, reason: collision with root package name */
    private FrameLayout f29848r;
    private View.OnClickListener tl;
    private View up;
    private float xt;

    private void xt() {
        int cw = ed.cw(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(cw, cw, cw, cw);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.f29848r = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.up = cw();
        frameLayout.addView(this.up, new ViewGroup.MarginLayoutParams(-1, -1));
        this.f29847m = r();
        frameLayout.addView(this.f29847m, new ViewGroup.MarginLayoutParams(-1, -1));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ed.cw(v.getContext(), 12.0f));
            }
        });
        setClipToOutline(true);
    }

    public void j() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = ed.cw(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = ed.cw(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    private View r() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387599);
        textView.setText("视频异常\n无法播放");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private void up() {
        View.OnClickListener onClickListener = this.tl;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public FrameLayout getVideoContainer() {
        return this.f29848r;
    }

    public void j(boolean z5) {
        if (!z5) {
            ed.j(this.f29847m, 8);
        } else {
            ed.j(this.f29847m, 0);
            ed.j(this.up, 8);
        }
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.tl = onClickListener;
    }

    public PlayableVideoContainer(Context context) {
        super(context);
        this.f29846j = new Paint();
        this.ae = 0L;
        xt();
    }

    private View cw() {
        int cw = ed.cw(getContext(), 8.0f);
        int cw2 = ed.cw(getContext(), 7.0f);
        int cw3 = ed.cw(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387599);
        textView.setText("可以\n拖动");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        kt.j(getContext(), "tt_arrow_up", imageView);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cw2, cw3);
        layoutParams2.setMargins(cw, cw, cw, cw);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        kt.j(getContext(), "tt_arrow_down", imageView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(cw2, cw3);
        layoutParams3.setMargins(cw, cw, cw, cw);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        kt.j(getContext(), "tt_arrow_left", imageView3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(cw3, cw2);
        layoutParams4.setMargins(cw, cw, cw, cw);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        kt.j(getContext(), "tt_arrow_right", imageView4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(cw3, cw2);
        layoutParams5.setMargins(cw, cw, cw, cw);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private void m() {
        int height;
        final int i6;
        final int i7;
        int width;
        int r5 = ed.r(getContext());
        int up = ed.up(getContext());
        final int left = getLeft();
        final int top2 = getTop();
        int left2 = getLeft();
        int right = r5 - getRight();
        int top3 = getTop();
        int bottom = up - getBottom();
        int cw = ed.cw(getContext(), 20.0f);
        int min = Math.min(Math.min(left2, right), Math.min(top3, bottom));
        if (left2 == min) {
            getWidth();
            int top4 = getTop();
            int bottom2 = getBottom();
            if (top4 < 0) {
                bottom2 = cw + getHeight();
                top4 = cw;
            }
            if (bottom2 > up) {
                height = (up - cw) - getHeight();
            } else {
                i6 = top4;
                i7 = cw;
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        int i8 = (int) (left + ((i7 - r0) * animatedFraction));
                        int i9 = (int) (top2 + ((i6 - r1) * animatedFraction));
                        PlayableVideoContainer.this.j(i8, i9, PlayableVideoContainer.this.getWidth() + i8, PlayableVideoContainer.this.getHeight() + i9);
                    }
                });
                duration.start();
            }
        } else {
            if (right == min) {
                width = (r5 - cw) - getWidth();
                int top5 = getTop();
                int bottom3 = getBottom();
                if (top5 < 0) {
                    bottom3 = cw + getHeight();
                    top5 = cw;
                }
                if (bottom3 > up) {
                    cw = (up - cw) - getHeight();
                    i7 = width;
                } else {
                    i7 = width;
                    i6 = top5;
                    ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
                    duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            int i8 = (int) (left + ((i7 - r0) * animatedFraction));
                            int i9 = (int) (top2 + ((i6 - r1) * animatedFraction));
                            PlayableVideoContainer.this.j(i8, i9, PlayableVideoContainer.this.getWidth() + i8, PlayableVideoContainer.this.getHeight() + i9);
                        }
                    });
                    duration2.start();
                }
            } else if (top3 == min) {
                int left3 = getLeft();
                int right2 = getRight();
                getHeight();
                if (left3 < 0) {
                    right2 = cw + getWidth();
                    left3 = cw;
                }
                if (right2 > r5) {
                    width = (r5 - cw) - getWidth();
                    i7 = width;
                } else {
                    i7 = left3;
                }
            } else {
                int left4 = getLeft();
                int right3 = getRight();
                height = (up - cw) - getHeight();
                if (left4 < 0) {
                    right3 = cw + getWidth();
                    left4 = cw;
                }
                if (right3 > r5) {
                    cw = (r5 - cw) - getWidth();
                } else {
                    i6 = height;
                    i7 = left4;
                    ValueAnimator duration22 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
                    duration22.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            int i8 = (int) (left + ((i7 - r0) * animatedFraction));
                            int i9 = (int) (top2 + ((i6 - r1) * animatedFraction));
                            PlayableVideoContainer.this.j(i8, i9, PlayableVideoContainer.this.getWidth() + i8, PlayableVideoContainer.this.getHeight() + i9);
                        }
                    });
                    duration22.start();
                }
            }
            i6 = cw;
            ValueAnimator duration222 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
            duration222.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    int i8 = (int) (left + ((i7 - r0) * animatedFraction));
                    int i9 = (int) (top2 + ((i6 - r1) * animatedFraction));
                    PlayableVideoContainer.this.j(i8, i9, PlayableVideoContainer.this.getWidth() + i8, PlayableVideoContainer.this.getHeight() + i9);
                }
            });
            duration222.start();
        }
        i6 = height;
        i7 = cw;
        ValueAnimator duration2222 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration2222.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i8 = (int) (left + ((i7 - r0) * animatedFraction));
                int i9 = (int) (top2 + ((i6 - r1) * animatedFraction));
                PlayableVideoContainer.this.j(i8, i9, PlayableVideoContainer.this.getWidth() + i8, PlayableVideoContainer.this.getHeight() + i9);
            }
        });
        duration2222.start();
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j6) {
        boolean drawChild = super.drawChild(canvas, view, j6);
        this.f29846j.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744")}, (float[]) null, Shader.TileMode.CLAMP));
        this.f29846j.setColor(SupportMenu.CATEGORY_MASK);
        this.f29846j.setStyle(Paint.Style.STROKE);
        this.f29846j.setAntiAlias(true);
        this.f29846j.setStrokeWidth(ed.cw(getContext(), 4.0f));
        canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), ed.cw(getContext(), 12.0f), ed.cw(getContext(), 12.0f), this.f29846j);
        return drawChild;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r0 != 3) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            super.onTouchEvent(r7)
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == 0) goto L80
            if (r0 == r1) goto L47
            r2 = 2
            if (r0 == r2) goto L14
            r7 = 3
            if (r0 == r7) goto L78
            goto L92
        L14:
            float r0 = r7.getX()
            float r2 = r6.xt
            float r0 = r0 - r2
            float r7 = r7.getY()
            float r2 = r6.cw
            float r7 = r7 - r2
            r2 = 0
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 == 0) goto L92
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L92
            int r2 = r6.getLeft()
            float r2 = (float) r2
            float r2 = r2 + r0
            int r0 = (int) r2
            int r2 = r6.getWidth()
            int r2 = r2 + r0
            int r3 = r6.getTop()
            float r3 = (float) r3
            float r3 = r3 + r7
            int r7 = (int) r3
            int r3 = r6.getHeight()
            int r3 = r3 + r7
            r6.j(r0, r7, r2, r3)
            goto L92
        L47:
            float r0 = r7.getX()
            float r2 = r6.xt
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r7 = r7.getY()
            float r2 = r6.cw
            float r7 = r7 - r2
            float r7 = java.lang.Math.abs(r7)
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.ae
            long r2 = r2 - r4
            r4 = 1092616192(0x41200000, float:10.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L78
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L78
            r4 = 200(0xc8, double:9.9E-322)
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L78
            r6.up()
            return r1
        L78:
            r6.m()
            r7 = 0
            r6.setPressed(r7)
            goto L92
        L80:
            float r0 = r7.getX()
            r6.xt = r0
            float r7 = r7.getY()
            r6.cw = r7
            long r2 = android.os.SystemClock.elapsedRealtime()
            r6.ae = r2
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void j(int i6, int i7, int i8, int i9) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i6;
        layoutParams.topMargin = i7;
        layoutParams.gravity = 0;
        layout(i6, i7, i8, i9);
    }

    public void xt(boolean z5) {
        if (z5) {
            ed.j(this.up, 0);
            ed.j(this.f29847m, 8);
        } else {
            ed.j(this.up, 8);
        }
    }
}
