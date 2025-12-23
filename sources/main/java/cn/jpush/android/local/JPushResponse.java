package cn.jpush.android.local;

import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushResponse {
    public ByteBuffer body;
    public int cmd;
    public long rid;
    public long rquestId;

    public ByteBuffer getBody() {
        return this.body;
    }

    public int getCmd() {
        return this.cmd;
    }

    public long getRid() {
        return this.rid;
    }

    public long getRquestId() {
        return this.rquestId;
    }

    public void setBody(ByteBuffer byteBuffer) {
        this.body = byteBuffer;
    }

    public void setCmd(int i6) {
        this.cmd = i6;
    }

    public void setRid(long j6) {
        this.rid = j6;
    }

    public void setRquestId(long j6) {
        this.rquestId = j6;
    }

    public String toString() {
        return "JPushResponse{cmd=" + this.cmd + ", rid=" + this.rid + ", rquestId=" + this.rquestId + '}';
    }

    public JPushResponse(int i6, long j6, long j7, ByteBuffer byteBuffer) {
        this.cmd = i6;
        this.rid = j6;
        this.body = byteBuffer;
        this.rquestId = j7;
    }

    protected void parseBody() {
    }
}
