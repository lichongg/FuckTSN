package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import cn.jiguang.bz.c0;
import com.amap.api.location.AMapLocationClient;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.student.R;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.ui.sports.v3.V4SportActivity;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f22009a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f22010b = 100;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final String f22011c = "my_channel_02";

    /* renamed from: d, reason: collision with root package name */
    private static final int f22012d = 101;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        public static /* synthetic */ void h(a aVar, Context context, String str, boolean z5, int i6, Object obj) {
            if ((i6 & 4) != 0) {
                z5 = false;
            }
            aVar.g(context, str, z5);
        }

        private final void i(Context context) {
            Object systemService = context.getSystemService("power");
            g0.n(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager powerManager = (PowerManager) systemService;
            if (powerManager.isInteractive()) {
                return;
            }
            powerManager.newWakeLock(268435462, "tsnApp:notificationLock").acquire(3000L);
        }

        public final void a(@NotNull Context context) {
            g0.p(context, "context");
            i(context);
        }

        public final void b(@NotNull Context context) {
            g0.p(context, "context");
            Object systemService = context.getSystemService("notification");
            g0.n(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            notificationManager.cancel(100);
            notificationManager.cancelAll();
        }

        public final void c(@NotNull Context context) {
            g0.p(context, "context");
            Object systemService = context.getSystemService("notification");
            g0.n(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).cancel(101);
        }

        public final void d(@NotNull Service service, @Nullable AMapLocationClient aMapLocationClient) {
            g0.p(service, "service");
            Object systemService = service.getSystemService("notification");
            g0.n(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationCompat.Builder ongoing = new NotificationCompat.Builder(service, l.f22011c).setSmallIcon(2131689689).setPriority(1).setOnlyAlertOnce(true).setDefaults(64).setAutoCancel(false).setOngoing(true);
            g0.o(ongoing, "setOngoing(...)");
            if (Build.VERSION.SDK_INT >= 26) {
                String string = service.getString(2131951695);
                g0.o(string, "getString(...)");
                NotificationChannel a6 = c0.a(l.f22011c, string, 4);
                a6.setDescription("正在记录本次跑步");
                a6.enableLights(true);
                a6.setLightColor(SupportMenu.CATEGORY_MASK);
                a6.setLockscreenVisibility(1);
                a6.setSound(null, null);
                notificationManager.createNotificationChannel(a6);
                ongoing.setChannelId(l.f22011c);
            }
            RemoteViews remoteViews = new RemoteViews(service.getPackageName(), R.layout.v3_notification_app_sports);
            i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
            remoteViews.setTextViewText(2131298881, com.bxkj.student.run.app.utils.i.c(aVar.g()));
            int i6 = com.bxkj.base.v2.common.utils.c0.f16887a.k(aVar.B(), "runType") == 5 ? 8 : 0;
            remoteViews.setViewVisibility(R.id.ll_distance, i6);
            remoteViews.setViewVisibility(R.id.tv_unit, i6);
            remoteViews.setViewVisibility(2131299117, i6);
            remoteViews.setTextViewText(2131299158, com.bxkj.student.run.app.utils.i.g(aVar.e()));
            remoteViews.setTextViewText(2131299117, String.valueOf(aVar.G()));
            ongoing.setCustomContentView(remoteViews);
            ongoing.setCustomBigContentView(remoteViews);
            ongoing.setVisibility(1);
            ongoing.setContentIntent(PendingIntent.getActivity(service, 1, new Intent(service, (Class<?>) V4SportActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH));
            Notification build = ongoing.build();
            g0.o(build, "build(...)");
            service.startForeground(100, build);
            if (aMapLocationClient != null) {
                aMapLocationClient.enableBackgroundLocation(100, build);
            }
        }

        public final void e(@NotNull Context context, @NotNull String title, @NotNull String longText) {
            g0.p(context, "context");
            g0.p(title, "title");
            g0.p(longText, "longText");
            Object systemService = context.getSystemService("notification");
            g0.n(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(context, l.f22011c).setSmallIcon(2131689689).setContentTitle(title).setContentText(longText).setStyle(new NotificationCompat.BigTextStyle().bigText(longText)).setPriority(0).setColor(ContextCompat.getColor(context, 2131099718)).setAutoCancel(true);
            g0.o(autoCancel, "setAutoCancel(...)");
            autoCancel.setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) V4SportActivity.class), 201326592));
            if (Build.VERSION.SDK_INT >= 26) {
                autoCancel.setChannelId(l.f22011c);
            }
            notificationManager.notify(101, autoCancel.build());
        }

        public final void f(@NotNull Context context) {
            g0.p(context, "context");
            h(this, context, "", false, 4, null);
        }

        public final void g(@NotNull Context context, @NotNull String msg, boolean z5) {
            g0.p(context, "context");
            g0.p(msg, "msg");
            NotificationCompat.Builder ongoing = new NotificationCompat.Builder(context, l.f22011c).setSmallIcon(2131689689).setWhen(System.currentTimeMillis()).setPriority(1).setOnlyAlertOnce(!z5).setDefaults(64).setAutoCancel(false).setOngoing(true);
            g0.o(ongoing, "setOngoing(...)");
            Object systemService = context.getSystemService("notification");
            g0.n(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (Build.VERSION.SDK_INT >= 26) {
                ongoing.setChannelId(l.f22011c);
            }
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.v3_notification_app_sports);
            i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
            remoteViews.setTextViewText(2131298881, com.bxkj.student.run.app.utils.i.c(aVar.g()));
            remoteViews.setTextViewText(2131299158, com.bxkj.student.run.app.utils.i.g(aVar.e()));
            remoteViews.setTextViewText(2131299117, String.valueOf(aVar.G()));
            if (msg.length() != 0) {
                i(context);
                remoteViews.setTextViewText(R.id.tv_app, msg);
                remoteViews.setTextColor(R.id.tv_app, ContextCompat.getColor(context, 2131099718));
            } else if (aVar.i() == 0.0d) {
                remoteViews.setTextViewText(R.id.tv_app, "体适能正在记录本次跑步");
                remoteViews.setTextColor(R.id.tv_app, ContextCompat.getColor(context, 2131099731));
            } else {
                String str = "请在" + ((int) (com.bxkj.base.v2.common.utils.c0.f16887a.f(aVar.B(), "faceDistanceOut") * 1000)) + "米范围内进行人脸识别！";
                i(context);
                remoteViews.setTextViewText(R.id.tv_app, str);
                remoteViews.setTextColor(R.id.tv_app, ContextCompat.getColor(context, 2131099718));
            }
            int i6 = com.bxkj.base.v2.common.utils.c0.f16887a.k(aVar.B(), "runType") == 5 ? 8 : 0;
            remoteViews.setViewVisibility(R.id.ll_distance, i6);
            remoteViews.setViewVisibility(R.id.tv_unit, i6);
            remoteViews.setViewVisibility(2131299117, i6);
            ongoing.setCustomContentView(remoteViews);
            ongoing.setCustomBigContentView(remoteViews);
            ongoing.setVisibility(1);
            ongoing.setContentIntent(PendingIntent.getActivity(context, 1, new Intent(context, (Class<?>) V4SportActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH));
            Notification build = ongoing.build();
            g0.o(build, "build(...)");
            notificationManager.notify(100, build);
        }
    }
}
