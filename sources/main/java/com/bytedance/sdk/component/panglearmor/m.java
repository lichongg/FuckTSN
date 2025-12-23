package com.bytedance.sdk.component.panglearmor;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.vl;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static String f26700j;
    private static ae oq;
    private static AtomicBoolean xt = new AtomicBoolean(false);
    private static final AtomicBoolean cw = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    private static String f26702r = "";
    private static long up = 0;

    /* renamed from: m, reason: collision with root package name */
    private static int f26701m = 0;
    private static xt ae = null;
    private static volatile DisplayManager.DisplayListener tl = null;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f26699g = false;

    @DungeonFlag
    public static String xt() {
        if (g.xt() && oq != null) {
            final Handler j6 = com.bytedance.sdk.component.utils.tl.j();
            final tl ae2 = ae();
            j6.post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.m.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!m.cw.get()) {
                            xt unused = m.ae = xt.j((Application) m.oq.j());
                            m.xt(j6);
                        }
                        up.j(m.oq.j());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        Object j7 = m.j(1001, new Object[]{m.oq.j()});
                        if (j7 instanceof String) {
                            String unused2 = m.f26702r = (String) j7;
                        }
                    } catch (Throwable th) {
                        String unused3 = m.f26702r = m.xt(th);
                    }
                    if (ae2 == null || m.xt.getAndSet(true)) {
                        return;
                    }
                    JSONObject j8 = com.bytedance.sdk.component.panglearmor.j.j.j().j(m.oq.j(), m.oq.xt());
                    if (j8 != null && j8.length() > 0) {
                        ae2.j("detailed_app_info", j8);
                    }
                    m.xt.set(false);
                }
            });
        }
        if (TextUtils.isEmpty(f26702r)) {
            String gc = SoftDecTool.gc();
            if (!TextUtils.isEmpty(gc)) {
                f26702r = gc;
            }
        }
        return TextUtils.isEmpty(f26702r) ? "eyJzdHRzIjoxfQ==" : f26702r;
    }

    public static tl ae() {
        ae aeVar = oq;
        if (aeVar != null) {
            return aeVar.r();
        }
        return null;
    }

    public static String cw() {
        if (f26700j == null) {
            Object j6 = j(1011, new Object[0]);
            if (j6 instanceof String) {
                f26700j = (String) j6;
            }
        }
        String str = f26700j;
        return str != null ? str : "";
    }

    public static int g() {
        return f26701m;
    }

    public static String m() {
        ae aeVar = oq;
        if (aeVar != null) {
            return aeVar.xt();
        }
        return null;
    }

    public static Context r() {
        ae aeVar = oq;
        if (aeVar != null) {
            return aeVar.j();
        }
        return null;
    }

    public static long tl() {
        return up;
    }

    public static boolean up() {
        ae aeVar = oq;
        if (aeVar != null) {
            return aeVar.cw();
        }
        return false;
    }

    public static void j(ae aeVar) {
        oq = aeVar;
    }

    public static void j() {
        try {
            Context r5 = r();
            if (!up() || cw.getAndSet(true) || r5 == null) {
                return;
            }
            if (ae != null) {
                xt.j((Application) r5).xt((Application) r5);
                ae = null;
            }
            if (tl != null) {
                ((DisplayManager) r5.getSystemService("display")).unregisterDisplayListener(tl);
                f26699g = false;
                tl = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void xt(Handler handler) {
        if (!g.xt() || f26699g || r() == null) {
            return;
        }
        f26699g = true;
        if (tl == null) {
            tl = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglearmor.m.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i6) {
                    if (i6 != 0) {
                        try {
                            m.j(1003, new Object[]{Integer.valueOf(i6), m.r()});
                        } catch (Throwable th) {
                            vl.j(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i6) {
                    if (i6 != 0) {
                        try {
                            m.j(1005, new Object[]{Integer.valueOf(i6), m.r()});
                        } catch (Throwable th) {
                            vl.j(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i6) {
                    if (i6 != 0) {
                        try {
                            m.j(1004, new Object[]{Integer.valueOf(i6), m.r()});
                        } catch (Throwable th) {
                            vl.j(th);
                        }
                    }
                }
            };
        }
        ((DisplayManager) r().getSystemService("display")).registerDisplayListener(tl, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String xt(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            f26702r = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            vl.j(th2);
            f26702r = "eyJzdHRzIjozfQ==";
        }
        return f26702r;
    }

    @DungeonFlag
    public static Object j(int i6, Object[] objArr) {
        return SoftDecTool.cn(i6, objArr);
    }

    @DungeonFlag
    public static void j(final MotionEvent motionEvent) {
        if (motionEvent == null || !g.xt() || r() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.bytedance.sdk.component.utils.tl.j().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.j(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), m.r()});
                }
            });
        }
    }

    @DungeonFlag
    public static void j(long j6, int i6) {
        up = j6;
        f26701m = i6;
    }

    public static String j(String str, long j6, int i6, boolean z5) {
        try {
            xt xtVar = ae;
            if (xtVar != null) {
                return xtVar.j(str, j6, i6, z5);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String j(String str, String str2) {
        Object j6 = j(1010, new String[]{str, str2});
        return j6 instanceof String ? (String) j6 : str2;
    }
}
