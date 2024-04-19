package com.sinovoice.hcicloudinputvehicle.service;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.MenuItem;
/* loaded from: classes.dex */
public class SettingActivity extends PreferenceActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f187a = g.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f188b;

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent intent = super.getIntent();
        if (intent.getStringExtra(":android:show_fragment") == null) {
            intent.putExtra(":android:show_fragment", f187a);
        }
        intent.putExtra(":android:no_headers", true);
        return intent;
    }

    @Override // android.preference.PreferenceActivity
    public boolean isValidFragment(String str) {
        return true;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        Intent intent = getIntent();
        if (actionBar != null) {
            boolean booleanExtra = intent.getBooleanExtra("show_home_as_up", true);
            this.f188b = booleanExtra;
            actionBar.setDisplayHomeAsUpEnabled(booleanExtra);
            actionBar.setHomeButtonEnabled(this.f188b);
        }
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f188b && menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(f.b());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(f.b());
    }
}
