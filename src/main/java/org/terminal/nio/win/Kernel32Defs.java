package org.terminal.nio.win;

import com.sun.jna.Native;

class Kernel32Defs {
      static final int STD_INPUT_HANDLE = -10;
      // static final long INVALID_HANDLE_VALUE = (Pointer.SIZE == 8) ? -1 : 0xFFFFFFFFL;
      static final long INVALID_HANDLE_VALUE = (Native.POINTER_SIZE == 8) ? -1 : 0xFFFFFFFFL;
      static final int ENABLE_PROCESSED_INPUT = 0x0001;
      static final int ENABLE_LINE_INPUT = 0x0002;
      static final int ENABLE_ECHO_INPUT = 0x0004;
      static final int ENABLE_WINDOW_INPUT = 0x0008;
}