package dk.itu.mmad.callingexternalapps;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Button callButton = (Button) findViewById(R.id.callnumber);
		callButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText number = (EditText) findViewById(R.id.number);
				String num = number.getText().toString();
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:" + num));
				startActivity(intent);
			}
		});
		
		
		Button webButton = (Button) findViewById(R.id.bringupweb);
		webButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText address = (EditText) findViewById(R.id.www);
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(address.getText().toString()));
				startActivity(intent);
			}
		});
	}

}
