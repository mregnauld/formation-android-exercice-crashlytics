package com.formationandroid.crashlytics;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// init :
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// utilisateur fictif :
		Crashlytics.setUserIdentifier("demo123456789");
	}
	
	/**
	 * Listener clic bouton crash.
	 * @param view Bouton
	 */
	public void onClickCrash(View view)
	{
		// init :
		int numerateur = new Random().nextInt(2);
		int denominateur = new Random().nextInt(2);
		
		try
		{
			// calcul :
			int resultat = numerateur / denominateur;
			Toast.makeText(this, "Résultat : " + resultat, Toast.LENGTH_LONG).show();
		}
		catch (Exception e)
		{
			// envoi de l'exception à Crashlytics :
			Crashlytics.log("numérateur : " + numerateur + " / dénominateur : " + denominateur);
			Crashlytics.logException(e);
			
			// affichage local de l'exception :
			e.printStackTrace();
			Toast.makeText(this, "Erreur : division par zéro !", Toast.LENGTH_LONG).show();
		}
	}
	
}
