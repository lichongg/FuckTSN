package io.netty.handler.codec.http.multipart;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.AbstractReferenceCounted;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class AbstractHttpData extends AbstractReferenceCounted implements HttpData {
    private boolean completed;
    protected long definedSize;
    private final String name;
    protected long size;
    private static final Pattern STRIP_PATTERN = Pattern.compile("(?:^\\s+|\\s+$|\\n)");
    private static final Pattern REPLACE_PATTERN = Pattern.compile("[\\r\\t]");
    private Charset charset = HttpConstants.DEFAULT_CHARSET;
    private long maxSize = -1;

    protected void setCompleted() {
        this.completed = true;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public abstract HttpData touch();

    @Override // io.netty.util.ReferenceCounted
    public abstract HttpData touch(Object obj);

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void checkSize(long j6) throws IOException {
        long j7 = this.maxSize;
        if (j7 >= 0 && j6 > j7) {
            throw new IOException("Size exceed allowed maximum capacity");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long definedLength() {
        return this.definedSize;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public Charset getCharset() {
        return this.charset;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return this.name;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long length() {
        return this.size;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setCharset(Charset charset) {
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        this.charset = charset;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setMaxSize(long j6) {
        this.maxSize = j6;
    }

    protected AbstractHttpData(String str, Charset charset, long j6) {
        if (str != null) {
            String replaceAll = STRIP_PATTERN.matcher(REPLACE_PATTERN.matcher(str).replaceAll(" ")).replaceAll("");
            if (!replaceAll.isEmpty()) {
                this.name = replaceAll;
                if (charset != null) {
                    setCharset(charset);
                }
                this.definedSize = j6;
                return;
            }
            throw new IllegalArgumentException("empty name");
        }
        throw new NullPointerException(CommonNetImpl.NAME);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        try {
            return getByteBuf();
        } catch (IOException e6) {
            throw new ChannelException(e6);
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        delete();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData retain(int i6) {
        super.retain(i6);
        return this;
    }
}
