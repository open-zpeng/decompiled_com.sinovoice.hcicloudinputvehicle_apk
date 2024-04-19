package com.sinovoice.hcicloudsdk.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {
    private static native void hciDnsSetDirty();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        hciDnsSetDirty();
    }
}
