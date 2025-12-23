package com.bxkj.student.v2.ai.fitness.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.bxkj.student.R;
import com.bxkj.student.v2.ai.fitness.camera.c;
import com.google.android.gms.common.images.Size;
import com.google.common.base.Preconditions;
import com.google.mlkit.vision.pose.PoseDetectorOptionsBase;
import com.google.mlkit.vision.pose.defaults.PoseDetectorOptions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f20631a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f20632b = 2;

    @Nullable
    public static c.C0275c a(Context context, int cameraId) {
        String string;
        String string2;
        boolean z5 = true;
        if (cameraId != 0 && cameraId != 1) {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        if (cameraId == 0) {
            string = context.getString(R.string.pref_key_rear_camera_preview_size);
            string2 = context.getString(R.string.pref_key_rear_camera_picture_size);
        } else {
            string = context.getString(R.string.pref_key_front_camera_preview_size);
            string2 = context.getString(R.string.pref_key_front_camera_picture_size);
        }
        try {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            return new c.C0275c(Size.parseSize(defaultSharedPreferences.getString(string, null)), Size.parseSize(defaultSharedPreferences.getString(string2, null)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static PoseDetectorOptionsBase c(Context context) {
        PoseDetectorOptions.Builder detectorMode = new PoseDetectorOptions.Builder().setDetectorMode(1);
        if (e(context)) {
            detectorMode.setPreferredHardwareConfigs(2, new int[0]);
        }
        return detectorMode.build();
    }

    private a() {
    }

    private static int b(Context context, @StringRes int prefKeyResId, int defaultValue) {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString(context.getString(prefKeyResId), String.valueOf(defaultValue)));
    }

    public static boolean d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.pref_key_camera_live_viewport), false);
    }

    public static boolean e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.pref_key_pose_detector_prefer_gpu), true);
    }

    static void f(Context context, @StringRes int prefKeyId, @Nullable String value) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(context.getString(prefKeyId), value).apply();
    }

    public static boolean g(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context);
        context.getString(R.string.pref_key_info_hide);
        return true;
    }

    public static boolean h(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.pref_key_pose_detector_rescale_z), true);
    }

    public static boolean i(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(R.string.pref_key_pose_detector_visualize_z), true);
    }

    public static boolean j(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context);
        context.getString(R.string.pref_key_live_preview_pose_detector_show_in_frame_likelihood);
        return false;
    }
}
