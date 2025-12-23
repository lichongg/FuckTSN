package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.UploadInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c extends b4<UploadInfo, Integer> {

    /* renamed from: t, reason: collision with root package name */
    private Context f7892t;

    /* renamed from: u, reason: collision with root package name */
    private UploadInfo f7893u;

    private static Integer U() throws AMapException {
        return 0;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f7892t));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.f7893u.getUserID());
        LatLonPoint point = this.f7893u.getPoint();
        int longitude = (int) (point.getLongitude() * 1000000.0d);
        int latitude = (int) (point.getLatitude() * 1000000.0d);
        stringBuffer.append("&location=");
        stringBuffer.append(longitude / 1000000.0f);
        stringBuffer.append(",");
        stringBuffer.append(latitude / 1000000.0f);
        stringBuffer.append("&coordtype=");
        stringBuffer.append(this.f7893u.getCoordType());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.e() + "/nearby/data/create";
    }

    public c(Context context, UploadInfo uploadInfo) {
        super(context, uploadInfo);
        this.f7892t = context;
        this.f7893u = uploadInfo;
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final /* synthetic */ Object I(String str) throws AMapException {
        return U();
    }
}
