package cn.jiguang.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.ba.l;
import cn.jiguang.bb.f;
import cn.jiguang.bi.g;
import cn.jiguang.bi.j;
import cn.jiguang.bz.v;
import cn.jiguang.internal.JConstants;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends JDispatchAction {
    private static JSONObject a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array());
            wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            f.c("JCoreDispatchAction", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e6) {
            f.i("JCoreDispatchAction", "parseBundle2Json exception:" + e6.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i6, int i7, long j6, long j7, ByteBuffer byteBuffer) {
        try {
            a(context, j7, i6, byteBuffer);
        } catch (Throwable th) {
            f.i("JCoreDispatchAction", "dispatchMessage failed:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i6) {
        return i6 == 0 || i6 == 1 || i6 == 19 || i6 == 25 || i6 == 26 || i6 == 30 || i6 == 32;
    }

    private void a(Context context, long j6, int i6, ByteBuffer byteBuffer) {
        if (i6 == 19) {
            g.a().a(context, "tcp_a18", null);
            return;
        }
        if (i6 == 41) {
            b(context, byteBuffer);
            return;
        }
        if (i6 == 25) {
            a(context, byteBuffer);
            return;
        }
        if (i6 == 26 && byteBuffer != null) {
            short s5 = byteBuffer.getShort();
            if (s5 == 0) {
                j.a().a(context, j6);
            } else {
                j.a().a(context, j6, s5);
            }
        }
    }

    private void b(Context context, ByteBuffer byteBuffer) {
        try {
            if (byteBuffer != null) {
                short s5 = byteBuffer.getShort();
                f.d("JCoreDispatchAction", "setCountry code:" + ((int) s5));
                if (s5 == 0) {
                    return;
                }
            } else {
                f.d("JCoreDispatchAction", "setCountry body null");
            }
        } catch (Throwable th) {
            f.d("JCoreDispatchAction", "setCountry fail:", th);
        }
        g.a().a(context, "tcp_a25", new Bundle());
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "core_sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return cn.jiguang.a.a.f1444b;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        if (bundle != null) {
            try {
                if (!TextUtils.isEmpty(str2) && !str2.equals("asm") && !str2.equals("asmr")) {
                    if (str2.equals("lbsenable")) {
                        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ae().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(bundle.getBoolean("enable")))});
                        return;
                    }
                    if (str2.equals("lbsforenry")) {
                        try {
                            long j6 = bundle.getLong("forenry");
                            f.c("JCoreDispatchAction", "setLbsPermissionDialogShieldDelay=" + j6);
                            if (((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ab())).longValue() <= 0) {
                                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ab().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                            }
                            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ad().a((cn.jiguang.e.a<Long>) (j6 > 0 ? Long.valueOf(j6) : null))});
                            return;
                        } catch (Throwable th) {
                            f.l("JCoreDispatchAction", "onActionRun failed:" + th);
                            return;
                        }
                    }
                    if (!str2.equals("notification_state")) {
                        if (!str2.equals("old_cmd")) {
                            if (str2.equals("user_present")) {
                                return;
                            }
                            if (!str2.equals("set_wake_enable")) {
                                if (str2.equals("open_log")) {
                                    a(context, bundle);
                                    return;
                                } else if ("country".equals(str2)) {
                                    JConstants.testCountry = bundle.getString("country");
                                    return;
                                } else {
                                    if ("save_exception_data".equals(str2)) {
                                        cn.jiguang.bw.a.a().a(bundle);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    cn.jiguang.v.a.a(context, str2, bundle);
                }
            } catch (Throwable th2) {
                f.i("JCoreDispatchAction", "onActionRun failed:" + th2.getMessage());
            }
        }
    }

    private void a(Context context, Bundle bundle) {
        if (bundle != null) {
            try {
                JSONObject jSONObject = new JSONObject(v.b(bundle.getString("aes"), cn.jiguang.a.a.f1451i));
                f.c("JCoreDispatchAction", "jsonObject=" + jSONObject);
                cn.jiguang.d.a.a(context, jSONObject);
                if (jSONObject.has("u_l")) {
                    f.c("JCoreDispatchAction", "startUpload");
                    cn.jiguang.bb.b.b(context);
                }
                if (jSONObject.has("e_l")) {
                    f.c("JCoreDispatchAction", "set e_l");
                    cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.an().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(jSONObject.optBoolean("e_l")))});
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Context context, ByteBuffer byteBuffer) {
        JSONObject a6 = a(byteBuffer);
        if (a6 == null) {
            return;
        }
        try {
            int optInt = a6.optInt("cmd");
            JSONObject optJSONObject = a6.optJSONObject("content");
            f.c("JCoreDispatchAction", "deal command, cmd: " + optInt + ", content: " + (optJSONObject != null ? optJSONObject.toString() : ""));
            if (optInt == 75) {
                g.a().a(optJSONObject);
            } else if (optInt == 80) {
                cn.jiguang.ba.b.a(context, optJSONObject);
            } else if (optInt == 84) {
                l.a(context, optJSONObject);
            }
            Bundle bundle = new Bundle();
            bundle.putByteArray("RESPONSE_BODY", byteBuffer.array());
            cn.jiguang.v.a.a(context, "cmd", bundle);
        } catch (Throwable th) {
            f.i("JCoreDispatchAction", "deal command failed, " + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
    }
}
