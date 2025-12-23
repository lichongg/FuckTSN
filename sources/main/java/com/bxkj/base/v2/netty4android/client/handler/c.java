package com.bxkj.base.v2.netty4android.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.nio.charset.Charset;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c extends MessageToByteEncoder<com.bxkj.base.v2.netty4android.client.command.a> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Charset f17123a;

    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ c(Charset charset, int i6, v vVar) {
        this((i6 & 1) != 0 ? Charset.defaultCharset() : charset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void encode(@NotNull ChannelHandlerContext ctx, @NotNull com.bxkj.base.v2.netty4android.client.command.a msg, @NotNull ByteBuf out) throws Exception {
        g0.p(ctx, "ctx");
        g0.p(msg, "msg");
        g0.p(out, "out");
        msg.d("客户端发送数据：");
        out.writeBytes(new byte[]{-52, -52});
        out.writeByte(msg.a());
        out.writeShort(msg.c());
        byte[] bytes = msg.b().getBytes(e.f47851b);
        g0.o(bytes, "getBytes(...)");
        out.writeBytes(bytes);
        b0.a aVar = b0.a.f1020a;
        out.writeShort(a.f17117a.a(n.g3(n.g3(n.g3(new byte[]{-52, -52}, aVar.e(msg.a())), aVar.f((short) msg.c())), bytes)));
    }

    public c(@Nullable Charset charset) {
        if (charset != null) {
            this.f17123a = charset;
            return;
        }
        throw new NullPointerException("charset");
    }
}
