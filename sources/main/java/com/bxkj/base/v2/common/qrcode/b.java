package com.bxkj.base.v2.common.qrcode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.utils.u;
import com.bxkj.base.R;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.ext.b0;
import com.huawei.hms.hmsscankit.ScanKitActivity;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.orhanobut.logger.j;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final FragmentActivity f16862a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private SoundUtils f16863b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private a f16864c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(@NotNull String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nQrCodeKit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QrCodeKit.kt\ncom/bxkj/base/v2/common/qrcode/QrCodeKit$startToScan$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n1#2:177\n*E\n"})
    /* renamed from: com.bxkj.base.v2.common.qrcode.b$b, reason: collision with other inner class name */
    public static final class C0189b implements b.a {
        C0189b() {
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            HmsScan hmsScan;
            String str;
            if (intent == null || (hmsScan = (HmsScan) intent.getParcelableExtra(ScanUtil.RESULT)) == null || (str = hmsScan.originalValue) == null) {
                return;
            }
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                b bVar = b.this;
                SoundUtils j6 = bVar.j();
                if (j6 != null) {
                    j6.g(R.raw.beep);
                }
                a i7 = bVar.i();
                if (i7 != null) {
                    i7.a(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(b bVar) {
        j.d("开始扫码", new Object[0]);
        bVar.p();
        return n1.f44123a;
    }

    public b(@NotNull FragmentActivity mActivity) {
        g0.p(mActivity, "mActivity");
        this.f16862a = mActivity;
    }

    public static /* synthetic */ Bitmap e(b bVar, String str, Integer num, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            num = null;
        }
        return bVar.d(str, num);
    }

    public static /* synthetic */ Bitmap g(b bVar, String str, Integer num, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            num = null;
        }
        return bVar.f(str, num);
    }

    private final void k() {
        b0.x(this.f16862a, "使用相机扫一扫功能", new Function0() { // from class: com.bxkj.base.v2.common.qrcode.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 l6;
                l6 = b.l(b.this);
                return l6;
            }
        });
    }

    private final void p() {
        u.b bVar = new u.b(this.f16862a);
        Intent putExtra = new Intent(this.f16862a, (Class<?>) ScanKitActivity.class).putExtra(HmsScanBase.SCAN_FORMAT_FLAG, HmsScanBase.QRCODE_SCAN_TYPE).putExtra(HmsScanBase.SCAN_GUIDE_FLAG, true).putExtra(HmsScanBase.SCAN_VIEW_FLAG, 1);
        g0.o(putExtra, "putExtra(...)");
        bVar.startActivityForResult(putExtra).c(new C0189b());
    }

    @Nullable
    public final Bitmap b(@NotNull String text) {
        g0.p(text, "text");
        try {
            return ScanUtil.buildBitmap(text, HmsScanBase.CODE128_SCAN_TYPE, u.a(320.0f, this.f16862a), u.a(80.0f, this.f16862a), null);
        } catch (Exception unused) {
            j.e("生成条形码失败", new Object[0]);
            return null;
        }
    }

    @Nullable
    public final Bitmap c(@NotNull String text) {
        g0.p(text, "text");
        try {
            Bitmap buildBitmap = ScanUtil.buildBitmap(text, HmsScanBase.CODE128_SCAN_TYPE, u.a(700.0f, this.f16862a), u.a(150.0f, this.f16862a), null);
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);
            return Bitmap.createBitmap(buildBitmap, 0, 0, buildBitmap.getWidth(), buildBitmap.getHeight(), matrix, true);
        } catch (Exception unused) {
            j.e("生成条形码失败", new Object[0]);
            return null;
        }
    }

    @Nullable
    public final Bitmap d(@NotNull String text, @Nullable Integer num) {
        g0.p(text, "text");
        try {
            return ScanUtil.buildBitmap(text, HmsScanBase.QRCODE_SCAN_TYPE, u.a(260.0f, this.f16862a), u.a(260.0f, this.f16862a), num != null ? new HmsBuildBitmapOption.Creator().setQRLogoBitmap(BitmapFactory.decodeResource(this.f16862a.getResources(), num.intValue())).create() : new HmsBuildBitmapOption.Creator().create());
        } catch (Exception unused) {
            ContextExtKt.m(this.f16862a, "生成二维码失败");
            j.e("生成二维码失败", new Object[0]);
            return null;
        }
    }

    @Nullable
    public final Bitmap f(@NotNull String text, @Nullable Integer num) {
        g0.p(text, "text");
        try {
            return ScanUtil.buildBitmap(text, HmsScanBase.QRCODE_SCAN_TYPE, u.a(320.0f, this.f16862a), u.a(320.0f, this.f16862a), num != null ? new HmsBuildBitmapOption.Creator().setQRLogoBitmap(BitmapFactory.decodeResource(this.f16862a.getResources(), num.intValue())).create() : new HmsBuildBitmapOption.Creator().create());
        } catch (Exception unused) {
            ContextExtKt.m(this.f16862a, "生成二维码失败");
            j.e("生成二维码失败", new Object[0]);
            return null;
        }
    }

    @NotNull
    public final FragmentActivity h() {
        return this.f16862a;
    }

    @Nullable
    public final a i() {
        return this.f16864c;
    }

    @Nullable
    public final SoundUtils j() {
        return this.f16863b;
    }

    public final void m(@NotNull a resultCallback) {
        g0.p(resultCallback, "resultCallback");
        SoundUtils soundUtils = new SoundUtils(this.f16862a);
        this.f16863b = soundUtils;
        soundUtils.m(R.raw.beep);
        this.f16864c = resultCallback;
        k();
    }

    public final void n(@Nullable a aVar) {
        this.f16864c = aVar;
    }

    public final void o(@Nullable SoundUtils soundUtils) {
        this.f16863b = soundUtils;
    }
}
