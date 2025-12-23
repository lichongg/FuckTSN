package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class r implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up {
    public View cw;
    com.bytedance.sdk.component.adexpress.dynamic.cw.j xt;

    /* renamed from: r, reason: collision with root package name */
    private Set<ScheduledFuture<?>> f25573r = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public List<ObjectAnimator> f25572j = j();

    public class j implements Runnable {

        /* renamed from: j, reason: collision with root package name */
        ObjectAnimator f25576j;
        ScheduledFuture<?> xt;

        j(ObjectAnimator objectAnimator) {
            this.f25576j = objectAnimator;
        }

        public void j(ScheduledFuture<?> scheduledFuture) {
            this.xt = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.j.j.j.j().cw() != null) {
                com.bytedance.sdk.component.adexpress.j.j.j.j().cw().xt().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.j.r.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.f25576j.resume();
                    }
                });
                if (this.xt != null) {
                    r.this.f25573r.remove(this.xt);
                }
            }
        }
    }

    abstract List<ObjectAnimator> j();

    public void cw() {
        List<ObjectAnimator> list = this.f25572j;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.xt.i() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.j.r.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        j jVar = r.this.new j(objectAnimator);
                        ScheduledFuture<?> j6 = com.bytedance.sdk.component.adexpress.r.up.j(jVar, (long) (r.this.xt.i() * 1000.0d), TimeUnit.MILLISECONDS);
                        jVar.j(j6);
                        r.this.f25573r.add(j6);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    ObjectAnimator j(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.xt.ws() * 1000.0d));
        if (this.xt.az() > 0) {
            objectAnimator.setRepeatCount(this.xt.az() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!PrerollVideoResponse.NORMAL.equals(this.xt.av())) {
            if ("alternate".equals(this.xt.av()) || "alternate-reverse".equals(this.xt.av())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.xt.jy())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.xt.av())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.xt.av())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.j.r.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    r.this.cw.setVisibility(0);
                    if (r.this.cw.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) r.this.cw.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.up
    public void xt() {
        List<ObjectAnimator> list = this.f25572j;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.f25573r.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public r(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        this.cw = view;
        this.xt = jVar;
    }
}
