package edu.wsu;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.text.Font;

public class DigitalClockPane extends ClockPane{

    Label time = new Label();
    public DigitalClockPane()  {
        time.layoutXProperty().bind(widthProperty().subtract(time.widthProperty()).divide(2));
        time.layoutYProperty().bind(heightProperty().subtract(time.heightProperty()).divide(2));
        getChildren().add(time);
        time.setAlignment(Pos.CENTER);
        setCurrentTime();
    }

    private int hour;
    private int minute;
    private int second;
    private double widthScale = 0.17;
    private double heightScale =0.24;

    @Override
    public void setHour(int hour) {
        this.hour = hour;
        initialize();
    }

    @Override
    public void setMinute(int minute) {
        this.minute = minute;
        initialize();
    }

    @Override
    public void setSecond(int second) {
        this.second = second;
        initialize();
    }

    @Override
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        initialize();
    }

    public void initialize(){
        time.setText(new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()));
    }

    public void resizeText()
    {
        if(getWidth()*widthScale>getHeight()*heightScale)
            time.setFont(Font.font("Arial",getHeight()*heightScale));
        else
            time.setFont(Font.font("Arial",getWidth()*widthScale));
    }
}
