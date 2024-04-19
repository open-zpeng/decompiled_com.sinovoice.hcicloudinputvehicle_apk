package com.sinovoice.hcicloudinputvehicle.engine.handwrite;

import com.sinovoice.hcicloudsdk.api.hwr.HciCloudHwr;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChineseHandWriteWrapper.java */
/* loaded from: classes.dex */
public class b extends f {
    private static final String d = "b";

    @Override // com.sinovoice.hcicloudinputvehicle.engine.handwrite.f
    public void a() {
        super.a();
        this.c.addParam("resPrefix", "cn.");
        this.c.addParam("recogRange", "gbk+all");
        int hciHwrSessionStart = HciCloudHwr.hciHwrSessionStart(this.c.getStringConfig(), this.f165b);
        String str = d;
        b.b.a.b.a.c(str, "hciHWRSessionStart return: " + hciHwrSessionStart);
    }
}
