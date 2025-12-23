package io.netty.handler.codec.http2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class Http2Flags {
    public static final short ACK = 1;
    public static final short END_HEADERS = 4;
    public static final short END_STREAM = 1;
    public static final short PADDED = 8;
    public static final short PRIORITY = 32;
    private short value;

    public Http2Flags() {
    }

    public boolean ack() {
        return isFlagSet((short) 1);
    }

    public boolean endOfHeaders() {
        return isFlagSet((short) 4);
    }

    public boolean endOfStream() {
        return isFlagSet((short) 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Http2Flags.class == obj.getClass() && this.value == ((Http2Flags) obj).value;
    }

    public boolean paddingPresent() {
        return isFlagSet((short) 8);
    }

    public boolean priorityPresent() {
        return isFlagSet((short) 32);
    }

    public Http2Flags(short s5) {
        this.value = s5;
    }

    public Http2Flags ack(boolean z5) {
        return setFlag(z5, (short) 1);
    }

    public Http2Flags endOfHeaders(boolean z5) {
        return setFlag(z5, (short) 4);
    }

    public Http2Flags endOfStream(boolean z5) {
        return setFlag(z5, (short) 1);
    }

    public int hashCode() {
        return 31 + this.value;
    }

    public boolean isFlagSet(short s5) {
        return (s5 & this.value) != 0;
    }

    public Http2Flags paddingPresent(boolean z5) {
        return setFlag(z5, (short) 8);
    }

    public Http2Flags priorityPresent(boolean z5) {
        return setFlag(z5, (short) 32);
    }

    public Http2Flags setFlag(boolean z5, short s5) {
        if (z5) {
            this.value = (short) (this.value | s5);
            return this;
        }
        this.value = (short) (this.value & (~s5));
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("value = ");
        sb.append((int) this.value);
        sb.append(" (");
        if (ack()) {
            sb.append("ACK,");
        }
        if (endOfHeaders()) {
            sb.append("END_OF_HEADERS,");
        }
        if (endOfStream()) {
            sb.append("END_OF_STREAM,");
        }
        if (priorityPresent()) {
            sb.append("PRIORITY_PRESENT,");
        }
        if (paddingPresent()) {
            sb.append("PADDING_PRESENT,");
        }
        sb.append(')');
        return sb.toString();
    }

    public short value() {
        return this.value;
    }

    public int getNumPriorityBytes() {
        if (priorityPresent()) {
            return 5;
        }
        return 0;
    }

    public int getPaddingPresenceFieldLength() {
        return paddingPresent() ? 1 : 0;
    }
}
