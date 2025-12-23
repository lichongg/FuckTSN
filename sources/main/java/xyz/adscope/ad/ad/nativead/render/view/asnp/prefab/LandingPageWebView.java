package xyz.adscope.ad.ad.nativead.render.view.asnp.prefab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.adscope.ad.n4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LandingPageWebView extends BasicWebView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f54812a;

    public LandingPageWebView(@NonNull Context context) {
        super(context);
        this.f54812a = false;
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.BasicWebView
    protected boolean a(String str) {
        if (str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            return false;
        }
        if (!this.f54812a) {
            return true;
        }
        n4.a(getContext(), str);
        return true;
    }

    public void setAllowDeeplinkDirect(boolean z5) {
        this.f54812a = z5;
    }

    public LandingPageWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f54812a = false;
    }

    public LandingPageWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f54812a = false;
    }

    public LandingPageWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f54812a = false;
    }
}
