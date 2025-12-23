package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: D:\Downloads\app\classes4.dex */
public class PlayableEndcardFrameLayout extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private j f28443j;
    private int xt;

    public interface j {
        void j();
    }

    public void j(j jVar) {
        this.f28443j = jVar;
    }

    private void j() {
        j jVar = this.f28443j;
        if (jVar != null) {
            jVar.j();
        }
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y5 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(this.xt - y5) > 100) {
                j();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.xt = y5;
        return super.dispatchTouchEvent(motionEvent);
    }
}
