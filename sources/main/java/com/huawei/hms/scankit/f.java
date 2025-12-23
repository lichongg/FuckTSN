package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.bumptech.glide.Registry;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.p.c5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;
import com.huawei.hms.scankit.p.r6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y3;
import com.huawei.hms.scankit.util.OpencvJNI;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class f extends IRemoteDecoderDelegate.Stub {

    /* renamed from: c, reason: collision with root package name */
    private static volatile f f33944c = new f();

    /* renamed from: a, reason: collision with root package name */
    private volatile w3 f33945a = null;

    /* renamed from: b, reason: collision with root package name */
    private volatile x3 f33946b = null;

    static f a() {
        return f33944c;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
        return null;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z5;
        int i6;
        boolean z6;
        if (iObjectWrapper == null) {
            o4.b("IRemoteDecoder", "bitmap is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            i6 = 0;
            z6 = true;
        } else {
            i6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            boolean z7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
            DetailRect.HMSSCAN_SDK_VALUE = i7;
            r1 = i7 >= 2;
            if (r1) {
                i6 = w7.b(i6);
            }
            boolean z8 = r1;
            r1 = z7;
            z5 = z8;
        }
        r3.f34735f = r1;
        if (!(unwrap instanceof Bitmap)) {
            return new HmsScan[0];
        }
        HmsScan[] b6 = r6.a().b((Bitmap) unwrap, i6, z6, this.f33945a);
        return !z5 ? w7.a(b6) : b6;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            throw new RemoteException("Bundle is Null");
        }
        Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        String string = bundle.getString(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_CONTENT);
        int i6 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_FOTMAT);
        int i7 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_WIDTH);
        int i8 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_HEIGHT);
        int i9 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_MARGIN, 1);
        int i10 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_COLOR, -1);
        try {
            Bitmap a6 = new c5().a(string, i6, i7, i8, new HmsBuildBitmapOption.Creator().setBitmapMargin(i9).setBitmapColor(i10).setBitmapBackgroundColor(bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_BACKCOLOR, -1)).create());
            if (a6 != null) {
                return ObjectWrapper.wrap(a6);
            }
            throw new RemoteException("Bitmap is Null");
        } catch (WriterException e6) {
            throw new RemoteException(e6.getMessage());
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public void buildBitmapLog(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.f33946b == null) {
            try {
                this.f33946b = new x3();
                this.f33946b.c(bundle);
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "buildBitmapLog RuntimeException");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "buildBitmapLog Exception");
            }
        }
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        boolean z5;
        boolean z6;
        boolean z7;
        if (!r3.A) {
            OpencvJNI.init();
        }
        Bundle bundle = (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        String str = "";
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            z6 = false;
            z7 = true;
        } else {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getString(DetailRect.CP_PACKAGE, "");
            z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.USE_APK, false);
            z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
            z7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
        }
        r3.f34735f = z7;
        if (z6 && !r3.f34730a && z5) {
            return new HmsScan[]{r6.b()};
        }
        if (this.f33945a == null && y3.a(str, y3.a())) {
            try {
                this.f33945a = new w3(bundle, Registry.f14551l);
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate
    public HmsScanResult decodeWithBuffer(byte[] bArr, int i6, int i7, IObjectWrapper iObjectWrapper) throws RemoteException {
        boolean z5;
        int i8;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        if (bArr == null) {
            o4.b("IRemoteDecoder", "buffer is null");
            return new HmsScanResult(4096, new HmsScan[0]);
        }
        if (!r3.A) {
            OpencvJNI.init();
        }
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            z5 = true;
            i8 = 0;
            z6 = true;
            z7 = false;
        } else {
            int i9 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getInt(DetailRect.FORMAT_FLAG);
            boolean z10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.PHOTO_MODE, false);
            r3.f34732c = z10;
            int i10 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getInt(DetailRect.TYPE_TRANS, 0);
            z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.PARSE_RESULT, true);
            DetailRect.HMSSCAN_SDK_VALUE = i10;
            boolean z11 = i10 >= 2;
            if (z11) {
                i9 = w7.b(i9);
            }
            i8 = i9;
            z6 = z10;
            z7 = z11;
        }
        Bundle bundle = (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        String str = "";
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            z8 = false;
            z9 = false;
        } else {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getString(DetailRect.CP_PACKAGE, "");
            z8 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.USE_APK, false);
            z9 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
        }
        if (z9 && !r3.f34730a && z8) {
            return new HmsScanResult(4096, new HmsScan[]{r6.b()});
        }
        if (this.f33945a == null && y3.a(str, y3.a())) {
            try {
                this.f33945a = new w3(bundle, Registry.f14551l);
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        r3.f34735f = z5;
        return r6.a().a(bArr, i6, i7, i8, z6, z7, this.f33945a);
    }
}
