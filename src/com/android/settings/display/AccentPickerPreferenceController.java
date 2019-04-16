/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.display;

import android.app.Fragment;
import android.content.Context;
import android.content.om.IOverlayManager;
import android.os.UserHandle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.Preference.OnPreferenceClickListener;
import android.support.v7.preference.PreferenceScreen;
import com.android.internal.statusbar.ThemeAccentUtils;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnResume;
import com.android.settings.R;

import com.aquarios.coralreef.helpers.AccentPicker;

public class AccentPickerPreferenceController extends AbstractPreferenceController
        implements PreferenceControllerMixin, LifecycleObserver, OnResume {

    private static final String KEY_ACCENT_PICKER_FRAGMENT_PREF = "accent_picker";
    private static final int MY_USER_ID = UserHandle.myUserId();

    private final Fragment mParent;
    private Preference mAccentPickerPref;
    private IOverlayManager mOverlayManager;
    private int mCurrentUserId;

    public AccentPickerPreferenceController(Context context, Lifecycle lifecycle, Fragment parent) {
        super(context);
        mParent = parent;
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        mAccentPickerPref  = (Preference) screen.findPreference(KEY_ACCENT_PICKER_FRAGMENT_PREF);
    }

    @Override
    public void onResume() {
        updateEnableState();
        updateSummary();
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_ACCENT_PICKER_FRAGMENT_PREF;
    }

    public void updateEnableState() {
        if (mAccentPickerPref == null) {
            return;
        }

        mAccentPickerPref.setOnPreferenceClickListener(
            new OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    AccentPicker.show(mParent);
                    return true;
                }
            });
    }

    public void updateSummary(IOverlayManager om, int selectedAcccent) {
        if (selectedAcccent == 0) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_default);
        } else if (selectedAcccent == 1) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_red);
        } else if (selectedAcccent == 2) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_pink);
        } else if (selectedAcccent == 3) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_purple);
        } else if (selectedAcccent == 4) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_deep_purple);
        } else if (selectedAcccent == 5) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_indigo);
        } else if (selectedAcccent == 6) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_blue);
        } else if (selectedAcccent == 7) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_light_blue);
        } else if (selectedAcccent == 8) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_cyan);
        } else if (selectedAcccent == 9) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_teal);
        } else if (selectedAcccent == 10) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_green);
        } else if (selectedAcccent == 11) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_light_green);
        } else if (selectedAcccent == 12) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_lime);
        } else if (selectedAcccent == 13) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_yellow);
        } else if (selectedAcccent == 14) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_amber);
        } else if (selectedAcccent == 15) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_orange);
        } else if (selectedAcccent == 16) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_deep_orange);
        } else if (selectedAcccent == 17) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_brown);
        } else if (selectedAcccent == 18) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_grey);
        } else if (selectedAcccent == 19) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_blue_grey);
        } else if (selectedAcccent == 20) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_user_one);
        } else if (selectedAcccent == 21) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_user_two);
        } else if (selectedAcccent == 22) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_user_three);
        } else if (selectedAcccent == 23) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_user_four);
        } else if (selectedAcccent == 24) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_user_five);
        } else if (selectedAcccent == 25) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_user_six);
        } else if (selectedAcccent == 26) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_user_seven);
        } else if (selectedAcccent == 27) {
            if (ThemeAccentUtils.isUsingDarkTheme(mOverlayManager, mCurrentUserId) ||
                ThemeAccentUtils.isUsingBlackTheme(mOverlayManager, mCurrentUserId)) {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_white);
            } else {
                mAccentPickerPref.setSummary(
                        R.string.pref_summary_accent_color_black);
            }
        }
    }
}
