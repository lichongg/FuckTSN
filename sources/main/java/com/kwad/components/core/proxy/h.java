package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.service.ServiceProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h extends KsFragment implements com.kwad.sdk.m.a.b {
    protected ViewGroup Wh;
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();
    protected Context mContext;
    protected ViewGroup nY;

    protected ViewGroup nj() {
        return null;
    }

    protected int qN() {
        return 0;
    }

    public final <T extends View> T findViewById(int i6) {
        ViewGroup viewGroup = this.nY;
        if (viewGroup != null) {
            return (T) viewGroup.findViewById(i6);
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.Wh = viewGroup;
        if (this.nY == null) {
            ViewGroup nj = nj();
            this.nY = nj;
            if (nj == null && qN() != 0) {
                this.nY = (ViewGroup) from.inflate(qN(), viewGroup, false);
            }
        }
        return this.nY;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(getActivity());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.t.g.destroyFragment(this.mContext, getView());
        }
    }
}
