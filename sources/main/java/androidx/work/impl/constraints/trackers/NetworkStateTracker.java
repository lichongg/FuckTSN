package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class NetworkStateTracker extends ConstraintTracker<NetworkState> {
    static final String TAG = Logger.tagWithPrefix("NetworkStateTracker");
    private NetworkStateBroadcastReceiver mBroadcastReceiver;
    private final ConnectivityManager mConnectivityManager;

    @RequiresApi(24)
    private NetworkStateCallback mNetworkCallback;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class NetworkStateBroadcastReceiver extends BroadcastReceiver {
        NetworkStateBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            Logger.get().debug(NetworkStateTracker.TAG, "Network broadcast received", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    private class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        NetworkStateCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities capabilities) {
            Logger.get().debug(NetworkStateTracker.TAG, String.format("Network capabilities changed: %s", capabilities), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            Logger.get().debug(NetworkStateTracker.TAG, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.setState(networkStateTracker.getActiveNetworkState());
        }
    }

    private static boolean isNetworkCallbackSupported() {
        return Build.VERSION.SDK_INT >= 24;
    }

    NetworkState getActiveNetworkState() {
        NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        boolean z5 = false;
        boolean z6 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean isActiveNetworkValidated = isActiveNetworkValidated();
        boolean isActiveNetworkMetered = ConnectivityManagerCompat.isActiveNetworkMetered(this.mConnectivityManager);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z5 = true;
        }
        return new NetworkState(z6, isActiveNetworkValidated, isActiveNetworkMetered, z5);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState getInitialState() {
        return getActiveNetworkState();
    }

    @VisibleForTesting
    boolean isActiveNetworkValidated() {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            activeNetwork = this.mConnectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = this.mConnectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e6) {
            Logger.get().error(TAG, "Unable to validate active network", e6);
            return false;
        }
    }

    public NetworkStateTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.mConnectivityManager = (ConnectivityManager) this.mAppContext.getSystemService("connectivity");
        if (isNetworkCallbackSupported()) {
            this.mNetworkCallback = new NetworkStateCallback();
        } else {
            this.mBroadcastReceiver = new NetworkStateBroadcastReceiver();
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(TAG, "Registering network callback", new Throwable[0]);
                this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
                return;
            } catch (IllegalArgumentException | SecurityException e6) {
                Logger.get().error(TAG, "Received exception while registering network callback", e6);
                return;
            }
        }
        Logger.get().debug(TAG, "Registering broadcast receiver", new Throwable[0]);
        this.mAppContext.registerReceiver(this.mBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        if (isNetworkCallbackSupported()) {
            try {
                Logger.get().debug(TAG, "Unregistering network callback", new Throwable[0]);
                this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
                return;
            } catch (IllegalArgumentException | SecurityException e6) {
                Logger.get().error(TAG, "Received exception while unregistering network callback", e6);
                return;
            }
        }
        Logger.get().debug(TAG, "Unregistering broadcast receiver", new Throwable[0]);
        this.mAppContext.unregisterReceiver(this.mBroadcastReceiver);
    }
}
