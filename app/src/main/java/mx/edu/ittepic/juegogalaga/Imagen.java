package mx.edu.ittepic.juegogalaga;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen {
    private Bitmap icono, nave;
    private float x, y;
    private boolean visible = true;
    int desplazamiento, sube, balamarciano;
    float pe;
    CountDownTimer timer, subir, bajarbala;

    public Imagen(int resource, float _x, float _y, final Lienzo l) {
        icono = BitmapFactory.decodeResource(l.getResources(), resource);
        x = _x;
        y = _y;

        timer=new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y+=desplazamiento;
                if(y>=l.getHeight())
                {
                    y=-100;
                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        subir=new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y-=sube;
                if(y<=0)
                {
                    y=2200;

                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
    }


    public void pintar(Canvas c, Paint p) {
        if (visible) {
            c.drawBitmap(icono, x, y, p);
        }
    }

    public boolean estaEnArea(float xp, float yp) {
        float x2, y2;
        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();

        if ((xp >= x && xp <= x2) && (yp >= y && yp <= y2)) {
            return true;
        }
        return false;
    }

    public void desplaza(float xp) {
        x = xp - (icono.getWidth() / 2);
    }

    public void desplazay(float yp) {

        y = yp - (icono.getHeight() / 2);

    }

    public void hacerVisible(boolean v) {
        visible = v;
    }

    public boolean colision(Imagen objetoB) {
        float x2 = x + icono.getWidth();
        float y2 = y + icono.getHeight();


        if( objetoB.estaEnArea(x2,y))
        {
            //Caso 2
            return  true;

        }
        if (objetoB.estaEnArea(x, y)) {
            //Caso 1
            return true;

        }

        if( objetoB.estaEnArea(x2,y2))
        {
            //Caso 3
            return  true;

        }
        if( objetoB.estaEnArea(x,y2))
        {
            //Caso 4
            return  true;

        }
        return false;
    }
    public void mover(int desplaza)
    {
        desplazamiento= desplaza;
        timer.start();
    }
    public void arriba(int desplaza) {
        sube = desplaza;
        subir.start();
    }

    public void abajo(int desplaza, final  Imagen n, final Lienzo l) {
        balamarciano = desplaza;
        bajarbala=new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                y+=balamarciano;
                if(y>=l.getHeight())
                {
                    y=n.getY()+200;

                }
                l.invalidate();
            }

            @Override
            public void onFinish() {
                start();
            }
        };
        bajarbala.start();
    }


    public void detener()
    {
        timer.onFinish();
        subir.onFinish();
    }

    public float getY ()
    {
        return y;
    }

    public float getX ()
    {
        return x;
    }


}