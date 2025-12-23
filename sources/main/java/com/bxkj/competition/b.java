package com.bxkj.competition;

import okhttp3.ResponseBody;
import retrofit2.c0;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface b {
    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteItems")
    e<c0<ResponseBody>> b(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/competeUserSignUp")
    e<c0<ResponseBody>> d(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionDetail")
    e<c0<ResponseBody>> e(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/cancelSignUpItem")
    e<c0<ResponseBody>> f(@Field("itemId") String itemId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompetitionList")
    e<c0<ResponseBody>> g(@Field("competitionId") String competitionId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompeteItems")
    e<c0<ResponseBody>> h(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/competeItemSignin")
    e<c0<ResponseBody>> i(@Field("itemId") String itemId, @Field("userNum") String userNum);

    @FormUrlEncoded
    @POST("app/appCompetition/getMyAppCompetitionList")
    e<c0<ResponseBody>> j(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getMaxGroupNumByScheduleId")
    e<c0<ResponseBody>> k(@Field("scheduleId") String scheduleId);

    @FormUrlEncoded
    @POST("app/appCompetition/loadRollCallData")
    e<c0<ResponseBody>> l(@Field("scheduleId") String scheduleId, @Field("groupNum") int groupNum, @Field("progressMode") String progressMode);

    @FormUrlEncoded
    @POST("app/appCompetition/competeRollCallUpdate")
    e<c0<ResponseBody>> m(@Field("userId") String userId, @Field("rollCallJson") String rollCallJson);

    @FormUrlEncoded
    @POST("app/appCompetition/loadStuScoreData")
    e<c0<ResponseBody>> n(@Field("scheduleId") String scheduleId, @Field("groupNum") int groupNum);

    @FormUrlEncoded
    @POST("app/appCompetition/getItemListByGroupId")
    e<c0<ResponseBody>> o(@Field("groupId") String groupId);

    @FormUrlEncoded
    @POST("app/appCompetition/getCompeteItemAllPlayers")
    e<c0<ResponseBody>> p(@Field("competeItemId") String competeItemId, @Field("status") int status, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/loadUserCompeteLetterData")
    e<c0<ResponseBody>> q(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("pageIndex") int pageIndex, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("app/appCompetition/getUserEntryCard")
    e<c0<ResponseBody>> r(@Field("competitionId") String competitionId, @Field("userId") String userId);

    @FormUrlEncoded
    @POST("app/appCompetition/getAppCompeteAllItems")
    e<c0<ResponseBody>> s(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/getGroupListByCompetitionId")
    e<c0<ResponseBody>> t(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/competeAliPay/appPay")
    e<c0<ResponseBody>> u(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("itemIds") String itemIds, @Field("insuranceFee") double insuranceFee, @Field("competitionFee") double competitionFee, @Field("totalPrice") double totalPrice, @Field("payPrize") double payPrize);

    @FormUrlEncoded
    @POST("app/appCompetition/loadCompeteScheduleData")
    e<c0<ResponseBody>> v(@Field("competitionId") String competitionId, @Field("groupId") Object groupId, @Field("itemId") Object itemId, @Field("dateId") Object dateId);

    @FormUrlEncoded
    @POST("app/competeWXPay/appPay")
    e<c0<ResponseBody>> w(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("itemIds") String itemIds, @Field("insuranceFee") double insuranceFee, @Field("competitionFee") double competitionFee, @Field("totalPrice") double totalPrice, @Field("payPrize") double payPrize);

    @FormUrlEncoded
    @POST("app/appCompetition/getDateListByCompetitionId")
    e<c0<ResponseBody>> x(@Field("competitionId") String competitionId);

    @FormUrlEncoded
    @POST("app/appCompetition/publishCompeteLetter")
    e<c0<ResponseBody>> y(@Field("competitionId") String competitionId, @Field("userId") String userId, @Field("content") String content);
}
