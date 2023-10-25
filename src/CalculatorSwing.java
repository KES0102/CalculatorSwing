/*
* Данный класс основной, здесь же main()
* собирает все компоненты в одном JFrame
* обращаясь к MyButtons ( кнопки+слушатели )
* и MyConstraints ( параметры расположения кнопок )
* и передает ссылку на свой экземпляр
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CalculatorSwing {

  JFrame frame;
  MyButtons myButtons;

  //jLabelTop содержит первое число и операцию
  //jLabelBottom содержит второе число
  JLabel jLabelTop, jLabelBottom;

  JButton button1, button2, button3, button4, button5, button6,
      button7, button8, button9, button0, buttonPoint,
      buttonInput, buttonP, buttonD, buttonMultiply,
      buttonM, buttonBackSp, buttonC;
  MyConstraints myConstraints;

  GridBagLayout gbl;


  //---------------------------------------------------------------------Конструктор
  public CalculatorSwing() {
    try {
      UIManager.setLookAndFeel(
          UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
    }

    //Make sure we have nice window decorations.
    JFrame.setDefaultLookAndFeelDecorated(true);
    //JDialog.setDefaultLookAndFeelDecorated(true);
    frame = new JFrame();
    frame.getContentPane().setBackground(new Color(200, 218, 225, 255));
    myConstraints = new MyConstraints();

    //----------------------------------jLabelTop
    jLabelTop = new JLabel("0");
    jLabelTop.setFont(new Font("TimesRoman", Font.ITALIC, 20));

    //----------------------------------jLabelBottom
    jLabelBottom = new JLabel("0");
    jLabelBottom.setForeground(new Color(200, 218, 225, 255));
    jLabelBottom.setFont(new Font("TimesRoman", Font.ITALIC, 15));

    myButtons = new MyButtons(this);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    gbl = new GridBagLayout();

    frame.setLayout(gbl);
    frame.setMinimumSize(new Dimension((screenSize.width + 100) / 7,
            (screenSize.height + 100) / 3));

    frame.setTitle("Калькулятор КЕС");

    frame.setBounds(screenSize.width / 3, screenSize.height / 4,
        screenSize.width / 6, screenSize.height / 2);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setIconImage(new ImageIcon(
        CalculatorSwing.class.getResource("images/cal_1.png")).getImage());

    setButtons();
    setPanelAll();

    frame.setVisible(true);
    frame.setFocusable(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new CalculatorSwing();

      }
    });


  }

//--------------------------------------------------------------------------setButtons()
  void setButtons() {
    button1 = myButtons.getButton1();
    button2 = myButtons.getButton2();
    button3 = myButtons.getButton3();

    button4 = myButtons.getButton4();
    button5 = myButtons.getButton5();
    button6 = myButtons.getButton6();

    button7 = myButtons.getButton7();
    button8 = myButtons.getButton8();
    button9 = myButtons.getButton9();
    button0 = myButtons.getButton0();
    buttonPoint = myButtons.getButtonPoint();
    buttonInput = myButtons.getButtonInput();

    buttonC = myButtons.getButtonC();
    buttonBackSp = myButtons.getButtonBackSp();
    buttonP = myButtons.getButtonPlus();

    buttonM = myButtons.getButtonMinus();
    buttonMultiply = myButtons.getButtonMultiply();
    buttonD = myButtons.getButtonDivide();
  }

  //--------------------------------------------------------------------------setPanelAll()
  //Установка параметров для компонентов и установка их во frame
  void setPanelAll() {
    //----------------------------------------------------------------Стока 1
    gbl.setConstraints(jLabelTop, myConstraints.getGbcJLabel1());

    //--------------------------------------------------Строка 2(JlabelBottom)
    gbl.setConstraints(jLabelBottom, myConstraints.getGbcJLabel2());

    //----------------------------------------------------------------Строка 3
    gbl.setConstraints(buttonC, myConstraints.getGbcC());
    gbl.setConstraints(buttonBackSp, myConstraints.getGbcBackSp());
    gbl.setConstraints(buttonP, myConstraints.getGbcPlus());

    //----------------------------------------------------------------Строка 4
    gbl.setConstraints(button7, myConstraints.getGbc7());
    gbl.setConstraints(button8, myConstraints.getGbc8());
    gbl.setConstraints(button9, myConstraints.getGbc9());
    gbl.setConstraints(buttonM, myConstraints.getGbcMinus());

    //----------------------------------------------------------------Строка 5

    gbl.setConstraints(button4, myConstraints.getGbc4());
    gbl.setConstraints(button5, myConstraints.getGbc5());
    gbl.setConstraints(button6, myConstraints.getGbc6());
    gbl.setConstraints(buttonMultiply, myConstraints.getGbcMultiply());
    //--------------------------------------------------------Строка 6(1,2,3,/)
    gbl.setConstraints(button1, myConstraints.getGbc1());
    gbl.setConstraints(button2, myConstraints.getGbc2());
    gbl.setConstraints(button3, myConstraints.getGbc3());
    gbl.setConstraints(buttonD, myConstraints.getGbcDivide());
    //----------------------------------------------------------------Строка 7
    gbl.setConstraints(button0, myConstraints.getGbc0());
    gbl.setConstraints(buttonPoint, myConstraints.getGbcPoint());
    gbl.setConstraints(buttonInput, myConstraints.getGbcInput());


    //----------------------------------------Установка содержимого по строчно
    frame.add(jLabelTop);
    frame.add(jLabelBottom);

    frame.add(buttonC);
    frame.add(buttonBackSp);
    frame.add(buttonP);

    frame.add(button1);
    frame.add(button2);
    frame.add(button3);
    frame.add(buttonM);

    frame.add(button4);
    frame.add(button5);
    frame.add(button6);
    frame.add(buttonMultiply);

    frame.add(button7);
    frame.add(button8);
    frame.add(button9);
    frame.add(buttonD);

    frame.add(button0);
    frame.add(buttonPoint);
    frame.add(buttonInput);
  }

}


