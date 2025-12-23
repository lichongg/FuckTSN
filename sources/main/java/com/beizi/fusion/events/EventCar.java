package com.beizi.fusion.events;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.beizi.fusion.model.Messenger;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ai;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.e;
import com.beizi.fusion.tool.g;
import com.beizi.fusion.tool.t;
import com.beizi.fusion.tool.v;
import com.beizi.fusion.tool.y;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EventCar {

    /* renamed from: a, reason: collision with root package name */
    private static EventCar f13451a;

    /* renamed from: b, reason: collision with root package name */
    private Context f13452b;

    /* renamed from: c, reason: collision with root package name */
    private List<Messenger.EventsBean> f13453c;

    /* renamed from: d, reason: collision with root package name */
    private long f13454d = 128;

    /* renamed from: e, reason: collision with root package name */
    private long f13455e = bn.f10749e;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EventBean eventBean) {
        try {
            ResponseInfo responseInfo = ResponseInfo.getInstance(this.f13452b);
            String a6 = a(eventBean.getEventCode());
            if (responseInfo.getMessenger() != null) {
                this.f13453c = responseInfo.getMessenger().getEvents();
                this.f13454d = Long.valueOf(responseInfo.getMessenger().getFileMaxSize()).longValue();
                this.f13455e = responseInfo.getMessenger().getExpireTime();
                List<Messenger.EventsBean> list = this.f13453c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (int i6 = 0; i6 < this.f13453c.size(); i6++) {
                    Messenger.EventsBean eventsBean = this.f13453c.get(i6);
                    List<String> codes = eventsBean.getCodes();
                    if (codes != null && codes.size() > 0) {
                        for (int i7 = 0; i7 < codes.size(); i7++) {
                            if (!TextUtils.isEmpty(eventBean.getEventCode())) {
                                if (!TextUtils.isEmpty(codes.get(i7))) {
                                    if (!eventBean.getEventCode().equals(codes.get(i7)) && !a6.equals(codes.get(i7))) {
                                    }
                                    if (eventsBean.getIsOnline().equals("1")) {
                                        eventBean.setUrl(eventsBean.getUploadUrl());
                                        a(eventsBean, eventBean);
                                    } else {
                                        a(eventsBean, eventBean, true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static EventCar getInstance(Context context) {
        if (f13451a == null) {
            synchronized (EventCar.class) {
                try {
                    if (f13451a == null) {
                        f13451a = new EventCar(context);
                    }
                } finally {
                }
            }
        }
        return f13451a;
    }

    public void doUpLoadLogs() {
        int i6;
        int i7;
        try {
            aa.a("BeiZis", "===================doUpLoadLogs===================:" + Thread.currentThread().getName());
            long currentTimeMillis = System.currentTimeMillis();
            File a6 = g.a(this.f13452b);
            aa.a("BeiZis", "doUpLoadLogs storagePath == " + a6);
            if (a6 != null) {
                String str = a6.getPath() + "/BeiZi/offline/";
                File[] listFiles = new File(str).listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                int length = listFiles.length;
                int i8 = 0;
                int i9 = 0;
                while (i9 < length) {
                    File file = listFiles[i9];
                    if (file.isDirectory()) {
                        String str2 = "";
                        File file2 = new File(str, file.getName() + "/10000.txt");
                        if (file2.exists()) {
                            str2 = a(file2);
                        } else {
                            ai.a(file);
                        }
                        String str3 = str2;
                        if (!TextUtils.isEmpty(str3)) {
                            File[] listFiles2 = file.listFiles();
                            int length2 = listFiles2.length;
                            int i10 = 0;
                            while (i10 < length2) {
                                File file3 = listFiles2[i10];
                                if (file3.getName().equals("10000.txt")) {
                                    i7 = i9;
                                } else {
                                    i7 = i9;
                                    if (currentTimeMillis - Long.valueOf(file3.getName().substring(i8, file3.getName().indexOf("."))).longValue() < this.f13455e) {
                                        String a7 = v.a(str3, file3);
                                        if (!TextUtils.isEmpty(a7)) {
                                            try {
                                                if (new JSONObject(a7).optInt("code") == 200) {
                                                    file3.delete();
                                                }
                                            } catch (JSONException e6) {
                                                e6.printStackTrace();
                                            }
                                        }
                                    } else {
                                        file3.delete();
                                    }
                                }
                                i10++;
                                i9 = i7;
                                i8 = 0;
                            }
                            i6 = i9;
                            if (file.listFiles().length <= 1) {
                                ai.a(file);
                            }
                            i9 = i6 + 1;
                            i8 = 0;
                        }
                    }
                    i6 = i9;
                    i9 = i6 + 1;
                    i8 = 0;
                }
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }

    private EventCar(Context context) {
        this.f13452b = context;
        RequestInfo init = RequestInfo.getInstance(context).init();
        if (!init.isInit()) {
            init.init();
        }
    }

    public void goRoad(final EventBean eventBean) {
        e.b().e().execute(new Runnable() { // from class: com.beizi.fusion.events.EventCar.1
            @Override // java.lang.Runnable
            public void run() {
                EventCar.this.a(eventBean);
            }
        });
    }

    public void goRoadWithoutThread(EventBean eventBean) {
        a(eventBean);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, str.indexOf(".") + 1) + "*";
    }

    private void a(Messenger.EventsBean eventsBean, EventBean eventBean) {
        String a6;
        if (eventBean != null) {
            try {
                if (TextUtils.isEmpty(eventBean.getUrl())) {
                    return;
                }
                String url = eventBean.getUrl();
                if ("590.200".equalsIgnoreCase(eventBean.getEventCode())) {
                    url = eventBean.getTaskReqUrl();
                }
                int indexOf = url.indexOf("?");
                String substring = url.substring(0, indexOf);
                String substring2 = url.substring(indexOf + 1);
                if ("590.200".equalsIgnoreCase(eventBean.getEventCode())) {
                    a6 = ao.a(this.f13452b, substring2, eventBean, eventBean.getAppLinks());
                } else {
                    a6 = ao.a(this.f13452b, substring2, eventBean);
                }
                String a7 = com.beizi.fusion.tool.b.a(y.a(), t.a(a6));
                if (a7 != null) {
                    String a8 = v.a(substring, a7.getBytes());
                    if (!TextUtils.isEmpty(a8)) {
                        try {
                            if (new JSONObject(a8).optInt("code") != 200) {
                                a(eventsBean, eventBean, true);
                                return;
                            }
                            return;
                        } catch (JSONException e6) {
                            e6.printStackTrace();
                            return;
                        }
                    }
                    a(eventsBean, eventBean, true);
                }
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
    }

    private static String a(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            fileInputStream.close();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return sb.toString();
    }

    private void a(Messenger.EventsBean eventsBean, EventBean eventBean, boolean z5) {
        eventBean.getEventCode();
        try {
            File a6 = g.a(this.f13452b);
            aa.a("BeiZis", "doOffline storagePath == " + a6);
            if (a6 != null) {
                String offlineUrl = z5 ? eventsBean.getOfflineUrl() : eventsBean.getUploadUrl();
                String substring = offlineUrl.substring(0, offlineUrl.indexOf("?"));
                String a7 = com.beizi.fusion.tool.b.a(y.a(), ao.a(this.f13452b, offlineUrl.substring(offlineUrl.indexOf("?") + 1), eventBean));
                String str = a6.getPath() + "/BeiZi/offline/" + ao.a(eventsBean.toString()) + "/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "10000.txt");
                synchronized (EventCar.class) {
                    try {
                        if (!file2.exists()) {
                            file2.createNewFile();
                            FileWriter fileWriter = new FileWriter(file2, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(substring);
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                            fileWriter.close();
                        }
                    } finally {
                    }
                }
                long j6 = 0;
                for (File file3 : file.listFiles()) {
                    String substring2 = file3.getName().substring(0, file3.getName().indexOf("."));
                    if (Long.valueOf(substring2).longValue() > j6) {
                        j6 = Long.valueOf(substring2).longValue();
                    }
                }
                if (j6 != 0 && j6 != 10000) {
                    File file4 = new File(str + j6 + ".txt");
                    if (file4.exists() && file4.length() < this.f13454d * 1000) {
                        FileWriter fileWriter2 = new FileWriter(file4, true);
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                        bufferedWriter2.write(a7);
                        bufferedWriter2.newLine();
                        bufferedWriter2.close();
                        fileWriter2.close();
                        file4.renameTo(new File(file, System.currentTimeMillis() + ".txt"));
                        return;
                    }
                }
                File file5 = new File(file, System.currentTimeMillis() + ".txt");
                file5.createNewFile();
                FileWriter fileWriter3 = new FileWriter(file5, true);
                BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
                bufferedWriter3.write(a7);
                bufferedWriter3.newLine();
                bufferedWriter3.close();
                fileWriter3.close();
            }
        } catch (IOException unused) {
        } catch (Exception e6) {
            e6.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
