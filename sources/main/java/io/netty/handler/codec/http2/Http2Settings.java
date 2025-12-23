package io.netty.handler.codec.http2;

import io.netty.util.collection.CharObjectHashMap;
import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Http2Settings extends CharObjectHashMap<Long> {
    private static final int DEFAULT_CAPACITY = 13;
    private static final Long FALSE = 0L;
    private static final Long TRUE = 1L;

    public Http2Settings() {
        this(13);
    }

    public Long headerTableSize() {
        return get((char) 1);
    }

    public Integer initialWindowSize() {
        return getIntValue((char) 4);
    }

    public Long maxConcurrentStreams() {
        return get((char) 3);
    }

    public Integer maxFrameSize() {
        return getIntValue((char) 5);
    }

    public Long maxHeaderListSize() {
        return get((char) 6);
    }

    public Boolean pushEnabled() {
        Long l6 = get((char) 2);
        if (l6 == null) {
            return null;
        }
        return Boolean.valueOf(TRUE.equals(l6));
    }

    public Http2Settings(int i6, float f6) {
        super(i6, f6);
    }

    public static Http2Settings defaultSettings() {
        return new Http2Settings().maxHeaderListSize(8192L);
    }

    private static void verifyStandardSetting(int i6, Long l6) {
        ObjectUtil.checkNotNull(l6, "value");
        switch (i6) {
            case 1:
                if (l6.longValue() < 0 || l6.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting HEADER_TABLE_SIZE is invalid: " + l6);
                }
                return;
            case 2:
                if (l6.longValue() == 0 || l6.longValue() == 1) {
                    return;
                }
                throw new IllegalArgumentException("Setting ENABLE_PUSH is invalid: " + l6);
            case 3:
                if (l6.longValue() < 0 || l6.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting MAX_CONCURRENT_STREAMS is invalid: " + l6);
                }
                return;
            case 4:
                if (l6.longValue() < 0 || l6.longValue() > 2147483647L) {
                    throw new IllegalArgumentException("Setting INITIAL_WINDOW_SIZE is invalid: " + l6);
                }
                return;
            case 5:
                if (Http2CodecUtil.isMaxFrameSizeValid(l6.intValue())) {
                    return;
                }
                throw new IllegalArgumentException("Setting MAX_FRAME_SIZE is invalid: " + l6);
            case 6:
                if (l6.longValue() < 0 || l6.longValue() > 4294967295L) {
                    throw new IllegalArgumentException("Setting MAX_HEADER_LIST_SIZE is invalid: " + l6);
                }
                return;
            default:
                return;
        }
    }

    public Http2Settings headerTableSize(long j6) {
        put((char) 1, Long.valueOf(j6));
        return this;
    }

    public Http2Settings initialWindowSize(int i6) {
        put((char) 4, Long.valueOf(i6));
        return this;
    }

    public Http2Settings maxConcurrentStreams(long j6) {
        put((char) 3, Long.valueOf(j6));
        return this;
    }

    public Http2Settings maxFrameSize(int i6) {
        put((char) 5, Long.valueOf(i6));
        return this;
    }

    public Http2Settings maxHeaderListSize(long j6) {
        put((char) 6, Long.valueOf(j6));
        return this;
    }

    @Override // io.netty.util.collection.CharObjectHashMap, io.netty.util.collection.CharObjectMap
    public Long put(char c6, Long l6) {
        verifyStandardSetting(c6, l6);
        return (Long) super.put(c6, (char) l6);
    }

    public Http2Settings(int i6) {
        super(i6);
    }

    public Http2Settings copyFrom(Http2Settings http2Settings) {
        clear();
        putAll(http2Settings);
        return this;
    }

    public Integer getIntValue(char c6) {
        Long l6 = get(c6);
        if (l6 == null) {
            return null;
        }
        return Integer.valueOf(l6.intValue());
    }

    @Override // io.netty.util.collection.CharObjectHashMap
    protected String keyToString(char c6) {
        switch (c6) {
            case 1:
                return "HEADER_TABLE_SIZE";
            case 2:
                return "ENABLE_PUSH";
            case 3:
                return "MAX_CONCURRENT_STREAMS";
            case 4:
                return "INITIAL_WINDOW_SIZE";
            case 5:
                return "MAX_FRAME_SIZE";
            case 6:
                return "MAX_HEADER_LIST_SIZE";
            default:
                return super.keyToString(c6);
        }
    }

    public Http2Settings pushEnabled(boolean z5) {
        put((char) 2, z5 ? TRUE : FALSE);
        return this;
    }
}
