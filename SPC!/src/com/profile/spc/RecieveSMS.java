package com.profile.spc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.widget.Toast;
import android.media.AudioManager;
import android.os.Bundle;

public class RecieveSMS extends BroadcastReceiver 
{   
    public static final String SMS_BUNDLE = "pdus";

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle intentExtras = intent.getExtras();
            if (intentExtras != null) {
                Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
                for (int i = 0; i < sms.length; ++i) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                    String smsBody = smsMessage.getMessageBody().toString();
                    if (smsBody.contains("silent") || smsBody.contains("SILENT"))
                    {
                    AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                    am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    }
                    else if (smsBody.contains("ring") || smsBody.contains("RING"))
                    {
                    AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                    am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    }
                    else if (smsBody.contains("vibrate") || smsBody.contains("VIBRATE"))
                    {
                    AudioManager am = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                    am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                    }
                    Toast.makeText(context, smsBody, Toast.LENGTH_SHORT).show();
                }
            }
    }
}