package com.bytedance.adsdk.lottie.xt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.r;
import com.bytedance.adsdk.lottie.up.up;
import com.stub.StubApp;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f23576j = new Object();
    private final String cw;

    /* renamed from: r, reason: collision with root package name */
    private r f23577r;
    private final Map<String, g> up;
    private final Context xt;

    public void j(r rVar) {
        this.f23577r = rVar;
    }

    private Bitmap xt(String str, Bitmap bitmap) {
        synchronized (f23576j) {
        }
        return bitmap;
    }

    public Bitmap j(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return this.up.get(str).ws();
        }
        g gVar = this.up.get(str);
        Bitmap ws = gVar.ws();
        gVar.j(null);
        return ws;
    }

    public xt(Drawable.Callback callback, String str, r rVar, Map<String, g> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.cw = str + '/';
        } else {
            this.cw = str;
        }
        this.up = map;
        j(rVar);
        if (!(callback instanceof View)) {
            this.xt = null;
        } else {
            this.xt = StubApp.getOrigApplicationContext(((View) callback).getContext().getApplicationContext());
        }
    }

    public Bitmap j(String str) {
        g gVar = this.up.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap ws = gVar.ws();
        if (ws != null) {
            return ws;
        }
        r rVar = this.f23577r;
        if (rVar != null) {
            return rVar.j(gVar);
        }
        Context context = this.xt;
        if (context == null) {
            return null;
        }
        String vl = gVar.vl();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (vl.startsWith("data:") && vl.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(vl.substring(vl.indexOf(44) + 1), 0);
                return xt(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e6) {
                up.j("data URL did not have correct base64 format.", e6);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.cw)) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.cw + vl), null, options);
                    if (decodeStream == null) {
                        up.xt("Decoded image `" + str + "` is null.");
                        return null;
                    }
                    return xt(str, com.bytedance.adsdk.lottie.up.g.j(decodeStream, gVar.j(), gVar.xt()));
                } catch (IllegalArgumentException e7) {
                    up.j("Unable to decode image `" + str + "`.", e7);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e8) {
            up.j("Unable to open asset.", e8);
            return null;
        }
    }

    public boolean j(Context context) {
        return (context == null && this.xt == null) || this.xt.equals(context);
    }
}
