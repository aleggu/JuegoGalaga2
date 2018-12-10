package mx.edu.ittepic.juegogalaga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Imagen nave, punteronave, fondo,enemigo1, enemigo2, enemigo3, bala, punterobala, punteroe1, punteroe2, punteroe3, ganaste, perdiste, balae1, balae2, balae3, pb1, pb2, pb3;
    Imagen m1, m2, m3, m4, m5;
    public Lienzo(Context context) {

        super(context);
        fondo=new Imagen(R.drawable.fondo, 0,0, this);
        nave=new Imagen(R.drawable.nave, 50,2000,this);
        punteronave=null;
        punterobala=null;
        punteroe1=null;
        punteroe2=null;
        punteroe3=null;
        pb1=null;
        pb2=null;
        pb3=null;
        enemigo1=new Imagen(R.drawable.enemigo, 50, 200, this);
        enemigo2=new Imagen(R.drawable.enemigo, 530, 300,this);
        enemigo3=new Imagen(R.drawable.enemigo, 1300, 100, this);
        bala=new Imagen(R.drawable.bala, 85,2250,this);
        ganaste=new Imagen(R.drawable.win, 500,1000,this);
        perdiste=new Imagen(R.drawable.lose, 500,1000,this);
        balae1= new Imagen (R.drawable.balaenemigo, (enemigo1.getX()+95), (enemigo1.getY()+250), this);
        balae2= new Imagen (R.drawable.balaenemigo, (enemigo2.getX()+95), (enemigo2.getY()+250), this);
        balae3= new Imagen (R.drawable.balaenemigo, (enemigo3.getX()+95), (enemigo3.getY()+250), this);
        m1=new Imagen(R.drawable.meteoro, 200, 300, this);
        m2=new Imagen(R.drawable.meteoro, 500, 400, this);
        m3=new Imagen(R.drawable.meteoro, 800, 500, this);
        m4=new Imagen(R.drawable.meteoro, 1000, 350, this);
        m5=new Imagen(R.drawable.meteoro, 1200, 470, this);
        punteroe1=enemigo1;
        punteroe2=enemigo2;
        punteroe3=enemigo3;
        pb1=balae1;
        pb2=balae2;
        pb3=balae3;
        ganaste.hacerVisible(false);
        perdiste.hacerVisible(false);
        enemigo1.mover(16);
        enemigo2.mover(10);
        enemigo3.mover(14);
        m1.mover(10);
        m2.mover(12);
        m3.mover(14);
        m4.mover(16);
        m5.mover(18);


        balae1.abajo(24, enemigo1, this);
        balae2.abajo(24, enemigo2, this);
        balae3.abajo(24, enemigo3, this);


    }
    protected void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p = new Paint();
        fondo.pintar(c,p);
        bala.pintar(c,p);
        nave.pintar(c,p);
        enemigo1.pintar(c,p);
        enemigo2.pintar(c,p);
        enemigo3.pintar(c,p);
        ganaste.pintar(c,p);
        perdiste.pintar(c,p);
        balae1.pintar(c,p);
        balae2.pintar(c,p);
        balae3.pintar(c,p);
        m1.pintar(c,p);
        m2.pintar(c,p);
        m3.pintar(c,p);
        m4.pintar(c,p);
        m5.pintar(c,p);




        punterobala=bala;
        punteronave=nave;

        if(punteroe1!=null) {
            if (punterobala.colision(enemigo1)) {
                enemigo1.hacerVisible(false);
                punteroe1 = null;
                bala.hacerVisible(false);
                balae1.hacerVisible(false);
                enemigo1.mover(0);
                balae1.abajo(0, enemigo1, this);
            }
        }

        if(pb1.colision(nave)|| pb2.colision(nave)|| pb3.colision(nave))
        {
            perdiste.hacerVisible(true);
            ganaste.hacerVisible(false);
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            enemigo1.hacerVisible(false);
            enemigo2.hacerVisible(false);
            enemigo3.hacerVisible(false);
            balae1.hacerVisible(false);
            balae2.hacerVisible(false);
            balae3.hacerVisible(false);
        }
        if(punteroe2!=null) {
            if (punterobala.colision(enemigo2)) {
                enemigo2.hacerVisible(false);
                punteroe2 = null;
                bala.hacerVisible(false);
                balae2.hacerVisible(false);
                enemigo2.mover(0);
                balae2.abajo(0, enemigo1, this);
            }
        }
        if(punteroe3!=null) {
            if (punterobala.colision(enemigo3)) {
                enemigo3.hacerVisible(false);
                punteroe3 = null;
                bala.hacerVisible(false);
                balae3.hacerVisible(false);
                enemigo3.mover(0);
                balae3.abajo(0, enemigo1, this);
            }
        }
        if(punteroe1==null && punteroe2==null && punteroe3==null)
        {
            ganaste.hacerVisible(true);
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            perdiste.hacerVisible(false);
        }
        if(punteronave.colision(enemigo1))
        {
            perdiste.hacerVisible(true);
            ganaste.hacerVisible(false);
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            enemigo1.hacerVisible(false);
            enemigo2.hacerVisible(false);
            enemigo3.hacerVisible(false);
        }
        if(punteronave.colision(enemigo2))
        {
            perdiste.hacerVisible(true);
            nave.hacerVisible(false);
            ganaste.hacerVisible(false);
            bala.hacerVisible(false);
            enemigo1.hacerVisible(false);
            enemigo2.hacerVisible(false);
            enemigo3.hacerVisible(false);
        }
        if(punteronave.colision(enemigo3))
        {
            perdiste.hacerVisible(true);
            nave.hacerVisible(false);
            bala.hacerVisible(false);
            ganaste.hacerVisible(false);
            enemigo1.hacerVisible(false);
            enemigo2.hacerVisible(false);
            enemigo3.hacerVisible(false);
        }

        /*c.drawBitmap(icono1, 100, 300, p);
        c.drawBitmap(icono2, 600, 300, p);*/
    }
    public boolean onTouchEvent (MotionEvent e)
    {
        float xp= e.getX();
        float yp=  e.getY();
        // mensaje="NO SE HA TOCADO OBJETO"
        switch ( e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(nave.estaEnArea(xp,yp))
                {
                    //mensaje="SE TOCO ICONO 1";
                    punteronave=nave;//puntero Apunta a icono1
                    punterobala=bala;
                    bala=new Imagen(R.drawable.bala, xp-10,2250,this);
                    bala.arriba(30);

                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(punteronave!=null)
                {
                    punteronave.desplaza(xp);
                    if(punteroe1==null && punteroe2==null && punteroe3==null)
                    {
                        ganaste.hacerVisible(true);
                        ganaste.detener();
                    }

                }

                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }


}
