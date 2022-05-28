package br.edimilsonborges.seupesoemoutroplaneta;

/*
 * Created by Edimilson Borges on 29/11/2017.
 */

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;

public class MessageAtualizar {
    private static Context context;

    public MessageAtualizar(Context context) {
        this.context = context;
    }

    public MessageAtualizar(){

    }

    public void message(String versao, int versaoCode){

        PackageInfo pInfo = null;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        int verCode = pInfo.versionCode;

      //if(versaoCode > verCode){
        if(versaoCode > verCode){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setCancelable(false);
            alert.setTitle(R.string.titleAtualizacao);
            alert.setMessage(context.getString(R.string.mess1Atualizacao)+" "+versao+" "+context.getString(R.string.mess2Atualizacao));
            alert.setNeutralButton(context.getString(R.string.alertbutnao), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
            alert.setPositiveButton(context.getString(R.string.alertbutsim), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String urlString="https://play.google.com/store/apps/details?id=br.edimilsonborges.seupesoemoutroplaneta";
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.vending");
                try {
                    context.startActivity(intent);
                } catch (ActivityNotFoundException ex) {
                    // Chrome browser presumably not installed so allow user to choose instead
                    intent.setPackage(null);
                    context.startActivity(intent);
                }

            }
        });
            alert.create();
            alert.show();
    }}
}
