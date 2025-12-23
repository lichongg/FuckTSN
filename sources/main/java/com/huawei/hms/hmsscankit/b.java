package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanFrame;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.y3;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile IRemoteHmsDecoderDelegate f33741a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f33742b = "b";

    static HmsScan[] a(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScan[] detectWithByteBuffer;
        int i6;
        o4.d("scankit mul", "start detectForHmsDector");
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f33741a == null) {
            IRemoteCreator c6 = g.c(context);
            if (c6 != null) {
                try {
                    f33741a = c6.newRemoteHmsDecoderDelegate();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
            return hmsScanArr;
        }
        if (f33741a != null) {
            try {
                DetailRect detailRect = mLFrame.acquireProperty() != null ? new DetailRect(mLFrame.acquireProperty().getWidth(), mLFrame.acquireProperty().getHeight()) : new DetailRect();
                Bundle bundle = new Bundle();
                if (hmsScanAnalyzerOptions != null && (i6 = hmsScanAnalyzerOptions.mode) != 0) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, i6);
                    bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                }
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f33754c);
                bundle.putBoolean(DetailRect.USE_APK, g.f33752a);
                bundle.putAll(y3.a(context));
                if (mLFrame.readBitmap() != null) {
                    o4.d("scankit mul", "end detectForHmsDector");
                    detectWithByteBuffer = f33741a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    detectWithByteBuffer = f33741a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                }
                f.a(detectWithByteBuffer);
                if (g.a()) {
                    IRemoteCreator c7 = g.c(context);
                    if (c7 != null) {
                        try {
                            f33741a = c7.newRemoteHmsDecoderDelegate();
                        } catch (RemoteException unused2) {
                            o4.b(f33742b, "RemoteException");
                        }
                        o4.d("scankit mul", "iRemoteDecoderDelegate rollback");
                        detectWithByteBuffer = mLFrame.readBitmap() != null ? f33741a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle)) : f33741a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                    }
                }
                if (detectWithByteBuffer != null) {
                    return detectWithByteBuffer;
                }
            } catch (RemoteException unused3) {
                o4.b("exception", "RemoteException");
            }
        }
        return hmsScanArr;
    }

    static HmsScan[] a(Context context, HmsScanFrame hmsScanFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScan[] detectWithByteBuffer;
        HmsScan[] detectWithByteBuffer2;
        o4.d("scankit mul", "start detectForHmsDector");
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (f33741a == null) {
            IRemoteCreator c6 = g.c(context);
            if (c6 != null) {
                try {
                    f33741a = c6.newRemoteHmsDecoderDelegate();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
            return hmsScanArr;
        }
        if (f33741a != null) {
            try {
                DetailRect detailRect = new DetailRect(hmsScanFrame.getWidth(), hmsScanFrame.getHeight());
                Bundle bundle = new Bundle();
                if (hmsScanAnalyzerOptions != null) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                    bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
                    bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                }
                bundle.putBoolean(DetailRect.SUPPORT_ROLLBACK, g.f33754c);
                bundle.putBoolean(DetailRect.USE_APK, g.f33752a);
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.NEW_VERSION, true);
                bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
                bundle.putAll(y3.a(context));
                if (hmsScanFrame.getBitmap() != null) {
                    o4.d("scankit mul", "end detectForHmsDector");
                    detectWithByteBuffer = f33741a.decodeInBitmap(detailRect, ObjectWrapper.wrap(hmsScanFrame.getBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    detectWithByteBuffer = f33741a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(ByteBuffer.wrap(hmsScanFrame.getYuvImage().getYuvData())), ObjectWrapper.wrap(bundle));
                }
                f.a(detectWithByteBuffer);
                if (g.a()) {
                    IRemoteCreator c7 = g.c(context);
                    if (c7 != null) {
                        try {
                            f33741a = c7.newRemoteHmsDecoderDelegate();
                        } catch (RemoteException unused2) {
                            o4.b(f33742b, "RemoteException");
                        }
                        o4.d("scankit mul", "iRemoteDecoderDelegate rollback");
                        if (hmsScanFrame.getBitmap() != null) {
                            detectWithByteBuffer2 = f33741a.decodeInBitmap(detailRect, ObjectWrapper.wrap(hmsScanFrame.getBitmap()), ObjectWrapper.wrap(bundle));
                        } else {
                            detectWithByteBuffer2 = f33741a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(ByteBuffer.wrap(hmsScanFrame.getYuvImage().getYuvData())), ObjectWrapper.wrap(bundle));
                        }
                        detectWithByteBuffer = detectWithByteBuffer2;
                    }
                }
                if (detectWithByteBuffer != null) {
                    return detectWithByteBuffer;
                }
            } catch (RemoteException unused3) {
                o4.b("exception", "RemoteException");
            }
        }
        return hmsScanArr;
    }
}
