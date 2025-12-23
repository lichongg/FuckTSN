package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bykv.vk.openvk.component.video.api.r.xt;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.m;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.up;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.EnumSet;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends r {
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.r
    protected m j(Context context, EnumSet<xt.j> enumSet) {
        View j6 = this.vl ? j(context) : new LayoutVideoDetail(context);
        if (j6 == null) {
            return null;
        }
        return this.vl ? new m(context, j6, true, enumSet, this.f30967m, this, gx(), null) : new up(context, j6, true, enumSet, this.f30967m, this, false);
    }

    public j(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6, boolean z7) {
        super(context, viewGroup, nVar, str, z5, z6, z7);
    }

    private View j(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387720);
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387906);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387637);
        layoutParams2.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams2);
        tTProgressBar.setIndeterminateDrawable(kt.cw(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        return relativeLayout;
    }
}
