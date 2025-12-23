package cn.jiguang.c;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ba.e;
import cn.jiguang.ba.h;
import cn.jiguang.ba.i;
import cn.jiguang.ba.k;
import cn.jiguang.bb.c;
import cn.jiguang.bb.f;
import cn.jiguang.bz.o;
import cn.jiguang.bz.w;
import cn.jiguang.bz.x;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreHelperAction;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends JCoreHelperAction {

    /* renamed from: a, reason: collision with root package name */
    public static List<Integer> f2800a;

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f2801b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2802c = false;

    private static class a implements Callable<Map<String, String>> {

        /* renamed from: a, reason: collision with root package name */
        private Context f2808a;

        /* renamed from: b, reason: collision with root package name */
        private Integer f2809b;

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, String> call() {
            return cn.jiguang.dy.b.c(this.f2808a, this.f2809b.intValue());
        }

        public a(Context context, Integer num) {
            this.f2808a = context;
            this.f2809b = num;
        }
    }

    /* renamed from: cn.jiguang.c.b$b, reason: collision with other inner class name */
    class C0039b extends cn.jiguang.by.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f2811b;

        /* renamed from: c, reason: collision with root package name */
        private Intent f2812c;

        /* renamed from: d, reason: collision with root package name */
        private String f2813d;

        public C0039b(Context context, Intent intent, String str) {
            this.f2811b = context;
            this.f2813d = str;
            this.f2812c = intent;
            this.f2653h = "JCoreHelper#PushReceiverAction";
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                ActionManager.getInstance().handleMessage(this.f2811b, this.f2813d, this.f2812c);
                b.this.a(this.f2811b, this.f2812c);
            } catch (Throwable th) {
                f.l("JCoreHelper", "[PushReceiverAction failed:]" + th.getMessage());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0018, code lost:
    
        if ((r6 instanceof java.lang.Integer) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.pm.PackageInfo a(android.content.Context r5, java.lang.Object... r6) {
        /*
            if (r5 == 0) goto L44
            if (r6 != 0) goto L5
            goto L44
        L5:
            int r0 = r6.length
            r1 = 1
            r2 = 0
            java.lang.String r3 = ""
            if (r0 != r1) goto L21
            r6 = r6[r2]
            boolean r0 = r6 instanceof java.lang.String
            if (r0 == 0) goto L16
            r3 = r6
            java.lang.String r3 = (java.lang.String) r3
            goto L34
        L16:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 == 0) goto L34
        L1a:
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r2 = r6.intValue()
            goto L34
        L21:
            int r0 = r6.length
            if (r0 <= r1) goto L34
            r0 = r6[r2]
            boolean r4 = r0 instanceof java.lang.String
            if (r4 == 0) goto L34
            r6 = r6[r1]
            boolean r1 = r6 instanceof java.lang.Integer
            if (r1 == 0) goto L34
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            goto L1a
        L34:
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 != 0) goto L3f
            android.content.pm.PackageInfo r5 = cn.jiguang.bz.p.a(r5, r3, r2)
            return r5
        L3f:
            android.content.pm.PackageInfo r5 = cn.jiguang.bz.p.a(r5, r2)
            return r5
        L44:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.c.b.a(android.content.Context, java.lang.Object[]):android.content.pm.PackageInfo");
    }

    private void b(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("set_country", str);
            bundle.putString("sdk_type", JConstants.SDK_TYPE);
            f.c("JCoreHelper", "setCountry action:" + str + " countrybundle=" + bundle);
            cn.jiguang.a.a.a(context, "tcp_set_country", bundle);
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sdk_type", str);
        cn.jiguang.a.a.a(context, "tcp_a8", bundle);
    }

    private static void d(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("sdk_type", str);
        cn.jiguang.a.a.a(context, "tcp_a9", bundle);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03b4 A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:3:0x000f, B:7:0x001a, B:9:0x0024, B:12:0x002c, B:17:0x006a, B:19:0x006d, B:21:0x0073, B:27:0x0088, B:29:0x008b, B:31:0x0091, B:42:0x00aa, B:44:0x00c8, B:45:0x00d4, B:50:0x00dc, B:52:0x00df, B:57:0x010f, B:59:0x00fa, B:62:0x0101, B:65:0x0117, B:67:0x011c, B:69:0x0128, B:71:0x012b, B:73:0x0134, B:75:0x0140, B:77:0x014d, B:79:0x0156, B:82:0x0161, B:84:0x0164, B:86:0x016a, B:92:0x0177, B:94:0x017a, B:96:0x0180, B:101:0x018b, B:102:0x0379, B:105:0x0196, B:107:0x01a2, B:108:0x01a6, B:110:0x01b3, B:112:0x01f1, B:114:0x01f7, B:116:0x01fc, B:118:0x01ff, B:120:0x0205, B:126:0x0212, B:128:0x0215, B:130:0x021b, B:136:0x0228, B:139:0x022d, B:144:0x0242, B:147:0x024b, B:149:0x024e, B:151:0x0251, B:153:0x0258, B:155:0x025d, B:157:0x0262, B:159:0x026b, B:162:0x0278, B:164:0x027b, B:166:0x0281, B:171:0x02a4, B:174:0x02b3, B:176:0x02b7, B:178:0x02bd, B:180:0x02c5, B:186:0x02d2, B:188:0x02d5, B:191:0x02db, B:193:0x02de, B:195:0x02e4, B:200:0x02f3, B:204:0x02fb, B:206:0x02ff, B:208:0x0305, B:210:0x030b, B:216:0x031a, B:218:0x031d, B:220:0x0322, B:223:0x0329, B:225:0x032d, B:227:0x0333, B:229:0x0339, B:236:0x0348, B:238:0x034b, B:240:0x0351, B:246:0x035a, B:248:0x035d, B:250:0x0363, B:251:0x0367, B:257:0x036e, B:259:0x0371, B:261:0x0377, B:266:0x0380, B:268:0x0383, B:270:0x0389, B:276:0x0394, B:278:0x0397, B:280:0x039d, B:282:0x03b4, B:286:0x03be, B:288:0x03c2, B:290:0x03c8, B:292:0x03d0, B:294:0x03d8, B:301:0x03f5, B:303:0x03fe, B:306:0x0409, B:308:0x040d, B:310:0x0413, B:312:0x0419, B:314:0x0420, B:318:0x0427, B:321:0x0434, B:323:0x0437, B:325:0x043d, B:327:0x0443, B:328:0x048b, B:331:0x04b1, B:332:0x04c3, B:334:0x04c8, B:336:0x04d2, B:341:0x0464, B:343:0x046a, B:346:0x0487, B:347:0x04dc, B:353:0x04e8, B:355:0x04ec, B:357:0x04f2, B:360:0x01ec, B:362:0x04fa, B:367:0x0503, B:369:0x0507, B:371:0x050d, B:373:0x0513, B:376:0x051b, B:379:0x0535, B:385:0x053f, B:387:0x0543, B:392:0x0559, B:394:0x055c, B:399:0x056b, B:401:0x056f, B:407:0x05b1, B:409:0x05b4, B:411:0x05ba, B:413:0x05c2, B:415:0x05c6, B:417:0x05cc, B:418:0x05cf, B:421:0x05da, B:423:0x05df, B:425:0x05e8, B:427:0x05f0, B:429:0x05f4, B:432:0x05fd, B:434:0x0605, B:436:0x0609, B:439:0x0612, B:441:0x061a, B:443:0x0623, B:446:0x062b, B:448:0x062e, B:450:0x0634, B:455:0x0645, B:458:0x064f, B:460:0x0652, B:462:0x0658, B:467:0x0669, B:470:0x0673, B:472:0x0676, B:474:0x067c, B:479:0x0689, B:482:0x0693, B:484:0x0696, B:486:0x069c, B:492:0x06a9, B:495:0x06b0, B:497:0x06b4, B:501:0x06e5, B:503:0x06f2, B:506:0x06f9, B:508:0x06fd, B:510:0x0703, B:516:0x0720, B:518:0x0723, B:520:0x0728, B:522:0x0731, B:525:0x0738, B:527:0x073b, B:529:0x0741, B:535:0x074a, B:537:0x074e, B:539:0x0754, B:541:0x075a, B:548:0x0769, B:550:0x076d, B:552:0x0773, B:554:0x0779, B:556:0x0781, B:558:0x0787, B:567:0x07b2, B:568:0x07b6, B:571:0x07bb, B:574:0x07c4, B:576:0x07c7, B:578:0x07cd, B:584:0x07da, B:586:0x07dd, B:588:0x07e3, B:594:0x07ec, B:596:0x07f0, B:598:0x07f6, B:600:0x07fe, B:602:0x0804, B:609:0x0853, B:613:0x085c, B:615:0x085f, B:617:0x0865, B:623:0x0873, B:625:0x0876, B:627:0x087c, B:634:0x088d, B:637:0x0895, B:639:0x089d, B:644:0x08b1, B:646:0x08b4, B:648:0x08ba, B:649:0x08ce, B:655:0x08d5, B:657:0x08d9, B:659:0x08df, B:661:0x08e3, B:663:0x08e7, B:666:0x08f2, B:668:0x08f5, B:670:0x08fb, B:674:0x090e, B:677:0x0917, B:679:0x091a, B:681:0x0920, B:686:0x093a, B:688:0x0949, B:690:0x095b, B:692:0x0964, B:695:0x096f, B:697:0x0972, B:699:0x0978, B:701:0x0987, B:704:0x0992, B:706:0x0996, B:708:0x099a, B:710:0x09a0, B:712:0x09a7, B:718:0x09c9, B:722:0x09d4, B:724:0x09d8, B:726:0x09de, B:733:0x09ec, B:735:0x09ef, B:737:0x09f6, B:741:0x0a03, B:743:0x0a06, B:745:0x0a0c, B:747:0x0a12, B:750:0x0a1f, B:756:0x0a2d, B:758:0x0a30, B:760:0x0a36, B:762:0x0a3c, B:765:0x0a56, B:767:0x0a48, B:774:0x0a5e, B:776:0x0a63, B:778:0x0a68, B:780:0x0a6d, B:782:0x0a72, B:784:0x0a77, B:786:0x0a7c, B:788:0x0a81, B:790:0x0a87, B:792:0x0a8c, B:794:0x0a91, B:807:0x01db, B:797:0x01c0, B:799:0x01ca, B:801:0x01d0), top: B:2:0x000f, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x04af  */
    @Override // cn.jiguang.internal.JCoreHelperAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object onEvent(android.content.Context r28, java.lang.String r29, int r30, java.lang.String r31, android.os.Bundle r32, final java.lang.Object... r33) {
        /*
            Method dump skipped, instructions count: 3014
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.c.b.onEvent(android.content.Context, java.lang.String, int, java.lang.String, android.os.Bundle, java.lang.Object[]):java.lang.Object");
    }

    static {
        ArrayList arrayList = new ArrayList();
        f2800a = arrayList;
        arrayList.add(18);
        f2800a.add(13);
        f2800a.add(52);
        f2800a.add(98);
        f2800a.add(7);
        f2800a.add(111);
        f2800a.add(99);
        f2800a.add(104);
        f2800a.add(119);
        f2800a.add(120);
        f2800a.add(121);
        f2800a.add(123);
        f2800a.add(100);
        f2800a.add(76);
        f2800a.add(42);
        f2800a.add(89);
        f2800a.add(90);
        f2800a.add(92);
        f2800a.add(95);
        f2800a.add(102);
        f2800a.add(108);
        f2800a.add(109);
        f2800a.add(111);
        f2800a.add(116);
        f2800a.add(122);
        f2800a.add(73);
        f2800a.add(128);
        f2800a.add(64);
        f2800a.add(25);
        f2800a.add(66);
        f2800a.add(75);
        f2800a.add(76);
        f2800a.add(77);
        f2800a.add(78);
        f2800a.add(83);
        f2800a.add(105);
        f2800a.add(Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE));
        f2800a.add(131);
        f2801b = new String[]{"JDevice", "JWakeCmd", "JWake", "JCommon", "JArp", "JLocation"};
    }

    private static Bundle a(Context context, int i6, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            if (i6 == 4096) {
                if (bundle != null) {
                    a(context, cn.jiguang.ba.a.a(bundle, "arg1"));
                }
                return bundle2;
            }
            if (i6 == 4098) {
                JCoreManager.init(context);
                return bundle2;
            }
            switch (i6) {
                case 36864:
                    a(bundle);
                    break;
                case 36865:
                    if (JCoreManager.isInternal()) {
                        JConstants.testAndroidQ();
                        break;
                    }
                    break;
            }
            return null;
        } catch (Throwable th) {
            f.l("JCoreHelper", "si e:" + th);
            return null;
        }
    }

    private void c(Context context, String str, Bundle bundle) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bundle", w.a(bundle));
            jSONObject.put(com.umeng.ccg.a.f41544t, str);
            cn.jiguang.bi.b.a().a(context, 2010, 0, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    private static void d(Context context, String str, Bundle bundle) {
        if (bundle != null) {
            try {
                boolean z5 = bundle.getBoolean("sdk_banned");
                f.c("JCoreHelper", "[handleSdkBannedStatusChanged] sdk banned: " + z5);
                if (!z5) {
                    d(context, str);
                } else {
                    c(context, str);
                    cn.jiguang.bm.b.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType);
                }
            } catch (Throwable th) {
                f.i("JCoreHelper", "network change handler error, " + th.getMessage());
            }
        }
    }

    private static void e(Context context, String str, Bundle bundle) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (bundle != null) {
            try {
                f.c("JCoreHelper", "[handleConnectionChanged] connected: " + bundle.getBoolean("connected"));
            } catch (Throwable th) {
                f.i("JCoreHelper", "network change handler error, " + th.getMessage());
                return;
            }
        }
        x.a();
        Intent intent = new Intent();
        intent.setAction("android.net.conn.CONNECTIVITY_CHANGE");
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            intent.putExtra("networkInfo", activeNetworkInfo);
            f.c("JCoreHelper", "networkInfo, available: " + activeNetworkInfo.isAvailable() + ", type: " + activeNetworkInfo.getType());
        }
        ActionManager.getInstance().handleMessage(context, str, intent);
        boolean z5 = JConstants.isCallInit.get();
        f.c("JCoreHelper", "networkInfo isCallInit: " + z5);
        if (z5) {
            cn.jiguang.v.a.a(context, "action_net_changed", bundle);
            cn.jiguang.a.a.a(context, "tcp_a15", bundle);
        }
    }

    public void b(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.b(context, str, bundle);
    }

    private Boolean a(int i6) {
        if (!f2800a.contains(Integer.valueOf(i6))) {
            if (h.b()) {
                if (i6 == 82) {
                    return Boolean.TRUE;
                }
                return null;
            }
            if (i.a()) {
                return null;
            }
        }
        return Boolean.FALSE;
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Bundle directHandle(Context context, String str, String str2, Bundle bundle) {
        return e.a().b(context, str, str2, bundle);
    }

    @Override // cn.jiguang.internal.JCoreHelperAction
    public Object onCommonMethod(Context context, String str, Object obj) {
        return cn.jiguang.v.a.a(context, str, obj);
    }

    public static String a(Context context) {
        Pair<String, Long> d6 = cn.jiguang.ba.a.d(context);
        return (d6 == null || w.a((String) d6.first)) ? "" : (String) d6.first;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Intent intent) {
        Method declaredMethod;
        Object invoke;
        boolean z5;
        Bundle extras;
        f.c("JCoreHelper", "[handleReceiverIntent]:" + intent.getAction());
        cn.jiguang.v.a.a(context, "get_receiver", intent);
        String action = intent.getAction();
        if (action == null) {
            f.i("JCoreHelper", "onReceive empty action");
            return;
        }
        if (action.equals("android.intent.action.USER_PRESENT")) {
            return;
        }
        if (action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo == null) {
                f.i("JCoreHelper", "Not found networkInfo");
                return;
            }
            f.c("JCoreHelper", "Connection state changed to - " + networkInfo.toString());
            if (2 == networkInfo.getType() || 3 == networkInfo.getType()) {
                f.c("JCoreHelper", "MMS or SUPL network state change, to do nothing!");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                extras2 = new Bundle();
            }
            if (booleanExtra) {
                f.c("JCoreHelper", "No any network is connected");
                extras2.putBoolean("connected", false);
            } else {
                try {
                    if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                        f.c("JCoreHelper", "Network is connected.");
                        extras2.putBoolean("connected", true);
                    } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                        f.c("JCoreHelper", "Network is disconnected.");
                        extras2.putBoolean("connected", false);
                    } else {
                        f.c("JCoreHelper", "other network state - " + networkInfo.getState() + ". Do nothing.");
                    }
                } catch (Throwable unused) {
                    extras2.putBoolean("connected", o.c());
                }
            }
            cn.jiguang.a.a.a(context, "tcp_a15", extras2);
            return;
        }
        if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED") || action.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                try {
                    Class<?> cls = Class.forName("android.os.PowerManager");
                    if (action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                        Method declaredMethod2 = cls.getDeclaredMethod("isDeviceIdleMode", null);
                        if (declaredMethod2 != null) {
                            invoke = declaredMethod2.invoke(powerManager, null);
                            z5 = ((Boolean) invoke).booleanValue();
                        }
                        z5 = true;
                    } else {
                        if (action.equals("android.os.action.POWER_SAVE_MODE_CHANGED") && (declaredMethod = cls.getDeclaredMethod("isPowerSaveMode", null)) != null) {
                            invoke = declaredMethod.invoke(powerManager, null);
                            z5 = ((Boolean) invoke).booleanValue();
                        }
                        z5 = true;
                    }
                    if (z5) {
                        return;
                    }
                    f.c("JCoreHelper", "doze or powersave mode exit.");
                    cn.jiguang.a.a.a(context, true, 0L);
                    return;
                } catch (Throwable th) {
                    f.l("JCoreHelper", "handle DEVICE_IDLE_MODE_CHANGED or POWER_SAVE_MODE_CHANGED fail:" + th);
                    return;
                }
            }
            return;
        }
        if (!action.equals("noti_open_proxy")) {
            if (cn.jiguang.bq.b.f2515e.equals(action)) {
                Bundle extras3 = intent.getExtras();
                if (extras3 != null) {
                    cn.jiguang.bq.b.a().b(extras3.getString("data"));
                    return;
                }
                return;
            }
            if (!k.f1951a.equals(action) || (extras = intent.getExtras()) == null) {
                return;
            }
            k.a(context, extras.getString("data"));
            return;
        }
        if (intent.getBooleanExtra("debug_notification", false)) {
            String stringExtra = intent.getStringExtra("toastText");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            Toast makeText = Toast.makeText(context, stringExtra, 0);
            try {
                View view = makeText.getView();
                if (view instanceof LinearLayout) {
                    View childAt = ((LinearLayout) view).getChildAt(0);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (!w.a(stringExtra)) {
                            textView.setText(stringExtra);
                        }
                        textView.setTextSize(13.0f);
                    }
                }
            } catch (Exception unused2) {
            }
            makeText.show();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x006c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[Catch: all -> 0x009a, TryCatch #1 {all -> 0x009a, blocks: (B:16:0x006c, B:22:0x007c, B:24:0x0082, B:25:0x0084), top: B:15:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4 A[Catch: all -> 0x0115, TryCatch #0 {all -> 0x0115, blocks: (B:6:0x0012, B:26:0x009a, B:28:0x00a4, B:29:0x00ba, B:31:0x00c0, B:32:0x00c6, B:35:0x00cf, B:36:0x00e2, B:38:0x00e8, B:39:0x00fb, B:49:0x0110, B:51:0x0113), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0 A[Catch: all -> 0x0115, TryCatch #0 {all -> 0x0115, blocks: (B:6:0x0012, B:26:0x009a, B:28:0x00a4, B:29:0x00ba, B:31:0x00c0, B:32:0x00c6, B:35:0x00cf, B:36:0x00e2, B:38:0x00e8, B:39:0x00fb, B:49:0x0110, B:51:0x0113), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf A[Catch: all -> 0x0115, TRY_ENTER, TryCatch #0 {all -> 0x0115, blocks: (B:6:0x0012, B:26:0x009a, B:28:0x00a4, B:29:0x00ba, B:31:0x00c0, B:32:0x00c6, B:35:0x00cf, B:36:0x00e2, B:38:0x00e8, B:39:0x00fb, B:49:0x0110, B:51:0x0113), top: B:5:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e8 A[Catch: all -> 0x0115, TryCatch #0 {all -> 0x0115, blocks: (B:6:0x0012, B:26:0x009a, B:28:0x00a4, B:29:0x00ba, B:31:0x00c0, B:32:0x00c6, B:35:0x00cf, B:36:0x00e2, B:38:0x00e8, B:39:0x00fb, B:49:0x0110, B:51:0x0113), top: B:5:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.content.Context r8, android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.c.b.a(android.content.Context, android.os.Bundle):void");
    }

    public static void a(Context context, String str) {
        cn.jiguang.ba.a.a(context, str);
    }

    public static void a(Context context, String str, int i6, int i7, int i8) {
        Bundle bundle = new Bundle();
        bundle.putString(CommonNetImpl.NAME, str);
        bundle.putInt("custom", i6);
        bundle.putInt("dynamic", i7);
        bundle.putInt("sdk_v", i8);
        cn.jiguang.v.a.a(context, "set_sdktype_info", bundle);
    }

    public static void a(Context context, String str, Bundle bundle) {
        cn.jiguang.a.a.a(context, str, bundle);
    }

    public static void a(Context context, String str, Bundle bundle, String str2) {
        if (bundle != null) {
            bundle.putString("sdk_type", str);
            cn.jiguang.a.a.a(context, str2, bundle);
        }
    }

    public static void a(Context context, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        f.d("JCoreHelper", "runActionWithService action:" + str2);
        bundle.putString("sdk_type", str);
        bundle.putString("internal_action", str2);
        cn.jiguang.a.a.a(context, "a3", bundle);
    }

    public static void a(Context context, boolean z5) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_auth", z5);
            a(context, "set_auth", bundle);
        } catch (Throwable th) {
            f.j("JCoreHelper", "sendSaveAuth error:" + th);
        }
    }

    public void a(Context context, boolean z5, int i6) {
        f.c("JCoreHelper", "changeForegroudStat:" + z5 + ", userActiveType:" + i6);
        cn.jiguang.be.b.f2036b.set(z5);
        Bundle bundle = new Bundle();
        bundle.putBoolean("foreground", z5);
        bundle.putInt("user_type", i6);
        cn.jiguang.a.a.a(context, "a4", bundle);
    }

    public static void a(Bundle bundle) {
    }

    private static void a(String str, String str2, boolean z5, int i6, String str3, Throwable th) {
        c.a(str, str2, z5, i6, str3, th);
    }
}
