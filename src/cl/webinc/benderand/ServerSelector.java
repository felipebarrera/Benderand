package cl.webinc.benderand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ServerSelector extends AppCompatActivity
{
	private Button btnOnline;
	private Button btnLocal;
	private Button btninternal;
	private AppMy app = AppMy.getinstance();
	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.serverselector);
		setTitle("Selector");
	    btnOnline = (Button) findViewById(R.id.btnOnline);
	    btnLocal = (Button) findViewById(R.id.btnlocal);
	    btninternal = (Button) findViewById(R.id.btnTestOnline);
	    btnOnline.setOnClickListener(new View.OnClickListener() 
	    {        	
	        public void onClick(View v) 
	        {
	        	app.setExternal(true);
	        	app.setUrl("www.webinc.cl");
	        	Intent i = new Intent(ServerSelector.this, Login.class);
	        	startActivity(i);
	        }       
	    });
	    btnLocal.setOnClickListener(new View.OnClickListener() 
	    {        	
	        public void onClick(View v) 
	        {
	        	app.setExternal(true);
	        	app.setUrl("192.168.1.103/webinc");
	        	Intent i = new Intent(ServerSelector.this, Login.class);
	        	startActivity(i);
	        }        
	    });
	    btninternal.setOnClickListener(new View.OnClickListener() 
	    {        	
	        public void onClick(View v) 
	        {
	        	app.setExternal(false);
	        	Intent i = new Intent(ServerSelector.this, Login.class);
	        	startActivity(i);
	        }        
	    });
	}
	@Override
	protected void onResume() {
		super.onResume();
	}
}