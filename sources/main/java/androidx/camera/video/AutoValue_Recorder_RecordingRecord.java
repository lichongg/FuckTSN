package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_Recorder_RecordingRecord extends Recorder.RecordingRecord {
    private final Executor getCallbackExecutor;
    private final Consumer<VideoRecordEvent> getEventListener;
    private final OutputOptions getOutputOptions;
    private final long getRecordingId;
    private final boolean hasAudioEnabled;
    private final boolean isPersistent;

    public boolean equals(Object obj) {
        Executor executor;
        Consumer<VideoRecordEvent> consumer;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Recorder.RecordingRecord) {
            Recorder.RecordingRecord recordingRecord = (Recorder.RecordingRecord) obj;
            if (this.getOutputOptions.equals(recordingRecord.getOutputOptions()) && ((executor = this.getCallbackExecutor) != null ? executor.equals(recordingRecord.getCallbackExecutor()) : recordingRecord.getCallbackExecutor() == null) && ((consumer = this.getEventListener) != null ? consumer.equals(recordingRecord.getEventListener()) : recordingRecord.getEventListener() == null) && this.hasAudioEnabled == recordingRecord.hasAudioEnabled() && this.isPersistent == recordingRecord.isPersistent() && this.getRecordingId == recordingRecord.getRecordingId()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    @Nullable
    Executor getCallbackExecutor() {
        return this.getCallbackExecutor;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    @Nullable
    Consumer<VideoRecordEvent> getEventListener() {
        return this.getEventListener;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    @NonNull
    OutputOptions getOutputOptions() {
        return this.getOutputOptions;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    long getRecordingId() {
        return this.getRecordingId;
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    boolean hasAudioEnabled() {
        return this.hasAudioEnabled;
    }

    public int hashCode() {
        int hashCode = (this.getOutputOptions.hashCode() ^ 1000003) * 1000003;
        Executor executor = this.getCallbackExecutor;
        int hashCode2 = (hashCode ^ (executor == null ? 0 : executor.hashCode())) * 1000003;
        Consumer<VideoRecordEvent> consumer = this.getEventListener;
        int hashCode3 = (((hashCode2 ^ (consumer != null ? consumer.hashCode() : 0)) * 1000003) ^ (this.hasAudioEnabled ? 1231 : 1237)) * 1000003;
        int i6 = this.isPersistent ? 1231 : 1237;
        long j6 = this.getRecordingId;
        return ((hashCode3 ^ i6) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    @Override // androidx.camera.video.Recorder.RecordingRecord
    boolean isPersistent() {
        return this.isPersistent;
    }

    public String toString() {
        return "RecordingRecord{getOutputOptions=" + this.getOutputOptions + ", getCallbackExecutor=" + this.getCallbackExecutor + ", getEventListener=" + this.getEventListener + ", hasAudioEnabled=" + this.hasAudioEnabled + ", isPersistent=" + this.isPersistent + ", getRecordingId=" + this.getRecordingId + "}";
    }

    AutoValue_Recorder_RecordingRecord(OutputOptions outputOptions, @Nullable Executor executor, @Nullable Consumer<VideoRecordEvent> consumer, boolean z5, boolean z6, long j6) {
        if (outputOptions != null) {
            this.getOutputOptions = outputOptions;
            this.getCallbackExecutor = executor;
            this.getEventListener = consumer;
            this.hasAudioEnabled = z5;
            this.isPersistent = z6;
            this.getRecordingId = j6;
            return;
        }
        throw new NullPointerException("Null getOutputOptions");
    }
}
