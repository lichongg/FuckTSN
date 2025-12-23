package cn.jiguang.bl;

import cn.jiguang.bb.f;
import cn.jiguang.bi.e;
import cn.jiguang.bz.y;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends a {

    /* renamed from: j, reason: collision with root package name */
    private final int f2355j;

    /* renamed from: k, reason: collision with root package name */
    private ByteBuffer f2356k = ByteBuffer.allocate(8192);

    @Override // cn.jiguang.bl.a
    public synchronized int a(String str, int i6) {
        super.a(str, i6);
        try {
            this.f2337b = SocketChannel.open();
            this.f2339d = Selector.open();
            this.f2337b.configureBlocking(false);
            this.f2337b.connect(new InetSocketAddress(str, i6));
            f.c("NioSocketClient", "tcp connecting...");
            long currentTimeMillis = System.currentTimeMillis();
            while (!this.f2337b.finishConnect()) {
                if (!this.f2340e) {
                    f.c("NioSocketClient", "has close channel when connect...");
                    return -991;
                }
                Thread.sleep(10L);
                if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                    close();
                    return -994;
                }
            }
            if (!this.f2340e) {
                f.c("NioSocketClient", "has close channel when connected...");
                return -991;
            }
            f.c("NioSocketClient", "tcp connected [" + str + ":" + i6 + "]");
            this.f2337b.register(this.f2339d, 1);
            return 0;
        } catch (Throwable th) {
            f.j("NioSocketClient", "tcp connect has failed:" + th);
            close();
            return th instanceof SocketTimeoutException ? -994 : -1000;
        }
    }

    private boolean b(byte[] bArr) {
        try {
            if (!b()) {
                f.k("NioSocketClient", "send error -tcp connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                int write = this.f2337b.write(ByteBuffer.wrap(bArr));
                if (write > 0) {
                    f.a("NioSocketClient", "isWritable has send len:" + write);
                    return true;
                }
                if (write >= 0) {
                    return true;
                }
                f.a("NioSocketClient", "isWritable error:" + write);
                return false;
            }
            f.c("NioSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e6) {
            f.j("NioSocketClient", "send data error:" + e6);
            close();
            return false;
        }
    }

    @Override // cn.jiguang.bl.a
    public synchronized int a(byte[] bArr) {
        if (bArr == null) {
            f.i("NioSocketClient", "sendData failed, send data was null");
            return 103;
        }
        f.c("NioSocketClient", "send data length:" + bArr.length);
        if (bArr.length < this.f2355j) {
            return b(bArr) ? 0 : 103;
        }
        f.i("NioSocketClient", "sendData failed, data length must less than " + this.f2355j);
        return 6026;
    }

    @Override // cn.jiguang.bl.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        f.c("NioSocketClient", "close this connect");
        super.close();
        Selector selector = this.f2339d;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
        y.a(this.f2337b);
        this.f2337b = null;
    }

    public c(int i6, int i7) {
        this.f2355j = i6;
        this.f2341f = i7;
    }

    @Override // cn.jiguang.bl.a
    public ByteBuffer a(int i6) {
        ByteBuffer b6;
        try {
            if (!b()) {
                throw new e(-991, "recv error,the connect is invalid");
            }
            int c6 = c();
            if (c6 > 0 && (b6 = b(c6)) != null) {
                return b6;
            }
            int i7 = 0;
            int i8 = 1048576;
            while (b() && this.f2338c < i8) {
                int select = i6 > 0 ? this.f2339d.select(i6) : this.f2339d.select();
                if (select == 0) {
                    f.c("NioSocketClient", "readSelect:" + select + ",time out:" + i6);
                    if (i6 > 0) {
                        throw new e(-994, "recv time out");
                    }
                } else {
                    Iterator<SelectionKey> it = this.f2339d.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        if (next.isReadable()) {
                            int read = socketChannel.read(this.f2356k);
                            if (read < 0) {
                                throw new e(-996, "read len < 0:" + read);
                            }
                            this.f2356k.flip();
                            int limit = this.f2356k.limit();
                            if (this.f2336a.remaining() < limit) {
                                throw new e(-996, "the total buf remaining less than readLen,remaining:" + this.f2336a.remaining() + ",readLen:" + limit);
                            }
                            this.f2336a.put(this.f2356k);
                            this.f2338c += limit;
                            this.f2356k.compact();
                            if (this.f2338c < this.f2341f) {
                                f.c("NioSocketClient", "totalbuf can not parse head:" + this.f2338c + ",peerNetData len:" + limit + ",read:" + read);
                            } else {
                                i8 = c();
                            }
                            i7 = limit;
                        } else {
                            next.isWritable();
                        }
                        it.remove();
                    }
                }
            }
            if (i8 == 1048576) {
                throw new e(-997, "recv empty data or tcp has close");
            }
            f.c("NioSocketClient", "read len:" + i7 + ",recvTotalLen:" + this.f2338c + ",shouldLen:" + i8);
            ByteBuffer b7 = b(i8);
            if (b7 != null) {
                return b7;
            }
            throw new e(-1001, "parse error");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                throw new e(-994, th.getMessage());
            }
            if (th instanceof e) {
                throw th;
            }
            throw new e(-997, th.getMessage());
        }
    }
}
