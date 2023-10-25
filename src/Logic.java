/*
* В данном классе вся логика ввода-вывода чисел и счета
* В конструкторе добавлен слушатель клавиатуры
*
* Из класса методы вызываются:
*   1) слушателями кнопок в JFrame
*   2) слушателем клавиатуры ( он жмет на кнопки )
*
* Также есть дополнительные методы (расположены снизу)
 */

import static java.awt.event.KeyEvent.VK_BACK_SPACE;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Logic {

  // a-первое число, b-второе число
  // operationTemp, bTemp - хранят последнюю операцию и число b,
  // при повторном нажатии = без ввода числа и оперции используются они
  String operation, a, b, operationTemp, bTemp, sDel0, sOverFlow;
  CalculatorSwing calculator2Swing;


  //-------------------------------------------------------Конструктор класса и слушатель клавиатуры
  public Logic(CalculatorSwing calculator) {
    sDel0 = "Деление на 0 невозможно";
    sOverFlow = "Переполнение";
    this.calculator2Swing = calculator;
    a = "0";
    operation = null;
    b = null;
  //---------------------------------------------Слушатель клавиатуры
    calculator2Swing.frame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        String s = String.valueOf(e.getKeyChar());

        //--------------------Клавиатра: Цифры

        if (s.equals("1")) {
          calculator2Swing.button1.doClick(10);
        } else if (s.equals("2")) {
          calculator2Swing.button2.doClick(10);
        } else if (s.equals("3")) {
          calculator2Swing.button3.doClick(10);
        } else if (s.equals("4")) {
          calculator2Swing.button4.doClick(10);
        } else if (s.equals("5")) {
          calculator2Swing.button5.doClick(10);
        } else if (s.equals("6")) {
          calculator2Swing.button6.doClick(10);
        } else if (s.equals("7")) {
          calculator2Swing.button7.doClick(10);
        } else if (s.equals("8")) {
          calculator2Swing.button8.doClick(10);
        } else if (s.equals("9")) {
          calculator2Swing.button9.doClick(10);
        } else if (s.equals("0")) {
          calculator2Swing.button0.doClick(10);
        }

        //------------------Клавиатура: Операции
        if (s.equals("+")) {
          calculator2Swing.buttonP.doClick(10);
        } else if (s.equals("-")) {
          calculator2Swing.buttonM.doClick(10);
        } else if (s.equals("*")) {
          calculator2Swing.buttonMultiply.doClick(10);
        } else if (s.equals("/")) {
          calculator2Swing.buttonD.doClick(10);
        }

        //-------------------------------Клавиатура: .,
        if (e.getKeyCode() == KeyEvent.VK_COMMA || e.getKeyCode() == KeyEvent.VK_DECIMAL) {
          calculator2Swing.buttonPoint.doClick(10);
        }

        // -------------------------------Клавиатура: ←
        if (e.getKeyCode() == VK_BACK_SPACE) {
          calculator2Swing.buttonBackSp.doClick(10);

        }
        //-------------------------------Клавиатура: Esc

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
          calculator2Swing.buttonC.doClick(10);
        }

        //-------------------------------Клавиатура: Enter
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          calculator2Swing.buttonInput.doClick(10);
        }

        //-------------------------------Клавиатура: Delete
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
          if (b != null) {
            b = null;
            jLabelRefresh();
          } else if (a != null && operation == null) {
            a = "0";
            bTemp = null;
            operationTemp = null;
            jLabelRefresh();
          }
        }
      }
    });

  }

  //-----------------------------------------------------------Нажатие на числа
  void clickNumber(String s) {

    //-------------------------------------------------Первое число
    if (a.length() < 16 && operation == null) {

      if (a.equals("0")) {
        a = s;
        jLabelRefresh();
        clearTemp();

      } else if (!a.equals("0") && bTemp == null) {
        a = a + s;
        jLabelRefresh();

      } else if (!a.equals("0") && bTemp != null) {
        a = s;
        jLabelRefresh();
        clearTemp();
      }

    } else//-------------------------------------------------Второе число

      if (operation != null && b == null) {
        b = s;
        jLabelRefresh();

      } else if (operation != null && b != null && b.length() < 16) {

        if (b.equals("0")) {
          b = s;
        } else {
          b = b + s;
        }
        jLabelRefresh();
      }
    clearTemp();
    calculator2Swing.frame.requestFocus();
  }


  //--------------------------------------------------------Нажатие на операции
  void clickOperations(String s) {
    //Есть только а
    if (operation == null && b == null) {

      //Убрать точку если есть в конце а
      if (a.toCharArray()[a.toCharArray().length - 1] == '.') {
        a = String.valueOf(a.toCharArray(), 0, a.toCharArray().length - 1);
      }

      operation = s;
      jLabelRefresh();

      //Есть а, операция - перезапись операции
    } else if (operation != null && b == null) {
      operation = s;
      jLabelRefresh();

      //Есть 2 числа и операция, нажамается опять операция,
      //подсчет результата  + запись операции
    } else if (operation != null && b != null) {
      countingAB();

      //Если при вызове countingAB() было /0,
      // вызвался метод click_C и запись на экран про /0
      if (calculator2Swing.jLabelTop.getText().equals(sDel0)) {
        return;
      }

      operation = s;
      b = null;
      jLabelRefresh();

    }
    clearTemp();
    calculator2Swing.frame.requestFocus();
  }


  //------------------------------------------------------------Нажатие =, ввод
  void clickScore() {
    //Есть а, операция, b
    if (b != null) {
      countingAB();

      //При вызове countingAB() было /0,
      // вызвался метод click_C+сообщение
      if (calculator2Swing.jLabelTop.getText().equals(sDel0)) {
        return;
      }

      bTemp = b;
      operationTemp = operation;
      b = null;
      operation = null;
      jLabelRefresh();
    }

    //Есть а и операция
    else if (b == null && operation != null) {
      bTemp = a;
      operationTemp = operation;
      switch (operation) {
        case "+":
          a = String.valueOf(new BigDecimal(a).add(new BigDecimal(a)));

          break;
        case "-":
          a = String.valueOf(new BigDecimal(a).subtract(new BigDecimal(a)));
          break;
        case "*":
          a = String.valueOf(new BigDecimal(a).multiply(new BigDecimal(a)));
          break;
        case "/":
          a = String.valueOf(new BigDecimal(a).divide(new BigDecimal(a), 16, RoundingMode.HALF_UP));
          break;
      }
      operation = null;
      jLabelRefresh();
    }

    //Есть а и временные параметры
    else if (b == null && operation == null && bTemp != null) {
      switch (operationTemp) {
        case "+":
          a = String.valueOf(new BigDecimal(a).add(new BigDecimal(bTemp)));
          break;
        case "-":
          a = String.valueOf(new BigDecimal(a).subtract(new BigDecimal(bTemp)));
          break;
        case "*":
          a = String.valueOf(new BigDecimal(a).multiply(new BigDecimal(bTemp)));
          break;
        case "/":
          a = String.valueOf(
              new BigDecimal(a).divide(new BigDecimal(bTemp), 16, RoundingMode.HALF_UP));
          break;
      }
      jLabelRefresh();
    }

    calculator2Swing.frame.requestFocus();
  }

  //--------------------------------------------------------------------Click C
  void clickC() {
    clearTemp();
    a = "0";
    b = null;
    operation = null;
    jLabelRefresh();

    //Фокус для клавиатуры ПК
    calculator2Swing.frame.requestFocus();
  }


  //--------------------------------------------------------------------Click_←
  void clickDel() {
    if (b != null) {//есть а + операция + b,
      // редактируем число b
      delete1Symbol();
      jLabelRefresh();

    } else if (operation != null) {//есть а и операция,
      // удалить операцию
      delete1Symbol();
      clearTemp();
      jLabelRefresh();

    } else if (a != null && operationTemp != null) {//а результат
                                  //подсчета, при попытке удалить
                                  // символ ничего не делать

    } else if (a != null) {//есть только а,
      // редактировать а
      delete1Symbol();
      jLabelRefresh();
    }

    calculator2Swing.frame.requestFocus();
  }


  //--------------------------------------------------------------------Click_.
  void clickPoint() {

    if (b != null && b.length() <= 15) {
      if (isPoint(b)) {
        //Есть точка уже, ничего не делать
      } else {
        b = b + ".";
        jLabelRefresh();
      }

    } else if (b == null && operation != null) {
      b = "0.";
      clearTemp();
      jLabelRefresh();

      //Есть только а
    } else if (a.length() <= 15 && bTemp == null) {
      if (isPoint(a)) {
        //Есть точка уже, ничего не делать
      } else {
        a = a + ".";
        jLabelRefresh();
      }

    } else if (a != null && bTemp != null) {
      clearTemp();
      a = "0.";
      jLabelRefresh();
    }

    calculator2Swing.frame.requestFocus();
  }


