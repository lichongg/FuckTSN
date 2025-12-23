package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class at {
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent a(Context context, int i6, @NonNull Intent intent) {
        return Build.VERSION.SDK_INT >= 23 ? PendingIntent.getBroadcast(context, i6, intent, 201326592) : PendingIntent.getBroadcast(context, i6, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    private static PendingIntent b(Context context, int i6, @NonNull Intent intent) {
        return Build.VERSION.SDK_INT >= 23 ? PendingIntent.getActivity(context, i6, intent, 201326592) : PendingIntent.getActivity(context, i6, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    }

    private static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
    }

    private static Intent j(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra(BaseGmsClient.KEY_PENDING_INTENT, intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    @Nullable
    public static PendingIntent d(Context context, String str, int i6) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i6, launchIntentForPackage);
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static PendingIntent a(Context context, File file, int i6, boolean z5) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri c6 = c(context, file);
        intent.setDataAndType(c6, "application/vnd.android.package-archive");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, c6, 3);
        }
        if (z5) {
            com.kwad.sdk.c.AA();
            if (com.kwad.sdk.c.AD()) {
                intent = j(intent);
            }
        }
        return b(context, i6, intent);
    }
}
