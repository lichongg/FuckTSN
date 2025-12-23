package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.w1;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class x1 extends b8 {

    /* renamed from: d, reason: collision with root package name */
    private Context f7632d;

    /* renamed from: e, reason: collision with root package name */
    private IAMapDelegate f7633e;

    /* renamed from: g, reason: collision with root package name */
    private w1 f7634g;

    /* renamed from: h, reason: collision with root package name */
    private String f7635h;

    /* renamed from: i, reason: collision with root package name */
    private String f7636i;

    /* renamed from: j, reason: collision with root package name */
    private String f7637j;

    /* renamed from: k, reason: collision with root package name */
    private a f7638k;

    /* renamed from: l, reason: collision with root package name */
    private int f7639l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(byte[] bArr, int i6);

        void b(byte[] bArr, int i6);
    }

    public x1(Context context, a aVar, int i6, String str) {
        this.f7635h = null;
        this.f7636i = null;
        this.f7637j = null;
        this.f7632d = context;
        this.f7638k = aVar;
        this.f7639l = i6;
        if (this.f7634g == null) {
            this.f7634g = new w1(context, "", i6 != 0);
        }
        this.f7634g.b(str);
        StringBuilder sb = new StringBuilder();
        sb.append(i6);
        sb.append(str == null ? "" : str);
        sb.append(".amapstyle");
        this.f7635h = sb.toString();
        this.f7636i = context.getCacheDir().getPath();
    }

    private byte[] e(String str) {
        if (str == null || this.f7636i == null) {
            return null;
        }
        return FileUtil.readFileContents(this.f7636i + File.separator + str);
    }

    private String f(String str) {
        if (str == null) {
            return null;
        }
        Object b6 = x2.b(this.f7632d, "amap_style_config", "lastModified".concat(str), "");
        if (!(b6 instanceof String) || b6 == "") {
            return null;
        }
        return (String) b6;
    }

    public final void a() {
        this.f7632d = null;
        if (this.f7634g != null) {
            this.f7634g = null;
        }
    }

    public final void b(String str) {
        w1 w1Var = this.f7634g;
        if (w1Var != null) {
            w1Var.c(str);
        }
        this.f7637j = str;
    }

    private void c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        x2.a(this.f7632d, "amap_style_config", "lastModified".concat(str), str2);
    }

    private void d(String str, byte[] bArr) {
        if (str == null || bArr == null || this.f7636i == null) {
            return;
        }
        FileUtil.saveFileContents(this.f7636i + File.separator + str, bArr);
    }

    @Override // com.amap.api.col.p0003l.b8
    public final void runTask() {
        byte[] bArr;
        JSONObject jSONObject;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.f7634g != null) {
                    String str = this.f7637j + this.f7635h;
                    String f6 = f(str);
                    if (f6 != null) {
                        this.f7634g.d(f6);
                    }
                    byte[] e6 = e(str);
                    a aVar = this.f7638k;
                    if (aVar != null && e6 != null) {
                        aVar.a(e6, this.f7639l);
                    }
                    w1.a m6 = this.f7634g.m();
                    if (m6 != null && (bArr = m6.f7494a) != null) {
                        try {
                            jSONObject = new JSONObject(new String(bArr));
                        } catch (JSONException unused) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            if (this.f7638k != null) {
                                if (!Arrays.equals(m6.f7494a, e6)) {
                                    this.f7638k.b(m6.f7494a, this.f7639l);
                                }
                            } else {
                                IAMapDelegate iAMapDelegate = this.f7633e;
                                if (iAMapDelegate != null) {
                                    iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), m6.f7494a);
                                }
                            }
                            d(str, m6.f7494a);
                            c(str, m6.f7496c);
                        }
                    }
                }
                v5.g(this.f7632d, b3.s());
                IAMapDelegate iAMapDelegate2 = this.f7633e;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            v5.p(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        z2.a().b(this);
    }

    public x1(Context context, IAMapDelegate iAMapDelegate) {
        this.f7635h = null;
        this.f7636i = null;
        this.f7637j = null;
        this.f7639l = 0;
        this.f7632d = context;
        this.f7633e = iAMapDelegate;
        if (this.f7634g == null) {
            this.f7634g = new w1(context, "");
        }
    }
}
