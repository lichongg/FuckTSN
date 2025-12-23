package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.b.h;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ImageActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    RelativeLayout f40299a;

    /* renamed from: b, reason: collision with root package name */
    private QQToken f40300b;

    /* renamed from: c, reason: collision with root package name */
    private String f40301c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f40302d;

    /* renamed from: e, reason: collision with root package name */
    private c f40303e;

    /* renamed from: f, reason: collision with root package name */
    private Button f40304f;

    /* renamed from: g, reason: collision with root package name */
    private Button f40305g;

    /* renamed from: h, reason: collision with root package name */
    private b f40306h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f40307i;

    /* renamed from: j, reason: collision with root package name */
    private ProgressBar f40308j;

    /* renamed from: r, reason: collision with root package name */
    private String f40316r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f40317s;

    /* renamed from: k, reason: collision with root package name */
    private int f40309k = 0;

    /* renamed from: l, reason: collision with root package name */
    private boolean f40310l = false;

    /* renamed from: m, reason: collision with root package name */
    private long f40311m = 0;

    /* renamed from: n, reason: collision with root package name */
    private int f40312n = 0;

    /* renamed from: o, reason: collision with root package name */
    private final int f40313o = 640;

    /* renamed from: p, reason: collision with root package name */
    private final int f40314p = 640;

    /* renamed from: q, reason: collision with root package name */
    private Rect f40315q = new Rect();

    /* renamed from: t, reason: collision with root package name */
    private final View.OnClickListener f40318t = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.f40308j.setVisibility(0);
            ImageActivity.this.f40305g.setEnabled(false);
            ImageActivity.this.f40305g.setTextColor(Color.rgb(21, 21, 21));
            ImageActivity.this.f40304f.setEnabled(false);
            ImageActivity.this.f40304f.setTextColor(Color.rgb(36, 94, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS));
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageActivity.this.c();
                }
            }).start();
            if (ImageActivity.this.f40310l) {
                ImageActivity.this.a("10657", 0L);
                return;
            }
            ImageActivity.this.a("10655", System.currentTimeMillis() - ImageActivity.this.f40311m);
            if (ImageActivity.this.f40303e.f40339b) {
                ImageActivity.this.a("10654", 0L);
            }
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private final View.OnClickListener f40319u = new View.OnClickListener() { // from class: com.tencent.connect.avatar.ImageActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImageActivity.this.a("10656", System.currentTimeMillis() - ImageActivity.this.f40311m);
            ImageActivity.this.setResult(0);
            ImageActivity.this.d();
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private final IUiListener f40320v = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.5
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            ImageActivity.this.f40305g.setEnabled(true);
            int i6 = -1;
            ImageActivity.this.f40305g.setTextColor(-1);
            ImageActivity.this.f40304f.setEnabled(true);
            ImageActivity.this.f40304f.setTextColor(-1);
            ImageActivity.this.f40308j.setVisibility(8);
            JSONObject jSONObject = (JSONObject) obj;
            try {
                i6 = jSONObject.getInt("ret");
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            if (i6 != 0) {
                ImageActivity.this.a("设置出错了，请重新登录再尝试下呢：）", 1);
                e.a().a(ImageActivity.this.f40300b.getOpenId(), ImageActivity.this.f40300b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "1");
                return;
            }
            ImageActivity.this.a("设置成功", 0);
            ImageActivity.this.a("10658", 0L);
            e.a().a(ImageActivity.this.f40300b.getOpenId(), ImageActivity.this.f40300b.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, "3", "0");
            ImageActivity imageActivity = ImageActivity.this;
            if (imageActivity.f40301c != null && !"".equals(ImageActivity.this.f40301c)) {
                Intent intent = new Intent();
                intent.setClassName(imageActivity, ImageActivity.this.f40301c);
                if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null) {
                    imageActivity.startActivity(intent);
                }
            }
            ImageActivity.this.a(0, jSONObject.toString(), null, null);
            ImageActivity.this.d();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            ImageActivity.this.f40305g.setEnabled(true);
            ImageActivity.this.f40305g.setTextColor(-1);
            ImageActivity.this.f40304f.setEnabled(true);
            ImageActivity.this.f40304f.setTextColor(-1);
            ImageActivity.this.f40304f.setText("重试");
            ImageActivity.this.f40308j.setVisibility(8);
            ImageActivity.this.f40310l = true;
            ImageActivity.this.a(uiError.errorMessage, 1);
            ImageActivity.this.a("10660", 0L);
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private final IUiListener f40321w = new DefaultUiListener() { // from class: com.tencent.connect.avatar.ImageActivity.6
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            a(0);
        }

        private void a(int i6) {
            if (ImageActivity.this.f40309k < 2) {
                ImageActivity.this.e();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            int i6 = -1;
            try {
                i6 = jSONObject.getInt("ret");
                if (i6 == 0) {
                    final String string = jSONObject.getString("nickname");
                    ImageActivity.this.f40302d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageActivity.this.c(string);
                        }
                    });
                    ImageActivity.this.a("10659", 0L);
                } else {
                    ImageActivity.this.a("10661", 0L);
                }
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
            if (i6 != 0) {
                a(i6);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class QQAvatarImp extends BaseApi {
        public QQAvatarImp(QQToken qQToken) {
            super(qQToken);
        }

        public void setAvator(Bitmap bitmap, IUiListener iUiListener) {
            Bundle a6 = a();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bitmap.recycle();
            BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(iUiListener);
            a6.putByteArray("picture", byteArray);
            HttpUtils.requestAsync(this.f40366c, g.a(), "user/set_user_face", a6, "POST", tempRequestListener);
            e.a().a(this.f40366c.getOpenId(), this.f40366c.getAppId(), Constants.VIA_SET_AVATAR_SUCCEED, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_ACT_TYPE_NINETEEN, "0");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends View {
        public a(Context context) {
            super(context);
        }

        public void a(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b6 = ImageActivity.this.b("com.tencent.plus.blue_normal.png");
            Drawable b7 = ImageActivity.this.b("com.tencent.plus.blue_down.png");
            Drawable b8 = ImageActivity.this.b("com.tencent.plus.blue_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b7);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b6);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b6);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b6);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b8);
            button.setBackgroundDrawable(stateListDrawable);
        }

        public void b(Button button) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable b6 = ImageActivity.this.b("com.tencent.plus.gray_normal.png");
            Drawable b7 = ImageActivity.this.b("com.tencent.plus.gray_down.png");
            Drawable b8 = ImageActivity.this.b("com.tencent.plus.gray_disable.png");
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, b7);
            stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, b6);
            stateListDrawable.addState(View.ENABLED_STATE_SET, b6);
            stateListDrawable.addState(View.FOCUSED_STATE_SET, b6);
            stateListDrawable.addState(View.EMPTY_STATE_SET, b8);
            button.setBackgroundDrawable(stateListDrawable);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResult(0);
        d();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView(a());
        this.f40302d = new Handler();
        Bundle bundleExtra = getIntent().getBundleExtra(Constants.KEY_PARAMS);
        this.f40316r = bundleExtra.getString("picture");
        this.f40301c = bundleExtra.getString("return_activity");
        String string = bundleExtra.getString("appid");
        String string2 = bundleExtra.getString("access_token");
        long j6 = bundleExtra.getLong("expires_in");
        String string3 = bundleExtra.getString("openid");
        this.f40312n = bundleExtra.getInt("exitAnim");
        QQToken qQToken = new QQToken(string);
        this.f40300b = qQToken;
        qQToken.setAccessToken(string2, ((j6 - System.currentTimeMillis()) / 1000) + "");
        this.f40300b.setOpenId(string3);
        b();
        e();
        this.f40311m = System.currentTimeMillis();
        a("10653", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        float width = this.f40315q.width();
        Matrix imageMatrix = this.f40303e.getImageMatrix();
        float[] fArr = new float[9];
        imageMatrix.getValues(fArr);
        float f6 = fArr[2];
        float f7 = fArr[5];
        float f8 = fArr[0];
        float f9 = 640.0f / width;
        Rect rect = this.f40315q;
        int i6 = (int) ((rect.left - f6) / f8);
        int i7 = i6 < 0 ? 0 : i6;
        int i8 = (int) ((rect.top - f7) / f8);
        int i9 = i8 < 0 ? 0 : i8;
        Matrix matrix = new Matrix();
        matrix.set(imageMatrix);
        matrix.postScale(f9, f9);
        int i10 = (int) (650.0f / f8);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f40317s, i7, i9, Math.min(this.f40317s.getWidth() - i7, i10), Math.min(this.f40317s.getHeight() - i9, i10), matrix, true);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, 640, 640);
            createBitmap.recycle();
            a(createBitmap2);
        } catch (IllegalArgumentException e6) {
            e6.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e6.getMessage());
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        finish();
        int i6 = this.f40312n;
        if (i6 != 0) {
            overridePendingTransition(0, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f40309k++;
        new UserInfo(this, this.f40300b).getUserInfo(this.f40321w);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f40303e.setImageBitmap(null);
        Bitmap bitmap = this.f40317s;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f40317s.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable b(String str) {
        return m.a(str, this);
    }

    private void b() {
        Bitmap a6;
        try {
            a6 = a(this.f40316r);
            this.f40317s = a6;
        } catch (IOException e6) {
            e6.printStackTrace();
            a(Constants.MSG_IMAGE_ERROR, 1);
            a(-5, null, Constants.MSG_IMAGE_ERROR, e6.getMessage());
            d();
        }
        if (a6 != null) {
            this.f40303e.setImageBitmap(a6);
            this.f40304f.setOnClickListener(this.f40318t);
            this.f40305g.setOnClickListener(this.f40319u);
            this.f40299a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.connect.avatar.ImageActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ImageActivity.this.f40299a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    ImageActivity imageActivity = ImageActivity.this;
                    imageActivity.f40315q = imageActivity.f40306h.a();
                    ImageActivity.this.f40303e.a(ImageActivity.this.f40315q);
                }
            });
            return;
        }
        throw new IOException("cannot read picture: '" + this.f40316r + "'!");
    }

    private String d(String str) {
        return str.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", ContainerUtils.FIELD_DELIMITER);
    }

    private Bitmap a(String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i6 = 1;
        options.inJustDecodeBounds = true;
        Uri parse = Uri.parse(str);
        InputStream openInputStream = getContentResolver().openInputStream(parse);
        if (openInputStream == null) {
            return null;
        }
        try {
            BitmapFactory.decodeStream(openInputStream, null, options);
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
        }
        openInputStream.close();
        int i7 = options.outWidth;
        int i8 = options.outHeight;
        while (i7 * i8 > 4194304) {
            i7 /= 2;
            i8 /= 2;
            i6 *= 2;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = i6;
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(parse), null, options);
        } catch (OutOfMemoryError e7) {
            e7.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i6) {
        Toast makeText = Toast.makeText(this, str, 1);
        LinearLayout linearLayout = (LinearLayout) makeText.getView();
        ((TextView) linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 16.0f), com.tencent.connect.avatar.a.a(this, 16.0f)));
        if (i6 == 0) {
            imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else {
            imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearLayout.addView(imageView, 0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        makeText.setView(linearLayout);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    private View a() {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f40299a = relativeLayout;
        relativeLayout.setLayoutParams(layoutParams);
        this.f40299a.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(layoutParams3);
        this.f40299a.addView(relativeLayout2);
        c cVar = new c(this);
        this.f40303e = cVar;
        cVar.setLayoutParams(layoutParams2);
        this.f40303e.setScaleType(ImageView.ScaleType.MATRIX);
        relativeLayout2.addView(this.f40303e);
        this.f40306h = new b(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams4.addRule(14, -1);
        layoutParams4.addRule(15, -1);
        this.f40306h.setLayoutParams(layoutParams4);
        relativeLayout2.addView(this.f40306h);
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.a.a(this, 80.0f));
        layoutParams5.addRule(14, -1);
        linearLayout.setLayoutParams(layoutParams5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        this.f40299a.addView(linearLayout);
        ImageView imageView = new ImageView(this);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 24.0f), com.tencent.connect.avatar.a.a(this, 24.0f)));
        imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearLayout.addView(imageView);
        this.f40307i = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(layoutParams3);
        layoutParams6.leftMargin = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f40307i.setLayoutParams(layoutParams6);
        this.f40307i.setEllipsize(TextUtils.TruncateAt.END);
        this.f40307i.setSingleLine();
        this.f40307i.setTextColor(-1);
        this.f40307i.setTextSize(24.0f);
        this.f40307i.setVisibility(8);
        linearLayout.addView(this.f40307i);
        RelativeLayout relativeLayout3 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.a.a(this, 60.0f));
        layoutParams7.addRule(12, -1);
        layoutParams7.addRule(9, -1);
        relativeLayout3.setLayoutParams(layoutParams7);
        relativeLayout3.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int a6 = com.tencent.connect.avatar.a.a(this, 10.0f);
        relativeLayout3.setPadding(a6, a6, a6, 0);
        this.f40299a.addView(relativeLayout3);
        a aVar = new a(this);
        int a7 = com.tencent.connect.avatar.a.a(this, 14.0f);
        int a8 = com.tencent.connect.avatar.a.a(this, 7.0f);
        this.f40305g = new Button(this);
        this.f40305g.setLayoutParams(new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f)));
        this.f40305g.setText("取消");
        this.f40305g.setTextColor(-1);
        this.f40305g.setTextSize(18.0f);
        this.f40305g.setPadding(a7, a8, a7, a8);
        aVar.b(this.f40305g);
        relativeLayout3.addView(this.f40305g);
        this.f40304f = new Button(this);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(com.tencent.connect.avatar.a.a(this, 78.0f), com.tencent.connect.avatar.a.a(this, 45.0f));
        layoutParams8.addRule(11, -1);
        this.f40304f.setLayoutParams(layoutParams8);
        this.f40304f.setTextColor(-1);
        this.f40304f.setTextSize(18.0f);
        this.f40304f.setPadding(a7, a8, a7, a8);
        this.f40304f.setText("选取");
        aVar.a(this.f40304f);
        relativeLayout3.addView(this.f40304f);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams9.addRule(13, -1);
        textView.setLayoutParams(layoutParams9);
        textView.setText("移动和缩放");
        textView.setPadding(0, com.tencent.connect.avatar.a.a(this, 3.0f), 0, 0);
        textView.setTextSize(18.0f);
        textView.setTextColor(-1);
        relativeLayout3.addView(textView);
        this.f40308j = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams10.addRule(14, -1);
        layoutParams10.addRule(15, -1);
        this.f40308j.setLayoutParams(layoutParams10);
        this.f40308j.setVisibility(8);
        this.f40299a.addView(this.f40308j);
        return this.f40299a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        String d6 = d(str);
        if ("".equals(d6)) {
            return;
        }
        this.f40307i.setText(d6);
        this.f40307i.setVisibility(0);
    }

    private void a(Bitmap bitmap) {
        new QQAvatarImp(this.f40300b).setAvator(bitmap, this.f40320v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i6) {
        this.f40302d.post(new Runnable() { // from class: com.tencent.connect.avatar.ImageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ImageActivity.this.b(str, i6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_ERROR_CODE, i6);
        intent.putExtra(Constants.KEY_ERROR_MSG, str2);
        intent.putExtra(Constants.KEY_ERROR_DETAIL, str3);
        intent.putExtra(Constants.KEY_RESPONSE, str);
        setResult(-1, intent);
    }

    public void a(String str, long j6) {
        a(str, j6, this.f40300b.getAppId());
    }

    public static void a(String str, long j6, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("strValue", str2);
        hashMap.put("nValue", str);
        hashMap.put("qver", Constants.SDK_VERSION);
        if (j6 != 0) {
            hashMap.put("elt", String.valueOf(j6));
        }
        h.a().a("https://cgi.qplus.com/report/report", hashMap);
    }
}
