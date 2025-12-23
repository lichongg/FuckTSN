package com.bxkj.base.v2.netty4android.client.handler;

import com.orhanobut.logger.j;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d extends SimpleChannelInboundHandler<com.bxkj.base.v2.netty4android.client.command.a> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final s.b<com.bxkj.base.v2.netty4android.client.command.a> f17124a;

    /* renamed from: b, reason: collision with root package name */
    private final int f17125b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f17126c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final Object f17127d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.SimpleChannelInboundHandler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void channelRead0(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull com.bxkj.base.v2.netty4android.client.command.a msg) {
        g0.p(channelHandlerContext, "channelHandlerContext");
        g0.p(msg, "msg");
        msg.d("服务器响应数据：");
        s.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this.f17124a;
        if (bVar != null) {
            bVar.a(msg, this.f17125b);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(@NotNull ChannelHandlerContext ctx) {
        g0.p(ctx, "ctx");
        j.d("客户端上线", new Object[0]);
        s.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this.f17124a;
        if (bVar != null) {
            bVar.b(1, this.f17125b);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(@NotNull ChannelHandlerContext ctx) {
        g0.p(ctx, "ctx");
        j.d("客户端下线", new Object[0]);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(@NotNull ChannelHandlerContext ctx, @NotNull Throwable cause) {
        g0.p(ctx, "ctx");
        g0.p(cause, "cause");
        j.e("exceptionCaught", new Object[0]);
        s.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this.f17124a;
        if (bVar != null) {
            bVar.b(-1, this.f17125b);
        }
        cause.printStackTrace();
        ctx.close();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(@NotNull ChannelHandlerContext ctx, @NotNull Object evt) {
        g0.p(ctx, "ctx");
        g0.p(evt, "evt");
        if ((evt instanceof IdleStateEvent) && ((IdleStateEvent) evt).state() == IdleState.WRITER_IDLE) {
            if (!this.f17126c) {
                j.d("不发送心跳", new Object[0]);
                n1 n1Var = n1.f44123a;
                return;
            }
            Object obj = this.f17127d;
            if (obj == null) {
                Channel channel = ctx.channel();
                String property = System.getProperty("line.separator");
                g0.m(property);
                channel.writeAndFlush("Heartbeat" + property);
                return;
            }
            if (obj instanceof String) {
                Channel channel2 = ctx.channel();
                Object obj2 = this.f17127d;
                String property2 = System.getProperty("line.separator");
                g0.m(property2);
                channel2.writeAndFlush(obj2 + property2);
                return;
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                g0.m(bArr);
                ctx.channel().writeAndFlush(Unpooled.copiedBuffer(bArr));
                return;
            }
            if (obj instanceof com.bxkj.base.v2.netty4android.client.command.a) {
                ctx.writeAndFlush(obj);
            } else {
                j.d("userEventTriggered: heartBeatData type error", new Object[0]);
                n1 n1Var2 = n1.f44123a;
            }
        }
    }

    public d(@Nullable s.b<com.bxkj.base.v2.netty4android.client.command.a> bVar, int i6, boolean z5, @Nullable Object obj) {
        this.f17124a = bVar;
        this.f17125b = i6;
        this.f17126c = z5;
        this.f17127d = obj;
    }
}
