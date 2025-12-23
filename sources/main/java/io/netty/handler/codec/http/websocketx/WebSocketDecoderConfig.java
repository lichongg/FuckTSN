package io.netty.handler.codec.http.websocketx;

import io.netty.util.internal.ObjectUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class WebSocketDecoderConfig {
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private final boolean closeOnProtocolViolation;
    private final boolean expectMaskedFrames;
    private final int maxFramePayloadLength;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: io.netty.handler.codec.http.websocketx.WebSocketDecoderConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private boolean allowExtensions;
        private boolean allowMaskMismatch;
        private boolean closeOnProtocolViolation;
        private boolean expectMaskedFrames;
        private int maxFramePayloadLength;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* synthetic */ Builder(WebSocketDecoderConfig webSocketDecoderConfig, AnonymousClass1 anonymousClass1) {
            this(webSocketDecoderConfig);
        }

        public Builder allowExtensions(boolean z5) {
            this.allowExtensions = z5;
            return this;
        }

        public Builder allowMaskMismatch(boolean z5) {
            this.allowMaskMismatch = z5;
            return this;
        }

        public WebSocketDecoderConfig build() {
            return new WebSocketDecoderConfig(this.maxFramePayloadLength, this.expectMaskedFrames, this.allowMaskMismatch, this.allowExtensions, this.closeOnProtocolViolation, null);
        }

        public Builder closeOnProtocolViolation(boolean z5) {
            this.closeOnProtocolViolation = z5;
            return this;
        }

        public Builder expectMaskedFrames(boolean z5) {
            this.expectMaskedFrames = z5;
            return this;
        }

        public Builder maxFramePayloadLength(int i6) {
            this.maxFramePayloadLength = i6;
            return this;
        }

        private Builder() {
            this.maxFramePayloadLength = 65536;
            this.expectMaskedFrames = true;
            this.closeOnProtocolViolation = true;
        }

        private Builder(WebSocketDecoderConfig webSocketDecoderConfig) {
            this.maxFramePayloadLength = 65536;
            this.expectMaskedFrames = true;
            this.closeOnProtocolViolation = true;
            ObjectUtil.checkNotNull(webSocketDecoderConfig, "decoderConfig");
            this.maxFramePayloadLength = webSocketDecoderConfig.maxFramePayloadLength();
            this.expectMaskedFrames = webSocketDecoderConfig.expectMaskedFrames();
            this.allowMaskMismatch = webSocketDecoderConfig.allowMaskMismatch();
            this.allowExtensions = webSocketDecoderConfig.allowExtensions();
            this.closeOnProtocolViolation = webSocketDecoderConfig.closeOnProtocolViolation();
        }
    }

    /* synthetic */ WebSocketDecoderConfig(int i6, boolean z5, boolean z6, boolean z7, boolean z8, AnonymousClass1 anonymousClass1) {
        this(i6, z5, z6, z7, z8);
    }

    private WebSocketDecoderConfig(int i6, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.maxFramePayloadLength = i6;
        this.expectMaskedFrames = z5;
        this.allowMaskMismatch = z6;
        this.allowExtensions = z7;
        this.closeOnProtocolViolation = z8;
    }

    public static Builder newBuilder() {
        return new Builder((AnonymousClass1) null);
    }

    public boolean allowExtensions() {
        return this.allowExtensions;
    }

    public boolean allowMaskMismatch() {
        return this.allowMaskMismatch;
    }

    public boolean closeOnProtocolViolation() {
        return this.closeOnProtocolViolation;
    }

    public boolean expectMaskedFrames() {
        return this.expectMaskedFrames;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public Builder toBuilder() {
        return new Builder(this, null);
    }

    public String toString() {
        return "WebSocketDecoderConfig [maxFramePayloadLength=" + this.maxFramePayloadLength + ", expectMaskedFrames=" + this.expectMaskedFrames + ", allowMaskMismatch=" + this.allowMaskMismatch + ", allowExtensions=" + this.allowExtensions + ", closeOnProtocolViolation=" + this.closeOnProtocolViolation + "]";
    }
}
