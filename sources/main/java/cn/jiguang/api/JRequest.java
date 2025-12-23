package cn.jiguang.api;

import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JRequest extends JProtocol {
    public JRequest(int i6, int i7, long j6) {
        super(true, i6, i7, j6);
    }

    public JRequest(Object obj, ByteBuffer byteBuffer) {
        super(true, obj, byteBuffer);
    }

    public void setJuid(long j6) {
        this.head.a(j6);
    }

    public void setSid(int i6) {
        this.head.b(i6);
    }
}
