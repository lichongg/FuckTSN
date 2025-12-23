package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class AsciiHeadersEncoder {
    private final ByteBuf buf;
    private final NewlineType newlineType;
    private final SeparatorType separatorType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum NewlineType {
        LF,
        CRLF
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SeparatorType {
        COLON,
        COLON_SPACE
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf) {
        this(byteBuf, SeparatorType.COLON_SPACE, NewlineType.CRLF);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.AsciiHeadersEncoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType;

        static {
            int[] iArr = new int[NewlineType.values().length];
            $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType = iArr;
            try {
                iArr[NewlineType.LF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[NewlineType.CRLF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[SeparatorType.values().length];
            $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType = iArr2;
            try {
                iArr2[SeparatorType.COLON.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[SeparatorType.COLON_SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AsciiHeadersEncoder(ByteBuf byteBuf, SeparatorType separatorType, NewlineType newlineType) {
        if (byteBuf == null) {
            throw new NullPointerException("buf");
        }
        if (separatorType == null) {
            throw new NullPointerException("separatorType");
        }
        if (newlineType == null) {
            throw new NullPointerException("newlineType");
        }
        this.buf = byteBuf;
        this.separatorType = separatorType;
        this.newlineType = newlineType;
    }

    private static void writeAscii(ByteBuf byteBuf, int i6, CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            ByteBufUtil.copy((AsciiString) charSequence, 0, byteBuf, i6, charSequence.length());
        } else {
            byteBuf.setCharSequence(i6, charSequence, CharsetUtil.US_ASCII);
        }
    }

    public void encode(Map.Entry<CharSequence, CharSequence> entry) {
        int i6;
        int i7;
        CharSequence key = entry.getKey();
        CharSequence value = entry.getValue();
        ByteBuf byteBuf = this.buf;
        int length = key.length();
        int length2 = value.length();
        int writerIndex = byteBuf.writerIndex();
        byteBuf.ensureWritable(length + length2 + 4);
        writeAscii(byteBuf, writerIndex, key);
        int i8 = writerIndex + length;
        int i9 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[this.separatorType.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                int i10 = i8 + 1;
                byteBuf.setByte(i8, 58);
                i6 = i8 + 2;
                byteBuf.setByte(i10, 32);
            } else {
                throw new Error();
            }
        } else {
            byteBuf.setByte(i8, 58);
            i6 = i8 + 1;
        }
        writeAscii(byteBuf, i6, value);
        int i11 = i6 + length2;
        int i12 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[this.newlineType.ordinal()];
        if (i12 != 1) {
            if (i12 == 2) {
                int i13 = i11 + 1;
                byteBuf.setByte(i11, 13);
                i7 = i11 + 2;
                byteBuf.setByte(i13, 10);
            } else {
                throw new Error();
            }
        } else {
            byteBuf.setByte(i11, 10);
            i7 = i11 + 1;
        }
        byteBuf.writerIndex(i7);
    }
}
