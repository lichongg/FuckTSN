package io.netty.buffer;

import io.netty.util.ByteProcessor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes7.dex */
public interface ByteBufProcessor extends ByteProcessor {

    @Deprecated
    public static final ByteBufProcessor FIND_NUL = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.1
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 != 0;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_NON_NUL = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.2
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 == 0;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_CR = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.3
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 != 13;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_NON_CR = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.4
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 == 13;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_LF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.5
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 != 10;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_NON_LF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.6
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 == 10;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_CRLF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.7
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return (b6 == 13 || b6 == 10) ? false : true;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_NON_CRLF = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.8
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 == 13 || b6 == 10;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_LINEAR_WHITESPACE = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.9
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return (b6 == 32 || b6 == 9) ? false : true;
        }
    };

    @Deprecated
    public static final ByteBufProcessor FIND_NON_LINEAR_WHITESPACE = new ByteBufProcessor() { // from class: io.netty.buffer.ByteBufProcessor.10
        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b6) throws Exception {
            return b6 == 32 || b6 == 9;
        }
    };
}
