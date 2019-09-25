package org.terminal.nio.win;

import com.sun.jna.Library;

interface Msvcrt extends Library {
      int _kbhit();

      int _getwch();

      int getwchar();
}