package androidx.camera.video;

import android.content.Context;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class PendingRecording {
    private final Context mContext;
    private Consumer<VideoRecordEvent> mEventListener;
    private Executor mListenerExecutor;
    private final OutputOptions mOutputOptions;
    private final Recorder mRecorder;
    private boolean mAudioEnabled = false;
    private boolean mIsPersistent = false;

    @NonNull
    @ExperimentalPersistentRecording
    public PendingRecording asPersistentRecording() {
        this.mIsPersistent = true;
        return this;
    }

    @NonNull
    Context getApplicationContext() {
        return this.mContext;
    }

    @Nullable
    Consumer<VideoRecordEvent> getEventListener() {
        return this.mEventListener;
    }

    @Nullable
    Executor getListenerExecutor() {
        return this.mListenerExecutor;
    }

    @NonNull
    OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    @NonNull
    Recorder getRecorder() {
        return this.mRecorder;
    }

    boolean isAudioEnabled() {
        return this.mAudioEnabled;
    }

    boolean isPersistent() {
        return this.mIsPersistent;
    }

    @NonNull
    @CheckResult
    public Recording start(@NonNull Executor executor, @NonNull Consumer<VideoRecordEvent> consumer) {
        Preconditions.checkNotNull(executor, "Listener Executor can't be null.");
        Preconditions.checkNotNull(consumer, "Event listener can't be null");
        this.mListenerExecutor = executor;
        this.mEventListener = consumer;
        return this.mRecorder.start(this);
    }

    @NonNull
    @RequiresPermission("android.permission.RECORD_AUDIO")
    public PendingRecording withAudioEnabled() {
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
        }
        Preconditions.checkState(this.mRecorder.isAudioSupported(), "The Recorder this recording is associated to doesn't support audio.");
        this.mAudioEnabled = true;
        return this;
    }

    PendingRecording(@NonNull Context context, @NonNull Recorder recorder, @NonNull OutputOptions outputOptions) {
        this.mContext = ContextUtil.getApplicationContext(context);
        this.mRecorder = recorder;
        this.mOutputOptions = outputOptions;
    }
}
