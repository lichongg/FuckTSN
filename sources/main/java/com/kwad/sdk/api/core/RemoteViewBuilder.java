package com.kwad.sdk.api.core;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.Keep;
import com.autonavi.amap.mapcore.AMapEngineUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsAdSdkDynamicApi
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class RemoteViewBuilder {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.api.core.RemoteViewBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class CompletedRemoteViewImpl implements ICompletedRemoteView {
        private final Context mContext;
        private final Context mOriginContext;
        private final RemoteViews mRemoteViews;

        /* synthetic */ CompletedRemoteViewImpl(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(Bitmap bitmap) {
            this.mRemoteViews.setImageViewBitmap(ApiResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CompletedRemoteViewImpl(Context context) {
            this.mContext = context;
            if (context instanceof ResContext) {
                this.mOriginContext = ((ResContext) context).getDelegatedContext();
            } else {
                this.mOriginContext = context;
            }
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ApiResUtil.getLayoutId(this.mOriginContext, "ksad_notification_download_completed"));
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public RemoteViews build() {
            return this.mRemoteViews;
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setIcon(int i6) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i6));
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setInstallText(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_install"), str);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setName(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_name"), str);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setSize(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_size"), str);
        }

        @Override // com.kwad.sdk.api.core.ICompletedRemoteView
        public void setStatus(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_status"), str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class ProgressRemoteViewImpl implements IProgressRemoteView {
        private static final String ACTION_CLICK_CONTROL_BTN = "com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN";
        private static final String KEY_TASKID = "taskId";
        private int btnControlId;
        private int btnTextColorChecked;
        private int btnTextColorUnchecked;
        private int downloadTaskId;
        private final Context mContext;
        private final Context mOriginContext;
        private final RemoteViews mRemoteViews;

        /* synthetic */ ProgressRemoteViewImpl(Context context, int i6, boolean z5, AnonymousClass1 anonymousClass1) {
            this(context, i6, z5);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(Bitmap bitmap) {
            this.mRemoteViews.setImageViewBitmap(ApiResUtil.getId(this.mOriginContext, "ksad_download_icon"), bitmap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ProgressRemoteViewImpl(Context context, int i6, boolean z5) {
            this.btnControlId = -1;
            this.btnTextColorChecked = Color.parseColor("#FFFFFFFF");
            this.btnTextColorUnchecked = Color.parseColor("#FF222222");
            this.mContext = context;
            this.downloadTaskId = i6;
            if (context instanceof ResContext) {
                this.mOriginContext = ((ResContext) context).getDelegatedContext();
            } else {
                this.mOriginContext = context;
            }
            this.mRemoteViews = new RemoteViews(this.mOriginContext.getPackageName(), ApiResUtil.getLayoutId(this.mOriginContext, z5 ? "ksad_notification_download_progress_with_control" : "ksad_notification_download_progress_without_control"));
            this.btnControlId = ApiResUtil.getId(this.mOriginContext, "ksad_download_control_btn");
            initViews();
            setControlBtnPaused(false);
        }

        private void initViews() {
            Intent intent = new Intent(ACTION_CLICK_CONTROL_BTN);
            intent.putExtra(KEY_TASKID, this.downloadTaskId);
            this.mRemoteViews.setOnClickPendingIntent(this.btnControlId, Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this.mContext, this.downloadTaskId, intent, 201326592) : PendingIntent.getBroadcast(this.mContext, this.downloadTaskId, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public RemoteViews build() {
            return this.mRemoteViews;
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setControlBtnPaused(boolean z5) {
            RemoteViews remoteViews = this.mRemoteViews;
            if (remoteViews == null) {
                return;
            }
            remoteViews.setTextViewText(this.btnControlId, z5 ? "继续" : "暂停");
            this.mRemoteViews.setTextColor(this.btnControlId, z5 ? this.btnTextColorChecked : this.btnTextColorUnchecked);
            this.mRemoteViews.setImageViewResource(ApiResUtil.getId(this.mOriginContext, "ksad_download_control_bg_image"), z5 ? ApiResUtil.getDrawableId(this.mOriginContext, "ksad_notification_control_btn_bg_checked") : ApiResUtil.getDrawableId(this.mOriginContext, "ksad_notification_control_btn_bg_unchecked"));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setIcon(int i6) {
            setIcon(RemoteViewBuilder.getBitmap(this.mContext, i6));
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setName(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_name"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setPercentNum(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_percent_num"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setProgress(int i6, int i7, boolean z5) {
            this.mRemoteViews.setProgressBar(ApiResUtil.getId(this.mOriginContext, "ksad_download_progress"), i6, i7, z5);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setSize(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_size"), str);
        }

        @Override // com.kwad.sdk.api.core.IProgressRemoteView
        public void setStatus(String str) {
            this.mRemoteViews.setTextViewText(ApiResUtil.getId(this.mOriginContext, "ksad_download_status"), str);
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public static IProgressRemoteView createProgressView(Context context) {
        return new ProgressRemoteViewImpl(context, 0, 0 == true ? 1 : 0, null);
    }

    @KsAdSdkDynamicApi
    @Keep
    public static ICompletedRemoteView createCompletedView(Context context) {
        return new CompletedRemoteViewImpl(context, null);
    }

    @KsAdSdkDynamicApi
    @Keep
    public static IProgressRemoteView createProgressView(Context context, int i6, boolean z5) {
        return new ProgressRemoteViewImpl(context, i6, z5, null);
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = !drawable.getBounds().isEmpty() ? drawable.getBounds().width() : drawable.getIntrinsicWidth();
        int height = !drawable.getBounds().isEmpty() ? drawable.getBounds().height() : drawable.getIntrinsicHeight();
        if (width <= 0) {
            width = 1;
        }
        if (height <= 0) {
            height = 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap getBitmap(Context context, int i6) {
        return drawableToBitmap(context.getResources().getDrawable(i6));
    }
}
