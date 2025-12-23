package c3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tsn.chat.model.ChatModel;
import com.tsn.chat.model.ResponseMessage;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    public static void a(ResponseMessage responseMessage) {
        byte controlType = responseMessage.getControlType();
        if (controlType == 50) {
            b3.a.a().f();
        }
        if (controlType == 51) {
            b3.a.a().e(((JSONObject) JSON.parse(responseMessage.getDatas())).getString("messageId"));
        }
        if (controlType == 52) {
            ChatModel chatModel = new ChatModel();
            JSONObject jSONObject = (JSONObject) JSON.parse(responseMessage.getDatas());
            try {
                chatModel.setCreateTime(com.tsn.chat.utils.a.c());
                chatModel.setSchoolId(jSONObject.getString("schoolId"));
                chatModel.setToUserId(jSONObject.getString("toUserId"));
                chatModel.setToUserName(jSONObject.getString("toUserName"));
                chatModel.setFromUserId(jSONObject.getString("fromUserId"));
                chatModel.setFromUserName(jSONObject.getString("fromUserName"));
                chatModel.setMsg(jSONObject.getString("msg"));
                chatModel.setType(jSONObject.getString("type"));
                chatModel.setPhoto(jSONObject.getString("photo"));
                if ("1".equals(jSONObject.getString("type"))) {
                    b3.a.a().c(chatModel);
                } else {
                    chatModel.setGroupId(jSONObject.getString("groupId"));
                    b3.a.a().j(chatModel);
                }
            } catch (Exception unused) {
                System.out.getClass();
            }
        }
        if (controlType == 53) {
            b3.a.a().b();
        }
    }
}
