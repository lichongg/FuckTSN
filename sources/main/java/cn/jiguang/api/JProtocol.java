package cn.jiguang.api;

import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.bx.c;
import cn.jiguang.bx.d;
import cn.jiguang.bx.f;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class JProtocol {
    public static final int DEFAULT_RESP_CODE = 0;
    public static final int DEFAULT_RID = 0;
    public static final int DEFAULT_SID = 0;
    public static final int NO_JUID = -1;
    public static final int NO_RESP_CODE = -1;
    public static final int NO_SID = -1;
    private static final int PACKET_SIZE = 7168;
    private static final String TAG = "JProtocol";
    protected ByteBuffer body;
    protected c head;
    private boolean isRequest;

    public JProtocol(boolean z5, int i6, int i7, long j6) {
        this.isRequest = z5;
        this.head = new c(z5, i6, i7, j6);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    public static byte[] parseHead(Object obj) {
        String str;
        if (obj == null) {
            str = "object was null";
        } else {
            if (obj instanceof c) {
                return ((c) obj).f();
            }
            str = "unknow Object";
        }
        d.c(TAG, str);
        return null;
    }

    public abstract String getName();

    protected abstract boolean isNeedParseeErrorMsg();

    protected abstract void parseBody();

    protected abstract void writeBody();

    public JProtocol(boolean z5, int i6, int i7, long j6, int i8, long j7) {
        this.isRequest = z5;
        this.head = new c(z5, 0, i6, i7, j6, i8, j7);
        this.body = ByteBuffer.allocate(PACKET_SIZE);
    }

    private final byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = ProtocolUtil.getBytes(this.body);
        if (bytes == null) {
            d.c(TAG, "toBytes bodyBytes  is  null");
            return null;
        }
        this.head.a((this.isRequest ? 24 : 20) + bytes.length);
        try {
            byteArrayOutputStream.write(this.head.f());
            byteArrayOutputStream.write(bytes);
        } catch (Exception unused) {
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        d.b(TAG, "Final - len:" + byteArray.length + ", bytes: " + f.a(byteArray));
        return byteArray;
    }

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCommand() {
        return this.head.a();
    }

    public c getHead() {
        return this.head;
    }

    public long getJuid() {
        return this.head.c();
    }

    public Long getRid() {
        return this.head.b();
    }

    public int getSid() {
        return this.head.d();
    }

    public int getVersion() {
        return this.head.e();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.isRequest ? "[Request]" : "[Response]");
        sb.append(" - ");
        sb.append(this.head.toString());
        return sb.toString();
    }

    public final byte[] writeBodyAndToBytes() {
        this.body.clear();
        writeBody();
        this.body.flip();
        return toBytes();
    }

    protected void writeBytes(byte[] bArr) {
        this.body.put(bArr);
    }

    protected void writeInt1(int i6) {
        this.body.put((byte) i6);
    }

    protected void writeInt2(int i6) {
        this.body.putShort((short) i6);
    }

    protected void writeInt4(int i6) {
        this.body.putInt(i6);
    }

    protected void writeLong8(long j6) {
        this.body.putLong(j6);
    }

    protected void writeTlv2(String str) {
        this.body.put(ProtocolUtil.tlv2ToByteArray(str));
    }

    public JProtocol(boolean z5, Object obj, ByteBuffer byteBuffer) {
        this.isRequest = z5;
        this.head = (c) obj;
        if (byteBuffer == null) {
            d.c(TAG, "No body to parse.");
        } else {
            this.body = byteBuffer;
            parseBody();
        }
    }

    public JProtocol(boolean z5, ByteBuffer byteBuffer, byte[] bArr) {
        this.isRequest = z5;
        try {
            this.head = new c(z5, bArr);
        } catch (Exception e6) {
            d.c(TAG, "create JHead failed:" + e6.getMessage());
        }
        if (byteBuffer == null) {
            d.c(TAG, "No body to parse.");
        } else {
            this.body = byteBuffer;
            parseBody();
        }
    }
}
