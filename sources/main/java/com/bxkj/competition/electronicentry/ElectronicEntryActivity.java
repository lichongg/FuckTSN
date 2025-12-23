package com.bxkj.competition.electronicentry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bumptech.glide.h;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ElectronicEntryActivity extends BaseActivity {
    private TextView F0;
    private TextView G0;
    private String H0;
    private String I0;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f17267a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f17268b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f17269c0;

    /* renamed from: k0, reason: collision with root package name */
    private ImageView f17270k0;

    /* renamed from: p0, reason: collision with root package name */
    private ImageView f17271p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ElectronicEntryActivity.this.Q().setVisibility(0);
            ElectronicEntryActivity.this.p0(data);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ElectronicEntryActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            ElectronicEntryActivity electronicEntryActivity = ElectronicEntryActivity.this;
            electronicEntryActivity.o0(electronicEntryActivity.I0);
        }
    }

    private void m0() {
        Http.with(this.T).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).r(this.H0, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(String imageUrl) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, new String[]{imageUrl});
        intent.putExtra(ImagePagerActivity.S, 1);
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_ente, R.anim.zoom_exit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Map<String, Object> data) {
        this.W.setText("姓名：" + JsonParse.getString(data, "userName"));
        this.X.setText("学号：" + JsonParse.getString(data, "userNum"));
        this.Y.setText("性别：" + JsonParse.getString(data, "sex"));
        this.Z.setText("年级：" + JsonParse.getString(data, "nj"));
        this.f17267a0.setText("院系：" + JsonParse.getString(data, "yx"));
        this.f17268b0.setText("专业：" + JsonParse.getString(data, "zy"));
        this.f17269c0.setText("班级：" + JsonParse.getString(data, "bj"));
        this.G0.setText("号码：" + JsonParse.getString(data, "cardNum"));
        this.I0 = JsonParse.getString(data, "userImg");
        h<Drawable> a6 = com.bumptech.glide.b.D(this.T).a(this.I0);
        int i6 = R.mipmap.student_img_default;
        a6.y0(i6).z(i6).m1(this.f17271p0);
        n0(JsonParse.getString(data, "cardNum"));
        this.F0.setText(JsonParse.getString(data, "itemName"));
        this.f17271p0.setOnClickListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_electronic_entry;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("电子参赛证");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (TextView) findViewById(R.id.tv_name);
        this.X = (TextView) findViewById(R.id.tv_number);
        this.Y = (TextView) findViewById(R.id.tv_sex);
        this.Z = (TextView) findViewById(R.id.tv_grade);
        this.f17267a0 = (TextView) findViewById(R.id.tv_yard);
        this.f17268b0 = (TextView) findViewById(R.id.tv_major);
        this.f17269c0 = (TextView) findViewById(R.id.tv_class);
        this.f17270k0 = (ImageView) findViewById(R.id.iv_qr_code);
        this.F0 = (TextView) findViewById(R.id.tv_project);
        this.f17271p0 = (ImageView) findViewById(R.id.iv_student_image);
        this.G0 = (TextView) findViewById(R.id.tv_NO);
    }

    public Bitmap l0(String text, int size, Bitmap mBitmap) {
        try {
            int i6 = size / 10;
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            hashtable.put(EncodeHintType.MARGIN, 0);
            BitMatrix encode = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hashtable);
            int width = encode.getWidth();
            int i7 = width / 2;
            int height = encode.getHeight() / 2;
            Matrix matrix = new Matrix();
            float f6 = i6 * 2.0f;
            matrix.setScale(f6 / mBitmap.getWidth(), f6 / mBitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(mBitmap, 0, 0, mBitmap.getWidth(), mBitmap.getHeight(), matrix, false);
            int[] iArr = new int[size * size];
            for (int i8 = 0; i8 < size; i8++) {
                for (int i9 = 0; i9 < size; i9++) {
                    if (i9 > i7 - i6 && i9 < i7 + i6 && i8 > height - i6 && i8 < height + i6) {
                        iArr[(i8 * width) + i9] = createBitmap.getPixel((i9 - i7) + i6, (i8 - height) + i6);
                    } else if (encode.get(i9, i8)) {
                        iArr[(i8 * size) + i9] = -16777216;
                    } else {
                        iArr[(i8 * size) + i9] = -1;
                    }
                }
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            createBitmap2.setPixels(iArr, 0, size, 0, 0, size, size);
            return createBitmap2;
        } catch (WriterException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public void n0(String cardNum) {
        this.f17270k0.setImageBitmap(l0(cardNum, u.a(200.0f, this.T), BitmapFactory.decodeResource(getResources(), R.mipmap.icon)));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        this.H0 = getIntent().getStringExtra("competitionId");
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
