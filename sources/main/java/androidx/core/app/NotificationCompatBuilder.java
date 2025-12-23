package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: D:\Downloads\app\classes.dex */
class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat.Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;
    private final List<Bundle> mActionExtrasList = new ArrayList();
    private final Bundle mExtras = new Bundle();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(20)
    static class Api20Impl {
        @DoNotInline
        static Notification.Action.Builder createBuilder(int i6, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i6, charSequence, pendingIntent);
        }

        private Api20Impl() {
        }

        @DoNotInline
        static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        @DoNotInline
        static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        @DoNotInline
        static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, android.app.RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        @DoNotInline
        static Notification.Action build(Notification.Action.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static String getGroup(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        static Notification.Builder setGroup(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        @DoNotInline
        static Notification.Builder setGroupSummary(Notification.Builder builder, boolean z5) {
            return builder.setGroupSummary(z5);
        }

        @DoNotInline
        static Notification.Builder setLocalOnly(Notification.Builder builder, boolean z5) {
            return builder.setLocalOnly(z5);
        }

        @DoNotInline
        static Notification.Builder setSortKey(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        @DoNotInline
        static Notification.Builder setSound(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        private Api21Impl() {
        }

        @DoNotInline
        static Notification.Builder addPerson(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        @DoNotInline
        static Notification.Builder setCategory(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        @DoNotInline
        static Notification.Builder setColor(Notification.Builder builder, int i6) {
            return builder.setColor(i6);
        }

        @DoNotInline
        static Notification.Builder setPublicVersion(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        @DoNotInline
        static Notification.Builder setVisibility(Notification.Builder builder, int i6) {
            return builder.setVisibility(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    static class Api23Impl {
        @DoNotInline
        static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        @DoNotInline
        static Notification.Builder setSmallIcon(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }

        private Api23Impl() {
        }

        @DoNotInline
        static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(26)
    static class Api26Impl {
        @DoNotInline
        static Notification.Builder createBuilder(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        private Api26Impl() {
        }

        @DoNotInline
        static Notification.Builder setBadgeIconType(Notification.Builder builder, int i6) {
            return builder.setBadgeIconType(i6);
        }

        @DoNotInline
        static Notification.Builder setColorized(Notification.Builder builder, boolean z5) {
            return builder.setColorized(z5);
        }

        @DoNotInline
        static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int i6) {
            return builder.setGroupAlertBehavior(i6);
        }

        @DoNotInline
        static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        @DoNotInline
        static Notification.Builder setShortcutId(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        @DoNotInline
        static Notification.Builder setTimeoutAfter(Notification.Builder builder, long j6) {
            return builder.setTimeoutAfter(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    static class Api29Impl {
        @DoNotInline
        static Notification.Builder setLocusId(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }

        private Api29Impl() {
        }

        @DoNotInline
        static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z5) {
            return builder.setAllowSystemGeneratedContextualActions(z5);
        }

        @DoNotInline
        static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        @DoNotInline
        static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean z5) {
            return builder.setContextual(z5);
        }
    }

    private void removeSoundAndVibration(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z5) {
            return builder.setAllowGeneratedReplies(z5);
        }

        @DoNotInline
        static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Notification.Builder addPerson(Notification.Builder builder, android.app.Person person) {
            return builder.addPerson(person);
        }

        @DoNotInline
        static Notification.Action.Builder setSemanticAction(Notification.Action.Builder builder, int i6) {
            return builder.setSemanticAction(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(31)
    static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean z5) {
            return builder.setAuthenticationRequired(z5);
        }

        @DoNotInline
        static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int i6) {
            return builder.setForegroundServiceBehavior(i6);
        }
    }

    NotificationCompatBuilder(NotificationCompat.Builder builder) {
        int i6;
        Object obj;
        this.mBuilderCompat = builder;
        Context context = builder.mContext;
        this.mContext = context;
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 26) {
            this.mBuilder = Api26Impl.createBuilder(context, builder.mChannelId);
        } else {
            this.mBuilder = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.mNotification;
        this.mBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.mFullScreenIntent, (notification.flags & 128) != 0).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        if (i7 < 23) {
            Notification.Builder builder2 = this.mBuilder;
            IconCompat iconCompat = builder.mLargeIcon;
            builder2.setLargeIcon(iconCompat == null ? null : iconCompat.getBitmap());
        } else {
            Notification.Builder builder3 = this.mBuilder;
            IconCompat iconCompat2 = builder.mLargeIcon;
            Api23Impl.setLargeIcon(builder3, iconCompat2 == null ? null : iconCompat2.toIcon(context));
        }
        this.mBuilder.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        NotificationCompat.Style style = builder.mStyle;
        if (style instanceof NotificationCompat.CallStyle) {
            Iterator<NotificationCompat.Action> it = ((NotificationCompat.CallStyle) style).getActionsListWithSystemActions().iterator();
            while (it.hasNext()) {
                addAction(it.next());
            }
        } else {
            Iterator<NotificationCompat.Action> it2 = builder.mActions.iterator();
            while (it2.hasNext()) {
                addAction(it2.next());
            }
        }
        Bundle bundle = builder.mExtras;
        if (bundle != null) {
            this.mExtras.putAll(bundle);
        }
        int i8 = Build.VERSION.SDK_INT;
        this.mContentView = builder.mContentView;
        this.mBigContentView = builder.mBigContentView;
        this.mBuilder.setShowWhen(builder.mShowWhen);
        Api20Impl.setLocalOnly(this.mBuilder, builder.mLocalOnly);
        Api20Impl.setGroup(this.mBuilder, builder.mGroupKey);
        Api20Impl.setSortKey(this.mBuilder, builder.mSortKey);
        Api20Impl.setGroupSummary(this.mBuilder, builder.mGroupSummary);
        this.mGroupAlertBehavior = builder.mGroupAlertBehavior;
        Api21Impl.setCategory(this.mBuilder, builder.mCategory);
        Api21Impl.setColor(this.mBuilder, builder.mColor);
        Api21Impl.setVisibility(this.mBuilder, builder.mVisibility);
        Api21Impl.setPublicVersion(this.mBuilder, builder.mPublicVersion);
        Api21Impl.setSound(this.mBuilder, notification.sound, notification.audioAttributes);
        List combineLists = i8 < 28 ? combineLists(getPeople(builder.mPersonList), builder.mPeople) : builder.mPeople;
        if (combineLists != null && !combineLists.isEmpty()) {
            Iterator it3 = combineLists.iterator();
            while (it3.hasNext()) {
                Api21Impl.addPerson(this.mBuilder, (String) it3.next());
            }
        }
        this.mHeadsUpContentView = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            Bundle bundle2 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i9 = 0; i9 < builder.mInvisibleActions.size(); i9++) {
                bundle4.putBundle(Integer.toString(i9), NotificationCompatJellybean.getBundleForAction(builder.mInvisibleActions.get(i9)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23 && (obj = builder.mSmallIcon) != null) {
            Api23Impl.setSmallIcon(this.mBuilder, obj);
        }
        if (i10 >= 24) {
            this.mBuilder.setExtras(builder.mExtras);
            Api24Impl.setRemoteInputHistory(this.mBuilder, builder.mRemoteInputHistory);
            RemoteViews remoteViews = builder.mContentView;
            if (remoteViews != null) {
                Api24Impl.setCustomContentView(this.mBuilder, remoteViews);
            }
            RemoteViews remoteViews2 = builder.mBigContentView;
            if (remoteViews2 != null) {
                Api24Impl.setCustomBigContentView(this.mBuilder, remoteViews2);
            }
            RemoteViews remoteViews3 = builder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                Api24Impl.setCustomHeadsUpContentView(this.mBuilder, remoteViews3);
            }
        }
        if (i10 >= 26) {
            Api26Impl.setBadgeIconType(this.mBuilder, builder.mBadgeIcon);
            Api26Impl.setSettingsText(this.mBuilder, builder.mSettingsText);
            Api26Impl.setShortcutId(this.mBuilder, builder.mShortcutId);
            Api26Impl.setTimeoutAfter(this.mBuilder, builder.mTimeout);
            Api26Impl.setGroupAlertBehavior(this.mBuilder, builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                Api26Impl.setColorized(this.mBuilder, builder.mColorized);
            }
            if (!TextUtils.isEmpty(builder.mChannelId)) {
                this.mBuilder.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator<Person> it4 = builder.mPersonList.iterator();
            while (it4.hasNext()) {
                Api28Impl.addPerson(this.mBuilder, it4.next().toAndroidPerson());
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            Api29Impl.setAllowSystemGeneratedContextualActions(this.mBuilder, builder.mAllowSystemGeneratedContextualActions);
            Api29Impl.setBubbleMetadata(this.mBuilder, NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
            LocusIdCompat locusIdCompat = builder.mLocusId;
            if (locusIdCompat != null) {
                Api29Impl.setLocusId(this.mBuilder, locusIdCompat.toLocusId());
            }
        }
        if (i11 >= 31 && (i6 = builder.mFgsDeferBehavior) != 0) {
            Api31Impl.setForegroundServiceBehavior(this.mBuilder, i6);
        }
        if (builder.mSilent) {
            if (this.mBuilderCompat.mGroupSummary) {
                this.mGroupAlertBehavior = 2;
            } else {
                this.mGroupAlertBehavior = 1;
            }
            this.mBuilder.setVibrate(null);
            this.mBuilder.setSound(null);
            int i12 = notification.defaults & (-4);
            notification.defaults = i12;
            this.mBuilder.setDefaults(i12);
            if (i11 >= 26) {
                if (TextUtils.isEmpty(this.mBuilderCompat.mGroupKey)) {
                    Api20Impl.setGroup(this.mBuilder, NotificationCompat.GROUP_KEY_SILENT);
                }
                Api26Impl.setGroupAlertBehavior(this.mBuilder, this.mGroupAlertBehavior);
            }
        }
    }

    private void addAction(NotificationCompat.Action action) {
        int i6 = Build.VERSION.SDK_INT;
        IconCompat iconCompat = action.getIconCompat();
        Notification.Action.Builder createBuilder = i6 >= 23 ? Api23Impl.createBuilder(iconCompat != null ? iconCompat.toIcon() : null, action.getTitle(), action.getActionIntent()) : Api20Impl.createBuilder(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.fromCompat(action.getRemoteInputs())) {
                Api20Impl.addRemoteInput(createBuilder, remoteInput);
            }
        }
        Bundle bundle = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            Api24Impl.setAllowGeneratedReplies(createBuilder, action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i7 >= 28) {
            Api28Impl.setSemanticAction(createBuilder, action.getSemanticAction());
        }
        if (i7 >= 29) {
            Api29Impl.setContextual(createBuilder, action.isContextual());
        }
        if (i7 >= 31) {
            Api31Impl.setAuthenticationRequired(createBuilder, action.isAuthenticationRequired());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        Api20Impl.addExtras(createBuilder, bundle);
        Api20Impl.addAction(this.mBuilder, Api20Impl.build(createBuilder));
    }

    @Nullable
    private static List<String> combineLists(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    @Nullable
    private static List<String> getPeople(@Nullable List<Person> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().resolveToLegacyUri());
        }
        return arrayList;
    }

    public Notification build() {
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.mBuilderCompat.mStyle;
        if (style != null) {
            style.apply(this);
        }
        RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        Notification buildInternal = buildInternal();
        if (makeContentView != null) {
            buildInternal.contentView = makeContentView;
        } else {
            RemoteViews remoteViews = this.mBuilderCompat.mContentView;
            if (remoteViews != null) {
                buildInternal.contentView = remoteViews;
            }
        }
        if (style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            buildInternal.bigContentView = makeBigContentView;
        }
        if (style != null && (makeHeadsUpContentView = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            buildInternal.headsUpContentView = makeHeadsUpContentView;
        }
        if (style != null && (extras = NotificationCompat.getExtras(buildInternal)) != null) {
            style.addCompatExtras(extras);
        }
        return buildInternal;
    }

    protected Notification buildInternal() {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 26) {
            return this.mBuilder.build();
        }
        if (i6 >= 24) {
            Notification build = this.mBuilder.build();
            if (this.mGroupAlertBehavior != 0) {
                if (Api20Impl.getGroup(build) != null && (build.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                    removeSoundAndVibration(build);
                }
                if (Api20Impl.getGroup(build) != null && (build.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                    removeSoundAndVibration(build);
                }
            }
            return build;
        }
        this.mBuilder.setExtras(this.mExtras);
        Notification build2 = this.mBuilder.build();
        RemoteViews remoteViews = this.mContentView;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.mBigContentView;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.mHeadsUpContentView;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.mGroupAlertBehavior != 0) {
            if (Api20Impl.getGroup(build2) != null && (build2.flags & 512) != 0 && this.mGroupAlertBehavior == 2) {
                removeSoundAndVibration(build2);
            }
            if (Api20Impl.getGroup(build2) != null && (build2.flags & 512) == 0 && this.mGroupAlertBehavior == 1) {
                removeSoundAndVibration(build2);
            }
        }
        return build2;
    }

    @Override // androidx.core.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    Context getContext() {
        return this.mContext;
    }
}
