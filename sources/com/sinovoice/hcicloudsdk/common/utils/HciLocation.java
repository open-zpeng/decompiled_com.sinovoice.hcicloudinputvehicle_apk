package com.sinovoice.hcicloudsdk.common.utils;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
/* loaded from: classes.dex */
public class HciLocation {

    /* renamed from: a  reason: collision with root package name */
    private static final String f435a = "HciLocation";

    /* renamed from: b  reason: collision with root package name */
    private static final LocationListener f436b = new LocationListener() { // from class: com.sinovoice.hcicloudsdk.common.utils.HciLocation.1
        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    public static void UpdateLocation(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (bestProvider == null) {
            CloudLog.d(f435a, "Location provider null");
            return;
        }
        String str = f435a;
        CloudLog.d(str, "Location provider:" + bestProvider);
        Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
        if (lastKnownLocation != null) {
            CloudLog.d(str, "Location: Lat: " + lastKnownLocation.getLatitude() + " Lng: " + lastKnownLocation.getLongitude());
            return;
        }
        LocationListener locationListener = f436b;
        locationManager.requestLocationUpdates(bestProvider, 2000L, 0.0f, locationListener);
        Location lastKnownLocation2 = locationManager.getLastKnownLocation(bestProvider);
        if (lastKnownLocation2 != null) {
            CloudLog.d(str, "Location: Lat: " + lastKnownLocation2.getLatitude() + " Lng: " + lastKnownLocation2.getLongitude());
            locationManager.removeUpdates(locationListener);
        }
    }
}
