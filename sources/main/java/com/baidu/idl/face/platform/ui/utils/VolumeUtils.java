package com.baidu.idl.face.platform.ui.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class VolumeUtils {
    public static final String TAG = "VolumeUtils";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface VolumeCallback {
        void volumeChanged();
    }

    public static BroadcastReceiver registerVolumeReceiver(Context context, VolumeCallback volumeCallback) {
        VolumeReceiver volumeReceiver = null;
        try {
            VolumeReceiver volumeReceiver2 = new VolumeReceiver(volumeCallback);
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                context.registerReceiver(volumeReceiver2, intentFilter);
                return volumeReceiver2;
            } catch (IllegalArgumentException e6) {
                e = e6;
                volumeReceiver = volumeReceiver2;
                e.printStackTrace();
                return volumeReceiver;
            } catch (Exception e7) {
                e = e7;
                volumeReceiver = volumeReceiver2;
                e.printStackTrace();
                return volumeReceiver;
            }
        } catch (IllegalArgumentException e8) {
            e = e8;
        } catch (Exception e9) {
            e = e9;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class VolumeReceiver extends BroadcastReceiver {
        private VolumeCallback callback;

        public VolumeReceiver(VolumeCallback volumeCallback) {
            this.callback = volumeCallback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VolumeCallback volumeCallback;
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && (volumeCallback = this.callback) != null) {
                String str = VolumeUtils.TAG;
                volumeCallback.volumeChanged();
            }
        }
    }

    public static void unRegisterVolumeReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context == null || broadcastReceiver == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }
}
