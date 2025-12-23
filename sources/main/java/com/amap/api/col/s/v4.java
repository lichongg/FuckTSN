package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v4 extends b4<String, Integer> {

    /* renamed from: t, reason: collision with root package name */
    private Context f8579t;

    /* renamed from: u, reason: collision with root package name */
    private String f8580u;

    private static Integer U() throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f8579t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f8580u);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.e() + "/nearby/data/delete";
    }

    public v4(Context context, String str) {
        super(context, str);
        this.f8579t = context;
        this.f8580u = str;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U();
    }
}
