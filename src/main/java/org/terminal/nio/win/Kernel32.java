package org.terminal.nio.win;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

interface Kernel32 extends Library {
      int GetConsoleMode(Pointer hConsoleHandle, IntByReference lpMode);

      int SetConsoleMode(Pointer hConsoleHandle, int dwMode);

      Pointer GetStdHandle(int nStdHandle);
}