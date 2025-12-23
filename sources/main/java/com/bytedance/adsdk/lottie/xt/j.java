package com.bytedance.adsdk.lottie.xt;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.lottie.cw;
import com.bytedance.adsdk.lottie.model.ae;
import com.bytedance.adsdk.lottie.up.up;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: r, reason: collision with root package name */
    private final AssetManager f23575r;
    private cw up;

    /* renamed from: j, reason: collision with root package name */
    private final ae<String> f23573j = new ae<>();
    private final Map<ae<String>, Typeface> xt = new HashMap();
    private final Map<String, Typeface> cw = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private String f23574m = ".ttf";

    public void j(cw cwVar) {
        this.up = cwVar;
    }

    public void j(String str) {
        this.f23574m = str;
    }

    public j(Drawable.Callback callback, cw cwVar) {
        this.up = cwVar;
        if (!(callback instanceof View)) {
            up.xt("LottieDrawable must be inside of a view for images to work.");
            this.f23575r = null;
        } else {
            this.f23575r = ((View) callback).getContext().getAssets();
        }
    }

    private Typeface xt(com.bytedance.adsdk.lottie.model.cw cwVar) {
        Typeface typeface;
        String j6 = cwVar.j();
        Typeface typeface2 = this.cw.get(j6);
        if (typeface2 != null) {
            return typeface2;
        }
        String cw = cwVar.cw();
        String xt = cwVar.xt();
        cw cwVar2 = this.up;
        if (cwVar2 != null) {
            typeface = cwVar2.j(j6, cw, xt);
            if (typeface == null) {
                typeface = this.up.j(j6);
            }
        } else {
            typeface = null;
        }
        cw cwVar3 = this.up;
        if (cwVar3 != null && typeface == null) {
            String xt2 = cwVar3.xt(j6, cw, xt);
            if (xt2 == null) {
                xt2 = this.up.xt(j6);
            }
            if (xt2 != null) {
                try {
                    typeface = Typeface.createFromAsset(this.f23575r, xt2);
                } catch (Throwable unused) {
                    typeface = Typeface.DEFAULT;
                }
            }
        }
        if (cwVar.r() != null) {
            return cwVar.r();
        }
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(this.f23575r, "fonts/" + j6 + this.f23574m);
            } catch (Throwable unused2) {
                typeface = Typeface.DEFAULT;
            }
        }
        this.cw.put(j6, typeface);
        return typeface;
    }

    public Typeface j(com.bytedance.adsdk.lottie.model.cw cwVar) {
        this.f23573j.j(cwVar.j(), cwVar.cw());
        Typeface typeface = this.xt.get(this.f23573j);
        if (typeface != null) {
            return typeface;
        }
        Typeface j6 = j(xt(cwVar), cwVar.cw());
        this.xt.put(this.f23573j, j6);
        return j6;
    }

    private Typeface j(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i6 = (contains && contains2) ? 3 : contains ? 2 : contains2 ? 1 : 0;
        return typeface.getStyle() == i6 ? typeface : Typeface.create(typeface, i6);
    }
}
