package cn.jpush.android.n;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    private int f3712a;

    public b(int i6, long j6, long j7, ByteBuffer byteBuffer) {
        super(i6, j6, j7, byteBuffer);
        this.f3712a = 0;
        parseBody();
    }

    public b(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f3712a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            ByteBuffer byteBuffer = this.body;
            if (byteBuffer != null) {
                this.f3712a = byteBuffer.get();
                Logger.ww("GeoControl", "control type:" + this.f3712a);
            }
        } catch (Throwable unused) {
            Logger.ww("GeoControl", "parse geoContorl failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoControl] - type:" + this.f3712a + " - " + super.toString();
    }
}
