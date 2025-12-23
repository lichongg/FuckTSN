package com.bxkj.base.v2.netty4android.client.handler;

import com.orhanobut.logger.j;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b extends MessageToMessageDecoder<ByteBuf> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Charset f17119a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f17120b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private ByteBuf f17121c;

    /* renamed from: d, reason: collision with root package name */
    private int f17122d;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) {
        decode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public /* synthetic */ b(Charset charset, int i6, v vVar) {
        this((i6 & 1) != 0 ? Charset.defaultCharset() : charset);
    }

    /* renamed from: decode, reason: avoid collision after fix types in other method */
    protected void decode2(@NotNull ChannelHandlerContext ctx, @NotNull ByteBuf msg, @NotNull List<Object> out) throws Exception {
        g0.p(ctx, "ctx");
        g0.p(msg, "msg");
        g0.p(out, "out");
        int readableBytes = msg.readableBytes();
        try {
            ByteBuf byteBuf = this.f17121c;
            if (byteBuf == null) {
                a(msg, readableBytes, ctx, out);
                return;
            }
            g0.m(byteBuf);
            int readableBytes2 = byteBuf.readableBytes();
            int i6 = this.f17122d + 7;
            ByteBuf wrappedBuffer = Unpooled.wrappedBuffer(this.f17121c, msg.readBytes(Math.min(readableBytes, i6 - readableBytes2)));
            this.f17121c = wrappedBuffer;
            g0.m(wrappedBuffer);
            if (wrappedBuffer.readableBytes() == i6) {
                b0.a aVar = b0.a.f1020a;
                ByteBuf byteBuf2 = this.f17121c;
                g0.m(byteBuf2);
                ByteBuf copy = byteBuf2.copy();
                g0.o(copy, "copy(...)");
                aVar.c(copy, "断包合并后的数据：");
                ByteBuf byteBuf3 = this.f17121c;
                g0.m(byteBuf3);
                a(byteBuf3, i6, ctx, out);
                this.f17121c = null;
                this.f17122d = 0;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            msg.resetReaderIndex();
            byte[] bArr = new byte[readableBytes];
            msg.readBytes(bArr);
            j.e(b0.a.f1020a.b(bArr), new Object[0]);
        }
    }

    public b(@Nullable Charset charset) {
        this.f17120b = "";
        if (charset != null) {
            this.f17119a = charset;
            return;
        }
        throw new NullPointerException("charset");
    }

    private final void a(ByteBuf byteBuf, int i6, ChannelHandlerContext channelHandlerContext, List<Object> list) {
        ByteBuf copy = byteBuf.copy();
        byteBuf.readShort();
        byte readByte = byteBuf.readByte();
        int readShort = byteBuf.readShort();
        this.f17122d = readShort;
        if (i6 < readShort + 7) {
            j.d("断包allLength=" + i6 + " length=" + readShort + " 长度不够等待下次数据到来", new Object[0]);
            this.f17121c = copy;
            return;
        }
        byte[] bArr = new byte[readShort];
        byteBuf.readBytes(bArr);
        short readShort2 = byteBuf.readShort();
        b0.a aVar = b0.a.f1020a;
        if (readShort2 != a.f17117a.a(n.g3(n.g3(n.g3(new byte[]{-52, -52}, aVar.e(readByte)), aVar.f((short) this.f17122d)), bArr))) {
            j.e("校验位异常", new Object[0]);
            channelHandlerContext.close();
        }
        list.add(new com.bxkj.base.v2.netty4android.client.command.a(readByte, this.f17122d, new String(bArr, e.f47851b)));
    }
}
