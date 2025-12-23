package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.y1;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class z1 extends b8 {

    /* renamed from: d, reason: collision with root package name */
    private Context f7792d;

    /* renamed from: e, reason: collision with root package name */
    private y1 f7793e;

    /* renamed from: g, reason: collision with root package name */
    private f2 f7794g;

    /* renamed from: h, reason: collision with root package name */
    private a f7795h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str, f2 f2Var);
    }

    private static String a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    public final void b() {
        z2.a().b(this);
    }

    public final void a() {
        this.f7792d = null;
        if (this.f7793e != null) {
            this.f7793e = null;
        }
    }

    public final void b(a aVar) {
        this.f7795h = aVar;
    }

    public final void c(f2 f2Var) {
        this.f7794g = f2Var;
    }

    public final void d(String str) {
        y1 y1Var = this.f7793e;
        if (y1Var != null) {
            y1Var.b(str);
        }
    }

    public z1(Context context) {
        this.f7792d = context;
        if (this.f7793e == null) {
            this.f7793e = new y1(context, "");
        }
    }

    private static void e(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    @Override // com.amap.api.col.p0003l.b8
    public final void runTask() {
        String str;
        try {
            if (!MapsInitializer.getNetWorkEnable()) {
                return;
            }
            y1 y1Var = this.f7793e;
            if (y1Var != null) {
                y1.a m6 = y1Var.m();
                if (m6 != null && m6.f7739a != null) {
                    str = a(this.f7792d) + "/custom_texture_data";
                    e(str, m6.f7739a);
                } else {
                    str = null;
                }
                a aVar = this.f7795h;
                if (aVar != null) {
                    aVar.a(str, this.f7794g);
                }
            }
            v5.g(this.f7792d, b3.s());
        } catch (Throwable th) {
            v5.p(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
