package com.tsn.chat.utils;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends Thread {

    /* renamed from: c, reason: collision with root package name */
    private static NioEventLoopGroup f40741c;

    /* renamed from: d, reason: collision with root package name */
    private static CountDownLatch f40742d;

    /* renamed from: a, reason: collision with root package name */
    String f40743a;

    /* renamed from: b, reason: collision with root package name */
    int f40744b;

    public d() {
    }

    public d(String str, int i6, CountDownLatch countDownLatch) {
        this.f40743a = str;
        this.f40744b = i6;
        f40742d = countDownLatch;
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [io.netty.channel.ChannelFuture, io.netty.util.concurrent.Future] */
    public static void a(String str, int i6) {
        if (b.f40731b.equals("")) {
            b.f40731b = "linking";
            if (b.f40730a.size() > 0) {
                b.f40730a.close();
                b.f40730a.clear();
            }
            NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
            try {
                try {
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.group(nioEventLoopGroup);
                    bootstrap.channel(NioSocketChannel.class);
                    bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
                    bootstrap.option(ChannelOption.TCP_NODELAY, Boolean.TRUE);
                    bootstrap.handler(new com.tsn.chat.handler.d());
                    ?? sync = bootstrap.connect(str, i6).sync();
                    if (sync.isSuccess()) {
                        b.f40730a.add(sync.channel());
                        f40742d.countDown();
                    }
                    sync.channel().closeFuture().await();
                    nioEventLoopGroup.shutdownGracefully();
                } catch (Exception unused) {
                    b.f40730a.clear();
                    f40742d.countDown();
                    b.f40731b = "";
                    b3.a.a().k();
                    nioEventLoopGroup.shutdownGracefully();
                }
            } catch (Throwable th) {
                nioEventLoopGroup.shutdownGracefully();
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a(this.f40743a, this.f40744b);
    }
}
