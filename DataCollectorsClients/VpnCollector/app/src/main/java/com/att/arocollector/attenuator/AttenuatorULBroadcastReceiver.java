/*
 *  Copyright 2018 AT&T
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
package com.att.arocollector.attenuator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
  */

public class AttenuatorULBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = AttenuatorULBroadcastReceiver.class.getSimpleName();

    public AttenuatorULBroadcastReceiver() {
        super();

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        int ulMs = intent.getIntExtra("ulms" ,0);

        if(ulMs>=0){//range check for negative throttle number
            Log.i(TAG, "Upload stream delay for: "+ ulMs+ " ms");
            AttenuatorManager.getInstance().setDelayUl(ulMs);
            CharSequence text = "Upload stream delay for "+ ulMs+ " ms";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else{
            Log.i(TAG,"Invalid attenuation delay value"+ ulMs + "ms");
        }

    }
}
