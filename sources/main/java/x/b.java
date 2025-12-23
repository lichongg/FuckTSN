package x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f54741a = "https://h.boxkj.com/";

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/closeDonationNotice")
    rx.e<c0<ResponseBody>> a(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/deleteDonationNotice")
    rx.e<c0<ResponseBody>> b(@Field("noticeId") String str, @Field("regionUserId") String str2);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/myDonationNoticeList")
    rx.e<c0<ResponseBody>> c(@Field("regionUserId") String str, @Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/usefulDonationNoticeList")
    rx.e<c0<ResponseBody>> d(@Field("pageIndex") int i6, @Field("pageSize") int i7);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/addDonationNotice")
    rx.e<c0<ResponseBody>> e(@NonNull @Field("regionUserId") String str, @NonNull @Field("goodsTypeId") String str2, @NonNull @Field("buyOrSell") int i6, @NonNull @Field("description") String str3, @Nullable @Field("img") String str4, @Nullable @Field("phone") String str5, @Nullable @Field("qq") String str6, @Nullable @Field("wechat") String str7, @Nullable @Field("price") String str8);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userJM/userHasGranted")
    rx.e<c0<ResponseBody>> f(@Field("regionUserId") String str);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/userJM/grantUser")
    rx.e<c0<ResponseBody>> g(@Field("schoolId") String str, @Field("userId") String str2, @Field("userName") String str3, @Field("sex") String str4, @Field("userNum") String str5, @Field("phone") String str6);

    @FormUrlEncoded
    @POST("https://h.boxkj.com/app/donationNotice/getDonationNoticeDetail")
    rx.e<c0<ResponseBody>> h(@Field("noticeId") String str, @Field("regionUserId") String str2);
}
