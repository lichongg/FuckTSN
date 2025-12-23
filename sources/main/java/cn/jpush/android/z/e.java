package cn.jpush.android.z;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f4024a;

    /* renamed from: b, reason: collision with root package name */
    String f4025b;

    public e(int i6, long j6, long j7, ByteBuffer byteBuffer) {
        super(i6, j6, j7, byteBuffer);
        parseBody();
    }

    public e(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public String a() {
        return this.f4025b;
    }

    @Override // cn.jpush.android.local.JPushResponse
    protected void parseBody() {
        try {
            int i6 = this.cmd;
            if (i6 == 10 || i6 == 38) {
                this.f4024a = this.body.getShort();
            }
            if (this.cmd == 38 || this.f4024a <= 0) {
                byte[] bArr = new byte[this.body.getShort()];
                this.body.get(bArr);
                this.f4025b = new String(bArr, "UTF-8");
            } else {
                Logger.e("TagaliasResponse", "Response error - code:" + this.f4024a);
            }
        } catch (Throwable th) {
            Logger.ww("TagaliasResponse", "parse failed:" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[TagaliasResponse] - action:" + this.f4025b + " - " + super.toString();
    }
}
