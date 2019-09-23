package com.gsoe.schnappspiel;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.util.*;

public class MainActivity extends Activity 
{
	Button b;
	TextView tv;
	LinearLayout ll;
	Timer t=new Timer();
	TimerTask tt;
	Random Zufall=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		b=findViewById(R.id.mainButton1);
		tv=findViewById(R.id.mainTextView1);
		ll=findViewById(R.id.mainLinearLayout1);
	
		tt=new TimerTask() 
		{ 
			@Override
			public void run()
			{ 

				runOnUiThread(new Runnable()
					{
						@Override
						public void run()
						{
							int maxx=ll.getMeasuredWidth();
							if (maxx==0) maxx=100;
							int maxy=ll.getMeasuredHeight();
							if (maxy==0) maxy=100;
							b.setX(Zufall.nextInt(maxx));
							b.setY(Zufall.nextInt(maxy));
						}
					});
			}
		};
		t.schedule(tt,0,750); 
    }
	
	int aTreffer=0;
	
	public void buttonClick(View v)
	{
		aTreffer++;
		tv.setText(Integer.toString(aTreffer));
	}
	
	
}
