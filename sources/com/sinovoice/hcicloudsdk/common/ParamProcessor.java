package com.sinovoice.hcicloudsdk.common;

import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ParamProcessor {
    public static final String VALUE_OF_NO = "no";
    public static final String VALUE_OF_YES = "yes";

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, String> f318a = new HashMap<>();

    public void addParam(String str, String str2) {
        this.f318a.put(str, str2);
    }

    public boolean equals(ParamProcessor paramProcessor) {
        return paramProcessor != null && getStringConfig().equals(paramProcessor.getStringConfig());
    }

    public String getParam(String str) {
        return this.f318a.get(str);
    }

    public String getStringConfig() {
        Iterator<String> it = this.f318a.keySet().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            String next = it.next();
            String str = this.f318a.get(next);
            if (str != null) {
                stringBuffer.append(next);
                stringBuffer.append("=");
                stringBuffer.append(str);
                if (it.hasNext()) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }

    public void parseStringConfig(String str) {
        if (str == null) {
            return;
        }
        this.f318a.clear();
        for (String str2 : str.split(",")) {
            String[] split = str2.split("=");
            if (split.length >= 2) {
                this.f318a.put(split[0], split[1]);
            }
        }
    }
}
