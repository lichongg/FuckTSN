package com.baidu.liantian.ac;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.liantian.a.a;
import com.baidu.liantian.b;
import com.baidu.liantian.core.d;
import com.baidu.liantian.e;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class U extends Thread {
    public static final int FROM_DAILY_ALARM = 6;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_HANDLE_REMOVE = 4;
    public static final int FROM_INIT = 1;
    public static final int FROM_INIT_ALARM = 2;
    public static final int FROM_NET_CHANGE = 3;
    public static final int FROM_OUT_FLASH = 5;
    public static final int NETWORK_TYPE_2G = 1;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_4G = 3;
    public static final int NETWORK_TYPE_MOBILE = 5;
    public static final int NETWORK_TYPE_UNCONNECTED = -1;
    public static final int NETWORK_TYPE_UNKNOWN = -2;
    public static final int NETWORK_TYPE_WIFI = 4;
    public static final int OUT_AES_FAIL = 8;
    public static final int OUT_FINISH = 1;
    public static final int OUT_NO_INTERNET = 3;
    public static final int OUT_NULL_APPKEY = 5;
    public static final int OUT_NULL_HOST_PKGINFO = 6;
    public static final int OUT_NULL_PLUGIN_JSON = 10;
    public static final int OUT_NULL_RESPONSE_JSON = 9;
    public static final int OUT_OTHER_THROWABLE = 11;
    public static final int OUT_PING_FAIL = 4;
    public static final int OUT_RESPONSE_EMPTY = 7;
    public static final int OUT_TIME_TOO_CLOSE = 2;
    public static final int OUT_UNSET = 0;
    public static final int TYPE_END = 1;
    public static final int TYPE_START = 0;
    public static final int UPGRADE_DECRYPT_FAIL = 7;
    public static final int UPGRADE_DOWNLOAD_FAIL = 4;
    public static final int UPGRADE_ERROR_CRASH_TIMES = 6;
    public static final int UPGRADE_LOAD_FAIL = 5;
    public static final int UPGRADE_MD5_FAIL = 8;
    public static final int UPGRADE_NETWORK_CHECK_FAIL = 3;
    public static final int UPGRADE_RESULT_EXCEPTION = 2;
    public static final int UPGRADE_RESULT_SUCCESS = 1;
    private static long sLastCheckTime;
    public static boolean sMonitorNetworkWhenUpgradeNoNet;
    private static volatile boolean sOutGoing;
    private static boolean sPidRegister;
    private static int sRetryDownoadHostCareApksTimesCount;
    private static int sRetryPingTimesCount;
    private static boolean sSetRetrmAlarm;
    private Context context;
    private d forHostAPP;
    private a loadedPluginDB;
    private Map<Integer, String> mCloudKeyMap;
    List<Integer> mDownloadPluginsList;
    private int mEndReason;
    private int mFrom;
    private boolean mOut;
    private Map<Integer, String> mStartKeyMap;
    private int mStartNetwork;
    List<Integer> mUnloadPluginsList;
    private Map<Integer, UpgradeResult> mUpgradeResultMap;
    private e preference;
    private File tmpDir;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class UpgradeResult {
        int networkId;
        int resultId;

        public UpgradeResult(int i6, int i7) {
            this.networkId = i6;
            this.resultId = i7;
        }
    }

    public U(Context context, int i6, boolean z5) {
        this.mFrom = 0;
        this.mEndReason = 0;
        this.mOut = false;
        this.mCloudKeyMap = new HashMap();
        this.mUnloadPluginsList = new ArrayList();
        this.mDownloadPluginsList = new ArrayList();
        this.mUpgradeResultMap = new HashMap();
        this.mStartNetwork = -2;
        this.context = context;
        this.loadedPluginDB = a.a(context);
        this.preference = new e(context);
        this.forHostAPP = d.a(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp_liantian");
        this.mFrom = i6;
        this.mOut = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:262:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x06dc A[Catch: all -> 0x0045, TryCatch #12 {all -> 0x0045, blocks: (B:19:0x0018, B:23:0x0029, B:25:0x002d, B:27:0x003b, B:29:0x003f, B:30:0x0048, B:42:0x005d, B:44:0x0065, B:45:0x006b, B:63:0x00af, B:66:0x00c0, B:68:0x00c4, B:69:0x00c6, B:71:0x00ce, B:75:0x0100, B:77:0x0104, B:78:0x0106, B:79:0x010d, B:80:0x00d6, B:82:0x00e6, B:83:0x00f1, B:84:0x010e, B:86:0x0118, B:88:0x011c, B:93:0x0130, B:94:0x0133, B:97:0x015c, B:436:0x0171, B:438:0x0177, B:442:0x017f, B:444:0x019d, B:446:0x01a8, B:447:0x01b7, B:449:0x01cc, B:450:0x01cf, B:451:0x01d6, B:452:0x01b4, B:453:0x0183, B:455:0x018f, B:99:0x01d7, B:101:0x01fe, B:106:0x029e, B:108:0x02b4, B:109:0x02b7, B:112:0x02cb, B:114:0x02ce, B:116:0x02d6, B:118:0x02de, B:120:0x02e9, B:121:0x02ec, B:133:0x02fe, B:135:0x0311, B:136:0x031b, B:138:0x032a, B:139:0x032f, B:144:0x0398, B:146:0x03b0, B:148:0x03b6, B:149:0x03de, B:150:0x03ec, B:151:0x0425, B:153:0x042b, B:158:0x0443, B:163:0x043d, B:165:0x0447, B:167:0x046c, B:168:0x0481, B:172:0x04a0, B:174:0x04a4, B:175:0x04a8, B:176:0x04af, B:177:0x04b0, B:179:0x04d9, B:183:0x04e3, B:184:0x04f1, B:186:0x04f9, B:188:0x04fd, B:189:0x0501, B:190:0x0508, B:191:0x0509, B:192:0x050d, B:194:0x0513, B:196:0x052e, B:197:0x0535, B:199:0x0549, B:202:0x0551, B:203:0x0555, B:206:0x0560, B:209:0x056d, B:211:0x0575, B:213:0x058a, B:216:0x05a3, B:256:0x06b0, B:257:0x06b4, B:260:0x06cd, B:263:0x06d8, B:265:0x06dc, B:266:0x06de, B:268:0x06e6, B:269:0x06f6, B:271:0x06fe, B:273:0x0706, B:275:0x070e, B:277:0x0718, B:278:0x0726, B:280:0x072c, B:282:0x073b, B:283:0x0740, B:285:0x0751, B:287:0x0761, B:290:0x0767, B:292:0x0773, B:294:0x0779, B:295:0x0780, B:297:0x078a, B:299:0x0791, B:300:0x07af, B:303:0x079b, B:305:0x07a1, B:306:0x07ac, B:307:0x07ba, B:309:0x07c1, B:313:0x06cb, B:342:0x07cb, B:344:0x07d1, B:345:0x07d4, B:346:0x07de, B:348:0x07e4, B:350:0x07f4, B:352:0x07f8, B:353:0x0801, B:358:0x080b, B:359:0x0831, B:361:0x0837, B:363:0x0841, B:365:0x0848, B:368:0x084b, B:369:0x085f, B:371:0x0865, B:373:0x0871, B:375:0x0879, B:377:0x0884, B:378:0x088a, B:381:0x0894, B:383:0x08a7, B:384:0x08aa, B:386:0x08d4, B:387:0x08d7, B:388:0x0921, B:390:0x0942, B:391:0x08df, B:393:0x08f2, B:395:0x0915, B:399:0x092e, B:401:0x0935, B:403:0x093f, B:408:0x0946, B:426:0x049a, B:427:0x0967, B:429:0x096b, B:430:0x096e, B:431:0x0975, B:433:0x0392, B:457:0x016e, B:459:0x0158, B:460:0x00b5, B:462:0x00ac, B:48:0x0075, B:49:0x0088, B:51:0x008e, B:54:0x0098, B:57:0x00a6, B:435:0x0162, B:91:0x0120, B:103:0x0216, B:105:0x0231, B:155:0x0437, B:259:0x06c1, B:142:0x038d, B:96:0x014c, B:170:0x0494), top: B:18:0x0018, outer: #18, inners: #1, #2, #4, #6, #10, #15, #20, #22, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x06e6 A[Catch: all -> 0x0045, TryCatch #12 {all -> 0x0045, blocks: (B:19:0x0018, B:23:0x0029, B:25:0x002d, B:27:0x003b, B:29:0x003f, B:30:0x0048, B:42:0x005d, B:44:0x0065, B:45:0x006b, B:63:0x00af, B:66:0x00c0, B:68:0x00c4, B:69:0x00c6, B:71:0x00ce, B:75:0x0100, B:77:0x0104, B:78:0x0106, B:79:0x010d, B:80:0x00d6, B:82:0x00e6, B:83:0x00f1, B:84:0x010e, B:86:0x0118, B:88:0x011c, B:93:0x0130, B:94:0x0133, B:97:0x015c, B:436:0x0171, B:438:0x0177, B:442:0x017f, B:444:0x019d, B:446:0x01a8, B:447:0x01b7, B:449:0x01cc, B:450:0x01cf, B:451:0x01d6, B:452:0x01b4, B:453:0x0183, B:455:0x018f, B:99:0x01d7, B:101:0x01fe, B:106:0x029e, B:108:0x02b4, B:109:0x02b7, B:112:0x02cb, B:114:0x02ce, B:116:0x02d6, B:118:0x02de, B:120:0x02e9, B:121:0x02ec, B:133:0x02fe, B:135:0x0311, B:136:0x031b, B:138:0x032a, B:139:0x032f, B:144:0x0398, B:146:0x03b0, B:148:0x03b6, B:149:0x03de, B:150:0x03ec, B:151:0x0425, B:153:0x042b, B:158:0x0443, B:163:0x043d, B:165:0x0447, B:167:0x046c, B:168:0x0481, B:172:0x04a0, B:174:0x04a4, B:175:0x04a8, B:176:0x04af, B:177:0x04b0, B:179:0x04d9, B:183:0x04e3, B:184:0x04f1, B:186:0x04f9, B:188:0x04fd, B:189:0x0501, B:190:0x0508, B:191:0x0509, B:192:0x050d, B:194:0x0513, B:196:0x052e, B:197:0x0535, B:199:0x0549, B:202:0x0551, B:203:0x0555, B:206:0x0560, B:209:0x056d, B:211:0x0575, B:213:0x058a, B:216:0x05a3, B:256:0x06b0, B:257:0x06b4, B:260:0x06cd, B:263:0x06d8, B:265:0x06dc, B:266:0x06de, B:268:0x06e6, B:269:0x06f6, B:271:0x06fe, B:273:0x0706, B:275:0x070e, B:277:0x0718, B:278:0x0726, B:280:0x072c, B:282:0x073b, B:283:0x0740, B:285:0x0751, B:287:0x0761, B:290:0x0767, B:292:0x0773, B:294:0x0779, B:295:0x0780, B:297:0x078a, B:299:0x0791, B:300:0x07af, B:303:0x079b, B:305:0x07a1, B:306:0x07ac, B:307:0x07ba, B:309:0x07c1, B:313:0x06cb, B:342:0x07cb, B:344:0x07d1, B:345:0x07d4, B:346:0x07de, B:348:0x07e4, B:350:0x07f4, B:352:0x07f8, B:353:0x0801, B:358:0x080b, B:359:0x0831, B:361:0x0837, B:363:0x0841, B:365:0x0848, B:368:0x084b, B:369:0x085f, B:371:0x0865, B:373:0x0871, B:375:0x0879, B:377:0x0884, B:378:0x088a, B:381:0x0894, B:383:0x08a7, B:384:0x08aa, B:386:0x08d4, B:387:0x08d7, B:388:0x0921, B:390:0x0942, B:391:0x08df, B:393:0x08f2, B:395:0x0915, B:399:0x092e, B:401:0x0935, B:403:0x093f, B:408:0x0946, B:426:0x049a, B:427:0x0967, B:429:0x096b, B:430:0x096e, B:431:0x0975, B:433:0x0392, B:457:0x016e, B:459:0x0158, B:460:0x00b5, B:462:0x00ac, B:48:0x0075, B:49:0x0088, B:51:0x008e, B:54:0x0098, B:57:0x00a6, B:435:0x0162, B:91:0x0120, B:103:0x0216, B:105:0x0231, B:155:0x0437, B:259:0x06c1, B:142:0x038d, B:96:0x014c, B:170:0x0494), top: B:18:0x0018, outer: #18, inners: #1, #2, #4, #6, #10, #15, #20, #22, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x072c A[Catch: all -> 0x0045, LOOP:4: B:278:0x0726->B:280:0x072c, LOOP_END, TryCatch #12 {all -> 0x0045, blocks: (B:19:0x0018, B:23:0x0029, B:25:0x002d, B:27:0x003b, B:29:0x003f, B:30:0x0048, B:42:0x005d, B:44:0x0065, B:45:0x006b, B:63:0x00af, B:66:0x00c0, B:68:0x00c4, B:69:0x00c6, B:71:0x00ce, B:75:0x0100, B:77:0x0104, B:78:0x0106, B:79:0x010d, B:80:0x00d6, B:82:0x00e6, B:83:0x00f1, B:84:0x010e, B:86:0x0118, B:88:0x011c, B:93:0x0130, B:94:0x0133, B:97:0x015c, B:436:0x0171, B:438:0x0177, B:442:0x017f, B:444:0x019d, B:446:0x01a8, B:447:0x01b7, B:449:0x01cc, B:450:0x01cf, B:451:0x01d6, B:452:0x01b4, B:453:0x0183, B:455:0x018f, B:99:0x01d7, B:101:0x01fe, B:106:0x029e, B:108:0x02b4, B:109:0x02b7, B:112:0x02cb, B:114:0x02ce, B:116:0x02d6, B:118:0x02de, B:120:0x02e9, B:121:0x02ec, B:133:0x02fe, B:135:0x0311, B:136:0x031b, B:138:0x032a, B:139:0x032f, B:144:0x0398, B:146:0x03b0, B:148:0x03b6, B:149:0x03de, B:150:0x03ec, B:151:0x0425, B:153:0x042b, B:158:0x0443, B:163:0x043d, B:165:0x0447, B:167:0x046c, B:168:0x0481, B:172:0x04a0, B:174:0x04a4, B:175:0x04a8, B:176:0x04af, B:177:0x04b0, B:179:0x04d9, B:183:0x04e3, B:184:0x04f1, B:186:0x04f9, B:188:0x04fd, B:189:0x0501, B:190:0x0508, B:191:0x0509, B:192:0x050d, B:194:0x0513, B:196:0x052e, B:197:0x0535, B:199:0x0549, B:202:0x0551, B:203:0x0555, B:206:0x0560, B:209:0x056d, B:211:0x0575, B:213:0x058a, B:216:0x05a3, B:256:0x06b0, B:257:0x06b4, B:260:0x06cd, B:263:0x06d8, B:265:0x06dc, B:266:0x06de, B:268:0x06e6, B:269:0x06f6, B:271:0x06fe, B:273:0x0706, B:275:0x070e, B:277:0x0718, B:278:0x0726, B:280:0x072c, B:282:0x073b, B:283:0x0740, B:285:0x0751, B:287:0x0761, B:290:0x0767, B:292:0x0773, B:294:0x0779, B:295:0x0780, B:297:0x078a, B:299:0x0791, B:300:0x07af, B:303:0x079b, B:305:0x07a1, B:306:0x07ac, B:307:0x07ba, B:309:0x07c1, B:313:0x06cb, B:342:0x07cb, B:344:0x07d1, B:345:0x07d4, B:346:0x07de, B:348:0x07e4, B:350:0x07f4, B:352:0x07f8, B:353:0x0801, B:358:0x080b, B:359:0x0831, B:361:0x0837, B:363:0x0841, B:365:0x0848, B:368:0x084b, B:369:0x085f, B:371:0x0865, B:373:0x0871, B:375:0x0879, B:377:0x0884, B:378:0x088a, B:381:0x0894, B:383:0x08a7, B:384:0x08aa, B:386:0x08d4, B:387:0x08d7, B:388:0x0921, B:390:0x0942, B:391:0x08df, B:393:0x08f2, B:395:0x0915, B:399:0x092e, B:401:0x0935, B:403:0x093f, B:408:0x0946, B:426:0x049a, B:427:0x0967, B:429:0x096b, B:430:0x096e, B:431:0x0975, B:433:0x0392, B:457:0x016e, B:459:0x0158, B:460:0x00b5, B:462:0x00ac, B:48:0x0075, B:49:0x0088, B:51:0x008e, B:54:0x0098, B:57:0x00a6, B:435:0x0162, B:91:0x0120, B:103:0x0216, B:105:0x0231, B:155:0x0437, B:259:0x06c1, B:142:0x038d, B:96:0x014c, B:170:0x0494), top: B:18:0x0018, outer: #18, inners: #1, #2, #4, #6, #10, #15, #20, #22, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0751 A[Catch: all -> 0x0045, TryCatch #12 {all -> 0x0045, blocks: (B:19:0x0018, B:23:0x0029, B:25:0x002d, B:27:0x003b, B:29:0x003f, B:30:0x0048, B:42:0x005d, B:44:0x0065, B:45:0x006b, B:63:0x00af, B:66:0x00c0, B:68:0x00c4, B:69:0x00c6, B:71:0x00ce, B:75:0x0100, B:77:0x0104, B:78:0x0106, B:79:0x010d, B:80:0x00d6, B:82:0x00e6, B:83:0x00f1, B:84:0x010e, B:86:0x0118, B:88:0x011c, B:93:0x0130, B:94:0x0133, B:97:0x015c, B:436:0x0171, B:438:0x0177, B:442:0x017f, B:444:0x019d, B:446:0x01a8, B:447:0x01b7, B:449:0x01cc, B:450:0x01cf, B:451:0x01d6, B:452:0x01b4, B:453:0x0183, B:455:0x018f, B:99:0x01d7, B:101:0x01fe, B:106:0x029e, B:108:0x02b4, B:109:0x02b7, B:112:0x02cb, B:114:0x02ce, B:116:0x02d6, B:118:0x02de, B:120:0x02e9, B:121:0x02ec, B:133:0x02fe, B:135:0x0311, B:136:0x031b, B:138:0x032a, B:139:0x032f, B:144:0x0398, B:146:0x03b0, B:148:0x03b6, B:149:0x03de, B:150:0x03ec, B:151:0x0425, B:153:0x042b, B:158:0x0443, B:163:0x043d, B:165:0x0447, B:167:0x046c, B:168:0x0481, B:172:0x04a0, B:174:0x04a4, B:175:0x04a8, B:176:0x04af, B:177:0x04b0, B:179:0x04d9, B:183:0x04e3, B:184:0x04f1, B:186:0x04f9, B:188:0x04fd, B:189:0x0501, B:190:0x0508, B:191:0x0509, B:192:0x050d, B:194:0x0513, B:196:0x052e, B:197:0x0535, B:199:0x0549, B:202:0x0551, B:203:0x0555, B:206:0x0560, B:209:0x056d, B:211:0x0575, B:213:0x058a, B:216:0x05a3, B:256:0x06b0, B:257:0x06b4, B:260:0x06cd, B:263:0x06d8, B:265:0x06dc, B:266:0x06de, B:268:0x06e6, B:269:0x06f6, B:271:0x06fe, B:273:0x0706, B:275:0x070e, B:277:0x0718, B:278:0x0726, B:280:0x072c, B:282:0x073b, B:283:0x0740, B:285:0x0751, B:287:0x0761, B:290:0x0767, B:292:0x0773, B:294:0x0779, B:295:0x0780, B:297:0x078a, B:299:0x0791, B:300:0x07af, B:303:0x079b, B:305:0x07a1, B:306:0x07ac, B:307:0x07ba, B:309:0x07c1, B:313:0x06cb, B:342:0x07cb, B:344:0x07d1, B:345:0x07d4, B:346:0x07de, B:348:0x07e4, B:350:0x07f4, B:352:0x07f8, B:353:0x0801, B:358:0x080b, B:359:0x0831, B:361:0x0837, B:363:0x0841, B:365:0x0848, B:368:0x084b, B:369:0x085f, B:371:0x0865, B:373:0x0871, B:375:0x0879, B:377:0x0884, B:378:0x088a, B:381:0x0894, B:383:0x08a7, B:384:0x08aa, B:386:0x08d4, B:387:0x08d7, B:388:0x0921, B:390:0x0942, B:391:0x08df, B:393:0x08f2, B:395:0x0915, B:399:0x092e, B:401:0x0935, B:403:0x093f, B:408:0x0946, B:426:0x049a, B:427:0x0967, B:429:0x096b, B:430:0x096e, B:431:0x0975, B:433:0x0392, B:457:0x016e, B:459:0x0158, B:460:0x00b5, B:462:0x00ac, B:48:0x0075, B:49:0x0088, B:51:0x008e, B:54:0x0098, B:57:0x00a6, B:435:0x0162, B:91:0x0120, B:103:0x0216, B:105:0x0231, B:155:0x0437, B:259:0x06c1, B:142:0x038d, B:96:0x014c, B:170:0x0494), top: B:18:0x0018, outer: #18, inners: #1, #2, #4, #6, #10, #15, #20, #22, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x07ba A[Catch: all -> 0x0045, TryCatch #12 {all -> 0x0045, blocks: (B:19:0x0018, B:23:0x0029, B:25:0x002d, B:27:0x003b, B:29:0x003f, B:30:0x0048, B:42:0x005d, B:44:0x0065, B:45:0x006b, B:63:0x00af, B:66:0x00c0, B:68:0x00c4, B:69:0x00c6, B:71:0x00ce, B:75:0x0100, B:77:0x0104, B:78:0x0106, B:79:0x010d, B:80:0x00d6, B:82:0x00e6, B:83:0x00f1, B:84:0x010e, B:86:0x0118, B:88:0x011c, B:93:0x0130, B:94:0x0133, B:97:0x015c, B:436:0x0171, B:438:0x0177, B:442:0x017f, B:444:0x019d, B:446:0x01a8, B:447:0x01b7, B:449:0x01cc, B:450:0x01cf, B:451:0x01d6, B:452:0x01b4, B:453:0x0183, B:455:0x018f, B:99:0x01d7, B:101:0x01fe, B:106:0x029e, B:108:0x02b4, B:109:0x02b7, B:112:0x02cb, B:114:0x02ce, B:116:0x02d6, B:118:0x02de, B:120:0x02e9, B:121:0x02ec, B:133:0x02fe, B:135:0x0311, B:136:0x031b, B:138:0x032a, B:139:0x032f, B:144:0x0398, B:146:0x03b0, B:148:0x03b6, B:149:0x03de, B:150:0x03ec, B:151:0x0425, B:153:0x042b, B:158:0x0443, B:163:0x043d, B:165:0x0447, B:167:0x046c, B:168:0x0481, B:172:0x04a0, B:174:0x04a4, B:175:0x04a8, B:176:0x04af, B:177:0x04b0, B:179:0x04d9, B:183:0x04e3, B:184:0x04f1, B:186:0x04f9, B:188:0x04fd, B:189:0x0501, B:190:0x0508, B:191:0x0509, B:192:0x050d, B:194:0x0513, B:196:0x052e, B:197:0x0535, B:199:0x0549, B:202:0x0551, B:203:0x0555, B:206:0x0560, B:209:0x056d, B:211:0x0575, B:213:0x058a, B:216:0x05a3, B:256:0x06b0, B:257:0x06b4, B:260:0x06cd, B:263:0x06d8, B:265:0x06dc, B:266:0x06de, B:268:0x06e6, B:269:0x06f6, B:271:0x06fe, B:273:0x0706, B:275:0x070e, B:277:0x0718, B:278:0x0726, B:280:0x072c, B:282:0x073b, B:283:0x0740, B:285:0x0751, B:287:0x0761, B:290:0x0767, B:292:0x0773, B:294:0x0779, B:295:0x0780, B:297:0x078a, B:299:0x0791, B:300:0x07af, B:303:0x079b, B:305:0x07a1, B:306:0x07ac, B:307:0x07ba, B:309:0x07c1, B:313:0x06cb, B:342:0x07cb, B:344:0x07d1, B:345:0x07d4, B:346:0x07de, B:348:0x07e4, B:350:0x07f4, B:352:0x07f8, B:353:0x0801, B:358:0x080b, B:359:0x0831, B:361:0x0837, B:363:0x0841, B:365:0x0848, B:368:0x084b, B:369:0x085f, B:371:0x0865, B:373:0x0871, B:375:0x0879, B:377:0x0884, B:378:0x088a, B:381:0x0894, B:383:0x08a7, B:384:0x08aa, B:386:0x08d4, B:387:0x08d7, B:388:0x0921, B:390:0x0942, B:391:0x08df, B:393:0x08f2, B:395:0x0915, B:399:0x092e, B:401:0x0935, B:403:0x093f, B:408:0x0946, B:426:0x049a, B:427:0x0967, B:429:0x096b, B:430:0x096e, B:431:0x0975, B:433:0x0392, B:457:0x016e, B:459:0x0158, B:460:0x00b5, B:462:0x00ac, B:48:0x0075, B:49:0x0088, B:51:0x008e, B:54:0x0098, B:57:0x00a6, B:435:0x0162, B:91:0x0120, B:103:0x0216, B:105:0x0231, B:155:0x0437, B:259:0x06c1, B:142:0x038d, B:96:0x014c, B:170:0x0494), top: B:18:0x0018, outer: #18, inners: #1, #2, #4, #6, #10, #15, #20, #22, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x06d7  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void run() {
        /*
            Method dump skipped, instructions count: 2530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.ac.U.run():void");
    }

    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0171: MOVE (r3 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY]) (LINE:371), block:B:166:0x0171 */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0498 A[Catch: all -> 0x04c4, TryCatch #1 {all -> 0x04c4, blocks: (B:111:0x0461, B:118:0x0472, B:120:0x047e, B:122:0x0482, B:123:0x0494, B:125:0x0498, B:127:0x04a1, B:128:0x04b0, B:131:0x04ad), top: B:110:0x0461 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0402 A[Catch: all -> 0x042f, TRY_LEAVE, TryCatch #5 {all -> 0x042f, blocks: (B:88:0x0379, B:90:0x038d, B:91:0x0394, B:93:0x039c, B:96:0x03ad, B:97:0x03ea, B:98:0x0428, B:136:0x03cc, B:137:0x0402, B:143:0x0414, B:139:0x041b, B:156:0x0350, B:158:0x0357, B:159:0x0366, B:160:0x0363), top: B:155:0x0350 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x038d A[Catch: all -> 0x042f, TryCatch #5 {all -> 0x042f, blocks: (B:88:0x0379, B:90:0x038d, B:91:0x0394, B:93:0x039c, B:96:0x03ad, B:97:0x03ea, B:98:0x0428, B:136:0x03cc, B:137:0x0402, B:143:0x0414, B:139:0x041b, B:156:0x0350, B:158:0x0357, B:159:0x0366, B:160:0x0363), top: B:155:0x0350 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x039c A[Catch: all -> 0x042f, TRY_LEAVE, TryCatch #5 {all -> 0x042f, blocks: (B:88:0x0379, B:90:0x038d, B:91:0x0394, B:93:0x039c, B:96:0x03ad, B:97:0x03ea, B:98:0x0428, B:136:0x03cc, B:137:0x0402, B:143:0x0414, B:139:0x041b, B:156:0x0350, B:158:0x0357, B:159:0x0366, B:160:0x0363), top: B:155:0x0350 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handlePluginUpgrade(com.baidu.liantian.core.ApkInfo r21) {
        /*
            Method dump skipped, instructions count: 1224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.ac.U.handlePluginUpgrade(com.baidu.liantian.core.ApkInfo):void");
    }

    private void handleThreadEnd(String str) {
        try {
            e eVar = this.preference;
            eVar.g(eVar.v() + 1);
            int i6 = this.mEndReason;
            if (i6 != 0) {
                e eVar2 = this.preference;
                eVar2.a(1, i6, eVar2.a(1, i6) + 1);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
        try {
            HashMap hashMap = new HashMap();
            Map<Integer, String> map = this.mStartKeyMap;
            if (map != null) {
                hashMap.put("1", map.keySet());
                hashMap.put("2", this.mStartKeyMap.values());
            }
            hashMap.put("3", Integer.valueOf(this.mFrom));
            Map<Integer, String> map2 = this.mCloudKeyMap;
            if (map2 != null) {
                hashMap.put("4", map2.keySet());
                hashMap.put("5", this.mCloudKeyMap.values());
            }
            List<Integer> list = this.mUnloadPluginsList;
            if (list != null) {
                hashMap.put("6", list);
            }
            List<Integer> list2 = this.mDownloadPluginsList;
            if (list2 != null) {
                hashMap.put("7", list2);
            }
            if (this.mUpgradeResultMap != null) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<Integer, UpgradeResult> entry : this.mUpgradeResultMap.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    int intValue = entry.getKey().intValue();
                    UpgradeResult value = entry.getValue();
                    if (value != null) {
                        jSONObject2.put("1", value.networkId);
                        jSONObject2.put("0", value.resultId);
                    }
                    jSONObject.put(String.valueOf(intValue), jSONObject2);
                }
                hashMap.put("8", jSONObject);
            }
            Map<Integer, String> b6 = this.loadedPluginDB.b();
            hashMap.put("9", b6.keySet());
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, b6.values());
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, str.replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\r", ""));
            }
            hashMap.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, Integer.valueOf(this.mStartNetwork));
            hashMap.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(com.baidu.liantian.b.e.m(this.context)));
            com.baidu.liantian.b.e.a(this.context, "1003129", hashMap);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e4 A[Catch: all -> 0x00f7, TryCatch #0 {all -> 0x00f7, blocks: (B:17:0x00ce, B:19:0x00e4, B:20:0x00ee), top: B:16:0x00ce }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handleThreadStart() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.ac.U.handleThreadStart():void");
    }

    public void handleWork(Context context, Intent intent) {
        this.context = context;
        this.loadedPluginDB = a.a(context);
        this.preference = new e(context);
        this.tmpDir = new File(context.getFilesDir(), ".tmp_liantian");
        this.forHostAPP = d.a(context);
        this.mFrom = intent.getIntExtra(Constants.FROM, 0);
        b.a();
        start();
    }

    public static void handleUploadPidChange(Context context, Intent intent) {
        try {
            b.a();
            com.baidu.liantian.b.b.a(context);
            e eVar = new e(context);
            JSONArray jSONArray = new JSONArray();
            String string = eVar.f10457a.getString("pdcgts", "");
            com.baidu.liantian.b.e.i(context);
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("_")) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONArray.put(Long.valueOf(str));
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.r()));
            hashMap.put("1", Integer.valueOf(eVar.t()));
            hashMap.put("2", jSONArray);
            eVar.d(0);
            eVar.e(0);
            eVar.b(0L);
            com.baidu.liantian.b.e.a(context, "1003122", hashMap);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
        }
    }

    public U() {
        this.mFrom = 0;
        this.mEndReason = 0;
        this.mOut = false;
        this.mCloudKeyMap = new HashMap();
        this.mUnloadPluginsList = new ArrayList();
        this.mDownloadPluginsList = new ArrayList();
        this.mUpgradeResultMap = new HashMap();
        this.mStartNetwork = -2;
    }
}
