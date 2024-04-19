package com.xiaopeng.libtheme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import com.xiaopeng.libtheme.a;
import java.util.HashMap;
/* compiled from: ThemeWrapper.java */
/* loaded from: classes.dex */
public class b {
    private static int a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{i});
        if (obtainStyledAttributes != null && attributeSet != null) {
            try {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    return resourceId;
                }
            } catch (Exception unused) {
            }
            obtainStyledAttributes.recycle();
        }
        return 0;
    }

    private static void b(Context context, View view, String str, int i) {
        try {
            if (TextUtils.isEmpty(str) || str.length() <= 0) {
                return;
            }
            view.getClass().getPackage().getName();
            String name = view.getClass().getName();
            Class.forName(name).getMethod("set" + str.substring(0, 1).toUpperCase() + str.substring(1), Integer.TYPE).invoke(view, Integer.valueOf(i));
        } catch (Exception e) {
            Log.d("ThemeWrapper", "updateViewResource invoke=" + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HashMap<String, Integer> c(Context context, AttributeSet attributeSet) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i = 0;
        if (attributeSet != null) {
            int attributeCount = attributeSet.getAttributeCount();
            int i2 = 0;
            while (i < attributeCount) {
                try {
                    String attributeName = attributeSet.getAttributeName(i);
                    String attributeValue = attributeSet.getAttributeValue(i);
                    if (!TextUtils.isEmpty(attributeName) && !TextUtils.isEmpty(attributeValue) && a.C0018a.a(attributeName) && attributeValue.startsWith("@")) {
                        if (a.C0018a.b(attributeName)) {
                            i2 = 1;
                        } else {
                            hashMap.put(attributeName, Integer.valueOf(Integer.parseInt(attributeValue.substring(1))));
                        }
                    }
                } catch (Exception unused) {
                }
                i++;
            }
            i = i2;
        }
        if (i != 0) {
            context.getTheme();
            int a2 = a(context, attributeSet, 16842964);
            if (a2 != 0 && !hashMap.containsKey("background")) {
                hashMap.put("background", Integer.valueOf(a2));
            }
            int a3 = a(context, attributeSet, 16843017);
            if (a3 != 0 && !hashMap.containsKey("foreground")) {
                hashMap.put("foreground", Integer.valueOf(a3));
            }
            int a4 = a(context, attributeSet, 16842904);
            if (a4 != 0 && !hashMap.containsKey("textColor")) {
                hashMap.put("textColor", Integer.valueOf(a4));
            }
            int a5 = a(context, attributeSet, 16843033);
            if (a5 != 0 && !hashMap.containsKey("src")) {
                hashMap.put("src", Integer.valueOf(a5));
            }
        }
        return hashMap;
    }

    private static void d(int i, android.widget.TextView textView, Drawable drawable) {
        if (drawable == null || textView == null) {
            return;
        }
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            if (compoundDrawables != null) {
                compoundDrawables[i] = drawable;
                textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            }
        } else if (i == 4 || i == 5) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            if (compoundDrawablesRelative != null) {
                compoundDrawablesRelative[i == 4 ? (char) 0 : (char) 2] = drawable;
                textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            }
        }
    }

    private static void e(Context context, View view, String str, int i) {
        if (context == null || view == null || TextUtils.isEmpty(str)) {
            return;
        }
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        try {
            if ("alpha".equals(str)) {
                view.setAlpha(resources.getFloat(i));
            } else if ("background".equals(str)) {
                view.setBackground(resources.getDrawable(i, theme));
            } else if ("foreground".equals(str)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    view.setForeground(resources.getDrawable(i, theme));
                }
            } else if ("src".equals(str)) {
                ((ImageView) view).setImageDrawable(resources.getDrawable(i, theme));
            } else if ("textColor".equals(str)) {
                ((android.widget.TextView) view).setTextColor(resources.getColor(i));
            } else if ("textColorHint".equals(str)) {
                ((android.widget.TextView) view).setHintTextColor(resources.getColor(i));
            } else if ("drawableLeft".equals(str)) {
                d(0, (android.widget.TextView) view, resources.getDrawable(i, theme));
            } else if ("drawableTop".equals(str)) {
                d(1, (android.widget.TextView) view, resources.getDrawable(i, theme));
            } else if ("drawableRight".equals(str)) {
                d(2, (android.widget.TextView) view, resources.getDrawable(i, theme));
            } else if ("drawableBottom".equals(str)) {
                d(3, (android.widget.TextView) view, resources.getDrawable(i, theme));
            } else if ("drawableStart".equals(str)) {
                d(4, (android.widget.TextView) view, resources.getDrawable(i, theme));
            } else if ("drawableEnd".equals(str)) {
                d(5, (android.widget.TextView) view, resources.getDrawable(i, theme));
            } else if ("progressDrawable".equals(str)) {
                ((ProgressBar) view).setProgressDrawable(resources.getDrawable(i, theme));
            } else if ("thumb".equals(str)) {
                ((SeekBar) view).setThumb(resources.getDrawable(i, theme));
            } else if ("button".equals(str)) {
                ((CompoundButton) view).setButtonDrawable(resources.getDrawable(i, theme));
            } else if ("divider".equals(str)) {
                ((ListView) view).setDivider(resources.getDrawable(i, theme));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(View view, HashMap<String, Integer> hashMap) {
        if (view == null || hashMap == null) {
            return;
        }
        for (String str : hashMap.keySet()) {
            if (a.C0018a.a(str)) {
                e(view.getContext(), view, str, hashMap.get(str).intValue());
            } else {
                b(view.getContext(), view, str, hashMap.get(str).intValue());
            }
        }
    }
}
