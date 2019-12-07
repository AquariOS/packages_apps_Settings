/*
 * Copyright (C) 2019 AquariOS
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

package com.android.settings.deviceinfo.aquarios;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.text.BidiFormatter;
import android.text.TextUtils;
import android.text.format.DateFormat;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AquaBuildDateDisplayController extends BasePreferenceController {

    private static final String TAG = "AquariOSVersion";
    private static final String AQUARIOS_BUILD_DATE_KEY = "aquarios_build_date";

    private Preference mPreference;

    public AquaBuildDateDisplayController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        mPreference = screen.findPreference(getPreferenceKey());
    }

    public static String getAquaBuildDate() {
        String buildDate = SystemProperties.get("ro.build.date","");
        if (!"".equals(buildDate)) {
            try {
                SimpleDateFormat template = new SimpleDateFormat("yyyy-MM-dd");
                Date aquaBuildDate = template.parse(buildDate);
                String format = DateFormat.getBestDateTimePattern(Locale.getDefault(), "dMMMMyyyy");
                buildDate = DateFormat.format(format, aquaBuildDate).toString();
            } catch (ParseException e) {
                // broken parse; fall through and use the raw string
            }
            return buildDate;
        } else {
            return null;
        }
    }

    @Override
    public CharSequence getSummary() {
        return getAquaBuildDate();
    }

    @Override
    public String getPreferenceKey() {
        return AQUARIOS_BUILD_DATE_KEY;
    }
}
