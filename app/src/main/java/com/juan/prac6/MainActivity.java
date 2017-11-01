package com.juan.prac6;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    PrestamosSQLiteHelper prestamosSQLiteHelper;
    SQLiteDatabase dbPrestamos;
    EditText eID, eName, eAutor,eNomlib, ePhone;
    Button bRegistrar,bModificar,bBuscar,bEliminar;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_main,contentFrameLayout);
        eID= (EditText) findViewById(R.id.eID);
        eName= (EditText) findViewById(R.id.eName);
        ePhone= (EditText) findViewById(R.id.eTelefono);
        eNomlib= (EditText) findViewById(R.id.eNomlib);
        eAutor= (EditText) findViewById(R.id.eAutor);
        bRegistrar= (Button) findViewById(R.id.bRegistrar);
        bEliminar= (Button) findViewById(R.id.bEliminar);
        bBuscar= (Button) findViewById(R.id.bBuscar);
        bModificar= (Button) findViewById(R.id.bModificar);
        prestamosSQLiteHelper= new PrestamosSQLiteHelper(this,"PrestamosDB",null,1);
        dbPrestamos= prestamosSQLiteHelper.getWritableDatabase();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
    }
    public void onClick(View view) {
        int id= view.getId();
        String idd,name,phone,autor,nomlib;
        idd=eID.getText().toString();
        name=eName.getText().toString();
        phone=ePhone.getText().toString();
        autor=eAutor.getText().toString();
        nomlib=eNomlib.getText().toString();
        ContentValues data= new ContentValues();
        switch (id){
            case R.id.bRegistrar:
                data.put("id",idd);
                data.put("nombre",name);
                data.put("telefono",phone);
                data.put("autor",autor);
                data.put("nombrelib",nomlib);
                dbPrestamos.insert("prestamos",null,data);
                clean();
                break;
            case R.id.bEliminar:
                dbPrestamos.delete("prestamos","telefono='"+phone+"'",null);
                clean();

                break;
            case R.id.bBuscar:
                Cursor c= dbPrestamos.rawQuery("SELECT * FROM prestamos WHERE telefono='"+phone+"'",null);
                if (c.moveToFirst()){
                    eID.setText(c.getString(0));
                    eName.setText(c.getString(1));
                    ePhone.setText(c.getString(2));
                    eNomlib.setText(c.getString(3));
                    eAutor.setText(c.getString(4));
                }
                else{
                    Toast.makeText(this,"No existe", Toast.LENGTH_SHORT).show();}

                break;
            case R.id.bModificar:
                data.put("id",idd);
                data.put("nombre",name);
                data.put("telefono",phone);
                data.put("autor",autor);
                data.put("nombrelib",nomlib);
                dbPrestamos.update("prestamos",data,"telefono='"+phone+"'",null);
                clean();

                break;
        }
    }

    private void clean() {
        ePhone.setText("");
        eName.setText("");
        eID.setText("");
        eAutor.setText("");
        eNomlib.setText("");
    }

}
