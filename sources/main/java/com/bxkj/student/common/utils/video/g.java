package com.bxkj.student.common.utils.video;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import androidx.fragment.app.FragmentActivity;
import com.jmolsmobile.landscapevideocapture.VideoCaptureActivity;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.io.File;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String outputPath, Bitmap thumbnailBitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(a aVar, int i6, Intent intent) {
        if (i6 == -1) {
            String stringExtra = intent.getStringExtra(VideoCaptureActivity.f35575i);
            Bitmap c6 = c(stringExtra);
            if (aVar != null) {
                aVar.a(stringExtra, c6);
            }
        }
    }

    private CaptureConfiguration b(int maxDuration) {
        CaptureConfiguration.b bVar = new CaptureConfiguration.b(PredefinedCaptureConfigurations.CaptureResolution.RES_720P, PredefinedCaptureConfigurations.CaptureQuality.HIGH);
        bVar.f();
        bVar.c(maxDuration);
        return bVar.a();
    }

    private Bitmap c(String filename) {
        if (filename == null) {
            return null;
        }
        return ThumbnailUtils.createVideoThumbnail(filename, 2);
    }

    public void e(FragmentActivity activity, int maxDuration, final a recordListener) {
        CaptureConfiguration b6 = b(maxDuration);
        File file = new File(activity.getCacheDir(), "video");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "record_video.mp4");
        if (file2.exists()) {
            try {
                file2.delete();
                file2.createNewFile();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        Intent intent = new Intent(activity, (Class<?>) VideoCaptureActivity.class);
        intent.putExtra(VideoCaptureActivity.f35576j, b6);
        intent.putExtra(VideoCaptureActivity.f35575i, file2.getPath());
        new u.b(activity).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.student.common.utils.video.f
            @Override // u.b.a
            public final void a(int i6, Intent intent2) {
                g.this.d(recordListener, i6, intent2);
            }
        });
    }
}
