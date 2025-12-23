package androidx.work.impl.constraints.controllers;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.NetworkType;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NetworkUnmeteredController extends ConstraintController<NetworkState> {
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    boolean hasConstraint(@NonNull WorkSpec workSpec) {
        if (workSpec.constraints.getRequiredNetworkType() != NetworkType.UNMETERED) {
            return Build.VERSION.SDK_INT >= 30 && workSpec.constraints.getRequiredNetworkType() == NetworkType.TEMPORARILY_UNMETERED;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isConstrained(@NonNull NetworkState state) {
        return !state.isConnected() || state.isMetered();
    }

    public NetworkUnmeteredController(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).getNetworkStateTracker());
    }
}
