package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;
import com.huawei.hms.scankit.p.r6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.y3;
import com.huawei.hms.scankit.util.OpencvJNI;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class g extends IRemoteHmsDecoderDelegate.Stub {

    /* renamed from: b, reason: collision with root package name */
    private static volatile g f33947b = new g();

    /* renamed from: a, reason: collision with root package name */
    private volatile w3 f33948a = null;

    static g a() {
        return f33947b;
    }

    private Bundle a(IObjectWrapper iObjectWrapper) {
        return (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) ? new Bundle() : (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
    public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        boolean z5;
        boolean z6;
        if (!r3.A) {
            OpencvJNI.init();
        }
        o4.d("Scankit", "start decodeInBitmap");
        Bundle a6 = a(iObjectWrapper2);
        String str = "";
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            z6 = false;
        } else {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getString(DetailRect.CP_PACKAGE, "");
            z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.USE_APK, false);
            z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
        }
        if (z6 && !r3.f34730a && z5) {
            return new HmsScan[]{r6.b()};
        }
        if (this.f33948a == null && y3.a(str, y3.a())) {
            try {
                this.f33948a = new w3(a6, "MultiProcessor");
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        o4.d("scankit mul", "end decodeInBitmap");
        return a(iObjectWrapper, iObjectWrapper2);
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate
    public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        boolean z5;
        boolean z6;
        if (!r3.A) {
            OpencvJNI.init();
        }
        Bundle a6 = a(iObjectWrapper2);
        String str = "";
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            z6 = false;
        } else {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getString(DetailRect.CP_PACKAGE, "");
            z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.USE_APK, false);
            z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.SUPPORT_ROLLBACK, false);
        }
        if (z6 && !r3.f34730a && z5) {
            return new HmsScan[]{r6.b()};
        }
        if (this.f33948a == null && y3.a(str, y3.a())) {
            try {
                this.f33948a = new w3(a6, "MultiProcessor");
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(detailRect, iObjectWrapper, iObjectWrapper2);
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z5;
        boolean z6;
        int i6;
        boolean z7;
        o4.d("Scankit", "start getHmsMLVisionScanResultByBitmap");
        if (iObjectWrapper == null) {
            o4.b("ScankitRemote", "bitmap is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            z6 = false;
            i6 = 0;
            z7 = false;
        } else {
            z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            r3.f34732c = z6;
            i6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            boolean z8 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
            z7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, false);
            int i7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i7;
            r2 = i7 >= 2;
            if (r2) {
                i6 = w7.b(i6);
            }
            z5 = r2;
            r2 = z8;
        }
        r3.f34735f = r2;
        r3.f34736g = z7;
        if (unwrap instanceof Bitmap) {
            o4.d("Scankit", "end getHmsMLVisionScanResultByBitmap");
            HmsScan[] a6 = r6.a().a((Bitmap) unwrap, i6, z6, this.f33948a);
            return !z5 ? w7.a(a6) : a6;
        }
        return new HmsScan[0];
    }

    private HmsScan[] a(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z5;
        boolean z6;
        int i6;
        boolean z7;
        if (iObjectWrapper == null) {
            o4.b("ScankitRemoteS", "bytebuffer is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z5 = false;
            z6 = false;
            i6 = 0;
            z7 = false;
        } else {
            int i7 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            boolean z8 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i8 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i8;
            boolean z9 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
            z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.NEW_VERSION, false);
            r1 = i8 >= 2;
            if (r1) {
                i7 = w7.b(i7);
            }
            i6 = i7;
            z7 = z8;
            z6 = r1;
            r1 = z9;
        }
        r3.f34735f = r1;
        r3.f34736g = z5;
        if (unwrap instanceof ByteBuffer) {
            HmsScan[] a6 = r6.a().a((ByteBuffer) unwrap, detailRect == null ? 1000 : detailRect.width, detailRect == null ? 1000 : detailRect.height, i6, z7, this.f33948a);
            return !z6 ? w7.a(a6) : a6;
        }
        return new HmsScan[0];
    }
}
