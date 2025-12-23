package com.bxkj.student.common.utils.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.hw.videoprocessor.util.k;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.orhanobut.logger.j;
import java.io.File;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private b f17829a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f17830b = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i6 = msg.what;
            if (i6 == 0) {
                if (e.this.f17829a != null) {
                    e.this.f17829a.onStart();
                }
            } else if (i6 == 1) {
                if (e.this.f17829a != null) {
                    e.this.f17829a.b(msg.arg1);
                }
            } else if (i6 == 2) {
                if (e.this.f17829a != null) {
                    e.this.f17829a.onSuccess(msg.obj.toString());
                }
            } else if (e.this.f17829a != null) {
                e.this.f17829a.a();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();

        void b(int percent);

        void onStart();

        void onSuccess(String outputPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(float f6) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = (int) (f6 * 100.0f);
        this.f17830b.sendMessage(message);
    }

    public void d(final Context mContext, final String inputPath, b compressListener) {
        if (!new File(inputPath).exists()) {
            new iOSOneButtonDialog(mContext).setMessage("您选取的该视频文件不存在,请重新选取").show();
            return;
        }
        this.f17829a = compressListener;
        File file = new File(mContext.getCacheDir(), "video");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(file, "scale_video.mp4");
        if (file2.exists()) {
            try {
                file2.delete();
                file2.createNewFile();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        final String absolutePath = file2.getAbsolutePath();
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bxkj.student.common.utils.video.c
            @Override // java.lang.Runnable
            public final void run() {
                e.this.f(inputPath, mContext, absolutePath, file2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(String str, Context context, String str2, File file) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f17830b.sendEmptyMessage(0);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = PredefinedCaptureConfigurations.f35647n;
            int i7 = PredefinedCaptureConfigurations.f35648o;
            if (parseInt > parseInt2) {
                i6 = PredefinedCaptureConfigurations.f35648o;
                i7 = PredefinedCaptureConfigurations.f35647n;
            }
            com.hw.videoprocessor.h.f(context).v(str).y(str2).x(i6).w(i7).p(600000).A(new k() { // from class: com.bxkj.student.common.utils.video.d
                @Override // com.hw.videoprocessor.util.k
                public final void a(float f6) {
                    e.this.e(f6);
                }
            }).z();
            Message message = new Message();
            message.what = 2;
            message.obj = file.getPath();
            this.f17830b.sendMessage(message);
            j.c("本次压缩共耗时" + ((System.currentTimeMillis() - currentTimeMillis) / 1000) + "秒");
        } catch (Exception e6) {
            e6.printStackTrace();
            this.f17830b.sendEmptyMessage(3);
        }
    }
}
