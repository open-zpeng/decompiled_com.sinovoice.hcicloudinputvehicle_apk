package com.sinovoice.hcicloudinputvehicle.service;

import android.content.Context;
import android.os.Handler;
/* compiled from: InputLogicControlFactory.java */
/* loaded from: classes.dex */
public class c {
    public static InputLogicControlInterface a(Context context, Handler handler, HciCloudInputConnection hciCloudInputConnection) {
        b bVar = new b(context, handler, hciCloudInputConnection);
        d dVar = new d();
        dVar.b(bVar);
        return dVar;
    }
}
