package edu.wsu;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public abstract class ClockPane extends Pane {
  /** Set a new hour */
  public abstract void setHour(int hour);
  public abstract void setMinute(int minute);

  /** Set a new second */
  public abstract void setSecond(int second);

  /* Set the current time for the clock */
  public abstract void setCurrentTime();

}