//-------------------------------------------------------------------------------------
//-------------------------------------Вспомогатедьные методы--------------------------
//-------------------------------------------------------------------------------------
  void countingAB() {
    switch (operation) {
      case "+":
        a = String.valueOf(new BigDecimal(a).add(new BigDecimal(b)));
        break;
      case "-":
        a = String.valueOf(new BigDecimal(a).subtract(new BigDecimal(b)));
        break;
      case "/":
        if (b.equals(String.valueOf(0))) {
          clickC();
          calculator2Swing.jLabelTop.setText(sDel0);
          break;
        }
        BigDecimal bigDecimal = new BigDecimal(a).divide(new BigDecimal(b), 16,
            RoundingMode.HALF_UP);
        a = bigDecimal.toString();
        System.out.println(a);
        break;
      case "*":
        a = String.valueOf(new BigDecimal(a).multiply(new BigDecimal(b)));
        break;

    }
  }


  //Удаление временных переменных-------------------
  void clearTemp() {
    bTemp = null;
    operationTemp = null;
  }


  //Проверка наличия точки--------------------------
  boolean isPoint(String s) {
    boolean b = false;
    for (char ch : s.toCharArray()) {
      if (ch == '.') {
        b = true;
        break;
      }
    }

    return b;
  }


  //Перерисовка JLabel-------------------------------
  void jLabelRefresh() {
    //Есть a + b + операция----------
    if (b != null) {
      a = methodExp(a);
      calculator2Swing.jLabelTop.setText(a + " " + operation);

      //Был скрытый 0 в b, его цвет совпадал с фоном
      //теперь отобразится текст как в верхнем JLabel
      calculator2Swing.jLabelBottom.setForeground(Color.BLACK);
      calculator2Swing.jLabelBottom.setText(b);


      //Есть а + операция--------------
    } else if (operation != null) {
      a = methodExp(a);
      calculator2Swing.jLabelTop.setText(a + " " + operation);

      // Установка "0" в JLabel_2, цвет текста совпадает
      // с фоном чтобы не изменялась высота(0 не видно)
      calculator2Swing.jLabelBottom.setForeground(new Color(200, 218, 225, 255));
      calculator2Swing.jLabelBottom.setText("0");
    }

    //Есть только а------------------
    else {
      //Удалить .0 (.000 и т.д. и просто 000 тоже) в результате подсчета
      //Если в а есть '.' взять его индекс и проверить
      // на true все последующие символы, если все '0',
      // то взять символы до этого индекса

      if (bTemp != null) {  //Перед этим был подсчет а
                            //не просто ввели a
        char[] aChar = a.toCharArray();
        int i = isAPoint0(aChar);// )))
        if (i == -1) {
          //Не меняем а
          //удалить все .000
        } else {
          a = String.valueOf(aChar, 0, i + 1);
        }
      }

      a = methodExp(a);

      if (new BigDecimal(a).abs().compareTo(new BigDecimal("10000000000E99")) == 1) {
        clickC();
        calculator2Swing.jLabelTop.setText(sOverFlow);
        return;
      }
      calculator2Swing.jLabelTop.setText(a);

      //Установка "0" в b и цвет текста совпадает
      // с фоном чтобы не изменялась высота
      calculator2Swing.jLabelBottom.setForeground(new Color(200, 218, 225, 255));
      calculator2Swing.jLabelBottom.setText("0");
    }

  }

  //Удаление одного символа у числа------------------
  //метод сам определяет у какого числа удалять------
  void delete1Symbol() {

    char[] sArray;
    //--Редактирование b--
    if (b != null) {
      if (b.length() == 1) {
        b = null;
      } else {
        sArray = b.toCharArray();
        b = String.valueOf(sArray, 0, sArray.length - 1);
      }

      //--Редактирование операции--
    } else if (operation != null) {
      operation = null;

      //--Редактирование a--
    } else if (a.length() == 1) {
      a = "0";
    } else {
      sArray = a.toCharArray();
      a = String.valueOf(sArray, 0, sArray.length - 1);
    }
  }

  //Проверка а на наличие в конце результата .0
  //и ххх.хх000
  //Аналог (BigDecimal) e.stripTrailingZeros()
  int isAPoint0(char[] chars) {

    //Если число а с E, то возврат -1,
    //чтобы число не менялось(иначе удаляется 0 у Е20 и т.д.
    if (a.indexOf('E') != -1) {
      return -1;
    }

    int aFlag = a.indexOf('.');
    int flagTemp = aFlag;

    if (aFlag == -1) {
      return aFlag;

      //Есть точка в а---------------
    } else {
      for (int i = aFlag + 1; i < chars.length; i++) {
        if (chars[i] != '0') {
          aFlag = i;
        } else {
          //Перебираем дальше в цикле
        }
      }

      if (flagTemp == aFlag) {
        return aFlag - 1;
      } else {
        return aFlag;
      }
    }
  }

  //Метод переписывает а в +-E00(в експоненциальное число)
  // с учетом кол-ва символов в а( >< 16)
  private String methodExp(String s) {

    //Если a меньше 17 символов
    // вывести как есть
    if (s.length() < 17) {

      //если а с E, перевести
      // его в нужный формат с E
      if (s.indexOf('E') != -1) {
        return (new DecimalFormat("0000000000E00").format(new BigDecimal(s)));
      } else {
        return s;
      }

    } else if (s.length() > 16) {

      //Если а >16 символов 2 случая:

      //1)-----
      //Если '.' нету и >16 символов
      //ограничиваем 15 символами + E
      if (s.indexOf('.') == -1) {
        return (new DecimalFormat("0000000000E00").format(new BigDecimal(s)));

        //в а>16 символов, есть '.'
        // в первых 15 регистрах
      } else if (s.indexOf('.') < 16) {

        //Если a экспоненц-е,
        // перевести его в правильный формат E
        if (s.indexOf('E') != -1) {
          return (new DecimalFormat("0000000000E00").format(new BigDecimal(s)));

          //Есть . и а не экспон-ое,
          //вывести 16 символов первых
        } else {
          return (new String(s.toCharArray(), 0, 17));
        }

      }

      //2)------
      //в а>16 символов, есть '.' не
      // в первых 15 регистрах
      else if (s.indexOf('.') > 15) {
        return (new DecimalFormat("0000000000E00").format(new BigDecimal(s)));
      }

    }
    return "";
  }

}
