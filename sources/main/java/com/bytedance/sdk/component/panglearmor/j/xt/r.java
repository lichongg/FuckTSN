package com.bytedance.sdk.component.panglearmor.j.xt;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements xt {
    private final long cw;

    /* renamed from: j, reason: collision with root package name */
    private final FileChannel f26698j;
    private final long xt;

    @Override // com.bytedance.sdk.component.panglearmor.j.xt.xt
    public long j() {
        long j6 = this.cw;
        if (j6 != -1) {
            return j6;
        }
        try {
            return this.f26698j.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public r(FileChannel fileChannel, long j6, long j7) {
        if (j6 >= 0) {
            if (j7 >= 0) {
                this.f26698j = fileChannel;
                this.xt = j6;
                this.cw = j7;
                return;
            }
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j7)));
        }
        throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j7)));
    }

    @Override // com.bytedance.sdk.component.panglearmor.j.xt.xt
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public r j(long j6, long j7) {
        long j8 = j();
        j(j6, j7, j8);
        if (j6 == 0 && j7 == j8) {
            return this;
        }
        return new r(this.f26698j, this.xt + j6, j7);
    }

    public void j(long j6, int i6, ByteBuffer byteBuffer) throws IOException {
        int read;
        j(j6, i6, j());
        if (i6 == 0) {
            return;
        }
        if (i6 <= byteBuffer.remaining()) {
            long j7 = this.xt + j6;
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i6);
                while (i6 > 0) {
                    synchronized (this.f26698j) {
                        this.f26698j.position(j7);
                        read = this.f26698j.read(byteBuffer);
                    }
                    j7 += read;
                    i6 -= read;
                }
                return;
            } finally {
                byteBuffer.limit(limit);
            }
        }
        throw new BufferOverflowException();
    }

    @Override // com.bytedance.sdk.component.panglearmor.j.xt.xt
    public ByteBuffer j(long j6, int i6) throws IOException {
        if (i6 >= 0) {
            ByteBuffer allocate = ByteBuffer.allocate(i6);
            j(j6, i6, allocate);
            allocate.flip();
            return allocate;
        }
        throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i6)));
    }

    private static void j(long j6, long j7, long j8) {
        if (j6 < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j6)));
        }
        if (j7 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j7)));
        }
        if (j6 > j8) {
            throw new IndexOutOfBoundsException("offset (" + j6 + ") > source size (" + j8 + ")");
        }
        long j9 = j6 + j7;
        if (j9 < j6) {
            throw new IndexOutOfBoundsException("offset (" + j6 + ") + size (" + j7 + ") overflow");
        }
        if (j9 <= j8) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j6 + ") + size (" + j7 + ") > source size (" + j8 + ")");
    }
}
