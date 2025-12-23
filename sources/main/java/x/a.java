package x;

import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface a {
    @FormUrlEncoded
    @POST("app/chat/updateReadStatus")
    rx.e<c0<ResponseBody>> a(@Field("type") int i6, @Field("userId") String str, @Field("groupId") String str2);

    @FormUrlEncoded
    @POST("app/chat/getUserInfo")
    rx.e<c0<ResponseBody>> b(@Field("userId") String str);

    @POST("app/chat/listChats")
    rx.e<c0<ResponseBody>> c();

    @POST("app/chat/getChatInfo")
    rx.e<c0<ResponseBody>> d();

    @FormUrlEncoded
    @POST("app/chat/getChat")
    rx.e<c0<ResponseBody>> e(@Field("type") int i6, @Field("userId") String str, @Field("groupId") String str2, @Field("pageSize") Integer num, @Field("pageIndex") Integer num2, @Field("lastDateTime") String str3);

    @FormUrlEncoded
    @POST("app/chat/listFriends")
    rx.e<c0<ResponseBody>> f(@Field("groupId") String str);
}
