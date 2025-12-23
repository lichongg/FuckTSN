package com.bytedance.msdk.j.up;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.vl;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends com.bytedance.sdk.component.oq.r.xt<String, Void, Bitmap> {
    private SoftReference<ImageView> xt;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            return null;
        } catch (Throwable th) {
            vl.j(th);
            return null;
        }
    }

    public xt(ImageView imageView) {
        this.xt = new SoftReference<>(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            if (this.xt.get() != null) {
                this.xt.get().setImageBitmap(bitmap);
                return;
            }
            return;
        }
        cw.j("download Image", "Error download Image fail...");
    }
}
