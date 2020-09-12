package com.example.javaadvanced.multithreading.task;

import android.os.AsyncTask;

public class UpdateTask extends AsyncTask<String, Integer, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
        protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
