package cn.jiguang.bx;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.api.SdkType;
import com.tencent.connect.common.Constants;
import io.netty.handler.codec.http2.Http2CodecUtil;
import java.nio.ByteBuffer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g extends JDispatchAction {
    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i6, int i7, long j6, long j7, ByteBuffer byteBuffer) {
        JAction jAction;
        long j8;
        Context context2;
        ByteBuffer byteBuffer2;
        c cVar;
        JAction a6 = a(str);
        if (a6 != null) {
            d.b("SupportDispatchAction", "dispatchMessage ,command:" + i6 + ",ver:" + i7 + ",rid:" + j6 + ",reuqestId:" + j7);
            if (str.equals(SdkType.JMESSAGE.name())) {
                j8 = 0;
                byteBuffer2 = byteBuffer;
                jAction = a6;
                cVar = new c(false, byteBuffer.limit() + 20, i7, i6, j6, JCoreInterface.getSid(), JCoreInterface.getUid());
                context2 = context;
            } else {
                jAction = a6;
                j8 = 0;
                context2 = context;
                byteBuffer2 = byteBuffer;
                cVar = new c(false, i7, i6, j7);
            }
            jAction.dispatchMessage(context2, j8, i6, cVar, byteBuffer2);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 3;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return Http2CodecUtil.MAX_WEIGHT;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return Http2CodecUtil.MAX_WEIGHT;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 0;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return Constants.PARAM_SDK_VER;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return "statistics_sdk_ver";
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return "share_sdk_ver";
        }
        if (str.equals(SdkType.JAD.name())) {
            return "ssp_sdk_ver";
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return "im_sdk_ver";
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return "verification_sdk_ver";
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return "mlink_sdk_ver";
        }
        if (str.equals(SdkType.JUNION.name())) {
            return "junion_sdk_ver";
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 9;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 10;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 11;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 12 : (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
        d.b("SupportDispatchAction", "handleMessage,sdkType:" + str);
        JAction a6 = a(str);
        if (a6 != null) {
            a6.handleMessage(context, 0L, obj);
        }
    }

    private JAction a(String str) {
        return a.a().a(str);
    }

    private JActionExtra b(String str) {
        return a.a().b(str);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforLogin(Context context, String str, int i6, String str2) {
        JActionExtra b6 = b(str);
        if (b6 != null) {
            return b6.beforLogin(context, i6, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforRegister(Context context, String str, int i6, String str2) {
        JActionExtra b6 = b(str);
        if (b6 != null) {
            return b6.beforRegister(context, i6, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean checkAction(String str, int i6) {
        JActionExtra b6 = b(str);
        if (b6 != null) {
            return b6.checkAction(i6);
        }
        return true;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchTimeOutMessage(Context context, String str, long j6, int i6) {
        JAction a6 = a(str);
        if (a6 != null) {
            a6.dispatchTimeOutMessage(context, 0L, j6, i6);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        JAction a6 = a(str);
        if (a6 != null) {
            return a6.getSdkVersion();
        }
        return "";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i6) {
        JAction a6 = a(str);
        if (a6 != null) {
            return a6.isSupportedCMD(i6);
        }
        return false;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        JAction a6 = a(str);
        if (a6 != null) {
            a6.onActionRun(context, 0L, bundle, null);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onEvent(Context context, String str, int i6, int i7, String str2) {
        JAction a6 = a(str);
        if (a6 != null) {
            a6.onEvent(context, 0L, i6);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object onSendData(Context context, String str, long j6, int i6, int i7) {
        JActionExtra b6 = b(str);
        if (b6 != null) {
            return b6.onSendData(context, 0L, j6, i6, i7);
        }
        return null;
    }
}
