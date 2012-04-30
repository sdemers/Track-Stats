package com.app.TrackStats;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

public class FileManagerActivity extends Activity
{
    private static final int REQUEST_PICK_FILE = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        // Create a new Intent for the file picker activity
        Intent intent = new Intent(this, FilePickerActivity.class);
        
        // Set the initial directory to be the sdcard
        intent.putExtra(FilePickerActivity.EXTRA_FILE_PATH, Environment.getExternalStorageDirectory().toString());
        
        // Show hidden files
        //intent.putExtra(FilePickerActivity.EXTRA_SHOW_HIDDEN_FILES, true);
        
        // Only make .png files visible
        ArrayList<String> extensions = new ArrayList<String>();
        extensions.add(".gpx");
        extensions.add(".kml");
        extensions.add(".cvs");
        intent.putExtra(FilePickerActivity.EXTRA_ACCEPTED_FILE_EXTENSIONS, extensions);
        
        // Start the activity
        startActivityForResult(intent, REQUEST_PICK_FILE);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == RESULT_OK)
        {
            switch (requestCode)
            {
            case REQUEST_PICK_FILE:
                if (data.hasExtra(FilePickerActivity.EXTRA_FILE_PATH))
                {
                    // Get the file path
                    File f = new File(data.getStringExtra(FilePickerActivity.EXTRA_FILE_PATH));

                    // Set the file path text view
                    //mFilePathTextView.setText(f.getPath());
                }
            }
        }
    }
}
