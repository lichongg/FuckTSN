package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class dc implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RelativeLayout f10989a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ cy f10990b;

    dc(cy cyVar, RelativeLayout relativeLayout) {
        this.f10990b = cyVar;
        this.f10989a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z5) {
        if (z5) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.f10990b.f10729i);
            hashMap.put("banner_container", this.f10989a);
            hashMap.put("entry", Integer.valueOf(this.f10990b.G));
            hashMap.put(URLPackage.KEY_CHANNEL_ID, Integer.valueOf(this.f10990b.H));
            hashMap.put("novel_id", this.f10990b.I);
            hashMap.put("isnight", Boolean.valueOf(this.f10990b.x()));
            this.f10990b.a(cy.f10981x, hashMap);
        }
    }
}
