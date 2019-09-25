package org.terminal.nio.unix;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class Termios extends Structure { // termios.h
      public int c_iflag;
      public int c_oflag;
      public int c_cflag;
      public int c_lflag;
      public byte c_line;
      public byte[] filler = new byte[64]; // actual length is platform dependent

      @Override
      protected List<String> getFieldOrder() {
         return Arrays.asList("c_iflag", "c_oflag", "c_cflag", "c_lflag", "c_line", "filler");
      }

      Termios() {
      }

      Termios(Termios t) {
         c_iflag = t.c_iflag;
         c_oflag = t.c_oflag;
         c_cflag = t.c_cflag;
         c_lflag = t.c_lflag;
         c_line = t.c_line;
         filler = t.filler.clone();
      }
   }