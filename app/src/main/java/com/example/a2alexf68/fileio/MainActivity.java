package com.example.a2alexf68.fileio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import android.os.Environment;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit_text, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String dir_path = Environment.getExternalStorageDirectory().getAbsolutePath();
        EditText et = (EditText) findViewById(R.id.editText1);

        if (item.getItemId() == R.id.save) {

            try {
                FileWriter fw = new FileWriter(dir_path + "/text.txt");
                PrintWriter pw = new PrintWriter(fw);


                pw.print(et.getText().toString());
                pw.flush();
                pw.close(); // close the file to ensure data is flushed to file

            } catch (IOException e) {
                System.out.println("I/O Error: " + e);
            }
            return true;
        } else if (item.getItemId() == R.id.load) {
            try
            {
                FileReader fr = new FileReader(dir_path + "/text.txt");
                BufferedReader br = new BufferedReader(fr);

                et.setText(br.readLine());

                String et1 = "";
                while((et1 = br.readLine()) != null)
                {
                    System.out.println(et1);
                }
                br.close();

                return true;

            }catch (IOException e){
                System.out.println("I/O Error: " + e);
            }
        }
        return false;

    }
}




