package cl.webinc.benderand.util;

import android.content.Intent;
import android.widget.Toast;

/**
 * Created by FelipeBarrera on 07-07-2015.
 */
public class EmailSender {
    Intent i = new Intent(Intent.ACTION_SEND);
    /*
    i.setType("message/rfc822");
    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
    i.putExtra(Intent.EXTRA_TEXT   , "body of email");
    try {
        startActivity(Intent.createChooser(i, "Send mail..."));
    } catch (android.content.ActivityNotFoundException ex) {
        Toast.makeText(MyActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
    }
    */
}
