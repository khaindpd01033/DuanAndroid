package com.example.chuyenmuc;

import com.example.duanandroid.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GopyActivity extends Activity {

	private TextView recipient;
	private EditText subject;
	private EditText body;
	ImageView btnsent;
	
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_gopy);

      recipient = (TextView) findViewById(R.id.recipient);
      subject = (EditText) findViewById(R.id.subject);
      body = (EditText) findViewById(R.id.body);
      btnsent=(ImageView)findViewById(R.id.sendEmail);
      btnsent.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
        	 sendEmail();
        	 // after sending the email, clear the fields
        	 recipient.setText("khaindpd01033@fpt.edu.vn");
        	 subject.setText("");
        	 body.setText("");
         }
   });

   }
   protected void sendEmail() {

      String[] recipients = {recipient.getText().toString()};
      Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:khaindpd01033@fpt.edu.vn"));
      // prompts email clients only
      email.setType("message/rfc822");

      email.putExtra(Intent.EXTRA_EMAIL, recipients);
      email.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
      email.putExtra(Intent.EXTRA_TEXT, body.getText().toString());

      try {
	    // the user can choose the email client
         startActivity(Intent.createChooser(email, "Choose an email client from..."));
     
      } catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(GopyActivity.this, "No email client installed.",
        		 Toast.LENGTH_LONG).show();
      }
   }
   
}
