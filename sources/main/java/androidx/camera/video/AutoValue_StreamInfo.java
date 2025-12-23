package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.StreamInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_StreamInfo extends StreamInfo {
    private final int id;
    private final SurfaceRequest.TransformationInfo inProgressTransformationInfo;
    private final StreamInfo.StreamState streamState;

    public boolean equals(Object obj) {
        SurfaceRequest.TransformationInfo transformationInfo;
        if (obj == this) {
            return true;
        }
        if (obj instanceof StreamInfo) {
            StreamInfo streamInfo = (StreamInfo) obj;
            if (this.id == streamInfo.getId() && this.streamState.equals(streamInfo.getStreamState()) && ((transformationInfo = this.inProgressTransformationInfo) != null ? transformationInfo.equals(streamInfo.getInProgressTransformationInfo()) : streamInfo.getInProgressTransformationInfo() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.StreamInfo
    public int getId() {
        return this.id;
    }

    @Override // androidx.camera.video.StreamInfo
    @Nullable
    public SurfaceRequest.TransformationInfo getInProgressTransformationInfo() {
        return this.inProgressTransformationInfo;
    }

    @Override // androidx.camera.video.StreamInfo
    @NonNull
    public StreamInfo.StreamState getStreamState() {
        return this.streamState;
    }

    public int hashCode() {
        int hashCode = (((this.id ^ 1000003) * 1000003) ^ this.streamState.hashCode()) * 1000003;
        SurfaceRequest.TransformationInfo transformationInfo = this.inProgressTransformationInfo;
        return hashCode ^ (transformationInfo == null ? 0 : transformationInfo.hashCode());
    }

    public String toString() {
        return "StreamInfo{id=" + this.id + ", streamState=" + this.streamState + ", inProgressTransformationInfo=" + this.inProgressTransformationInfo + "}";
    }

    AutoValue_StreamInfo(int i6, StreamInfo.StreamState streamState, @Nullable SurfaceRequest.TransformationInfo transformationInfo) {
        this.id = i6;
        if (streamState != null) {
            this.streamState = streamState;
            this.inProgressTransformationInfo = transformationInfo;
            return;
        }
        throw new NullPointerException("Null streamState");
    }
}
