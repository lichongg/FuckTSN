package com.bykv.vk.openvk.component.video.j.up;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import java.util.HashMap;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: com.bykv.vk.openvk.component.video.j.up.xt$xt, reason: collision with other inner class name */
    public interface InterfaceC0309xt {
        void j(Bitmap bitmap);
    }

    public static class j extends com.bytedance.sdk.component.oq.r.xt<String, Integer, Bitmap> {
        private long cw;
        private InterfaceC0309xt xt;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmap = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith(b.f50154a)) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.cw * 1000, 3);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.cw.cw("MediaUtils", "MediaUtils doInBackground : ", th);
                return bitmap;
            }
        }

        public j(InterfaceC0309xt interfaceC0309xt, long j6) {
            this.xt = interfaceC0309xt;
            this.cw = j6;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0309xt interfaceC0309xt = this.xt;
            if (interfaceC0309xt != null) {
                interfaceC0309xt.j(bitmap);
            }
        }
    }

    public static void j(long j6, String str, InterfaceC0309xt interfaceC0309xt) {
        new j(interfaceC0309xt, j6).j((Object[]) new String[]{str});
    }
}
