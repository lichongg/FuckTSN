package com.bytedance.sdk.openadsdk.core.ugeno;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.model.layer.a;
import com.bytedance.adsdk.lottie.model.layer.b;
import com.bytedance.adsdk.ugeno.cw.ws;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.rn.i;
import com.bytedance.sdk.openadsdk.core.tj.pz;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements com.bytedance.adsdk.ugeno.j {

    public interface j {
        void j(Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable cw(byte[] bArr) {
        FileOutputStream fileOutputStream;
        File xt;
        ImageDecoder.Source createSource;
        Drawable decodeDrawable;
        try {
            boolean cw = com.bytedance.sdk.openadsdk.core.multipro.xt.cw();
            xt = com.bytedance.sdk.component.utils.m.xt(v.getContext(), cw, cw ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(xt);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr, 0, bArr.length);
            if (Build.VERSION.SDK_INT < 28) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(v.getContext().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
                return bitmapDrawable;
            }
            createSource = ImageDecoder.createSource(xt);
            decodeDrawable = ImageDecoder.decodeDrawable(createSource);
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
            return decodeDrawable;
        } catch (Throwable th2) {
            th = th2;
            try {
                vl.cw("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            } catch (Throwable th3) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th3;
            }
        }
    }

    public void xt(ws wsVar, String str, final j.InterfaceC0320j interfaceC0320j) {
        com.bytedance.sdk.component.m.oq cw = com.bytedance.sdk.openadsdk.g.xt.j(str).cw(1);
        j(wsVar, cw, str);
        cw.j(new av() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.3
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv qvVar) {
                if (qvVar == null) {
                    interfaceC0320j.j(null);
                    return;
                }
                j.InterfaceC0320j interfaceC0320j2 = interfaceC0320j;
                if (interfaceC0320j2 == null) {
                    interfaceC0320j2.j(null);
                    return;
                }
                if (qvVar.cw() instanceof Bitmap) {
                    interfaceC0320j.j((Bitmap) qvVar.cw());
                } else if (qvVar.cw() instanceof byte[]) {
                    try {
                        interfaceC0320j.j(BitmapFactory.decodeByteArray((byte[]) qvVar.cw(), 0, ((byte[]) qvVar.cw()).length));
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i6, String str2, Throwable th) {
                j.InterfaceC0320j interfaceC0320j2 = interfaceC0320j;
                if (interfaceC0320j2 != null) {
                    interfaceC0320j2.j(null);
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.j
    public void j(ws wsVar, String str, ImageView imageView, j.InterfaceC0320j interfaceC0320j) {
        if (imageView instanceof GifView) {
            final GifView gifView = (GifView) imageView;
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            com.bytedance.sdk.openadsdk.g.xt.j(str).cw(3).j(Bitmap.Config.RGB_565).j(new av() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.1
                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(2)
                public void j(int i6, String str2, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.av
                @ATSMethod(1)
                public void j(qv qvVar) {
                    try {
                        Object cw = qvVar.cw();
                        if (!(cw instanceof byte[])) {
                            if (cw instanceof Bitmap) {
                                gifView.setImageBitmap((Bitmap) cw);
                            }
                        } else if (!qvVar.tl()) {
                            gifView.setImageDrawable(i.j((byte[]) cw, 0));
                        } else {
                            gifView.j((byte[]) cw, false);
                            gifView.setRepeatConfig(true);
                            gifView.xt();
                        }
                    } catch (Throwable th) {
                        j(1002, "", th);
                    }
                }
            });
            return;
        }
        com.bytedance.sdk.component.m.oq j6 = com.bytedance.sdk.openadsdk.g.xt.j(str);
        j(wsVar, j6, str);
        j6.j(imageView);
    }

    public boolean xt(byte[] bArr) {
        return TextUtils.equals("png", com.bytedance.sdk.component.utils.g.j(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.g.j()))) && com.bytedance.sdk.component.adexpress.r.m.j(bArr);
    }

    @Override // com.bytedance.adsdk.ugeno.j
    public void j(ws wsVar, String str, final ImageView imageView, int i6, int i7, j.InterfaceC0320j interfaceC0320j) {
        com.bytedance.sdk.component.m.oq cw = com.bytedance.sdk.openadsdk.g.xt.j(str).cw(3);
        j(wsVar, cw, str);
        cw.j(new av() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.2
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i8, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(final qv qvVar) {
                if (imageView.isAttachedToWindow()) {
                    r.this.j(qvVar, imageView);
                } else {
                    imageView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            r.this.j(qvVar, imageView);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(qv qvVar, ImageView imageView) {
        Object cw = qvVar.cw();
        if (cw instanceof byte[]) {
            if (!qvVar.tl()) {
                byte[] bArr = (byte[]) cw;
                if (!xt(bArr)) {
                    if (j(bArr)) {
                        com.bytedance.sdk.component.adexpress.r.m.j(imageView, bArr, imageView.getWidth(), imageView.getHeight());
                        return;
                    }
                    int j6 = pz.j(imageView.getWidth(), imageView.getHeight());
                    Bitmap j7 = new com.bytedance.sdk.component.m.cw.xt.j(imageView.getWidth(), imageView.getHeight(), imageView.getScaleType(), Bitmap.Config.RGB_565, imageView.getWidth() / j6, imageView.getHeight() / j6).j(bArr);
                    if (j7 != null) {
                        imageView.setImageBitmap(j7);
                        return;
                    }
                    return;
                }
            }
            if (Build.VERSION.SDK_INT <= 30) {
                j((byte[]) cw, imageView);
                return;
            } else {
                com.bytedance.sdk.component.adexpress.r.m.j(imageView, (byte[]) cw, imageView.getWidth(), imageView.getHeight());
                return;
            }
        }
        if (cw instanceof Bitmap) {
            imageView.setImageBitmap((Bitmap) cw);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.j
    public void j(ws wsVar, String str, j.InterfaceC0320j interfaceC0320j) {
        xt(wsVar, str, interfaceC0320j);
    }

    private void j(ws wsVar, com.bytedance.sdk.component.m.oq oqVar, String str) {
        Map<String, Object> xt;
        if (wsVar == null || (xt = wsVar.xt()) == null) {
            return;
        }
        Object obj = xt.get("image_info");
        if (obj instanceof Map) {
            oqVar.xt((String) ((Map) obj).get(str));
        }
        String str2 = (String) xt.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        oqVar.cw(str2);
    }

    private void j(byte[] bArr, final ImageView imageView) {
        try {
            vl.r("ImageLoaderProvider", "load animation image");
            j(bArr, new j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.4
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
                public void j(final Drawable drawable) {
                    com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && a.a(drawable)) {
                                b.a(drawable).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void j(final byte[] bArr, final j jVar) {
        com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("csj_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.5
            @Override // java.lang.Runnable
            public void run() {
                Drawable cw = r.this.cw(bArr);
                j jVar2 = jVar;
                if (jVar2 != null) {
                    jVar2.j(cw);
                }
            }
        });
    }

    public boolean j(byte[] bArr) {
        return com.bytedance.sdk.component.adexpress.r.m.j(bArr, 0);
    }
}
