package com.bxkj.student.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;
import com.bxkj.student.common.crop.view.ClipViewLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ClipImageActivity extends BaseActivity {

    /* renamed from: c0, reason: collision with root package name */
    private static final String f19542c0 = "ClipImageActivity";
    private ClipViewLayout W;
    private ClipViewLayout X;
    private ImageView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19543a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f19544b0;

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007d, code lost:
    
        if (r2 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008b, code lost:
    
        if (r2 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h0() {
        /*
            r7 = this;
            int r0 = r7.f19544b0
            r1 = 1
            if (r0 != r1) goto Lc
            com.bxkj.student.common.crop.view.ClipViewLayout r0 = r7.W
            android.graphics.Bitmap r0 = r0.d()
            goto L12
        Lc:
            com.bxkj.student.common.crop.view.ClipViewLayout r0 = r7.X
            android.graphics.Bitmap r0 = r0.d()
        L12:
            if (r0 != 0) goto L15
            return
        L15:
            java.lang.String r1 = "mounted"
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L27
            java.io.File r1 = r7.getExternalCacheDir()
            goto L28
        L27:
            r1 = r2
        L28:
            if (r1 == 0) goto L30
            boolean r3 = r1.exists()
            if (r3 != 0) goto L34
        L30:
            java.io.File r1 = r7.getCacheDir()
        L34:
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "avatar"
            r3.<init>(r1, r4)
            boolean r1 = r3.exists()
            if (r1 != 0) goto L44
            r3.mkdirs()
        L44:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "cropped_"
            r4.append(r5)
            long r5 = java.lang.System.currentTimeMillis()
            r4.append(r5)
            java.lang.String r5 = ".jpg"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1.<init>(r3, r4)
            android.net.Uri r1 = android.net.Uri.fromFile(r1)
            if (r1 == 0) goto La9
            android.content.ContentResolver r3 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L7b java.io.IOException -> L88
            java.io.OutputStream r2 = r3.openOutputStream(r1)     // Catch: java.lang.Throwable -> L7b java.io.IOException -> L88
            if (r2 == 0) goto L7d
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L7b java.io.IOException -> L88
            r4 = 100
            r0.compress(r3, r4, r2)     // Catch: java.lang.Throwable -> L7b java.io.IOException -> L88
            goto L7d
        L7b:
            r0 = move-exception
            goto L9e
        L7d:
            if (r2 == 0) goto L8e
        L7f:
            r2.close()     // Catch: java.io.IOException -> L83
            goto L8e
        L83:
            r0 = move-exception
            r0.printStackTrace()
            goto L8e
        L88:
            r1.toString()     // Catch: java.lang.Throwable -> L7b
            if (r2 == 0) goto L8e
            goto L7f
        L8e:
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            r0.setData(r1)
            r1 = -1
            r7.setResult(r1, r0)
            r7.finish()
            return
        L9e:
            if (r2 == 0) goto La8
            r2.close()     // Catch: java.io.IOException -> La4
            goto La8
        La4:
            r1 = move-exception
            r1.printStackTrace()
        La8:
            throw r0
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.personal.ClipImageActivity.h0():void");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_clip_image;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.f19544b0 = getIntent().getIntExtra("type", 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (ClipViewLayout) findViewById(R.id.clipViewLayout1);
        this.X = (ClipViewLayout) findViewById(R.id.clipViewLayout2);
        this.Y = (ImageView) findViewById(2131297102);
        this.Z = (TextView) findViewById(R.id.btn_cancel);
        this.f19543a0 = (TextView) findViewById(2131296623);
        this.Y.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f19543a0.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        int id = v5.getId();
        if (id != 2131296623) {
            if (id != 2131296660) {
                if (id != 2131297102) {
                    return;
                }
                finish();
                return;
            }
            finish();
            return;
        }
        h0();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f19544b0 == 1) {
            this.W.setVisibility(0);
            this.X.setVisibility(8);
            this.W.setImageSrc(getIntent().getData());
        } else {
            this.X.setVisibility(0);
            this.W.setVisibility(8);
            this.X.setImageSrc(getIntent().getData());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }
}
