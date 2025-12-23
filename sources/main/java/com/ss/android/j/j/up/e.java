package com.ss.android.j.j.up;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.up.j;
import java.util.Arrays;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: e, reason: collision with root package name */
    public String f38318e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f38320g;

    /* renamed from: a, reason: collision with root package name */
    public long f38314a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f38315b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f38316c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f38317d = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f38319f = 0;

    public void a(cw cwVar) {
        if (cwVar == null) {
            return;
        }
        this.f38314a = cwVar.ae();
        this.f38315b = cwVar.i();
        this.f38317d = cwVar.uq();
        this.f38316c = cwVar.ka();
        this.f38318e = cwVar.ws();
        j hk = cwVar.hk();
        if (hk != null) {
            this.f38319f = hk.j();
        } else {
            this.f38319f = 0;
        }
        this.f38320g = cwVar.x();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return super.equals(obj);
        }
        e eVar = (e) obj;
        return ((this.f38314a > eVar.f38314a ? 1 : (this.f38314a == eVar.f38314a ? 0 : -1)) == 0) && (this.f38315b == eVar.f38315b) && ((this.f38316c > eVar.f38316c ? 1 : (this.f38316c == eVar.f38316c ? 0 : -1)) == 0) && ((TextUtils.isEmpty(this.f38318e) && TextUtils.isEmpty(eVar.f38318e)) || (!TextUtils.isEmpty(this.f38318e) && !TextUtils.isEmpty(eVar.f38318e) && this.f38318e.equals(eVar.f38318e)));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f38314a), Integer.valueOf(this.f38315b), Long.valueOf(this.f38316c), this.f38318e});
    }
}
