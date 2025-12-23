package b3;

import android.content.ComponentName;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.chat.heart.ChatBroadcastActionType;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.a0;
import com.bxkj.student.d;
import com.orhanobut.logger.j;
import com.tsn.chat.model.ChatModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c extends d3.a {
    @Override // d3.a, b3.b
    public void b() {
        LocalBroadcastManager.getInstance(d3.a.f42988a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS));
        l();
        LoginUser.getLoginUser().setLogin(false);
        LoginUser.getLoginUser().setToken("");
        LoginUser.getLoginUser().setUserId("");
        cn.bluemobi.dylan.base.utils.a.n().j();
        if (LoginUser.getLoginUser().getUserType() == 1) {
            d3.a.f42988a.startActivity(new Intent().setComponent(new ComponentName(d.f17843b, "com.bxkj.student.MainActivity")).setFlags(335544320));
            d3.a.f42988a.startActivity(new Intent().setComponent(new ComponentName(d.f17843b, "com.bxkj.student.personal.login.LoginActivity")).setFlags(268435456));
        } else {
            d3.a.f42988a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.teacher", "com.bxkj.teacher.login.LoginActivity")).setFlags(335544320));
        }
        if (a0.a(d3.a.f42988a, AlarmChatService.class.getName())) {
            j.c("AlarmChatService----------isServiceRunning");
            d3.a.f42988a.stopService(new Intent(d3.a.f42988a, (Class<?>) AlarmChatService.class));
        }
    }

    @Override // d3.a, b3.b
    public void c(ChatModel chatModel) {
        j.c("接收到聊天信息:" + chatModel.toString());
        LocalBroadcastManager.getInstance(d3.a.f42988a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE).putExtra("chatType", 1).putExtra("userId", chatModel.getFromUserId()).putExtra("userName", chatModel.getFromUserName()).putExtra("toUserName", chatModel.getToUserName()).putExtra("photo", chatModel.getPhoto()).putExtra("createTime", chatModel.getCreateTime()).putExtra("msg", chatModel.getMsg()));
    }

    @Override // d3.a, b3.b
    public void f() {
        j.c("心跳响应" + d3.a.f42988a);
        LocalBroadcastManager.getInstance(d3.a.f42988a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS));
    }

    @Override // d3.a, b3.b
    public void j(ChatModel chatModel) {
        j.c("接收到群聊信息:" + chatModel.toString());
        LocalBroadcastManager.getInstance(d3.a.f42988a).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE).putExtra("chatType", 2).putExtra("userId", chatModel.getFromUserId()).putExtra("userName", chatModel.getFromUserName()).putExtra("toUserName", chatModel.getToUserName()).putExtra("photo", chatModel.getPhoto()).putExtra("createTime", chatModel.getCreateTime()).putExtra("groupId", chatModel.getGroupId()).putExtra("msg", chatModel.getMsg()));
    }

    @Override // d3.a, b3.b
    public void k() {
        j.c("客户端离线回调");
    }

    @Override // d3.a, b3.b
    public void e(String str) {
        cn.bluemobi.dylan.sqlitelibrary.c.h().delete(ChatMessageDb.class, "messageId=?", new String[]{str});
        j.c("消息发送回调" + str);
        Intent intent = new Intent(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS);
        intent.putExtra("messageId", str);
        LocalBroadcastManager.getInstance(d3.a.f42988a).sendBroadcast(intent);
        super.e(str);
    }
}
