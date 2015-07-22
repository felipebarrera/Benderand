package cl.webinc.benderand.movidos;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import cl.webinc.benderand.ProductoList;
import cl.webinc.benderand.R;

public class PosMenu extends TabActivity
{

	@Override
    protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.menu);

	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, CarroCompraList.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("Venta").setIndicator("Venta")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    tabHost.getTabWidget().getChildAt(0).getLayoutParams().height = 50;
	    tabHost.getTabWidget().getChildAt(0).getLayoutParams().width = 50;
	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, ProductoList.class);
	    spec = tabHost.newTabSpec("Productos").setIndicator("Productos")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 50;
	    tabHost.getTabWidget().getChildAt(1).getLayoutParams().width = 60;

	    intent = new Intent().setClass(this, ProductoWeb.class);
	    spec = tabHost.newTabSpec("Sinc").setIndicator("Sinc")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    tabHost.getTabWidget().getChildAt(2).getLayoutParams().height = 50;
	    tabHost.getTabWidget().getChildAt(2).getLayoutParams().width = 60;

	    intent = new Intent().setClass(this, ProductoWeb.class);
	    spec = tabHost.newTabSpec("Sinc2").setIndicator("Sinc2")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    tabHost.getTabWidget().getChildAt(3).getLayoutParams().height = 50;
	    tabHost.getTabWidget().getChildAt(3).getLayoutParams().width = 60;

	    intent = new Intent().setClass(this, ProductoWeb.class);
	    spec = tabHost.newTabSpec("Sinc3").setIndicator("Sinc3")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    tabHost.getTabWidget().getChildAt(4).getLayoutParams().height = 50;
	    tabHost.getTabWidget().getChildAt(4).getLayoutParams().width = 60;

	    intent = new Intent().setClass(this, ProductoWeb.class);
	    spec = tabHost.newTabSpec("Sinc3").setIndicator("Sinc3")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    tabHost.getTabWidget().getChildAt(5).getLayoutParams().height = 50;
	    tabHost.getTabWidget().getChildAt(5).getLayoutParams().width = 60;

	    intent = new Intent().setClass(this, ProductoWeb.class);
	    spec = tabHost.newTabSpec("Sinc3").setIndicator("Sinc3")
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    tabHost.getTabWidget().getChildAt(6).getLayoutParams().height = 50;
	    tabHost.getTabWidget().getChildAt(6).getLayoutParams().width = 60;

	    tabHost.setCurrentTab(1);
	}	
}
