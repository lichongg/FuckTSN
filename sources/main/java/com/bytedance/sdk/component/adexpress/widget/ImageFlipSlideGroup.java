package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.p;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ImageFlipSlideGroup extends FrameLayout {
    boolean ae;
    ImageView cw;

    /* renamed from: g, reason: collision with root package name */
    private String f25939g;

    /* renamed from: j, reason: collision with root package name */
    FrameLayout f25940j;
    private List<String> jy;

    /* renamed from: m, reason: collision with root package name */
    boolean f25941m;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    float f25942r;
    private ImageFlipSlide tl;
    ObjectAnimator up;
    private String vl;
    BookPageView xt;

    public void xt() {
        ObjectAnimator objectAnimator = this.up;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void r() {
        ImageFlipSlide imageFlipSlide = new ImageFlipSlide(getContext(), this.ae);
        this.tl = imageFlipSlide;
        addView(imageFlipSlide);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f25940j = frameLayout;
        addView(frameLayout);
        if (!this.ae) {
            BookPageView bookPageView = new BookPageView(getContext());
            this.xt = bookPageView;
            this.f25940j.addView(bookPageView);
            return;
        }
        View view = new View(getContext());
        view.setBackgroundColor(-1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(p.j(getContext(), 2.0f), -1);
        layoutParams.gravity = 17;
        this.f25940j.addView(view, layoutParams);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(kt.up(getContext(), "tt_im_fs_handle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(p.j(getContext(), 44.0f), p.j(getContext(), 44.0f));
        layoutParams2.gravity = 17;
        this.f25940j.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        this.cw = imageView2;
        imageView2.setImageResource(kt.up(getContext(), "tt_im_fs_tip"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(p.j(getContext(), 196.0f), p.j(getContext(), 300.0f));
        layoutParams3.gravity = 17;
        layoutParams3.topMargin = p.j(getContext(), 6.0f);
        this.f25940j.addView(this.cw, layoutParams3);
    }

    public void cw() {
        if (TextUtils.isEmpty(this.oq)) {
            this.tl.j(this.f25939g, this.qv, this.jy);
        } else {
            this.tl.j(this.oq, this.vl, (List<String>) null);
        }
    }

    public float getRatio() {
        return this.f25942r;
    }

    public void j(final DynamicImageFlipSlide.j jVar) {
        if (this.f25941m) {
            if (jVar != null) {
                jVar.j();
                return;
            }
            return;
        }
        this.f25941m = true;
        this.up.cancel();
        if (this.cw != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.cw.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "ratio", this.f25942r, this.ae ? 1.1f : 1.3f);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ImageFlipSlideGroup.this.f25940j.setVisibility(8);
                DynamicImageFlipSlide.j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    public void setFilterColors(List<String> list) {
        this.jy = list;
    }

    public void setRatio(float f6) {
        this.f25942r = f6;
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.2
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup imageFlipSlideGroup = ImageFlipSlideGroup.this;
                if (imageFlipSlideGroup.ae) {
                    imageFlipSlideGroup.tl.j(ImageFlipSlideGroup.this.f25942r);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ImageFlipSlideGroup.this.f25940j.getLayoutParams();
                    layoutParams.leftMargin = (int) (((1.0f - ImageFlipSlideGroup.this.f25942r) - 0.5f) * r1.getWidth() * 2);
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    ImageFlipSlideGroup.this.f25940j.setLayoutParams(layoutParams);
                    return;
                }
                Point point = new Point();
                float width = ImageFlipSlideGroup.this.getWidth();
                float width2 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup2 = ImageFlipSlideGroup.this;
                point.x = ((int) (width - (width2 * imageFlipSlideGroup2.f25942r))) - 100;
                float height = imageFlipSlideGroup2.getHeight();
                float width3 = ImageFlipSlideGroup.this.getWidth();
                ImageFlipSlideGroup imageFlipSlideGroup3 = ImageFlipSlideGroup.this;
                float f7 = imageFlipSlideGroup3.f25942r;
                point.y = ((int) (height - (width3 * f7))) - 100;
                if (f7 > 0.3f) {
                    double d6 = point.x;
                    double width4 = imageFlipSlideGroup3.getWidth() * 2;
                    ImageFlipSlideGroup imageFlipSlideGroup4 = ImageFlipSlideGroup.this;
                    point.x = (int) (d6 - (width4 * (imageFlipSlideGroup4.f25942r - 0.3d)));
                    point.y = (int) (point.y + ((imageFlipSlideGroup4.getHeight() / 2) * (ImageFlipSlideGroup.this.f25942r - 0.3d)));
                }
                ImageFlipSlideGroup.this.xt.j(point);
                ImageFlipSlideGroup imageFlipSlideGroup5 = ImageFlipSlideGroup.this;
                imageFlipSlideGroup5.xt.setAlpha(1.0f - (imageFlipSlideGroup5.f25942r - 0.3f));
                ImageFlipSlideGroup.this.tl.j(ImageFlipSlideGroup.this.xt.getFilterAreaPath());
            }
        });
    }

    public ImageFlipSlideGroup(Context context, boolean z5) {
        super(context);
        this.f25942r = 0.0f;
        this.ae = z5;
        r();
        setVisibility(4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup.1
            @Override // java.lang.Runnable
            public void run() {
                ImageFlipSlideGroup.this.setVisibility(0);
            }
        });
    }

    public void xt(String str, String str2) {
        this.oq = str;
        this.vl = str2;
    }

    public void j() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "ratio", 0.15f, 0.25f);
        this.up = ofFloat;
        ofFloat.setDuration(700L);
        this.up.setInterpolator(new LinearInterpolator());
        this.up.setRepeatCount(-1);
        this.up.setRepeatMode(2);
        this.up.start();
    }

    public void j(String str, String str2) {
        this.f25939g = str;
        this.qv = str2;
    }
}
