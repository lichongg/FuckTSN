package io.netty.handler.codec;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class ProtocolDetectionResult<T> {
    private final T result;
    private final ProtocolDetectionState state;
    private static final ProtocolDetectionResult NEEDS_MORE_DATE = new ProtocolDetectionResult(ProtocolDetectionState.NEEDS_MORE_DATA, null);
    private static final ProtocolDetectionResult INVALID = new ProtocolDetectionResult(ProtocolDetectionState.INVALID, null);

    public static <T> ProtocolDetectionResult<T> detected(T t5) {
        return new ProtocolDetectionResult<>(ProtocolDetectionState.DETECTED, ObjectUtil.checkNotNull(t5, "protocol"));
    }

    public static <T> ProtocolDetectionResult<T> invalid() {
        return INVALID;
    }

    public static <T> ProtocolDetectionResult<T> needsMoreData() {
        return NEEDS_MORE_DATE;
    }

    public T detectedProtocol() {
        return this.result;
    }

    public ProtocolDetectionState state() {
        return this.state;
    }

    private ProtocolDetectionResult(ProtocolDetectionState protocolDetectionState, T t5) {
        this.state = protocolDetectionState;
        this.result = t5;
    }
}
