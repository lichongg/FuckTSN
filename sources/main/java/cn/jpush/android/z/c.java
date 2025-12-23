package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    int f4017a;

    /* renamed from: b, reason: collision with root package name */
    long f4018b;

    /* renamed from: c, reason: collision with root package name */
    String f4019c;

    public c(int i6, long j6, long j7, ByteBuffer byteBuffer) {
        super(i6, j6, j7, byteBuffer);
        parseBody();
    }

    public c(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f4017a;
    }

    public long b() {
        return this.f4018b;
    }

    public String c() {
        return this.f4019c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(this.body.array());
            this.f4017a = wrap.get();
            this.f4018b = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            this.f4019c = new String(bArr, "UTF-8");
        } catch (Throwable th) {
            Logger.ww("MessagePush", "parse msg content failed, e: " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[MessagePush] - msgType:" + this.f4017a + ", msgId:" + this.f4018b + ", msgContent:" + this.f4019c + " - " + super.toString();
    }
}
