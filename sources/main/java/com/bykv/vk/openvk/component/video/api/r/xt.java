package com.bykv.vk.openvk.component.video.api.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes3.dex */
public interface xt<T> extends com.bykv.vk.openvk.component.video.api.xt.j {

    public enum j {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    View cw();

    void j();

    void j(int i6);

    void j(Drawable drawable);

    void j(T t5, WeakReference<Context> weakReference, boolean z5);

    void j(boolean z5);

    void xt();
}
