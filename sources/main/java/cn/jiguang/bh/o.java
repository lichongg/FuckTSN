package cn.jiguang.bh;

import java.io.EOFException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    protected long f2217a;

    /* renamed from: b, reason: collision with root package name */
    protected SelectionKey f2218b;

    void a(SocketAddress socketAddress) {
        ((SocketChannel) this.f2218b.channel()).socket().bind(socketAddress);
    }

    void b() {
        this.f2218b.selector().close();
        this.f2218b.channel().close();
    }

    protected static void a(SelectionKey selectionKey, long j6) {
        long currentTimeMillis = j6 - System.currentTimeMillis();
        if ((currentTimeMillis > 0 ? selectionKey.selector().select(currentTimeMillis) : currentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    void b(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.f2218b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.f2218b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.f2218b.isConnectable()) {
                    a(this.f2218b, this.f2217a);
                }
            } finally {
                if (this.f2218b.isValid()) {
                    this.f2218b.interestOps(0);
                }
            }
        }
    }

    public o(long j6) {
        this.f2217a = j6;
        SocketChannel open = SocketChannel.open();
        try {
            Selector open2 = Selector.open();
            try {
                open.configureBlocking(false);
                this.f2218b = open.register(open2, 1);
                if (open2 != null) {
                    open2.close();
                }
                open.close();
            } finally {
            }
        } catch (Throwable th) {
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    void a(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.f2218b.channel();
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.f2218b.interestOps(4);
        int i6 = 0;
        while (i6 < bArr.length + 2) {
            try {
                if (this.f2218b.isWritable()) {
                    long write = socketChannel.write(byteBufferArr);
                    if (write < 0) {
                        throw new EOFException();
                    }
                    i6 += (int) write;
                    if (i6 < bArr.length + 2 && System.currentTimeMillis() > this.f2217a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f2218b, this.f2217a);
                }
            } catch (Throwable th) {
                if (this.f2218b.isValid()) {
                    this.f2218b.interestOps(0);
                }
                throw th;
            }
        }
        if (this.f2218b.isValid()) {
            this.f2218b.interestOps(0);
        }
    }

    byte[] a() {
        byte[] a6 = a(2);
        byte[] a7 = a(((a6[0] & 255) << 8) + (a6[1] & 255));
        return a7;
    }

    private byte[] a(int i6) {
        SocketChannel socketChannel = (SocketChannel) this.f2218b.channel();
        byte[] bArr = new byte[i6];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f2218b.interestOps(1);
        int i7 = 0;
        while (i7 < i6) {
            try {
                if (this.f2218b.isReadable()) {
                    long read = socketChannel.read(wrap);
                    if (read < 0) {
                        throw new EOFException();
                    }
                    i7 += (int) read;
                    if (i7 < i6 && System.currentTimeMillis() > this.f2217a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f2218b, this.f2217a);
                }
            } catch (Throwable th) {
                if (this.f2218b.isValid()) {
                    this.f2218b.interestOps(0);
                }
                throw th;
            }
        }
        if (this.f2218b.isValid()) {
            this.f2218b.interestOps(0);
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j6) {
        o oVar = new o(j6);
        if (socketAddress != null) {
            try {
                oVar.a(socketAddress);
            } catch (Throwable th) {
                oVar.b();
                throw th;
            }
        }
        oVar.b(socketAddress2);
        oVar.a(bArr);
        byte[] a6 = oVar.a();
        oVar.b();
        return a6;
    }
}
