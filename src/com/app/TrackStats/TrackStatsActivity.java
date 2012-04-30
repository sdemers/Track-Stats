package com.app.TrackStats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class TrackStatsActivity extends Activity
{
    TrackView trackView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        trackView = new TrackView(this);
        setContentView(trackView);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle item selection
        switch (item.getItemId())
        {
            case R.id.open_file:
                openFile();
                return true;
                
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    private void openFile()
    {
        Intent openFile = new Intent(TrackStatsActivity.this, FileManagerActivity.class);
        TrackStatsActivity.this.startActivity(openFile);
    }
}