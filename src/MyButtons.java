/*
* В конструкторе создаются все кнопки
* и реализуются слушатели
*
* дальше get()-ры возвращают каждую кнопку
* при вызове из основного класса ( CalculatorSwing )
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyButtons {

  Logic logic;
  JButton button1, button2, button3, button4, button5, button6,
      button7, button8, button9,
      button0, buttonPoint, buttonInput, buttonP, buttonD, buttonMultiply,
      buttonM, buttonBackSp, ButtonC;

  public MyButtons(CalculatorSwing calculator2Swing) {
    logic = new Logic(calculator2Swing);

  //-----------------------------------------------------------------Button1
    button1 = new JButton("1");
    button1.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button1.getText());
      }
    });

  //-----------------------------------------------------------------Button2
    button2 = new JButton("2");
    button2.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button2.getText());
      }
    });

  //-----------------------------------------------------------------Button3
    button3 = new JButton("3");
    button3.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button3.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button3.getText());
      }
    });

  //-----------------------------------------------------------------Button4
    button4 = new JButton("4");
    button4.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button4.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button4.getText());
      }
    });

  //-----------------------------------------------------------------Button5
    button5 = new JButton("5");
    button5.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button5.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button5.getText());
      }
    });

  //-----------------------------------------------------------------Button6
    button6 = new JButton("6");
    button6.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button6.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button6.getText());
      }
    });

  //-----------------------------------------------------------------Button7
    button7 = new JButton("7");
    button7.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button7.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button7.getText());
      }
    });

  //-----------------------------------------------------------------Button8
    button8 = new JButton("8");
    button8.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button8.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button8.getText());
      }
    });

  //-----------------------------------------------------------------Button9
    button9 = new JButton("9");
    button9.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button9.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button9.getText());
      }
    });

  //----------------------------------------------------------------Button_0
    button0 = new JButton("0");
    button0.setFont(new Font("TimesRoman", Font.BOLD, 50));

    button0.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickNumber(button0.getText());
      }
    });

  //----------------------------------------------------------------Button_.
    buttonPoint = new JButton(".");
    buttonPoint.setFont(new Font("TimesRoman", Font.BOLD, 25));

    buttonPoint.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickPoint();
      }
    });

  //---------------------------------------------------------------Button_=
    buttonInput = new JButton("=");
    buttonInput.setFont(new Font("TimesRoman", Font.PLAIN, 50));

    buttonInput.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickScore();
      }
    });

  //---------------------------------------------------------------Button_+
    buttonP = new JButton("+");
    buttonP.setFont(new Font("TimesRoman", Font.PLAIN, 50));

    buttonP.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickOperations(buttonP.getText());
      }
    });

  //---------------------------------------------------------------Button_/
    buttonD = new JButton("/");
    buttonD.setFont(new Font("TimesRoman", Font.PLAIN, 40));

    buttonD.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickOperations(buttonD.getText());
      }
    });

  //---------------------------------------------------------------Button_*
    buttonMultiply = new JButton("*");
    buttonMultiply.setFont(new Font("TimesRoman", Font.BOLD, 20));

    buttonMultiply.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickOperations(buttonMultiply.getText());
      }
    });

  //---------------------------------------------------------------Button_-
    buttonM = new JButton("-");
    buttonM.setFont(new Font("TimesRoman", Font.PLAIN, 40));

    buttonM.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickOperations(buttonM.getText());
      }
    });

  //---------------------------------------------------------------Button_←
    buttonBackSp = new JButton("←");
    buttonBackSp.setFont(new Font("TimesRoman", Font.PLAIN, 40));

    buttonBackSp.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickDel();
      }
    });

  //---------------------------------------------------------------Button_C
    ButtonC = new JButton("C");
    ButtonC.setFont(new Font("TimesRoman", Font.PLAIN, 40));

    ButtonC.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logic.clickC();
      }
    });
  }

  //----------------------------------------------------------return Buttons
  public JButton getButton1() {
    return button1;
  }

  public JButton getButton2() {
    return button2;
  }

  public JButton getButton3() {
    return button3;
  }

  public JButton getButton4() {
    return button4;
  }

  public JButton getButton5() {
    return button5;
  }

  public JButton getButton6() {
    return button6;
  }

  public JButton getButton7() {
    return button7;
  }

  public JButton getButton8() {
    return button8;
  }

  public JButton getButton9() {
    return button9;
  }

  public JButton getButton0() {
    return button0;
  }

  public JButton getButtonPoint() {
    return buttonPoint;
  }

  public JButton getButtonInput() {
    return buttonInput;
  }

  public JButton getButtonPlus() {
    return buttonP;
  }

  public JButton getButtonDivide() {
    return buttonD;
  }

  public JButton getButtonMultiply() {
    return buttonMultiply;
  }

  public JButton getButtonMinus() {
    return buttonM;
  }

  public JButton getButtonBackSp() {
    return buttonBackSp;
  }

  public JButton getButtonC() {
    return ButtonC;
  }

}
