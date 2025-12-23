package com.bxkj.student.home.teaching.lesson;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.dialog.LoadingDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.lesson.CertificateActivity;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CertificateActivity extends BaseActivity {
    private ImageView W;
    private Button X;
    private Bitmap Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private float f18871a0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoadingDialog f18872a;

        a(final LoadingDialog val$loadingDialog) {
            this.f18872a = val$loadingDialog;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Bitmap decodeResource = BitmapFactory.decodeResource(CertificateActivity.this.getResources(), R.mipmap.certificate_bg);
            CertificateActivity certificateActivity = CertificateActivity.this;
            certificateActivity.Y = certificateActivity.o0(decodeResource);
            CertificateActivity certificateActivity2 = CertificateActivity.this;
            final LoadingDialog loadingDialog = this.f18872a;
            certificateActivity2.runOnUiThread(new Runnable() { // from class: com.bxkj.student.home.teaching.lesson.b
                @Override // java.lang.Runnable
                public final void run() {
                    CertificateActivity.a.this.b(loadingDialog);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(LoadingDialog loadingDialog) {
            loadingDialog.dismiss();
            CertificateActivity.this.X.setVisibility(0);
            CertificateActivity.this.W.setImageBitmap(CertificateActivity.this.Y);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f18874a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f18875b;

        b(final Bitmap val$bmp, final Context val$context) {
            this.f18874a = val$bmp;
            this.f18875b = val$context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Toast.makeText(((BaseActivity) CertificateActivity.this).T, "已成功保存到相册", 0).show();
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        
            if (r1 == null) goto L30;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r1v14, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = android.os.Environment.DIRECTORY_PICTURES
                java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)
                java.io.File r0 = r0.getAbsoluteFile()
                java.io.File r1 = new java.io.File
                java.lang.String r2 = "download"
                r1.<init>(r0, r2)
                boolean r0 = r1.exists()
                if (r0 != 0) goto L1a
                r1.mkdirs()
            L1a:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                long r2 = java.lang.System.currentTimeMillis()
                r0.append(r2)
                java.lang.String r2 = ".jpg"
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.io.File r2 = new java.io.File
                r2.<init>(r1, r0)
                r0 = 0
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5a java.io.FileNotFoundException -> L5f
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L5a java.io.FileNotFoundException -> L5f
                android.graphics.Bitmap r0 = r6.f18874a     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L51 java.io.FileNotFoundException -> L53
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L51 java.io.FileNotFoundException -> L53
                r4 = 100
                r0.compress(r3, r4, r1)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L51 java.io.FileNotFoundException -> L53
                r1.flush()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L51 java.io.FileNotFoundException -> L53
            L46:
                r1.close()     // Catch: java.io.IOException -> L4a
                goto L70
            L4a:
                r0 = move-exception
                r0.printStackTrace()
                goto L70
            L4f:
                r0 = move-exception
                goto L94
            L51:
                r0 = move-exception
                goto L64
            L53:
                r0 = move-exception
                goto L6a
            L55:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L94
            L5a:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L64
            L5f:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L6a
            L64:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L4f
                if (r1 == 0) goto L70
                goto L46
            L6a:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> L4f
                if (r1 == 0) goto L70
                goto L46
            L70:
                android.content.Context r0 = r6.f18875b
                android.content.Intent r1 = new android.content.Intent
                java.io.File r3 = new java.io.File
                java.lang.String r2 = r2.getPath()
                r3.<init>(r2)
                android.net.Uri r2 = android.net.Uri.fromFile(r3)
                java.lang.String r3 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE"
                r1.<init>(r3, r2)
                r0.sendBroadcast(r1)
                com.bxkj.student.home.teaching.lesson.CertificateActivity r0 = com.bxkj.student.home.teaching.lesson.CertificateActivity.this
                com.bxkj.student.home.teaching.lesson.c r1 = new com.bxkj.student.home.teaching.lesson.c
                r1.<init>()
                r0.runOnUiThread(r1)
                return
            L94:
                if (r1 == 0) goto L9e
                r1.close()     // Catch: java.io.IOException -> L9a
                goto L9e
            L9a:
                r1 = move-exception
                r1.printStackTrace()
            L9e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.home.teaching.lesson.CertificateActivity.b.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap o0(Bitmap src) {
        if (src == null) {
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        float f6 = width;
        float f7 = f6 / 2480;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRGB(255, 255, 255);
        canvas.drawBitmap(src, 0.0f, 0.0f, (Paint) null);
        float f8 = f6 / 2.0f;
        float f9 = 234.0f * f7;
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.certificate_top_logo), f8 - (r1.getWidth() / 2.0f), f9, (Paint) null);
        float height2 = f9 + r1.getHeight() + (73.0f * f7);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.certificate_top_school), f8 - (r10.getWidth() / 2.0f), height2, (Paint) null);
        float height3 = height2 + r10.getHeight() + (266.0f * f7);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.certificate_top_level), f8 - (r1.getWidth() / 2.0f), height3, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Typeface typeface = Typeface.DEFAULT_BOLD;
        paint.setTypeface(typeface);
        paint.setTextSize(u.a(36.0f, this.T));
        paint.setUnderlineText(true);
        Rect rect = new Rect();
        String realName = LoginUser.getLoginUser().getRealName();
        paint.getTextBounds(realName, 0, realName.length(), rect);
        float f10 = 388.0f * f7;
        float height4 = height3 + r1.getHeight() + (302.0f * f7);
        canvas.drawText(realName, f10, height4, paint);
        Rect rect2 = new Rect();
        paint.setUnderlineText(false);
        paint.getTextBounds("同学：", 0, 3, rect2);
        canvas.drawText("同学：", rect.width() + f10, height4, paint);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.certificate_bottom_deal);
        Rect rect3 = new Rect();
        paint.setUnderlineText(false);
        paint.setTextSize(u.a(30.0f, this.T));
        String schoolName = LoginUser.getLoginUser().getSchoolName();
        paint.getTextBounds(schoolName, 0, schoolName.length(), rect3);
        float f11 = 1103.0f * f7;
        float f12 = height - (440.0f * f7);
        canvas.drawText(schoolName, ((decodeResource.getWidth() / 2.0f) + f11) - (rect3.width() / 2.0f), f12 - (decodeResource.getHeight() / 2.0f), paint);
        Rect rect4 = new Rect();
        paint.setUnderlineText(false);
        paint.setTextSize(u.a(30.0f, this.T));
        paint.getTextBounds("体育部", 0, 3, rect4);
        canvas.drawText("体育部", ((decodeResource.getWidth() / 2.0f) + f11) - (rect4.width() / 2.0f), (f12 - (decodeResource.getHeight() / 2.0f)) + rect3.height(), paint);
        canvas.drawBitmap(decodeResource, f11, f12 - decodeResource.getHeight(), (Paint) null);
        String str = "\u3000\u3000参加" + this.Z + "班学习，经考核" + p0(this.f18871a0) + "，特发此证！";
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        textPaint.setTypeface(typeface);
        textPaint.setTextSize(u.a(36.0f, this.T));
        StaticLayout staticLayout = new StaticLayout(str, textPaint, (int) ((f6 - f10) - (450.0f * f7)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        canvas.translate(f10, height4 + rect2.height() + (f7 * 120.0f));
        staticLayout.draw(canvas);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private String p0(float score) {
        return score >= 90.0f ? "优秀" : score >= 80.0f ? "良好" : score >= 60.0f ? "合格" : "无证书";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        s0(this.T, this.Y);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.lesson.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CertificateActivity.this.q0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("查看证书");
    }

    public void s0(Context context, Bitmap bmp) {
        new b(bmp, context).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_certificate;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("lessonName")) {
            this.Z = getIntent().getStringExtra("lessonName");
        }
        if (getIntent().hasExtra("score")) {
            this.f18871a0 = getIntent().getFloatExtra("score", 0.0f);
        }
        LoadingDialog loadingDialog = new LoadingDialog(this.T);
        loadingDialog.setMessage("证书生成中...");
        loadingDialog.show();
        try {
            new a(loadingDialog).start();
        } catch (Exception e6) {
            e6.printStackTrace();
            new iOSOneButtonDialog(this.T).setMessage("生成证书失败,请稍后再试").show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (ImageView) findViewById(R.id.iv);
        this.X = (Button) findViewById(R.id.bt_save);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.Y;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.Y.recycle();
            this.Y = null;
        }
        System.gc();
    }

    public Bitmap r0(Context mContext, int resourcesId, int width, int height) {
        InputStream openRawResource = mContext.getResources().openRawResource(resourcesId);
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i6 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(openRawResource, null, options);
        float f6 = options.outWidth;
        float f7 = options.outHeight;
        float f8 = height;
        if (f7 > f8 || f6 > width) {
            if (f6 > f7) {
                i6 = Math.round(f7 / f8);
            } else {
                i6 = Math.round(f6 / width);
            }
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i6;
        return BitmapFactory.decodeStream(openRawResource, null, options);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
