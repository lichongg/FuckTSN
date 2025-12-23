package d3;

import android.content.Context;
import b3.b;
import com.alibaba.fastjson.JSON;
import com.tsn.chat.model.ChatModel;
import com.tsn.chat.model.RequestMessage;
import com.tsn.chat.utils.c;
import com.tsn.chat.utils.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f42988a;

    public static void p() {
        ChatModel chatModel = new ChatModel();
        chatModel.setCreateTime(com.tsn.chat.utils.a.c());
        chatModel.setFromUserId("47932");
        chatModel.setFromUserName("郭清枝");
        chatModel.setToUserId("47932,39850,39858,40125,40209,40223,40232,40236,42127,41446,45897,44998,47297,47712,47719,47723,40231,40240,40341,40351,40356,40805,42034,42070,42114,42318,40559,47370,47415,43931,44735,44747,45315,46760,46764,47304,47305,47314,46769,46853,47022,47089");
        chatModel.setToUserName("wangmazi");
        chatModel.setSchoolId("wgydx");
        chatModel.setMsg(CommonNetImpl.AS);
        chatModel.setGroupId("638");
        chatModel.setMessageId("c5ef9a84-c3fc-4ca2-88f3-bb1affcc88e0");
        chatModel.setPhoto("");
        b3.a.a().i(chatModel);
    }

    @Override // b3.b
    public void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("schoolId", com.tsn.chat.utils.b.f40734e);
        hashMap.put("userId", com.tsn.chat.utils.b.f40733d);
        hashMap.put("hb", "chat");
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 2, jSONString);
        if (com.tsn.chat.utils.b.f40730a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // b3.b
    public void g(Context context) {
        f42988a = context;
    }

    @Override // b3.b
    public void h(ChatModel chatModel) {
        chatModel.setType("2");
        String jSONString = JSON.toJSONString(chatModel);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 3, jSONString);
        if (com.tsn.chat.utils.b.f40730a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // b3.b
    public void i(ChatModel chatModel) {
        chatModel.setType("1");
        String jSONString = JSON.toJSONString(chatModel);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 3, jSONString);
        if (com.tsn.chat.utils.b.f40730a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // b3.b
    public void l() {
        com.tsn.chat.utils.b.f40733d = "";
        com.tsn.chat.utils.b.f40734e = "";
        com.tsn.chat.utils.b.f40730a.close();
    }

    @Override // b3.b
    public void n() {
        HashMap hashMap = new HashMap();
        hashMap.put("schoolId", com.tsn.chat.utils.b.f40734e);
        hashMap.put("userId", com.tsn.chat.utils.b.f40733d);
        hashMap.put("hb", "back");
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 2, jSONString);
        if (com.tsn.chat.utils.b.f40730a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // b3.b
    public void o(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", str);
        hashMap.put("schoolId", str2);
        String jSONString = JSON.toJSONString(hashMap);
        RequestMessage requestMessage = new RequestMessage(jSONString.getBytes().length + 6, (byte) 1, jSONString);
        if (com.tsn.chat.utils.b.f40730a.size() > 0) {
            c.a(requestMessage);
        }
    }

    @Override // b3.b
    public int d(String str, String str2, String str3, String str4) {
        l();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new d(str3, Integer.parseInt(str4), countDownLatch).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        if (com.tsn.chat.utils.b.f40730a.size() == 0) {
            return 2;
        }
        com.tsn.chat.utils.b.f40733d = str;
        com.tsn.chat.utils.b.f40734e = str2;
        b3.a.a().o(str, str2);
        return 1;
    }

    @Override // b3.b
    public void b() {
    }

    @Override // b3.b
    public void f() {
    }

    @Override // b3.b
    public void k() {
    }

    @Override // b3.b
    public void m() {
    }

    @Override // b3.b
    public void c(ChatModel chatModel) {
    }

    @Override // b3.b
    public void e(String str) {
    }

    @Override // b3.b
    public void j(ChatModel chatModel) {
    }
}
