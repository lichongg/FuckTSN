package com.bytedance.sdk.component.m.cw;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.m.az;
import com.bytedance.sdk.component.m.cw.cw;
import com.bytedance.sdk.component.m.jy;
import com.bytedance.sdk.component.m.mi;
import com.bytedance.sdk.component.m.oq;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;

@ATS(single = true, value = {"img_service"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements az {

    /* renamed from: j, reason: collision with root package name */
    private volatile m f26590j;

    public static az j(Context context, jy jyVar) {
        xt xtVar = new xt();
        xtVar.xt(context, jyVar);
        return xtVar;
    }

    private void xt(Context context, jy jyVar) {
        if (this.f26590j != null) {
            vl.xt(ImageLoader.TAG, "already init!");
        }
        if (jyVar == null) {
            jyVar = up.j(context);
        }
        this.f26590j = new m(context, jyVar);
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(4)
    public void cw(double d6) {
        if (this.f26590j != null) {
            j(this.f26590j.cw(), d6);
        }
    }

    private xt() {
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(1)
    public oq j(String str) {
        return new cw.xt(this.f26590j).j(str);
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(2)
    public void j(double d6) {
        xt(d6);
        cw(d6);
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(3)
    public void xt(double d6) {
        if (this.f26590j != null) {
            j(this.f26590j.j(), d6);
            j(this.f26590j.xt(), d6);
        }
    }

    private void j(Collection<? extends com.bytedance.sdk.component.m.j> collection, double d6) {
        if (collection == null) {
            return;
        }
        Iterator<? extends com.bytedance.sdk.component.m.j> it = collection.iterator();
        while (it.hasNext()) {
            it.next().j(d6);
        }
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(5)
    public void j() {
        cw(0.0d);
        xt(0.0d);
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(8)
    public boolean xt(String str, String str2, String str3) {
        if (this.f26590j == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            str2 = com.bytedance.sdk.component.m.cw.cw.cw.j(str);
        }
        com.bytedance.sdk.component.m.cw j6 = this.f26590j.j(str3);
        if (j6 != null) {
            return j6.xt(str2);
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(6)
    public InputStream j(String str, String str2) {
        if (this.f26590j != null) {
            if (TextUtils.isEmpty(str2)) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                str2 = com.bytedance.sdk.component.m.cw.cw.cw.j(str);
            }
            Collection<mi> xt = this.f26590j.xt();
            if (xt != null) {
                Iterator<mi> it = xt.iterator();
                while (it.hasNext()) {
                    byte[] j6 = it.next().j((mi) str2);
                    if (j6 != null) {
                        return new ByteArrayInputStream(j6);
                    }
                }
            }
            Collection<com.bytedance.sdk.component.m.cw> cw = this.f26590j.cw();
            if (cw != null) {
                Iterator<com.bytedance.sdk.component.m.cw> it2 = cw.iterator();
                while (it2.hasNext()) {
                    InputStream j7 = it2.next().j(str2);
                    if (j7 != null) {
                        return j7;
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.m.az
    @ATSMethod(7)
    public InputStream j(String str, String str2, String str3) {
        if (this.f26590j == null || TextUtils.isEmpty(str3)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str2 = com.bytedance.sdk.component.m.cw.cw.cw.j(str);
        }
        com.bytedance.sdk.component.m.cw j6 = this.f26590j.j(str3);
        if (j6 != null) {
            return j6.j(str2);
        }
        return null;
    }
}
