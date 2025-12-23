package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ForceCloseCaptureSession {

    @Nullable
    private final CaptureSessionOnClosedNotCalledQuirk mCaptureSessionOnClosedNotCalledQuirk;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @FunctionalInterface
    public interface OnConfigured {
        void run(@NonNull SynchronizedCaptureSession synchronizedCaptureSession);
    }

    public boolean shouldForceClose() {
        return this.mCaptureSessionOnClosedNotCalledQuirk != null;
    }

    public ForceCloseCaptureSession(@NonNull Quirks quirks) {
        this.mCaptureSessionOnClosedNotCalledQuirk = (CaptureSessionOnClosedNotCalledQuirk) quirks.get(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    private void forceOnClosed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onClosed(synchronizedCaptureSession);
        }
    }

    private void forceOnConfigureFailed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession synchronizedCaptureSession : set) {
            synchronizedCaptureSession.getStateCallback().onConfigureFailed(synchronizedCaptureSession);
        }
    }

    public void onSessionConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull List<SynchronizedCaptureSession> list, @NonNull List<SynchronizedCaptureSession> list2, @NonNull OnConfigured onConfigured) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        if (shouldForceClose()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it = list.iterator();
            while (it.hasNext() && (next2 = it.next()) != synchronizedCaptureSession) {
                linkedHashSet.add(next2);
            }
            forceOnConfigureFailed(linkedHashSet);
        }
        onConfigured.run(synchronizedCaptureSession);
        if (shouldForceClose()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = list2.iterator();
            while (it2.hasNext() && (next = it2.next()) != synchronizedCaptureSession) {
                linkedHashSet2.add(next);
            }
            forceOnClosed(linkedHashSet2);
        }
    }
}
