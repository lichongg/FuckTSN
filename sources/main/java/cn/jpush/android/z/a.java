package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    private int f4016a;

    public a(int i6, long j6, long j7, ByteBuffer byteBuffer) {
        super(i6, j6, j7, byteBuffer);
        parseBody();
    }

    public a(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f4016a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            this.f4016a = this.body.getShort();
        } catch (Throwable th) {
            Logger.ww("CommonResponse", "parse code failed :" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[CommonResponse] - " + this.f4016a;
    }
}
