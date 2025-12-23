package cn.jiguang.api;

import cn.jiguang.api.utils.ByteBufferUtils;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JResponse extends JProtocol {
    public int code;

    public JResponse(int i6, int i7, long j6, long j7, int i8, String str) {
        super(false, i6, i7, j6, -1, j7);
        this.code = i8;
    }

    public JResponse(Object obj, ByteBuffer byteBuffer) {
        super(false, obj, byteBuffer);
    }

    @Override // cn.jiguang.api.JProtocol
    public String toString() {
        return "JResponse{code=" + this.code + '}';
    }

    @Override // cn.jiguang.api.JProtocol
    protected void writeBody() {
        int i6 = this.code;
        if (i6 >= 0) {
            writeInt2(i6);
        }
    }

    public JResponse(ByteBuffer byteBuffer, byte[] bArr) {
        super(false, byteBuffer, bArr);
    }

    @Override // cn.jiguang.api.JProtocol
    protected void parseBody() {
        if (isNeedParseeErrorMsg()) {
            this.code = ByteBufferUtils.getShort(this.body, this);
        }
    }
}
