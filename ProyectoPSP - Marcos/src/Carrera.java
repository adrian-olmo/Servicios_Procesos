import java.io.IOException;
import java.awt.*;
import java.awt.event.*;

public class Carrera {

    private Robot robot;


    private static final int SPEED = 300;

    private void execute(int letter[]) {
        try {
            robot = new Robot();

        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < letter.length; i++) {
            robot.delay(SPEED);
            robot.keyPress(letter[i]);
            robot.keyRelease(letter[i]);
        }
    }

    public static void main(String args[]) throws AWTException {
        PanelCarrera carrera = new PanelCarrera();
        System.out.println("----------CLASIFICACION-------------");

        Carrera t = new Carrera();
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(1 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        int[] executeNotepad =
                {KeyEvent.VK_WINDOWS, KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_T, KeyEvent.VK_ENTER};
        t.execute(executeNotepad);
        int[] messageToPrint =
                {KeyEvent.VK_E, KeyEvent.VK_S, KeyEvent.VK_P, KeyEvent.VK_E, KeyEvent.VK_R, KeyEvent.VK_A };
        t.execute(messageToPrint);
        int[] closeIt =
                {KeyEvent.VK_ALT, KeyEvent.VK_SPACE, KeyEvent.VK_N};
        t.execute(closeIt);
        int[] executeChrome =
                {KeyEvent.VK_WINDOWS, KeyEvent.VK_C, KeyEvent.VK_H, KeyEvent.VK_ENTER};
        t.execute(executeChrome);
        int[] executeYoutube =
                {KeyEvent.VK_Y, KeyEvent.VK_O, KeyEvent.VK_U, KeyEvent.VK_ENTER};
        t.execute(executeYoutube);


        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            System.out.println(e);

        }
        //instanciamos la clase Robot

        Robot robot3 = new Robot();


        //cambia la posición en pantalla del puntero a las coordenadas
        //X=300 e Y=600.
        robot3.mouseMove(651, 129);

        robot3.mousePress(InputEvent.BUTTON1_MASK);
        robot3.mouseRelease(InputEvent.BUTTON1_MASK);

        int[] messageToPrint2 =
                {KeyEvent.VK_B, KeyEvent.VK_S, KeyEvent.VK_O, KeyEvent.VK_SPACE, KeyEvent.VK_F, KeyEvent.VK_1, KeyEvent.VK_ENTER};
        t.execute(messageToPrint2);
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        robot3.mouseMove(592, 309);
        robot3.mousePress(InputEvent.BUTTON1_MASK);
        robot3.mouseRelease(InputEvent.BUTTON1_MASK);

        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(4 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        robot3.mouseMove(1802, 18);
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        robot3.mousePress(InputEvent.BUTTON1_MASK);
        robot3.mouseRelease(InputEvent.BUTTON1_MASK);

        robot3.mouseMove(748, 869);
        try {
            //Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(2 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
        robot3.mousePress(InputEvent.BUTTON1_MASK);
        robot3.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}

















