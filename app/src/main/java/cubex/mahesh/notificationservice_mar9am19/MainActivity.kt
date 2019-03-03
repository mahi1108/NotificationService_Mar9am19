package cubex.mahesh.notificationservice_mar9am19

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v4.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            var count = 0;
        button.setOnClickListener {
            var nManager:NotificationManager = getSystemService(
                Context.NOTIFICATION_SERVICE) as NotificationManager

             if(android.os.Build.VERSION.SDK_INT <
                 android.os.Build.VERSION_CODES.O)
             {
                 var nCompact = NotificationCompat.Builder(
                     this@MainActivity)
                nCompact.setSmallIcon(R.drawable.ic_local_shipping_black_24dp)
                nCompact.setTicker("Sample Notification @ And9amMar19")
                nCompact.setContentTitle("NareshIT - And9amMar19 ")
                nCompact.setContentText("sample  notification for demo @ NareshIT - And9amMar19")

                var i = Intent(this@MainActivity,
                    MainActivity::class.java)
                 var pIntent:PendingIntent = PendingIntent.getActivity(
                     this@MainActivity,0,i,0)
                nCompact.setContentIntent(pIntent)
                nCompact.setAutoCancel(true)
                nCompact.addAction(R.drawable.ic_cancel_black_24dp,
                    "Cancel",pIntent)
                 nCompact.addAction(R.drawable.ic_reply_black_24dp,
                     "Reply",pIntent)
                 nManager.notify(++count,nCompact.build())
             }else{
                        var nChannel:NotificationChannel =
                            NotificationChannel(count.toString(),
              "and9ammar19",
                                NotificationManager.IMPORTANCE_HIGH)
                        nChannel.setShowBadge(true)
                        nChannel.enableLights(true)
                        nChannel.enableVibration(true)
                 nManager.createNotificationChannel(nChannel)

                 var nCompact = NotificationCompat.Builder(
                     this@MainActivity,"and9ammar19")
                 nCompact.setSmallIcon(R.drawable.ic_local_shipping_black_24dp)
                 nCompact.setTicker("Sample Notification @ And9amMar19")
                 nCompact.setContentTitle("NareshIT - And9amMar19 ")
                 nCompact.setContentText("sample  notification for demo @ NareshIT - And9amMar19")

                 var i = Intent(this@MainActivity,
                     MainActivity::class.java)
                 var pIntent:PendingIntent = PendingIntent.getActivity(
                     this@MainActivity,0,i,0)
                 nCompact.setContentIntent(pIntent)
                 nCompact.setAutoCancel(true)
                 nCompact.addAction(R.drawable.ic_cancel_black_24dp,
                     "Cancel",pIntent)
                 nCompact.addAction(R.drawable.ic_reply_black_24dp,
                     "Reply",pIntent)
                 nManager.notify(++count,nCompact.build())
             }
        }

        button2.setOnClickListener {
            var vib: Vibrator = getSystemService(
                Context.VIBRATOR_SERVICE) as Vibrator
            vib.vibrate(VibrationEffect.createOneShot(10000,
                VibrationEffect.DEFAULT_AMPLITUDE))
        }

    }
}
