package com.kwad.components.core.m;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.m.a.a> Rt = new ArrayList();

    @NonNull
    private final b<?> Ru;

    @NonNull
    public final Context mContext;

    @NonNull
    public final View mRootView;

    @Deprecated
    public final Activity getActivity() {
        return this.Ru.getActivity();
    }

    public final void iz() {
        this.Ru.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Rt.clear();
    }

    public a(b<?> bVar) {
        this.Ru = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }
}
