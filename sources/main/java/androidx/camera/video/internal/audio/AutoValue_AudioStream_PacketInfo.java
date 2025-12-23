package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_AudioStream_PacketInfo extends AudioStream.PacketInfo {
    private final int sizeInBytes;
    private final long timestampNs;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioStream.PacketInfo) {
            AudioStream.PacketInfo packetInfo = (AudioStream.PacketInfo) obj;
            if (this.sizeInBytes == packetInfo.getSizeInBytes() && this.timestampNs == packetInfo.getTimestampNs()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public int getSizeInBytes() {
        return this.sizeInBytes;
    }

    @Override // androidx.camera.video.internal.audio.AudioStream.PacketInfo
    public long getTimestampNs() {
        return this.timestampNs;
    }

    public int hashCode() {
        int i6 = (this.sizeInBytes ^ 1000003) * 1000003;
        long j6 = this.timestampNs;
        return i6 ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public String toString() {
        return "PacketInfo{sizeInBytes=" + this.sizeInBytes + ", timestampNs=" + this.timestampNs + "}";
    }

    AutoValue_AudioStream_PacketInfo(int i6, long j6) {
        this.sizeInBytes = i6;
        this.timestampNs = j6;
    }
}
