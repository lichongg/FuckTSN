package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LocationCompat {
    public static final String EXTRA_BEARING_ACCURACY = "bearingAccuracy";
    public static final String EXTRA_IS_MOCK = "mockLocation";
    public static final String EXTRA_MSL_ALTITUDE = "androidx.core.location.extra.MSL_ALTITUDE";
    public static final String EXTRA_MSL_ALTITUDE_ACCURACY = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    public static final String EXTRA_SPEED_ACCURACY = "speedAccuracy";
    public static final String EXTRA_VERTICAL_ACCURACY = "verticalAccuracy";

    @Nullable
    private static Field sFieldsMaskField;

    @Nullable
    private static Integer sHasBearingAccuracyMask;

    @Nullable
    private static Integer sHasSpeedAccuracyMask;

    @Nullable
    private static Integer sHasVerticalAccuracyMask;

    @Nullable
    private static Method sSetIsFromMockProviderMethod;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(28)
    private static class Api28Impl {
        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            if (location.hasBearingAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                Bundle extras = location.getExtras();
                location.reset();
                location.setProvider(provider);
                location.setTime(time);
                location.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location.setLatitude(latitude);
                location.setLongitude(longitude);
                if (hasAltitude) {
                    location.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location.setSpeed(speed);
                }
                if (hasBearing) {
                    location.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location.setAccuracy(accuracy);
                }
                if (hasVerticalAccuracy) {
                    location.setVerticalAccuracyMeters(verticalAccuracyMeters);
                }
                if (hasSpeedAccuracy) {
                    location.setBearingAccuracyDegrees(speedAccuracyMetersPerSecond);
                }
                if (extras != null) {
                    location.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            if (location.hasSpeedAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location.setProvider(provider);
                location.setTime(time);
                location.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location.setLatitude(latitude);
                location.setLongitude(longitude);
                if (hasAltitude) {
                    location.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location.setSpeed(speed);
                }
                if (hasBearing) {
                    location.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location.setAccuracy(accuracy);
                }
                if (hasVerticalAccuracy) {
                    location.setVerticalAccuracyMeters(verticalAccuracyMeters);
                }
                if (hasBearingAccuracy) {
                    location.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            if (location.hasVerticalAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float accuracy = location.getAccuracy();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location.setProvider(provider);
                location.setTime(time);
                location.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location.setLatitude(latitude);
                location.setLongitude(longitude);
                if (hasAltitude) {
                    location.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location.setSpeed(speed);
                }
                if (hasBearing) {
                    location.setBearing(bearing);
                }
                if (hasAccuracy) {
                    location.setAccuracy(accuracy);
                }
                if (hasSpeedAccuracy) {
                    location.setSpeedAccuracyMetersPerSecond(speedAccuracyMetersPerSecond);
                }
                if (hasBearingAccuracy) {
                    location.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location.setExtras(extras);
                }
            }
        }

        private Api28Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @DoNotInline
        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @DoNotInline
        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        @DoNotInline
        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        @DoNotInline
        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }

        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasBearingAccuracyMask())));
            } catch (IllegalAccessException e6) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e6);
                throw illegalAccessError;
            } catch (NoSuchFieldException e7) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e7);
                throw noSuchFieldError;
            }
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasSpeedAccuracyMask())));
            } catch (IllegalAccessException e6) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e6);
                throw illegalAccessError;
            } catch (NoSuchFieldException e7) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e7);
                throw noSuchFieldError;
            }
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            try {
                LocationCompat.getFieldsMaskField().setByte(location, (byte) (LocationCompat.getFieldsMaskField().getByte(location) & (~LocationCompat.getHasVerticalAccuracyMask())));
            } catch (IllegalAccessException | NoSuchFieldException e6) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e6);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void setBearingAccuracyDegrees(Location location, float f6) {
            location.setBearingAccuracyDegrees(f6);
        }

        @DoNotInline
        static void setSpeedAccuracyMetersPerSecond(Location location, float f6) {
            location.setSpeedAccuracyMetersPerSecond(f6);
        }

        @DoNotInline
        static void setVerticalAccuracyMeters(Location location, float f6) {
            location.setVerticalAccuracyMeters(f6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            if (!location.hasBearingAccuracy()) {
                return;
            }
            double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeBearingAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            if (!location.hasSpeedAccuracy()) {
                return;
            }
            double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeSpeedAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            if (!location.hasVerticalAccuracy()) {
                return;
            }
            double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
            Api28Impl.removeVerticalAccuracy(location);
            location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static void removeBearingAccuracy(Location location) {
            location.removeBearingAccuracy();
        }

        @DoNotInline
        static void removeSpeedAccuracy(Location location) {
            location.removeSpeedAccuracy();
        }

        @DoNotInline
        static void removeVerticalAccuracy(Location location) {
            location.removeVerticalAccuracy();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static float getMslAltitudeAccuracyMeters(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        @DoNotInline
        static double getMslAltitudeMeters(Location location) {
            return location.getMslAltitudeMeters();
        }

        @DoNotInline
        static boolean hasMslAltitude(Location location) {
            return location.hasMslAltitude();
        }

        @DoNotInline
        static boolean hasMslAltitudeAccuracy(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        @DoNotInline
        static void removeMslAltitude(Location location) {
            location.removeMslAltitude();
        }

        @DoNotInline
        static void removeMslAltitudeAccuracy(Location location) {
            location.removeMslAltitudeAccuracy();
        }

        @DoNotInline
        static void setMslAltitudeAccuracyMeters(Location location, float f6) {
            location.setMslAltitudeAccuracyMeters(f6);
        }

        @DoNotInline
        static void setMslAltitudeMeters(Location location, double d6) {
            location.setMslAltitudeMeters(d6);
        }
    }

    public static float getBearingAccuracyDegrees(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getBearingAccuracyDegrees(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_BEARING_ACCURACY, 0.0f);
    }

    public static long getElapsedRealtimeMillis(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    @SuppressLint({"BlockedPrivateApi"})
    static Field getFieldsMaskField() throws NoSuchFieldException {
        if (sFieldsMaskField == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            sFieldsMaskField = declaredField;
            declaredField.setAccessible(true);
        }
        return sFieldsMaskField;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasBearingAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasBearingAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasBearingAccuracyMask = Integer.valueOf(declaredField.getInt(null));
        }
        return sHasBearingAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasSpeedAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasSpeedAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasSpeedAccuracyMask = Integer.valueOf(declaredField.getInt(null));
        }
        return sHasSpeedAccuracyMask.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int getHasVerticalAccuracyMask() throws NoSuchFieldException, IllegalAccessException {
        if (sHasVerticalAccuracyMask == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            sHasVerticalAccuracyMask = Integer.valueOf(declaredField.getInt(null));
        }
        return sHasVerticalAccuracyMask.intValue();
    }

    @FloatRange(from = 0.0d)
    public static float getMslAltitudeAccuracyMeters(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.getMslAltitudeAccuracyMeters(location) : getOrCreateExtras(location).getFloat(EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static double getMslAltitudeMeters(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.getMslAltitudeMeters(location) : getOrCreateExtras(location).getDouble(EXTRA_MSL_ALTITUDE);
    }

    private static Method getSetIsFromMockProviderMethod() throws NoSuchMethodException {
        if (sSetIsFromMockProviderMethod == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            sSetIsFromMockProviderMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sSetIsFromMockProviderMethod;
    }

    public static float getSpeedAccuracyMetersPerSecond(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_SPEED_ACCURACY, 0.0f);
    }

    public static float getVerticalAccuracyMeters(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getVerticalAccuracyMeters(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(EXTRA_VERTICAL_ACCURACY, 0.0f);
    }

    public static boolean hasBearingAccuracy(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.hasBearingAccuracy(location) : containsExtra(location, EXTRA_BEARING_ACCURACY);
    }

    public static boolean hasMslAltitude(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.hasMslAltitude(location) : containsExtra(location, EXTRA_MSL_ALTITUDE);
    }

    public static boolean hasMslAltitudeAccuracy(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.hasMslAltitudeAccuracy(location) : containsExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
    }

    public static boolean hasSpeedAccuracy(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.hasSpeedAccuracy(location) : containsExtra(location, EXTRA_SPEED_ACCURACY);
    }

    public static boolean hasVerticalAccuracy(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.hasVerticalAccuracy(location) : containsExtra(location, EXTRA_VERTICAL_ACCURACY);
    }

    public static void removeBearingAccuracy(@NonNull Location location) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33) {
            Api33Impl.removeBearingAccuracy(location);
            return;
        }
        if (i6 >= 29) {
            Api29Impl.removeBearingAccuracy(location);
            return;
        }
        if (i6 >= 28) {
            Api28Impl.removeBearingAccuracy(location);
        } else if (i6 >= 26) {
            Api26Impl.removeBearingAccuracy(location);
        } else {
            removeExtra(location, EXTRA_BEARING_ACCURACY);
        }
    }

    public static void removeMslAltitude(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitude(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE);
        }
    }

    public static void removeMslAltitudeAccuracy(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.removeMslAltitudeAccuracy(location);
        } else {
            removeExtra(location, EXTRA_MSL_ALTITUDE_ACCURACY);
        }
    }

    public static void removeSpeedAccuracy(@NonNull Location location) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33) {
            Api33Impl.removeSpeedAccuracy(location);
            return;
        }
        if (i6 >= 29) {
            Api29Impl.removeSpeedAccuracy(location);
            return;
        }
        if (i6 >= 28) {
            Api28Impl.removeSpeedAccuracy(location);
        } else if (i6 >= 26) {
            Api26Impl.removeSpeedAccuracy(location);
        } else {
            removeExtra(location, EXTRA_SPEED_ACCURACY);
        }
    }

    public static void removeVerticalAccuracy(@NonNull Location location) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33) {
            Api33Impl.removeVerticalAccuracy(location);
            return;
        }
        if (i6 >= 29) {
            Api29Impl.removeVerticalAccuracy(location);
            return;
        }
        if (i6 >= 28) {
            Api28Impl.removeVerticalAccuracy(location);
        } else if (i6 >= 26) {
            Api26Impl.removeVerticalAccuracy(location);
        } else {
            removeExtra(location, EXTRA_VERTICAL_ACCURACY);
        }
    }

    public static void setBearingAccuracyDegrees(@NonNull Location location, float f6) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setBearingAccuracyDegrees(location, f6);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_BEARING_ACCURACY, f6);
        }
    }

    public static void setMslAltitudeAccuracyMeters(@NonNull Location location, @FloatRange(from = 0.0d) float f6) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeAccuracyMeters(location, f6);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_MSL_ALTITUDE_ACCURACY, f6);
        }
    }

    public static void setMslAltitudeMeters(@NonNull Location location, double d6) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMslAltitudeMeters(location, d6);
        } else {
            getOrCreateExtras(location).putDouble(EXTRA_MSL_ALTITUDE, d6);
        }
    }

    public static void setSpeedAccuracyMetersPerSecond(@NonNull Location location, float f6) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setSpeedAccuracyMetersPerSecond(location, f6);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_SPEED_ACCURACY, f6);
        }
    }

    public static void setVerticalAccuracyMeters(@NonNull Location location, float f6) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setVerticalAccuracyMeters(location, f6);
        } else {
            getOrCreateExtras(location).putFloat(EXTRA_VERTICAL_ACCURACY, f6);
        }
    }

    private LocationCompat() {
    }

    private static boolean containsExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null && extras.containsKey(str)) {
            return true;
        }
        return false;
    }

    public static long getElapsedRealtimeNanos(@NonNull Location location) {
        return location.getElapsedRealtimeNanos();
    }

    private static Bundle getOrCreateExtras(@NonNull Location location) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            location.setExtras(new Bundle());
            return location.getExtras();
        }
        return extras;
    }

    public static boolean isMock(@NonNull Location location) {
        return location.isFromMockProvider();
    }

    private static void removeExtra(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras(null);
            }
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void setMock(@NonNull Location location, boolean z5) {
        try {
            getSetIsFromMockProviderMethod().invoke(location, Boolean.valueOf(z5));
        } catch (IllegalAccessException e6) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e6);
            throw illegalAccessError;
        } catch (NoSuchMethodException e7) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e7);
            throw noSuchMethodError;
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }
}
