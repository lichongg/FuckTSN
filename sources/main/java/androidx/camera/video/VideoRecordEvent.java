package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class VideoRecordEvent {
    private final OutputOptions mOutputOptions;
    private final RecordingStats mRecordingStats;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class Finalize extends VideoRecordEvent {
        public static final int ERROR_DURATION_LIMIT_REACHED = 9;
        public static final int ERROR_ENCODING_FAILED = 6;
        public static final int ERROR_FILE_SIZE_LIMIT_REACHED = 2;
        public static final int ERROR_INSUFFICIENT_STORAGE = 3;
        public static final int ERROR_INVALID_OUTPUT_OPTIONS = 5;
        public static final int ERROR_NONE = 0;
        public static final int ERROR_NO_VALID_DATA = 8;
        public static final int ERROR_RECORDER_ERROR = 7;
        public static final int ERROR_RECORDING_GARBAGE_COLLECTED = 10;
        public static final int ERROR_SOURCE_INACTIVE = 4;
        public static final int ERROR_UNKNOWN = 1;
        private final Throwable mCause;
        private final int mError;
        private final OutputResults mOutputResults;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface VideoRecordError {
        }

        @Nullable
        public Throwable getCause() {
            return this.mCause;
        }

        public int getError() {
            return this.mError;
        }

        @NonNull
        public OutputResults getOutputResults() {
            return this.mOutputResults;
        }

        public boolean hasError() {
            return this.mError != 0;
        }

        Finalize(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats, @NonNull OutputResults outputResults, int i6, @Nullable Throwable th) {
            super(outputOptions, recordingStats);
            this.mOutputResults = outputResults;
            this.mError = i6;
            this.mCause = th;
        }

        @NonNull
        static String errorToString(int i6) {
            switch (i6) {
                case 0:
                    return "ERROR_NONE";
                case 1:
                    return "ERROR_UNKNOWN";
                case 2:
                    return "ERROR_FILE_SIZE_LIMIT_REACHED";
                case 3:
                    return "ERROR_INSUFFICIENT_STORAGE";
                case 4:
                    return "ERROR_SOURCE_INACTIVE";
                case 5:
                    return "ERROR_INVALID_OUTPUT_OPTIONS";
                case 6:
                    return "ERROR_ENCODING_FAILED";
                case 7:
                    return "ERROR_RECORDER_ERROR";
                case 8:
                    return "ERROR_NO_VALID_DATA";
                case 9:
                    return "ERROR_DURATION_LIMIT_REACHED";
                case 10:
                    return "ERROR_RECORDING_GARBAGE_COLLECTED";
                default:
                    return "Unknown(" + i6 + ")";
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class Pause extends VideoRecordEvent {
        Pause(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class Resume extends VideoRecordEvent {
        Resume(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class Start extends VideoRecordEvent {
        Start(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class Status extends VideoRecordEvent {
        Status(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
            super(outputOptions, recordingStats);
        }
    }

    @NonNull
    static Finalize finalize(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats, @NonNull OutputResults outputResults) {
        return new Finalize(outputOptions, recordingStats, outputResults, 0, null);
    }

    @NonNull
    static Finalize finalizeWithError(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats, @NonNull OutputResults outputResults, int i6, @Nullable Throwable th) {
        Preconditions.checkArgument(i6 != 0, "An error type is required.");
        return new Finalize(outputOptions, recordingStats, outputResults, i6, th);
    }

    @NonNull
    static Pause pause(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
        return new Pause(outputOptions, recordingStats);
    }

    @NonNull
    static Resume resume(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
        return new Resume(outputOptions, recordingStats);
    }

    @NonNull
    static Start start(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
        return new Start(outputOptions, recordingStats);
    }

    @NonNull
    static Status status(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
        return new Status(outputOptions, recordingStats);
    }

    @NonNull
    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    @NonNull
    public RecordingStats getRecordingStats() {
        return this.mRecordingStats;
    }

    VideoRecordEvent(@NonNull OutputOptions outputOptions, @NonNull RecordingStats recordingStats) {
        this.mOutputOptions = (OutputOptions) Preconditions.checkNotNull(outputOptions);
        this.mRecordingStats = (RecordingStats) Preconditions.checkNotNull(recordingStats);
    }
}
